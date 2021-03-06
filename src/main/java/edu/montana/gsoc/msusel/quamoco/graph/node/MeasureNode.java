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
package edu.montana.gsoc.msusel.quamoco.graph.node;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringEscapeUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.RankedEdge;
import edu.montana.gsoc.msusel.quamoco.processor.Extent;
import edu.montana.gsoc.msusel.quamoco.processor.FindingsAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.MetricsContext;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * MeasureNode -
 *
 * @author Isaac Griffith
 */
public class MeasureNode extends Node {

    /**
     * The type associated with this measure
     */
    private String       type;
    /**
     * The method associated with this measure
     */
    private String       method;
    /**
     * The set of findings collected in this node
     */
    private Set<Finding> findings;

    /**
     * Constructs a new MeasureNode which is contained in the given graph,
     * identified by the given name, extracted from the quamoco model entity
     * with
     * the given identifier.
     * 
     * @param graph
     *            Graph to which this node belongs
     * @param name
     *            Identifier of this node
     * @param owner
     *            Identifier of the quamoco model entity this node came from
     */
    public MeasureNode(final DirectedSparseGraph<Node, Edge> graph, final String name, final String owner)
    {
        super(graph, name, owner);
        type = MeasureType.FINDINGS;
        findings = Sets.newHashSet();
    }

    /**
     * @return Method of this measure
     */
    public String getMethod()
    {
        return method;
    }

    /**
     * @return the type of this measure
     */
    public String getType()
    {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getValue()
    {
        if (type.equals(MeasureType.NUMBER))
        {
            if (!calculated)
            {
                value = processor.process();
            }

            calculated = true;
            return value;
        }

        return BigDecimal.ZERO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTag()
    {
        final StringBuilder builder = new StringBuilder();
        builder.append(
                String.format(
                        "<nodes name=\"%s\" description=\"%s\" owner=\"%s\" type=\"MEASURE\">\n",
                        StringEscapeUtils.escapeXml10(name), StringEscapeUtils.escapeXml10(description), ownedBy));
        builder.append("\t</nodes>");
        return builder.toString();
    }

    /**
     * @param method
     *            the new method of this measure
     */
    public void setMethod(final String method)
    {
        this.method = method;
    }

    /**
     * @param type
     *            the new type of this measure
     */
    public void setType(final String type)
    {
        this.type = type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Finding> getFindings()
    {
        if (findings == null || findings.isEmpty())
        {
            if (type.equals(MeasureType.FINDINGS))
            {
                findings = ((FindingsAggregator) processor).processFindings();
            }
        }

        return findings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getLowerResult()
    {
        final List<BigDecimal> values = collectFindingExtents();

        return values.isEmpty() ? BigDecimal.ZERO : Collections.min(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getUpperResult()
    {
        final List<BigDecimal> values = collectFindingExtents();

        return values.isEmpty() ? BigDecimal.ONE : Collections.max(values);
    }

    /**
     * @return the list of extents of the findings attached to this
     *         measure
     */
    private List<BigDecimal> collectFindingExtents()
    {
        final List<BigDecimal> values = Lists.newArrayList();

        if (type.equals(MeasureType.FINDINGS))
        {
            for (final Edge e : graph.getInEdges(this))
            {
                final Node n = graph.getOpposite(this, e);
                if (e instanceof RankedEdge)
                {
                    final RankedEdge we = (RankedEdge) e;
                    final Normalizer norm = we.getNormalizer();

                    if (n instanceof MeasureNode)
                    {
                        values.add(
                                Extent.getInstance().findMeasureExtent(
                                        norm.getMetric(), norm.getNormalizationRange(), (MeasureNode) n));
                    }
                    else if (n instanceof FindingNode)
                    {
                        values.add(
                                Extent.getInstance().findFindingExtent(
                                        MetricsContext.getInstance().getTree(), norm.getMetric(),
                                        norm.getNormalizationRange(), (FindingNode) n));
                    }
                }
            }
        }
        else
        {
            for (final Edge e : graph.getInEdges(this))
            {
                final Node n = graph.getOpposite(this, e);
                values.add(n.getValue());
            }
        }

        return values;
    }
}
