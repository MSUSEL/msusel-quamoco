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
package edu.montana.gsoc.msusel.quamoco.processor.lineardist;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>PositiveLinearDistributionTest</code> contains tests for the
 * class <code>{@link PositiveLinearDistribution}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class PositiveLinearDistributionTest {
    /**
     * Run the PositiveLinearDistribution(String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testPositiveLinearDistribution_1() throws Exception
    {
        final PositiveLinearDistribution result = new PositiveLinearDistribution();

        // add additional test code here
        Assert.assertNotNull(result);
    }

    /**
     * Run the double calculate(double,double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testCalculate_1() throws Exception
    {
        final PositiveLinearDistribution fixture = new PositiveLinearDistribution();
        final BigDecimal maxPoints = new BigDecimal(100.0);
        final BigDecimal proportion = new BigDecimal(0.5);

        BigDecimal result = fixture.calculate(maxPoints, proportion);

        // add additional test code here
        Assert.assertEquals(50.0, result.doubleValue(), 0.001);

        result = fixture.calculate(maxPoints, new BigDecimal(0.75));
        Assert.assertEquals(75.0, result.doubleValue(), 0.001);

        result = fixture.calculate(maxPoints, new BigDecimal(0.25));
        Assert.assertEquals(25.0, result.doubleValue(), 0.001);

        result = fixture.calculate(maxPoints, new BigDecimal(0));
        Assert.assertEquals(0.0, result.doubleValue(), 0.001);

        result = fixture.calculate(maxPoints, new BigDecimal(1.0));
        Assert.assertEquals(100.0, result.doubleValue(), 0.001);

        result = fixture.calculate(maxPoints, new BigDecimal(1.5));
        Assert.assertEquals(100.0, result.doubleValue(), 0.001);

        result = fixture.calculate(maxPoints, new BigDecimal(-1.5));
        Assert.assertEquals(0.0, result.doubleValue(), 0.001);
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
        new org.junit.runner.JUnitCore().run(PositiveLinearDistributionTest.class);
    }
}