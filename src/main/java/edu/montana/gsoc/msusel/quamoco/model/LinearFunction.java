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

/**
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class LinearFunction extends Function {

    private double lowerBound;
    private double upperBound;

    public LinearFunction()
    {
        super();
    }

    public LinearFunction(String identifier)
    {
        super(identifier);
    }

    /**
     * @return the lowerBound
     */
    public double getLowerBound()
    {
        return lowerBound;
    }

    /**
     * @param lowerBound
     *            the lowerBound to set
     */
    public void setLowerBound(double lowerBound)
    {
        this.lowerBound = lowerBound;
    }

    /**
     * @return the upperBound
     */
    public double getUpperBound()
    {
        return upperBound;
    }

    /**
     * @param upperBound
     *            the upperBound to set
     */
    public void setUpperBound(double upperBound)
    {
        this.upperBound = upperBound;
    }
    
    /**
     * @param type
     * @return
     */
    protected String generateXMLTag(String type) {
        StringBuilder builder = new StringBuilder();
        
        builder.append(String.format(
                "<function xmi:id=\"%s\" xsi:type=\"%s\" lowerBound=\"%f\" upperBound=\"%f\" />%n",
                getIdentifier(), type, getLowerBound(), getUpperBound()));
        
        return builder.toString();
    }

    /**
     * Base Builder for LinearFunctions using a Fluent Interface.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public abstract static class AbstractLinearFunctionBuilder extends AbstractFunctionBuilder {

        /**
         * Sets theDouble elements lower bound
         * 
         * @param lb
         *            The lower bound
         * @return this
         */
        @Nonnull
        public AbstractLinearFunctionBuilder lowerBound(double lb)
        {
            ((LinearFunction) element).setLowerBound(lb);

            return this;
        }

        /**
         * Sets the elements upper bound
         * 
         * @param lb
         *            The upper bound
         * @return this
         */
        @Nonnull
        public AbstractLinearFunctionBuilder upperBound(double ub)
        {
            ((LinearFunction) element).setUpperBound(ub);

            return this;
        }
    }
}
