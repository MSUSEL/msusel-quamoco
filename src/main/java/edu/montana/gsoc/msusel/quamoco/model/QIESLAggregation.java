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

import org.apache.commons.lang3.StringEscapeUtils;

import edu.montana.gsoc.msusel.quamoco.io.MeasurementMethodType;

/**
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class QIESLAggregation extends TextAggregation {

    /**
     * /**
     * Constructs a new QIESLAggregation.
     */
    public QIESLAggregation()
    {
        super();
    }

    /**
     * Constructs a new QIESLAggregation with the given unique
     * identifier.
     * 
     * @param identifier
     *            The unique identifier
     */
    public QIESLAggregation(String identifier)
    {
        super(identifier);
    }

    /**
     * Creates a new Builder for a TextAggregation
     * 
     * @return the TextAggregation.Builder instance
     */
    public static QIESLAggregationBuilder builder()
    {
        return new QIESLAggregationBuilder();
    }

    /**
     * Creates a new Builder for a TextAggregation with the
     * given unique identifier
     * 
     * @param identifier
     *            The unique identifier
     * @return the TextAggregation.Builder instance
     */
    public static QIESLAggregationBuilder builder(String identifier)
    {
        return new QIESLAggregationBuilder(identifier);
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
                        "<measurementMethods xmi:id=\"%s\" xsi:type=\"%s\" description=\"%s\" originatesFrom=\"%s\" tool=\"%s\" specification=\"%s\" determines=\"%s\"",
                        getIdentifier(), MeasurementMethodType.QIESL_AGGREGATION.type(),
                        StringEscapeUtils.escapeXml10(getDescription()), getOriginatesFrom().getQualifiedIdentifier(),
                        StringEscapeUtils.escapeXml10(getSpecification()), getDetermines().getQualifiedIdentifier()));
        if (hasAnnotations())
        {
            builder.append(">\n");
            annotations.forEach((ann) -> builder.append(ann.xmlTag()));
            builder.append("</measurementMethods>\n");
        }
        else
        {
            builder.append(" />\n");
        }

        return builder.toString();
    }

    /**
     * Builder for TextAggregations implemented using the fluent
     * interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class QIESLAggregationBuilder extends TextAggregationBuilder {

        /**
         * Constructs a new Builder for a TextAggregation
         */
        private QIESLAggregationBuilder()
        {
            super();
            element = new QIESLAggregation();
        }

        /**
         * Constructs a new Builder for a TextAggregation with
         * the given unique identifier
         * 
         * @param name
         *            The unique identifier
         */
        private QIESLAggregationBuilder(String identifier)
        {
            super(identifier);
            element = new QIESLAggregation(identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
        public QIESLAggregation create()
        {
            return (QIESLAggregation) element;
        }
    }
}
