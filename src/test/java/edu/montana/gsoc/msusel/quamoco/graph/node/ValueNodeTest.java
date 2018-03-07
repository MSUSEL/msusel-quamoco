/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * The class <code>ValueNodeTest</code> contains tests for the class
 * <code>{@link ValueNode}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:38 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class ValueNodeTest {

    private ValueNode fixture;

    /**
     * Run the ValueNode(DirectedSparseGraph<Node,Edge>,String,String,String)
     * constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testValueNode_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final String key = "node";
        final String owner = "owner";
        final String tool = "tool";

        final ValueNode result = new ValueNode(graph, key, owner, tool);

        // TODO: add additional test code here
        assertNotNull(result);
        assertEquals("tool", result.getTool());
        assertEquals(BigDecimal.ZERO, result.getValue());
        assertEquals("node", result.getKey());
        assertEquals("owner", result.getOwnedBy());
        assertEquals("", result.getDescription());
        assertEquals("node", result.getName());
    }

    /**
     * Run the ValueNode(DirectedSparseGraph
     * <Node,Edge>,String,String,String,long) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testValueNode_2() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final String key = "node";
        final String owner = "owner";
        final String tool = "tool";

        final ValueNode result = new ValueNode(graph, key, owner, tool);

        // TODO: add additional test code here
        assertNotNull(result);
        assertEquals("tool", result.getTool());
        assertEquals(BigDecimal.ZERO, result.getValue());
        assertEquals("node", result.getKey());
        assertEquals("owner", result.getOwnedBy());
        assertEquals("", result.getDescription());
        assertEquals("node", result.getName());
    }

    /**
     * Run the String getKey() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetKey_1() throws Exception
    {
        final String result = fixture.getKey();

        // TODO: add additional test code here
        assertEquals("node", result);
    }

    /**
     * Run the String getTool() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetTool_1() throws Exception
    {
        final String result = fixture.getTool();

        // TODO: add additional test code here
        assertEquals("tool", result);
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
        fixture.addValue(new BigDecimal(1));
        fixture.addValue(new BigDecimal(1));
        fixture.addValue(new BigDecimal(1));
        fixture.addValue(new BigDecimal(-2));

        final BigDecimal result = fixture.getValue();

        // TODO: add additional test code here
        assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the void setKey(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetKey_1() throws Exception
    {
        String key = "";

        try
        {
            fixture.setKey(key);
            fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        key = null;
        try
        {
            fixture.setKey(key);
            fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        key = "other";
        fixture.setKey(key);

        // TODO: add additional test code here
        assertEquals(key, fixture.getKey());
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
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        fixture = new ValueNode(graph, "node", "owner", "tool");
        fixture.graph = graph;
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
}