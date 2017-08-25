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
 * Technical issues are also a way to decompose the abstract concept of quality.
 * This is a technical view, which assigns problems to areas such as memory or
 * declaration.
 * <br>
 * NOTE: Cannot characterize specific entities
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class TechnicalIssue extends Factor {

    /**
     * List of factors which this factor refines (note: must be of same type as
     * this factor)
     */
    protected List<TechnicalIssue> refines;
    /**
     * List of factors which refine this factor (note: must be of same type as
     * this factor)
     */
    protected List<TechnicalIssue> refinedBy;

    /**
     * Constructs a new TechnicalIssue with the given name
     * 
     * @param name
     *            The name
     */
    public TechnicalIssue(String name)
    {
        super(name);
        refines = Lists.newArrayList();
        refinedBy = Lists.newArrayList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity getCharacterizes()
    {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCharacterizes(Entity characterizes)
    {
    }

    /**
     * Adds a factor which this factor refines.
     * 
     * @param factor
     *            Factor which this factor refines
     */
    public void addRefines(TechnicalIssue factor)
    {
        if (factor == null || refines.contains(factor))
            return;

        refines.add(factor);
    }

    /**
     * Remove a factor which this factor refines
     * 
     * @param factor
     *            Factor no longer refined by this factor
     */
    public void removeRefines(TechnicalIssue factor)
    {
        if (factor == null || !refines.contains(factor))
            return;

        refines.remove(factor);
        factor.removeRefinedBy(this);
    }

    /**
     * @return List of all factors refined by this factor
     */
    public List<TechnicalIssue> getRefines()
    {
        return Lists.newArrayList(refines);
    }

    /**
     * Add a factor which refines this factor
     * 
     * @param factor
     *            Factor refining this factor
     */
    public void addRefinedBy(TechnicalIssue factor)
    {
        if (factor == null || refinedBy.contains(factor))
            return;

        refinedBy.add(factor);
    }

    /**
     * Removes a factor refining this factor
     * 
     * @param factor
     *            Factor no longer refining this factor
     */
    public void removeRefinedBy(TechnicalIssue factor)
    {
        if (factor == null || refinedBy.contains(factor))
            return;

        refinedBy.add(factor);
        factor.removeRefines(this);
    }

    /**
     * @return List of all factors refining this factor.
     */
    public List<TechnicalIssue> getRefinedBy()
    {
        return Lists.newArrayList(refinedBy);
    }

    /**
     * Creates a new Builder for a Tag with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the ProductFactor.Builder instance.
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Builder for TechnicalIssues implemented using the fluent interface
     * and
     * method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * Tag element under construction
         */
        private TechnicalIssue element;

        /**
         * Constructs a new Builder for a TechnicalIssue with the given
         * name
         * 
         * @param name
         *            The name of the tag to construct
         */
        private Builder(String name)
        {
            element = new TechnicalIssue(name);
        }

        /**
         * @return The newly constructed TechnicalIssue element
         */
        @NonNull
        public TechnicalIssue create()
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
         * Adds a factor which refines the factor under construction
         * 
         * @param factor
         *            Product Factor
         * @return this
         */
        @NonNull
        public Builder refinedBy(TechnicalIssue factor)
        {
            element.addRefinedBy(factor);
            factor.addRefines(element);

            return this;
        }

        /**
         * Adds a factor which the factor under construction refines
         * 
         * @param factor
         *            Factor
         * @return this
         */
        @NonNull
        public Builder refines(TechnicalIssue factor)
        {
            element.addRefines(factor);
            factor.addRefinedBy(element);

            return this;
        }
    }
}
