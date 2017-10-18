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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import java.math.BigDecimal;
import java.util.List;

import com.google.common.collect.Lists;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;

/**
 * An abstract representation of an Edge for the Quamoco
 * processing graph. In the Quamoco Graph, edges normalize the value of the
 * source and provide this normalized value to the dest.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class AbstractEdge implements Edge {

    /**
     * Incoming side of the edge
     */
    protected Node src;
    /**
     * Outgoing side of the edge
     */
    protected Node       dest;
    /**
     * Normalizer attached to this edge
     * FIXME: should only be available on Normalizable Edges
     */
    protected Normalizer norm;
    /**
     * The next unique identification number for an edge
     */
    private static long  NEXT_ID = 0;
    /**
     * Name of this edge
     */
    private final String name;
    /**
     * The unique identifying number for this edge
     */
    private long         id;

    /**
     * Constructs a new MeasureToMeasureNumberEdge with the given name
     * connecting the source and dest nodes.
     * 
     * @param name
     *            Name of this edge
     * @param src
     *            Source node
     * @param dest
     *            Dest node
     */
    public AbstractEdge(final String name, final Node src, final Node dest)
    {
        this.name = name;
        id = AbstractEdge.NEXT_ID++;
        this.src = src;
        this.dest = dest;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(final Object obj)
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
        final AbstractEdge other = (AbstractEdge) obj;
        if (id != other.id)
        {
            return false;
        }
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
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getId()
    {
        return id;
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
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ id >>> 32);
        result = prime * result + (name == null ? 0 : name.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return "Edge: " + id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(final long id)
    {
        this.id = id;
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
     * A value for any edge (after processing) should be in the range [0.0,1.0]
     * and thus any values outside of this must be made to conform to this
     * range. Thus this method takes a value and if this value is less than 0.0,
     * returns 0.0, or if the value is greater than 1.0, returns 1.0. Otherwise
     * it returns the original value.
     * 
     * @param value
     *            Input value
     * @return 0.0 if the input value is less than 0.0, 1.0 if the input value
     *         is greater than 1.0, and the original value otherwise.
     */
    protected BigDecimal thresholdValue(BigDecimal value)
    {
        if (value.compareTo(BigDecimal.ZERO) < 0)
            return BigDecimal.ZERO;

        if (value.compareTo(BigDecimal.ONE) > 0)
            return BigDecimal.ONE;

        return value;
    }
}