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
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

/**
 * Evaluation -
 *
 * @author Isaac Griffith
 */
@XStreamAlias("evaluations")
public class Evaluation extends AbstractQMEntity {

    @XStreamAlias("completeness")
    @XStreamAsAttribute
    private String              completeness;
    private Evaluates           evaluates;
    @XStreamAlias("maximumPoints")
    @XStreamAsAttribute
    private BigDecimal          maximumPoints;
    @XStreamAlias("specification")
    @XStreamAsAttribute
    private String              specification;
    @XStreamAsAttribute
    @XStreamAlias("xsi:type")
    private final String        type;
    @XStreamImplicit
    private final List<Ranking> rankings;

    /**
     *
     */
    public Evaluation(final String name, final String description, final String specification,
            final BigDecimal maximumPoints, final String completeness, final Evaluates evaluates, final String type,
            final String id)
    {
        if (name == null || name.isEmpty() || id == null || id.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        rankings = new ArrayList<>();
        this.name = name;
        this.description = description;
        this.specification = specification;
        this.completeness = completeness;
        this.evaluates = evaluates;
        this.maximumPoints = maximumPoints;
        this.type = type;
        this.id = id;
    }

    /**
     * @param rank
     */
    public void addRanking(final Ranking rank)
    {
        if (rank == null || rankings.contains(rank))
        {
            return;
        }

        rankings.add(rank);
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
        final Evaluation other = (Evaluation) obj;
        if (completeness == null)
        {
            if (other.completeness != null)
            {
                return false;
            }
        }
        else if (!completeness.equals(other.completeness))
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
        if (evaluates == null)
        {
            if (other.evaluates != null)
            {
                return false;
            }
        }
        else if (!evaluates.equals(other.evaluates))
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
        if (maximumPoints.compareTo(other.maximumPoints) != 0)
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
        if (specification == null)
        {
            if (other.specification != null)
            {
                return false;
            }
        }
        else if (!specification.equals(other.specification))
        {
            return false;
        }
        return true;
    }

    /**
     * @return the completeness
     */
    public String getCompleteness()
    {
        return completeness;
    }

    /**
     * @return the evaluates
     */
    public Evaluates getEvaluates()
    {
        return evaluates;
    }

    /**
     * @return the maximumPoints
     */
    public BigDecimal getMaximumPoints()
    {
        return maximumPoints;
    }

    /**
     * @return
     */
    public List<Ranking> getRankings()
    {
        return rankings;
    }

    /**
     * @return the specification
     */
    public String getSpecification()
    {
        return specification;
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
        result = prime * result + (completeness == null ? 0 : completeness.hashCode());
        result = prime * result + (description == null ? 0 : description.hashCode());
        result = prime * result + (evaluates == null ? 0 : evaluates.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (maximumPoints == null ? 0 : maximumPoints.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + (specification == null ? 0 : specification.hashCode());
        return result;
    }

    /**
     * @param rank
     */
    public void removeRanking(final Ranking rank)
    {
        if (rank == null || !rankings.contains(rank))
        {
            return;
        }

        rankings.remove(rank);
    }

    /**
     * @param completeness
     *            the completeness to set
     */
    public void setCompleteness(final String completeness)
    {
        this.completeness = completeness;
    }

    /**
     * @param evaluates
     *            the evaluates to set
     */
    public void setEvaluates(final Evaluates evaluates)
    {
        this.evaluates = evaluates;
    }

    /**
     * @param maximumPoints
     *            the maximumPoints to set
     */
    public void setMaximumPoints(final BigDecimal maximumPoints)
    {
        this.maximumPoints = maximumPoints;
    }

    /**
     * @param specification
     *            the specification to set
     */
    public void setSpecification(final String specification)
    {
        this.specification = specification;
    }

}
