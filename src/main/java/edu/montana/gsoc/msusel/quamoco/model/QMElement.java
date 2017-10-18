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
import java.util.UUID;

import javax.annotation.Nonnull;

import edu.montana.gsoc.msusel.quamoco.io.JsonSerializable;
import edu.montana.gsoc.msusel.quamoco.io.ScriptSerializable;
import edu.montana.gsoc.msusel.quamoco.io.XMLSerializable;
import edu.montana.gsoc.msusel.quamoco.io.YamlSerializable;

/**
 * Abstract base class of all QMElements. This class contains the basic pieces
 * of all QMElements.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class QMElement implements XMLSerializable, YamlSerializable, JsonSerializable, ScriptSerializable {

    protected String identifier;

    /**
     * Link to where the original information for this element can be found
     */
    protected Source           originatesFrom;
    /**
     * Tags for the element indicating additional information
     */
    protected List<Tag>        taggedBy;
    /**
     * List of annotations
     */
    protected List<Annotation> annotations;

    private String qualifiedIdentifier;

    /**
     * Constructs a new QMElement with a randomly generated UUID as its
     * identifier.
     */
    public QMElement()
    {
        identifier = UUID.randomUUID().toString();
    }

    /**
     * Constructs a new QMElement with the specified Unique Identifier already
     * assigned.
     * 
     * @param identifier
     *            The Unique Identifier of this element.
     */
    public QMElement(String identifier)
    {
        this.identifier = identifier;
    }

    /**
     * @return the element's originatesFrom
     */
    public Source getOriginatesFrom()
    {
        return originatesFrom;
    }

    /**
     * @param source
     *            the new source to add
     */
    public void setOriginatesFrom(Source source)
    {
        originatesFrom = source;
    }

    /**
     * @return the element's taggedBy
     */
    public List<Tag> getTaggedBy()
    {
        return taggedBy;
    }

    /**
     * @param taggedBy
     *            the new taggedBy to add
     */
    public void addTaggedBy(Tag tag)
    {
        if (tag == null || taggedBy.contains(tag))
            return;

        taggedBy.add(tag);
    }

    public void removeTaggedBy(Tag tag)
    {
        if (tag == null || !taggedBy.contains(tag))
            return;

        taggedBy.remove(tag);
    }

    /**
     * Adds the given annotation to this element, unless the given annotation is
     * null.
     * 
     * @param ann
     *            Annotation to add
     */
    public void addAnnotation(Annotation ann)
    {
        if (ann == null)
            return;

        annotations.add(ann);
    }

    public boolean hasAnnotations()
    {
        return !annotations.isEmpty();
    }

    public List<Annotation> getAnnotations()
    {
        return annotations;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier()
    {
        return identifier;
    }

    /**
     * @return the qualifiedIdentifier
     */
    public String getQualifiedIdentifier()
    {
        return qualifiedIdentifier;
    }

    public void updateQualifiedIdentifier(QualityModel owner)
    {
        if (owner != null)
            qualifiedIdentifier = owner.getFileName() + identifier;
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
        QMElement other = (QMElement) obj;
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
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString()
    {
        return String.format("%s [identifier=%s]", this.getClass().getSimpleName(), identifier);
    }

    public abstract String xmlTag();

    /**
     * Base Builder for QMElements implemented using the fluent interface
     * and method chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static abstract class AbstractQMElementBuilder {

        protected QMElement element;

        /**
         * @return The newly constructed ProductPart element
         */
        @Nonnull
        public abstract QMElement create();

        /**
         * Sets the element under construction's originatesFrom
         * 
         * @param originatesFrom
         *            the originatesFrom to set
         * @return this
         */
        public AbstractQMElementBuilder originatesFrom(Source originatesFrom)
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
        @Nonnull
        public AbstractQMElementBuilder taggedBy(Tag taggedBy)
        {
            element.addTaggedBy(taggedBy);

            return this;
        }

        /**
         * Adds the given annotation to the element under construction.
         * 
         * @param ann
         *            Annotation to add
         * @return this
         */
        @Nonnull
        public AbstractQMElementBuilder annotation(Annotation ann)
        {
            element.addAnnotation(ann);

            return this;
        }

    }
}
