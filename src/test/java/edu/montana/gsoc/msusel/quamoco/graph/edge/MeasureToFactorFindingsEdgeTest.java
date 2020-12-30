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
import edu.montana.gsoc.msusel.quamoco.graph.node.*;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.evaluators.MeanEvaluator;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * The class <code>MeasureToFactorFindingsEdgeTest</code> contains tests for the
 * class <code>{@link MeasureToFactorFindingsEdge}</code>.
 *
 * @author Isaac Griffith
 * @version $Revision: 1.0 $
 */
public class MeasureToFactorFindingsEdgeTest extends DBSpec {

    private MeasureToFactorFindingsEdge fixture;

    /**
     * Run the MeasureToFactorFindingsEdge(String,InfluenceEffect) constructor
     * test.
     */
    @Test
    public void testMeasureToFactorFindingsEdge_1() {
        final String name = "";
        final InfluenceEffect effect = InfluenceEffect.NEGATIVE;

        final MeasureToFactorFindingsEdge result = new MeasureToFactorFindingsEdge(name, null, null, effect);

        // add additional test code here
        assertNotNull(result);
        Assert.assertEquals("NEGATIVE", result.getInf());
        Assert.assertEquals(1.0, result.getValue(), 0.001);
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
     * Run the MeasureToFactorFindingsEdge(String,InfluenceEffect) constructor
     * test.
     */
    @Test
    public void testMeasureToFactorFindingsEdge_2() {
        final String name = "";
        final InfluenceEffect effect = null;

        final MeasureToFactorFindingsEdge result = new MeasureToFactorFindingsEdge(name, null, null, effect);

        // add additional test code here
        assertNotNull(result);
        Assert.assertEquals("POSITIVE", result.getInf());
        Assert.assertEquals(0.0, result.getValue(), 0.001);
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
     * Run the String getInf() method test.
     */
    @Test
    public void testGetInf_1() {
        final String result = fixture.getInf();

        // add additional test code here
        Assert.assertEquals(InfluenceType.NEG, result);
    }

    /**
     * Run the double getValue() method test.
     */
    @Test
    public void testGetValue_1() {
        fixture.setUsesLinearDist(false);
        fixture.setInf(InfluenceType.POS);
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the double getValue() method test.
     */
    @Test
    public void testGetValue_2() {
        fixture.setUsesLinearDist(false);
        fixture.setInf(InfluenceType.NEG);
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(1.0, result, 0.001);
    }

    /**
     * Run the double getValue() method test.
     */
    @Test
    public void testGetValue_3() {
        fixture.setUsesLinearDist(true);
        fixture.setInf(InfluenceType.POS);
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the double getValue() method test.
     */
    @Test
    public void testGetValue_4() {
        fixture.setUsesLinearDist(true);
        fixture.setInf(InfluenceType.NEG);
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(1.0, result, 0.001);
    }

    /**
     * Run the double getValue() method test.
     */
    @Test
    public void testGetValue_5() {
        fixture.setUsesLinearDist(false);
        fixture.setInf(InfluenceType.NEG);
        fixture.setWeight(0.5);
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(0.5, result, 0.001);
    }

    /**
     * Run the double getValue() method test.
     */
    @Test
    public void testGetValue_6() {
        fixture.setUsesLinearDist(true);
        fixture.setInf(InfluenceType.NEG);
        fixture.setWeight(0.5);
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(0.5, result, 0.001);
    }

    @Test
    public void testGetValue_7() {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode src = new MeasureNode("measure", "owner");
        src.setGraph(graph);
        src.setType(MeasureType.FINDINGS);
        src.setProcessor(new FindingsUnionAggregator(src));
        final FactorNode dest = new FactorNode("factor", "owner");
        dest.setGraph(graph);
        final FindingNode srcsrc = new FindingNode("key", "owner", "finding", "tool");

        fixture = new MeasureToFactorFindingsEdge("", src, dest, InfluenceEffect.NEGATIVE);
        graph.addEdge(srcsrc, src, new FindingToMeasureEdge("f2m", srcsrc, src));
        graph.addEdge(src, dest, fixture);

        fixture.weight = 1.0;
        fixture.lowerBound = 0.0;
        fixture.upperBound = 1.0;
        fixture.usesLinearDist = true;
        fixture.maxPoints = 100.0;
        fixture.dist = new PositiveLinearDistribution();
        fixture.norm = new NullNormalizer(fixture, "norm", NormalizationRange.CLASS);
        dest.setProcessor(new MeanEvaluator(dest));

        Assert.assertEquals(0.0, dest.getValue(), 0.001);
    }

    /**
     * Run the void setInf(String) method test.
     */
    @Test
    public void testSetInf_1() {
        final InfluenceEffect inf = InfluenceEffect.POSITIVE;
        fixture.setInf(inf.toString());

        // add additional test code here
        Assert.assertEquals(InfluenceType.POS, fixture.getInf());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     */
    @Before
    public void setUp() throws Exception {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode src = new MeasureNode(graph, "measure", "owner");
        src.setType(MeasureType.FINDINGS);
        src.setProcessor(new FindingsUnionAggregator(src));
        final FactorNode dest = new FactorNode(graph, "factor", "owner");
        final FindingNode srcsrc = new FindingNode(graph, "key", "owner", "finding", "tool");
        srcsrc.addFinding(new FileFinding(File.builder().fileKey("path").create(), "finding", "finding"));

        fixture = new MeasureToFactorFindingsEdge("", src, dest, InfluenceEffect.NEGATIVE);
        graph.addEdge(srcsrc, src, new FindingToMeasureEdge("f2m", srcsrc, src));
        graph.addEdge(src, dest, fixture);

        fixture.weight = 1.0;
        fixture.setRank(1);
        fixture.lowerBound = 0.0;
        fixture.upperBound = 1.0;
        fixture.usesLinearDist = true;
        fixture.maxPoints = 100.0;
        fixture.dist = new PositiveLinearDistribution();
        fixture.norm = new NullNormalizer(fixture, "norm", NormalizationRange.CLASS);
    }
}