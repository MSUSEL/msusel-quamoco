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
package edu.montana.gsoc.msusel.quamoco.graph.node;

import com.google.common.collect.Sets;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingsEdge;

import java.math.BigDecimal;
import java.util.Set;


/**
 * Node which simply constructs a union of all input findings nodes.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class FindingsUnionNode extends Node {

    /**
     * The union-ed set of findings.
     */
    private final Set<Finding> findings;

    /**
     * Constructs a new Node which is contained in the given graph,
     * identified by the given name, extracted from the quamoco model entity
     * with
     * the given identifier.
     * 
     * @param name
     *            Identifier of this node
     * @param owner
     *            Identifier of the quamoco model entity this node came from
     */
    public FindingsUnionNode(final String name, final String owner)
    {
        this(null, name, owner);
    }

    public FindingsUnionNode(MutableNetwork<Node, Edge> graph, final String name, final String owner)
    {
        super(graph, name, owner);
        findings = Sets.newHashSet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getLowerResult()
    {
        // TODO Auto-generated method stub
        return BigDecimal.ZERO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getUpperResult()
    {
        // TODO Auto-generated method stub
        return BigDecimal.ONE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getValue()
    {
        // TODO Auto-generated method stub
        calculated = true;
        return BigDecimal.ZERO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTag()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Finding> getFindings()
    {
        if (findings.isEmpty())
        {
            for (final Edge e : graph.inEdges(this))
            {
                if (e instanceof FindingsEdge)
                {
                    findings.addAll(((FindingsEdge) e).getFindings());
                }
            }
        }

        return findings;
    }
}
