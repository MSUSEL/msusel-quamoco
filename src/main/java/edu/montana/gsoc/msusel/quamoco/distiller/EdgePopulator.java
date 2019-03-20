/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.quamoco.distiller;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.WeightedRankedEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MeasureRanking;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.WeightedSumMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.func.Function;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearDecreasingFunction;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearIncreasingFunction;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.FactorRanking;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.NegativeLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;

/**
 * Connects the nodes in the Quamoco Processing graph.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class EdgePopulator implements GraphModifier {

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyGraph(final DistillerData data, final MutableNetwork<Node, Edge> graph) {
//        handleFactors(data, graph);
        handleMeasures(data, graph);
        handleProviders(data, graph);
        handleEvals(data, graph);
//        handleData(data, graph);
//        handleUnions(data, graph);
    }

    /**
     * Adds an edge between the two provided nodes in the provided graph.
     *
     * @param graph Graph in which to add the edge.
     * @param edge  the edge.
     */
    @VisibleForTesting
    void addEdge(final MutableNetwork<Node, Edge> graph, Edge edge) {
        if (edge != null) {
            try {
                if (graph.edgesConnecting(edge.getSource(), edge.getDest()).isEmpty())
                    graph.addEdge(edge.getSource(), edge.getDest(), edge);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    /**
     * Using the provided DistillerData object this method retrieves a FactorNode
     * or MeasureNode associated with a Factor or Measure entity, respectively,
     * with the given unique identifier.
     *
     * @param data    DistillerData used to search for the dest node
     * @param element Identifier of the associated Measure or Factor associated with
     *                the node to retrieve.
     * @return The node associated with the entity whose Identifier has been
     * given, if the identifier is null or is neither a Factor nor
     * Measure entity, then null will be returned.
     */
    @VisibleForTesting
    Node getDestNode(final DistillerData data, QMElement element) {
        Node dest = null;

        if (element instanceof Factor) {
            dest = data.getFactor((Factor) element);
        } else if (element instanceof Measure) {
            dest = data.getMeasure((Measure) element);
        }

        return dest;
    }

    /**
     * Handles processing the relationships involving FindingsUnionNodes.
     *
     * @param data  DistillerData
     * @param graph Graph in which to populate edges
     */
    @VisibleForTesting
    void handleUnions(final DistillerData data, final MutableNetwork<Node, Edge> graph) {
        for (final QMElement key : data.getUnions()) {
            if (key instanceof MeasurementMethod) {
                final MeasurementMethod method = (MeasurementMethod) key;
                final Node union = data.getUnion(method);

                if (method.getDetermines() != null) {
                    Node dest = getDestNode(data, method.getDetermines());
                    //if (dest != null)
                    //addEdge(graph, union, dest, null);
                }

                for (final QMElement dataKey : data.getValues()) {
                    if (dataKey instanceof MeasurementMethod) {
                        final Node src = data.getValue((MeasurementMethod) dataKey);
                        if (src instanceof FindingNode) // FIXME verify this is
                        // correct
                        {
                            //addEdge(graph, src, union, null);
                        }
                    }
                }
            }
        }
    }

    /**
     * Handles the relationships involving MeasurementMethod associated Value
     * and Finding nodes
     *
     * @param data  DistillerData
     * @param graph Graph into which edges will be populated.
     */
    @VisibleForTesting
    void handleData(final DistillerData data, final MutableNetwork<Node, Edge> graph) {
        for (final QMElement key : data.getValues()) {
            if (key instanceof MeasurementMethod) {
                final MeasurementMethod method = (MeasurementMethod) key;
                final Node src = data.getValue(method);
                if (method.getDetermines() != null) {
                    Node dest = getDestNode(data, method.getDetermines());
//                    if (dest != null)
//                        addEdge(graph, src, dest, null);
                }
            }
        }
    }

    /**
     * Handles the creation of edges involving factors
     *
     * @param data  DistillerData
     * @param graph Graph into which edges will be populated.
     */
    @VisibleForTesting
    void handleFactors(final DistillerData data, final MutableNetwork<Node, Edge> graph) {
        for (final QMElement key : data.getFactors()) {
            if (key instanceof Factor) {
                final Factor factor = (Factor) key;
//                for (final Impact inf : factor.getInfluences().values()) {
//                    addEdge(graph, EdgeFactory.getInstance().createEdge(factor, inf.getTarget(), data));
//                }
                if (factor.getRefines() != null) {
                    addEdge(graph, EdgeFactory.getInstance().createEdge(factor, factor.getRefines(), data));
                }
            }
        }
    }

    /**
     * Handles the creation of edges involving measures
     *
     * @param data  DistillerData
     * @param graph Graph into which edges will be populated.
     */
    @VisibleForTesting
    void handleMeasures(final DistillerData data, final MutableNetwork<Node, Edge> graph) {
        for (final QMElement key : data.getMeasures()) {
            if (key instanceof Measure) {
                final Measure measure = (Measure) key;
                if (measure.getRefines() != null) {
                    addEdge(graph, EdgeFactory.getInstance().createEdge(measure, measure.getRefines(), data));
                }
                measure.getMeasures().forEach((f) -> {
                    addEdge(graph, EdgeFactory.getInstance().createEdge(measure, f, data));
                });
            }
        }
    }

    @VisibleForTesting
    void handleProviders(final DistillerData data, final MutableNetwork<Node, Edge> graph) {
        for (final QMElement key : data.getManager().getAllMeasurementMethods()) {
            if (key instanceof MeasurementMethod) {
                MeasurementMethod method = (MeasurementMethod) key;

                if (method.getDetermines() != null) {
                    addEdge(graph, EdgeFactory.getInstance().createEdge(method, method.getDetermines(), data));
                }
            }
        }
    }

    void handleEvals(final DistillerData data, final MutableNetwork<Node, Edge> graph) {
        for (final QMElement key : data.getEvaluations()) {
            if (key instanceof SingleMeasureEvaluation) {
                SingleMeasureEvaluation eval = (SingleMeasureEvaluation) key;
                Measure m = eval.getBasedOn();
                Factor f = eval.getEvaluates();
                WeightedRankedEdge edge;
                if (graph.edgesConnecting(data.getMeasure(m), data.getFactor(f)).isEmpty())
                    edge = (WeightedRankedEdge) EdgeFactory.getInstance().createEdge(m, f, data);
                else
                    edge = (WeightedRankedEdge) graph.edgesConnecting(data.getMeasure(m), data.getFactor(f)).toArray(new Edge[0])[0];
                edge.setRank(1);

                if (eval.getFunction() != null) {
                    edge.setMaxPoints(eval.getMaximumPoints());
                    edge.setUsesLinearDist(true);
                    Function fun = eval.getFunction();
                    if (fun instanceof LinearIncreasingFunction) {
                        edge.setLowerBound(((LinearIncreasingFunction) fun).getLowerBound());
                        edge.setUpperBound(((LinearIncreasingFunction) fun).getUpperBound());
                        edge.setDist(new PositiveLinearDistribution());
                    } else {
                        edge.setLowerBound(((LinearDecreasingFunction) fun).getLowerBound());
                        edge.setUpperBound(((LinearDecreasingFunction) fun).getUpperBound());
                        edge.setDist(new NegativeLinearDistribution());
                    }
                }

                if (graph.edgesConnecting(data.getMeasure(m), data.getFactor(f)).isEmpty())
                    addEdge(graph, edge);
            } else if (key instanceof WeightedSumFactorAggregation) {
                WeightedSumFactorAggregation eval = (WeightedSumFactorAggregation) key;
                for (FactorRanking r : eval.getRankings()) {
                    Factor src = r.getFactor();
                    Factor dest = eval.getEvaluates();

                    WeightedRankedEdge edge;
                    if (graph.edgesConnecting(data.getFactor(src), data.getFactor(dest)).isEmpty())
                        edge = (WeightedRankedEdge) EdgeFactory.getInstance().createEdge(src, dest, data);
                    else
                        edge = (WeightedRankedEdge) graph.edgesConnecting(data.getFactor(src), data.getFactor(dest)).toArray(new Edge[0])[0];
                    edge.setRank(r.getRank());
                    edge.setWeight(r.getWeight());
                    edge.setMaxPoints(eval.getMaximumPoints());

                    if (graph.edgesConnecting(data.getFactor(src), data.getFactor(dest)).isEmpty() && edge.getRank() > 0)
                        addEdge(graph, edge);
                    else if (!graph.edgesConnecting(data.getFactor(src), data.getFactor(dest)).isEmpty() && edge.getRank() <= 0)
                        graph.removeEdge(edge);
                }
            } else if (key instanceof WeightedSumMultiMeasureEvaluation) {
                WeightedSumMultiMeasureEvaluation eval = (WeightedSumMultiMeasureEvaluation) key;
                for (MeasureRanking r : eval.getRankings()) {
                    Measure src = r.getBasedOn();
                    Factor dest = eval.getEvaluates();

                    if (src == null || dest == null)
                        return;

                    WeightedRankedEdge edge;
                    if (graph.edgesConnecting(data.getMeasure(src), data.getFactor(dest)).isEmpty())
                        edge = (WeightedRankedEdge) EdgeFactory.getInstance().createEdge(src, dest, data);
                    else
                        edge = (WeightedRankedEdge) graph.edgesConnecting(data.getMeasure(src), data.getFactor(dest)).toArray(new Edge[0])[0];
                    edge.setRank(r.getRank());
                    edge.setWeight(r.getWeight());
                    if (r.getFunction() != null) {
                        edge.setMaxPoints(eval.getMaximumPoints());
                        edge.setUsesLinearDist(true);
                        Function f = r.getFunction();
                        if (f instanceof LinearIncreasingFunction) {
                            edge.setLowerBound(((LinearIncreasingFunction) f).getLowerBound());
                            edge.setUpperBound(((LinearIncreasingFunction) f).getUpperBound());
                            edge.setDist(new PositiveLinearDistribution());
                        } else {
                            edge.setLowerBound(((LinearDecreasingFunction) f).getLowerBound());
                            edge.setUpperBound(((LinearDecreasingFunction) f).getUpperBound());
                            edge.setDist(new NegativeLinearDistribution());
                        }
                    }

                    if (graph.edgesConnecting(data.getMeasure(src), data.getFactor(dest)).isEmpty() && edge.getRank() > 0)
                        addEdge(graph, edge);
                    else if (!graph.edgesConnecting(data.getMeasure(src), data.getFactor(dest)).isEmpty() && edge.getRank() <= 0)
                        graph.removeEdge(edge);
                }
            }
        }
    }
}
