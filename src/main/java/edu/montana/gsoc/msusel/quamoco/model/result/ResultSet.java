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
import java.util.UUID;

import javax.annotation.Nonnull;

/**
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ResultSet {

    private SystemDescriptor system;
    private String identifier;
    private List<EvaluationResult> evaluations;
    private List<MeasurementResult> measurements;
    
    /**
     * @param system
     */
    public ResultSet(SystemDescriptor system)
    {
        this(system, UUID.randomUUID().toString());
    }
    
    /**
     * @param system
     * @param identifier
     */
    public ResultSet(SystemDescriptor system, String identifier) {
        this.system = system;
        this.identifier = identifier;
    }

    /**
     * @param er
     */
    public void addEvaluation(EvaluationResult er) {
        if (er == null || evaluations.contains(er))
            return;
        
        evaluations.add(er);
    }
    
    /**
     * @param er
     */
    public void removeEvaluation(EvaluationResult er) {
        if (er == null || !evaluations.contains(er))
            return;
        
        evaluations.remove(er);
    }
    
    /**
     * @return
     */
    public List<EvaluationResult> getEvaluations() {
        return evaluations;
    }
    
    /**
     * @param mr
     */
    public void addMeasurement(MeasurementResult mr) {
        if (mr == null || measurements.contains(mr))
            return;
        
        measurements.add(mr);
    }
    
    /**
     * @param mr
     */
    public void removeMeasurement(MeasurementResult mr) {
        if (mr == null || !measurements.contains(mr))
            return;
        
        measurements.remove(mr);
    }
    
    /**
     * @return
     */
    public List<MeasurementResult> getMeasurements() {
        return measurements;
    }
    
    /**
     * @return the system
     */
    public SystemDescriptor getSystem()
    {
        return system;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier()
    {
        return identifier;
    }

    /**
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {
        private ResultSet instance;
        
        /**
         * @param system
         */
        public Builder(SystemDescriptor system) {
            instance = new ResultSet(system);
        }
        
        /**
         * @param system
         * @param identifier
         */
        public Builder(SystemDescriptor system, String identifier) {
            instance = new ResultSet(system, identifier);
        }
        
        /**
         * @return
         */
        @Nonnull
        public ResultSet create() {
            return instance;
        }
        
        /**
         * @param er
         * @return
         */
        @Nonnull
        public Builder evaluation(EvaluationResult er) {
            instance.addEvaluation(er);            
            
            return this;
        }
        
        /**
         * @param mr
         * @return
         */
        @Nonnull
        public Builder measurement(MeasurementResult mr) {
            instance.addMeasurement(mr);
            
            return this;
        }
    }
}
