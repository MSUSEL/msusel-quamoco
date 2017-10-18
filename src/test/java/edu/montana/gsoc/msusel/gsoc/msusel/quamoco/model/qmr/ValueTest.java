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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.model.qmr;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.model.qmr.Value;

/**
 * The class <code>ValueTest</code> contains tests for the class
 * <code>{@link Value}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:49 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class ValueTest {

	/**
	 * Run the Value(double,double,String) constructor test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testValue_1() throws Exception {
		final double lower = 1.0;
		final double upper = 1.0;
		final String id = "";

		final Value result = new Value(lower, upper, id);

		// TODO: add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(1.0, result.getMean(), 1.0);
		Assert.assertEquals(1.0, result.getLower(), 1.0);
		Assert.assertEquals(1.0, result.getUpper(), 1.0);
		Assert.assertEquals("", result.getId());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");
		final Object obj = new Value(1.0, 1.0, "");

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEquals_2() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");
		final Object obj = null;

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEquals_3() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEquals_4() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");
		final Object obj = new Value(1.0, 1.0, "");

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEquals_5() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");
		final Object obj = new Value(1.0, 1.0, "");

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEquals_6() throws Exception {
		final Value fixture = new Value(1.0, 1.0, (String) null);
		final Object obj = new Value(1.0, 1.0, (String) null);

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEquals_7() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");
		final Object obj = new Value(1.0, 1.0, "");

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetId_1() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");

		final String result = fixture.getId();

		// TODO: add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the double getLower() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetLower_1() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");

		final double result = fixture.getLower();

		// TODO: add additional test code here
		Assert.assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the double getMean() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetMean_1() throws Exception {
		final Value fixture = new Value(1.0, 2.0, "");

		final double result = fixture.getMean();

		// TODO: add additional test code here
		Assert.assertEquals(1.5, result, 0.1);
	}

	/**
	 * Run the double getMean() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetMean_2() throws Exception {
		final Value fixture = new Value(-2.0, 2.0, "");

		final double result = fixture.getMean();

		// TODO: add additional test code here
		Assert.assertEquals(2.0, result, 0.1);
	}

	/**
	 * Run the double getMean() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetMean_3() throws Exception {
		final Value fixture = new Value(-1.0, -1.0, "");

		final double result = fixture.getMean();

		// TODO: add additional test code here
		Assert.assertEquals(-1.0, result, 0.1);
	}

	/**
	 * Run the double getMean() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetMean_4() throws Exception {
		final Value fixture = new Value(1.0, -1.0, "");

		final double result = fixture.getMean();

		// TODO: add additional test code here
		Assert.assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the double getUpper() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetUpper_1() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");

		final double result = fixture.getUpper();

		// TODO: add additional test code here
		Assert.assertEquals(1.0, result, 0.1);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testHashCode_1() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");

		final int result = fixture.hashCode();

		// TODO: add additional test code here
		Assert.assertEquals(-33524641, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testHashCode_2() throws Exception {
		final Value fixture = new Value(1.0, 1.0, (String) null);

		final int result = fixture.hashCode();

		// TODO: add additional test code here
		Assert.assertEquals(-33524641, result);
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetId_1() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");
		final String id = "";

		fixture.setId(id);

		Assert.assertEquals(id, fixture.getId());
	}

	/**
	 * Run the void setLower(double) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetLower_1() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");
		final double lower = 1.0;

		fixture.setLower(lower);

		Assert.assertEquals(lower, fixture.getLower(), 0.01);
	}

	/**
	 * Run the void setUpper(double) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetUpper_1() throws Exception {
		final Value fixture = new Value(1.0, 1.0, "");
		final double upper = 1.0;

		fixture.setUpper(upper);

		Assert.assertEquals(upper, fixture.getUpper(), 0.01);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * @generatedBy CodePro at 5/30/15 3:49 PM
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
	 * @generatedBy CodePro at 5/30/15 3:49 PM
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
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(ValueTest.class);
	}
}