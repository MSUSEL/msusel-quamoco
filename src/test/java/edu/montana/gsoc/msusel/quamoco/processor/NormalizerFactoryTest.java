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
package edu.montana.gsoc.msusel.quamoco.processor;

import edu.montana.gsoc.msusel.quamoco.graph.edge.*;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.RangedNormalizer;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.UnrangedNormalizer;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.mock;

/**
 * The class <code>NormalizerFactoryTest</code> contains tests for the class
 * <code>{@link NormalizerFactory}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class NormalizerFactoryTest {

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCreateNormalizer_1() {
        final Edge edge = null;
        final String metric = "";
        final NormalizationRange range = NormalizationRange.CLASS;

        final Normalizer result = NormalizerFactory.getInstance().createNormalizer(edge, metric, range);

        // add additional test code here
        assertNull(result);
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     */
    @Test
    public void testCreateNormalizer_2() {
        final Edge edge = EasyMock.createMock(Edge.class);
        final String metric = null;
        final NormalizationRange range = NormalizationRange.CLASS;
        // add mock object expectations here

        EasyMock.replay(edge);

        final Normalizer result = NormalizerFactory.getInstance().createNormalizer(edge, metric, range);

        // add additional test code here
        EasyMock.verify(edge);
        Assert.assertNotNull(result);
        Assert.assertTrue(result instanceof NullNormalizer);
        assertNull(result.getMetric());
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     */
    @Test
    public void testCreateNormalizer_3() {
        final Edge edge = EasyMock.createMock(Edge.class);
        final String metric = "";
        final NormalizationRange range = null;
        // add mock object expectations here

        EasyMock.replay(edge);

        final Normalizer result = NormalizerFactory.getInstance().createNormalizer(edge, metric, range);
        assertEquals(NormalizationRange.NA, result.getRange());
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     */
    @Test
    public void testCreateNormalizer_4() {
        final Edge edge = EasyMock.createMock(Edge.class);
        final String metric = "";
        final NormalizationRange range = NormalizationRange.CLASS;
        // add mock object expectations here

        EasyMock.replay(edge);

        final Normalizer result = NormalizerFactory.getInstance().createNormalizer(edge, metric, range);

        // add additional test code here
        EasyMock.verify(edge);
        Assert.assertNotNull(result);
        Assert.assertTrue(result instanceof NullNormalizer);
        assertEquals("", result.getMetric());
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     */
    @Test
    public void testCreateNormalizer_5() {
        final Edge edge = mock(MeasureToFactorFindingsEdge.class);
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.CLASS;
        // add mock object expectations here

        final Normalizer result = NormalizerFactory.getInstance().createNormalizer(edge, metric, range);

        Assert.assertNotNull(result);
        Assert.assertTrue(result instanceof RangedNormalizer);
        assertEquals("LOC", result.getMetric());
    }

    /**
     * Run the Normalizer createNormalizer(Edge,String,NormalizationRange)
     * method test.
     */
    @Test
    public void testCreateNormalizer_6() {
        NormalizerFactory fixture = NormalizerFactory.getInstance();
        final Edge edge = mock(FindingToMeasureEdge.class);
        final String metric = "LOC";
        final NormalizationRange range = NormalizationRange.NA;

        final Normalizer result = fixture.createNormalizer(edge, metric, range);

        Assert.assertNotNull(result);
        Assert.assertTrue(result instanceof UnrangedNormalizer);
        assertEquals("LOC", result.getMetric());
    }

    /**
     * Run the NormalizerFactory getInstance() method test.
     */
    @Test
    public void testGetInstance_1() {
        final NormalizerFactory result = NormalizerFactory.getInstance();
        final NormalizerFactory result2 = NormalizerFactory.getInstance();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertNotNull(result2);
        Assert.assertSame(result, result2);
    }

//    @Test
//    public void isFindingsOrNormalizable() {
//    }

//    @Test
//    public void isBadRange() {
//    }

//    @Test
//    public void isBadMetric() {
//    }
}