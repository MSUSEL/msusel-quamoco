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
package edu.montana.gsoc.msusel.quamoco.graph.node;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.ValueToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.processor.NullProcessor;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>FactorNodeTest</code> contains tests for the class
 * <code>{@link FactorNode}</code>.
 *
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class FactorNodeTest {

    private FactorNode fixture;

    /**
     * Run the FactorNode(DirectedSparseGraph<Node,Edge>,String,String)
     * constructor test.
     */
    @Test
    public void testFactorNode_1() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final String name = "factor";
        final String owner = "owner";

        final FactorNode result = new FactorNode(graph, name, owner);

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(FactorMethod.MEAN, result.getMethod());
        Assert.assertEquals("owner", result.getOwnedBy());
        Assert.assertEquals("", result.getDescription());
        Assert.assertEquals("Node(name=factor)", result.toString());
        Assert.assertEquals("factor", result.getName());
    }

    /**
     * Run the FactorNode(DirectedSparseGraph<Node,Edge>,String,String,long)
     * constructor test.
     */
    @Test
    public void testFactorNode_2() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final String name = "factor";
        final String owner = "owner";

        final FactorNode result = new FactorNode(graph, name, owner);

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(FactorMethod.MEAN, result.getMethod());
        Assert.assertEquals("owner", result.getOwnedBy());
        Assert.assertEquals("", result.getDescription());
        Assert.assertEquals("Node(name=factor)", result.toString());
        Assert.assertEquals("factor", result.getName());
    }

    /**
     * Run the String getMethod() method test.
     */
    @Test
    public void testGetMethod_1() {
        final String result = fixture.getMethod();

        // TODO: add additional test code here
        Assert.assertEquals("MEAN", result);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_1() {
        fixture.setProcessor(new NullProcessor(fixture));

        final double result = fixture.getValue();

        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_2() {
        fixture.setProcessor(new NullProcessor(fixture));
        fixture.value = 1.0;
        fixture.calculated = true;

        final double result = fixture.getValue();

        Assert.assertEquals(1.0, result, 0.001);
    }

    /**
     * Run the void setMethod(String) method test.
     */
    @Test
    public void testSetMethod_1() {
        try
        {
            fixture.setMethod("");
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        try
        {
            fixture.setMethod(null);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        try
        {
            fixture.setMethod("bob");
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        final String method = FactorMethod.RANKING;
        fixture.setMethod(method);

        Assert.assertEquals(method, fixture.getMethod());
    }

    @Test
    public void testGetUpperResult_1() {
        final ValueNode vn1 = new ValueNode(fixture.getGraph(), "vn1", "owner", "tool");
        vn1.addValue(100.0);
        final ValueNode vn2 = new ValueNode(fixture.getGraph(), "vn2", "owner", "tool");
        vn2.addValue(150.0);
        final ValueNode vn3 = new ValueNode(fixture.getGraph(), "vn3", "owner", "tool");
        vn3.addValue(200.0);

        fixture.getGraph().addEdge(vn1, fixture, new ValueToMeasureEdge("edge1", vn1, fixture));
        fixture.getGraph().addEdge(vn2, fixture, new ValueToMeasureEdge("edge2", vn2, fixture));
        fixture.getGraph().addEdge(vn3, fixture, new ValueToMeasureEdge("edge3", vn3, fixture));

        final double result = fixture.getUpperResult();

        Assert.assertEquals(200.0, result, 0.001);
    }

    @Test
    public void testGetLowerResult_1() {
        final ValueNode vn1 = new ValueNode(fixture.getGraph(), "vn1", "owner", "tool");
        vn1.addValue(100.0);
        final ValueNode vn2 = new ValueNode(fixture.getGraph(), "vn2", "owner", "tool");
        vn2.addValue(150.0);
        final ValueNode vn3 = new ValueNode(fixture.getGraph(), "vn3", "owner", "tool");
        vn3.addValue(200.0);

        fixture.getGraph().addEdge(vn1, fixture, new ValueToMeasureEdge("edge1", vn1, fixture));
        fixture.getGraph().addEdge(vn2, fixture, new ValueToMeasureEdge("edge2", vn2, fixture));
        fixture.getGraph().addEdge(vn3, fixture, new ValueToMeasureEdge("edge3", vn3, fixture));

        final double result = fixture.getLowerResult();

        Assert.assertEquals(100.0, result, 0.001);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     */
    @Before
    public void setUp() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        fixture = new FactorNode(graph, "factor", "owner");
    }
}