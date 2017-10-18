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
public abstract class MeasurementMethod extends QMElement {

    protected Measure determines;
    protected String metric;

    public MeasurementMethod(String metric)
    {
        super();
        this.metric = metric;
    }

    public MeasurementMethod(String metric, String identifier)
    {
        super(identifier);
        this.metric = metric;
    }

    /**
     * @return the determines
     */
    public Measure getDetermines()
    {
        return determines;
    }

    /**
     * @param determines
     *            the determines to set
     */
    public void setDetermines(Measure determines)
    {
        this.determines = determines;
    }

    /**
     * @return the metric
     */
    public String getMetric()
    {
        return metric;
    }

    /**
     * @param metric
     *            the metric to set
     */
    public void setMetric(String metric)
    {
        this.metric = metric;
    }

    /**
     * Base Builder for MeasurementMethods using the Fluent Interface and Method
     * Chaining patterns.
     * 
     * @author Isaac Griffith
     * @verison 1.1.1
     */
    public abstract static class AbstractMeasurementMethodBuilder extends AbstractQMElementBuilder {
        
        @Nonnull
        public AbstractMeasurementMethodBuilder determines(Measure measure) {
            ((MeasurementMethod) element).setDetermines(measure);
            
            return this;
        }
    }
}
