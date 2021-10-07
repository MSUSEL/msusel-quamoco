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
package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.isu.isuese.datamodel.System;
import edu.isu.isuese.datamodel.*;
import edu.montana.gsoc.msusel.quamoco.distiller.QuamocoContext;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.*;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class GraphTest extends BaseTestClass {

    @Test
    public void testGraph() {

    }

    public void testQualityProd() {

    }

    @Test
    public void testQualitySourceCode() {
        Node fixture = findNodeByName("Quality @Source Code Part");
        assertNotNull(fixture);
        assertTrue(fixture instanceof FactorNode);

        System sys = System.builder().name("System").key("system").create();
        Project proj = Project.builder().projKey("project").create();
        sys.addProject(proj);
        File fn = File.builder().fileKey("file1").create();
        File fn2 = File.builder().fileKey("file2").create();
        proj.addFile(fn);
        proj.addFile(fn2);
        MetricRepository repo = MetricRepository.builder().key("repo").name("repo").create();
        repo.addMetric(Metric.builder()
                .name("Test Normalization @Source Code Part")
                .handle("Test Normalization @Source Code Part")
                .key("repo:Test Normalization @Source Code Part")
                .create());
        repo.addMetric(Metric.builder()
                .name("NormMeas")
                .handle("NormMeas")
                .key("repo:NormMeas")
                .create());
        QuamocoContext.instance().setProject(proj);
        QuamocoContext.instance().setMetricRepoKey("repo");
        proj.addMeasure(Measure.of("repo:Test Normalization @Source Code Part").on(fn).withValue(10.0));
        proj.addMeasure(Measure.of("repo:Test Normalization @Source Code Part").on(fn2).withValue(90.0));
        proj.addMeasure(Measure.of("repo:NormMeas").on(fn).withValue(10.0));
        proj.addMeasure(Measure.of("repo:NormMeas").on(fn2).withValue(90.0));

        FindingNode[] nodes = new FindingNode[4];
        for (int i = 1; i < 5; i++) {
            nodes[i-1] = (FindingNode) findNodeByName("Test" + i);
            assertNotNull(nodes[i-1]);
        }

        FindingNode n = (FindingNode) findNodeByName("TestOther");
        Finding f1 = new FileFinding(fn, "key", "name");
        Finding f2 = new FileFinding(fn, "key", "name2");
        n.addFinding(f1);
        n.addFinding(f2);

        int i = 1;
        for (FindingNode n2 : nodes) {
            n2.addFinding(f1);
            n2.addFinding(f2);
            i++;
        }

        assertEquals(0.0, fixture.getValue(), 0.001);
    }

    @Test
    public void testSecurity() {
        Node fixture = findNodeByName("Security");
        assertNotNull(fixture);

        System sys = System.builder().name("System").key("system").create();
        Project proj = Project.builder().projKey("project").create();
        File fn = File.builder().fileKey("file1").create();
        File fn2 = File.builder().fileKey("file2").create();
        sys.addProject(proj);
        proj.addFile(fn);
        proj.addFile(fn2);
        MetricRepository repo = MetricRepository.builder().key("repo").name("repo").create();
        repo.addMetric(Metric.builder()
                .name("Test Normalization @Source Code Part")
                .handle("Test Normalization @Source Code Part")
                .key("repo:Test Normalization @Source Code Part")
                .create());
        QuamocoContext.instance().setProject(proj);
        QuamocoContext.instance().setMetricRepoKey("repo");
        proj.addMeasure(Measure.of("repo:Test Normalization @Source Code Part").on(fn).withValue(10.0));
        proj.addMeasure(Measure.of("repo:Test Normalization @Source Code Part").on(fn2).withValue(90.0));

        FindingNode n = (FindingNode) findNodeByName("TestOther");
        Finding f1 = new FileFinding(fn, "key", "name");
        Finding f2 = new FileFinding(fn, "key", "name2");
        n.addFinding(f1);
        n.addFinding(f2);

        for (Edge e : graph.inEdges(fixture)) {
            assertTrue(e instanceof MeasureToFactorFindingsEdge);
            MeasureToFactorFindingsEdge mffe = (MeasureToFactorFindingsEdge) e;
            assertNotNull(mffe.getNormalizer());
            assertEquals(1.0, mffe.getRank(), 0.001);
            assertEquals(1.0, mffe.getWeight(), 0.001);
        }

        assertEquals(0.2, fixture.getValue(), 0.001);
    }

    public void testParent() {

    }

    @Test
    public void testMaintainability() {
        Node fixture = findNodeByName("Maintainability");
        assertNotNull(fixture);

        System sys = System.builder().name("System").key("system").create();
        Project proj = Project.builder().projKey("project").create();
        sys.addProject(proj);
        File fn = File.builder().fileKey("file1").create();
        File fn2 = File.builder().fileKey("file2").create();
        proj.addFile(fn);
        proj.addFile(fn2);
        MetricRepository repo = MetricRepository.builder().key("repo").name("repo").create();
        repo.addMetric(Metric.builder()
                .name("Test Normalization @Source Code Part")
                .handle("Test Normalization @Source Code Part")
                .key("repo:Test Normalization @Source Code Part")
                .create());
        QuamocoContext.instance().setProject(proj);
        QuamocoContext.instance().setMetricRepoKey("repo");
        proj.addMeasure(Measure.of("repo:Test Normalization @Source Code Part").on(fn).withValue(10.0));
        proj.addMeasure(Measure.of("repo:Test Normalization @Source Code Part").on(fn2).withValue(90.0));

        FindingNode n = (FindingNode) findNodeByName("TestOther");
        Finding f1 = new FileFinding(fn, "key", "name");
        Finding f2 = new FileFinding(fn, "key", "name2");
        n.addFinding(f1);
        n.addFinding(f2);

        for (Edge e : graph.inEdges(fixture)) {
            assertTrue(e instanceof MeasureToFactorFindingsEdge);
            MeasureToFactorFindingsEdge mffe = (MeasureToFactorFindingsEdge) e;
            assertEquals(1.0, mffe.getRank(), 0.001);
            assertEquals(1.0, mffe.getWeight(), 0.001);
        }

        assertEquals(0.8, fixture.getValue(), 0.001);
    }

    @Test
    public void testReliability() {
        Node fixture = findNodeByName("Reliability");
        assertNotNull(fixture);

        FindingNode[] nodes = new FindingNode[4];
        for (int i = 1; i < 5; i++) {
            nodes[i-1] = (FindingNode) findNodeByName("Test" + i);
            assertNotNull(nodes[i-1]);
        }

        assertNotNull(fixture);
        assertTrue(fixture instanceof FactorNode);

        assertEquals(5, graph.inDegree(fixture));

        int i = 0;
        System sys = System.builder().name("System").key("system").create();
        Project proj = Project.builder().projKey("project").create();
        File fn = File.builder().fileKey("file1").create();
        File fn2 = File.builder().fileKey("file2").create();
        Namespace ns = Namespace.builder().nsKey("ns").name("ns").create();
        sys.addProject(proj);
        proj.addFile(fn);
        proj.addFile(fn2);
        MetricRepository repo = MetricRepository.builder().key("repo").name("repo").create();
        repo.addMetric(Metric.builder()
                .name("NormMeas")
                .handle("NormMeas")
                .key("repo:NormMeas")
                .create());
        QuamocoContext.instance().setProject(proj);
        QuamocoContext.instance().setMetricRepoKey("repo");
        proj.addMeasure(Measure.of("repo:NormMeas").on(fn).withValue(10.0));
        proj.addMeasure(Measure.of("repo:NormMeas").on(fn2).withValue(90.0));

        for (FindingNode n : nodes) {
            Finding f1 = new FileFinding(fn, "key", "name" + i);
            Finding f2 = new FileFinding(fn, "key", "name2" + i);
            n.addFinding(f1);
            n.addFinding(f2);
            i++;
        }

        assertEquals(0.9, fixture.getValue(), 0.001);
    }

    @Test
    public void testTestMeasure() {
        Node node = findNodeByName("TestOther");
        Node fixture = findNodeByName("Test Measure @Source Code Part");

        assertNotNull(fixture);
        assertNotNull(node);
        assertTrue(fixture instanceof MeasureNode);

        MeasureNode measure = (MeasureNode) fixture;
        FindingNode finding = (FindingNode) node;

        measure.getMethod();
        assertEquals(MeasureType.FINDINGS, measure.getType());
        measure.getValue();
        assertEquals("Test Measure @Source Code Part", measure.getName());
        assertEquals(0.0, measure.getLowerResult(), 0.001);
        assertEquals(1.0, measure.getUpperResult(), 0.001);
        assertNotNull(measure.getGraph());
        assertNotNull(measure.getOwnedBy());
        assertNotNull(measure.getProcessor());

        Finding f1 = new FileFinding(File.builder().fileKey("file1").create(), "key", "name");
        Finding f2 = new FileFinding(File.findFirst("fileKey = ?", "file1"), "key", "name2");

        finding.addFinding(f1);
        finding.addFinding(f2);

        assertEquals(2, finding.getFindings().size());

        for (Edge e : graph.edgesConnecting(node, fixture)) {
            assertTrue(e instanceof FindingToMeasureEdge);
            FindingToMeasureEdge ftm = (FindingToMeasureEdge) e;
            assertNull(ftm.getNorm());
            assertEquals(2, ftm.getFindings().size());
            assertEquals(0.0, e.getValue(), 0.001);
        }
    }

    @Test
    public void testRelMultMeasure() {
        FindingNode[] nodes = new FindingNode[4];
        for (int i = 1; i < 5; i++) {
            nodes[i-1] = (FindingNode) findNodeByName("Test" + i);
            assertNotNull(nodes[i-1]);
        }

        Node fixture = findNodeByName("RelMultMeasure");

        assertNotNull(fixture);
        assertTrue(fixture instanceof FactorNode);

        assertEquals(4, graph.inDegree(fixture));

        for (Edge e : graph.inEdges(fixture)) {
            assertTrue(e instanceof MeasureToFactorFindingsEdge);
            MeasureToFactorFindingsEdge mtfe = (MeasureToFactorFindingsEdge) e;
            assertEquals(InfluenceEffect.POSITIVE.toString(), mtfe.getInf());
            assertNotNull(mtfe.getNorm());
            assertEquals(0.25, mtfe.getWeight(), 0.001);
            //((MeasureToFactorFindingsEdge) e).setDist(new PositiveLinearDistribution());
        }

        int i = 0;
        System sys = System.builder().name("System").key("system").create();
        Project proj = Project.builder().projKey("project").create();
        File fn = File.builder().fileKey("file1").create();
        File fn2 = File.builder().fileKey("file2").create();
        sys.addProject(proj);
        proj.addFile(fn);
        proj.addFile(fn2);
        MetricRepository repo = MetricRepository.builder().key("repo").name("repo").create();
        repo.addMetric(Metric.builder()
                .name("NormMeas")
                .handle("NormMeas")
                .key("repo:NormMeas")
                .create());
        QuamocoContext.instance().setProject(proj);
        QuamocoContext.instance().setMetricRepoKey("repo");
        proj.addMeasure(Measure.of("repo:NormMeas").on(fn).withValue(10.0));
        proj.addMeasure(Measure.of("repo:NormMeas").on(fn2).withValue(90.0));

        for (FindingNode n : nodes) {
            Finding f1 = new FileFinding(fn, "key", "name" + i);
            Finding f2 = new FileFinding(fn, "key", "name2" + i);
            n.addFinding(f1);
            n.addFinding(f2);
            i++;
        }

        assertEquals(0.5, fixture.getValue(), 0.001);
        assertEquals(8, fixture.getFindings().size());
    }

    @Test
    public void testRelText() {
        Node fixture = findNodeByName("RelText");
        assertNotNull(fixture);
        assertTrue(fixture instanceof FactorNode);

        Node textMeas = findNodeByName("TextMeas");
        assertNotNull(textMeas);

        assertTrue(textMeas instanceof MeasureNode);

        assertEquals(1.0, textMeas.getValue(), 0.001);
        assertEquals(1.0, fixture.getValue(), 0.001);

        for (Edge e : graph.inEdges(fixture)) {
            assertTrue(e instanceof MeasureToFactorFindingsEdge);
            MeasureToFactorFindingsEdge mtff = (MeasureToFactorFindingsEdge) e;
            assertEquals("POSITIVE", mtff.getInf());
            assertEquals(1.0, mtff.getRank(), 0.001);
            assertEquals(1.0, mtff.getWeight(), 0.001);
            assertEquals(1.0, e.getValue(), 0.001);
        }
    }

    @Test
    public void testRelManual() {
        Node fixture = findNodeByName("RelManual");
        assertNotNull(fixture);
        assertTrue(fixture instanceof FactorNode);

        Node manMeas = findNodeByName("ManualMeas");
        assertNotNull(manMeas);
        assertTrue(manMeas instanceof MeasureNode);

        Node manual = findNodeByName("TestHier Manual");
        assertNotNull(manual);
        assertTrue(manual instanceof ValueNode);

        assertEquals(0.0, manMeas.getValue(), 0.001);
        assertEquals(0.0, fixture.getValue(), 0.001);

        for (Edge e : graph.inEdges(fixture)) {
            assertTrue(e instanceof MeasureToFactorNumberEdge);
            MeasureToFactorNumberEdge mtff = (MeasureToFactorNumberEdge) e;
            assertEquals("POSITIVE", mtff.getInf());
            assertEquals(1.0, mtff.getRank(), 0.001);
            assertEquals(1.0, mtff.getWeight(), 0.001);
            assertEquals(0.0, e.getValue(), 0.001);
        }
    }

    @Test
    public void testRelQIESL() {
        Node fixture = findNodeByName("RelQIESL");
        assertNotNull(fixture);
        assertTrue(fixture instanceof FactorNode);

        Node qieslMeas = findNodeByName("QIESLMeas");
        assertNotNull(qieslMeas);

        assertTrue(qieslMeas instanceof MeasureNode);

        assertEquals(0.0, qieslMeas.getValue(), 0.001);
        assertEquals(0.0, fixture.getValue(), 0.001);

        for (Edge e : graph.inEdges(fixture)) {
            assertTrue(e instanceof MeasureToFactorNumberEdge);
            MeasureToFactorNumberEdge mtff = (MeasureToFactorNumberEdge) e;
            assertEquals("POSITIVE", mtff.getInf());
            assertEquals(1.0, mtff.getRank(), 0.001);
            assertEquals(1.0, mtff.getWeight(), 0.001);
            assertEquals(0.0, e.getValue(), 0.001);
        }
    }

    @Test
    public void testUnionFactor() {
        Node fixture = findNodeByName("UnionFactor");
        assertNotNull(fixture);
        assertTrue(fixture instanceof FactorNode);

        Node unionMeas = findNodeByName("UnionMeas");
        assertNotNull(unionMeas);
        assertTrue(unionMeas instanceof MeasureNode);
        assertEquals(MeasureType.FINDINGS, ((MeasureNode) unionMeas).getType());

        Node union = findNodeByName("TestHier Union Aggr");
        assertNotNull(union);
        assertTrue(union instanceof FindingsUnionNode);

        assertEquals(0.0, unionMeas.getValue(), 0.001);
        assertEquals(1.0, fixture.getValue(), 0.001);

        for (Edge e : graph.inEdges(fixture)) {
            assertTrue(e instanceof MeasureToFactorFindingsEdge);
            MeasureToFactorFindingsEdge mtff = (MeasureToFactorFindingsEdge) e;
            assertEquals("POSITIVE", mtff.getInf());
            assertEquals(1.0, mtff.getRank(), 0.001);
            assertEquals(1.0, mtff.getWeight(), 0.001);
            assertEquals(1.0, e.getValue(), 0.001);
        }
    }

    @Test
    public void testMeasure2() {
        Node node = findNodeByName("Test2");
        Node fixture = findNodeByName("Measure2");

        assertNotNull(fixture);
        assertTrue(fixture instanceof MeasureNode);

        MeasureNode measure = (MeasureNode) fixture;
        FindingNode finding = (FindingNode) node;

        measure.getMethod();
        assertEquals(MeasureType.FINDINGS, measure.getType());
        measure.getValue();
        assertEquals("Measure2", measure.getName());
        assertEquals(0.0, measure.getLowerResult(), 0.001);
        assertEquals(1.0, measure.getUpperResult(), 0.001);
        assertNotNull(measure.getGraph());
        assertNotNull(measure.getOwnedBy());
        assertNotNull(measure.getProcessor());

        Finding f1 = new FileFinding(File.builder().fileKey("file1").create(), "key", "name");
        Finding f2 = new FileFinding(File.findFirst("fileKey = ?", "file1"), "key", "name2");

        finding.addFinding(f1);
        finding.addFinding(f2);

        assertEquals(2, finding.getFindings().size());

        assertEquals(1, graph.edgesConnecting(node, fixture).size());
        for (Edge e : graph.edgesConnecting(node, fixture)) {
            assertTrue(e instanceof FindingToMeasureEdge);
            FindingToMeasureEdge ftm = (FindingToMeasureEdge) e;
            assertNull(ftm.getNorm());
            assertEquals(2, ftm.getFindings().size());
            assertEquals(0.0, e.getValue(), 0.001);
        }
    }

    @Test
    public void testMeasure1() {
        Node node = findNodeByName("Test1");
        Node fixture = findNodeByName("Measure1");

        assertNotNull(fixture);
        assertTrue(fixture instanceof MeasureNode);

        MeasureNode measure = (MeasureNode) fixture;
        FindingNode finding = (FindingNode) node;

        measure.getMethod();
        assertEquals(MeasureType.FINDINGS, measure.getType());
        measure.getValue();
        assertEquals("Measure1", measure.getName());
        assertEquals(0.0, measure.getLowerResult(), 0.001);
        assertEquals(1.0, measure.getUpperResult(), 0.001);
        assertNotNull(measure.getGraph());
        assertNotNull(measure.getOwnedBy());
        assertNotNull(measure.getProcessor());

        Finding f1 = new FileFinding(File.builder().fileKey("file1").create(), "key", "name");
        Finding f2 = new FileFinding(File.findFirst("fileKey = ?", "file1"), "key", "name2");

        finding.addFinding(f1);
        finding.addFinding(f2);

        assertEquals(2, finding.getFindings().size());

        assertEquals(1, graph.edgesConnecting(node, fixture).size());
        for (Edge e : graph.edgesConnecting(node, fixture)) {
            assertTrue(e instanceof FindingToMeasureEdge);
            FindingToMeasureEdge ftm = (FindingToMeasureEdge) e;
            assertNull(ftm.getNorm());
            assertEquals(2, ftm.getFindings().size());
            assertEquals(0.0, e.getValue(), 0.001);
        }
    }

    @Test
    public void testMeasure3() {
        Node node = findNodeByName("Test3");
        Node fixture = findNodeByName("Measure3");

        assertNotNull(fixture);
        assertTrue(fixture instanceof MeasureNode);

        MeasureNode measure = (MeasureNode) fixture;
        FindingNode finding = (FindingNode) node;

        measure.getMethod();
        assertEquals(MeasureType.FINDINGS, measure.getType());
        measure.getValue();
        assertEquals("Measure3", measure.getName());
        assertEquals(0.0, measure.getLowerResult(), 0.001);
        assertEquals(1.0, measure.getUpperResult(), 0.001);
        assertNotNull(measure.getGraph());
        assertNotNull(measure.getOwnedBy());
        assertNotNull(measure.getProcessor());

        Finding f1 = new FileFinding(File.builder().fileKey("file1").create(), "key", "name");
        Finding f2 = new FileFinding(File.findFirst("fileKey = ?", "file1"), "key", "name2");

        finding.addFinding(f1);
        finding.addFinding(f2);

        assertEquals(2, finding.getFindings().size());

        assertEquals(1, graph.edgesConnecting(node, fixture).size());
        for (Edge e : graph.edgesConnecting(node, fixture)) {
            assertTrue(e instanceof FindingToMeasureEdge);
            FindingToMeasureEdge ftm = (FindingToMeasureEdge) e;
            assertNull(ftm.getNorm());
            assertEquals(2, ftm.getFindings().size());
            assertEquals(0.0, e.getValue(), 0.001);
        }
    }

    @Test
    public void testToolMeas() {
        Node node = findNodeByName("Test4");
        Node fixture = findNodeByName("ToolMeas");

        assertNotNull(fixture);
        assertTrue(fixture instanceof MeasureNode);

        MeasureNode measure = (MeasureNode) fixture;
        FindingNode finding = (FindingNode) node;

        measure.getMethod();
        assertEquals(MeasureType.FINDINGS, measure.getType());
        measure.getValue();
        assertEquals("ToolMeas", measure.getName());
        assertEquals(0.0, measure.getLowerResult(), 0.001);
        assertEquals(1.0, measure.getUpperResult(), 0.001);
        assertNotNull(measure.getGraph());
        assertNotNull(measure.getOwnedBy());
        assertNotNull(measure.getProcessor());

        Finding f1 = new FileFinding(File.builder().fileKey("file1").create(), "key", "name");
        Finding f2 = new FileFinding(File.findFirst("fileKey = ?", "file1"), "key", "name2");

        finding.addFinding(f1);
        finding.addFinding(f2);

        assertEquals(2, finding.getFindings().size());

        assertEquals(1, graph.edgesConnecting(node, fixture).size());
        for (Edge e : graph.edgesConnecting(node, fixture)) {
            assertTrue(e instanceof FindingToMeasureEdge);
            FindingToMeasureEdge ftm = (FindingToMeasureEdge) e;
            assertNull(ftm.getNorm());
            assertEquals(2, ftm.getFindings().size());
            assertEquals(0.0, e.getValue(), 0.001);
        }
    }

    public void testTextMeas() {

    }

    public void testManualMeas() {

    }

    public void testQIESLMeas() {

    }

    public void testUnionMeas() {

    }

    @Test
    public void testTest2() {
        Node node = findNodeByName("Test2");

        assertNotNull(node);
        assertTrue(node instanceof FindingNode);

        FindingNode fn = (FindingNode) node;
        assertEquals("Test2", fn.getRuleName());
        assertEquals("TestHierTool", fn.getToolName());
        assertEquals(0.0, fn.getLowerResult(), 0.001);
        assertEquals(1.0, fn.getUpperResult(), 0.001);
        assertNotNull(fn.getGraph());
        assertNotNull(fn.getOwnedBy());
        //assertNotNull(fn.getProcessor());

        Finding f1 = new FileFinding(File.builder().fileKey("file1").create(), "key", "name");
        Finding f2 = new FileFinding(File.findFirst("fileKey = ?", "file1"), "key", "name2");

        fn.addFinding(f1);
        fn.addFinding(f2);

        assertEquals(2, fn.getFindings().size());
    }

    @Test
    public void testTest1() {
        Node node = findNodeByName("Test1");

        assertNotNull(node);
        assertTrue(node instanceof FindingNode);

        FindingNode fn = (FindingNode) node;
        assertEquals("Test1", fn.getRuleName());
        assertEquals("TestHierTool", fn.getToolName());
        assertEquals(0.0, fn.getLowerResult(), 0.001);
        assertEquals(1.0, fn.getUpperResult(), 0.001);
        assertNotNull(fn.getGraph());
        assertNotNull(fn.getOwnedBy());
        //assertNotNull(fn.getProcessor());

        Finding f1 = new FileFinding(File.builder().fileKey("file1").create(), "key", "name");
        Finding f2 = new FileFinding(File.findFirst("fileKey = ?", "file1"), "key", "name2");

        fn.addFinding(f1);
        fn.addFinding(f2);

        assertEquals(2, fn.getFindings().size());
    }

    @Test
    public void testTest3() {
        Node node = findNodeByName("Test3");

        assertNotNull(node);
        assertTrue(node instanceof FindingNode);

        FindingNode fn = (FindingNode) node;
        assertEquals("Test3", fn.getRuleName());
        assertEquals("TestHierTool", fn.getToolName());
        assertEquals(0.0, fn.getLowerResult(), 0.001);
        assertEquals(1.0, fn.getUpperResult(), 0.001);
        assertNotNull(fn.getGraph());
        assertNotNull(fn.getOwnedBy());
        //assertNotNull(fn.getProcessor());

        Finding f1 = new FileFinding(File.builder().fileKey("file1").create(), "key", "name");
        Finding f2 = new FileFinding(File.findFirst("fileKey = ?", "file1"), "key", "name2");

        fn.addFinding(f1);
        fn.addFinding(f2);

        assertEquals(2, fn.getFindings().size());
    }

    @Test
    public void testTest4() {
        Node node = findNodeByName("Test4");

        assertNotNull(node);
        assertTrue(node instanceof FindingNode);

        FindingNode fn = (FindingNode) node;
        assertEquals("Test4", fn.getRuleName());
        assertEquals("TestHierTool", fn.getToolName());
        assertEquals(0.0, fn.getLowerResult(), 0.001);
        assertEquals(1.0, fn.getUpperResult(), 0.001);
        assertNotNull(fn.getGraph());
        assertNotNull(fn.getOwnedBy());
        //assertNotNull(fn.getProcessor());

        Finding f1 = new FileFinding(File.builder().fileKey("file1").create(), "key", "name");
        Finding f2 = new FileFinding(File.findFirst("fileKey = ?", "file1"), "key", "name2");

        fn.addFinding(f1);
        fn.addFinding(f2);

        assertEquals(2, fn.getFindings().size());
    }

    public void testTestHierManual() {

    }

    public void TestHierUnionAggr() {

    }

    private Node findNodeByName(String name) {
        for (Node n : graph.nodes()) {
            if (n.getName().equals(name))
                return n;
        }

        return null;
    }


}
