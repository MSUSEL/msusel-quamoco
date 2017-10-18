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

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;

/**
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class FormBasedMeasureAggregation extends MeasureAggregation {

    protected List<Measure> aggregates;

    /**
     * 
     */
    public FormBasedMeasureAggregation()
    {
        super();
        aggregates = Lists.newArrayList();
    }

    public FormBasedMeasureAggregation(String identifier)
    {
        super(identifier);
        aggregates = Lists.newArrayList();
    }

    public void addAggregate(Measure aggr)
    {
        if (aggr == null || aggregates.contains(aggr))
            return;

        aggregates.add(aggr);
    }

    public void removeAggregate(Measure aggr)
    {
        if (aggr == null || !aggregates.contains(aggr))
        {
            return;
        }

        aggregates.remove(aggr);
    }

    public List<Measure> getAggregates()
    {
        return aggregates;
    }

    /**
     * Base Builder class for FormBasedMesureAggregations which uses the Fluent
     * Interface and Method Chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public abstract static class AbstractFormBasedMeasureAggregationBuilder extends AbstractMeasureAggregationBuilder {

        /**
         * Adds a measure for aggregation to the
         * FindingsIntersectionMeasureAggregation
         * 
         * @param measure
         *            The measure to add to the list of aggregates for the
         *            FindingsIntersectionMeasureAggregation under construction.
         * @return this
         */
        @Nonnull
        public AbstractFormBasedMeasureAggregationBuilder aggregates(Measure measure)
        {
            ((FormBasedMeasureAggregation) element).addAggregate(measure);

            return this;
        }
    }
}
