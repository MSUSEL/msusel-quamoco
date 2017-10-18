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

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringEscapeUtils;

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
    private String title;
    private String description;
    private String name;

    /**
     * Constructs a new instance of Tag
     * 
     * @param name
     *            name of the new Tag instance
     */
    private Tag(String name)
    {
        super();
        this.name = name;
    }

    /**
     * Constructs a new instance of Tag
     * 
     * @param name
     *            name of the new Tag instance
     * @param identifier
     *            the unique identifier
     */
    public Tag(String name, String identifier)
    {
        super(identifier);
        this.name = name;
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
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Tag> getTaggedBy()
    {
        return Lists.newArrayList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTaggedBy(Tag tag)
    {
        return;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeTaggedBy(Tag tag)
    {
        return;
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
     * Creates a new Builder for a Tag with the given simple name
     * 
     * @param name
     *            Simple Name
     * @param identifier
     *            The unique identifier
     * @return the Tag.Builder instance
     */
    public static Builder builder(String name, String identifier)
    {
        return new Builder(name, identifier);
    }

    /**
     * Builder for Tags implemented using the fluent interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractQMElementBuilder {

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
         * Constructs a new Builder for a Tag with the given name
         * 
         * @param name
         *            The name of the tag to construct
         * @param identifier
         *            the unique identifier
         */
        private Builder(String name, String identifier)
        {
            element = new Tag(name, identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
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
        @Nonnull
        public Builder description(String description)
        {
            ((Tag) element).setDescription(description);

            return this;
        }

        /**
         * Sets the optional title of the Tag under construction
         * 
         * @param title
         *            Title of the Tag
         * @return this
         */
        @Nonnull
        public Builder title(String title)
        {
            ((Tag) element).setTitle(title);

            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append(String.format(
                    "<tags xmi:id=\"%s\" name=\"%s\" description=\"%s\" />%n", getIdentifier(), StringEscapeUtils.escapeXml10(getName()),
                    StringEscapeUtils.escapeXml10(getDescription())));
        
        return builder.toString();
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
