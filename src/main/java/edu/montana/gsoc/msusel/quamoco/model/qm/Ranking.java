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
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Ranking -
 *
 * @author Isaac Griffith
 */
@XStreamAlias("rankings")
public class Ranking extends AbstractQMEntity {

    private FactorLink           factor;
    private MeasureLink          measure;
    private NormalizationMeasure normalizationMeasure;
    @XStreamAlias("range")
    @XStreamAsAttribute
    private NormalizationRange   range;
    @XStreamAlias("rank")
    @XStreamAsAttribute
    private String               rank;
    @XStreamAlias("weight")
    @XStreamAsAttribute
    private String               weight;
    private Function             function;
    @XStreamOmitField
    private String               ownerId;

    /**
     *
     */
    public Ranking(final String rank, final String range, final String weight, final MeasureLink measure,
            final FactorLink factor, final NormalizationMeasure normalizationMeasure, final String ownerId,
            final String id)
    {
        if (ownerId == null || ownerId.isEmpty() || id == null || id.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.rank = rank;
        this.range = range == null ? NormalizationRange.NA : NormalizationRange.valueOf(range.toUpperCase());
        this.measure = measure;
        this.weight = weight;
        this.factor = factor;
        this.normalizationMeasure = normalizationMeasure;
        this.id = id;
        this.ownerId = ownerId;
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
        final Ranking other = (Ranking) obj;
        if (factor == null)
        {
            if (other.factor != null)
            {
                return false;
            }
        }
        else if (!factor.equals(other.factor))
        {
            return false;
        }

        if (function == null)
        {
            if (other.function != null)
            {
                return false;
            }
        }
        else if (!function.equals(other.function))
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
        if (measure == null)
        {
            if (other.measure != null)
            {
                return false;
            }
        }
        else if (!measure.equals(other.measure))
        {
            return false;
        }

        if (normalizationMeasure == null)
        {
            if (other.normalizationMeasure != null)
            {
                return false;
            }
        }
        else if (!normalizationMeasure.equals(other.normalizationMeasure))
        {
            return false;
        }

        if (ownerId == null)
        {
            if (other.ownerId != null)
            {
                return false;
            }
        }
        else if (!ownerId.equals(other.ownerId))
        {
            return false;
        }
        if (range == null)
        {
            if (other.range != null)
            {
                return false;
            }
        }
        else if (!range.equals(other.range))
        {
            return false;
        }
        if (rank == null)
        {
            if (other.rank != null)
            {
                return false;
            }
        }
        else if (!rank.equals(other.rank))
        {
            return false;
        }
        if (weight == null)
        {
            if (other.weight != null)
            {
                return false;
            }
        }
        else if (!weight.equals(other.weight))
        {
            return false;
        }
        return true;
    }

    /**
     * @return the factor
     */
    public FactorLink getFactor()
    {
        return factor;
    }

    /**
     * @return the function
     */
    public Function getFunction()
    {
        return function;
    }

    /**
     * @return the id
     */
    /**
     * {@inheritDoc}
     */
    @Override
    public String getId()
    {
        return id;
    }

    /**
     * @return the measure
     */
    public MeasureLink getMeasure()
    {
        return measure;
    }

    /**
     * @return the normalizationMeasure
     */
    public NormalizationMeasure getNormalizationMeasure()
    {
        return normalizationMeasure;
    }

    /**
     * @return the ownerId
     */
    public String getOwnerId()
    {
        return ownerId;
    }

    /**
     * @return the range
     */
    public NormalizationRange getRange()
    {
        return range;
    }

    /**
     * @return the rank
     */
    public String getRank()
    {
        return rank;
    }

    /**
     * @return the weight
     */
    public String getWeight()
    {
        return weight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + (factor == null ? 0 : factor.hashCode());
        result = prime * result + (function == null ? 0 : function.hashCode());
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (measure == null ? 0 : measure.hashCode());
        result = prime * result + (normalizationMeasure == null ? 0 : normalizationMeasure.hashCode());
        result = prime * result + (ownerId == null ? 0 : ownerId.hashCode());
        result = prime * result + (range == null ? 0 : range.hashCode());
        result = prime * result + (rank == null ? 0 : rank.hashCode());
        result = prime * result + (weight == null ? 0 : weight.hashCode());
        return result;
    }

    /**
     * @param factor
     *            the factor to set
     */
    public void setFactor(final FactorLink factor)
    {
        if (factor != null)
        {
            measure = null;
        }

        this.factor = factor;
    }

    /**
     * @param function
     *            the function to set
     */
    public void setFunction(final Function function)
    {
        this.function = function;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(final String id)
    {
        if (id == null || id.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.id = id;
    }

    /**
     * @param measure
     *            the measure to set
     */
    public void setMeasure(final MeasureLink measure)
    {
        if (measure != null)
        {
            factor = null;
        }

        this.measure = measure;
    }

    /**
     * @param normalizationMeasure
     *            the normalizationMeasure to set
     */
    public void setNormalizationMeasure(final NormalizationMeasure normalizationMeasure)
    {
        this.normalizationMeasure = normalizationMeasure;
    }

    /**
     * @param ownerId
     *            the ownerId to set
     */
    public void setOwnerId(final String ownerId)
    {
        if (ownerId == null || ownerId.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.ownerId = ownerId;
    }

    /**
     * @param range
     *            the range to set
     */
    public void setRange(final String range)
    {
        this.range = NormalizationRange.valueOf(range);
    }

    /**
     * @param rank
     *            the rank to set
     */
    public void setRank(final String rank)
    {
        this.rank = rank;
    }

    /**
     * @param weight
     *            the weight to set
     */
    public void setWeight(final String weight)
    {
        this.weight = weight;
    }

}
