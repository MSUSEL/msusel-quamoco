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

import java.util.List;

import org.eclipse.jdt.annotation.NonNull;

import com.google.common.collect.Lists;

/**
 * A tag is a keyword that can be added to model elements.
 * <br>
 * General Rules:
 * <ul>
 * <li>Tags can be assigned to various model elements (e.g. Entities, Factors,
 * or Measures).</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Tag extends QMElement {

    /**
     * Optional title providing a more detailed name for this Tag
     */
    private String          title;
    /**
     * List of QMElements marked by this Tag
     */
    private List<QMElement> usedBy;

    /**
     * Constructs a new instance of Tag
     * 
     * @param name
     *            name of the new Tag instance
     */
    private Tag(String name)
    {
        super(name);
        usedBy = Lists.newArrayList();
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
     *            The new title of this Tag
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * Add the given element as a user of this tag.
     * 
     * @param element
     *            Element using this Tag
     */
    public void addUsedBy(QMElement element)
    {
        if (element == null || usedBy.contains(element))
            return;

        usedBy.add(element);
    }

    /**
     * Remove the given element as a user of this tag
     * 
     * @param element
     *            Element no longer using this tag
     */
    public void removeUsedBy(QMElement element)
    {
        if (element == null || !usedBy.contains(element))
            return;

        usedBy.remove(element);
    }

    /**
     * @return The list of elements using this tag
     */
    public List<QMElement> getUsedBy()
    {
        return usedBy;
    }

    /**
     * Creates a new Builder for a Tag with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the Tag.Builder instance
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Builder for Tags implemented using the fluent interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * Tag element under construction
         */
        private Tag element;

        /**
         * Constructs a new Builder for a Tag with the given name
         * 
         * @param name
         *            The name of the tag to construct
         */
        private Builder(String name)
        {
            element = new Tag(name);
        }

        /**
         * @return The newly constructed Tag element
         */
        @NonNull
        public Tag create()
        {
            return (Tag) element;
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
         * Sets the optional title of the Tag under construction
         * 
         * @param title
         *            Title of the Tag
         * @return this
         */
        @NonNull
        public Builder title(String title)
        {
            element.setTitle(title);

            return this;
        }

        /**
         * Adds a User of the Tag under construction
         * 
         * @param user
         *            QMElement which is marked by this Tag
         * @return this
         */
        @NonNull
        public Builder usedBy(QMElement user)
        {
            element.addUsedBy(user);

            return this;
        }
    }
}
