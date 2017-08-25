/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
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

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.RankedEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.AbstractEntity;
import edu.montana.gsoc.msusel.quamoco.model.qm.AbstractQMEntity;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluates;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Factor;
import edu.montana.gsoc.msusel.quamoco.model.qm.Function;
import edu.montana.gsoc.msusel.quamoco.model.qm.FunctionType;
import edu.montana.gsoc.msusel.quamoco.model.qm.Measure;
import edu.montana.gsoc.msusel.quamoco.model.qm.Ranking;
import edu.montana.gsoc.msusel.quamoco.processor.NormalizerFactory;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.NegativeLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

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
    DistillerData                   data;
    /**
     * Distilled quality model processing graph
     */
    DirectedSparseGraph<Node, Edge> graph;

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyGraph(DistillerData data, DirectedSparseGraph<Node, Edge> graph)
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

        Map<String, Evaluation> evalMap = data.getEvalMap();
        for (Evaluation eval : evalList)
        {
            Evaluates ev = eval.getEvaluates();
            if (ev != null)
            {
                if (evalMap.containsKey(ev.getHREF()))
                {
                    continue;
                }
                evalMap.put(ev.getHREF(), eval);
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
        for (final Edge edge : graph.getEdges())
        {
            // FIXME so that it returns non-null values
            AbstractQMEntity srcEntity = null;
            AbstractQMEntity destEntity = null;
            Node dest = graph.getDest(edge);
            Node src = graph.getSource(edge);
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
    void updateEdge(final RankedEdge redge, final Evaluation eval, final AbstractQMEntity srcEntity,
            final AbstractQMEntity destEntity)
    {
        for (final Ranking rank : eval.getRankings())
        {
            if (rank.getFactor() == null && rank.getMeasure() == null)
            {
                continue;
            }

            if (srcEntity instanceof Measure && rank.getMeasure() != null)
            {
                Measure srcMeas = (Measure) srcEntity;
                if (!srcMeas.equals(QualityModelUtils.getMeasure(rank.getMeasure().getHREF(), data.getModelMap())))
                    continue;
                else
                {
                    updateEdge(redge, rank, eval);
                    break;
                }
            }
            else if (srcEntity instanceof Factor && rank.getFactor() != null)
            {
                Factor srcFac = (Factor) srcEntity;
                if (!srcFac.equals(QualityModelUtils.getFactor(rank.getFactor().getHREF(), data.getModelMap())))
                    continue;
                else
                {
                    updateEdge(redge, rank, eval);
                    break;
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
        if (rank.getRank() != null)
        {
            redge.setRank(new BigDecimal(rank.getRank()));
        }
        if (rank.getWeight() != null)
        {
            redge.setWeight(new BigDecimal(rank.getWeight()));
        }
        if (rank.getFunction() != null)
        {
            final Function f = rank.getFunction();
            redge.setMaxPoints(eval.getMaximumPoints());
            redge.setLowerBound(f.getLowerBound());
            redge.setUpperBound(f.getUpperBound());

            redge.setUsesLinearDist(true);

            switch (f.getType())
            {
            case FunctionType.INCREASING:
                redge.setDist(new PositiveLinearDistribution());
                break;
            case FunctionType.DECREASING:
                redge.setDist(new NegativeLinearDistribution());
                break;
            }
        }

        if (rank.getNormalizationMeasure() != null)
        {
            AbstractEntity ent = QualityModelUtils
                    .findEntity(data.getModelMap(), rank.getNormalizationMeasure().getHREF());
            if (ent != null && ent instanceof Measure)
            {
                final Node norm = data.getMeasure((Measure) ent);
                redge.setNormalizer(
                        NormalizerFactory.getInstance()
                                .createNormalizer((Edge) redge, norm.getName(), rank.getRange()));
            }
        }
        else
        {
            redge.setNormalizer(NormalizerFactory.getInstance().createNormalizer((Edge) redge, "LOC", rank.getRange()));
        }
    }
}
