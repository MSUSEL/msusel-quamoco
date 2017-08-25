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
     * Constructs an new ManualInstrument with the given name.
     */
    private ManualInstrument(String name)
    {
        super(name);
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
     * method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * ManualInstrument element under construction
         */
        private ManualInstrument element;

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
         * @return The newly constructed Instrument element
         */
        @NonNull
        public ManualInstrument create()
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
         * Sets the optional title of the ManualInstrument under construction
         * 
         * @param title
         *            Title of the ManualInstrument
         * @return this
         */
        @NonNull
        public Builder title(String title)
        {
            element.setTitle(title);

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
    }
}
