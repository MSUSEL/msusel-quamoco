/**
 * The MIT License (MIT)
 *
 * SparQLine Quamoco Implementation
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.RankedEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.NormalizerFactory;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.NegativeLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.model.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.Factor;
import edu.montana.gsoc.msusel.quamoco.model.FactorRanking;
import edu.montana.gsoc.msusel.quamoco.model.Function;
import edu.montana.gsoc.msusel.quamoco.model.LinearFunction;
import edu.montana.gsoc.msusel.quamoco.model.LinearIncreasingFunction;
import edu.montana.gsoc.msusel.quamoco.model.Measure;
import edu.montana.gsoc.msusel.quamoco.model.MeasureRanking;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.Ranking;
import edu.montana.gsoc.msusel.quamoco.model.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.WeightedSumMultiMeasureEvaluation;

/**
 * Class to populate the model processing graph edges with normalizers
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class NormalizerPopulator implements GraphModifier {

    /**
     * Data storage for the distillation process
     */
    DistillerData              data;
    /**
     * Distilled quality model processing graph
     */
    MutableNetwork<Node, Edge> graph;

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyGraph(DistillerData data, MutableNetwork<Node, Edge> graph)
    {
        this.data = data;
        this.graph = graph;
        constructEvalMap();
        updateEdges();
    }

    /**
     * Constructs the evaluation map for all evaluations in all known quality
     * models
     */
    @VisibleForTesting
    void constructEvalMap()
    {
        List<Evaluation> evalList = QualityModelUtils.getAllEvaluations(data.getModels());

        Map<Factor, Evaluation> evalMap = data.getEvalMap();
        for (Evaluation eval : evalList)
        {
            Factor ev = eval.getEvaluates();
            if (ev != null)
            {
                evalMap.put(ev, eval);
            }
        }
    }

    /**
     * Updates all edges in the graph with information required to facilitate
     * processing.
     */
    @VisibleForTesting
    void updateEdges()
    {
        for (final Edge edge : graph.edges())
        {
            // FIXME so that it returns non-null values
            QMElement srcEntity = null;
            QMElement destEntity = null;
            EndpointPair<Node> pair = graph.incidentNodes(edge);
            Node dest = pair.target();
            Node src = pair.source();
            final Evaluation eval = data.getEvalMap().get(dest.getOwnedBy());

            RankedEdge re = null;
            if (edge instanceof RankedEdge)
            {
                re = (RankedEdge) edge;
            }

            if (src instanceof FactorNode)
            {
                srcEntity = data.getFactorOwner(src);
            }
            else if (src instanceof MeasureNode)
            {
                srcEntity = data.getMeasureOwner(src);
            }

            if (dest instanceof FactorNode)
            {
                destEntity = data.getFactorOwner(dest);
            }
            else if (dest instanceof MeasureNode)
            {
                destEntity = data.getMeasureOwner(dest);
            }

            if (re != null && srcEntity != null && destEntity != null && eval != null)
            {
                updateEdge(re, eval, srcEntity, destEntity);
            }
        }
    }

    /**
     * Updates edges with rank information and sets the normalizer for the edge.
     *
     * @param redge
     *            The edge to be update
     * @param eval
     *            The evaluation object containing ranking information.
     * @param srcEntity
     *            The Entity on the source side of the Edge.
     * @param destEntity
     *            The Entity on the dest side of the Edge
     */
    @VisibleForTesting
    void updateEdge(final RankedEdge redge, final Evaluation eval, final QMElement srcEntity,
            final QMElement destEntity)
    {
        if (eval instanceof WeightedSumFactorAggregation)
        {
            for (final FactorRanking rank : ((WeightedSumFactorAggregation) eval).getRankings())
            {
                if (rank.getFactor() == null)
                {
                    continue;
                }

                if (srcEntity instanceof Factor)
                {
                    Factor srcFac = (Factor) srcEntity;
                    if (!srcFac.equals(rank.getFactor()))
                        continue;
                    else
                    {
                        updateEdge(redge, rank, eval);
                        break;
                    }
                }
            }
        }
        else if (eval instanceof WeightedSumMultiMeasureEvaluation)
        {
            for (final MeasureRanking rank : ((WeightedSumMultiMeasureEvaluation) eval).getRankings())
            {
                if (rank.getMeasure() == null)
                {
                    continue;
                }

                if (srcEntity instanceof Measure)
                {
                    Measure srcMeas = (Measure) srcEntity;
                    if (!srcMeas.equals(rank.getMeasure()))
                        continue;
                    else
                    {
                        updateEdge(redge, rank, eval);
                        break;
                    }
                }
            }
        }
    }

    /**
     * Updates the given ranked edge with the provided ranking based on the
     * given evaluation.
     * 
     * @param redge
     *            Ranked Edge to update
     * @param rank
     *            Ranking providing information for the update
     * @param eval
     *            Evaluation providing information for the update
     */
    @VisibleForTesting
    void updateEdge(final RankedEdge redge, final Ranking rank, final Evaluation eval)
    {
        if (rank.getRank() > 0)
        {
            redge.setRank(new BigDecimal(rank.getRank()));
        }
        if (Double.compare(rank.getWeight(), 0) > 0)
        {
            redge.setWeight(new BigDecimal(rank.getWeight()));
        }

        if (eval instanceof WeightedSumMultiMeasureEvaluation)
        {
            MeasureRanking mrank = (MeasureRanking) rank;
            if (mrank.getFunction() != null)
            {
                final Function f = mrank.getFunction();
                if (f instanceof LinearFunction)
                {
                    redge.setMaxPoints(new BigDecimal(eval.getMaximumPoints()));
                    redge.setLowerBound(new BigDecimal(((LinearFunction) f).getLowerBound()));
                    redge.setUpperBound(new BigDecimal(((LinearFunction) f).getUpperBound()));

                    if (f instanceof LinearIncreasingFunction)
                    {
                        redge.setDist(new PositiveLinearDistribution());
                    }
                    else
                    {
                        redge.setDist(new NegativeLinearDistribution());
                    }
                }
            }

            if (mrank.getNormalization() != null)
            {
                Measure ent = mrank.getNormalization();
                if (ent != null)
                {
                    final Node norm = data.getMeasure(ent);
                    redge.setNormalizer(
                            NormalizerFactory.getInstance()
                                    .createNormalizer((Edge) redge, norm.getName(), mrank.getRange()));
                }
            }
            else
            {
                redge.setNormalizer(
                        NormalizerFactory.getInstance().createNormalizer((Edge) redge, "LOC", mrank.getRange()));
            }
        }
    }
}
