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

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Factor -
 *
 * @author Isaac Griffith
 */
@XStreamAlias("factors")
public class Factor extends AbstractQMEntity {

    private Characterizes          characterizes;
    private OriginatesFrom         originatesFrom;
    @XStreamAlias("title")
    @XStreamAsAttribute
    private String                 title;
    @XStreamImplicit
    private final List<Influence>  influences;
    private Refines                refines;

    /**
     *
     */
    public Factor(final String name, final String description, final Characterizes characterises,
            final OriginatesFrom originatesFrom, final String title, final Refines refines, final String id)
    {
        influences = new ArrayList<>();
        characterizes = characterises;
        this.name = name;
        this.description = description;
        this.originatesFrom = originatesFrom;
        this.title = title;
        this.refines = refines;
        this.id = id;
    }

    /**
     * @param inf
     */
    public void addInfluence(final Influence inf)
    {
        if (inf == null || influences.contains(inf))
        {
            return;
        }

        influences.add(inf);
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
        final Factor other = (Factor) obj;
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
     * @return
     */
    public List<Influence> getInfluences()
    {
        return influences;
    }

    /**
     * @return the originatesFrom
     */
    public OriginatesFrom getOriginatesFrom()
    {
        return originatesFrom;
    }

    /**
     * @return the refines
     */
    public Refines getRefines()
    {
        return refines;
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
        result = prime * result + (characterizes == null ? 0 : characterizes.hashCode());
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (originatesFrom == null ? 0 : originatesFrom.hashCode());
        result = prime * result + (refines == null ? 0 : refines.hashCode());
        result = prime * result + (title == null ? 0 : title.hashCode());
        return result;
    }

    /**
     * @param fac
     * @return
     */
    public InfluenceEffect influenceEffect(final Factor fac)
    {
        for (final Influence inf : influences)
        {
            if (inf.getTarget().getHREF().equals(fac.getId()))
            {
                return inf.getEffect();
            }
        }
        return null;
    }

    /**
     * @param fac
     * @return
     */
    public boolean influences(final Factor fac)
    {
        for (final Influence inf : influences)
        {
            if (inf.getTarget().getHREF().equals(fac.getId()))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * @param inf
     */
    public void removeInfluence(final Influence inf)
    {
        if (inf == null || !influences.contains(inf))
        {
            return;
        }

        influences.remove(inf);
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
     * @param title
     *            the title to set
     */
    public void setTitle(final String title)
    {
        this.title = title;
    }

    /**
     * @return
     */
    public boolean hasAggregationAnnotation()
    {
        for (final Annotation ann : annotations)
        {
            if (ann.getKey().equals("aggregation"))
            {
                return true;
            }
        }

        return false;
    }

    /**
     * @return
     */
    public String getAggregationAnnotationValue()
    {
        for (final Annotation ann : annotations)
        {
            if (ann.getKey().equals("aggregation"))
            {
                return ann.getValue();
            }
        }

        return "";
    }

}
