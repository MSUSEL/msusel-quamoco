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

import edu.montana.gsoc.msusel.quamoco.model.Evaluation;

/**
 * @author Isaac Griffith
 *
 */
public class SingleMeasureEvaluationResult extends EvaluationResult {

    /**
     * 
     */
    private double ratioAffected;
    
    /**
     * @param ratio
     */
    public SingleMeasureEvaluationResult(double ratio)
    {
        super();
        this.ratioAffected = ratio;
    }
    
    /**
     * @param ratio
     * @param identifier
     */
    public SingleMeasureEvaluationResult(double ratio, String identifier)
    {
        super(identifier);
        this.ratioAffected = ratio;
    }

    /**
     * @return the ratioAffected
     */
    public double getRatioAffected()
    {
        return ratioAffected;
    }

    /**
     * @param ratioAffected the ratioAffected to set
     */
    public void setRatioAffected(double ratioAffected)
    {
        this.ratioAffected = ratioAffected;
    }
    
    /**
     * @param ratio
     * @return
     */
    public static Builder builder(double ratio) {
        return new Builder(ratio);
    }
    
    /**
     * @param ratio
     * @param identifier
     * @return
     */
    public static Builder builder(double ratio, String identifier) {
        return new Builder(ratio, identifier);
    }
    
    /**
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class Builder {
        
        private SingleMeasureEvaluationResult instance;
        
        /**
         * @param ratio
         */
        public Builder(double ratio) {
            instance = new SingleMeasureEvaluationResult(ratio);
        }
        
        /**
         * @param ratio
         * @param identifier
         */
        public Builder(double ratio, String identifier) {
            instance = new SingleMeasureEvaluationResult(ratio, identifier);
        }
        
        /**
         * @return
         */
        @Nonnull
        public SingleMeasureEvaluationResult create() {
            return instance;
        }
        
        /**
         * @param from
         * @return
         */
        @Nonnull
        public Builder from(Evaluation from) {
            instance.setResultFrom(from);
            
            return this;
        }
    }

}
