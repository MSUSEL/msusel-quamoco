/*
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.quamoco.io.factories;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public enum MeasurementMethodType {

    TOOL_BASED_INSTRUMENT("qm:ToolBasedInstrument"),
    /**
     *
     */
    MANUAL_INSTRUMENT("qm:ManualInstrument"),
    /**
     *
     */
    METRIC_BASED_INSTRUMENT("qm:MetricBasedInstrument"),
    /**
     *
     */
    RULE_BASED_INSTRUMENT("qm:RuleBasedInstrument"),
    /**
     *
     */
    FINDINGS_INTERSECTION_MEASURE_AGGREGATION("qm:FindingsIntersectionMeasureAggregation"),
    /**
     *
     */
    FINDINGS_UNION_MEASURE_AGGREGATION("qm:FindingsUnionMeasureAggregation"),
    /**
     *
     */
    NUMBER_HISTOGRAM_COMP_MEASURE_AGGREGATION("qm:NumberHistogramCompMeasureAggregation"),
    /**
     *
     */
    NUMBER_MAX_MEASURE_AGGREGATION("qm:NumberMaxMeasureAggregation"),
    /**
     *
     */
    NUMBER_MEAN_MEASURE_AGGREGATION("qm:NumberMeanMeasureAggregation"),
    /**
     *
     */
    NUMBER_MEDIAN_MEASURE_AGGREGATION("qm:NumberMedianMeasureAggregation"),
    /**
     *
     */
    NUMBER_MIN_MEASURE_AGGREGATION("qm:NumberMinMeasureAggregation"),
    /**
     *
     */
    NUMBER_MODE_MEASURE_AGGREGATION("qm:NumberModeMeasureAggregation"),
    /**
     *
     */
    NUMBER_RANGE_MEASURE_AGGREGATION("qm:NumberRangeMeasureAggregation"),
    /**
     *
     */
    NUMBER_STD_DEV_MEASURE_AGGREGATION("qm:NumberStdDevMeasureAggregation"),
    /**
     *
     */
    NUMBER_SUMMATION_MEASURE_AGGREGATION("qm:NumberSummationMeasureAggregation"),
    /**
     *
     */
    NUMBER_VARIANCE_MEASURE_AGGREGATION("qm:NumberVarianceMeasureAggregation"),
    /**
     *
     */
    TEXT_AGGREGATION("qm:TextAggregation"),
    /**
     *
     */
    QIESL_AGGREGATION("qm:QIESLAggregation");

    private String type;

    MeasurementMethodType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

    public static MeasurementMethodType fromType(String type) {
        for (MeasurementMethodType m : MeasurementMethodType.values()) {
            if (m.type().equals(type))
                return m;
        }

        return RULE_BASED_INSTRUMENT;
    }
}
