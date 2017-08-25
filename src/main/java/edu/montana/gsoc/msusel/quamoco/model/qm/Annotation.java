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
 * Annotation -
 *
 * @author Isaac Griffith
 */
@XStreamAlias("annotations")
public class Annotation {

    @XStreamAsAttribute
    @XStreamAlias("key")
    private String key;
    @XStreamAsAttribute
    @XStreamAlias("value")
    private String value;
    @XStreamAsAttribute
    @XStreamAlias("xmi:id")
    private String id;

    /**
     *
     */
    public Annotation(final String key, final String value, final String id)
    {
        this.key = key;
        this.value = value;
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
        final Annotation other = (Annotation) obj;
        if (key == null)
        {
            if (other.key != null)
            {
                return false;
            }
        }
        else if (!key.equals(other.key))
        {
            return false;
        }
        if (value == null)
        {
            if (other.value != null)
            {
                return false;
            }
        }
        else if (!value.equals(other.value))
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
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (key == null ? 0 : key.hashCode());
        result = prime * result + (value == null ? 0 : value.hashCode());
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
     * @param key
     *            the key to set
     */
    public void setKey(final String key)
    {
        this.key = key;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(final String value)
    {
        this.value = value;
    }

}
