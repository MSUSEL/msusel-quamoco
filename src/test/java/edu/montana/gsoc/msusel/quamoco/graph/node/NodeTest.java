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
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>NodeTest</code> contains tests for the class
 * <code>{@link Node}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:38 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class NodeTest {

    private Node fixture;

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testEquals_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final FactorNode obj = new FactorNode(graph, "node", "owner");
        final boolean result = fixture.equals(obj);

        // TODO: add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testEquals_2() throws Exception
    {
        final Object obj = null;

        final boolean result = fixture.equals(obj);

        // TODO: add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testEquals_3() throws Exception
    {
        final Object obj = new Object();

        final boolean result = fixture.equals(obj);

        // TODO: add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testEquals_4() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final ValueNode obj = new ValueNode(graph, "node", "owner", "tool");

        final boolean result = fixture.equals(obj);

        // TODO: add additional test code here
        Assert.assertTrue(result);
    }

    /**
     * Run the String getDescription() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetDescription_1() throws Exception
    {
        fixture.description = "description";

        final String result = fixture.getDescription();

        // TODO: add additional test code here
        Assert.assertEquals("description", result);
    }

    /**
     * Run the DirectedSparseGraph<Node, Edge> getGraph() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetGraph_1() throws Exception
    {
        final MutableNetwork<Node, Edge> result = fixture.getGraph();

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.nodes().size());
        Assert.assertEquals(0, result.edges().size());
        Assert.assertEquals("isDirected: true, allowsParallelEdges: true, allowsSelfLoops: false, nodes: [], edges: {}", result.toString());
    }

    /**
     * Run the String getName() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetName_1() throws Exception
    {
        final String result = fixture.getName();

        // TODO: add additional test code here
        Assert.assertEquals("node", result);
    }

    /**
     * Run the String getOwnedBy() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testGetOwnedBy_1() throws Exception
    {
        final String result = fixture.getOwnedBy();

        // TODO: add additional test code here
        Assert.assertEquals("owner", result);
    }

    /**
     * Run the void setDescription(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetDescription_1() throws Exception
    {
        Assert.assertEquals("", fixture.getDescription());
        final String description = "description";
        fixture.setDescription(description);

        // TODO: add additional test code here
        Assert.assertEquals(description, fixture.getDescription());
    }

    /**
     * Run the void setDescription(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetDescription_2() throws Exception
    {
        final String description = null;

        fixture.setDescription(description);

        // TODO: add additional test code here
        Assert.assertEquals("", fixture.getDescription());
    }

    /**
     * Run the void setName(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetName_1() throws Exception
    {
        String name = "";
        try
        {
            fixture.setName(name);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        name = null;
        try
        {
            fixture.setName(name);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        name = "newName";
        fixture.setName(name);

        // TODO: add additional test code here
        Assert.assertEquals(name, fixture.getName());
    }

    /**
     * Run the void setOwnedBy(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testSetOwnedBy_1() throws Exception
    {
        String ownedBy = "";
        try
        {
            fixture.setOwnedBy(ownedBy);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        ownedBy = null;
        try
        {
            fixture.setOwnedBy(ownedBy);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        ownedBy = "newOwner";
        fixture.setOwnedBy(ownedBy);

        // TODO: add additional test code here
        Assert.assertEquals(ownedBy, fixture.getOwnedBy());
    }

    /**
     * Run the String toString() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:38 PM
     */
    @Test
    public void testToString_1() throws Exception
    {
        final String result = fixture.toString();

        // TODO: add additional test code here
        Assert.assertEquals("Node(name=node)", result);
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
        fixture = new FactorNode(graph, "node", "owner");
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