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

import java.util.List;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * MeasurementMethod -
 *
 * @author Isaac Griffith
 */
@XStreamAlias("measurementMethods")
public class MeasurementMethod extends AbstractQMEntity {

    private Determines     determines;
    @XStreamAlias("metric")
    @XStreamAsAttribute
    private String         metric;
    private OriginatesFrom originatesFrom;
    @XStreamAlias("tool")
    @XStreamAsAttribute
    private String         tool;
    @XStreamAlias("xsi:type")
    @XStreamAsAttribute
    private String         type;

    /**
     *
     */
    public MeasurementMethod(final String name, final String description, final Determines determines,
            final String tool, final String metric, final OriginatesFrom originatesFrom, final String type,
            final String id)
    {
        if (id == null || id.isEmpty() || type == null || type.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.description = description;
        this.determines = determines;
        this.metric = metric;
        this.name = name;
        this.originatesFrom = originatesFrom;
        this.tool = tool;
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
        final MeasurementMethod other = (MeasurementMethod) obj;
        if (description == null)
        {
            if (other.description != null)
            {
                return false;
            }
        }
        else if (!description.equals(other.description))
        {
            return false;
        }
        if (determines == null)
        {
            if (other.determines != null)
            {
                return false;
            }
        }
        else if (!determines.equals(other.determines))
        {
            return false;
        }
        if (metric == null)
        {
            if (other.metric != null)
            {
                return false;
            }
        }
        else if (!metric.equals(other.metric))
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
        if (originatesFrom == null)
        {
            if (other.originatesFrom != null)
            {
                return false;
            }
        }
        else if (!originatesFrom.equals(other.originatesFrom))
        {
            return false;
        }
        if (type == null)
        {
            if (other.type != null)
            {
                return false;
            }
        }
        else if (!type.equals(other.type))
        {
            return false;
        }
        if (tool == null)
        {
            if (other.tool != null)
            {
                return false;
            }
        }
        else if (!tool.equals(other.tool))
        {
            return false;
        }
        return true;
    }

    /**
     * @return the determines
     */
    public Determines getDetermines()
    {
        return determines;
    }

    /**
     * @return the metric
     */
    public String getMetric()
    {
        return metric;
    }

    /**
     * @return the originatesFrom
     */
    public OriginatesFrom getOriginatesFrom()
    {
        return originatesFrom;
    }

    /**
     * @return the tool
     */
    public String getTool()
    {
        return tool;
    }

    /**
     * @return
     */
    public String getType()
    {
        return type;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + (determines == null ? 0 : determines.hashCode());
        result = prime * result + (metric == null ? 0 : metric.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (originatesFrom == null ? 0 : originatesFrom.hashCode());
        result = prime * result + (type == null ? 0 : type.hashCode());
        result = prime * result + (tool == null ? 0 : tool.hashCode());
        return result;
    }

    /**
     * @param determines
     *            the determines to set
     */
    public void setDetermines(final Determines determines)
    {
        this.determines = determines;
    }

    /**
     * @param metric
     *            the metric to set
     */
    public void setMetric(final String metric)
    {
        this.metric = metric;
    }

    /**
     * @param originatesFrom
     *            the originatesFrom to set
     */
    public void setOriginatesFrom(final OriginatesFrom originatesFrom)
    {
        this.originatesFrom = originatesFrom;
    }

    /**
     * @param tool
     *            the tool to set
     */
    public void setTool(final String tool)
    {
        this.tool = tool;
    }

    /**
     * @param type
     */
    public void setType(final String type)
    {
        this.type = type;
    }

}
