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
 * A tool is a software program, which is used to collect measurement data. This
 * can be, for example, a static analysis tool.
 * <br>
 * General Rules
 * <ul>
 * <li>Describe the used tool as precisely as possible.</li>
 * <li>You can create different tools for different tool versions, if
 * necessary.</li>
 * <li>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Tool extends QMElement {

    private String name;
    private String description;

    /**
     * Optional title providing a more detailed name than the simple name field
     */
    private String title;

    /**
     * Constructs a new instance of Tool
     * 
     * @param name
     *            name of the new Tool instance
     */
    public Tool(String name)
    {
        super();
        this.name = name;
    }

    /**
     * Constructs a new instance of Tool
     * 
     * @param name
     *            name of the new Tool instance
     * @param identifier
     *            unique identifier of this tool
     */
    public Tool(String name, String identifier)
    {
        super(identifier);
        this.name = name;
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
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(
                String.format(
                        "<tools xmi:id=\"%s\" title=\"%s\" description=\"%s\" name=\"%s\" originatesFrom=\"%s\"",
                        getIdentifier(), StringEscapeUtils.escapeXml10(getTitle()),
                        StringEscapeUtils.escapeXml10(getDescription()), StringEscapeUtils.escapeXml10(getName()),
                        getOriginatesFrom().getQualifiedIdentifier()));
        if (hasAnnotations())
        {
            builder.append(">\n");
            annotations.forEach((ann) -> {
                builder.append(ann.xmlTag());
            });
            builder.append("</tools>\n");
        }
        else
        {
            builder.append("/>\n");
        }
        
        return builder.toString();
    }

    /**
     * Creates a new Builder for a Tool with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the Tool.Builder instance
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Creates a new Builder for a Tool with the given simple name and unique
     * identifier
     * 
     * @param name
     *            Simple Name
     * @param identifier
     *            Unique identifier
     * @return the Tool.Builder instance
     */
    public static Builder builder(String name, String identifier)
    {
        return new Builder(name, identifier);
    }

    /**
     * Builder for Tools implemented using the fluent interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractQMElementBuilder {

        /**
         * Constructs a new Builder for a Tool with the given name
         * 
         * @param name
         *            The name of the tool to construct
         */
        private Builder(String name)
        {
            element = new Tool(name);
        }

        /**
         * Constructs a new Builder for a Tool with the given name
         * 
         * @param name
         *            The name of the tool to construct
         * @param identifier
         *            The identifier of the tool to construct
         */
        private Builder(String name, String identifier)
        {
            element = new Tool(name, identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
        public Tool create()
        {
            return (Tool) element;
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
            ((Tool) element).setDescription(description);

            return this;
        }

        /**
         * Sets the optional title of the Tool under construction
         * 
         * @param title
         *            Title of the Tool
         * @return this
         */
        @Nonnull
        public Builder title(String title)
        {
            ((Tool) element).setTitle(title);

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
