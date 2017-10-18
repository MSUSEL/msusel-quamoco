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

import edu.montana.gsoc.msusel.quamoco.io.EntityType;

/**
 * They describe a part of a software product. If they are characterized by a
 * factors, a Product-Factor results. The root entity of this hierarchy is an
 * entity Product, which is also characterized by all ISO 25010 -ilities
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ProductPart extends Entity {

    /**
     * Constructs a new ProductPart with the given name
     * 
     * @param name
     *            The name of the ProductPart
     */
    public ProductPart(String name)
    {
        super(name);
    }

    /**
     * Constructs a new ProductPart with the given name
     * 
     * @param name
     *            The name of the ProductPart
     * @param identifier
     *            The unique identifier
     */
    public ProductPart(String name, String identifier)
    {
        super(name, identifier);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        return generateXMLTag(EntityType.PRODUCT_PART.type());
    }

    /**
     * Creates a new Builder for a Tag with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the ProductPart.Builder instance.
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Creates a new Builder for a Tag with the given simple name
     * 
     * @param name
     *            Simple Name
     * @Param identifer The unique identifier of the Product part to be created
     *        if it is already known.
     * @return the ProductPart.Builder instance.
     */
    public static Builder builder(String name, String identifier)
    {
        return new Builder(name, identifier);
    }

    /**
     * Builder for ProductParts implemented using the fluent interface
     * and
     * method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractEntityBuilder {

        /**
         * Constructs a new Builder for a ProductPart with the given
         * name
         * 
         * @param name
         *            The name of the tag to construct
         */
        private Builder(String name)
        {
            element = new ProductPart(name);
        }

        /**
         * Constructs a new Builder for a ProductPart with the given
         * name
         * 
         * @param name
         *            The name of the tag to construct
         * @param identifier
         *            The unique identifier of this entity (if already known)
         */
        private Builder(String name, String identifier)
        {
            element = new ProductPart(name, identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Nonnull
        public ProductPart create()
        {
            return (ProductPart) element;
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
