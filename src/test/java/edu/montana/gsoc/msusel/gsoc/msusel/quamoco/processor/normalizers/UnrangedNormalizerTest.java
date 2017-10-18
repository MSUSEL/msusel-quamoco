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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.processor.normalizers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

import edu.montana.gsoc.msusel.gsoc.msusel.node.FileNode;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Sets;

import edu.montana.gsoc.msusel.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.gsoc.msusel.node.MethodNode;
import edu.montana.gsoc.msusel.gsoc.msusel.node.ProjectNode;
import edu.montana.gsoc.msusel.gsoc.msusel.node.TypeNode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.ValueToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.graph.node.ValueNode;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.MetricsContext;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMeanAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.UnrangedNormalizer;
import edu.uci.ics.jung.graph.DirectedSparseGraph;
import edu.uci.ics.jung.graph.util.EdgeType;

/**
 * The class <code>UnrangedNormalizerTest</code> contains tests for the class
 * <code>{@link UnrangedNormalizer}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:34 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class UnrangedNormalizerTest {

    private UnrangedNormalizer fixture;
    private Set<Finding>       findings;
    private FileNode file;
    private FileNode           file2;

    /**
     * Run the UnrangedNormalizer(Edge,String,NormalizationRange) constructor
     * test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:34 PM
     */
    @Test
    public void testUnrangedNormalizer_1() throws Exception
    {
        final Edge owner = EasyMock.createMock(Edge.class);
        final String normMetric = "LOC";
        final NormalizationRange range = NormalizationRange.CLASS;
        // add mock object expectations here

        EasyMock.replay(owner);

        final UnrangedNormalizer result = new UnrangedNormalizer(owner, normMetric, range);

        // add additional test code here
        EasyMock.verify(owner);
        Assert.assertNotNull(result);
        Assert.assertEquals("LOC", result.getMetric());
        Assert.assertEquals(NormalizationRange.CLASS, result.getNormalizationRange());
    }

    @Test
    public void testNormalize_Set_Finding_1() throws Exception
    {
        findings = Sets.newHashSet();
        Finding f1 = new Finding(file, "issue", "issue");
        Finding f2 = new Finding(file2, "issue", "issue");
        findings.add(f1);
        findings.add(f2);

        BigDecimal result = fixture.normalize(findings);
        Assert.assertEquals(new BigDecimal(0.4).setScale(1, RoundingMode.HALF_UP), result);
    }

    @Test
    public void testNormalize_Set_Finding_2() throws Exception
    {
        BigDecimal result = fixture.normalize((Set<Finding>) null);

        Assert.assertEquals(BigDecimal.ONE, result);
    }

    @Test
    public void testNormalize_Set_Finding_3() throws Exception
    {
        BigDecimal result = fixture.normalize(Sets.newHashSet());

        Assert.assertEquals(BigDecimal.ONE, result);
    }

    @Test
    public void testNormalize_Set_Finding_4() throws Exception
    {
        findings = Sets.newHashSet();
        Finding f1 = new Finding(file, "issue", "issue");
        Finding f2 = new Finding(file2, "issue", "issue");
        findings.add(f1);
        findings.add(f2);

        BigDecimal result = fixture.normalize(findings);
        Assert.assertEquals(new BigDecimal(0.4).setScale(1, RoundingMode.HALF_UP), result);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 1/26/16 6:34 PM
     */
    @Before
    public void setUp() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();

        final ValueNode vn = new ValueNode(graph, "LOC", "owner", "tool");
        vn.addValue(new BigDecimal(100.0));

        final MeasureNode src = new MeasureNode(graph, "src", "owner");
        src.setProcessor(new NumberMeanAggregator(src));

        final MeasureNode dest = new MeasureNode(graph, "dest", "owner");
        dest.setProcessor(new NumberMeanAggregator(dest));

        final Edge e = new MeasureToMeasureNumberEdge("edge", src, dest);
        fixture = new UnrangedNormalizer(e, "LOC", NormalizationRange.NA);

        graph.addEdge(e, src, dest, EdgeType.DIRECTED);
        graph.addEdge(new ValueToMeasureEdge("v2m", vn, src), vn, src, EdgeType.DIRECTED);

        // setup metrics
        final MetricsContext context = MetricsContext.getCleanInstance();

        CodeTree tree = new CodeTree();
        ProjectNode proj = ProjectNode.builder("Test")
                .file(
                        FileNode.builder("path")
                                .type(
                                        TypeNode.builder("Type", "namespace.Type")
                                                .range(1, 100)
                                                .metric("LOC", 100.0)
                                                .method(
                                                        MethodNode.builder("method", "namespace.Type#method")
                                                                .range(20, 100)
                                                                .metric("LOC", 80.0)
                                                                .create())
                                                .create())
                                .metric("LOC", 200.0)
                                .create())
                .file(FileNode.builder("path2").metric("LOC", 200.0).create())
                .metric("LOC", 1000.0)
                .metric("NOM", 2.0)
                .metric("NIV", 10.0)
                .metric("NOC", 2.0)
                .create();

        tree.setProject(proj);

        context.merge(tree);
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 1/26/16 6:34 PM
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
     * @generatedBy CodePro at 1/26/16 6:34 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(UnrangedNormalizerTest.class);
    }
}