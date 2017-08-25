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
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.node.FileNode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingsUnionNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.NullProcessor;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * The class <code>FindingsUnionNodeTest</code> contains tests for the class
 * <code>{@link FindingsUnionNode}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class FindingsUnionNodeTest {

    /**
     * Run the FindingsUnionNode(DirectedSparseGraph<Node,Edge>,String,String)
     * constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testFindingsUnionNode_1() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final String name = "name";
        final String owner = "owner";

        final FindingsUnionNode result = new FindingsUnionNode(graph, name, owner);

        // add additional test code here
        assertNotNull(result);
        assertEquals(null, result.getXMLTag());
        assertEquals(BigDecimal.ZERO, result.getLowerResult());
        assertEquals(BigDecimal.ONE, result.getUpperResult());
        assertEquals(BigDecimal.ONE, result.getValue());
        assertEquals("owner", result.getOwnedBy());
        assertEquals("", result.getDescription());
        assertEquals(null, result.getProcessor());
        assertEquals("name", result.toString());
        assertEquals("name", result.getName());
    }

    /**
     * Run the Set<Finding> getFindings() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetFindings_1() throws Exception
    {
        final FindingsUnionNode fixture = new FindingsUnionNode(new DirectedSparseGraph<>(), "union", "owner");
        fixture.processor = new NullProcessor(fixture);

        fixture.graph.addVertex(fixture);
        final FindingNode fn = new FindingNode(fixture.graph, "finding", "finding", "rule", "tool");
        fn.addFinding(new Finding(FileNode.builder("path").create(), "finding1", "rule"));
        fn.addFinding(new Finding(FileNode.builder("path").create(), "finding2", "rule"));
        fn.addFinding(new Finding(FileNode.builder("path").create(), "finding3", "rule"));
        fixture.graph.addVertex(fn);
        fixture.graph.addEdge(new FindingToMeasureEdge("name", fn, fixture), fn, fixture, EdgeType.DIRECTED);

        final Set<Finding> result = fixture.getFindings();

        assertNotNull(result);
        assertEquals(3, result.size());
    }

    /**
     * Run the Set<Finding> getFindings() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetFindings_2() throws Exception
    {
        final FindingsUnionNode fixture = new FindingsUnionNode(new DirectedSparseGraph<>(), "union", "owner");

        fixture.graph.addVertex(fixture);
        final Set<Finding> result = fixture.getFindings();

        assertTrue(result.isEmpty());
    }

    /**
     * Run the BigDecimal getLowerResult() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetLowerResult_1() throws Exception
    {
        final FindingsUnionNode fixture = new FindingsUnionNode(new DirectedSparseGraph<>(), "union", "owner");

        final BigDecimal result = fixture.getLowerResult();

        // add additional test code here
        assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Run the BigDecimal getUpperResult() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetUpperResult_1() throws Exception
    {
        final FindingsUnionNode fixture = new FindingsUnionNode(new DirectedSparseGraph<>(), "union", "owner");

        final BigDecimal result = fixture.getUpperResult();

        // add additional test code here
        assertEquals(BigDecimal.ONE, result);
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
        final FindingsUnionNode fixture = new FindingsUnionNode(new DirectedSparseGraph<>(), "union", "owner");

        final BigDecimal result = fixture.getValue();

        // add additional test code here
        assertEquals(BigDecimal.ONE, result);
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
        // add additional set up code here
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
        new org.junit.runner.JUnitCore().run(FindingsUnionNodeTest.class);
    }
}