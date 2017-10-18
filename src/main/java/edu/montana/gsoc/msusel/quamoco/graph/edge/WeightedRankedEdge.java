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

import edu.montana.gsoc.msusel.quamoco.processor.LinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

/**
 * Abstract base edge type for edges which have both a weight and a rank.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class WeightedRankedEdge extends AbstractEdge implements WeightedEdge, RankedEdge {

    /**
     * Weight applied to the input value
     */
    protected BigDecimal         weight;
    /**
     * Lower bound on proportion (0.0 to 1.0)
     */
    protected BigDecimal         lowerBound;
    /**
     * Upper bound on proportion (0.0 to 1.0)
     */
    protected BigDecimal         upperBound;
    /**
     * Flag indicating that a linear distribution should be applied to the
     * value.
     */
    protected boolean            usesLinearDist;
    /**
     * Linear distribution to use if usesLinearDist is true
     */
    protected LinearDistribution dist;
    /**
     * Maximum points
     */
    protected BigDecimal         maxPoints;
    /**
     * Rank of the source in the evaluation of the dest
     */
    protected BigDecimal         rank;
    /**
     * Flag indicating that the rank has been set
     */
    private boolean              rankSet   = false;
    /**
     * Flag indicating that the weight has been set
     */
    private boolean              weightSet = false;

    /**
     * Constructs a new WeightedRankedEdge with the given name connecting the
     * source and dest nodes. Initially the weight is 1.0 and rank is 0.
     * MaxPoints is set to the default of 100 and upperbound is set to 1.0 while
     * lowerbound is set to 0.0
     * 
     * @param name
     *            Name of this edge
     * @param src
     *            Source node
     * @param dest
     *            Dest node
     */
    public WeightedRankedEdge(final String name, final Node src, final Node dest)
    {
        super(name, src, dest);
        weight = BigDecimal.ONE;
        lowerBound = BigDecimal.ZERO;
        upperBound = BigDecimal.ONE;
        maxPoints = new BigDecimal(100);
        rank = BigDecimal.ZERO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getLowerBound()
    {
        return lowerBound;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getUpperBound()
    {
        return upperBound;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLowerBound(final BigDecimal lowerBound)
    {
        if (upperBound.compareTo(lowerBound) < 0)
        {
            throw new IllegalArgumentException(
                    "Value of upperbound: " + upperBound + " cannot be less than value of lowerbound: " + lowerBound);
        }

        this.lowerBound = lowerBound;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUpperBound(final BigDecimal upperBound)
    {
        if (upperBound.compareTo(lowerBound) < 0)
        {
            throw new IllegalArgumentException(
                    "Value of upperbound: " + upperBound + " cannot be less than value of lowerbound: " + lowerBound);
        }

        this.upperBound = upperBound;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWeight(final BigDecimal weight)
    {
        if (weight.compareTo(BigDecimal.ZERO) < 0)
        {
            throw new IllegalArgumentException("Value of weight cannot be less than 0.0.");
        }
        if (weight.compareTo(BigDecimal.ONE) > 0)
        {
            throw new IllegalArgumentException("Value of weight cannot be greater than 1.0.");
        }

        if (weightSet)
            return;

        this.weight = weight;
        weightSet = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNormalizer(final Normalizer normalizer)
    {
        norm = normalizer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getWeight()
    {
        return weight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isUsesLinearDist()
    {
        return usesLinearDist;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUsesLinearDist(final boolean usesLinearDist)
    {
        this.usesLinearDist = usesLinearDist;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LinearDistribution getDist()
    {
        return dist;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDist(final LinearDistribution dist)
    {
        this.dist = dist;

        if (dist == null)
            setUsesLinearDist(false);
        else
            setUsesLinearDist(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getMaxPoints()
    {
        return maxPoints;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxPoints(final BigDecimal maxPoints)
    {
        if (maxPoints.compareTo(BigDecimal.ZERO) < 0)
        {
            throw new IllegalArgumentException("Value of maximum points cannot be less than 0");
        }

        this.maxPoints = maxPoints;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalizer getNormalizer()
    {
        return norm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRank(BigDecimal rank)
    {
        if (rank == null)
            return;

        if (rankSet)
        {
            System.out.println("Trying to set the rank twice");
            return;
        }

        this.rank = rank;
        rankSet = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getRank()
    {
        return rank;
    }
}
