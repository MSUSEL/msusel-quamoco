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

import edu.montana.gsoc.msusel.quamoco.io.MeasurementMethodType;

/**
 * Indicates that the measure should aggregate incoming finding sets using
 * the union operator
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class FindingsUnionMeasureAggregation extends FormBasedMeasureAggregation {

    /**
     * Constructs a new FindingsUnionMeasureAggregation.
     */
    public FindingsUnionMeasureAggregation()
    {
        super();
    }

    /**
     * Constructs a new FindingsUnionMeasureAggregation with the given unique
     * identifier.
     * 
     * @param identifier
     *            The unique identifier
     */
    public FindingsUnionMeasureAggregation(String identifier)
    {
        super(identifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        return generateXMLTag(MeasurementMethodType.FINDINGS_UNION_MEASURE_AGGREGATION.type());
    }

    /**
     * Creates a new Builder for a FindingsUnionMeasureAggregation
     * 
     * @return the FindingsUnionMeasureAggregation.Builder instance
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Creates a new Builder for a FindingsUnionMeasureAggregation with the
     * given unique identifier
     * 
     * @param identifier
     *            The unique identifier
     * @return the FindingsUnionMeasureAggregation.Builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder for FindingsUnionMeasureAggregations implemented using the fluent
     * interface and method chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractFormBasedMeasureAggregationBuilder {

        /**
         * Constructs a new Builder for a FindingsUnionMeasureAggregation
         */
        private Builder()
        {
            element = new FindingsUnionMeasureAggregation();
        }

        /**
         * Constructs a new Builder for a FindingsUnionMeasureAggregation with
         * the given unique identifier
         * 
         * @param name
         *            The unique identifier
         */
        private Builder(String identifier)
        {
            element = new FindingsUnionMeasureAggregation(identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
        public FindingsUnionMeasureAggregation create()
        {
            return (FindingsUnionMeasureAggregation) element;
        }
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
