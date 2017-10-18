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

import java.util.List;

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;
import edu.montana.gsoc.msusel.quamoco.model.Evaluation;

/**
 * @author Isaac Griffith
 *
 */
public class MultiMeasureEvaluationResult extends EvaluationResult {

    private List<MeasureRankingEvaluationResult> results;
        
    /**
     * 
     */
    public MultiMeasureEvaluationResult()
    {
        super();
        results = Lists.newArrayList();
    }

    /**
     * @param identifier
     */
    public MultiMeasureEvaluationResult(String identifier)
    {
        super(identifier);
        results = Lists.newArrayList();
    }
    
    public void addResult(MeasureRankingEvaluationResult result) {
        if (result == null || results.contains(result))
            return;
        
        results.add(result);
    }
    
    public void removeResult(MeasureRankingEvaluationResult result) {
        if (result == null || !results.contains(result))
            return;
        
        results.remove(result);
    }

    /**
     * @return
     */
    public static Builder builder() {
        return new Builder();
    }
    
    /**
     * @param identifier
     * @return
     */
    public static Builder builder(String identifier) {
        return new Builder(identifier);
    }
    
    /**
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class Builder {
        
        private MultiMeasureEvaluationResult instance;
        
        /**
         */
        public Builder() {
            instance = new MultiMeasureEvaluationResult();
        }
        
        /**
         * @param identifier
         */
        public Builder(String identifier) {
            instance = new MultiMeasureEvaluationResult(identifier);
        }
        
        /**
         * @return
         */
        @Nonnull
        public MultiMeasureEvaluationResult create() {
            return instance;
        }
        
        /**
         * @param result
         * @return
         */
        @Nonnull
        public Builder result(MeasureRankingEvaluationResult result) {
            instance.addResult(result);
            
            return this;
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