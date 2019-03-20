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

import com.google.common.collect.Sets;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.codetree.CodeTree;
import edu.montana.gsoc.msusel.codetree.DefaultCodeTree;
import edu.montana.gsoc.msusel.codetree.node.member.MethodNode;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.codetree.node.structural.ProjectNode;
import edu.montana.gsoc.msusel.codetree.node.type.ClassNode;
import edu.montana.gsoc.msusel.metrics.Measurement;
import edu.montana.gsoc.msusel.metrics.MeasuresTable;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.ValueToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.graph.node.ValueNode;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMeanAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.extents.Extent;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * The class <code>RangedNormalizerTest</code> contains tests for the class
 * <code>{@link RangedNormalizer}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class RangedNormalizerTest {

    private RangedNormalizer fixture;
    private Set<Finding> findings;
    private FileNode file;
    private FileNode file2;
    private FileNode file3;

    /**
     * Run the RangedNormalizer(Edge,String,NormalizationRange) constructor
     * test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testRangedNormalizer_1() throws Exception {
        final Edge owner = EasyMock.createMock(Edge.class);
        final String normMetric = "LOC";
        final NormalizationRange range = NormalizationRange.CLASS;
        // add mock object expectations here

        EasyMock.replay(owner);

        final RangedNormalizer result = new RangedNormalizer(owner, normMetric, range);

        // add additional test code here
        EasyMock.verify(owner);
        Assert.assertNotNull(result);
        Assert.assertEquals("LOC", result.getMetric());
    }

    @Test
    public void testNormalize_Set_Finding_1() throws Exception {
        findings = Sets.newHashSet();
        Finding f1 = new Finding(file, "issue", "issue");
        Finding f2 = new Finding(file2, "issue", "issue");
        findings.add(f1);
        findings.add(f2);

        double result = fixture.normalize(findings);
        double exp = 0.66667;
        double res = result;
        Assert.assertEquals(exp, res, 0.00001);
    }

    @Test
    public void testNormalize_Set_Finding_2() throws Exception {
        double result = fixture.normalize((Set<Finding>) null);

        Assert.assertEquals(0.0, result, 0.001);
    }

    @Test
    public void testNormalize_Set_Finding_3() throws Exception {
        double result = fixture.normalize(Sets.newHashSet());

        Assert.assertEquals(0.0, result, 0.001);
    }

    public void testNormalize_Set_Finding_4() throws Exception {
        findings = Sets.newHashSet();
        Finding f1 = new Finding(file, "issue", "issue");
        Finding f2 = new Finding(file2, "issue", "issue");
        findings.add(f1);
        findings.add(f2);

        double result = fixture.normalize(findings);
        Assert.assertEquals(1.0, result, 0.001);
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
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();

        final ValueNode vn = new ValueNode(graph, "LOC", "owner", "tool");
        vn.addValue(100.0);

        final MeasureNode src = new MeasureNode(graph, "src", "owner");
        src.setProcessor(new NumberMeanAggregator(src));

        final MeasureNode dest = new MeasureNode(graph, "dest", "owner");
        dest.setProcessor(new NumberMeanAggregator(dest));

        final Edge e = new MeasureToMeasureNumberEdge("edge", src, dest);
        fixture = new RangedNormalizer(e, "LOC", NormalizationRange.FILE);

        graph.addEdge(src, dest, e);
        graph.addEdge(vn, src, new ValueToMeasureEdge("v2m", vn, src));

        // setup metrics
        CodeTree tree = new DefaultCodeTree();
        file = null;
        file2 = null;
        ProjectNode proj = ProjectNode.builder().key("Test").create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(proj).withValue(1000.0));
        MeasuresTable.getInstance().store(Measurement.of("NOM").on(proj).withValue(2.0));
        MeasuresTable.getInstance().store(Measurement.of("NIV").on(proj).withValue(10.0));
        MeasuresTable.getInstance().store(Measurement.of("NOC").on(proj).withValue(2.0));

        file = FileNode.builder().key("path").create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(file).withValue(200.0));

        ClassNode type = ClassNode.builder().key("namespace.Type").start(1).end(100).create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(type).withValue(100.0));
        file.addChild(type);

        MethodNode method1 = MethodNode.builder().key("namespace.Type#method").start(20).end(100).create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(method1).withValue(80.0));
//        type.addChild(method1);

        file2 = FileNode.builder().key("path2").create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(file2).withValue(200.0));

        file3 = FileNode.builder().key("path3").create();
        MeasuresTable.getInstance().store(Measurement.of("LOC").on(file3).withValue(200.0));

        proj.addChild(file);
        proj.addChild(file2);
        proj.addChild(file3);

        tree.setProject(proj);

        findings = Sets.newHashSet();
        Finding f1 = new Finding(file, "issue", "issue");
        Finding f2 = new Finding(file2, "issue", "issue");
        findings.add(f1);
        findings.add(f2);

        MeasuresTable.getInstance().merge(tree);
        Extent.getInstance().clearExtents();
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
}