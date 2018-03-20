/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorMethod;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.QualityModel;
import edu.montana.gsoc.msusel.quamoco.model.eval.ManualEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.WeightedSumMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;

import java.util.List;

/**
 * Populates the Quamoco Processing Graph with nodes.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class NodePopulator implements GraphModifier {

    /**
     * Constructor
     */
    public NodePopulator()
    {
    }

    /**
     * Adds a the provided Node representing the given entity to both the
     * provided graph and Map.
     *
     * @param graph
     *            Graph to which the node is to be added.
     * @param entity
     *            Entity the node represents.
     * @param node
     *            Node to be added.
     */
    @VisibleForTesting
    void addNode(DistillerData data, final MutableNetwork<Node, Edge> graph, final QMElement entity, final Node node)
    {
        if (node == null || graph.nodes().contains(node))
            return;

        graph.addNode(node);
        node.setGraph(graph);
        data.addNode(entity, node);
    }

    /**
     * Extracts Factors and Measures from the Quality Models and adds the proper
     * nodes to the distilled processing graph.
     *
     * @param data
     *            Data structure holding the information to be extracted.
     * @param graph
     *            Graph to which the information will be added.
     */
    @VisibleForTesting
    void extractFactorsAndMeasures(final DistillerData data, final MutableNetwork<Node, Edge> graph)
    {
        for (final QualityModel model : data.getManager().getModels())
        {
            List<QMElement> elements = Lists.newArrayList();
            elements.addAll(model.getMeasures());
            elements.addAll(model.getFactors());
            elements.addAll(model.getMeasurementMethods());

            for (QMElement element : elements)
            {
                Node node = NodeFactory.getInstance().createNode(element);
                addNode(data, graph, element, node);
            }
        }
    }

    /**
     * Extracts Value nodes from the quality models.
     *
     * @param data
     *            Data object holding distiller data.
     * @param graph
     *            Graph to which the data nodes will be added.
     */
    @VisibleForTesting
    void extractValues(final DistillerData data, final MutableNetwork<Node, Edge> graph)
    {
        final List<MeasurementMethod> list = data.getManager().getAllMeasurementMethods();
        for (final MeasurementMethod method : list)
        {
            Node node = NodeFactory.getInstance().createNode(method);
            addNode(data, graph, method, node);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyGraph(final DistillerData data, final MutableNetwork<Node, Edge> graph)
    {
        extractFactorsAndMeasures(data, graph);
        updateFactorMethods(data, graph);
        extractValues(data, graph);
    }

    private void updateFactorMethods(DistillerData data, MutableNetwork<Node, Edge> graph) {
        data.getEvaluations().forEach((eval) -> {
            FactorNode fn = (FactorNode) data.getFactor(eval.getEvaluates());
            if (fn != null) {
                if (eval instanceof WeightedSumMultiMeasureEvaluation || eval instanceof WeightedSumFactorAggregation)
                    fn.setMethod(FactorMethod.RANKING);
                else if (eval instanceof SingleMeasureEvaluation)
                    fn.setMethod(FactorMethod.ONE);
                else if (eval instanceof ManualEvaluation)
                    fn.setMethod(FactorMethod.MANUAL);
                else
                    fn.setMethod(FactorMethod.MEAN);
            }
        });
    }
}
