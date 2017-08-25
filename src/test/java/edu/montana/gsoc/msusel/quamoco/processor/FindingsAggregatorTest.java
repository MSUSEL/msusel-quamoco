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
package edu.montana.gsoc.msusel.quamoco.processor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import edu.montana.gsoc.msusel.node.FileNode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.FindingsAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * The class <code>FindingsAggregatorTest</code> contains tests for the class
 * <code>{@link FindingsAggregator}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class FindingsAggregatorTest {

    private FindingsAggregator fixture;

    /**
     * Run the double aggregate(Map<Node,Double>) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testAggregate_1() throws Exception
    {
        final List<BigDecimal> values = Lists.newArrayList();
        values.add(new BigDecimal(10.0));
        values.add(new BigDecimal(20.0));
        values.add(new BigDecimal(0.0));
        final BigDecimal result = fixture.aggregate(values);

        Assert.assertEquals(new BigDecimal(1.0), result);
    }

    /**
     * Run the Set<Finding> processFindings() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testProcessFindings_1() throws Exception
    {
        final Set<Finding> result = fixture.processFindings();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(2, result.size());
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
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();

        final FindingNode fn = new FindingNode(graph, "fn1", "owner", "rule1", "tool");
        fn.addFinding(new Finding(FileNode.builder("path2").create(), "issue1", "issue"));
        final MeasureNode mn = new MeasureNode(graph, "measure1", "owner");
        mn.setType(MeasureType.FINDINGS);
        final MeasureNode mn2 = new MeasureNode(graph, "measure2", "owner");
        mn2.setType(MeasureType.FINDINGS);
        final FindingNode fn2 = new FindingNode(graph, "fn2", "owner", "rule1", "tool");
        fn2.addFinding(new Finding(FileNode.builder("path").create(), "issue1", "issue"));

        graph.addEdge(new FindingToMeasureEdge("edge1", fn, mn), fn, mn, EdgeType.DIRECTED);
        graph.addEdge(new MeasureToMeasureFindingsEdge("edge2", mn2, mn), mn2, mn, EdgeType.DIRECTED);
        graph.addEdge(new FindingToMeasureEdge("edge3", fn2, mn2), fn2, mn2, EdgeType.DIRECTED);

        fixture = new FindingsUnionAggregator(mn);
        mn.setProcessor(fixture);
        mn2.setProcessor(new FindingsUnionAggregator(mn2));
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
        new org.junit.runner.JUnitCore().run(FindingsAggregatorTest.class);
    }
}