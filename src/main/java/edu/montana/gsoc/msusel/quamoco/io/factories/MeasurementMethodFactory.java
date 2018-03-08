/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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
 * @version 1.2.0
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

    /**
     * {@inheritDoc}
     */
    @Override
    public MeasurementMethod create(Element e, ModelManager manager) {
        MeasurementMethod method = null;
        this.manager = manager;

        if (e.hasAttribute("xsi:type")) {
            MeasurementMethodType type = MeasurementMethodType.fromType(e.getAttribute("xsi:type"));
            switch (type) {
                case TOOL_BASED_INSTRUMENT:
                    method = createToolBasedInstrument(e);
                    break;
                case MANUAL_INSTRUMENT:
                    method = createManualInstrument(e);
                    break;
                case RULE_BASED_INSTRUMENT:
                    method = createRuleBasedInstrument(e);
                    break;
                case METRIC_BASED_INSTRUMENT:
                    method = createMetricBasedInstrument(e);
                    break;
                case QIESL_AGGREGATION:
                    method = createQIESLAggregation(e);
                    break;
                case TEXT_AGGREGATION:
                    method = createTextAggregation(e);
                    break;
                case FINDINGS_INTERSECTION_MEASURE_AGGREGATION:
                    method = createFindingsIntersectionMeasureAggregation(e);
                    break;
                case FINDINGS_UNION_MEASURE_AGGREGATION:
                    method = createFindingsUnionMeasureAggregation(e);
                    break;
                case NUMBER_HISTOGRAM_COMP_MEASURE_AGGREGATION:
                    method = createNumberHistogramCompMeasureAggregation(e);
                    break;
                case NUMBER_MAX_MEASURE_AGGREGATION:
                    method = createNumberMaxMeasureAggregation(e);
                    break;
                case NUMBER_MEAN_MEASURE_AGGREGATION:
                    method = createNumberMeanMeasureAggregation(e);
                    break;
                case NUMBER_MEDIAN_MEASURE_AGGREGATION:
                    method = createNumberMedianMeasureAggregation(e);
                    break;
                case NUMBER_MIN_MEASURE_AGGREGATION:
                    method = createNumberMinMeasureAggregation(e);
                    break;
                case NUMBER_MODE_MEASURE_AGGREGATION:
                    method = createNumberModeMeasureAggregation(e);
                    break;
                case NUMBER_RANGE_MEASURE_AGGREGATION:
                    method = createNumberRangeMeasureAggregation(e);
                    break;
                case NUMBER_STD_DEV_MEASURE_AGGREGATION:
                    method = createNumberStdDevMeasureAggregation(e);
                    break;
                case NUMBER_SUMMATION_MEASURE_AGGREGATION:
                    method = createNumberSummationMeasureAggregation(e);
                    break;
                case NUMBER_VARIANCE_MEASURE_AGGREGATION:
                    method = createNumberVarianceMeasureAggregation(e);
                    break;
            }
        }

        return method;
    }

    private MeasurementMethod createToolBasedInstrument(Element e) {
        Measure determines = manager.findMeasure(e.getAttribute("determines"));
        if (determines.getType() == MeasureType.FINDINGS) {
            return createRuleBasedInstrument(e);
        } else {
            return createMetricBasedInstrument(e);
        }
    }

    private MeasurementMethod createManualInstrument(Element e) {
        return ManualInstrument.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createRuleBasedInstrument(Element e) {
        return RuleBasedInstrument.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .tool(manager.findTool(e.getAttribute("tool")))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createMetricBasedInstrument(Element e) {
        return MetricBasedInstrument.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .tool(manager.findTool(e.getAttribute("tool")))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createQIESLAggregation(Element e) {
        return QIESLAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .specification(e.getAttribute("specification"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createTextAggregation(Element e) {
        return TextAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .specification(e.getAttribute("specification"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createFindingsIntersectionMeasureAggregation(Element e) {
        return FindingsIntersectionMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createFindingsUnionMeasureAggregation(Element e) {
        return FindingsUnionMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberHistogramCompMeasureAggregation(Element e) {
        return NumberHistogramCompMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberMaxMeasureAggregation(Element e) {
        return NumberMaxMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberMeanMeasureAggregation(Element e) {
        return NumberMeanMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("name"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberMedianMeasureAggregation(Element e) {
        return NumberMedianMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberMinMeasureAggregation(Element e) {
        return NumberMinMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberModeMeasureAggregation(Element e) {
        return NumberModeMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberRangeMeasureAggregation(Element e) {
        return NumberRangeMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberStdDevMeasureAggregation(Element e) {
        return NumberStdDevMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberSummationMeasureAggregation(Element e) {
        return NumberSummationMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }

    private MeasurementMethod createNumberVarianceMeasureAggregation(Element e) {
        return NumberVarianceMeasureAggregation.builder()
                .identifier(e.getAttribute("xmi:id"))
                .metric(e.getAttribute("metric"))
                .description(e.getAttribute("description"))
                .title(e.getAttribute("title"))
                .determines(manager.findMeasure(e.getAttribute("determines")))
                .create();
    }
}
