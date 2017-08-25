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
package edu.montana.gsoc.msusel.quamoco.model.qm2;

import org.eclipse.jdt.annotation.NonNull;

/**
 * A class providing the ability to rank and weight the factors affecting the
 * evaluation of another Factor
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class FactorRanking extends Ranking {

    /**
     * Factor associated with this ranking
     */
    private Factor factor;

    /**
     * Constructs a new Factor ranking
     * 
     * @param factor
     *            The factor for which this is a ranking
     */
    public FactorRanking(Factor factor)
    {
        super();
        this.factor = factor;
    }

    /**
     * @return the factor
     */
    public Factor getFactor()
    {
        return factor;
    }

    /**
     * @param factor
     *            the factor to set
     */
    public void setFactor(Factor factor)
    {
        this.factor = factor;
    }

    /**
     * Constructs and returns a new instance of a ranking builder
     * 
     * @param factor
     *            The factor for the ranking
     * @return The ranking builder instance
     */
    public static Builder builder(Factor factor)
    {
        return new Builder(factor);
    }

    /**
     * Builder used to construct a ranking.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * The ranking under construction
         */
        private FactorRanking ranking;

        /**
         * Constructs a new Builder for a ranking for the given factor
         * 
         * @param factor
         *            The factor
         */
        public Builder(Factor factor)
        {
            ranking = new FactorRanking(factor);
        }

        /**
         * @return The instance under construction
         */
        public FactorRanking create()
        {
            return ranking;
        }

        /**
         * Sets the rank of the ranking under construction to the given value
         * 
         * @param rank
         *            The rank
         * @return this
         */
        @NonNull
        public Builder rank(int rank)
        {
            ranking.setRank(rank);

            return this;
        }

        /**
         * Sets the weight of the ranking under construction to the given value
         * 
         * @param weight
         *            The weight
         * @return this
         */
        @NonNull
        public Builder weight(double weight)
        {
            ranking.setWeight(weight);

            return this;
        }
    }
}
