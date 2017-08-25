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
import java.util.List;

import com.google.common.collect.Lists;

import edu.montana.gsoc.msusel.quamoco.graph.INode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.processor.Processor;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * Abstract base class for the nodes in the distilled quality model processing
 * graph.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class Node implements INode {

    /**
     * Graph to which this node belongs
     */
    transient protected DirectedSparseGraph<Node, Edge> graph;
    /**
     * Value associated with node after evaluation
     */
    protected BigDecimal                                value       = BigDecimal.ZERO;
    /**
     * lower result of this node (min of all incoming values)
     */
    protected BigDecimal                                lowerResult = BigDecimal.ZERO;
    /**
     * upper result of this node (max of all incoming values)
     */
    protected BigDecimal                                upperResult = BigDecimal.ONE;
    /**
     * fully qualified identifier of the quamoco model entity from which this
     * node was derived
     */
    protected String                                    ownedBy;
    /**
     * name of this node
     */
    protected String                                    name;
    /**
     * description of this node
     * TODO remove this
     */
    protected String                                    description;
    /**
     * The process associated with this node, which facilitates the evaluation
     */
    protected Processor                                 processor;
    /**
     * Boolean flag indicating that this node has already successfully been
     * calculated.
     */
    protected boolean                                   calculated;

    /**
     * Constructs a new Node which is contained in the given graph,
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
    public Node(final DirectedSparseGraph<Node, Edge> graph, final String name, final String owner)
    {
        if (name == null || name.isEmpty() || owner == null || owner.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.graph = graph;
        this.name = name;
        description = "";
        ownedBy = owner;
        calculated = false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription()
    {
        return description;
    }

    /**
     * @return The graph to which this node belongs
     */
    public DirectedSparseGraph<Node, Edge> getGraph()
    {
        return graph;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName()
    {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getOwnedBy()
    {
        return ownedBy;
    }

    /**
     * @return The evaluated value of this node, which is dependent on all
     *         incoming nodes.
     */
    public abstract BigDecimal getValue();

    /**
     * @return The xml tag associated with node
     */
    public abstract String getXMLTag();

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDescription(final String description)
    {
        if (description == null)
        {
            this.description = "";
        }
        else
        {
            this.description = description;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOwnedBy(final String ownedBy)
    {
        if (ownedBy == null || ownedBy.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.ownedBy = ownedBy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Processor getProcessor()
    {
        return processor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setProcessor(final Processor processor)
    {
        this.processor = processor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<BigDecimal> getValues()
    {
        final List<BigDecimal> list = Lists.newArrayList();
        list.add(getValue());

        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((ownedBy == null) ? 0 : ownedBy.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Node other = (Node) obj;
        if (name == null)
        {
            if (other.name != null)
            {
                return false;
            }
        }
        else if (!name.equals(other.name))
        {
            return false;
        }
        if (ownedBy == null)
        {
            if (other.ownedBy != null)
            {
                return false;
            }
        }
        else if (!ownedBy.equals(other.ownedBy))
        {
            return false;
        }
        return true;
    }

}
