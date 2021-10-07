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
/**
 * 
 */
package edu.montana.gsoc.msusel.quamoco.distiller;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * The class <code>GradeTest</code> contains tests for the class
 * <code>{@link Grade}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class GradeTest {

    /**
     * Run the int evaluate(Double) method test.
     */
    @Test
    public void testEvaluate_1() {
        final Grade fixture = Grade.A;
        final double val = 1.0;

        final int result = fixture.evaluate(val);

        // TODO: add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the int evaluate(Double) method test.
     */
    @Test
    public void testEvaluate_2() {
        final Grade fixture = Grade.A;
        final double val = 1.0;

        final int result = fixture.evaluate(val);

        // TODO: add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the int evaluate(Double) method test.
     */
    @Test
    public void testEvaluate_3() {
        final Grade fixture = Grade.A;
        final double val = 1.0;

        final int result = fixture.evaluate(val);

        // TODO: add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the List<Grade> getGrades() method test.
     */
    @Test
    public void testGetGrades_1() {

        final List<Grade> result = Grade.getGrades();

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(7.0, result.size(), 0.001);
    }

    /**
     * Run the String getName() method test.
     */
    @Test
    public void testGetName_1() {
        final Grade fixture = Grade.A;

        final String result = fixture.getName();

        // TODO: add additional test code here
        Assert.assertEquals("A", result);
    }

    /**
     * Run the void setThresholds(double,double) method test.
     */
    @Test
    public void testSetThresholds_1() throws Exception
    {
        final Grade fixture = Grade.A;
        final double lower = 1.0;
        final double upper = 1.0;

        try
        {
            fixture.setThresholds(lower, upper);
            Assert.assertEquals(lower, fixture.getLowerThreshold(), 0.001);
            Assert.assertEquals(upper, fixture.getUpperThreshold(), 0.001);
        }
        catch (final IllegalArgumentException e)
        {
            Assert.fail();
        }
    }

    /**
     * Run the void setThresholds(double,double) method test.
     */
    @Test(expected = GradeThresholdException.class)
    public void testSetThresholds_2() throws Exception
    {
        final Grade fixture = Grade.A;
        fixture.setThresholds(0.0, 1.0);
        final double lower = 1.0;
        final double upper = 0.0;

        fixture.setThresholds(lower, upper);
    }
}
