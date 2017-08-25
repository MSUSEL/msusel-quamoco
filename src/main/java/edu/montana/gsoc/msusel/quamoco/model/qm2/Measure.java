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
 * A measure defines how a specific entity is measured. For the concrete
 * measurement, it defines either an instrument, which is bound to a tool or
 * manual measurement, or an aggregation of other measures.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Measure extends QMElement {

    /**
     * Specify the entity that is characterized by the measure.
     */
    private Entity        characterizes;
    /**
     * Measures that consist of this measure
     */
    private List<Measure> refines;
    /**
     * The measures that this measure consists of
     */
    private List<Measure> refinedBy;
    /**
     * A title can be an alternative, more readable identifier for the measure.
     * Providing a title is optional. If there is no specific reason to do
     * otherwise, only capitalize the first word in the title.
     */
    private String        title;
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
    private MeasureType   type;

    /**
     * Constructs a new Measure with the given name
     * 
     * @param name
     *            Name of this measure
     */
    protected Measure(String name)
    {
        super(name);
        refines = Lists.newArrayList();
        refinedBy = Lists.newArrayList();
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
    public List<Measure> getRefines()
    {
        return refines;
    }

    /**
     * Adds the given measure to the list of measures this measure refines.
     * 
     * @param measure
     *            Measure that this measure refines
     */
    public void addRefines(Measure measure)
    {
        if (measure == null || refines.contains(measure))
            return;

        refines.add(measure);
    }

    /**
     * @return List of measures refining this measure
     */
    public List<Measure> getRefinedBy()
    {
        return refinedBy;
    }

    /**
     * Adds the given measure to the list of measures that refine this measure
     * 
     * @param measure
     *            Measure that refines this measure
     */
    public void addRefinedBy(Measure measure)
    {
        if (measure == null || refinedBy.contains(measure))
            return;

        refinedBy.add(measure);
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
     * Creates a new Builder for a Measure with the given simple name and
     * associated with the given tool.
     * 
     * @param name
     *            Simple Name
     * @return the Measure.Builder instance
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Builder for Measures implemented using the fluent interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * Measure element under construction
         */
        private Measure element;

        /**
         * Creates a new Builder for a Measure with the given simple name.
         * 
         * @param name
         *            Simple Name
         * @return the Measure.Builder instance
         */
        private Builder(String name)
        {
            element = new Measure(name);
        }

        /**
         * @return The newly constructed Measure element
         */
        @NonNull
        public Measure create()
        {
            return element;
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
         * Sets the entity characterized by this measure
         * 
         * @param ent
         *            Entity characterized
         * @return this
         */
        @NonNull
        public Builder characterizes(Entity ent)
        {
            element.setCharacterizes(ent);

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
        @NonNull
        public Builder refines(Measure measure)
        {
            element.addRefines(measure);
            measure.addRefinedBy(element);

            return this;
        }

        /**
         * Sets the given measure as a measure refining the measure under
         * construction and updates the measure under construction's list of
         * refined-by measures.
         * 
         * @param measure
         *            Measure refining the measure under construction
         * @return this
         */
        @NonNull
        public Builder refinedBy(Measure measure)
        {
            element.addRefinedBy(measure);
            measure.addRefines(element);

            return this;
        }

        /**
         * Sets the title of the measure under construction
         * 
         * @param title
         *            New title
         * @return this
         */
        @NonNull
        public Builder title(String title)
        {
            element.setTitle(title);

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
        @NonNull
        public Builder type(MeasureType type)
        {
            element.setType(type);

            return this;
        }
    }
}
