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

import java.util.UUID;

import javax.annotation.Nonnull;

import edu.montana.gsoc.msusel.quamoco.model.MeasureRanking;

/**
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MeasureRankingEvaluationResult {

    private double ratioAffected;
    private MeasureRanking resultFrom;
    private DoubleInterval value;
    private String identifier;
    
    /**
     * 
     */
    public MeasureRankingEvaluationResult()
    {
        this(UUID.randomUUID().toString());
    }
    
    /**
     * @param identifier
     */
    public MeasureRankingEvaluationResult(String identifier) {
        this.identifier = identifier;
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
     * @return the resultFrom
     */
    public MeasureRanking getResultFrom()
    {
        return resultFrom;
    }

    /**
     * @param resultFrom the resultFrom to set
     */
    public void setResultFrom(MeasureRanking resultFrom)
    {
        this.resultFrom = resultFrom;
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
     * @return the identifier
     */
    public String getIdentifier()
    {
        return identifier;
    }

    /**
     * @param ratio
     * @return
     */
    public static Builder build() {
        return new Builder();
    }
    
    /**
     * @param ratio
     * @param identifier
     * @return
     */
    public static Builder build(String identifier) {
        return new Builder(identifier);
    }
    
    /**
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class Builder {
        
        private MeasureRankingEvaluationResult instance;
        
        /**
         * @param ratio
         */
        public Builder() {
            instance = new MeasureRankingEvaluationResult();
        }
        
        /**
         * @param ratio
         * @param identifier
         */
        public Builder(String identifier) {
            instance = new MeasureRankingEvaluationResult(identifier);
        }
        
        /**
         * @return
         */
        @Nonnull
        public MeasureRankingEvaluationResult create() {
            return instance;
        }
        
        /**
         * @param value
         * @return
         */
        @Nonnull
        public Builder value(DoubleInterval value) {
            instance.setValue(value);
            
            return this;
        }
        
        /**
         * @param ratio
         * @return
         */
        @Nonnull
        public Builder ratio(double ratio) {
            instance.setRatioAffected(ratio);
            
            return this;
        }
        
        /**
         * @param from
         * @return
         */
        @Nonnull
        public Builder from(MeasureRanking from) {
            instance.setResultFrom(from);
            
            return this;
        }
    }
}
