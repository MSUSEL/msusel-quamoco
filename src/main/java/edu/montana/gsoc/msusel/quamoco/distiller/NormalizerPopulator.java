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
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.RankedEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.Ranking;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MeasureRanking;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.WeightedSumMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.FactorRanking;
import edu.montana.gsoc.msusel.quamoco.processor.NormalizerFactory;

/**
 * Class to populate the model processing graph edges with normalizers
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class NormalizerPopulator implements GraphModifier {

    /**
     * Data storage for the distillation process
     */
    DistillerData data;
    /**
     * Distilled quality model processing graph
     */
    MutableNetwork<Node, Edge> graph;

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyGraph(DistillerData data, MutableNetwork<Node, Edge> graph) {
        this.data = data;
        this.graph = graph;
        //constructEvalMap();
        updateEdges();
    }

    /**
     * Updates all edges in the graph with information required to facilitate
     * processing.
     */
    @VisibleForTesting
    void updateEdges() {
        for (final Edge edge : graph.edges()) {
            // FIXME so that it returns non-null values
            QMElement srcEntity = null;
            QMElement destEntity = null;
            EndpointPair<Node> pair = graph.incidentNodes(edge);
            Node dest = pair.target();
            Node src = pair.source();
            Evaluation eval = data.getEvalMap().get(data.getManager().findFactor(dest.getOwnedBy()));
            RankedEdge re = null;
            if (edge instanceof RankedEdge) {
                re = (RankedEdge) edge;
            }

            if (src instanceof FactorNode) {
                srcEntity = data.getFactorOwner(src);
            } else if (src instanceof MeasureNode) {
                srcEntity = data.getMeasureOwner(src);
            }

            if (dest instanceof FactorNode) {
                destEntity = data.getFactorOwner(dest);
            } else if (dest instanceof MeasureNode) {
                destEntity = data.getMeasureOwner(dest);
            }

            if (re != null && srcEntity != null && destEntity != null && eval != null) {
                updateEdge(re, eval, srcEntity, destEntity);
            }
        }
    }

    /**
     * Updates edges with rank information and sets the normalizer for the edge.
     *
     * @param rankedEdge The edge to be update
     * @param eval       The evaluation object containing ranking information.
     * @param srcEntity  The Entity on the source side of the Edge.
     * @param destEntity The Entity on the dest side of the Edge
     */
    @VisibleForTesting
    void updateEdge(final RankedEdge rankedEdge, final Evaluation eval, final QMElement srcEntity,
                    final QMElement destEntity) {
        if (eval instanceof WeightedSumFactorAggregation) {
            for (final FactorRanking rank : ((WeightedSumFactorAggregation) eval).getRankings()) {
                if (rank.getFactor() == null) {
                    continue;
                }

                if (srcEntity instanceof Factor) {
                    Factor srcFac = (Factor) srcEntity;
                    if (srcFac.equals(rank.getFactor())) {
                        updateEdge(rankedEdge, rank, eval);
                        break;
                    }
                }
            }
        } else if (eval instanceof WeightedSumMultiMeasureEvaluation) {
            for (final MeasureRanking rank : ((WeightedSumMultiMeasureEvaluation) eval).getRankings()) {
                if (rank.getMeasure() == null) {
                    continue;
                }

                if (srcEntity instanceof Measure) {
                    Measure srcMeas = (Measure) srcEntity;
                    if (srcMeas.equals(rank.getMeasure())) {
                        updateEdge(rankedEdge, rank, eval);
                        break;
                    }
                }
            }
        } else if (eval instanceof SingleMeasureEvaluation) {
            SingleMeasureEvaluation sme = (SingleMeasureEvaluation) eval;

            if (sme.getNormalization() != null) {
                Measure ent = sme.getNormalization();

                if (ent != null) {
                    final Node norm = data.getMeasure(ent);
                    rankedEdge.setNormalizer(
                            NormalizerFactory.getInstance()
                                    .createNormalizer((Edge) rankedEdge, norm.getName(), sme.getRange()));
                }
            } else {
                rankedEdge.setNormalizer(
                        NormalizerFactory.getInstance().createNormalizer((Edge) rankedEdge, "LOC", sme.getRange()));
            }
        }
    }

    /**
     * Updates the given ranked edge with the provided ranking based on the
     * given evaluation.
     *
     * @param rankedEdge Ranked Edge to update
     * @param rank       Ranking providing information for the update
     * @param eval       Evaluation providing information for the update
     */
    @VisibleForTesting
    void updateEdge(final RankedEdge rankedEdge, final Ranking rank, final Evaluation eval) {
        if (eval instanceof WeightedSumMultiMeasureEvaluation) {
            MeasureRanking measureRank = (MeasureRanking) rank;

            if (measureRank.getNormalization() != null) {
                Measure ent = measureRank.getNormalization();

                if (ent != null) {
                    final Node norm = data.getMeasure(ent);
                    rankedEdge.setNormalizer(
                            NormalizerFactory.getInstance()
                                    .createNormalizer((Edge) rankedEdge, norm.getName(), measureRank.getRange()));
                }
            } else {
                rankedEdge.setNormalizer(
                        NormalizerFactory.getInstance().createNormalizer((Edge) rankedEdge, "LOC", measureRank.getRange()));
            }
        }
    }
}
