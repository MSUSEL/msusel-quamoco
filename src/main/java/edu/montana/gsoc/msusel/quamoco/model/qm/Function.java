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
package edu.montana.gsoc.msusel.quamoco.model.qm;

import java.math.BigDecimal;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * Function -
 *
 * @author Isaac Griffith
 */
public class Function {

    @XStreamAlias("lowerBound")
    @XStreamAsAttribute
    private BigDecimal lowerBound;
    @XStreamAlias("upperBound")
    @XStreamAsAttribute
    private BigDecimal upperBound;
    @XStreamAlias("xsi:type")
    @XStreamAsAttribute
    private String     type;
    @XStreamAlias("xmi:id")
    @XStreamAsAttribute
    private String     id;

    /**
     *
     */
    public Function(final BigDecimal lowerBound, final BigDecimal upperBound, final String type, final String id)
    {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
        this.type = type;
        this.id = id;
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
        final Function other = (Function) obj;
        if (id == null)
        {
            if (other.id != null)
            {
                return false;
            }
        }
        else if (!id.equals(other.id))
        {
            return false;
        }
        if (lowerBound.compareTo(other.lowerBound) != 0)
        {
            return false;
        }
        if (upperBound.compareTo(other.upperBound) != 0)
        {
            return false;
        }
        return true;
    }

    /**
     * @return the id
     */
    public String getId()
    {
        return id;
    }

    /**
     * @return the lowerBound
     */
    public BigDecimal getLowerBound()
    {
        return lowerBound;
    }

    /**
     * @return the type
     */
    public String getType()
    {
        return type;
    }

    /**
     * @return the upperBound
     */
    public BigDecimal getUpperBound()
    {
        return upperBound;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (lowerBound == null ? 0 : lowerBound.hashCode());
        result = prime * result + (upperBound == null ? 0 : upperBound.hashCode());
        return result;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(final String id)
    {
        this.id = id;
    }

    /**
     * @param lowerBound
     *            the lowerBound to set
     */
    public void setLowerBound(final BigDecimal lowerBound)
    {
        this.lowerBound = lowerBound;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(final String type)
    {
        this.type = type;
    }

    /**
     * @param upperBound
     *            the upperBound to set
     */
    public void setUpperBound(final BigDecimal upperBound)
    {
        this.upperBound = upperBound;
    }
}
