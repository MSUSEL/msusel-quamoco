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
package edu.montana.gsoc.msusel.quamoco.model;

import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.apache.commons.lang3.StringEscapeUtils;

import com.google.common.collect.Lists;
import edu.montana.gsoc.msusel.quamoco.io.MeasuresType;

/**
 * A measure defines how a specific entity is measured. For the concrete
 * measurement, it defines either an instrument, which is bound to a tool or
 * manual measurement, or an aggregation of other measures.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Measure extends QMElement {

    @Getter @Setter
    protected String name = "";
    @Getter @Setter
    protected String description = "";
    /**
     * Specify the entity that is characterized by the measure.
     */
    @Getter @Setter
    protected Entity characterizes;
    /**
     * Measures that consist of this measure
     */
    @Getter @Setter
    protected Measure refines;
    /**
     * List of elements representing the items that this measure quantifies and
     * the method by which it does that
     */
    @Getter
    @Builder.Default
    protected List<Factor> measures = Lists.newArrayList();
    /**
     * A title can be an alternative, more readable identifier for the measure.
     * Providing a title is optional. If there is no specific reason to do
     * otherwise, only capitalize the first word in the title.
     */
    @Getter @Setter
    protected String title;
    /**
     * Set one of NONE, FINDINGS, NUMBER. In many cases, FINDINGS is an
     * appropriate type. Measures that represent rules that are checked on a
     * product can identify locations in the product where the rule is violated.
     * Such a location is called finding. Most of static code analysis tools,
     * for example, return findings. Measures can return an arbitrary real
     * numerical value. The data type to represent them is NUMBER. This number
     * can be an absolute value or a ratio of some kind, it is mostly
     * appropriate for numerical measures.
     */
    @Getter @Setter
    protected MeasureType type;

    /**
     * Constructs a new Measure with the given name
     *
     * @param name Name of this measure
     */
    protected Measure(String name) {
        super();
        this.name = name;
        measures = Lists.newArrayList();
    }

    /**
     * Constructs a new Measure with the given name and unique identifier
     *
     * @param name       Name of this measure
     * @param identifier The unique identifier
     */
    protected Measure(String name, String identifier) {
        super(identifier);
        this.name = name;
        measures = Lists.newArrayList();
    }

    @Builder(buildMethodName = "create")
    protected Measure(String name, String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations,
                      String title, String description, Entity characterizes, Measure refines, @Singular List<Factor> measures, MeasureType type) {
        super(identifier, originatesFrom, tags, annotations);
        this.name = name;
        this.title = title;
        this.description = description;
        this.characterizes = characterizes;
        this.refines = refines;
        if (measures != null && !measures.isEmpty())
            this.measures = Lists.newArrayList(measures);
        this.type = type;
    }

    /**
     * Adds the given quantifier to the list of quantifiers this measure
     * quantifies
     *
     * @param factor Factor to add to the list of items Measured
     */
    public void addMeasures(Factor factor) {
        if (factor == null || measures.contains(factor))
            return;
        measures.add(factor);
    }

    public void removeMeasures(Factor factor) {
        if (factor == null || !measures.contains(factor))
            return;

        measures.remove(factor);
    }

    /**
     * @return the normalizer
     */
    public boolean isNormalizer() {
        return false;
    }

    protected String xmlTag(String type) {
        Map<String, String> attrMap = Maps.newHashMap();
        List<String> contents = Lists.newArrayList();

        if (getTitle() != null)
            attrMap.put("title", StringEscapeUtils.escapeXml10(getTitle()));
        if (getName() != null)
            attrMap.put("name", StringEscapeUtils.escapeXml10(getName()));
        if (getDescription() != null)
            attrMap.put("description", StringEscapeUtils.escapeXml10(getDescription()));
        if (getCharacterizes() != null)
            attrMap.put("characterizes", getCharacterizes().getQualifiedIdentifier());
        if (getRefines() != null)
            contents.add(String.format("<refines parent=\"%s\" />", getRefines().getQualifiedIdentifier()));

        return generateXMLTag("measures", type, attrMap, contents);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        String temp = MeasuresType.UNKNOWN_MEASURE.type();

        switch (type) {
            case FINDINGS:
                temp = MeasuresType.FINDING_MEASURE.type();
            case NUMBER:
                temp = MeasuresType.NUMBER_MEASURE.type();
            case NONE:
                temp = MeasuresType.UNKNOWN_MEASURE.type();
            default:
                temp = MeasuresType.FINDING_MEASURE.type();
        }

        return xmlTag(temp);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toScript() {
        // TODO Auto-generated method stub
        return null;
    }
}
