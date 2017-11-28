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
package edu.montana.gsoc.msusel.quamoco.processor;

import edu.montana.gsoc.msusel.quamoco.graph.edge.FactorToFactorEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorNumberEdge;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.RangedNormalizer;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.UnrangedNormalizer;

import static org.mockito.Mockito.mock;

/**
 * The class <code>NormalizerFactoryTest</code> contains tests for the class
 * <code>{@link NormalizerFactory}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class NormalizerFactoryTest {

    private NormalizerFactory fixture;

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNormalizer_1() throws Exception
    {
        final Edge edge = null;
        final String metric = "";
        final NormalizationRange range = NormalizationRange.CLASS;

        final Normalizer result = fixture.createNormalizer(edge, metric, range);

        // add additional test code here
        Assert.assertEquals(null, result);
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testCreateNormalizer_2() throws Exception
    {
        final Edge edge = EasyMock.createMock(Edge.class);
        final String metric = null;
        final NormalizationRange range = NormalizationRange.CLASS;
        // add mock object expectations here

        EasyMock.replay(edge);

        final Normalizer result = fixture.createNormalizer(edge, metric, range);

        // add additional test code here
        EasyMock.verify(edge);
        Assert.assertNotNull(result);
        Assert.assertTrue(result instanceof NullNormalizer);
        Assert.assertEquals(null, result.getMetric());
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNormalizer_3() throws Exception
    {
        final Edge edge = EasyMock.createMock(Edge.class);
        final String metric = "";
        final NormalizationRange range = null;
        // add mock object expectations here

        EasyMock.replay(edge);

        final Normalizer result = fixture.createNormalizer(edge, metric, range);
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testCreateNormalizer_4() throws Exception
    {
        final Edge edge = EasyMock.createMock(Edge.class);
        final String metric = "";
        final NormalizationRange range = NormalizationRange.CLASS;
        // add mock object expectations here

        EasyMock.replay(edge);

        final Normalizer result = fixture.createNormalizer(edge, metric, range);

        // add additional test code here
        EasyMock.verify(edge);
        Assert.assertNotNull(result);
        Assert.assertTrue(result instanceof NullNormalizer);
        Assert.assertEquals("", result.getMetric());
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testCreateNormalizer_5() throws Exception
    {
        final Edge edge = mock(MeasureToFactorNumberEdge.class);
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.CLASS;
        // add mock object expectations here

        System.out.println(edge.getClass().getName());
        final Normalizer result = fixture.createNormalizer(edge, metric, range);

        Assert.assertNotNull(result);
        System.out.println(result.getClass().getName());
        System.out.println(metric);
        System.out.println(range);
        Assert.assertTrue(result instanceof RangedNormalizer);
        Assert.assertEquals("LOC", result.getMetric());
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testCreateNormalizer_6() throws Exception
    {
        fixture = NormalizerFactory.getInstance();
        final Edge edge = mock(FactorToFactorEdge.class);
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.NA;

        System.out.println(edge.getClass().getName());
        final Normalizer result = fixture.createNormalizer(edge, metric, range);

        Assert.assertNotNull(result);
        System.out.println(result.getClass().getName());
        System.out.println(metric);
        System.out.println(range);
        Assert.assertTrue(result instanceof UnrangedNormalizer);
        Assert.assertEquals("LOC", result.getMetric());
    }

    /**
     * Run the NormalizerFactory getInstance() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testGetInstance_1() throws Exception
    {
        final NormalizerFactory result = NormalizerFactory.getInstance();
        final NormalizerFactory result2 = NormalizerFactory.getInstance();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertNotNull(result2);
        Assert.assertSame(result, result2);
    }

    @Test
    public void isFIndingsOrNormalizable() throws Exception {
    }

    @Test
    public void isBadRange() throws Exception {
    }

    @Test
    public void isBadMetric() throws Exception {
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Before
    public void setUp() throws Exception
    {
        // add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 1/26/16 6:35 PM
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
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(NormalizerFactoryTest.class);
    }
}