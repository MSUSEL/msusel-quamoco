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
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * A manual instrument describes a manual way to collect the data for a measure.
 * This can, for example, be part of a code review.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ManualInstrument extends Instrument {

    /**
     * Optional title providing a more detailed name for this ManualInstrument
     */
    private String title;

    /**
     * Constructs an new ManualInstrument with the given name
     * 
     * @param metric
     *            The simple name of this instrument
     */
    public ManualInstrument(String metric)
    {
        super(metric);
    }

    /**
     * Constructs an new ManualInstrument with the given name and identifier.
     * 
     * @param metric
     *            The simple name of this instrument
     * @param identifier
     *            The unique identifier of this instrument
     */
    private ManualInstrument(String metric, String identifier)
    {
        super(metric, identifier);
    }

    /**
     * @return The title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title
     *            The new title of this ManualInstrument
     */
    public void setTitle(String title)
    {
        this.title = title;
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
                        "<measurementMethods xmi:id=\"%s\" xsi:type=\"%s\" description=\"%s\" originatesFrom=\"%s\" metric=\"%s\" determines=\"%s\"",
                        getIdentifier(), MeasurementMethodType.MANUAL_INSTRUMENT.type(),
                        StringEscapeUtils.escapeXml10(getDescription()), getOriginatesFrom().getQualifiedIdentifier(),
                        StringEscapeUtils.escapeXml10(getMetric()), getDetermines().getQualifiedIdentifier()));
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
     * Creates a new Builder for a Instrument with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the Instrument.Builder instance
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Builder for ManualInstruments implemented using the fluent interface and
     * method chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractInstrumentBuilder {

        /**
         * Constructs a new Builder for a Instrument with the given name
         * 
         * @param name
         *            The name of the instrument to construct
         */
        private Builder(String name)
        {
            element = new ManualInstrument(name);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
        public ManualInstrument create()
        {
            return (ManualInstrument) element;
        }

        /**
         * Sets the optional title of the ManualInstrument under construction
         * 
         * @param title
         *            Title of the ManualInstrument
         * @return this
         */
        @Nonnull
        public Builder title(String title)
        {
            ((ManualInstrument) element).setTitle(title);

            return this;
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
