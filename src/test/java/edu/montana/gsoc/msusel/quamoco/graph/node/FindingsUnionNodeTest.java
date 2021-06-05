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
import edu.isu.isuese.datamodel.File;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.processor.NullProcessor;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * The class <code>FindingsUnionNodeTest</code> contains tests for the class
 * <code>{@link FindingsUnionNode}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class FindingsUnionNodeTest extends DBSpec {

    /**
     * Run the FindingsUnionNode(DirectedSparseGraph<Node,Edge>,String,String)
     * constructor test.
     */
    @Test
    public void testFindingsUnionNode_1() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final String name = "name";
        final String owner = "owner";

        final FindingsUnionNode result = new FindingsUnionNode(graph, name, owner);

        // add additional test code here
        assertNotNull(result);
        assertNull(result.getXMLTag());
        assertEquals(0.0, result.getLowerResult(), 0.001);
        assertEquals(1.0, result.getUpperResult(), 0.001);
        assertEquals(1.0, result.getValue(), 0.001);
        assertEquals("owner", result.getOwnedBy());
        assertEquals("", result.getDescription());
        assertNull(result.getProcessor());
        assertEquals("Node(name=name)", result.toString());
        assertEquals("name", result.getName());
    }

    /**
     * Run the Set<Finding> getFindings() method test.
     */
    @Test
    public void testGetFindings_1() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final FindingsUnionNode fixture = new FindingsUnionNode(graph, "union", "owner");
        fixture.processor = new NullProcessor(fixture);

        fixture.graph.addNode(fixture);
        final FindingNode fn = new FindingNode(fixture.graph, "finding", "finding", "rule", "tool");
        fn.addFinding(new FileFinding(File.builder().fileKey("path").create(), "finding1", "rule"));
        fn.addFinding(new FileFinding(File.findFirst("fileKey = ?", "path"), "finding2", "rule"));
        fn.addFinding(new FileFinding(File.findFirst("fileKey = ?", "path"), "finding3", "rule"));
        fixture.graph.addNode(fn);
        fixture.graph.addEdge(fn, fixture, new FindingToMeasureEdge("name", fn, fixture));

        final List<Finding> result = fixture.getFindings();

        assertNotNull(result);
        assertEquals(3, result.size());
    }

    /**
     * Run the Set<Finding> getFindings() method test.
     */
    @Test
    public void testGetFindings_2() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final FindingsUnionNode fixture = new FindingsUnionNode(graph, "union", "owner");

        fixture.graph.addNode(fixture);
        final List<Finding> result = fixture.getFindings();

        assertTrue(result.isEmpty());
    }

    /**
     * Run the BigDecimal getLowerResult() method test.
     */
    @Test
    public void testGetLowerResult_1() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final FindingsUnionNode fixture = new FindingsUnionNode(graph, "union", "owner");

        final double result = fixture.getLowerResult();

        // add additional test code here
        assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the BigDecimal getUpperResult() method test.
     */
    @Test
    public void testGetUpperResult_1() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final FindingsUnionNode fixture = new FindingsUnionNode(graph, "union", "owner");

        final double result = fixture.getUpperResult();

        // add additional test code here
        assertEquals(1.0, result, 0.001);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_1() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final FindingsUnionNode fixture = new FindingsUnionNode(graph, "union", "owner");

        final double result = fixture.getValue();

        // add additional test code here
        assertEquals(1.0, result, 0.001);
    }
}