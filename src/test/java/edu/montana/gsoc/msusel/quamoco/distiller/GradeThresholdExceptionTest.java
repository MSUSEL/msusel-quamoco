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
package edu.montana.gsoc.msusel.quamoco.distiller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.distiller.GradeThresholdException;

/**
 * The class <code>GradeThresholdExceptionTest</code> contains tests for the
 * class <code>{@link GradeThresholdException}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:42 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class GradeThresholdExceptionTest {

    /**
     * Run the GradeThresholdException() constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testGradeThresholdException_1() throws Exception {

        final GradeThresholdException result = new GradeThresholdException();

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(null, result.getCause());
        Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.distiller.GradeThresholdException", result.toString());
        Assert.assertEquals(null, result.getMessage());
        Assert.assertEquals(null, result.getLocalizedMessage());
    }

    /**
     * Run the GradeThresholdException(String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testGradeThresholdException_2() throws Exception {
        final String message = "";

        final GradeThresholdException result = new GradeThresholdException(message);

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(null, result.getCause());
        Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.distiller.GradeThresholdException: ", result.toString());
        Assert.assertEquals("", result.getMessage());
        Assert.assertEquals("", result.getLocalizedMessage());
    }

    /**
     * Run the GradeThresholdException(Throwable) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testGradeThresholdException_3() throws Exception {
        final Throwable cause = new Throwable();

        final GradeThresholdException result = new GradeThresholdException(cause);

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.distiller.GradeThresholdException: java.lang.Throwable",
                result.toString());
        Assert.assertEquals("java.lang.Throwable", result.getMessage());
        Assert.assertEquals("java.lang.Throwable", result.getLocalizedMessage());
    }

    /**
     * Run the GradeThresholdException(String,Throwable) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testGradeThresholdException_4() throws Exception {
        final String message = "";
        final Throwable cause = new Throwable();

        final GradeThresholdException result = new GradeThresholdException(message, cause);

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.distiller.GradeThresholdException: ", result.toString());
        Assert.assertEquals("", result.getMessage());
        Assert.assertEquals("", result.getLocalizedMessage());
    }

    /**
     * Run the GradeThresholdException(String,Throwable,boolean,boolean)
     * constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testGradeThresholdException_5() throws Exception {
        final String message = "";
        final Throwable cause = new Throwable();
        final boolean enableSuppression = true;
        final boolean writableStackTrace = true;

        final GradeThresholdException result = new GradeThresholdException(message, cause, enableSuppression,
                writableStackTrace);

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.distiller.GradeThresholdException: ", result.toString());
        Assert.assertEquals("", result.getMessage());
        Assert.assertEquals("", result.getLocalizedMessage());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Before
    public void setUp() throws Exception {
        // TODO: add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @After
    public void tearDown() throws Exception {
        // TODO: add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    public static void main(final String[] args) {
        new org.junit.runner.JUnitCore().run(GradeThresholdExceptionTest.class);
    }
}
