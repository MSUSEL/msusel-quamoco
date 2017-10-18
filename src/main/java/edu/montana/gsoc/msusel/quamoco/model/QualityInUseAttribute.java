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

import javax.annotation.Nonnull;

import edu.montana.gsoc.msusel.quamoco.io.FactorType;

/**
 * Quality in use attributes define a way to decompose the abstract concept
 * software quality. These quality attributes are defined in the ISO 25010 as
 * description of the quality in its various forms of usage. Examples are
 * efficiency or effectiveness. To be more precise, we add the activity that is
 * characterised by the attribute as entity to the factor. Activities like
 * maintenance, program comprehension, modification, or testing, which can be
 * decomposed in their respective sub-activities, provide a means to model
 * software development cost structures.
 * <ul>
 * <li>The entity of a quality in use attribute is an activity.</li>
 * <li>Characterize an activity by:
 * <ul>
 * <li>Effectiveness</li>
 * <li>Efficiency</li>
 * <li>Safety</li>
 * <li>Satisfaction</li></li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class QualityInUseAttribute extends QualityAspect {

    /**
     * Constructs a new QualityInUseAttribute with the given name
     * 
     * @param name
     *            The name
     */
    public QualityInUseAttribute(String name)
    {
        super(name);
    }

    /**
     * @param name
     * @param identifier
     */
    public QualityInUseAttribute(String name, String identifier)
    {
        super(name, identifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        return generateXMLTag(FactorType.QUALITY_IN_USE_ATTRIBUTE.type());
    }

    /**
     * Creates a new Builder for a QualityInUseAttribute with the given simple
     * name
     * 
     * @param name
     *            Simple Name
     * @return the QualityInUseAttribute.Builder instance.
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Creates a new Builder for a QualityInUseAttribute with the given simple
     * name and
     * unique
     * identifier.
     * 
     * @param name
     *            Simple Name
     * @param identifier
     *            The unique identifier
     * @return the QualityInUseAttribute.Builder instance.
     */
    public static Builder builder(String name, String identifier)
    {
        return new Builder(name, identifier);
    }

    /**
     * Builder for QualityInUseAttributes implemented using the fluent interface
     * and method chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractAspectBuilder {

        /**
         * Constructs a new Builder for a QualityInUseAttribute with the given
         * name
         * 
         * @param name
         *            The name of the QualityInUseAttribute to construct
         */
        private Builder(String name)
        {
            element = new QualityInUseAttribute(name);
        }

        /**
         * Constructs a new Builder for a QualityInUseAttribute with the given
         * name and unique identifier
         * 
         * @param name
         *            The name of the QualityInUseAttribute to construct
         * @param identifier
         *            The unique identifier
         */
        private Builder(String name, String identifier)
        {
            element = new QualityInUseAttribute(name, identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
        public QualityInUseAttribute create()
        {
            return (QualityInUseAttribute) element;
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
