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
package edu.montana.gsoc.msusel.quamoco.io;

/**
 * @author Isaac Griffith
 *
 */
public enum EvaluationType {

    /**
     * 
     */
    MANUAL_EVALUATION("qm:ManualEvaluation"),
    /**
     * 
     */
    TEXT_EVALUATION("qm:TextEvaluation"),
    /**
     * 
     */
    QIESL_EVALUATION("qm:QIESLEvaluation"),
    /**
     * 
     */
    HISTOGRAM_COMP_FACTOR_AGGREGATION("qm:HistogramCompFactorAggregation"),
    /**
     * 
     */
    MAX_FACTOR_AGGREGATION("qm:MaxFactorAggregation"),
    /**
     * 
     */
    MEAN_FACTOR_AGGREGATION("qm:MeanFactorAggregation"),
    /**
     * 
     */
    MEDIAN_FACTOR_AGGREGATION("qm:MedianFactorAggregation"),
    /**
     * 
     */
    MIN_FACTOR_AGGREGATION("qm:MinFactorAggregation"),
    /**
     * 
     */
    MODE_FACTOR_AGGREGATION("qm:ModeFactorAggregation"),
    /**
     * 
     */
    RANGE_FACTOR_AGGREGATION("qm:RangeFactorAggregation"),
    /**
     * 
     */
    STD_DEV_FACTOR_AGGREGATION("qm:StdDevFactorAggregation"),
    /**
     * 
     */
    SUMMATION_FACTOR_AGGREGATION("qm:SummationFactorAggregation"),
    /**
     * 
     */
    VARIANCE_FACTOR_AGGREGATION("qm:VarianceFactorAggregation"),
    /**
     * 
     */
    WEIGHTED_SUM_FACTOR_AGGREGATION("qm:WeightedSumFactorAggregation"),
    /**
     * 
     */
    SINGLE_MEASURE_EVALUATION("qm:SingleMeasureEvaluation"),
    /**
     * 
     */
    HIST_COMP_MULTI_MEASURE_EVALUATION("qm:HistCompMultiMeasureEvaluation"),
    /**
     * 
     */
    MAX_MULTI_MEASURE_EVALUATION("qm:MaxMultiMeasureEvaluation"),
    /**
     * 
     */
    MEAN_MULTI_MEASURE_EVALUATION("qm:MeanMultiMeasureEvaluation"),
    /**
     * 
     */
    MEDIAN_MULTI_MEASURE_EVALUATION("qm:MedianMultiMeasureEvaluation"),
    /**
     * 
     */
    MIN_MULTI_MEASURE_EVALUATION("qm:MinMultiMeasureEvaluation"),
    /**
     * 
     */
    MODE_MULTI_MEASURE_EVALUATION("qm:ModeMultiMeasureEvaluation"),
    /**
     * 
     */
    RANGE_MULTI_MEASURE_EVALUATION("qm:RangeMultiMeasureEvaluation"),
    /**
     * 
     */
    STD_DEV_MULTI_MEASURE_EVALUATION("qm:StdDevMultiMeasureEvaluation"),
    /**
     * 
     */
    SUMMATION_MULTI_MEASURE_EVALUATION("qm:SummationMultiMeasureEvaluation"),
    /**
     * 
     */
    VARIANCE_MULTI_MEASURE_EVALUATION("qm:VarianceMultiMeasureEvaluation"),
    /**
     * 
     */
    WEIGHTED_SUM_MULTI_MEASURE_EVALUATION("qm:WeightedSumMultiMeasureEvaluation");
    
    private String type;
    
    EvaluationType(String type) {
        this.type = type;
    }
    
    public String type() {
        return type;
    }
    
    public static EvaluationType fromType(String type) {
        for (EvaluationType e : EvaluationType.values())
        {
            if (e.type().equals(type))
                return e;
        }
        
        return EvaluationType.WEIGHTED_SUM_FACTOR_AGGREGATION;
    }
}
