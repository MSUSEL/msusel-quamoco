/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.LinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.NegativeLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.lineardist.PositiveLinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * The class <code>WeightedRankedEdgeTest</code> contains tests for the class
 * <code>{@link WeightedRankedEdge}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: BigDecimal.ONE $
 */
public class WeightedRankedEdgeTest {

    private WeightedRankedEdge fixture;

    /**
     * Run the LinearDistribution getDist() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetDist_1() throws Exception
    {
        final LinearDistribution result = fixture.getDist();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertTrue(result instanceof PositiveLinearDistribution);
    }

    /**
     * Run the BigDecimal getLowerBound() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetLowerBound_1() throws Exception
    {
        final BigDecimal result = fixture.getLowerBound();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Run the BigDecimal getMaxPoints() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetMaxPoints_1() throws Exception
    {
        final BigDecimal result = fixture.getMaxPoints();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the Normalizer getNormalizer() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetNormalizer_1() throws Exception
    {
        final Normalizer result = fixture.getNormalizer();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("LOC", result.getMetric());
    }

    /**
     * Run the BigDecimal getUpperBound() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetUpperBound_1() throws Exception
    {
        final BigDecimal result = fixture.getUpperBound();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the BigDecimal getWeight() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetWeight_1() throws Exception
    {
        final BigDecimal result = fixture.getWeight();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the boolean isUsesLinearDist() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testIsUsesLinearDist_1() throws Exception
    {
        final boolean result = fixture.isUsesLinearDist();

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean isUsesLinearDist() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testIsUsesLinearDist_2() throws Exception
    {
        fixture.setUsesLinearDist(false);
        final boolean result = fixture.isUsesLinearDist();

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the void setDist(LinearDistribution) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetDist_1() throws Exception
    {
        final LinearDistribution lindist = new NegativeLinearDistribution();

        fixture.setDist(lindist);

        Assert.assertSame(lindist, fixture.getDist());
    }

    /**
     * Run the void setLowerBound(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetLowerBound_1() throws Exception
    {
        final BigDecimal lowerBound = new BigDecimal(0.5);

        try
        {
            fixture.setLowerBound(lowerBound);
            Assert.assertEquals(new BigDecimal(0.5), fixture.getLowerBound());
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail();
        }

    }

    /**
     * Run the void setLowerBound(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetLowerBound_2() throws Exception
    {
        fixture.setUpperBound(BigDecimal.ZERO);
        final BigDecimal lowerBound = new BigDecimal(0.5);

        fixture.setLowerBound(lowerBound);
    }

    /**
     * Run the void setMaxPoints(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetMaxPoints_1() throws Exception
    {
        final BigDecimal maxPoints = new BigDecimal(100.0);

        fixture.setMaxPoints(maxPoints);
        Assert.assertEquals(maxPoints, fixture.getMaxPoints());
    }

    /**
     * Run the void setMaxPoints(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetMaxPoints_2() throws Exception
    {
        final BigDecimal maxPoints = BigDecimal.ZERO;

        fixture.setMaxPoints(maxPoints);
        Assert.assertEquals(maxPoints, fixture.getMaxPoints());
    }

    /**
     * Run the void setMaxPoints(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetMaxPoints_3() throws Exception
    {
        final BigDecimal maxPoints = new BigDecimal(-1.0);

        fixture.setMaxPoints(maxPoints);
    }

    /**
     * Run the void setNormalizer(Normalizer) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetNormalizer_1() throws Exception
    {
        final Normalizer normalizer = new NullNormalizer(fixture, "NOC", NormalizationRange.CLASS);

        fixture.setNormalizer(normalizer);

        // add additional test code here
        Assert.assertNotNull(fixture.getNormalizer());
        Assert.assertEquals("NOC", fixture.getNormalizer().getMetric());
        Assert.assertEquals(NormalizationRange.CLASS, fixture.getNormalizer().getRange());
    }

    /**
     * Run the void setUpperBound(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetUpperBound_1() throws Exception
    {
        final BigDecimal upperBound = new BigDecimal(0.5);

        try
        {
            fixture.setUpperBound(upperBound);
            Assert.assertEquals(upperBound, fixture.getUpperBound());
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail();
        }
    }

    /**
     * Run the void setUpperBound(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetUpperBound_2() throws Exception
    {
        fixture.setLowerBound(BigDecimal.ONE);
        final BigDecimal upperBound = new BigDecimal(0.5);

        try
        {
            fixture.setUpperBound(upperBound);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
            Assert.assertEquals(BigDecimal.ONE, fixture.getUpperBound());
        }
    }

    /**
     * Run the void setUsesLinearDist(boolean) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetUsesLinearDist_1() throws Exception
    {
        final boolean usesLinearDist = true;

        fixture.setUsesLinearDist(usesLinearDist);

        Assert.assertTrue(fixture.usesLinearDist);
    }

    /**
     * Run the void setWeight(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetWeight_1() throws Exception
    {
        final BigDecimal weight = BigDecimal.ONE;

        try
        {
            fixture.setWeight(weight);
            Assert.assertEquals(weight, fixture.getWeight());
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail();
        }
    }

    /**
     * Run the void setWeight(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetWeight_2() throws Exception
    {
        final BigDecimal weight = new BigDecimal(-1.0);

        fixture.setWeight(weight);
    }

    /**
     * Run the void setWeight(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetWeight_3() throws Exception
    {
        final BigDecimal weight = BigDecimal.ZERO;

        fixture.setWeight(weight);
        Assert.assertEquals(weight, fixture.getWeight());
    }

    /**
     * Run the void setWeight(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetWeight_4() throws Exception
    {
        final BigDecimal weight = new BigDecimal(2.0);

        fixture.setWeight(weight);
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

        final FactorNode src = new FactorNode(graph, "src", "factor");
        final FactorNode dest = new FactorNode(graph, "src", "factor");
        fixture = new MeasureToMeasureFindingsNumberEdge("edge", src, dest);

        fixture.upperBound = BigDecimal.ONE;
        fixture.norm = new NullNormalizer(fixture, "LOC", NormalizationRange.CLASS);
        fixture.dist = new PositiveLinearDistribution();
        fixture.usesLinearDist = true;
        fixture.weight = BigDecimal.ONE;
        fixture.maxPoints = BigDecimal.ONE;
        fixture.lowerBound = BigDecimal.ZERO;
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
        new org.junit.runner.JUnitCore().run(WeightedRankedEdgeTest.class);
    }
}