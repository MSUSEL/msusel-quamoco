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

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Entity -
 *
 * @author Isaac Griffith
 */
@XStreamAlias("entities")
public class Entity extends AbstractQMEntity {

    private OriginatesFrom  originatesFrom;
    @XStreamAlias("")
    @XStreamAsAttribute
    private String          title;
    @XStreamImplicit
    private final List<IsA> isAs;
    private PartOf          partOf;                 // create an object

    /**
     *
     */
    public Entity(final String name, final String description, final OriginatesFrom originatesFrom, final String title,
            final String id, final PartOf partOf)
    {
        if (name == null || name.isEmpty() || id == null || id.isEmpty() || description == null)
        {
            throw new IllegalArgumentException();
        }

        isAs = new ArrayList<>();
        this.description = description;
        this.name = name;
        this.title = title == null ? "" : title;
        this.id = id;
        this.originatesFrom = originatesFrom;
        this.partOf = partOf;
    }

    /**
     * @param isa
     */
    public void addIsA(final IsA isa)
    {
        if (isa == null || isAs.contains(isa))
        {
            return;
        }

        isAs.add(isa);
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
        final Entity other = (Entity) obj;
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
        if (partOf == null)
        {
            if (other.partOf != null)
            {
                return false;
            }
        }
        else if (!partOf.equals(other.partOf))
        {
            return false;
        }
        if (title == null)
        {
            if (other.title != null)
            {
                return false;
            }
        }
        else if (!title.equals(other.title))
        {
            return false;
        }
        return true;
    }

    /**
     * @return the originatesFrom
     */
    public OriginatesFrom getOriginatesFrom()
    {
        return originatesFrom;
    }

    /**
     * @return the partOf
     */
    public PartOf getPartOf()
    {
        return partOf;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
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
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (originatesFrom == null ? 0 : originatesFrom.hashCode());
        result = prime * result + (partOf == null ? 0 : partOf.hashCode());
        result = prime * result + (title == null ? 0 : title.hashCode());
        return result;
    }

    /**
     * @param isa
     */
    public void removeIsA(final IsA isa)
    {
        if (isa == null || !isAs.contains(isa))
        {
            return;
        }

        isAs.remove(isa);
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
     * @param partOf
     *            the partOf to set
     */
    public void setPartOf(final PartOf partOf)
    {
        this.partOf = partOf;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(final String title)
    {
        if (title == null)
        {
            this.title = "";
        }
        else
        {
            this.title = title;
        }
    }

    /**
     * @return
     */
    public List<IsA> getIsAs()
    {
        return isAs;
    }

}
