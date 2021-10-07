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

/**
 * The class <code>GradeThresholdExceptionTest</code> contains tests for the
 * class <code>{@link GradeThresholdException}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class GradeThresholdExceptionTest {

    /**
     * Run the GradeThresholdException() constructor test.
     */
    @Test
    public void testGradeThresholdException_1() {

        final GradeThresholdException result = new GradeThresholdException();

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertNull(result.getCause());
        Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.distiller.GradeThresholdException", result.toString());
        Assert.assertNull(result.getMessage());
        Assert.assertNull(result.getLocalizedMessage());
    }

    /**
     * Run the GradeThresholdException(String) constructor test.
     */
    @Test
    public void testGradeThresholdException_2() {
        final String message = "";

        final GradeThresholdException result = new GradeThresholdException(message);

        // TODO: add additional test code here
        Assert.assertNotNull(result);
        Assert.assertNull(result.getCause());
        Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.distiller.GradeThresholdException: ", result.toString());
        Assert.assertEquals("", result.getMessage());
        Assert.assertEquals("", result.getLocalizedMessage());
    }

    /**
     * Run the GradeThresholdException(Throwable) constructor test.
     */
    @Test
    public void testGradeThresholdException_3() {
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
     */
    @Test
    public void testGradeThresholdException_4() {
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
     */
    @Test
    public void testGradeThresholdException_5() {
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
}
