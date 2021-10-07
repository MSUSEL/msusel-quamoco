/*
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.quamoco.model.entity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;
import java.util.Map;

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
 * @version 1.3.0
 */
public abstract class Entity extends QMElement {

    @Getter @Setter
    protected String name;
    @Getter @Setter
    protected String title;
    @Getter @Setter
    protected String description;
    /**
     * List of entities which are children of this Entity
     */
    private List<Entity> isAs = Lists.newArrayList();
    /**
     * Entity of which this entity is a part
     */
    @Getter @Setter
    protected Entity partOf;

    /**
     * Constructs a new Entity with the given name
     *
     * @param name The name of the Entity
     */
    public Entity(String name) {
        super();
        this.name = name;
        isAs = Lists.newArrayList();
    }

    /**
     * Constructs a new Entity with the given name and identifier
     *
     * @param name       The name of the entity
     * @param identifier The unique identifier of this entity
     */
    public Entity(String name, String identifier) {
        super(identifier);
        this.name = name;
        isAs = Lists.newArrayList();
    }

    protected Entity(@Singular List<Entity> isAs, Entity partOf, String name, String description, String title, String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations)
    {
        super(identifier, originatesFrom, tags, annotations);
        if (isAs != null && !isAs.isEmpty())
            this.isAs = Lists.newArrayList(isAs);
        this.partOf = partOf;
        this.name = name;
        this.description = description;
        this.title = title;
    }

    /**
     * @return List of Entities which extend the hierarchy of this Entity
     */
    public List<Entity> isAs() {
        return isAs;
    }

    public boolean hasIsAs() {
        return !isAs.isEmpty();
    }

    /**
     * Adds the given entity to the list of isAs if it is not already present.
     *
     * @param ent Entity to add
     */
    public void addIsA(Entity ent) {
        if (ent == null || isAs.contains(ent))
            return;

        isAs.add(ent);
    }

    /**
     * Removes the given Entity from the list of isAs if it is present.
     *
     * @param ent Entity to remove
     */
    public void removeIsA(Entity ent) {
        if (ent == null || !isAs.contains(ent))
            return;

        isAs.remove(ent);
    }

    public String generateXMLTag(String type) {
        String tag = "entities";
        Map<String, String> attrs = Maps.newHashMap();
        List<String> content = Lists.newArrayList();

        if (getTitle() != null)
            attrs.put("title", StringEscapeUtils.escapeXml10(getTitle()));
        if (getName() != null)
            attrs.put("name", StringEscapeUtils.escapeXml10(getName()));
        if (getDescription() != null)
            attrs.put("description", StringEscapeUtils.escapeXml10(getDescription()));
        if (getPartOf() != null)
            attrs.put("partOf", getPartOf().getQualifiedIdentifier());

        if (hasIsAs()) {
            isAs.forEach(
                    (isa) -> content.add(String.format("<isA parent=\"%s\" />", isa.getQualifiedIdentifier())));
        }

        return generateXMLTag(tag, type, attrs, content);
    }
}
