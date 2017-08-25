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

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

/**
 * PartOf -
 *
 * @author Isaac Griffith
 */
@XStreamAlias("partOf")
public class PartOf {

    @XStreamAlias("xmi:id")
    @XStreamAsAttribute
    private String id;

    private Parent parent;

    /**
     * @param id
     * @param parent
     */
    public PartOf(final String id, final Parent parent)
    {
        if (id == null || id.isEmpty() || parent == null)
        {
            throw new IllegalArgumentException();
        }
        this.id = id;
        this.parent = parent;
    }

    /**
     * @return
     */
    public String getId()
    {
        return id;
    }

    /**
     * @return
     */
    public Parent getParent()
    {
        return parent;
    }

    /**
     * @param id
     */
    public void setId(final String id)
    {
        if (id == null || id.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.id = id;
    }

    /**
     * @param parent
     */
    public void setParent(final Parent parent)
    {
        this.parent = parent;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (parent == null ? 0 : parent.hashCode());
        return result;
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
        if (!(obj instanceof PartOf))
        {
            return false;
        }
        final PartOf other = (PartOf) obj;
        if (parent == null)
        {
            if (other.parent != null)
            {
                return false;
            }
        }
        else if (!parent.equals(other.parent))
        {
            return false;
        }
        return true;
    }
}
