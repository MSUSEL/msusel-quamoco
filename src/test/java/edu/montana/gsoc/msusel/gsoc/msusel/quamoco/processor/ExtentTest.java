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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.gsoc.msusel.node.FileNode;
import edu.montana.gsoc.msusel.gsoc.msusel.node.MethodNode;
import edu.montana.gsoc.msusel.gsoc.msusel.node.ProjectNode;
import edu.montana.gsoc.msusel.gsoc.msusel.node.TypeNode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.Extent;
import edu.montana.gsoc.msusel.quamoco.processor.MetricsContext;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * The class <code>ExtentTest</code> contains tests for the class
 * <code>{@link Extent}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class ExtentTest {

    private Extent     fixture;
    private FileNode   file;
    private FileNode   file2;
    private FileNode   file3;
    private TypeNode   type;
    private MethodNode method;

    private Finding fileFinding;
    private Finding methodFinding;
    private Finding typeFinding;

    private MeasureNode measure;

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testFindExtent_1() throws Exception
    {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.FILE;

        final BigDecimal result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(new BigDecimal(600.0), result);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testFindExtent_2() throws Exception
    {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.CLASS;

        final BigDecimal result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(new BigDecimal(100.0), result);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testFindExtent_3() throws Exception
    {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.METHOD;

        final BigDecimal result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(new BigDecimal(80.0), result);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testFindExtent_4() throws Exception
    {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.NA;

        final BigDecimal result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(new BigDecimal(1000.0), result);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindExtent_7() throws Exception
    {
        final String metric = "";
        final NormalizationRange range = NormalizationRange.CLASS;

        fixture.findExtent(metric, range);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindExtent_8() throws Exception
    {
        final String metric = null;
        final NormalizationRange range = NormalizationRange.CLASS;

        fixture.findExtent(metric, range);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindExtent_9() throws Exception
    {
        final String metric = "LOC";
        final NormalizationRange range = null;

        fixture.findExtent(metric, range);
    }

    /**
     * Run the double findMeasureExtent(String,NormalizationRange,MeasureNode)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testFindMeasureExtent_1() throws Exception
    {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.FILE;

        buildGraph();
        final BigDecimal result = fixture.findMeasureExtent(metric, range, measure);

        // add additional test code here
        assertEquals(new BigDecimal(600.0), result);
    }

    /**
     * Run the double findMeasureExtent(String,NormalizationRange,MeasureNode)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMeasureExtent_2() throws Exception
    {
        final String metric = "";
        final NormalizationRange range = NormalizationRange.FILE;

        buildGraph();

        fixture.findMeasureExtent(metric, range, measure);
    }

    /**
     * Run the double findMeasureExtent(String,NormalizationRange,MeasureNode)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMeasureExtent_3() throws Exception
    {
        final String metric = null;
        final NormalizationRange range = NormalizationRange.FILE;

        buildGraph();
        fixture.findMeasureExtent(metric, range, measure);
    }

    /**
     * Run the double findMeasureExtent(String,NormalizationRange,MeasureNode)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMeasureExtent_4() throws Exception
    {
        final String metric = "LOC";
        final NormalizationRange range = null;

        buildGraph();
        fixture.findMeasureExtent(metric, range, measure);
    }

    /**
     * Run the double findMeasureExtent(String,NormalizationRange,MeasureNode)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMeasureExtent_5() throws Exception
    {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.FILE;

        buildGraph();
        fixture.findMeasureExtent(metric, range, null);
    }

    /**
     * Run the Extent getInstance() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testGetInstance_1() throws Exception
    {
        final Extent result = Extent.getInstance();
        final Extent result2 = Extent.getInstance();

        // add additional test code here
        assertNotNull(result);
        assertNotNull(result2);
        assertSame(result, result2);
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
        fixture = Extent.getInstance();
        fixture.clearExtents();
        final MetricsContext context = MetricsContext.getCleanInstance();

        CodeTree tree = new CodeTree();
        FileNode file = null;
        MethodNode method = null;
        TypeNode type = null;
        ProjectNode proj = ProjectNode.builder("Test")
                .file(
                        file = FileNode.builder("path")
                                .metric("LOC", 200.0)
                                .type(
                                        type = TypeNode.builder("Type", "namespace.Type")
                                                .range(1, 100)
                                                .metric("LOC", 100.0)
                                                .method(
                                                        method = MethodNode.builder("method", "namespace.Type#method")
                                                                .range(20, 100)
                                                                .metric("LOC", 80.0)
                                                                .create())
                                                .create())
                                .create())
                .file(FileNode.builder("path2").metric("LOC", 200.0).create())
                .file(FileNode.builder("path3").metric("LOC", 200.0).create())
                .metric("LOC", 1000.0)
                .metric("NOM", 2.0)
                .metric("NIV", 10.0)
                .metric("NOC", 2.0)
                .create();
        tree.setProject(proj);

        fileFinding = new Finding(file, "issue", "issue");
        methodFinding = new Finding(method, "issue", "issue");
        typeFinding = new Finding(type, "issue", "issue");

        context.merge(tree);
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
        new org.junit.runner.JUnitCore().run(ExtentTest.class);
    }

    private void buildGraph()
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        measure = new MeasureNode(graph, "dest", "owner");
        measure.setType(MeasureType.FINDINGS);
        final MeasureNode src = new MeasureNode(graph, "src", "owner");
        src.setType(MeasureType.FINDINGS);
        final FindingNode srcsrc = new FindingNode(graph, "key", "owner", "rule", "tool");
        final FindingToMeasureEdge f2m = new FindingToMeasureEdge("preedge", srcsrc, src);
        final Edge edge = new MeasureToMeasureFindingsEdge("fixture", src, measure);
        src.setProcessor(new FindingsUnionAggregator(src));
        measure.setProcessor(new FindingsUnionAggregator(src));

        srcsrc.addFinding(new Finding(file, "issue", "issue"));
        srcsrc.addFinding(new Finding(file2, "issue", "issue"));
        srcsrc.addFinding(new Finding(file3, "issue", "issue"));

        graph.addEdge(edge, src, measure);
        graph.addEdge(f2m, srcsrc, src);
    }
}