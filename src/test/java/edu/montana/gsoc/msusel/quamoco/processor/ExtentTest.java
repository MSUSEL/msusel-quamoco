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
package edu.montana.gsoc.msusel.quamoco.processor;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.isu.isuese.datamodel.*;
import edu.isu.isuese.datamodel.Class;
import edu.isu.isuese.datamodel.System;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.*;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.extents.Extent;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The class <code>ExtentTest</code> contains tests for the class
 * <code>{@link Extent}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class ExtentTest extends DBSpec {

    private Extent fixture;
    private File file;
    private File file2;
    private File file3;

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

        final double result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(600.0, result, 0.001);
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

        final double result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(100.0, result, 0.001);
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

        final double result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(80.0, result, 0.001);
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

        final double result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(1000.0, result, 0.001);
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
        final double result = fixture.findMeasureExtent(metric, range, measure);

        // add additional test code here
        assertEquals(600.0, result, 0.001);
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
        //MeasuresTable.getInstance().clean();
        fixture = Extent.getInstance();
        fixture.clearExtents();

        System tree = new System();

        Project proj = Project.builder().projKey("Test").create();
        proj.addMeasure(Measure.of("LOC").on(proj).withValue(1000.0));
        proj.addMeasure(Measure.of("NOM").on(proj).withValue(2.0));
        proj.addMeasure(Measure.of("NIV").on(proj).withValue(10.0));
        proj.addMeasure(Measure.of("NOC").on(proj).withValue(2.0));

        file = File.builder().fileKey("path").create();
        proj.addMeasure(Measure.of("LOC").on(file).withValue(200.0));

        Type type = Class.builder().compKey("namespace.Type").start(1).end(100).create();
        proj.addMeasure(Measure.of("LOC").on(type).withValue(100.0));
        file.addType(type);

        Method method1 = Method.builder().compKey("namespace.Type#method").start(20).end(100).create();
        proj.addMeasure(Measure.of("LOC").on(method1).withValue(80.0));
        type.addMember(method1);

        file2 = File.builder().fileKey("path2").create();
        proj.addMeasure(Measure.of("LOC").on(file2).withValue(200.0));

        file3 = File.builder().fileKey("path3").create();
        proj.addMeasure(Measure.of("LOC").on(file3).withValue(200.0));

        proj.addFile(file);
        proj.addFile(file2);
        proj.addFile(file3);

        tree.addProject(proj);

        fileFinding = new FileFinding(file, "issue", "issue");
        methodFinding = new ComponentFinding(method1, "issue", "issue");
        typeFinding = new ComponentFinding(type, "issue", "issue");
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

        srcsrc.addFinding(new FileFinding(file, "issue", "issue"));
        srcsrc.addFinding(new FileFinding(file2, "issue", "issue"));
        srcsrc.addFinding(new FileFinding(file3, "issue", "issue"));

        graph.addEdge(src, measure, edge);
        graph.addEdge(srcsrc, src, f2m);
    }
}