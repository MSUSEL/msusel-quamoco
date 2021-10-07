/*
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
import edu.isu.isuese.datamodel.System;
import edu.isu.isuese.datamodel.*;
import edu.montana.gsoc.msusel.quamoco.distiller.QuamocoContext;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.*;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.extents.Extent;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The class <code>ExtentTest</code> contains tests for the class
 * <code>{@link Extent}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
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
     */
    @Test
    public void testFindExtent_1() {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.FILE;

        final double result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(600.0, result, 0.001);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     */
    @Test
    public void testFindExtent_2() {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.CLASS;

        final double result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(100.0, result, 0.001);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     */
    @Test
    public void testFindExtent_3() {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.METHOD;

        final double result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(80.0, result, 0.001);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     */
    @Test
    public void testFindExtent_4() {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.NA;

        final double result = fixture.findExtent(metric, range);

        // add additional test code here
        assertEquals(1000.0, result, 0.001);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindExtent_7() {
        final String metric = "";
        final NormalizationRange range = NormalizationRange.CLASS;

        fixture.findExtent(metric, range);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindExtent_8() {
        final String metric = null;
        final NormalizationRange range = NormalizationRange.CLASS;

        fixture.findExtent(metric, range);
    }

    /**
     * Run the double findExtent(String,NormalizationRange) method test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindExtent_9() {
        final String metric = "LOC";
        final NormalizationRange range = null;

        fixture.findExtent(metric, range);
    }

    /**
     * Run the double findMeasureExtent(String,NormalizationRange,MeasureNode)
     * method test.
     */
    @Test
    public void testFindMeasureExtent_1() {
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
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMeasureExtent_2() {
        final String metric = "";
        final NormalizationRange range = NormalizationRange.FILE;

        buildGraph();

        fixture.findMeasureExtent(metric, range, measure);
    }

    /**
     * Run the double findMeasureExtent(String,NormalizationRange,MeasureNode)
     * method test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMeasureExtent_3() {
        final String metric = null;
        final NormalizationRange range = NormalizationRange.FILE;

        buildGraph();
        fixture.findMeasureExtent(metric, range, measure);
    }

    /**
     * Run the double findMeasureExtent(String,NormalizationRange,MeasureNode)
     * method test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMeasureExtent_4() {
        final String metric = "LOC";
        final NormalizationRange range = null;

        buildGraph();
        fixture.findMeasureExtent(metric, range, measure);
    }

    /**
     * Run the double findMeasureExtent(String,NormalizationRange,MeasureNode)
     * method test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindMeasureExtent_5() {
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.FILE;

        buildGraph();
        fixture.findMeasureExtent(metric, range, null);
    }

    /**
     * Run the Extent getInstance() method test.
     */
    @Test
    public void testGetInstance_1() {
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
     */
    @Before
    public void setUp() throws Exception {
        //MeasuresTable.getInstance().clean();
        fixture = Extent.getInstance();
        fixture.clearExtents();

        System tree = System.builder().name("System").key("System").create();

        Project proj = Project.builder().projKey("Test").name("Test").create();
        MetricRepository repo = MetricRepository.builder().key("repo").name("repo").create();
        repo.addMetric(Metric.builder().handle("LOC").key("repo:LOC").name("LOC").create());
        repo.addMetric(Metric.builder().handle("NOM").key("repo:NOM").name("NOM").create());
        repo.addMetric(Metric.builder().handle("NIV").key("repo:NIV").name("NIV").create());
        repo.addMetric(Metric.builder().handle("NOC").key("repo:NOC").name("NOC").create());
        QuamocoContext.instance().setMetricRepoKey("repo");
        QuamocoContext.instance().setProject(proj);

        proj.addMeasure(Measure.of("repo:LOC").on(proj).withValue(1000.0));
        proj.addMeasure(Measure.of("repo:NOM").on(proj).withValue(2.0));
        proj.addMeasure(Measure.of("repo:NIV").on(proj).withValue(10.0));
        proj.addMeasure(Measure.of("repo:NOC").on(proj).withValue(2.0));

        Namespace ns = Namespace.builder().nsKey("ns").name("ns").create();
        proj.addNamespace(ns);

        file = File.builder().fileKey("path").create();
        proj.addFile(file);
        proj.addMeasure(Measure.of("repo:LOC").on(file).withValue(200.0));

        Type type = Type.builder().type(Type.CLASS).compKey("namespace.Type").start(1).end(100).create();
        file.addType(type);
        ns.addType(type);
        proj.addMeasure(Measure.of("repo:LOC").on(type).withValue(100.0));

        Method method1 = Method.builder().compKey("namespace.Type#method").start(20).end(100).create();
        type.addMember(method1);
        proj.addMeasure(Measure.of("repo:LOC").on(method1).withValue(80.0));

        file2 = File.builder().fileKey("path2").create();
        proj.addFile(file2);
        proj.addMeasure(Measure.of("repo:LOC").on(file2).withValue(200.0));

        file3 = File.builder().fileKey("path3").create();
        proj.addFile(file3);
        proj.addMeasure(Measure.of("repo:LOC").on(file3).withValue(200.0));

        tree.addProject(proj);

        fileFinding = new FileFinding(file, "issue", "issue");
        methodFinding = new ComponentFinding(method1, "issue", "issue");
        typeFinding = new ComponentFinding(type, "issue", "issue");
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