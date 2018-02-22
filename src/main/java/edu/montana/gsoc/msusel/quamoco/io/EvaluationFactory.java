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

import org.w3c.dom.Element;

import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.HistCompMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.HistogramCompFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.ManualEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.MaxFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MaxMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.MeanFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MeanMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.MedianFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MedianMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.MinFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MinMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.ModeFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.ModeMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.QIESLEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.RangeFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.RangeMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.StdDevFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.StdDevMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SummationMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.TextEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.VarianceFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.VarianceMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.WeightedSumMultiMeasureEvaluation;

/**
 * @author Isaac Griffith
 * @version 1.2.0
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
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createSummationMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) SummationMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createStdDevMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) StdDevMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createRangeMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) RangeMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createModeMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) ModeMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMinMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) MinMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMedianMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) MedianMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMeanMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) MeanMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMaxMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) MaxMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createHistCompMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) HistCompMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createVarianceFactorAggregation(Element e)
    {
        return (Evaluation) VarianceFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createStdDevFactorAggregation(Element e)
    {
        return (Evaluation) StdDevFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createRangeFactorAggregation(Element e)
    {
        return (Evaluation) RangeFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createModeFactorAggregation(Element e)
    {
        return (Evaluation) ModeFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMinFactorAggregation(Element e)
    {
        return (Evaluation) MinFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMedianFactorAggregation(Element e)
    {
        return (Evaluation) MedianFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMeanFactorAggregation(Element e)
    {
        return (Evaluation) MeanFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createMaxFactorAggregation(Element e)
    {
        return (Evaluation) MaxFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createHistogramCompFactorAggregation(Element e)
    {
        return (Evaluation) HistogramCompFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createWeightedSumMultiMeasureEvaluation(Element e)
    {
        return (Evaluation) WeightedSumMultiMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createManualEvaluation(Element e)
    {
        return (Evaluation) ManualEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createWeightedSumFactorAggregation(Element e)
    {
        return (Evaluation) WeightedSumFactorAggregation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createSingleMeasureEvaluation(Element e)
    {
        return (Evaluation) SingleMeasureEvaluation.builder()
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Evaluation createQIESLEvaluation(Element e)
    {
        return (Evaluation) QIESLEvaluation.builder()
                .create();
    }

    /**
     * @param e
     */
    private Evaluation createTextEvaluation(Element e)
    {
        return (Evaluation) TextEvaluation.builder()
                .create();
    }
}
