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
 * All model elements can be labeled with any number of annotations. An
 * annotation is a pair of a key with a corresponding value.
 * <br>
 * General Rules
 * <ul>
 * <li>Use annotations only if there is no suitable attribute available for this
 * purpose.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Annotation {

    /**
     * The key has to be unique for the current model element.
     */
    private String key;
    /**
     * The value can be any text describing the facts for the particular key.
     */
    private String value;

    public Annotation()
    {
        this(null, null);
    }

    public Annotation(String key, String value)
    {
        this.key = key;
        this.value = value;
    }

    /**
     * @return the key
     */
    public String getKey()
    {
        return key;
    }

    /**
     * @param key
     *            the key to set
     */
    public void setKey(String key)
    {
        this.key = key;
    }

    /**
     * @return the value
     */
    public String getValue()
    {
        return value;
    }

    /**
     * @param value
     *            the value to set
     */
    public void setValue(String value)
    {
        this.value = value;
    }

    /**
     * Creates a new Builder for an Annotation
     * 
     * @return the Annotation.Builder instance
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Builder for Annotations implemented using the fluent interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * Annotation element under construction
         */
        private Annotation element;

        /**
         * Constructs a new Builder for an Annotation
         */
        private Builder()
        {
            element = new Annotation();
        }

        /**
         * @return The newly constructed Annotation element
         */
        @NonNull
        public Annotation create()
        {
            return (Annotation) element;
        }

        /**
         * Sets the Annotation under construction's value
         * 
         * @param value
         *            the value
         * @return this
         */
        @NonNull
        public Builder value(String value)
        {
            element.setValue(value);

            return this;
        }

        /**
         * Sets the Annotation under construction's key
         * 
         * @param key
         *            the key
         * @return this
         */
        public Builder key(String key)
        {
            element.setKey(key);

            return this;
        }
    }
}
