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
package edu.montana.gsoc.msusel.quamoco.model.qm;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.model.qm.Function;

/**
 * The class <code>FunctionTest</code> contains tests for the class
 * <code>{@link Function}</code>.
 *
 * @generatedBy CodePro at 6/6/15 1:35 PM
 * @author isaac
 * @version $Revision: BigDecimal.ONE $
 */
public class FunctionTest {

    /**
     * Run the Function(BigDecimal,BigDecimal,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testFunction_1() throws Exception
    {
        final BigDecimal lowerBound = BigDecimal.ONE;
        final BigDecimal upperBound = BigDecimal.ONE;
        final String type = "";
        final String id = "";

        final Function result = new Function(lowerBound, upperBound, type, id);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(BigDecimal.ONE, result.getUpperBound());
        Assert.assertEquals(BigDecimal.ONE, result.getLowerBound());
        Assert.assertEquals("", result.getId());
        Assert.assertEquals("", result.getType());
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_1() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final Object obj = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_2() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final Object obj = null;

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_3() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final Object obj = new Object();

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_4() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final Object obj = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_5() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final Object obj = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_6() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", (String) null);
        final Object obj = new Function(BigDecimal.ONE, BigDecimal.ONE, "", (String) null);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_7() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final Object obj = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the String getId() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetId_1() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");

        final String result = fixture.getId();

        // add additional test code here
        Assert.assertEquals("", result);
    }

    /**
     * Run the BigDecimal getLowerBound() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetLowerBound_1() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");

        final BigDecimal result = fixture.getLowerBound();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the String getType() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetType_1() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");

        final String result = fixture.getType();

        // add additional test code here
        Assert.assertEquals("", result);
    }

    /**
     * Run the BigDecimal getUpperBound() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetUpperBound_1() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");

        final BigDecimal result = fixture.getUpperBound();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the void setId(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetId_1() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final String id = "";

        fixture.setId(id);

        Assert.assertEquals(id, fixture.getId());
    }

    /**
     * Run the void setLowerBound(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetLowerBound_1() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final BigDecimal lowerBound = BigDecimal.ONE;

        fixture.setLowerBound(lowerBound);

        Assert.assertEquals(lowerBound, fixture.getLowerBound());
    }

    /**
     * Run the void setType(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetType_1() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final String type = "";

        fixture.setType(type);

        Assert.assertEquals(type, fixture.getType());
    }

    /**
     * Run the void setUpperBound(BigDecimal) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetUpperBound_1() throws Exception
    {
        final Function fixture = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");
        final BigDecimal upperBound = BigDecimal.ONE;

        fixture.setUpperBound(upperBound);

        Assert.assertEquals(upperBound, fixture.getUpperBound());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 6/6/15 1:35 PM
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
     * @generatedBy CodePro at 6/6/15 1:35 PM
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
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(FunctionTest.class);
    }
}