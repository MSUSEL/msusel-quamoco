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
 * A metric based instrument is a concrete description how to collect the data
 * for a measure using a tool that calculates a numerical metric. Examples are
 * lines of code or clone coverage.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MetricBasedInstrument extends ToolBasedInstrument {

    /**
     * Use exactly the name and capitalizing of the metric as implemented in the
     * tool.
     */
    private String metric;

    /**
     * Constructs a new MetricBasedInstrument with the given name and associated
     * with the given tool.
     * 
     * @param name
     *            The name of this instrument
     * @param tool
     *            The tool associated with this instrument
     */
    public MetricBasedInstrument(String name, Tool tool)
    {
        super(name, tool);
    }

    /**
     * Sets the metric name associated with this instrument
     * 
     * @param metric
     *            The new metric
     */
    private void setMetric(String metric)
    {
        if (metric == null || metric.isEmpty())
            return;

        this.metric = metric;
    }

    /**
     * @return The metric name associated with this instrument
     */
    public String getMetric()
    {
        return metric;
    }

    /**
     * Creates a new Builder for a Instrument with the given simple name and
     * associated with the given tool.
     * 
     * @param name
     *            Simple Name
     * @param tool
     *            The tool associated with instrument under construction.
     * @return the Instrument.Builder instance
     */
    public static Builder builder(String name, Tool tool)
    {
        return new Builder(name, tool);
    }

    /**
     * Builder for Instruments implemented using the fluent interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * Instrument element under construction
         */
        private MetricBasedInstrument element;

        /**
         * Creates a new Builder for a Instrument with the given simple name and
         * associated with the given tool.
         * 
         * @param name
         *            Simple Name
         * @param tool
         *            The tool associated with instrument under construction.
         * @return the Instrument.Builder instance
         */
        private Builder(String name, Tool tool)
        {
            element = new MetricBasedInstrument(name, tool);
        }

        /**
         * @return The newly constructed Instrument element
         */
        @NonNull
        public MetricBasedInstrument create()
        {
            return element;
        }

        /**
         * Sets the element under construction's description
         * 
         * @param description
         *            the description to set
         * @return this
         */
        @NonNull
        public Builder description(String description)
        {
            element.setDescription(description);

            return this;
        }

        /**
         * Sets the element under construction's originatesFrom
         * 
         * @param originatesFrom
         *            the originatesFrom to set
         * @return this
         */
        public Builder originatesFrom(Source originatesFrom)
        {
            element.setOriginatesFrom(originatesFrom);

            return this;
        }

        /**
         * Sets the element under contruction's tagged by
         * 
         * @param taggedBy
         *            the taggedBy to set
         * @return this
         */
        @NonNull
        public Builder taggedBy(Tag taggedBy)
        {
            element.setTaggedBy(taggedBy);

            return this;
        }

        /**
         * Adds the given annotation to the element under construction.
         * 
         * @param ann
         *            Annotation to add
         * @return this
         */
        @NonNull
        public Builder annotation(Annotation ann)
        {
            element.addAnnotation(ann);

            return this;
        }

        /**
         * Sets the metric name of the Instrument under construction
         * 
         * @param metric
         *            Metric name
         * @return this
         */
        @NonNull
        public Builder metric(String metric)
        {
            element.setMetric(metric);

            return this;
        }

        /**
         * Sets the tool associated with the Instrument under construction
         * 
         * @param tool
         *            The tool
         * @return this
         */
        @NonNull
        public Builder tool(Tool tool)
        {
            element.setTool(tool);

            return this;
        }
    }
}
