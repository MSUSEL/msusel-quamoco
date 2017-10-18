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
 * @version 1.1.1
 */
public abstract class Factor extends QMElement {

    protected String       name;
    protected String       description;
    /**
     * Specifies the entity that is characterized by the factor
     */
    protected Entity       characterizes;
    /**
     * Optional title. The title can be used to provided a more verbose
     * description of the factor, beyond its name
     */
    protected String       title;
    /**
     * List of impacts which indicate the factors which this factor influences
     */
    protected List<Impact> influences;
    /**
     * List of factors which this factor refines (note: must be of same type as
     * this factor)
     */
    protected Factor       refines;

    /**
     * @param name
     */
    public Factor(String name)
    {
        super();
        this.name = name;
        influences = Lists.newArrayList();
    }

    /**
     * @param name
     * @param identifier
     */
    public Factor(String name, String identifier)
    {
        super(identifier);
        this.name = name;
        influences = Lists.newArrayList();
    }

    /**
     * @return the characterizes
     */
    public Entity getCharacterizes()
    {
        return characterizes;
    }

    /**
     * @param characterizes
     *            the characterizes to set
     */
    public void setCharacterizes(Entity characterizes)
    {
        this.characterizes = characterizes;
    }

    public void addInfluence(Impact impact)
    {
        if (impact == null || influences.contains(impact))
            return;

        influences.add(impact);
    }

    /**
     * Adds a factor which this factor refines.
     * 
     * @param factor
     *            Factor which this factor refines
     */
    public void setRefines(Factor factor)
    {
        refines = factor;
    }

    /**
     * @return List of all factors refined by this factor
     */
    public Factor getRefines()
    {
        return refines;
    }

    /**
     * @return List of all factors influenced by this factor
     */
    public List<Impact> getInfluences()
    {
        return influences;
    }

    /**
     * @return the element's description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the new description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the element's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the new name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    protected String generateXMLTag(String type)
    {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "<factors xmi:id=\"%s\" xsi:type=\"%s\" originatesFrom=\"%s\" title=\"%s\" name=\"%s\" description=\"%s\" chracterizes=\"%s\">%n",
                        getIdentifier(), type, getOriginatesFrom().getQualifiedIdentifier(),
                        StringEscapeUtils.escapeXml10(getTitle()), StringEscapeUtils.escapeXml10(getName()),
                        StringEscapeUtils.escapeXml10(getDescription()), getCharacterizes().getQualifiedIdentifier()));

        if (getRefines() != null)
            builder.append(String.format("<refines parent=\"%s\" />%n", getRefines().getQualifiedIdentifier()));

        influences.forEach((inf) -> builder.append(inf.xmlTag()));
        annotations.forEach((ann) -> builder.append(ann.xmlTag()));
        builder.append("</factors>\n");

        return builder.toString();
    }

    /**
     * Base Builder for Factors implemented using the fluent interface
     * and method chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public abstract static class AbstractFactorBuilder extends AbstractQMElementBuilder {

        /**
         * Sets the element under construction's description
         * 
         * @param description
         *            the description to set
         * @return this
         */
        @Nonnull
        public AbstractFactorBuilder description(String description)
        {
            ((Factor) element).setDescription(description);

            return this;
        }

        /**
         * Adds a factor which the factor under construction refines
         * 
         * @param factor
         *            Factor
         * @return this
         */
        @Nonnull
        public AbstractFactorBuilder refines(Factor factor)
        {
            ((Factor) element).setRefines(factor);

            return this;
        }
    }
}
