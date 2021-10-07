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
package edu.montana.gsoc.msusel.quamoco.processor.lineardist;

import org.junit.Assert;
import org.junit.Test;

/**
 * The class <code>NegativeLinearDistributionTest</code> contains tests for the
 * class <code>{@link NegativeLinearDistribution}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class NegativeLinearDistributionTest {
    /**
     * Run the NegativeLinearDistribution(String) constructor test.
     */
    @Test
    public void testNegativeLinearDistribution_1() throws Exception
    {
        final NegativeLinearDistribution result = new NegativeLinearDistribution();

        // add additional test code here
        Assert.assertNotNull(result);
    }

    /**
     * Run the BigDecimal calculate(BigDecimal,BigDecimal) method test.
     */
    @Test
    public void testCalculate_1() throws Exception
    {
        final NegativeLinearDistribution fixture = new NegativeLinearDistribution();
        final double maxPoints = 100.0;
        final double proportion = 0.5;

        double result = fixture.calculate(maxPoints, proportion);

        // add additional test code here
        Assert.assertEquals(50.0, result, 0.001);

        result = fixture.calculate(maxPoints, 0.75);
        Assert.assertEquals(25.0, result, 0.001);

        result = fixture.calculate(maxPoints, 0.25);
        Assert.assertEquals(75.0, result, 0.001);

        result = fixture.calculate(maxPoints, 0);
        Assert.assertEquals(100.0, result, 0.001);

        result = fixture.calculate(maxPoints, 1.0);
        Assert.assertEquals(0.0, result, 0.001);

        result = fixture.calculate(maxPoints, 1.5);
        Assert.assertEquals(0.0, result, 0.001);

        result = fixture.calculate(maxPoints, -1.5);
        Assert.assertEquals(100.0, result, 0.001);
    }
}