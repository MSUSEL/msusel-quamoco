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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.graph.edge;

import java.math.BigDecimal;
import java.util.Set;

import edu.montana.gsoc.msusel.gsoc.msusel.node.FileNode;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * The class <code>MeasureToMeasureFindingsEdgeTest</code> contains tests for
 * the class <code>{@link MeasureToMeasureFindingsEdge}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class MeasureToMeasureFindingsEdgeTest {

    private MeasureToMeasureFindingsEdge fixture;

    /**
     * Run the MeasureToMeasureFindingsEdge(String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testMeasureToMeasureFindingsEdge_1() throws Exception
    {
        final String name = "edge";

        final MeasureToMeasureFindingsEdge result = new MeasureToMeasureFindingsEdge(name, null, null);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(BigDecimal.ZERO, result.getValue());
        Assert.assertEquals("edge", result.getName());
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
        final Set<Finding> result = fixture.getFindings();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }

    /**
     * Run the double getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_1() throws Exception
    {
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ZERO, result);
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
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final MeasureNode dest = new MeasureNode(graph, "dest", "owner");
        dest.setType(MeasureType.FINDINGS);
        final MeasureNode src = new MeasureNode(graph, "src", "owner");
        src.setType(MeasureType.FINDINGS);
        final FindingNode srcsrc = new FindingNode(graph, "key", "owner", "rule", "tool");
        final FindingToMeasureEdge f2m = new FindingToMeasureEdge("preedge", srcsrc, src);
        fixture = new MeasureToMeasureFindingsEdge("fixture", src, dest);
        src.setProcessor(new FindingsUnionAggregator(src));

        srcsrc.addFinding(new Finding(FileNode.builder("path0").create(), "issue", "issue"));
        srcsrc.addFinding(new Finding(FileNode.builder("path1").create(), "issue", "issue"));
        srcsrc.addFinding(new Finding(FileNode.builder("path2").create(), "issue", "issue"));

        graph.addEdge(fixture, src, dest);
        graph.addEdge(f2m, srcsrc, src);
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
        new org.junit.runner.JUnitCore().run(MeasureToMeasureFindingsEdgeTest.class);
    }
}