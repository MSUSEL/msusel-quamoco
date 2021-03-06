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

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.ValueToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.graph.node.ValueNode;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMeanAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * The class <code>MeasureToMeasureNumberEdgeTest</code> contains tests for the
 * class <code>{@link MeasureToMeasureNumberEdge}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: BigDecimal.ONE $
 */
public class MeasureToMeasureNumberEdgeTest {

    private MeasureToMeasureNumberEdge fixture;

    /**
     * Run the MeasureToMeasureNumberEdge(String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testMeasureToMeasureNumberEdge_1() throws Exception
    {
        final String name = "";

        final MeasureToMeasureNumberEdge result = new MeasureToMeasureNumberEdge(name, null, null);

        // add additional test code here
        assertNotNull(result);
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
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_1() throws Exception
    {
        fixture.usesLinearDist = false;
        fixture.setWeight(new BigDecimal(0.5));
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(new BigDecimal(27.5).setScale(6, RoundingMode.HALF_UP), result);
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_2() throws Exception
    {
        fixture.usesLinearDist = false;
        fixture.setWeight(new BigDecimal(0.5));
        fixture.setNormalizer(null);
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(new BigDecimal(27.5).setScale(6, RoundingMode.HALF_UP), result);
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_3() throws Exception
    {
        fixture.usesLinearDist = true;
        fixture.setWeight(BigDecimal.ONE);
        fixture.setMaxPoints(new BigDecimal(50.0));
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(new BigDecimal(50.0), result);
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_4() throws Exception
    {
        fixture.usesLinearDist = true;
        fixture.setWeight(BigDecimal.ONE);
        fixture.setNormalizer(null);
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(new BigDecimal(55.0).setScale(10, RoundingMode.HALF_UP), result);
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_5() throws Exception
    {
        fixture.usesLinearDist = true;
        fixture.setWeight(BigDecimal.ONE);
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(new BigDecimal(55.0).setScale(10, RoundingMode.HALF_UP), result);
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_6() throws Exception
    {
        fixture.usesLinearDist = false;
        fixture.setWeight(BigDecimal.ONE);
        fixture.setNormalizer(null);
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(new BigDecimal(55.0).setScale(5, RoundingMode.HALF_UP), result);
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
        final MeasureNode dest = new MeasureNode(graph, "dest", "owner");
        dest.setType(MeasureType.NUMBER);
        final MeasureNode src = new MeasureNode(graph, "src", "owner2");
        src.setType(MeasureType.NUMBER);
        final ValueNode srcsrc = new ValueNode(graph, "srcsrc", "owner", "tool");
        final ValueToMeasureEdge v2m = new ValueToMeasureEdge("preedge", srcsrc, src);
        srcsrc.addValue(BigDecimal.TEN);
        srcsrc.addValue(new BigDecimal(100.0));
        fixture = new MeasureToMeasureNumberEdge("edge", src, dest);
        fixture.dist = new PositiveLinearDistribution();
        src.setProcessor(new NumberMeanAggregator(src));

        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);
        graph.addEdge(v2m, srcsrc, src, EdgeType.DIRECTED);

        fixture.maxPoints = new BigDecimal(100.0);
        fixture.usesLinearDist = false;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.weight = BigDecimal.ONE;
        fixture.setNormalizer(new NullNormalizer(fixture, "LOC", NormalizationRange.CLASS));
        fixture.upperBound = BigDecimal.ONE;

        src.getValue();
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
        new org.junit.runner.JUnitCore().run(MeasureToMeasureNumberEdgeTest.class);
    }
}