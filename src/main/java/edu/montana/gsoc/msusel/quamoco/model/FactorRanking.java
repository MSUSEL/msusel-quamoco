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
package edu.montana.gsoc.msusel.quamoco.model;

import javax.annotation.Nonnull;

import edu.montana.gsoc.msusel.quamoco.io.RankingType;

/**
 * A class providing the ability to rank and weight the factors affecting the
 * evaluation of another Factor
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class FactorRanking extends QMElement implements Ranking {

    /**
     * Factor associated with this ranking
     */
    private Factor basedOn;
    /**
     * Rank associated with the measure or factor
     */
    private int    rank;
    /**
     * Weight associated with the measure or factor
     */
    private double weight;

    /**
     * Constructs a new Factor ranking
     */
    public FactorRanking()
    {
        super();
    }

    /**
     * @param identifier
     * @param factor
     */
    public FactorRanking(String identifier)
    {
        super(identifier);
    }

    /**
     * @return the factor
     */
    public Factor getFactor()
    {
        return basedOn;
    }

    /**
     * @param factor
     *            the factor to set
     */
    public void setFactor(Factor factor)
    {
        this.basedOn = factor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getRank()
    {
        return rank;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setRank(int rank)
    {
        this.rank = rank;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getWeight()
    {
        return weight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "<rankings xmi:id=\"%s\" xsi:type=\"%s\" factor=\"%s\" weight=\"%f\" rank=\"%d\" />%n",
                        getIdentifier(), RankingType.FACTOR_RANKING.type(), getFactor().getQualifiedIdentifier(),
                        getWeight(), getRank()));

        return builder.toString();
    }

    /**
     * Constructs and returns a new instance of a ranking builder
     * 
     * @return The ranking builder instance
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Constructs and returns a new instance of a ranking builder
     * 
     * @param identifier
     *            the unique identifier
     * @return The ranking builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder used to construct a ranking.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractQMElementBuilder {

        /**
         * Constructs a new Builder for a ranking for the given factor
         */
        public Builder()
        {
            element = new FactorRanking();
        }

        /**
         * Constructs a new Builder for a ranking for the given factor
         * 
         * @param identifier
         *            The unique identifier
         */
        public Builder(String identifier)
        {
            element = new FactorRanking(identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
        public FactorRanking create()
        {
            return (FactorRanking) element;
        }

        /**
         * Sets the rank of the ranking under construction to the given value
         * 
         * @param rank
         *            The rank
         * @return this
         */
        @Nonnull
        public Builder rank(int rank)
        {
            ((FactorRanking) element).setRank(rank);

            return this;
        }

        /**
         * Sets the weight of the ranking under construction to the given value
         * 
         * @param weight
         *            The weight
         * @return this
         */
        @Nonnull
        public Builder weight(double weight)
        {
            ((FactorRanking) element).setWeight(weight);

            return this;
        }

        @Nonnull
        public Builder basedOn(Factor factor)
        {
            ((FactorRanking) element).setFactor(factor);

            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getContributionPoints()
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setContributionPoints(double contPoints)
    {
        // TODO Auto-generated method stub

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toYaml()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toJson()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toScript()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
