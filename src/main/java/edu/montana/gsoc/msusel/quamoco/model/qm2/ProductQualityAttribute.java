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
 * Product quality attributes define one way to decompose the abstract concept
 * software quality. These quality attributes, as given in ISO 25010, relate to
 * the quality of the product without explicitly considering its use. These
 * quality attributes are colloquially called -illities, because they contain,
 * for example, reliability or maintainability. In the standard, the top level
 * attributes are refined by so-called quality characteristics.
 * <ul>
 * <li>Product quality attributes model the -ilities of the ISO 25010.</li>
 * <li>These factors do characterize the entity Product.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ProductQualityAttribute extends QualityAspect {

    /**
     * List of factors which this factor refines (note: must be of same type as
     * this factor)
     */
    protected List<ProductQualityAttribute> refines;
    /**
     * List of factors which refine this factor (note: must be of same type as
     * this factor)
     */
    protected List<ProductQualityAttribute> refinedBy;

    /**
     * Constructs a new ProductQualityAttribute with the given name
     * 
     * @param name
     *            The name
     */
    public ProductQualityAttribute(String name)
    {
        super(name);
        refines = Lists.newArrayList();
        refinedBy = Lists.newArrayList();
    }

    /**
     * Adds a factor which this factor refines.
     * 
     * @param factor
     *            Factor which this factor refines
     */
    public void addRefines(ProductQualityAttribute factor)
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
    public void removeRefines(ProductQualityAttribute factor)
    {
        if (factor == null || !refines.contains(factor))
            return;

        refines.remove(factor);
        factor.removeRefinedBy(this);
    }

    /**
     * @return List of all factors refined by this factor
     */
    public List<ProductQualityAttribute> getRefines()
    {
        return Lists.newArrayList(refines);
    }

    /**
     * Add a factor which refines this factor
     * 
     * @param factor
     *            Factor refining this factor
     */
    public void addRefinedBy(ProductQualityAttribute factor)
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
    public void removeRefinedBy(ProductQualityAttribute factor)
    {
        if (factor == null || refinedBy.contains(factor))
            return;

        refinedBy.add(factor);
        factor.removeRefines(this);
    }

    /**
     * @return List of all factors refining this factor.
     */
    public List<ProductQualityAttribute> getRefinedBy()
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
     * Builder for ProductQualityAttributes implemented using the fluent
     * interface
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
        private ProductQualityAttribute element;

        /**
         * Constructs a new Builder for a ProductQualityAttribute with the given
         * name
         * 
         * @param name
         *            The name of the tag to construct
         */
        private Builder(String name)
        {
            element = new ProductQualityAttribute(name);
        }

        /**
         * @return The newly constructed ProductQualityAttribute element
         */
        @NonNull
        public ProductQualityAttribute create()
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
        public Builder refinedBy(ProductQualityAttribute factor)
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
        public Builder refines(ProductQualityAttribute factor)
        {
            element.addRefines(factor);
            factor.addRefinedBy(element);

            return this;
        }
    }
}
