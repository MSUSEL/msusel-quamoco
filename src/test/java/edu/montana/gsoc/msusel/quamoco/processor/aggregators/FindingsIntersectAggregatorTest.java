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
package edu.montana.gsoc.msusel.quamoco.processor.aggregators;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * The class <code>FindingsIntersectAggregatorTest</code> contains tests for the
 * class <code>{@link FindingsIntersectAggregator}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class FindingsIntersectAggregatorTest {

    private FindingsIntersectAggregator fixture;
    private FindingNode                 fn1;
    private FindingNode                 fn2;

    /**
     * Run the FindingsIntersectAggregator(Node) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testFindingsIntersectAggregator_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
//        final Node owner = new MeasureNode(graph, "measure", "owner");

//        final FindingsIntersectAggregator result = new FindingsIntersectAggregator(owner);

        // add additional test code here
//        Assert.assertNotNull(result);
    }

    /**
     * Run the Set<Finding> aggregate() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testAggregate_1() throws Exception
    {
        fn1.addFinding(new Finding(FileNode.builder().key("file").create(), "issue1", "issue"));
        fn1.addFinding(new Finding(FileNode.builder().key("file2").create(), "issue2", "issue"));

        fn2.addFinding(new Finding(FileNode.builder().key("file").create(), "issue1", "issue2"));
        fn2.addFinding(new Finding(FileNode.builder().key("file2").create(), "issue2", "issue2"));

        final Set<Finding> result = fixture.aggregate();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    /**
     * Run the Set<Finding> aggregate() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testAggregate_2() throws Exception
    {
        fn1.addFinding(new Finding(FileNode.builder().key("file").create(), "issue1", "issue"));
        fn1.addFinding(new Finding(FileNode.builder().key("file2").create(), "issue2", "issue"));

        fn2.addFinding(new Finding(FileNode.builder().key("file").create(), "issue1", "issue"));
        fn2.addFinding(new Finding(FileNode.builder().key("file2").create(), "issue2", "issue2"));

        final Set<Finding> result = fixture.aggregate();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    /**
     * Run the Set<Finding> aggregate() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testAggregate_3() throws Exception
    {
        fn1.addFinding(new Finding(FileNode.builder().key("file").create(), "issue1", "issue"));
        fn1.addFinding(new Finding(FileNode.builder().key("file2").create(), "issue2", "issue"));

        final Set<Finding> result = fixture.aggregate();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    /**
     * Run the Set<Finding> aggregate() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testAggregate_4() throws Exception
    {
        fn1.addFinding(new Finding(FileNode.builder().key("file").create(), "issue1", "issue"));

        fn2.addFinding(new Finding(FileNode.builder().key("file").create(), "issue1", "issue"));

        final Set<Finding> result = fixture.aggregate();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 1/26/16 6:35 PM
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
        final MeasureNode src = new MeasureNode(graph, "src", "owner");
        final MeasureNode dest = new MeasureNode(graph, "dest", "owner");
        fn1 = new FindingNode(graph, "key", "owner", "rule", "tool");
        fn2 = new FindingNode(graph, "key2", "owner", "rule2", "tool");

        fixture = new FindingsIntersectAggregator(dest);
        dest.setProcessor(fixture);

        src.setProcessor(new FindingsIntersectAggregator(src));

        graph.addEdge(fn1, src, new FindingToMeasureEdge("edge1", fn1, src));
        graph.addEdge(fn2, dest, new FindingToMeasureEdge("edge2", fn2, dest));
        graph.addEdge(src, dest, new MeasureToMeasureFindingsEdge("edge3", src, dest));
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 1/26/16 6:35 PM
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
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(FindingsIntersectAggregatorTest.class);
    }
}