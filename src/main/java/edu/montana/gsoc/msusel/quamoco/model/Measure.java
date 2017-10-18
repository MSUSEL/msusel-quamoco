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

    protected String       name;
    protected String       description;
    /**
     * Specify the entity that is characterized by the measure.
     */
    protected Entity       characterizes;
    /**
     * Measures that consist of this measure
     */
    protected Measure      refines;
    /**
     * List of elements representing the items that this measure quantifies and
     * the method by which it does that
     */
    protected List<Factor> measures;
    /**
     * A title can be an alternative, more readable identifier for the measure.
     * Providing a title is optional. If there is no specific reason to do
     * otherwise, only capitalize the first word in the title.
     */
    protected String       title;
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
    protected MeasureType  type;

    /**
     * Constructs a new Measure with the given name
     * 
     * @param name
     *            Name of this measure
     */
    protected Measure(String name)
    {
        super();
        this.name = name;
        measures = Lists.newArrayList();
    }

    /**
     * Constructs a new Measure with the given name and unique identifier
     * 
     * @param name
     *            Name of this measure
     * @param identifier
     *            The unique identifier
     */
    protected Measure(String name, String identifier)
    {
        super(identifier);
        this.name = name;
        measures = Lists.newArrayList();
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

    /**
     * @return the list of measures this measure refines
     */
    public Measure getRefines()
    {
        return refines;
    }

    /**
     * Adds the given measure to the list of measures this measure refines.
     * 
     * @param measure
     *            Measure that this measure refines
     */
    public void setRefines(Measure measure)
    {
        refines = measure;
    }

    /**
     * Adds the given quantifier to the list of quantifiers this measure
     * quantifies
     * 
     * @param factor
     *            Factor to add to the list of items Measured
     */
    public void addMeasures(Factor factor)
    {
        if (factor == null || measures.contains(factor))
            return;

        measures.add(factor);
    }

    public void removeMeasures(Factor factor)
    {
        if (factor == null || !measures.contains(factor))
            return;

        measures.remove(factor);
    }

    public List<Factor> getMeasures()
    {
        return measures;
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
     * @return the type
     */
    public MeasureType getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(MeasureType type)
    {
        this.type = type;
    }

    /**
     * @return the normalizer
     */
    public boolean isNormalizer()
    {
        return false;
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
     * Creates a new Builder for a Measure with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the Measure.Builder instance.
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Creates a new Builder for a Measure with the given simple name and
     * unique identifier.
     * 
     * @param name
     *            Simple Name
     * @param identifier
     *            The unique identifier
     * @return the Measure.Builder instance.
     */
    public static Builder builder(String name, String identifier)
    {
        return new Builder(name, identifier);
    }

    /**
     * Builder for Measures implemented using the fluent interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractQMElementBuilder {

        /**
         * Creates a new Builder for a Measure with the given simple name.
         * 
         * @param name
         *            Simple Name
         * @return the Measure.Builder instance
         */
        protected Builder(String name)
        {
            element = new Measure(name);
        }

        /**
         * Constructs a new Builder for a Measure with the given
         * name and unique identifier
         * 
         * @param name
         *            The name of the Measure to construct
         * @param identifier
         *            The unique identifier
         */
        protected Builder(String name, String identifier)
        {
            element = new Measure(name, identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
        public Measure create()
        {
            return (Measure) element;
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
            ((Measure) element).setDescription(description);

            return this;
        }

        /**
         * Sets the entity characterized by this measure
         * 
         * @param ent
         *            Entity characterized
         * @return this
         */
        @Nonnull
        public Builder characterizes(Entity ent)
        {
            ((Measure) element).setCharacterizes(ent);

            return this;
        }

        /**
         * Sets the given measure as a measure which the measure under
         * construction refines. And adds the measure under construction to the
         * given measure's refined-by list
         * 
         * @param measure
         *            Measure refined-by the measure under construction
         * @return this
         */
        @Nonnull
        public Builder refines(Measure measure)
        {
            ((Measure) element).setRefines(measure);

            return this;
        }

        /**
         * Sets the title of the measure under construction
         * 
         * @param title
         *            New title
         * @return this
         */
        @Nonnull
        public Builder title(String title)
        {
            ((Measure) element).setTitle(title);

            return this;
        }

        /**
         * Sets the type of the measure under construction to the given measure
         * type
         * 
         * @param type
         *            Measure type
         * @return this
         */
        @Nonnull
        public Builder type(MeasureType type)
        {
            ((Measure) element).setType(type);

            return this;
        }
    }

    protected String generateXMLTag(String type)
    {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "<measures xmi:id=\"%s\" xsi:type=\"%s\" title=\"%s\" originatesFrom=\"%s\" name=\"%s\" description=\"%s\" characterizes=\"%s\">%n",
                        getIdentifier(), type, StringEscapeUtils.escapeXml10(getTitle()),
                        getOriginatesFrom().getQualifiedIdentifier(), StringEscapeUtils.escapeXml10(getName()),
                        StringEscapeUtils.escapeXml10(getDescription()), getCharacterizes().getQualifiedIdentifier()));
        if (getRefines() != null)
            builder.append(String.format("<refines parent=\"%s\" />%n", getRefines().getQualifiedIdentifier()));

        taggedBy.forEach(
                (tag) -> builder.append(String.format("<taggedBy href=\"%s\" />", tag.getQualifiedIdentifier())));
        annotations.forEach((ann) -> builder.append(ann.xmlTag()));
        builder.append("</measures>\n");

        return builder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        switch (type)
        {
        case FINDINGS:
            return generateXMLTag(MeasuresType.FINDING_MEASURE.type());
        case NUMBER:
            return generateXMLTag(MeasuresType.NUMBER_MEASURE.type());
        case NONE:
            return generateXMLTag(MeasuresType.UNKNOWN_MEASURE.type());
        default:
            return generateXMLTag(MeasuresType.FINDING_MEASURE.type());
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
