/**
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
package edu.montana.gsoc.msusel.quamoco.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.common.collect.Lists;
import edu.montana.gsoc.msusel.quamoco.io.JsonSerializable;
import edu.montana.gsoc.msusel.quamoco.io.ScriptSerializable;
import edu.montana.gsoc.msusel.quamoco.io.XMLSerializable;
import edu.montana.gsoc.msusel.quamoco.io.YamlSerializable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Abstract base class of all QMElements. This class contains the basic pieces
 * of all QMElements.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
@EqualsAndHashCode(of = {"identifier"})
@ToString(of = {"identifier"})
public abstract class QMElement implements XMLSerializable, YamlSerializable, JsonSerializable, ScriptSerializable {

    @Getter
    protected String identifier;
    /**
     * Link to where the original information for this element can be found
     */
    @Getter
    @Setter
    protected Source originatesFrom;
    /**
     * Tags for the element indicating additional information
     */
    @Getter
    protected List<Tag> taggedBy = Lists.newArrayList();
    /**
     * List of annotations
     */
    @Getter
    protected List<Annotation> annotations = Lists.newArrayList();
    @Getter
    private String qualifiedIdentifier;

    /**
     * Constructs a new QMElement with a randomly generated UUID as its
     * identifier.
     */
    public QMElement() {
        identifier = UUID.randomUUID().toString();
        taggedBy = Lists.newArrayList();
        annotations = Lists.newArrayList();
    }

    public QMElement(String identifier) {
        this();
        identifier = identifier;
    }

    /**
     * Constructs a new QMElement with the specified Unique Identifier already
     * assigned.
     *
     * @param identifier The Unique Identifier of this element.
     */
    public QMElement(String identifier, Source originatesFrom, List<Tag> taggedBy, List<Annotation> annotations) {
        if (identifier != null)
            this.identifier = identifier;
        this.originatesFrom = originatesFrom;
        if (taggedBy != null && !taggedBy.isEmpty())
            this.taggedBy = Lists.newArrayList(taggedBy);
        if (annotations != null && !annotations.isEmpty())
        this.annotations = Lists.newArrayList(annotations);
    }

    /**
     * @param tag the tag this element is tagged by
     */
    public void addTaggedBy(Tag tag) {
        if (tag == null || taggedBy.contains(tag))
            return;

        taggedBy.add(tag);
    }

    public void removeTaggedBy(Tag tag) {
        if (tag == null || !taggedBy.contains(tag))
            return;

        taggedBy.remove(tag);
    }

    public boolean hasTags() {
        return !taggedBy.isEmpty();
    }

    /**
     * Adds the given annotation to this element, unless the given annotation is
     * null.
     *
     * @param ann Annotation to add
     */
    public void addAnnotation(Annotation ann) {
        if (ann == null)
            return;

        annotations.add(ann);
    }

    public boolean hasAnnotations() {
        return !annotations.isEmpty();
    }

    public void updateQualifiedIdentifier(QualityModel owner) {
        if (owner == null || owner.getFileName() == null)
            qualifiedIdentifier = identifier;
        else
            qualifiedIdentifier = owner.getFileName() + "#" + identifier;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toJson() {
        ObjectMapper mapper = new ObjectMapper();
        String value = "";

        try {
            value = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {

        }

        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toYaml() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        String value = "";

        try {
            value = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (JsonProcessingException e) {

        }

        return value;
    }

    protected String generateXMLTag(String tag, String type, Map<String, String> attrMap, List<String> contents) {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("<%s xmi:id=\"%s\"", tag, getIdentifier()));
        if (type != null)
            builder.append(String.format(" xsi:type=\"%s\"", type));
        if (getOriginatesFrom() != null)
            attrMap.put("originatesFrom", getOriginatesFrom().getQualifiedIdentifier());
        attrMap.forEach((key, value) -> {
            if (value != null) builder.append(String.format(" %s=\"%s\"", key, value));
        });

        if (hasAnnotations() || hasTags() || !contents.isEmpty()) {
            builder.append(">\n");

            taggedBy.forEach(
                    (tagg) -> builder.append(String.format("<taggedBy href=\"%s\" />%n", tagg.getQualifiedIdentifier())));
            annotations.forEach((ann) -> builder.append(ann.xmlTag()));
            contents.forEach(content -> builder.append(content + "\n"));

            builder.append(String.format("</%s>\n", tag));
        } else {
            builder.append(" />\n");
        }

        return builder.toString();
    }

    public String getName() {
        return "";
    }

    public String getFullName() { return getName(); }

    public abstract String xmlTag();
}
