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
package edu.montana.gsoc.msusel.quamoco.model.result;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class ResultSet {

    @Getter
    private SystemDescriptor system;
    @Getter
    @Builder.Default
    private String identifier = UUID.randomUUID().toString();
    @Getter
    private List<EvaluationResult> evaluations;
    @Getter
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

    @Builder(buildMethodName = "create")
    ResultSet(String identifier, SystemDescriptor system, List<EvaluationResult> evaluations, List<MeasurementResult> measurements) {
        if (identifier != null)
            this.identifier = identifier;
        this.system = system;
        this.evaluations = evaluations;
        this.measurements = measurements;
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
}
