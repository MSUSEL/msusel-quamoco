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
package edu.montana.gsoc.msusel.quamoco.graph.node;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.ValueToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.processor.NullProcessor;

/**
 * The class <code>MeasureNodeTest</code> contains tests for the class
 * <code>{@link MeasureNode}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:38 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class MeasureNodeTest {

    /**
     * Run the MeasureNode(DirectedSparseGraph<Node,Edge>,String,String)
     * constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testMeasureNode_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final String name = "name";
        final String owner = "owner";

        final MeasureNode result = new MeasureNode(graph, name, owner);

        // TODO: add additional test code here
        assertNotNull(result);
        assertEquals(null, result.getMethod());
        assertEquals(MeasureType.FINDINGS, result.getType());
        assertEquals("owner", result.getOwnedBy());
        assertEquals("", result.getDescription());
        assertEquals("Node(name=name)", result.toString());
        assertEquals("name", result.getName());
    }

    /**
     * Run the MeasureNode(DirectedSparseGraph<Node,Edge>,String,String,long)
     * constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testMeasureNode_2() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final String name = "name";
        final String owner = "owner";

        final MeasureNode result = new MeasureNode(graph, name, owner);

        // TODO: add additional test code here
        assertNotNull(result);
        assertEquals(null, result.getMethod());
        assertEquals(MeasureType.FINDINGS, result.getType());
        assertEquals("owner", result.getOwnedBy());
        assertEquals("", result.getDescription());
        assertEquals("Node(name=name)", result.toString());
        assertEquals("name", result.getName());
    }

    /**
     * Run the String getMethod() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetMethod_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode fixture = new MeasureNode(graph, "name", "owner");
        fixture.setType(MeasureType.NONE);
        fixture.setMethod("");
        fixture.name = "";
        fixture.value = BigDecimal.ONE;
        fixture.graph = graph;
        fixture.ownedBy = "";
        fixture.description = "";

        final String result = fixture.getMethod();

        // TODO: add additional test code here
        assertEquals("", result);
    }

    /**
     * Run the String getType() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetType_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode fixture = new MeasureNode(graph, "name", "owner");
        fixture.setType(MeasureType.NONE);
        fixture.setMethod("");
        fixture.name = "";
        fixture.value = BigDecimal.ONE;
        fixture.graph = graph;
        fixture.ownedBy = "";
        fixture.description = "";

        final MeasureType result = fixture.getType();

        // TODO: add additional test code here
        assertEquals(MeasureType.NONE, result);
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetValue_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode fixture = new MeasureNode(graph, "fixture", "fixture");
        final ValueNode value = new ValueNode(graph, "value", "value", "");
        final ValueToMeasureEdge edge = new ValueToMeasureEdge("edge", fixture, value);
        fixture.setProcessor(new NullProcessor(fixture));
        fixture.setType(MeasureType.NUMBER);
        fixture.value = BigDecimal.ONE;

        graph.addEdge(value, fixture, edge);

        final BigDecimal result = fixture.getValue();

        assertEquals(BigDecimal.ZERO, result);
        fixture.value = BigDecimal.ONE;
        assertEquals(BigDecimal.ONE, fixture.getValue());
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetValue_2() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode fixture = new MeasureNode(graph, "fixture", "fixture");
        final ValueNode value = new ValueNode(graph, "value", "value", "");
        final ValueToMeasureEdge edge = new ValueToMeasureEdge("edge", fixture, value);

        fixture.setProcessor(new NullProcessor(fixture));
        fixture.setType(MeasureType.FINDINGS);

        graph.addEdge(value, fixture, edge);

        assertEquals(BigDecimal.ZERO, fixture.getValue());
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetValue_3() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode fixture = new MeasureNode(graph, "fixture", "fixture");
        final ValueNode value = new ValueNode(graph, "value", "value", "");
        final ValueToMeasureEdge edge = new ValueToMeasureEdge("edge", fixture, value);
        fixture.setProcessor(new NullProcessor(fixture));
        fixture.setType(MeasureType.NUMBER);

        graph.addEdge(value, fixture, edge);

        final BigDecimal result = fixture.getValue();

        assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Run the String getXMLTag() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetXMLTag_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode fixture = new MeasureNode(graph, "name", "owner");
        fixture.setType(MeasureType.NUMBER);
        fixture.setMethod("");
        fixture.name = "";
        fixture.value = BigDecimal.ONE;
        fixture.graph = graph;
        fixture.ownedBy = "";
        fixture.description = "";

        final String result = fixture.getXMLTag();

        // TODO: add additional test code here
        assertEquals("<nodes name=\"\" description=\"\" owner=\"\" type=\"MEASURE\">\n" +
                "\t</nodes>", result);
    }

    /**
     * Run the void setMethod(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetMethod_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode fixture = new MeasureNode(graph, "name", "owner");
        fixture.setType(MeasureType.NONE);
        fixture.setMethod("");
        fixture.name = "";
        fixture.value = BigDecimal.ONE;
        fixture.graph = graph;
        fixture.ownedBy = "";
        fixture.description = "";
        final String method = "";

        fixture.setMethod(method);

        // TODO: add additional test code here
        assertEquals(method, fixture.getMethod());
    }

    /**
     * Run the void setType(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetType_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode fixture = new MeasureNode(graph, "name", "owner");
        fixture.setType(MeasureType.NONE);
        fixture.setMethod("");
        fixture.name = "";
        fixture.value = BigDecimal.ONE;
        fixture.graph = graph;
        fixture.ownedBy = "";
        fixture.description = "";
        final MeasureType type = MeasureType.NUMBER;

        fixture.setType(type);

        assertEquals(type, fixture.getType());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 5/30/15 3:38 PM
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
     * @generatedBy CodePro at 5/30/15 3:38 PM
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
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(MeasureNodeTest.class);
    }
}