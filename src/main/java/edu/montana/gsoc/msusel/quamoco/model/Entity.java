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
 * An entity is a type of an element that is part of the software product, its
 * environment, or which is a resource required during development, maintenance,
 * or use of a software product.
 * <br>
 * General Rules
 * <ul>
 * <li>Use nouns to describe Entities.</li>
 * <li>Use entities to model the parts of the software product that are subject
 * of a quality need.</li>
 * <li>If there is no specific reason to do otherwise, only capitalize the first
 * word in the name.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class Entity extends QMElement {

    protected String       name;
    protected String       title;
    protected String       description;
    /**
     * List of entities which are children of this Entity
     */
    protected List<Entity> isAs;
    /**
     * Entity of which this entity is a part
     */
    protected Entity       partOf;

    /**
     * Constructs a new Entity with the given name
     * 
     * @param name
     *            The name of the Entity
     */
    public Entity(String name)
    {
        super();
        this.name = name;
        isAs = Lists.newArrayList();
    }

    /**
     * Constructs a new Entity with the given name and identifier
     * 
     * @param name
     *            The name of the entity
     * @param identifier
     *            The unique identifier of this entity
     */
    public Entity(String name, String identifier)
    {
        super(identifier);
        this.name = name;
        isAs = Lists.newArrayList();
    }

    /**
     * @return the partOf
     */
    public Entity getPartOf()
    {
        return partOf;
    }

    /**
     * @param partOf
     *            the partOf to set
     */
    public void setPartOf(Entity partOf)
    {
        this.partOf = partOf;
    }

    /**
     * @return List of Entities which extend the hierarch of this Entity
     */
    public List<Entity> isAs()
    {
        return isAs;
    }

    public boolean hasIsAs()
    {
        return !isAs.isEmpty();
    }

    /**
     * Adds the given entity to the list of isAs if it is not already present.
     * 
     * @param ent
     *            Entity to add
     */
    public void addIsA(Entity ent)
    {
        if (ent == null || isAs.contains(ent))
            return;

        isAs.add(ent);
    }

    /**
     * Removes the given Entity from the list of isAs if it is present.
     * 
     * @param ent
     *            Entity to remove
     */
    public void removeIsA(Entity ent)
    {
        if (ent == null || !isAs.contains(ent))
            return;

        isAs.remove(ent);
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

    protected String generateXMLTag(String type)
    {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "<entities xmi:id=\"%s\" xsi:type=\"%s\" title=\"%s\" originatesFrom=\"%s\" name=\"%s\" description=\"%s\" partOf=\"%s\"",
                        getIdentifier(), type, StringEscapeUtils.escapeXml10(getTitle()),
                        getOriginatesFrom().getQualifiedIdentifier(), StringEscapeUtils.escapeXml10(getName()),
                        StringEscapeUtils.escapeXml10(getDescription()), getPartOf().getQualifiedIdentifier()));

        if (hasIsAs())
        {
            builder.append(">\n");
            isAs.forEach(
                    (isa) -> builder.append(String.format("<isA parent=\"%s\" />%n", isa.getQualifiedIdentifier())));
            builder.append("</entities>");
        }
        else
        {
            builder.append(" />\n");
        }

        return builder.toString();
    }

    /**
     * Base Builder for Entities which uses the Fluent Interface and Method
     * Chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public abstract static class AbstractEntityBuilder extends AbstractQMElementBuilder {

        /**
         * Sets the element under construction's description
         * 
         * @param description
         *            the description to set
         * @return this
         */
        @Nonnull
        public AbstractEntityBuilder description(String description)
        {
            ((Entity) element).setDescription(description);

            return this;
        }

        /**
         * Adds an entity to which this entity forms an IS-A relationship with.
         * 
         * @param entity
         *            Entity
         * @return this
         */
        @Nonnull
        public AbstractEntityBuilder isA(Entity entity)
        {
            ((Entity) element).addIsA(entity);

            return this;
        }

        /**
         * Sets the entity to which this entity is a part of
         * 
         * @param entity
         *            The Entity
         * @return this
         */
        @Nonnull
        public AbstractEntityBuilder partOf(Entity entity)
        {
            ((Entity) element).setPartOf(entity);

            return this;
        }
    }
}
