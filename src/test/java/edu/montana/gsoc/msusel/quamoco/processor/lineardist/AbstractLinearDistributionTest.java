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
 * The class <code>AbstractLinearDistributionTest</code> contains tests for the
 * class <code>{@link AbstractLinearDistribution}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class AbstractLinearDistributionTest {

    private AbstractLinearDistribution fixture;

    /**
     * Run the BigDecimal
     * calculate(BigDecimal,BigDecimal,BigDecimal,BigDecimal,BigDecimal) method
     * test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testCalculate_1() throws Exception
    {
        final BigDecimal proportion = new BigDecimal(0.5);
        final BigDecimal lowerBound = BigDecimal.ZERO;
        final BigDecimal lowerResult = BigDecimal.ZERO;
        final BigDecimal upperBound = BigDecimal.ONE;
        final BigDecimal upperResult = new BigDecimal(100.0);

        final BigDecimal result = fixture.calculate(proportion, lowerBound, lowerResult, upperBound, upperResult);

        // add additional test code here
        Assert.assertEquals(50.0, result.doubleValue(), 0.001);
    }

    /**
     * Run the BigDecimal
     * calculate(BigDecimal,BigDecimal,BigDecimal,BigDecimal,BigDecimal) method
     * test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testCalculate_2() throws Exception
    {
        final BigDecimal proportion = new BigDecimal(1.5);
        final BigDecimal lowerBound = BigDecimal.ZERO;
        final BigDecimal lowerResult = BigDecimal.ZERO;
        final BigDecimal upperBound = BigDecimal.ONE;
        final BigDecimal upperResult = new BigDecimal(100.0);

        final BigDecimal result = fixture.calculate(proportion, lowerBound, lowerResult, upperBound, upperResult);

        // add additional test code here
        Assert.assertEquals(new BigDecimal(100.0), result);
    }

    /**
     * Run the BigDecimal
     * calculate(BigDecimal,BigDecimal,BigDecimal,BigDecimal,BigDecimal) method
     * test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testCalculate_3() throws Exception
    {
        final BigDecimal proportion = new BigDecimal(-0.5);
        final BigDecimal lowerBound = BigDecimal.ZERO;
        final BigDecimal lowerResult = BigDecimal.ZERO;
        final BigDecimal upperBound = BigDecimal.ONE;
        final BigDecimal upperResult = new BigDecimal(100.0);

        final BigDecimal result = fixture.calculate(proportion, lowerBound, lowerResult, upperBound, upperResult);

        // add additional test code here
        Assert.assertEquals(BigDecimal.ZERO, result);
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
        fixture = new NegativeLinearDistribution();
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
        new org.junit.runner.JUnitCore().run(AbstractLinearDistributionTest.class);
    }
}