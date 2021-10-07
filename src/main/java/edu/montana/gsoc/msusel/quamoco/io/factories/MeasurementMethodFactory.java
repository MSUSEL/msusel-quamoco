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

import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.ManualInstrument;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MetricBasedInstrument;
import edu.montana.gsoc.msusel.quamoco.model.measurement.RuleBasedInstrument;
import edu.montana.gsoc.msusel.quamoco.model.measurement.aggregation.*;
import org.w3c.dom.Element;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MeasurementMethodFactory extends AbstractQMElementFactory {

    /**
     *
     */
    private MeasurementMethodFactory() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @author Isaac Griffith
     */
    private static class Holder {

        /**
         *
         */
        private static final MeasurementMethodFactory INSTANCE = new MeasurementMethodFactory();
    }

    /**
     * @return
     */
    public static MeasurementMethodFactory instance() {
        return Holder.INSTANCE;
    }

    public MeasurementMethod create(Element e, ModelManager manager) { return null; }

    public MeasurementMethod create(Element e, ModelManager manager, Measure determines) {
        MeasurementMethod method = null;
        this.manager = manager;

        if (e.hasAttribute("xsi:type")) {
            MeasurementMethodType type = MeasurementMethodType.fromType(e.getAttribute("xsi:type"));
            switch (type) {
                case TOOL_BASED_INSTRUMENT:
                    method = createToolBasedInstrument(e, determines);
                    break;
                case MANUAL_INSTRUMENT:
                    method = createManualInstrument(e, determines);
                    break;
                case RULE_BASED_INSTRUMENT:
                    method = createRuleBasedInstrument(e, determines);
                    break;
                case METRIC_BASED_INSTRUMENT:
                    method = createMetricBasedInstrument(e, determines);
                    break;
                case QIESL_AGGREGATION:
                    method = createQIESLAggregation(e, determines);
                    break;
                case TEXT_AGGREGATION:
                    method = createTextAggregation(e, determines);
                    break;
                case FINDINGS_INTERSECTION_MEASURE_AGGREGATION:
                    method = createFindingsIntersectionMeasureAggregation(e, determines);
                    break;
                case FINDINGS_UNION_MEASURE_AGGREGATION:
                    method = createFindingsUnionMeasureAggregation(e, determines);
                    break;
                case NUMBER_HISTOGRAM_COMP_MEASURE_AGGREGATION:
                    method = createNumberHistogramCompMeasureAggregation(e, determines);
                    break;
                case NUMBER_MAX_MEASURE_AGGREGATION:
                    method = createNumberMaxMeasureAggregation(e, determines);
                    break;
                case NUMBER_MEAN_MEASURE_AGGREGATION:
                    method = createNumberMeanMeasureAggregation(e, determines);
                    break;
                case NUMBER_MEDIAN_MEASURE_AGGREGATION:
                    method = createNumberMedianMeasureAggregation(e, determines);
                    break;
                case NUMBER_MIN_MEASURE_AGGREGATION:
                    method = createNumberMinMeasureAggregation(e, determines);
                    break;
                case NUMBER_MODE_MEASURE_AGGREGATION:
                    method = createNumberModeMeasureAggregation(e, determines);
                    break;
                case NUMBER_RANGE_MEASURE_AGGREGATION:
                    method = createNumberRangeMeasureAggregation(e, determines);
                    break;
                case NUMBER_STD_DEV_MEASURE_AGGREGATION:
                    method = createNumberStdDevMeasureAggregation(e, determines);
                    break;
                case NUMBER_SUMMATION_MEASURE_AGGREGATION:
                    method = createNumberSummationMeasureAggregation(e, determines);
                    break;
                case NUMBER_VARIANCE_MEASURE_AGGREGATION:
                    method = createNumberVarianceMeasureAggregation(e, determines);
                    break;
            }
        }

        return method;
    }

    private MeasurementMethod createToolBasedInstrument(Element e, Measure determines) {
        if (determines == null || determines.getType() == MeasureType.FINDINGS) {
            return createRuleBasedInstrument(e, determines);
        } else {
            return createMetricBasedInstrument(e, determines);
        }
    }

    private MeasurementMethod createManualInstrument(Element e, Measure determines) {
        return ManualInstrument.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createRuleBasedInstrument(Element e, Measure determines) {
        return RuleBasedInstrument.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.hasAttribute("metric") ? e.getAttribute("metric") : e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createMetricBasedInstrument(Element e, Measure determines) {
        return MetricBasedInstrument.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.hasAttribute("metric") ? e.getAttribute("metric") : e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createQIESLAggregation(Element e, Measure determines) {
        return QIESLAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .specification(e.getAttribute("specification"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createTextAggregation(Element e, Measure determines) {
        return TextAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .specification(e.getAttribute("specification"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createFindingsIntersectionMeasureAggregation(Element e, Measure determines) {
        return FindingsIntersectionMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createFindingsUnionMeasureAggregation(Element e, Measure determines) {
        return FindingsUnionMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberHistogramCompMeasureAggregation(Element e, Measure determines) {
        return NumberHistogramCompMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberMaxMeasureAggregation(Element e, Measure determines) {
        return NumberMaxMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberMeanMeasureAggregation(Element e, Measure determines) {
        return NumberMeanMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberMedianMeasureAggregation(Element e, Measure determines) {
        return NumberMedianMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberMinMeasureAggregation(Element e, Measure determines) {
        return NumberMinMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberModeMeasureAggregation(Element e, Measure determines) {
        return NumberModeMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberRangeMeasureAggregation(Element e, Measure determines) {
        return NumberRangeMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberStdDevMeasureAggregation(Element e, Measure determines) {
        return NumberStdDevMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberSummationMeasureAggregation(Element e, Measure determines) {
        return NumberSummationMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }

    private MeasurementMethod createNumberVarianceMeasureAggregation(Element e, Measure determines) {
        return NumberVarianceMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(determines)
                .create();
    }
}
