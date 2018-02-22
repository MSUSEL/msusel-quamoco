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

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.NegativeLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

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
        Assert.assertEquals(BigDecimal.ZERO, result);
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
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode dest = new MeasureNode(graph, "dest", "owner");
        dest.setType(MeasureType.NUMBER);
        final MeasureNode src = new MeasureNode(graph, "src", "owner");
        src.setType(MeasureType.FINDINGS);
        final FindingNode srcsrc = new FindingNode(graph, "key", "owner", "rule", "tool");
        final FindingToMeasureEdge f2m = new FindingToMeasureEdge("preedge", srcsrc, src);
        srcsrc.addFinding(new Finding(FileNode.builder().key("path").create(), "issue", "issue"));
        fixture = new MeasureToMeasureFindingsNumberEdge("edge", src, dest);
        fixture.dist = new NegativeLinearDistribution();
        src.setProcessor(new FindingsUnionAggregator(src));

        graph.addEdge(src, dest, fixture);
        graph.addEdge(srcsrc, src, f2m);

        fixture.maxPoints = new BigDecimal(100.0);
        fixture.setRank(BigDecimal.ONE);
        fixture.usesLinearDist = false;
        fixture.lowerBound = BigDecimal.ZERO;
        fixture.setWeight(BigDecimal.ONE);
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
}