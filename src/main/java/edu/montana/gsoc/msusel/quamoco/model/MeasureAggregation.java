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

/**
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class MeasureAggregation extends MeasurementMethod {

    protected String description;
    protected String title;

    /**
     * 
     */
    public MeasureAggregation()
    {
        super(null);
    }

    /**
     * @param identifier
     */
    public MeasureAggregation(String identifier)
    {
        super(null, identifier);
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String generateXMLTag(String type)
    {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "<measurementMethods xmi:id=\"%s\" xsi:type=\"%s\" description=\"%s\" originatesFrom=\"%s\" tool=\"%s\" determines=\"%s\"",
                        getIdentifier(), type, StringEscapeUtils.escapeXml10(getDescription()),
                        getOriginatesFrom().getQualifiedIdentifier(),
                        getDetermines().getQualifiedIdentifier()));
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
     * Base Builder for MeasureAggregations which uses the Fluent Interface and
     * Method Chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public abstract static class AbstractMeasureAggregationBuilder extends AbstractMeasurementMethodBuilder {

        @Nonnull
        public AbstractMeasureAggregationBuilder title(String title)
        {
            ((MeasureAggregation) element).setTitle(title);

            return this;
        }

        @Nonnull
        public AbstractMeasureAggregationBuilder description(String desc)
        {
            ((MeasureAggregation) element).setDescription(desc);

            return this;
        }
    }
}
