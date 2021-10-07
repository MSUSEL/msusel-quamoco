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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.graph.node.ValueNode;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMeanAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * The class <code>MeasureToMeasureNumberEdgeTest</code> contains tests for the
 * class <code>{@link MeasureToMeasureNumberEdge}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MeasureToMeasureNumberEdgeTest {

    private MeasureToMeasureNumberEdge fixture;

    /**
     * Run the MeasureToMeasureNumberEdge(String) constructor test.
     */
    @Test
    public void testMeasureToMeasureNumberEdge_1() {
        final String name = "";

        final MeasureToMeasureNumberEdge result = new MeasureToMeasureNumberEdge(name, null, null);

        // add additional test code here
        assertNotNull(result);
        assertNull(result.getDist());
        assertEquals(100.0, result.getMaxPoints(), 0.001);
        assertFalse(result.isUsesLinearDist());
        assertNull(result.getNormalizer());
        assertEquals(1.0, result.getWeight(), 0.001);
        assertEquals(1.0, result.getUpperBound(), 0.001);
        assertEquals(0.0, result.getLowerBound(), 0.001);
        assertEquals("", result.getName());
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_1() {
        fixture.usesLinearDist = false;
        fixture.setWeight(0.5);
        final double result = fixture.getValue();

        // add additional test code here
        assertEquals(27.5, result, 0.001);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_2() {
        fixture.usesLinearDist = false;
        fixture.setWeight(0.5);
        fixture.setNormalizer(null);
        final double result = fixture.getValue();

        // add additional test code here
        assertEquals(27.5, result, 0.001);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_3() {
        fixture.usesLinearDist = true;
        fixture.setWeight(1.0);
        fixture.setMaxPoints(50.0);
        final double result = fixture.getValue();

        // add additional test code here
        assertEquals(50.0, result, 0.001);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_4() {
        fixture.usesLinearDist = true;
        fixture.setWeight(1.0);
        fixture.setNormalizer(null);
        final double result = fixture.getValue();

        // add additional test code here
        assertEquals(55.0, result, 0.001);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_5() {
        fixture.usesLinearDist = true;
        fixture.setWeight(1.0);
        final double result = fixture.getValue();

        // add additional test code here
        assertEquals(55.0, result, 0.001);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_6() {
        fixture.usesLinearDist = false;
        fixture.setWeight(1.0);
        fixture.setNormalizer(null);
        final double result = fixture.getValue();

        // add additional test code here
        assertEquals(55.0, result, 0.001);
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
        dest.setType(MeasureType.NUMBER);
        final MeasureNode src = new MeasureNode(graph, "src", "owner2");
        src.setType(MeasureType.NUMBER);
        final ValueNode srcsrc = new ValueNode(graph, "srcsrc", "owner", "tool");
        final ValueToMeasureEdge v2m = new ValueToMeasureEdge("preedge", srcsrc, src);
        srcsrc.addValue(10.0);
        srcsrc.addValue(100.0);
        fixture = new MeasureToMeasureNumberEdge("edge", src, dest);
        fixture.dist = new PositiveLinearDistribution();
        fixture.setRank(1);
        src.setProcessor(new NumberMeanAggregator(src));

        graph.addEdge(src, dest, fixture);
        graph.addEdge(srcsrc, src, v2m);

        fixture.maxPoints = 100.0;
        fixture.usesLinearDist = false;
        fixture.lowerBound = 0.0;
        fixture.weight = 1.0;
        fixture.setNormalizer(new NullNormalizer(fixture, "LOC", NormalizationRange.CLASS));
        fixture.upperBound = 1.0;

        src.getValue();
    }
}