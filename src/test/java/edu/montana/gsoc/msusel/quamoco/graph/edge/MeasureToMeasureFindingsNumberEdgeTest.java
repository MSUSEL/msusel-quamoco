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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import java.math.BigDecimal;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.node.FileNode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.LinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * The class <code>MeasureToMeasureFindingsNumberEdgeTest</code> contains tests
 * for the class <code>{@link MeasureToMeasureFindingsNumberEdge}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class MeasureToMeasureFindingsNumberEdgeTest {

    private MeasureToMeasureFindingsNumberEdge fixture;

    /**
     * Run the MeasureToMeasureFindingsNumberEdge(String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testMeasureToMeasureFindingsNumberEdge_1() throws Exception
    {
        final String name = "";

        final MeasureToMeasureFindingsNumberEdge result = new MeasureToMeasureFindingsNumberEdge(name, null, null);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(null, result.getDist());
        Assert.assertEquals(new BigDecimal(100), result.getMaxPoints());
        Assert.assertEquals(false, result.isUsesLinearDist());
        Assert.assertEquals(null, result.getNormalizer());
        Assert.assertEquals(BigDecimal.ONE, result.getWeight());
        Assert.assertEquals(BigDecimal.ONE, result.getUpperBound());
        Assert.assertEquals(BigDecimal.ZERO, result.getLowerBound());
        Assert.assertEquals("", result.getName());
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_1() throws Exception
    {
        fixture.usesLinearDist = false;
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_2() throws Exception
    {
        fixture.usesLinearDist = true;
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
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
        final MeasureNode dest = new MeasureNode(graph, "name", "owner");
        dest.setType(MeasureType.NUMBER);
        final MeasureNode src = new MeasureNode(graph, "name", "owner");
        src.setType(MeasureType.FINDINGS);
        final FindingNode srcsrc = new FindingNode(graph, "key", "owner", "rule", "tool");
        final FindingToMeasureEdge f2m = new FindingToMeasureEdge("preedge", srcsrc, src);
        srcsrc.addFinding(new Finding(FileNode.builder("path").create(), "issue", "issue"));
        fixture = new MeasureToMeasureFindingsNumberEdge("edge", src, dest);
        fixture.dist = EasyMock.createNiceMock(LinearDistribution.class);
        src.setProcessor(new FindingsUnionAggregator(src));

        graph.addEdge(fixture, src, dest);
        graph.addEdge(f2m, srcsrc, src);

        fixture.maxPoints = new BigDecimal(100.0);
        fixture.usesLinearDist = false;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.weight = BigDecimal.ONE;
        fixture.setNormalizer(new NullNormalizer(fixture, "LOC", NormalizationRange.CLASS));
        fixture.upperBound = BigDecimal.ONE;
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
        new org.junit.runner.JUnitCore().run(MeasureToMeasureFindingsNumberEdgeTest.class);
    }
}