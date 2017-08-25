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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.InfluenceType;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.ValueToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.graph.node.ValueNode;
import edu.montana.gsoc.msusel.quamoco.model.qm.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * The class <code>MeasureToFactorNumberEdgeTest</code> contains tests for the
 * class <code>{@link MeasureToFactorNumberEdge}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: BigDecimal.ONE $
 */
public class MeasureToFactorNumberEdgeTest {

    private MeasureToFactorNumberEdge fixture;

    /**
     * Run the MeasureToFactorNumberEdge(String,InfluenceEffect) constructor
     * test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testMeasureToFactorNumberEdge_1() throws Exception
    {
        final String name = "";
        final InfluenceEffect effect = InfluenceEffect.NEGATIVE;

        final MeasureToFactorNumberEdge result = new MeasureToFactorNumberEdge(name, null, null, effect);

        // add additional test code here
        assertNotNull(result);
        assertEquals("NEGATIVE", result.getInf());
        assertEquals(null, result.getDist());
        assertEquals(new BigDecimal(100), result.getMaxPoints());
        assertEquals(false, result.isUsesLinearDist());
        assertEquals(null, result.getNormalizer());
        assertEquals(BigDecimal.ONE, result.getWeight());
        assertEquals(BigDecimal.ONE, result.getUpperBound());
        assertEquals(BigDecimal.ZERO, result.getLowerBound());
        assertEquals("", result.getName());
    }

    /**
     * Run the MeasureToFactorNumberEdge(String,InfluenceEffect) constructor
     * test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testMeasureToFactorNumberEdge_2() throws Exception
    {
        final String name = "";
        final InfluenceEffect effect = null;

        final MeasureToFactorNumberEdge result = new MeasureToFactorNumberEdge(name, null, null, effect);

        // add additional test code here
        assertNotNull(result);
        assertEquals("POSITIVE", result.getInf());
        assertEquals(null, result.getDist());
        assertEquals(new BigDecimal(100), result.getMaxPoints());
        assertEquals(false, result.isUsesLinearDist());
        assertEquals(null, result.getNormalizer());
        assertEquals(BigDecimal.ONE, result.getWeight());
        assertEquals(BigDecimal.ONE, result.getUpperBound());
        assertEquals(BigDecimal.ZERO, result.getLowerBound());
        assertEquals("", result.getName());
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
        assertEquals(InfluenceType.NEG, result);
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
        fixture.weight = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = BigDecimal.ONE;
        fixture.usesLinearDist = true;
        fixture.maxPoints = BigDecimal.ONE;
        fixture.dist = new PositiveLinearDistribution();
        fixture.norm = new NullNormalizer(fixture, "", NormalizationRange.CLASS);

        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(BigDecimal.ONE, result);
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
        fixture.weight = new BigDecimal(0.5);
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = BigDecimal.ONE;
        fixture.usesLinearDist = false;
        fixture.maxPoints = BigDecimal.ONE;
        fixture.setInf(InfluenceType.POS);
        fixture.dist = new PositiveLinearDistribution();
        fixture.norm = new NullNormalizer(fixture, "", NormalizationRange.CLASS);

        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(new BigDecimal(0.5), result);
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
        fixture.weight = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = BigDecimal.ONE;
        fixture.usesLinearDist = false;
        fixture.maxPoints = BigDecimal.ONE;
        fixture.setInf(InfluenceType.NEG);
        fixture.dist = null;
        fixture.norm = new NullNormalizer(fixture, "", NormalizationRange.CLASS);

        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(BigDecimal.ZERO, result);
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
        fixture.weight = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = new BigDecimal(2.0);
        fixture.usesLinearDist = true;
        fixture.maxPoints = new BigDecimal(0.5);
        fixture.dist = new PositiveLinearDistribution();
        fixture.norm = null;

        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(new BigDecimal(0.5), result);
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
        fixture.weight = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = BigDecimal.ONE;
        fixture.usesLinearDist = false;
        fixture.maxPoints = BigDecimal.ONE;
        fixture.setInf(InfluenceType.NEG);
        fixture.dist = null;
        fixture.norm = null;

        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(BigDecimal.ZERO, result);
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
        fixture.weight = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = BigDecimal.ONE;
        fixture.usesLinearDist = false;
        fixture.maxPoints = BigDecimal.ONE;
        fixture.setInf(InfluenceType.POS);
        fixture.dist = null;
        fixture.norm = null;

        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the double getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_7() throws Exception
    {
        fixture.weight = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = BigDecimal.ONE;
        fixture.usesLinearDist = false;
        fixture.maxPoints = new BigDecimal(0.5);
        fixture.setInf(null);
        fixture.dist = null;
        fixture.norm = null;

        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(BigDecimal.ONE, result);
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
        final String inf = "";

        try
        {
            fixture.setInf(inf);
            fail();
        }
        catch (final IllegalArgumentException e)
        {
            assertEquals(InfluenceType.NEG, fixture.getInf());
        }
    }

    /**
     * Run the void setInf(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetInf_2() throws Exception
    {
        final String inf = null;

        fixture.setInf(inf);
        assertNull(fixture.getInf());
    }

    /**
     * Run the void setInf(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetInf_3() throws Exception
    {
        final String inf = "Test";

        try
        {
            fixture.setInf(inf);
            fail();
        }
        catch (final IllegalArgumentException e)
        {
            assertEquals(InfluenceType.NEG, fixture.getInf());
        }
    }

    /**
     * Run the void setInf(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetInf_4() throws Exception
    {
        final String inf = InfluenceType.POS;

        try
        {
            fixture.setInf(inf);
            assertEquals(InfluenceType.POS, fixture.getInf());
        }
        catch (final IllegalArgumentException e)
        {
            fail();
        }
    }

    /**
     * Run the void setInf(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetInf_5() throws Exception
    {
        final String inf = InfluenceType.NEG;

        try
        {
            fixture.setInf(inf);
            assertEquals(InfluenceType.NEG, fixture.getInf());
        }
        catch (final IllegalArgumentException e)
        {
            fail();
        }
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
        src.setType(MeasureType.NUMBER);
        src.setProcessor(new FindingsUnionAggregator(src));
        final FactorNode dest = new FactorNode(graph, "factor", "owner");
        final ValueNode srcsrc = new ValueNode(graph, "key", "owner", "tool");
        srcsrc.addValue(BigDecimal.TEN);
        srcsrc.addValue(new BigDecimal(100));

        fixture = new MeasureToFactorNumberEdge("", src, dest, InfluenceEffect.NEGATIVE);
        graph.addEdge(new ValueToMeasureEdge("v2m", srcsrc, src), srcsrc, src, EdgeType.DIRECTED);
        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);

        fixture.weight = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.upperBound = BigDecimal.ONE;
        fixture.usesLinearDist = true;
        fixture.maxPoints = BigDecimal.ONE;
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
        new org.junit.runner.JUnitCore().run(MeasureToFactorNumberEdgeTest.class);
    }
}