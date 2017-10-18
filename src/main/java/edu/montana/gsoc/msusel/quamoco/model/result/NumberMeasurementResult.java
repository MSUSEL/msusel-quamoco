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
package edu.montana.gsoc.msusel.quamoco.model.result;

import javax.annotation.Nonnull;

import edu.montana.gsoc.msusel.quamoco.model.MeasurementMethod;

/**
 * @author Isaac Griffith
 *
 */
public class NumberMeasurementResult extends MeasurementResult {

    private DoubleInterval value;
    
    /**
     * 
     */
    public NumberMeasurementResult(DoubleInterval value)
    {
        super();
        this.value = value;
    }

    /**
     * @param identifier
     */
    public NumberMeasurementResult(DoubleInterval value, String identifier)
    {
        super(identifier);
        this.value = value;
    }

    /**
     * @return the value
     */
    public DoubleInterval getValue()
    {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(DoubleInterval value)
    {
        this.value = value;
    }

    /**
     * @param value
     * @return
     */
    public static Builder builder(DoubleInterval value)
    {
        return new Builder(value);
    }

    /**
     * @param value
     * @param identifier
     * @return
     */
    public static Builder builder(DoubleInterval value, String identifier)
    {
        return new Builder(value, identifier);
    }

    /**
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class Builder {

        private NumberMeasurementResult instance;

        /**
         * @param value
         */
        public Builder(DoubleInterval value)
        {
            instance = new NumberMeasurementResult(value);
        }

        /**
         * @param value
         * @param identifier
         */
        public Builder(DoubleInterval value, String identifier)
        {
            instance = new NumberMeasurementResult(value, identifier);
        }

        /**
         * @return
         */
        @Nonnull
        public NumberMeasurementResult create()
        {
            return instance;
        }

        /**
         * @param from
         * @return
         */
        @Nonnull
        public Builder from(MeasurementMethod from)
        {
            instance.setResultFrom(from);

            return this;
        }
    }
}
