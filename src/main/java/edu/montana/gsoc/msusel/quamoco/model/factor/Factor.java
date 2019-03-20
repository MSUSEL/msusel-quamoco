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
package edu.montana.gsoc.msusel.quamoco.model.factor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.model.*;
import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;
import java.util.Map;

/**
 * Factors are one of the basic elements of quality models. A factor constitutes
 * a property of the software product (or a part of it) that is related to the
 * product’s quality. A factor is always defined in a way, that it is possible
 * to talk about the degree to which it is present in a product that is
 * assessed. The factor can be further defined by characterizing an entity, but
 * it does not have to define an entity.
 * <br>
 * The terms attribute and property are used interchangeably in the literature.
 * Here, we chose the term factor to clearly distinguish it from the term
 * quality attribute defined in ISO 9126 [ISO9126].
 * <br>
 * General Rules:
 * <ul>
 * <li>Use a factor to define a property of an entity entity in a textual
 * descriptive way.
 * <li>Provide textual criteria in the factor's description that defines when an
 * entity exhibits the property and when not.</li>
 * <li>Create a factor before you think about the measures that quantify it.
 * This is
 * helpful to ensure that you measure what you really want to measure.
 * Furthermore, it helps to create factors at the right level of abstraction,
 * preventing the quantitative explosion of factors and impacts.</li>
 * <li>There are different types of factors:
 * <ul>
 * <li>Product Factors</li>
 * <li>Product Quality Attribute (ISO 25010)</li>
 * <li>Quality in Use Attribute (ISO 25010)</li>
 * <li>Stakeholder Satisfaction</li>
 * <li>Technical Issue</li>
 * </ul>
 * </li>
 * </ul>
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public abstract class Factor extends QMElement {

    @Getter
    @Setter
    protected String name;
    @Getter
    @Setter
    protected String description;
    /**
     * Specifies the entity that is characterized by the factor
     */
    @Getter
    @Setter
    protected Entity characterizes;
    /**
     * Optional title. The title can be used to provided a more verbose
     * description of the factor, beyond its name
     */
    @Getter
    @Setter
    protected String title;
    /**
     * List of impacts which indicate the factors which this factor influences
     */
    @Getter
    protected Map<String, Impact> influences;
    /**
     * List of factors which this factor refines (note: must be of same type as
     * this factor)
     */
    @Getter
    @Setter
    protected Factor refines;

    /**
     * @param name
     */
    public Factor(String name) {
        super();
        this.name = name;
        influences = Maps.newHashMap();
    }

    /**
     * @param name
     * @param identifier
     */
    public Factor(String name, String identifier) {
        super(identifier);
        this.name = name;
        influences = Maps.newHashMap();
    }

    public Factor(String name, String description, Entity characterizes, String title, @Singular Map<String, Impact> influences, Factor refines,
                  String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(identifier, originatesFrom, tags, annotations);
        this.name = name;
        this.description = description;
        this.characterizes = characterizes;
        this.title = title;
        this.refines = refines;
        if (influences != null && !influences.isEmpty())
            this.influences = Maps.newHashMap(influences);
        else
            this.influences = Maps.newHashMap();
    }

    public String getFullName() {
        return characterizes == null ? name : name + " @" + characterizes.getName();
    }

    public void addInfluence(Impact impact) {
        if (impact != null)
            influences.put(impact.getTarget().getQualifiedIdentifier(), impact);
    }

    public void removeInfluence(Impact impact) {
        if (impact != null && influences.containsKey(impact.getTarget().getQualifiedIdentifier()))
            influences.remove(impact.getTarget().getQualifiedIdentifier());
    }

    protected String generateXMLTag(String type) {
        String tag = "factors";
        Map<String, String> attrs = Maps.newHashMap();
        List<String> content = Lists.newArrayList();

        if (getTitle() != null)
            attrs.put("title", StringEscapeUtils.escapeXml10(getTitle()));
        if (getName() != null)
            attrs.put("name", StringEscapeUtils.escapeXml10(getName()));
        if (getDescription() != null)
            attrs.put("description", StringEscapeUtils.escapeXml10(getDescription()));
        if (getCharacterizes() != null)
            attrs.put("characterizes", getCharacterizes().getQualifiedIdentifier());
        if (getRefines() != null)
            content.add(String.format("<refines parent=\"%s\" />", getRefines().getQualifiedIdentifier()));

        influences.forEach((key, inf) -> content.add(inf.xmlTag()));

        return generateXMLTag(tag, type, attrs, content);
    }

    public boolean hasAggregationAnnotation() {
        return false;
    }

    public String getAggregationAnnotationValue() {
        return "";
    }

    public InfluenceEffect getInfluenceOn(Factor evaluates) {
        if (refines != null && refines.equals(evaluates))
            return InfluenceEffect.REFINEMENT;
        else {
            if (influences.containsKey(evaluates.getQualifiedIdentifier()))
                    return influences.get(evaluates.getQualifiedIdentifier()).getEffect();
        }

        return InfluenceEffect.NONE;
    }
}
