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
package edu.montana.gsoc.msusel.quamoco.processor;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.node.member.MethodNode;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.codetree.node.structural.ProjectNode;
import edu.montana.gsoc.msusel.codetree.node.type.ClassNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;
import edu.montana.gsoc.msusel.metrics.Measurement;
import edu.montana.gsoc.msusel.metrics.MeasuresTable;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.extents.Extent;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * The class <code>ExtentTest</code> contains tests for the class
 * <code>{@link Extent}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class ExtentTest {

    private Extent fixture;
    private FileNode file;
    private FileNode file2;
    private FileNode file3;

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
    public void testFindExtent_1() throws Exception {
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
    public void testFindExtent_2() throws Exception {
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
    public void testFindExtent_3() throws Exception {
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
    public void testFindExtent_4() throws Exception {
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
    public void testFindExtent_7() throws Exception {
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
    public void testFindExtent_8() throws Exception {
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
    public void testFindExtent_9() throws Exception {
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
    public void testFindMeasureExtent_1() throws Exception {
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
    public void testFindMeasureExtent_2() throws Exception {
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
    public void testFindMeasureExtent_3() throws Exception {
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
    public void testFindMeasureExtent_4() throws Exception {
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
    public void testFindMeasureExtent_5() throws Exception {
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
    public void testGetInstance_1() throws Exception {
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
    public void setUp() throws Exception {
        fixture = Extent.getInstance();
        fixture.clearExtents();

        CodeTree tree = new CodeTree();

        ProjectNode proj = ProjectNode.builder().key("Test").create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(proj).withValue(1000.0));
        MeasuresTable.getInstance().store(Measurement.of("NOM").on(proj).withValue(2.0));
        MeasuresTable.getInstance().store(Measurement.of("NIV").on(proj).withValue(10.0));
        MeasuresTable.getInstance().store(Measurement.of("NOC").on(proj).withValue(2.0));

        file = FileNode.builder().key("path").create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(file).withValue(200.0));

        TypeNode type = ClassNode.builder().key("namespace.Type").start(1).end(100).create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(type).withValue(100.0));
        file.addChild(type);

        MethodNode method1 = MethodNode.builder().key("namespace.Type#method").start(20).end(100).create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(method1).withValue(80.0));
        type.addChild(method1);

        file2 = FileNode.builder().key("path2").create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(file2).withValue(200.0));

        file3 = FileNode.builder().key("path3").create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(file3).withValue(200.0));

        proj.addChild(file);
        proj.addChild(file2);
        proj.addChild(file3);

        tree.setProject(proj);

        fileFinding = new Finding(file, "issue", "issue");
        methodFinding = new Finding(method1, "issue", "issue");
        typeFinding = new Finding(type, "issue", "issue");

        MeasuresTable.getInstance().merge(tree);
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @After
    public void tearDown() throws Exception {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    public static void main(final String[] args) {
        new org.junit.runner.JUnitCore().run(ExtentTest.class);
    }

    private void buildGraph() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();

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

        graph.addEdge(src, measure, edge);
        graph.addEdge(srcsrc, src, f2m);
    }
}