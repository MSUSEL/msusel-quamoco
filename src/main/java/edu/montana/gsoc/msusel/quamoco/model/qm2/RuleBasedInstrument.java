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

import edu.montana.gsoc.msusel.quamoco.model.qm2.MetricBasedInstrument.Builder;

/**
 * A rule based instrument is a concrete description how to collect the data for
 * a measure using a tool that checks rules which have an unique identifier.
 * Examples for such tools are static analysis tools (e.g., FindBugs or
 * Gendarme).
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class RuleBasedInstrument extends ToolBasedInstrument {

    /**
     * Use exactly the name and capitalizing of the rule as implemented in the
     * tool.
     */
    private String rule;

    /**
     * Constructs a new RuleBasedInstrument with the given name and associated
     * with the given tool.
     * 
     * @param name
     *            The name of the instrument
     * @param tool
     *            The tool associated with the instrument
     */
    public RuleBasedInstrument(String name, Tool tool)
    {
        super(name, tool);
    }

    /**
     * Sets the rule associated with this instrument
     * 
     * @param rule
     *            The new rule
     */
    private void setRule(String rule)
    {
        if (rule == null || rule.isEmpty())
            return;

        this.rule = rule;
    }

    /**
     * @return The rule associated with this instrument
     */
    public String getRule()
    {
        return rule;
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
        private RuleBasedInstrument element;

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
            element = new RuleBasedInstrument(name, tool);
        }

        /**
         * @return The newly constructed Instrument element
         */
        @NonNull
        public Instrument create()
        {
            return (Instrument) element;
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
         * Sets the rule for the instrument under construction
         * 
         * @param rule
         *            The rule name associated with the instrument under
         *            construction
         * @return this
         */
        @NonNull
        public Builder rule(String rule)
        {
            element.setRule(rule);

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
