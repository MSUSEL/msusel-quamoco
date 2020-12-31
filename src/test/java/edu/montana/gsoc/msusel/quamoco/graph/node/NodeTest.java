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
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>NodeTest</code> contains tests for the class
 * <code>{@link Node}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class NodeTest {

    private Node fixture;

    /**
     * Run the boolean equals(Object) method test.
     */
    @Test
    public void testEquals_1() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final FactorNode obj = new FactorNode(graph, "node", "owner");
        final boolean result = fixture.equals(obj);

        // TODO: add additional test code here
        Assert.assertTrue(result);
    }

    /**
     * Run the boolean equals(Object) method test.
     */
    @Test
    public void testEquals_2() {
        final Object obj = null;

        final boolean result = fixture.equals(obj);

        // TODO: add additional test code here
        Assert.assertFalse(result);
    }

    /**
     * Run the boolean equals(Object) method test.
     */
    @Test
    public void testEquals_3() {
        final Object obj = new Object();

        final boolean result = fixture.equals(obj);

        // TODO: add additional test code here
        Assert.assertFalse(result);
    }

    /**
     * Run the boolean equals(Object) method test.
     */
    @Test
    public void testEquals_4() {
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
     */
    @Test
    public void testGetDescription_1() {
        fixture.description = "description";

        final String result = fixture.getDescription();

        // TODO: add additional test code here
        Assert.assertEquals("description", result);
    }

    /**
     * Run the DirectedSparseGraph<Node, Edge> getGraph() method test.
     */
    @Test
    public void testGetGraph_1() {
        final MutableNetwork<Node, Edge> result = fixture.getGraph();

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(0, result.nodes().size());
        Assert.assertEquals(0, result.edges().size());
        Assert.assertEquals("isDirected: true, allowsParallelEdges: true, allowsSelfLoops: false, nodes: [], edges: {}", result.toString());
    }

    /**
     * Run the String getName() method test.
     */
    @Test
    public void testGetName_1() {
        final String result = fixture.getName();

        // TODO: add additional test code here
        Assert.assertEquals("node", result);
    }

    /**
     * Run the String getOwnedBy() method test.
     */
    @Test
    public void testGetOwnedBy_1() {
        final String result = fixture.getOwnedBy();

        // TODO: add additional test code here
        Assert.assertEquals("owner", result);
    }

    /**
     * Run the void setDescription(String) method test.
     */
    @Test
    public void testSetDescription_1() {
        Assert.assertEquals("", fixture.getDescription());
        final String description = "description";
        fixture.setDescription(description);

        // TODO: add additional test code here
        Assert.assertEquals(description, fixture.getDescription());
    }

    /**
     * Run the void setDescription(String) method test.
     */
    @Test
    public void testSetDescription_2() {
        final String description = null;

        fixture.setDescription(description);

        // TODO: add additional test code here
        Assert.assertEquals("", fixture.getDescription());
    }

    /**
     * Run the void setName(String) method test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetName_1() {
        String name = "";

        fixture.setName(name);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetName_2() {
        String name = null;

        fixture.setName(name);
    }

    @Test
    public void testSetName_3() {
        String name = "newName";
        fixture.setName(name);

        // TODO: add additional test code here
        Assert.assertEquals(name, fixture.getName());
    }

    /**
     * Run the void setOwnedBy(String) method test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetOwnedBy_1() {
        String ownedBy = "";

        fixture.setOwnedBy(ownedBy);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetOwnedBy_2() {
        String ownedBy = null;

        fixture.setOwnedBy(ownedBy);
    }

    @Test
    public void testSetOwnedBy_3() {
        String ownedBy = "newOwner";
        fixture.setOwnedBy(ownedBy);

        // TODO: add additional test code here
        Assert.assertEquals(ownedBy, fixture.getOwnedBy());
    }

    /**
     * Run the String toString() method test.
     */
    @Test
    public void testToString_1() {
        final String result = fixture.toString();

        // TODO: add additional test code here
        Assert.assertEquals("Node(name=node)", result);
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
        fixture = new FactorNode(graph, "node", "owner");
    }
}