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
/**
 * 
 */
package edu.montana.gsoc.msusel.quamoco.distiller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * The class <code>GradeTest</code> contains tests for the class
 * <code>{@link Grade}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:41 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class GradeTest {

    /**
     * Run the int evaluate(Double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:41 PM
     */
    @Test
    public void testEvaluate_1() throws Exception
    {
        final Grade fixture = Grade.A;
        final double val = 1.0;

        final int result = fixture.evaluate(val);

        // TODO: add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the int evaluate(Double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:41 PM
     */
    @Test
    public void testEvaluate_2() throws Exception
    {
        final Grade fixture = Grade.A;
        final double val = 1.0;

        final int result = fixture.evaluate(val);

        // TODO: add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the int evaluate(Double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:41 PM
     */
    @Test
    public void testEvaluate_3() throws Exception
    {
        final Grade fixture = Grade.A;
        final double val = 1.0;

        final int result = fixture.evaluate(val);

        // TODO: add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the List<Grade> getGrades() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:41 PM
     */
    @Test
    public void testGetGrades_1() throws Exception
    {

        final List<Grade> result = Grade.getGrades();

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(7.0, result.size(), 0.001);
    }

    /**
     * Run the String getName() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:41 PM
     */
    @Test
    public void testGetName_1() throws Exception
    {
        final Grade fixture = Grade.A;

        final String result = fixture.getName();

        // TODO: add additional test code here
        Assert.assertEquals("A", result);
    }

    /**
     * Run the void setThresholds(double,double) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:41 PM
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
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:41 PM
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

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 5/30/15 3:41 PM
     */
    @Before
    public void setUp() throws Exception
    {
        // TODO: add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 5/30/15 3:41 PM
     */
    @After
    public void tearDown() throws Exception
    {
        // TODO: add additional tear down code here
    }
}
