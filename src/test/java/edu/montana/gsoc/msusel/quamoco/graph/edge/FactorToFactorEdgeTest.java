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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FactorToFactorEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.InfluenceType;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.qm.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * The class <code>InfluenceEdgeTest</code> contains tests for the class
 * <code>{@link FactorToFactorEdge}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:38 PM
 * @author isaac
 * @version $Revision: BigDecimal.ONE $
 */
public class FactorToFactorEdgeTest {

    private FactorToFactorEdge fixture;

    /**
     * Run the InfluenceEdge(String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testFactorToFactorEdge_1() throws Exception
    {
        final String name = "TestEdge";

        final FactorToFactorEdge result = new FactorToFactorEdge(name, null, null, InfluenceEffect.POSITIVE);

        // TODO: add additional test code here
        assertNotNull(result);
        assertEquals(BigDecimal.ONE, result.getWeight());
        assertEquals(InfluenceType.POS, result.getInf());
        assertEquals(BigDecimal.ONE, result.getUpperBound());
        assertEquals(BigDecimal.ZERO, result.getLowerBound());
        assertEquals(name, result.getName());
    }

    /**
     * Run the String getInf() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetInf_1() throws Exception
    {
        final String result = fixture.getInf();

        // TODO: add additional test code here
        assertEquals(InfluenceType.POS, result);
    }

    /**
     * Run the double getLowerBound() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetLowerBound_1() throws Exception
    {
        final BigDecimal result = fixture.getLowerBound();

        // TODO: add additional test code here
        assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Run the double getUpperBound() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetUpperBound_1() throws Exception
    {
        final BigDecimal result = fixture.getUpperBound();

        // TODO: add additional test code here
        assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the double getValue(DirectedSparseGraph<Node,Edge>,Node) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetValue_1() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final FactorNode dest = new FactorNode(graph, "dest", "dest");
        FactorNode src = mock(FactorNode.class);
        when(src.getValue()).thenReturn(new BigDecimal(0.5));

        fixture.setDist(null);
        fixture.setMaxPoints(new BigDecimal(100));
        fixture.setWeight(new BigDecimal(0.5));
        fixture.setInf(InfluenceType.POS);
        fixture.setNormalizer(null);

        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);
        fixture.src = src;
        fixture.dest = dest;

        // TODO: add additional test code here
        assertEquals(new BigDecimal(0.25), fixture.getValue());
    }

    /**
     * Run the double getValue(DirectedSparseGraph<Node,Edge>,Node) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetValue_2() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final FactorNode dest = new FactorNode(graph, "dest", "dest");
        FactorNode src = mock(FactorNode.class);
        when(src.getValue()).thenReturn(new BigDecimal(0.75));

        fixture.setDist(null);
        fixture.setMaxPoints(BigDecimal.ONE);
        fixture.setWeight(new BigDecimal(0.5));
        fixture.setInf(InfluenceType.NEG);
        fixture.setNormalizer(null);

        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);
        fixture.src = src;
        fixture.dest = dest;

        // TODO: add additional test code here
        assertEquals(new BigDecimal(0.125), fixture.getValue());
    }

    /**
     * Run the double getValue(DirectedSparseGraph<Node,Edge>,Node) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetValue_3() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final FactorNode dest = new FactorNode(graph, "dest", "dest");
        FactorNode src = mock(FactorNode.class);
        when(src.getValue()).thenReturn(new BigDecimal(0.5));

        fixture.setDist(new PositiveLinearDistribution());
        fixture.setMaxPoints(new BigDecimal(100));
        fixture.setInf(null);
        fixture.setNormalizer(null);

        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);
        fixture.src = src;
        fixture.dest = dest;

        // TODO: add additional test code here
        assertEquals(new BigDecimal(0.5), fixture.getValue());
    }

    /**
     * Run the double getValue(DirectedSparseGraph<Node,Edge>,Node) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetValue_4() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final FactorNode dest = new FactorNode(graph, "dest", "dest");
        FactorNode src = mock(FactorNode.class);
        when(src.getValue()).thenReturn(new BigDecimal(1.5));

        fixture.setDist(new PositiveLinearDistribution());
        fixture.setMaxPoints(BigDecimal.ONE);
        fixture.setInf(null);
        fixture.setNormalizer(null);

        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);
        fixture.src = src;
        fixture.dest = dest;

        // TODO: add additional test code here
        assertEquals(BigDecimal.ONE, fixture.getValue());
    }

    /**
     * Run the double getValue(DirectedSparseGraph<Node,Edge>,Node) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetValue_5() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final FactorNode dest = new FactorNode(graph, "dest", "dest");
        // final ValueNode src = new ValueNode(graph, "source", "source", "");

        FactorNode src = mock(FactorNode.class);
        when(src.getValue()).thenReturn(new BigDecimal(-1));

        fixture.setDist(null);
        fixture.setInf(null);
        fixture.setNormalizer(null);

        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);
        fixture.src = src;
        fixture.dest = dest;

        assertEquals(BigDecimal.ZERO, fixture.getValue());
    }

    /**
     * Run the double getValue(DirectedSparseGraph<Node,Edge>,Node) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetValue_6() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final FactorNode dest = new FactorNode(graph, "dest", "dest");
        FactorNode src = mock(FactorNode.class);
        when(src.getValue()).thenReturn(new BigDecimal(0.75));

        fixture.setDist(null);
        fixture.setMaxPoints(BigDecimal.ONE);
        fixture.setWeight(new BigDecimal(0.5));
        fixture.setInf(InfluenceType.POS);
        fixture.setNormalizer(new NullNormalizer(fixture, "NOM", NormalizationRange.CLASS));

        graph.addEdge(fixture, src, dest, EdgeType.DIRECTED);
        fixture.src = src;
        fixture.dest = dest;

        // TODO: add additional test code here
        assertEquals(new BigDecimal(0.375), fixture.getValue());
    }

    /**
     * Run the double getWeight() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetWeight_1() throws Exception
    {
        final BigDecimal result = fixture.getWeight();

        // TODO: add additional test code here
        assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the void setInf(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInf_1() throws Exception
    {
        final String inf = "";

        fixture.setInf(inf);
        fail();
    }

    /**
     * Run the void setInf(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
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
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetInf_3() throws Exception
    {
        final String inf = InfluenceType.POS;

        fixture.setInf(inf);
        assertEquals(InfluenceType.POS, fixture.getInf());
    }

    /**
     * Run the void setInf(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetInf_4() throws Exception
    {
        final String inf = InfluenceType.NEG;

        fixture.setInf(inf);
        assertEquals(InfluenceType.NEG, fixture.getInf());
    }

    /**
     * Run the void setInf(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetInf_5() throws Exception
    {
        final String inf = "test";

        fixture.setInf(inf);
    }

    /**
     * Run the void setLowerBound(double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetLowerBound_1() throws Exception
    {
        final BigDecimal lowerBound = BigDecimal.ZERO;

        fixture.setLowerBound(lowerBound);
        assertEquals(lowerBound, fixture.getLowerBound());
    }

    /**
     * Run the void setLowerBound(double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetLowerBound_2() throws Exception
    {
        final BigDecimal lowerBound = new BigDecimal(2.0);

        fixture.setLowerBound(lowerBound);
    }

    /**
     * Run the void setUpperBound(double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetUpperBound_1() throws Exception
    {
        final BigDecimal upperBound = BigDecimal.ZERO;
        fixture.setLowerBound(BigDecimal.ONE);
        fixture.setUpperBound(upperBound);
    }

    /**
     * Run the void setUpperBound(double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetUpperBound_2() throws Exception
    {
        final BigDecimal upperBound = new BigDecimal(2.0);

        fixture.setUpperBound(upperBound);
        assertEquals(upperBound, fixture.getUpperBound());
    }

    /**
     * Run the void setWeight(double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetWeight_1() throws Exception
    {
        final BigDecimal weight = BigDecimal.ZERO;

        fixture.setWeight(weight);
        assertEquals(weight, fixture.getWeight());
    }

    /**
     * Run the void setWeight(double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetWeight_2() throws Exception
    {
        final BigDecimal weight = new BigDecimal(-1.0);

        fixture.setWeight(weight);
        fail();
    }

    /**
     * Run the void setWeight(double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetWeight_3() throws Exception
    {
        final BigDecimal weight = new BigDecimal(1.5);

        fixture.setWeight(weight);
        fail();
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(FactorToFactorEdgeTest.class);
    }

    /**
     *
     */
    @Before
    public void setUp()
    {
        fixture = new FactorToFactorEdge("", null, null, InfluenceEffect.POSITIVE);
        fixture.setInf(InfluenceType.POS);
        fixture.setUpperBound(BigDecimal.ONE);
        fixture.setWeight(BigDecimal.ONE);
        fixture.setLowerBound(BigDecimal.ZERO);
    }
}