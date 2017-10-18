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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.distiller;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import edu.montana.gsoc.msusel.quamoco.distiller.DistilledGraphCreator;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluates;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Factor;
import edu.montana.gsoc.msusel.quamoco.model.qm.FactorLink;
import edu.montana.gsoc.msusel.quamoco.model.qm.Influence;
import edu.montana.gsoc.msusel.quamoco.model.qm.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.qm.Measure;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.model.qm.Parent;
import edu.montana.gsoc.msusel.quamoco.model.qm.QualityModel;
import edu.montana.gsoc.msusel.quamoco.model.qm.Ranking;
import edu.montana.gsoc.msusel.quamoco.model.qm.Refines;
import edu.montana.gsoc.msusel.quamoco.model.qm.Target;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * The class <code>DistilledGraphCreatorTest</code> contains tests for the class
 * <code>{@link DistilledGraphCreator}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:42 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class DistilledGraphCreatorTest {

    /**
     * Run the DistilledGraphCreator() constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testDistilledGraphCreator_1() throws Exception
    {

        final DistilledGraphCreator result = new DistilledGraphCreator();

        Assert.assertNotNull(result);
    }

    /**
     * Run the DirectedSparseGraph<Node, Edge> buildGraph(List
     * <QualityModel>,DecoratorContext) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testBuildGraph_1() throws Exception
    {
        final DistilledGraphCreator fixture = new DistilledGraphCreator();
        final List<QualityModel> models = Lists.newArrayList();
        final QualityModel model = new QualityModel("java", "", null, null, "java");
        models.add(model);
        final Factor f1 = new Factor("factor1", "", null, null, "factor1", new Refines("java.qm#factor2"),
                "java.qm#factor1");
        f1.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", new Target("java.qm#factor2"), "java.qm#inf1"));
        final Factor f2 = new Factor("factor2", "", null, null, "factor2", null, "java.qm#factor2");
        final Measure m1 = new Measure("measure1", "", "measure1", null, "", "", null, null, "java.qm#measure1", false);
        m1.addParent(new Parent("java.qm#factor1"));
        final Evaluation eval = new Evaluation("eval1", "", "", BigDecimal.ZERO, "", new Evaluates("java.qm#factor2"),
                "", "java.qm#eval1");
        final Ranking rank = new Ranking("1", NormalizationRange.NA.toString(), "0.25", null,
                new FactorLink("java.qm#factor1"), null, "java.qm#factor1", "java.qm#rank1");
        eval.addRanking(rank);
        model.addEvaluation(eval);
        model.addFactor(f1);
        model.addFactor(f2);
        model.addMeasure(m1);

        final DirectedSparseGraph<Node, Edge> result = fixture.buildGraph(models);

        Assert.assertEquals(3, result.getVertexCount());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Before
    public void setUp() throws Exception
    {
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
    public void tearDown() throws Exception
    {
        // TODO: add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(DistilledGraphCreatorTest.class);
    }
}
