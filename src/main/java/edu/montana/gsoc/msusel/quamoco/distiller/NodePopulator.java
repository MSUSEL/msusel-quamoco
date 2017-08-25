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

import java.util.List;
import java.util.Map;

import com.google.common.annotations.VisibleForTesting;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorMethod;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingsUnionNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureMethod;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.graph.node.NormalizationNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.ValueNode;
import edu.montana.gsoc.msusel.quamoco.model.AbstractEntity;
import edu.montana.gsoc.msusel.quamoco.model.qm.AbstractQMEntity;
import edu.montana.gsoc.msusel.quamoco.model.qm.Entity;
import edu.montana.gsoc.msusel.quamoco.model.qm.Factor;
import edu.montana.gsoc.msusel.quamoco.model.qm.Measure;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.qm.QualityModel;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tool;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * Populates the Quamoco Processing Graph with nodes.
 *
 * @author Isaac Griffith
 * @version 1.1.1
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
     * @param map
     *            Map to which the node will be added.
     */
    @VisibleForTesting
    void addNode(DistillerData data, final DirectedSparseGraph<Node, Edge> graph, final AbstractQMEntity entity,
            final Node node)
    {
        if (graph.containsVertex(node))
            return;

        graph.addVertex(node);
        data.addNode(entity, node);
    }

    /**
     * Extracts Factors and Measures from the Quality Models and adds the proper
     * nodes to the distilled processing graph.
     *
     * @param data
     *            Data structure holding the information to be extracted.
     * @param models
     *            List of known quality models.
     * @param graph
     *            Graph to which the information will be added.
     */
    @VisibleForTesting
    void extractFactorsAndMeasures(final DistillerData data, final List<QualityModel> models,
            final DirectedSparseGraph<Node, Edge> graph)
    {
        for (final QualityModel model : models)
        {
            for (final AbstractQMEntity entity : model.getContained())
            {
                if (entity instanceof Measure)
                {
                    final Measure measure = (Measure) entity;
                    MeasureNode node = null;
                    if (measure.getType() != null && measure.getType().equals("qm:NormalizationMeasure"))
                    {
                        node = new NormalizationNode(graph, measure.getName(), measure.getId());
                        setMeasureNodeProperties(measure, node);
                    }
                    else
                    {
                        node = new MeasureNode(graph, measure.getName(), measure.getId());
                        setMeasureNodeProperties(measure, node);
                    }
                    addNode(data, graph, measure, node);
                }
                else if (entity instanceof Factor)
                {
                    final Factor factor = (Factor) entity;

                    String name = factor.getName();

                    if (factor.getCharacterizes() != null)
                    {
                        AbstractEntity ent = QualityModelUtils
                                .findEntity(data.getModelMap(), factor.getCharacterizes().getHREF());

                        if (ent != null)
                        {
                            if (ent instanceof Entity)
                            {
                                name = name.concat(" @" + ((Entity) ent).getName());
                            }
                        }
                    }

                    final FactorNode node = new FactorNode(graph, name, factor.getId());
                    if (!factor.getAnnotations().isEmpty() && factor.hasAggregationAnnotation())
                    {
                        node.setMethod(factor.getAggregationAnnotationValue());
                    }
                    else
                    {
                        node.setMethod(FactorMethod.MEAN);
                    }
                    addNode(data, graph, factor, node);
                }
            }
        }
    }

    /**
     * Extracts Value nodes from the quality models.
     *
     * @param data
     *            Data object holding distiller data.
     * @param models
     *            List of known QualityModel objects.
     * @param graph
     *            Graph to which the data nodes will be added.
     */
    @VisibleForTesting
    void extractValues(final DistillerData data, final List<QualityModel> models,
            final DirectedSparseGraph<Node, Edge> graph)
    {
        final List<MeasurementMethod> mmlist = QualityModelUtils.getAllMeasurementMethods(models);
        final Map<String, QualityModel> map = QualityModelUtils.createModelMap(models);
        for (final MeasurementMethod method : mmlist)
        {
            Node node = null;
            if (method.getType().equals("qm:ManualInstrument"))
            {
                node = new ValueNode(graph, method.getName(), method.getId(), ValueNode.MANUAL);
            }
            else if (method.getType().equals("qm:ToolBasedInstrument"))
            {
                String type = "";
                if (method.getDetermines() != null)
                {
                    final AbstractEntity determines = QualityModelUtils
                            .findEntity(map, method.getDetermines().getHREF());

                    if (determines instanceof Measure)
                    {
                        type = ((Measure) determines).getType();
                    }
                }

                final AbstractEntity tool = QualityModelUtils.findEntity(map, method.getTool());
                String toolName = "";

                if (tool instanceof Tool)
                {
                    toolName = ((Tool) tool).getName();
                }

                if (type.equalsIgnoreCase(MeasureType.FINDINGS))
                {
                    node = new FindingNode(graph, method.getMetric(), method.getId(), method.getMetric(), toolName);
                }
                else
                {
                    node = new ValueNode(graph, method.getMetric(), method.getId(), toolName);
                }
            }
            else
            {
                node = new FindingsUnionNode(graph, method.getName(), method.getId());
            }

            if (!graph.containsVertex(node))
            {
                if (node instanceof FindingsUnionNode)
                {
                    data.addUnion(method, node);
                }
                else
                {
                    data.addValue(method, node);
                }
                graph.addVertex(node);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyGraph(final DistillerData data, final DirectedSparseGraph<Node, Edge> graph)
    {
        extractFactorsAndMeasures(data, data.getModels(), graph);
        extractValues(data, data.getModels(), graph);
    }

    /**
     * Sets a given MeasureNode's properties.
     *
     * @param measure
     *            Measure the MeasureNode represents
     * @param node
     *            Node for which properties will be set.
     */
    @VisibleForTesting
    void setMeasureNodeProperties(final Measure measure, final MeasureNode node)
    {
        // TODO Need to add a field to qm files in order to specify the
        // MeasureMethod correctly
        node.setType(measure.getType());
        if (measure.getType().equals(MeasureType.FINDINGS))
            node.setMethod(MeasureMethod.UNION);
        else
            node.setMethod(MeasureMethod.MEAN);
    }
}
