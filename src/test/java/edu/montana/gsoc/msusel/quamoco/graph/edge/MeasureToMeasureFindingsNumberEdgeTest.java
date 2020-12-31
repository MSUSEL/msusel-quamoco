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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.isu.isuese.datamodel.File;
import edu.montana.gsoc.msusel.quamoco.graph.node.FileFinding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.NegativeLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static edu.montana.gsoc.msusel.quamoco.model.MeasureType.FINDINGS;
import static edu.montana.gsoc.msusel.quamoco.model.MeasureType.NUMBER;

/**
 * The class <code>MeasureToMeasureFindingsNumberEdgeTest</code> contains tests
 * for the class <code>{@link MeasureToMeasureFindingsNumberEdge}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MeasureToMeasureFindingsNumberEdgeTest extends DBSpec {

    private MeasureToMeasureFindingsNumberEdge fixture;

    /**
     * Run the MeasureToMeasureFindingsNumberEdge(String) constructor test.
     */
    @Test
    public void testMeasureToMeasureFindingsNumberEdge_1() {
        final String name = "";

        final MeasureToMeasureFindingsNumberEdge result = new MeasureToMeasureFindingsNumberEdge(name, null, null);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertNull(result.getDist());
        Assert.assertEquals(100.0, result.getMaxPoints(), 0.001);
        Assert.assertFalse(result.isUsesLinearDist());
        Assert.assertNull(result.getNormalizer());
        Assert.assertEquals(1.0, result.getWeight(), 0.001);
        Assert.assertEquals(1.0, result.getUpperBound(), 0.001);
        Assert.assertEquals(0.0, result.getLowerBound(), 0.001);
        Assert.assertEquals("", result.getName());
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_1() {
        fixture.usesLinearDist = false;
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_2() {
        fixture.usesLinearDist = true;
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(100.0, result, 0.001);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
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
        dest.setType(NUMBER);
        final MeasureNode src = new MeasureNode(graph, "src", "owner");
        src.setType(FINDINGS);
        final FindingNode srcsrc = new FindingNode(graph, "key", "owner", "rule", "tool");
        final FindingToMeasureEdge f2m = new FindingToMeasureEdge("preedge", srcsrc, src);
        srcsrc.addFinding(new FileFinding(File.builder().fileKey("path").create(), "issue", "issue"));
        fixture = new MeasureToMeasureFindingsNumberEdge("edge", src, dest);
        fixture.dist = new NegativeLinearDistribution();
        src.setProcessor(new FindingsUnionAggregator(src));

        graph.addEdge(src, dest, fixture);
        graph.addEdge(srcsrc, src, f2m);

        fixture.maxPoints = 100.0;
        fixture.setRank(1);
        fixture.usesLinearDist = false;
        fixture.lowerBound = 0.0;
        fixture.setWeight(1.0);
        fixture.setNormalizer(new NullNormalizer(fixture, "LOC", NormalizationRange.CLASS));
        fixture.upperBound = 1.0;
    }
}