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
 * A class to provide the capability to rank and weight the evaluation of
 * measures which affect a factor.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MeasureRanking extends Ranking {

    /**
     * Measure associated with this ranking
     */
    private Measure            measure;
    /**
     * Normalization measure used to normalize the findings of the associated
     * measure
     */
    private Measure            normalizationMeasure;
    /**
     * Normalization range applicable to normalizing findings of the associated
     * measure
     */
    private NormalizationRange range;
    /**
     * Function used to determine the effect of the measure associated with this
     * ranking
     */
    private Function           function;

    /**
     * Constructs a new Ranking for the given measure
     * 
     * @param measure
     *            The measure
     */
    public MeasureRanking(Measure measure)
    {
        super();
        this.measure = measure;
    }

    /**
     * @return the measure
     */
    public Measure getMeasure()
    {
        return measure;
    }

    /**
     * @param measure
     *            the measure to set
     */
    public void setMeasure(Measure measure)
    {
        this.measure = measure;
    }

    /**
     * @return the normalizationMeasure
     */
    public Measure getNormalizationMeasure()
    {
        return normalizationMeasure;
    }

    /**
     * @param normalizationMeasure
     *            the normalizationMeasure to set
     */
    public void setNormalizationMeasure(Measure normalizationMeasure)
    {
        this.normalizationMeasure = normalizationMeasure;
    }

    /**
     * @return the range
     */
    public NormalizationRange getRange()
    {
        return range;
    }

    /**
     * @param range
     *            the range to set
     */
    public void setRange(NormalizationRange range)
    {
        this.range = range;
    }

    /**
     * @return the function
     */
    public Function getFunction()
    {
        return function;
    }

    /**
     * @param function
     *            the function to set
     */
    public void setFunction(Function function)
    {
        this.function = function;
    }

    /**
     * Constructs and returns a new instance of a ranking builder
     * 
     * @param measure
     *            The measure this ranking is for
     * @return The ranking builder instance
     */
    public static Builder builder(Measure measure)
    {
        return new Builder(measure);
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
        private MeasureRanking ranking;

        /**
         * Constructs a new Builder for a ranking of the given measure
         * 
         * @param measure
         *            The measure
         */
        public Builder(Measure measure)
        {
            ranking = new MeasureRanking(measure);
        }

        /**
         * @return The instance under construction
         */
        public MeasureRanking create()
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

        /**
         * Sets the function associated with the measure
         * 
         * @param function
         *            Linear Distribution function
         * @return this
         */
        @NonNull
        public Builder function(Function function)
        {
            ranking.setFunction(function);

            return this;
        }

        /**
         * Sets the normalization measure of the ranking
         * 
         * @param norm
         *            NormalizationMeasure
         * @return this
         */
        @NonNull
        public Builder normalizer(NormalizationMeasure norm)
        {
            ranking.setNormalizationMeasure(norm);

            return this;
        }

        /**
         * Sets the normalization range of the ranking
         * 
         * @param range
         *            The Range
         * @return this
         */
        @NonNull
        public Builder range(NormalizationRange range)
        {
            ranking.setRange(range);

            return this;
        }
    }
}
