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
/**
 * 
 */
package edu.montana.gsoc.msusel.quamoco.distiller;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.measurement.FactorRanking;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.factor.ProductFactor;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.QualityModel;

/**
 * The class <code>EdgePopulatorTest</code> contains tests for the class
 * <code>{@link EdgePopulator}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:42 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class EdgePopulatorTest {

    /**
     * Run the EdgePopulator() constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testEdgePopulator_1() throws Exception {

        final EdgePopulator result = new EdgePopulator();

        // TODO: add additional test code here
        Assert.assertNotNull(result);
    }

    /**
     * Run the void modifyGraph(DistillerData,DirectedSparseGraph<Node,Edge>)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testModifyGraph_1() throws Exception {
        final List<QualityModel> models = Lists.newArrayList();
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
                .evaluation((Evaluation) SingleMeasureEvaluation.builder().identifier("eval1")
                        .basedOn(m1)
                        .evaluates(f1)
                        .create())
                .evaluation((Evaluation) WeightedSumFactorAggregation.builder().identifier("eval2")
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
        models.add(model);

        final NodePopulator nodepop = new NodePopulator();
        final EdgePopulator fixture = new EdgePopulator();
        final DistillerData data = new DistillerData(models);
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();

        nodepop.modifyGraph(data, graph);
        fixture.modifyGraph(data, graph);

        Assert.assertEquals(3, graph.nodes().size());
        Assert.assertEquals(2, graph.edges().size());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Before
    public void setUp() throws Exception {
        // TODO: add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @After
    public void tearDown() throws Exception {
        // TODO: add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    public static void main(final String[] args) {
        new org.junit.runner.JUnitCore().run(EdgePopulatorTest.class);
    }
}