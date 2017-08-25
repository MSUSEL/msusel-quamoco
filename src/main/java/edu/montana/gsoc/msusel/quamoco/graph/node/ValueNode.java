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

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * Input Node which simply forms a place into which metric measures are to be
 * stored in the graph.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ValueNode extends Node {

    /**
     * FIXME: This needs to be moved
     * Constant indicating that this is a value from a manual instrument
     */
    public static final String     MANUAL = "ManualInstrument";
    /**
     * FIXME: This needs to be moved
     * Constant indicating that this is a measure which unions findings
     */
    public static final String     UNION  = "FindingsUnionMeasureAggregation";
    /**
     * Name of the tool providing the values for this metric
     */
    private final String           tool;
    /**
     * List of actual measurement values.
     * TODO Provide a means by which these values can be related to where they
     * came from (INode)
     */
    private final List<BigDecimal> values;
    /**
     * Name of the metric for which the provided measures exist.
     */
    private String                 metric;

    /**
     * Constructs a new ValueNode which is contained in the given graph,
     * identified by the given key, extracted from the quamoco model entity with
     * the given identifier and measured by the tool with the given identifier
     * 
     * @param graph
     *            Graph to which this node belongs
     * @param key
     *            Identifier of this node
     * @param owner
     *            Identifier of the quamoco model entity this node came from
     * @param tool
     *            Tool which provides the values for this node
     */
    public ValueNode(final DirectedSparseGraph<Node, Edge> graph, final String key, final String owner,
            final String tool)
    {
        super(graph, key, owner);
        this.tool = tool;
        values = Lists.newArrayList();
        value = BigDecimal.ZERO;
    }

    /**
     * @return the key identifying this ndoe
     */
    public String getKey()
    {
        return getName();
    }

    /**
     * @return tool providing measuments for this node
     */
    public String getTool()
    {
        return tool;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getValue()
    {
        if (!calculated)
        {
            value = BigDecimal.ZERO;
            for (final BigDecimal v : values)
            {
                value = value.add(v);
            }
            // calculated = true;
        }
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTag()
    {
        return String.format("<nodes name=\"%s\" owner=\"%s\" type=\"VALUE\" />", name, ownedBy);
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKey(final String key)
    {
        if (key == null || key.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        setName(key);
    }

    /**
     * @param value
     *            A new measurement for this node
     */
    public void addValue(final BigDecimal value)
    {
        values.add(value);

        this.value = this.value.add(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getLowerResult()
    {
        return Collections.min(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getUpperResult()
    {
        return Collections.max(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<BigDecimal> getValues()
    {
        return values;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Finding> getFindings()
    {
        return Sets.newHashSet();
    }
}
