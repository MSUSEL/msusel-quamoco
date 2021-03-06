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
package edu.montana.gsoc.msusel.quamoco.io;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.distiller.Grade;
import edu.montana.gsoc.msusel.quamoco.io.GradeSchemePropertiesReader;

/**
 * The class <code>GradeSchemePropertiesReaderTest</code> contains tests for the
 * class <code>{@link GradeSchemePropertiesReader}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:42 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class GradeSchemePropertiesReaderTest {

    /**
     * Run the GradeSchemePropertiesReader() constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testGradeSchemePropertiesReader_1() throws Exception
    {
        final GradeSchemePropertiesReader fixture = new GradeSchemePropertiesReader();

        Assert.assertNotNull(fixture);
    }

    /**
     * Run the void read() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testRead_1() throws Exception
    {
        final GradeSchemePropertiesReader fixture = new GradeSchemePropertiesReader();
        fixture.read();

        Assert.assertEquals(new BigDecimal(1.5), Grade.A.getUpperThreshold());
        Assert.assertEquals(new BigDecimal(0.98), Grade.A.getLowerThreshold());

        Assert.assertEquals(new BigDecimal(0.98), Grade.B.getUpperThreshold());
        Assert.assertEquals(new BigDecimal(0.96), Grade.B.getLowerThreshold());

        Assert.assertEquals(new BigDecimal(0.96), Grade.C.getUpperThreshold());
        Assert.assertEquals(new BigDecimal(0.94), Grade.C.getLowerThreshold());

        Assert.assertEquals(new BigDecimal(0.94), Grade.D.getUpperThreshold());
        Assert.assertEquals(new BigDecimal(0.92), Grade.D.getLowerThreshold());

        Assert.assertEquals(new BigDecimal(0.92), Grade.E.getUpperThreshold());
        Assert.assertEquals(new BigDecimal(0.90), Grade.E.getLowerThreshold());

        Assert.assertEquals(new BigDecimal(0.90), Grade.F.getUpperThreshold());
        Assert.assertEquals(new BigDecimal(0.0), Grade.F.getLowerThreshold());

        Assert.assertEquals(new BigDecimal(0.0), Grade.U.getUpperThreshold());
        Assert.assertEquals(new BigDecimal(-1.0), Grade.U.getLowerThreshold());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 5/30/15 3:42 PM
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
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @After
    public void tearDown() throws Exception
    {
        // TODO: add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(GradeSchemePropertiesReaderTest.class);
    }
}