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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;

/**
 * Measure -
 *
 * @author Isaac Griffith
 */
@XStreamAlias("measures")
public class Measure extends AbstractQMEntity {

    private Characterizes       characterizes;
    private OriginatesFrom      originatesFrom;
    private Refines             refines;
    @XStreamImplicit
    private final Set<Parent>   parents;
    @XStreamAlias("title")
    @XStreamAsAttribute
    private String              title;
    @XStreamAlias("xsi:type")
    @XStreamAsAttribute
    private String              type;
    @XStreamImplicit
    private final List<Measure> measures;
    @XStreamAlias("taggedBy")
    @XStreamAsAttribute
    private String              taggedBy;
    private boolean             normalizer;

    /**
     *
     */
    public Measure(final String name, final String description, final String title, final Characterizes characterises,
            final String type, final String taggedBy, final OriginatesFrom originatesFrom, final Refines refines,
            final String id, boolean normalizer)
    {
        if (id == null || id.isEmpty() || type == null || type.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        measures = new ArrayList<>();
        parents = new HashSet<>();
        this.name = name;
        this.description = description;
        this.title = title;
        characterizes = characterises;
        this.type = type;
        this.originatesFrom = originatesFrom;
        this.id = id;
        this.refines = refines;
        this.taggedBy = taggedBy;
        this.normalizer = normalizer;
    }

    /**
     * @param measure
     *            the measure to add
     */
    public void addMeasure(final Measure measure)
    {
        if (measure == null || measures.contains(measure))
        {
            return;
        }

        measures.add(measure);
    }

    /**
     * @param parent
     */
    public void addParent(final Parent parent)
    {
        if (parent == null)
        {
            return;
        }

        parents.add(parent);
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
        final Measure other = (Measure) obj;
        if (characterizes == null)
        {
            if (other.characterizes != null)
            {
                return false;
            }
        }
        else if (!characterizes.equals(other.characterizes))
        {
            return false;
        }
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
        if (measures == null)
        {
            if (other.measures != null)
            {
                return false;
            }
        }
        else if (!measures.equals(other.measures))
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
        if (refines == null)
        {
            if (other.refines != null)
            {
                return false;
            }
        }
        else if (!refines.equals(other.refines))
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
        return true;
    }

    /**
     * @return the characterises
     */
    public Characterizes getCharacterizes()
    {
        return characterizes;
    }

    /**
     * @return the originatesFrom
     */
    public OriginatesFrom getOriginatesFrom()
    {
        return originatesFrom;
    }

    /**
     * @return
     */
    public Set<Parent> getParents()
    {
        return parents;
    }

    /**
     * @return the refines
     */
    public Refines getRefines()
    {
        return refines;
    }

    /**
     * @return
     */
    public String getTaggedBy()
    {
        return taggedBy;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @return the type
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
        result = prime * result + (characterizes == null ? 0 : characterizes.hashCode());
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + (measures == null ? 0 : measures.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (originatesFrom == null ? 0 : originatesFrom.hashCode());
        result = prime * result + (refines == null ? 0 : refines.hashCode());
        result = prime * result + (title == null ? 0 : title.hashCode());
        result = prime * result + (type == null ? 0 : type.hashCode());
        return result;
    }

    /**
     * @param measure
     *            the measure to remove
     */
    public void removeMeasure(final Measure measure)
    {
        if (measure == null || !measures.contains(measure))
        {
            return;
        }

        measures.remove(measure);
    }

    /**
     * @param characterises
     *            the characterises to set
     */
    public void setCharacterizes(final Characterizes characterises)
    {
        characterizes = characterises;
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
     * @param refines
     *            the refines to set
     */
    public void setRefines(final Refines refines)
    {
        this.refines = refines;
    }

    /**
     * @param taggedBy
     */
    public void setTaggedBy(final String taggedBy)
    {
        this.taggedBy = taggedBy;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(final String title)
    {
        this.title = title;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(final String type)
    {
        if (type != null && !(type.equals(MeasureType.FINDINGS) || type.equals(MeasureType.NUMBER)))
        {
            throw new IllegalArgumentException();
        }

        this.type = type;
    }

    /**
     * @return
     */
    public List<Measure> getMeasures()
    {
        return measures;
    }

    /**
     * @return
     */
    public boolean isNomalizationMeasure()
    {
        return normalizer;
    }

    /**
     * @param norm
     */
    public void setNormalizationMeasure(boolean norm)
    {
        this.normalizer = norm;
    }
}
