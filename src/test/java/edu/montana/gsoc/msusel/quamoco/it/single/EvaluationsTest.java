/**
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
package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.ManualEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.TextEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.WeightedSumMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearDecreasingFunction;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearFunction;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearIncreasingFunction;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluationsTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMaintainabilitySingleMeasureEval() {
        SingleMeasureEvaluation m = (SingleMeasureEvaluation) manager.findEvaluationByName("Test/Maintainability/SingleMeasureEvaluation");
        assertNotNull(m);

        assertEquals("", m.getTitle());
        assertEquals("Test evaluation for maintainability", m.getDescription());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertEquals(100.0, m.getCompleteness(), 0.001);
        assertEquals(100.0, m.getMaximumPoints(), 0.001);
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());
        assertEquals(NormalizationRange.FILE, m.getRange());
        assertNotNull(m.getNormalization());
        assertEquals("Test Normalization", m.getNormalization().getName());
        assertEquals("Test Measure", m.getBasedOn().getName());

        assertNotNull("Maintainability", m.getEvaluates().getName());
        assertNotNull(m.getFunction());

        assertTrue(m.getFunction() instanceof LinearIncreasingFunction);
        assertEquals(1.0, ((LinearIncreasingFunction) m.getFunction()).getUpperBound(), 0.001);
        assertEquals(0.0, ((LinearIncreasingFunction) m.getFunction()).getLowerBound(), 0.001);
    }

    @Test
    public void testProductQualityWeightedSumFactorAggregation() {
        WeightedSumFactorAggregation m = (WeightedSumFactorAggregation) manager.findEvaluationByName("Test/Quality @Product/WeightedSumFactorAggregation");
        assertNotNull(m);

        assertEquals("Product Quality Aggregation", m.getTitle());
        assertEquals("Aggregates Product Quality", m.getDescription());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertEquals(100.0, m.getCompleteness(), 0.001);
        assertEquals(100.0, m.getMaximumPoints(), 0.001);
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());

        assertEquals(3, m.getRankings().size());

        assertEquals(1, m.getRankings().get(0).getRank());
        assertEquals("Maintainability", m.getRankings().get(0).getFactor().getName());
        assertEquals("Maintainability", m.getRankings().get(0).getName());
//        assertEquals(33.33, m.getRankings().get(0).getContributionPoints(), 0.01);
        assertEquals(0.333, m.getRankings().get(0).getWeight(), 0.001);
//        assertEquals(InfluenceEffect.POSITIVE, m.getRankings().get(0).getInfluence());

        assertEquals(1, m.getRankings().get(1).getRank());
        assertEquals("Security", m.getRankings().get(1).getFactor().getFullName());
        assertEquals("Security", m.getRankings().get(1).getName());
//        assertEquals(33.33, m.getRankings().get(1).getContributionPoints(), 0.01);
        assertEquals(0.333, m.getRankings().get(1).getWeight(), 0.001);
//        assertEquals(InfluenceEffect.REFINEMENT, m.getRankings().get(1).getInfluence());

        assertEquals(1, m.getRankings().get(2).getRank());
        assertEquals("Quality @Source Code Part", m.getRankings().get(2).getFactor().getFullName());
        assertEquals("Quality @Source Code Part", m.getRankings().get(2).getName());
//        assertEquals(33.33, m.getRankings().get(2).getContributionPoints(), 0.01);
        assertEquals(0.333, m.getRankings().get(2).getWeight(), 0.001);
//        assertEquals(InfluenceEffect.POSITIVE, m.getRankings().get(2).getInfluence());

    }

    @Test
    public void testSourceCodePartQualityWeightedSumFactorAggregation() {
        WeightedSumFactorAggregation m = (WeightedSumFactorAggregation) manager.findEvaluationByName("Test/Quality @Source Code Part/WeightedSumFactorAggregation");
        assertNotNull(m);

        assertEquals("Source Code Quality Eval", m.getTitle());
        assertEquals("Aggregates Source Code Quality", m.getDescription());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertEquals(100.0, m.getCompleteness(), 0.001);
        assertEquals(100.0, m.getMaximumPoints(), 0.001);
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());

        assertEquals(2, m.getRankings().size());

        assertEquals(1, m.getRankings().get(0).getRank());
        assertEquals("Maintainability", m.getRankings().get(0).getFactor().getName());
        assertEquals("Maintainability", m.getRankings().get(0).getName());
//        assertEquals(50.0, m.getRankings().get(0).getContributionPoints(), 0.01);
        assertEquals(0.5, m.getRankings().get(0).getWeight(), 0.001);
//        assertEquals(InfluenceEffect.POSITIVE, m.getRankings().get(0).getInfluence());

        assertEquals(1, m.getRankings().get(1).getRank());
        assertEquals("Security", m.getRankings().get(1).getFactor().getName());
        assertEquals("Security", m.getRankings().get(1).getName());
//        assertEquals(50.0, m.getRankings().get(2).getContributionPoints(), 0.01);
        assertEquals(0.5, m.getRankings().get(1).getWeight(), 0.001);
//        assertEquals(InfluenceEffect.REFINEMENT, m.getRankings().get(1).getInfluence());
    }

    @Test
    public void testSecuritySingleMeasureEval() {
        SingleMeasureEvaluation m = (SingleMeasureEvaluation) manager.findEvaluationByName("Test/Security/SingleMeasureEvaluation");
        assertNotNull(m);

        assertEquals("Test Measure for Security", m.getTitle());
        assertEquals("Security test measue evaluation", m.getDescription());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertEquals(100.0, m.getCompleteness(), 0.001);
        assertEquals(100.0, m.getMaximumPoints(), 0.001);
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());

        assertNotNull("Security", m.getEvaluates().getName());
        assertNotNull(m.getFunction());

        assertTrue(m.getFunction() instanceof LinearDecreasingFunction);
        assertEquals(1.0, ((LinearFunction) m.getFunction()).getUpperBound(), 0.001);
        assertEquals(0.0, ((LinearFunction) m.getFunction()).getLowerBound(), 0.001);
    }

    @Test
    public void testReliabilityWeightedSumFactorAggr() {
        WeightedSumFactorAggregation eval = (WeightedSumFactorAggregation) manager.findEvaluationByName("TestHier/Reliability/WeightedSumFactorAggregation");
        assertNotNull(eval);

        assertEquals("WeightedSumFactorAggregation", eval.getName());
        assertEquals("Test Hier WSFA", eval.getTitle());
        assertEquals("Test Hier WSFA", eval.getDescription());
        assertEquals("TestHier Source", eval.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", eval.getTaggedBy().get(0).getName());
        assertEquals("Reliability", eval.getEvaluates().getName());
        assertEquals(100.0, eval.getMaximumPoints(), 0.001);
        assertEquals(100.0, eval.getCompleteness(), 0.001);

        // Factor Aggregation
        assertEquals(5, eval.getRankings().size());

        assertEquals(1, eval.getRankings().get(0).getRank());
        assertEquals("RelManual", eval.getRankings().get(0).getFactor().getName());
        assertEquals("RelManual", eval.getRankings().get(0).getName());
        assertEquals(0.20, eval.getRankings().get(0).getWeight(), 0.001);
        assertEquals(InfluenceEffect.NEGATIVE, eval.getRankings().get(0).getInfluence());

        assertEquals(1, eval.getRankings().get(1).getRank());
        assertEquals("RelMultMeasure", eval.getRankings().get(1).getFactor().getName());
        assertEquals("RelMultMeasure", eval.getRankings().get(1).getName());
        assertEquals(0.20, eval.getRankings().get(1).getWeight(), 0.001);
        assertEquals(InfluenceEffect.POSITIVE, eval.getRankings().get(1).getInfluence());

        assertEquals(1, eval.getRankings().get(2).getRank());
        assertEquals("RelQIESL", eval.getRankings().get(2).getFactor().getName());
        assertEquals("RelQIESL", eval.getRankings().get(2).getName());
        assertEquals(0.20, eval.getRankings().get(2).getWeight(), 0.001);
        assertEquals(InfluenceEffect.NEGATIVE, eval.getRankings().get(2).getInfluence());

        assertEquals(1, eval.getRankings().get(3).getRank());
        assertEquals("RelText", eval.getRankings().get(3).getFactor().getName());
        assertEquals("RelText", eval.getRankings().get(3).getName());
        assertEquals(0.20, eval.getRankings().get(3).getWeight(), 0.001);
        assertEquals(InfluenceEffect.POSITIVE, eval.getRankings().get(3).getInfluence());

        assertEquals(1, eval.getRankings().get(4).getRank());
        assertEquals("UnionFactor", eval.getRankings().get(4).getFactor().getName());
        assertEquals("UnionFactor", eval.getRankings().get(4).getName());
        assertEquals(0.20, eval.getRankings().get(4).getWeight(), 0.001);
        assertEquals(InfluenceEffect.POSITIVE, eval.getRankings().get(4).getInfluence());

    }

    @Test
    public void testRelManualManualEval() {
        ManualEvaluation eval = (ManualEvaluation) manager.findEvaluationByName("TestHier/RelManual/ManualEvaluation");
        assertNotNull(eval);

        assertEquals("ManualEvaluation", eval.getName());
        assertEquals("Test Hier Manual Eval", eval.getTitle());
        assertEquals("Test Hier Manual Eval", eval.getDescription());
        assertEquals("TestHier Source", eval.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", eval.getTaggedBy().get(0).getName());
        assertEquals("RelManual", eval.getEvaluates().getName());
        assertEquals(100.0, eval.getMaximumPoints(), 0.001);
        assertEquals(100.0, eval.getCompleteness(), 0.001);
    }

    @Test
    public void testRelMultMeasureWeightedSumMultiMeasureEval() {
        WeightedSumMultiMeasureEvaluation eval = (WeightedSumMultiMeasureEvaluation) manager.findEvaluationByName("TestHier/RelMultMeasure/WeightedSumMultiMeasureEvaluation");
        assertNotNull(eval);

        assertEquals("WeightedSumMultiMeasureEvaluation", eval.getName());
        assertEquals("Test Hier WSMME", eval.getTitle());
        assertEquals("Test Hier WSMME", eval.getDescription());
        assertEquals("TestHier Source", eval.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", eval.getTaggedBy().get(0).getName());
        assertEquals("RelMultMeasure", eval.getEvaluates().getName());
        assertEquals(100.0, eval.getMaximumPoints(), 0.001);
        assertEquals(100.0, eval.getCompleteness(), 0.001);

        // Evaluation Function
        assertEquals("Measure1", eval.getRankings().get(0).getMeasure().getName());
        assertEquals(1, eval.getRankings().get(0).getRank());
        assertEquals(0.25, eval.getRankings().get(0).getWeight(), 0.001);
        //assertEquals(100.0, eval.getRankings().get(0).getCompleteness(), 0.001);
        //assertEquals("RelMultMeasure", eval.getRankings().get(0).getEvaluates().getName());
        //assertEquals(100.0, eval.getRankings().get(0).getMaximumPoints(), 0.001);
        LinearFunction f = (LinearFunction) eval.getRankings().get(0).getFunction();
        assertEquals(0.0, f.getLowerBound(), 0.001);
        assertEquals(1.0, f.getUpperBound(), 0.001);
        assertTrue(f instanceof LinearIncreasingFunction);

        assertEquals("Measure2", eval.getRankings().get(1).getMeasure().getName());
        assertEquals(1, eval.getRankings().get(1).getRank());
        assertEquals(0.25, eval.getRankings().get(1).getWeight(), 0.001);
//        assertEquals(100.0, eval.getRankings().get(1).getCompleteness(), 0.001);
//        assertEquals("RelMultMeasure", eval.getRankings().get(1).getEvaluates().getName());
//        assertEquals(100.0, eval.getRankings().get(1).getMaximumPoints(), 0.001);
        f = (LinearFunction) eval.getRankings().get(1).getFunction();
        assertEquals(0.0, f.getLowerBound(), 0.001);
        assertEquals(1.0, f.getUpperBound(), 0.001);
        assertTrue(f instanceof LinearDecreasingFunction);

        assertEquals("Measure3", eval.getRankings().get(2).getMeasure().getName());
        assertEquals(1, eval.getRankings().get(2).getRank());
        assertEquals(0.25, eval.getRankings().get(2).getWeight(), 0.001);
//        assertEquals(100.0, eval.getRankings().get(2).getCompleteness(), 0.001);
//        assertEquals("RelMultMeasure", eval.getRankings().get(2).getEvaluates().getName());
//        assertEquals(100.0, eval.getRankings().get(2).getMaximumPoints(), 0.001);
        f = (LinearFunction) eval.getRankings().get(2).getFunction();
        assertEquals(0.0, f.getLowerBound(), 0.001);
        assertEquals(1.0, f.getUpperBound(), 0.001);
        assertTrue(f instanceof LinearIncreasingFunction);

        assertEquals("ToolMeas", eval.getRankings().get(3).getMeasure().getName());
        assertEquals(1, eval.getRankings().get(3).getRank());
        assertEquals(0.25, eval.getRankings().get(3).getWeight(), 0.001);
//        assertEquals(100.0, eval.getRankings().get(3).getCompleteness(), 0.001);
//        assertEquals("RelMultMeasure", eval.getRankings().get(3).getEvaluates().getName());
//        assertEquals(100.0, eval.getRankings().get(3).getMaximumPoints(), 0.001);
        f = (LinearFunction) eval.getRankings().get(3).getFunction();
        assertEquals(0.0, f.getLowerBound(), 0.001);
        assertEquals(1.0, f.getUpperBound(), 0.001);
        assertTrue(f instanceof LinearDecreasingFunction);
    }

    @Test
    public void testRelQIESLEval() {
        Evaluation eval = manager.findEvaluationByName("TestHier/RelQIESL/QIESLEvaluation");
        assertNotNull(eval);

        assertEquals("QIESLEvaluation", eval.getName());
        assertEquals("Test Hier QIESLEval", eval.getTitle());
        assertEquals("Test Hier QIESLEval", eval.getDescription());
        assertEquals("TestHier Source", eval.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", eval.getTaggedBy().get(0).getName());
        assertEquals("RelQIESL", eval.getEvaluates().getName());
        assertEquals(100.0, eval.getMaximumPoints(), 0.001);
        assertEquals(100.0, eval.getCompleteness(), 0.001);
    }

    @Test
    public void testRelTextEval() {
        TextEvaluation eval = (TextEvaluation) manager.findEvaluationByName("TestHier/RelText/TextEvaluation");
        assertNotNull(eval);

        assertEquals("TextEvaluation", eval.getName());
        assertEquals("Test Hier TextEvaluation", eval.getTitle());
        assertEquals("Test Hier TextEval", eval.getDescription());
        assertEquals("TestHier Source", eval.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", eval.getTaggedBy().get(0).getName());
        assertEquals("RelText", eval.getEvaluates().getName());
        assertEquals(100.0, eval.getMaximumPoints(), 0.001);
        assertEquals(100.0, eval.getCompleteness(), 0.001);
        assertEquals("", eval.getSpecification());
    }

    @Test
    public void testUnionFactorSingleMeasureEval() {
        SingleMeasureEvaluation eval = (SingleMeasureEvaluation) manager.findEvaluationByName("TestHier/UnionFactor/SingleMeasureEvaluation");
        assertNotNull(eval);

        assertEquals("SingleMeasureEvaluation", eval.getName());
        assertEquals("UnionEval", eval.getTitle());
        assertEquals("UnionEval", eval.getDescription());
        assertEquals("TestHier Source", eval.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", eval.getTaggedBy().get(0).getName());
        assertEquals("UnionFactor", eval.getEvaluates().getName());
        assertEquals(100.0, eval.getMaximumPoints(), 0.001);
        assertEquals(100.0, eval.getCompleteness(), 0.001);

        assertNotNull(eval.getFunction());

        assertTrue(eval.getFunction() instanceof LinearIncreasingFunction);
        assertEquals(1.0, ((LinearIncreasingFunction) eval.getFunction()).getUpperBound(), 0.001);
        assertEquals(0.0, ((LinearIncreasingFunction) eval.getFunction()).getLowerBound(), 0.001);
    }
}
