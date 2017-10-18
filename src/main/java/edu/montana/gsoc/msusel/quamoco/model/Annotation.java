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

import java.util.UUID;

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringEscapeUtils;

import edu.montana.gsoc.msusel.quamoco.io.XMLSerializable;

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
public class Annotation implements XMLSerializable {

    /**
     * The key has to be unique for the current model element.
     */
    private String key;
    /**
     * The value can be any text describing the facts for the particular key.
     */
    private String value;
    /**
     * A unique identifier for this annotation
     */
    private String identifier;

    public Annotation()
    {
        this(null, null);
    }

    public Annotation(String identifier)
    {
        this(identifier, null, null);
    }

    public Annotation(String key, String value)
    {
        identifier = UUID.randomUUID().toString();
        this.key = key;
        this.value = value;
    }

    public Annotation(String identifier, String key, String value)
    {
        this.identifier = identifier;
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
     * @return the identifier
     */
    public String getIdentifier()
    {
        return identifier;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        result = prime * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Annotation other = (Annotation) obj;
        if (identifier == null)
        {
            if (other.identifier != null)
            {
                return false;
            }
        }
        else if (!identifier.equals(other.identifier))
        {
            return false;
        }
        if (key == null)
        {
            if (other.key != null)
            {
                return false;
            }
        }
        else if (!key.equals(other.key))
        {
            return false;
        }
        if (value == null)
        {
            if (other.value != null)
            {
                return false;
            }
        }
        else if (!value.equals(other.value))
        {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return String.format("Annotation [key=%s, value=%s, identifier=%s]", key, value, identifier);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        StringBuilder builder = new StringBuilder();
        
        builder.append(String.format(
                "<annotations xmi:id=\"%s\" key=\"%s\" value=\"%s\" />\n", getIdentifier(), 
                StringEscapeUtils.escapeXml10(getKey()), StringEscapeUtils.escapeXml10(getValue())));
        
        return builder.toString();
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
     * Creates a new Builder for an Annotation
     * 
     * @param identifier
     *            The unique identifier of this annotation
     * @return the Annotation.Builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
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
         * Constructs a new Builder for an Annotation with the given unique
         * identifier
         * 
         * @param identifier
         *            Unique identifier
         */
        private Builder(String identifier)
        {
            element = new Annotation();
        }

        /**
         * @return The newly constructed Annotation element
         */
        @Nonnull
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
        @Nonnull
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
