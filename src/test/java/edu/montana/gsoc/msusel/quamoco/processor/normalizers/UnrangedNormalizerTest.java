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
package edu.montana.gsoc.msusel.quamoco.processor.normalizers;

import com.google.common.collect.Lists;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.isu.isuese.datamodel.Class;
import edu.isu.isuese.datamodel.System;
import edu.isu.isuese.datamodel.*;
import edu.montana.gsoc.msusel.quamoco.distiller.QuamocoContext;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.ValueToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.*;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMeanAggregator;
import org.easymock.EasyMock;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * The class <code>UnrangedNormalizerTest</code> contains tests for the class
 * <code>{@link UnrangedNormalizer}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class UnrangedNormalizerTest extends DBSpec {

    private UnrangedNormalizer fixture;
    private List<Finding> findings;
    private File file;
    private File file2;

    /**
     * Run the UnrangedNormalizer(Edge,String,NormalizationRange) constructor
     * test.
     */
    @Test
    public void testUnrangedNormalizer_1() {
        final Edge owner = EasyMock.createMock(Edge.class);
        final String normMetric = "repo:LOC";
        // add mock object expectations here

        EasyMock.replay(owner);

        final UnrangedNormalizer result = new UnrangedNormalizer(owner, normMetric);

        // add additional test code here
        EasyMock.verify(owner);
        Assert.assertNotNull(result);
        Assert.assertEquals("repo:LOC", result.getMetric());
        Assert.assertEquals(NormalizationRange.NA, result.getRange());
    }

    @Test
    public void testNormalize_Set_Finding_1() {
        findings = Lists.newArrayList();
        Finding f1 = new FileFinding(file, "issue", "issue");
        Finding f2 = new FileFinding(file2, "issue", "issue");
        findings.add(f1);
        findings.add(f2);

        double result = fixture.normalize(findings);
        double exp = 0.4;
        Assert.assertEquals(exp, result, 0.001);
    }

    @Test
    public void testNormalize_Set_Finding_2() {
        double result = fixture.normalize((List<Finding>) null);

        Assert.assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testNormalize_Set_Finding_3() {
        double result = fixture.normalize(Lists.newArrayList());

        Assert.assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testNormalize_Set_Finding_4() {
        findings = Lists.newArrayList();
        Finding f1 = new FileFinding(file, "issue", "issue");
        Finding f2 = new FileFinding(file2, "issue", "issue");
        findings.add(f1);
        findings.add(f2);

        double result = fixture.normalize(findings);
        double exp = 0.4;
        double res = result;
        Assert.assertEquals(exp, res, 0.001);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception if the initialization fails for some reason
     */
    @Before
    public void setUp() throws Exception {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();

        MetricRepository repo = MetricRepository.builder().key("repo").name("repo").create();
        repo.addMetric(Metric.builder().handle("LOC").key("repo:LOC").name("LOC").create());
        repo.addMetric(Metric.builder().handle("NOM").key("repo:NOM").name("NOM").create());
        repo.addMetric(Metric.builder().handle("NIV").key("repo:NIV").name("NIV").create());
        repo.addMetric(Metric.builder().handle("NOC").key("repo:NOC").name("NOC").create());
        QuamocoContext.instance().setMetricRepoKey("repo");

        final ValueNode vn = new ValueNode(graph, "LOC", "owner", "repo");
        vn.addValue(100.0);

        final MeasureNode src = new MeasureNode(graph, "src", "owner");
        src.setProcessor(new NumberMeanAggregator(src));

        final MeasureNode dest = new MeasureNode(graph, "dest", "owner");
        dest.setProcessor(new NumberMeanAggregator(dest));

        final Edge e = new MeasureToMeasureNumberEdge("edge", src, dest);
        fixture = new UnrangedNormalizer(e, "LOC");

        graph.addEdge(src, dest, e);
        graph.addEdge(vn, src, new ValueToMeasureEdge("v2m", vn, src));

        // setup metrics
        System sys = System.builder().name("System").key("system").create();
        Project proj = Project.builder().projKey("Test").create();
        QuamocoContext.instance().setProject(proj);

        file = File.builder().fileKey("path").create();
        proj.addFile(file);
        proj.addMeasure(Measure.of("repo:LOC").on(file).withValue(200.0));

        Type type = Class.builder().compKey("namespace.Type").start(1).end(100).create();
        file.addType(type);
        proj.addMeasure(Measure.of("repo:LOC").on(type).withValue(100.0));

        Method method = Method.builder().compKey("namespace.Type#method").start(20).end(100).create();
        type.addMember(method);
        proj.addMeasure(Measure.of("repo:LOC").on(method).withValue(80.0));

        file2 = File.builder().fileKey("path2").create();
        proj.addFile(file2);

        proj.addMeasure(Measure.of("repo:LOC").on(file2).withValue(200.0));
        proj.addMeasure(Measure.of("repo:LOC").on(proj).withValue(1000.0));
        proj.addMeasure(Measure.of("repo:NOM").on(proj).withValue(2.0));
        proj.addMeasure(Measure.of("repo:NIV").on(proj).withValue(10.0));
        proj.addMeasure(Measure.of("repo:NOC").on(proj).withValue(2.0));

        sys.addProject(proj);
    }
}