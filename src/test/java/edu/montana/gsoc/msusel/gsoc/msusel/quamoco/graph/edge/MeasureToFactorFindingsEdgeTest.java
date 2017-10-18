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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.graph.edge;

import java.math.BigDecimal;
import java.math.RoundingMode;

import edu.montana.gsoc.msusel.gsoc.msusel.node.FileNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.InfluenceType;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.qm.FunctionType;
import edu.montana.gsoc.msusel.quamoco.model.qm.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.evaluators.MeanEvaluator;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * The class <code>MeasureToFactorFindingsEdgeTest</code> contains tests for the
 * class <code>{@link MeasureToFactorFindingsEdge}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: BigDecimal.ONE $
 */
public class MeasureToFactorFindingsEdgeTest {

    private MeasureToFactorFindingsEdge fixture;

    /**
     * Run the MeasureToFactorFindingsEdge(String,InfluenceEffect) constructor
     * test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testMeasureToFactorFindingsEdge_1() throws Exception
    {
        final String name = "";
        final InfluenceEffect effect = InfluenceEffect.NEGATIVE;

        final MeasureToFactorFindingsEdge result = new MeasureToFactorFindingsEdge(name, null, null, effect);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("NEGATIVE", result.getInf());
        Assert.assertEquals(BigDecimal.ZERO, result.getValue());
        Assert.assertEquals(null, result.getDist());
        Assert.assertEquals(new BigDecimal(100), result.getMaxPoints());
        Assert.assertEquals(false, result.isUsesLinearDist());
        Assert.assertEquals(null, result.getNormalizer());
        Assert.assertEquals(BigDecimal.ONE, result.getWeight());
        Assert.assertEquals(BigDecimal.ONE, result.getUpperBound());
        Assert.assertEquals(BigDecimal.ZERO, result.getLowerBound());
        Assert.assertEquals("", result.getName());
    }

    /**
     * Run the MeasureToFactorFindingsEdge(String,InfluenceEffect) constructor
     * test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testMeasureToFactorFindingsEdge_2() throws Exception
    {
        final String name = "";
        final InfluenceEffect effect = null;

        final MeasureToFactorFindingsEdge result = new MeasureToFactorFindingsEdge(name, null, null, effect);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("POSITIVE", result.getInf());
        Assert.assertEquals(BigDecimal.ZERO, result.getValue());
        Assert.assertEquals(null, result.getDist());
        Assert.assertEquals(new BigDecimal(100), result.getMaxPoints());
        Assert.assertEquals(false, result.isUsesLinearDist());
        Assert.assertEquals(null, result.getNormalizer());
        Assert.assertEquals(BigDecimal.ONE, result.getWeight());
        Assert.assertEquals(BigDecimal.ONE, result.getUpperBound());
        Assert.assertEquals(BigDecimal.ZERO, result.getLowerBound());
        Assert.assertEquals("", result.getName());
    }

    /**
     * Run the String getInf() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetInf_1() throws Exception
    {
        final String result = fixture.getInf();

        // add additional test code here
        Assert.assertEquals(InfluenceType.NEG, result);
    }

    /**
     * Run the double getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_1() throws Exception
    {
        fixture.setUsesLinearDist(false);
        fixture.setInf(InfluenceType.POS);
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the double getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_2() throws Exception
    {
        fixture.setUsesLinearDist(false);
        fixture.setInf(InfluenceType.NEG);
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Run the double getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_3() throws Exception
    {
        fixture.setUsesLinearDist(true);
        fixture.setInf(InfluenceType.POS);
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the double getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_4() throws Exception
    {
        fixture.setUsesLinearDist(true);
        fixture.setInf(InfluenceType.NEG);
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Run the double getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_5() throws Exception
    {
        fixture.setUsesLinearDist(false);
        fixture.setInf(InfluenceType.POS);
        fixture.setWeight(new BigDecimal(0.5));
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(new BigDecimal(0.5), result);
    }

    /**
     * Run the double getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_6() throws Exception
    {
        fixture.setUsesLinearDist(true);
        fixture.setInf(InfluenceType.POS);
        fixture.setWeight(new BigDecimal(0.5));
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(new BigDecimal(0.5), result);
    }

    @Test
    public void testGetValue_7() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final MeasureNode src = new MeasureNode(graph, "measure", "owner");
        src.setType(MeasureType.FINDINGS);
        src.setProcessor(new FindingsUnionAggregator(src));
        final FactorNode dest = new FactorNode(graph, "factor", "owner");
        final FindingNode srcsrc = new FindingNode(graph, "key", "owner", "finding", "tool");

        fixture = new MeasureToFactorFindingsEdge("", src, dest, InfluenceEffect.NEGATIVE);
        graph.addEdge(new FindingToMeasureEdge("f2m", srcsrc, src), srcsrc, src, EdgeType.DIRECTED);
        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);

        fixture.weight = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = BigDecimal.ONE;
        fixture.usesLinearDist = true;
        fixture.maxPoints = BigDecimal.ONE;
        fixture.dist = new PositiveLinearDistribution();
        fixture.norm = new NullNormalizer(fixture, "", NormalizationRange.CLASS);
        dest.setProcessor(new MeanEvaluator(dest));
        Assert.assertEquals(BigDecimal.ZERO.setScale(5, RoundingMode.HALF_UP), dest.getValue());
    }

    /**
     * Run the void setInf(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetInf_1() throws Exception
    {
        final InfluenceEffect inf = InfluenceEffect.POSITIVE;
        fixture.setInf(inf.toString());

        // add additional test code here
        Assert.assertEquals(InfluenceType.POS, fixture.getInf());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Before
    public void setUp() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final MeasureNode src = new MeasureNode(graph, "measure", "owner");
        src.setType(MeasureType.FINDINGS);
        src.setProcessor(new FindingsUnionAggregator(src));
        final FactorNode dest = new FactorNode(graph, "factor", "owner");
        final FindingNode srcsrc = new FindingNode(graph, "key", "owner", "finding", "tool");
        srcsrc.addFinding(new Finding(FileNode.builder("path").create(), "finding", "finding"));

        fixture = new MeasureToFactorFindingsEdge("", src, dest, InfluenceEffect.NEGATIVE);
        graph.addEdge(new FindingToMeasureEdge("f2m", srcsrc, src), srcsrc, src, EdgeType.DIRECTED);
        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);

        fixture.weight = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = BigDecimal.ONE;
        fixture.usesLinearDist = true;
        fixture.maxPoints = new BigDecimal(100);
        fixture.dist = new PositiveLinearDistribution();
        fixture.norm = new NullNormalizer(fixture, "", NormalizationRange.CLASS);
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @After
    public void tearDown() throws Exception
    {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(MeasureToFactorFindingsEdgeTest.class);
    }
}