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

import com.google.common.annotations.VisibleForTesting;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.ValueNode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FactorToFactorEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.ValueToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.Factor;
import edu.montana.gsoc.msusel.quamoco.model.Impact;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.Measure;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.MeasurementMethod;

/**
 * Connects the nodes in the Quamoco Processing graph.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class EdgePopulator implements GraphModifier {

    /**
     * {@inheritDoc}
     */
    @Override
    public void modifyGraph(final DistillerData data, final MutableNetwork<Node, Edge> graph)
    {
        handleFactors(data, graph);
        handleMeasures(data, graph);
        handleData(data, graph);
        handleUnions(data, graph);
    }

    /**
     * Adds an edge between the two provided nodes in the provided graph.
     *
     * @param graph
     *            Graph in which to add the edge.
     * @param src
     *            Source side of the edge.
     * @param dest
     *            Destination side of the edge.
     * @param infEffect
     *            The influence effect, can be POS or NEG (if null POS is
     *            assumed)
     */
    @VisibleForTesting
    void addEdge(final MutableNetwork<Node, Edge> graph, final Node src, final Node dest,
            final InfluenceEffect infEffect)
    {
        if (src == null || dest == null)
        {
            return;
        }

        if (src instanceof ValueNode)
        {

            graph.addEdge(src, dest, new ValueToMeasureEdge(src.getName() + ":" + dest.getName(), src, dest));
        }
        else if (src instanceof FindingNode)
        {
            graph.addEdge(src, dest, new FindingToMeasureEdge(src.getName() + ":" + dest.getName(), dest, src));
        }
        else if (src instanceof MeasureNode && dest instanceof MeasureNode)
        {
            final MeasureNode sm = (MeasureNode) src;
            final MeasureNode dm = (MeasureNode) dest;
            if (sm.getType().equals(MeasureType.FINDINGS) && dm.getType().equals(MeasureType.FINDINGS))
            {
                graph.addEdge(
                        src, dest, new MeasureToMeasureFindingsEdge(src.getName() + ":" + dest.getName(), src, dest));
            }
            else if (sm.getType().equals(MeasureType.NUMBER) && dm.getType().equals(MeasureType.NUMBER))
            {
                graph.addEdge(
                        src, dest, new MeasureToMeasureNumberEdge(src.getName() + ":" + dest.getName(), src, dest));
            }
            else
            {
                graph.addEdge(
                        src, dest,
                        new MeasureToMeasureFindingsNumberEdge(src.getName() + ":" + dest.getName(), src, dest));
            }
        }
        else if (src instanceof MeasureNode && dest instanceof FactorNode)
        {
            final MeasureNode sn = (MeasureNode) src;

            if (sn.getType().equals(MeasureType.FINDINGS))
            {
                graph.addEdge(
                        src, dest,
                        new MeasureToFactorFindingsEdge(src.getName() + ":" + dest.getName(), src, dest, infEffect));
            }
            else
            {
                graph.addEdge(
                        src, dest,
                        new MeasureToFactorNumberEdge(src.getName() + ":" + dest.getName(), src, dest, infEffect));
            }
        }
        else if (src instanceof FactorNode && dest instanceof FactorNode)
        {
            graph.addEdge(
                    src, dest, new FactorToFactorEdge(src.getName() + ":" + dest.getName(), src, dest, infEffect));
        }
    }

    /**
     * Using the provided DistillerData object this method retrieves a FactorNode
     * or MeasureNode associated with a Factor or Measure entity, respectively,
     * with the given unique identifier.
     * 
     * @param data
     *            DistillerData used to search for the dest node
     * @param element
     *            Identifier of the associated Measure or Factor associated with
     *            the node to retrieve.
     * @return The node associated with the entity whose Identifier has been
     *         given, if the identifier is null or is neither a Factor nor
     *         Measure entity, then null will be returned.
     */
    @VisibleForTesting
    Node getDestNode(final DistillerData data, QMElement element)
    {
        Node dest = null;

        if (element instanceof Factor)
        {
            dest = data.getFactor((Factor) element);
        }
        else if (element instanceof Measure)
        {
            dest = data.getMeasure((Measure) element);
        }

        return dest;
    }

    /**
     * Handles processing the relationships involving FindingsUnionNodes.
     * 
     * @param data
     *            DistillerData
     * @param graph
     *            Graph in which to populate edges
     */
    @VisibleForTesting
    void handleUnions(final DistillerData data, final MutableNetwork<Node, Edge> graph)
    {
        for (final QMElement key : data.getUnions())
        {
            if (key instanceof MeasurementMethod)
            {
                final MeasurementMethod method = (MeasurementMethod) key;
                final Node union = data.getUnion(method);

                if (method.getDetermines() != null)
                {
                    Node dest = getDestNode(data, method.getDetermines());
                    if (dest != null)
                        addEdge(graph, union, dest, null);
                }

                for (final QMElement dataKey : data.getValues())
                {
                    if (dataKey instanceof MeasurementMethod)
                    {
                        final Node src = data.getValue((MeasurementMethod) dataKey);
                        if (src instanceof FindingNode) // FIXME verify this is
                                                        // correct
                        {
                            addEdge(graph, src, union, null);
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
     * @param data
     *            DistillerData
     * @param graph
     *            Graph into which edges will be populated.
     */
    @VisibleForTesting
    void handleData(final DistillerData data, final MutableNetwork<Node, Edge> graph)
    {
        for (final QMElement key : data.getValues())
        {
            if (key instanceof MeasurementMethod)
            {
                final MeasurementMethod method = (MeasurementMethod) key;
                final Node src = data.getValue(method);
                if (method.getDetermines() != null)
                {
                    Node dest = getDestNode(data, method.getDetermines());
                    if (dest != null)
                        addEdge(graph, src, dest, null);
                }
            }
        }
    }

    /**
     * Handles the creation of edges involving factors
     * 
     * @param data
     *            DistillerData
     * @param graph
     *            Graph into which edges will be populated.
     */
    @VisibleForTesting
    void handleFactors(final DistillerData data, final MutableNetwork<Node, Edge> graph)
    {
        for (final QMElement key : data.getFactors())
        {
            if (key instanceof Factor)
            {
                final Factor factor = (Factor) key;
                final Node src = data.getFactor(factor);
                for (final Impact inf : factor.getInfluences())
                {
                    final Node dest = data.getFactor(inf.getTarget());
                    addEdge(graph, src, dest, inf.getEffect());
                }
                if (factor.getRefines() != null)
                {
                    final Node dest = data.getFactor(factor.getRefines());
                    addEdge(graph, src, dest, null);
                }
            }
        }
    }

    /**
     * Handles the creation of edges involving measures
     * 
     * @param data
     *            DistillerData
     * @param graph
     *            Graph into which edges will be populated.
     */
    @VisibleForTesting
    void handleMeasures(final DistillerData data, final MutableNetwork<Node, Edge> graph)
    {
        for (final QMElement key : data.getMeasures())
        {
            if (key instanceof Measure)
            {
                final Measure measure = (Measure) key;
                final Node src = data.getMeasure(measure);
                
                if (measure.getRefines() != null)
                {
                    Node dest = getDestNode(data, measure.getRefines());
                    if (dest != null)
                        addEdge(graph, src, dest, null);
                }
            }
        }
    }
}
