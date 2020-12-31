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
/**
 * 
 */
package edu.montana.gsoc.msusel.quamoco.distiller;

import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.QualityModel;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.factor.ProductFactor;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.FactorRanking;
import org.junit.Assert;
import org.junit.Test;

/**
 * The class <code>DistilledGraphCreatorTest</code> contains tests for the class
 * <code>{@link DistilledGraphCreator}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class DistilledGraphCreatorTest {

    /**
     * Run the DistilledGraphCreator() constructor test.
     */
    @Test
    public void testDistilledGraphCreator_1() {

        final DistilledGraphCreator result = new DistilledGraphCreator();

        Assert.assertNotNull(result);
    }

    /**
     * Run the MutableNetwork<Node, Edge> buildGraph(List
     * <QualityModel>,DecoratorContext) method test.
     */
    @Test
    public void testBuildGraph_1() {
        final DistilledGraphCreator fixture = new DistilledGraphCreator();
        ModelManager manager = new ModelManager();
        Factor f2 = null;
        Measure m1 = null;
        Factor f1 = null;
        QualityModel model = QualityModel.builder().identifier("java").fileName("java.qm")
                .description("")
                .title("")
                .factor("factor2", f2 = ProductFactor.builder().name("factor2").identifier("factor2").create())
                .factor("factor1", f1 = (Factor) ProductFactor.builder().name("factor1").identifier("factor1")
                        .description("")
                        .refines(f2)
                        .create())
                .measure("measure1", m1 = Measure.builder()
                        .name("measure1")
                        .identifier("measure1")
                        .description("")
                        .title("")
                        .type(MeasureType.FINDINGS)
                        .create())
                .evaluation("eval1", (Evaluation) SingleMeasureEvaluation.builder().identifier("eval1")
                        .basedOn(m1)
                        .evaluates(f1)
                        .create())
                .evaluation("eval2", (Evaluation) WeightedSumFactorAggregation.builder().identifier("eval2")
                        .ranking(FactorRanking.builder()
                                .identifier("rank1")
                                .factor(f1)
                                .rank(1)
                                .weight(0.25)
                                .create())
                        .completeness(1.0)
                        .description("")
                        .maximumPoints(100d)
                        .evaluates(f2)
                        .title("")
                        .create())
                .create();
        manager.addModel(model);

        final MutableNetwork<Node, Edge> result = fixture.buildGraph(manager);

        Assert.assertEquals(3, result.nodes().size());
    }
}
