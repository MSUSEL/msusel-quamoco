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
package edu.montana.gsoc.msusel.quamoco.io;

import org.w3c.dom.Element;

import edu.montana.gsoc.msusel.quamoco.model.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.HistCompMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.HistogramCompFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.ManualEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.MaxFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.MaxMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.MeanFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.MeanMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.MedianFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.MedianMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.MinFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.MinMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.ModeFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.ModeMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.QIESLEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.RangeFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.RangeMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.StdDevFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.StdDevMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.SummationMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.TextEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.VarianceFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.VarianceMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.WeightedSumMultiMeasureEvaluation;

/**
 * @author Isaac Griffith
 */
public class EvaluationFactory extends AbstractQMElementFactory {

    /**
     * 
     */
    private EvaluationFactory() {
        
    }
    
    /**
     * @author Isaac Griffith
     *
     */
    private static class Holder {
        
        /**
         * 
         */
        private static final EvaluationFactory INSTANCE = new EvaluationFactory();
    }
    
    /**
     * @return
     */
    public static EvaluationFactory instance() {
        return Holder.INSTANCE;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public Evaluation create(Element e)
    {
        Evaluation eval = null;

        if (e.hasAttribute("xsi:type"))
        {
            EvaluationType type = EvaluationType.fromType(e.getAttribute("xsi:type"));
            switch (type)
            {
            case TEXT_EVALUATION:
                eval = createTextEvaluation(e);
                break;
            case QIESL_EVALUATION:
                eval = createQIESLEvaluation(e);
                break;
            case SINGLE_MEASURE_EVALUATION:
                eval = createSingleMeasureEvaluation(e);
                break;
            case WEIGHTED_SUM_FACTOR_AGGREGATION:
                eval = createWeightedSumFactorAggregation(e);
                break;
            case MANUAL_EVALUATION:
                eval = createManualEvaluation(e);
                break;
            case WEIGHTED_SUM_MULTI_MEASURE_EVALUATION:
                eval = createWeightedSumMultiMeasureEvaluation(e);
                break;
            case HISTOGRAM_COMP_FACTOR_AGGREGATION:
                eval = createHistogramCompFactorAggregation(e);
                break;
            case MAX_FACTOR_AGGREGATION:
                eval = createMaxFactorAggregation(e);
                break;
            case MEAN_FACTOR_AGGREGATION:
                eval = createMeanFactorAggregation(e);
                break;
            case MEDIAN_FACTOR_AGGREGATION:
                eval = createMedianFactorAggregation(e);
                break;
            case MIN_FACTOR_AGGREGATION:
                eval = createMinFactorAggregation(e);
                break;
            case MODE_FACTOR_AGGREGATION:
                eval = createModeFactorAggregation(e);
                break;
            case RANGE_FACTOR_AGGREGATION:
                eval = createRangeFactorAggregation(e);
                break;
            case SUMMATION_FACTOR_AGGREGATION:
                eval = createSummationFactorAggregation(e);
                break;
            case STD_DEV_FACTOR_AGGREGATION:
                eval = createStdDevFactorAggregation(e);
                break;
            case VARIANCE_FACTOR_AGGREGATION:
                eval = createVarianceFactorAggregation(e);
                break;
            case HIST_COMP_MULTI_MEASURE_EVALUATION:
                eval = createHistCompMultiMeasureEvaluation(e);
                break;
            case MAX_MULTI_MEASURE_EVALUATION:
                eval = createMaxMultiMeasureEvaluation(e);
                break;
            case MEAN_MULTI_MEASURE_EVALUATION:
                eval = createMeanMultiMeasureEvaluation(e);
                break;
            case MEDIAN_MULTI_MEASURE_EVALUATION:
                eval = createMedianMultiMeasureEvaluation(e);
                break;
            case MIN_MULTI_MEASURE_EVALUATION:
                eval = createMinMultiMeasureEvaluation(e);
                break;
            case MODE_MULTI_MEASURE_EVALUATION:
                eval = createModeMultiMeasureEvaluation(e);
                break;
            case RANGE_MULTI_MEASURE_EVALUATION:
                eval = createRangeMultiMeasureEvaluation(e);
                break;
            case STD_DEV_MULTI_MEASURE_EVALUATION:
                eval = createStdDevMultiMeasureEvaluation(e);
                break;
            case SUMMATION_MULTI_MEASURE_EVALUATION:
                eval = createSummationMultiMeasureEvaluation(e);
                break;
            case VARIANCE_MULTI_MEASURE_EVALUATION:
                eval = createVarianceMultiMeasureEvaluation(e);
                break;
            }
        }

        return eval;
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createSummationFactorAggregation(Element e)
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createVarianceMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) VarianceMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .annotation(null)
                .originatesFrom(null)
                .taggedBy(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createSummationMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) SummationMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createStdDevMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) StdDevMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createRangeMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) RangeMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createModeMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) ModeMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMinMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) MinMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMedianMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) MedianMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMeanMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) MeanMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMaxMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) MaxMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createHistCompMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) HistCompMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createVarianceFactorAggregation(Element e)
    {
        return (Evaluation) VarianceFactorAggregation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createStdDevFactorAggregation(Element e)
    {
        return (Evaluation) StdDevFactorAggregation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createRangeFactorAggregation(Element e)
    {
        return (Evaluation) RangeFactorAggregation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createModeFactorAggregation(Element e)
    {
        return (Evaluation) ModeFactorAggregation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMinFactorAggregation(Element e)
    {
        return (Evaluation) MinFactorAggregation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMedianFactorAggregation(Element e)
    {
        return (Evaluation) MedianFactorAggregation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMeanFactorAggregation(Element e)
    {
        return (Evaluation) MeanFactorAggregation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMaxFactorAggregation(Element e)
    {
        return (Evaluation) MaxFactorAggregation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createHistogramCompFactorAggregation(Element e)
    {
        return (Evaluation) HistogramCompFactorAggregation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createWeightedSumMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) WeightedSumMultiMeasureEvaluation.builder()
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)                
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createManualEvaluation(Element e)
    {
        return (Evaluation) ManualEvaluation.builder()
                .description("")
                .title("")
                .evaluates(null)
                .originatesFrom(null)
                .taggedBy(null)
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createWeightedSumFactorAggregation(Element e)
    {
        return (Evaluation) WeightedSumFactorAggregation.builder()
                .ranking(null)
                .title("")
                .description("")
                .evaluates(null)
                .originatesFrom(null)
                .taggedBy(null)
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createSingleMeasureEvaluation(Element e)
    {
        return (Evaluation) SingleMeasureEvaluation.builder()
                .basedOn(null)
                .range(null)
                .normalization(null)
                .function(null)
                .title("")
                .description("")
                .evaluates(null)
                .originatesFrom(null)
                .taggedBy(null)
                .annotation(null)
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createQIESLEvaluation(Element e)
    {
        return (Evaluation) QIESLEvaluation.builder()
                .specification("")
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)
                .annotation(null)
                .create();
    }

    /**
     * @param e
     */
    private Evaluation createTextEvaluation(Element e)
    {
        return (Evaluation) TextEvaluation.builder()
                .specification("")
                .title("")
                .description("")
                .completeness(0.0)
                .evaluates(null)
                .maxPts(0.0)
                .originatesFrom(null)
                .taggedBy(null)
                .annotation(null)
                .create();
    }
}
