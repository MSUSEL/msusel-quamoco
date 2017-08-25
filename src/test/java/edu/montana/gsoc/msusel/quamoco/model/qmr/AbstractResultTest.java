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
package edu.montana.gsoc.msusel.quamoco.model.qmr;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.model.qmr.AbstractResult;
import edu.montana.gsoc.msusel.quamoco.model.qmr.Value;

/**
 * The class <code>AbstractResultTest</code> contains tests for the class
 * <code>{@link AbstractResult}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:49 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class AbstractResultTest {
	/**
	 * Run the AbstractResult() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testAbstractResult_1() throws Exception {

		final AbstractResult result = new AbstractResult();

		// TODO: add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(null, result.getValue());
		Assert.assertEquals(null, result.getType());
		Assert.assertEquals(null, result.getId());
	}

	/**
	 * Run the String getType() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetType_1() throws Exception {
		final AbstractResult fixture = new AbstractResult();
		fixture.setValue(new Value(1.0, 1.0, ""));
		fixture.setType("");

		final String result = fixture.getType();

		// TODO: add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the Value getValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetValue_1() throws Exception {
		final AbstractResult fixture = new AbstractResult();
		fixture.setValue(new Value(1.0, 1.0, ""));
		fixture.setType("");

		final Value result = fixture.getValue();

		// TODO: add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(1.0, result.getMean(), 1.0);
		Assert.assertEquals(1.0, result.getLower(), 1.0);
		Assert.assertEquals(1.0, result.getUpper(), 1.0);
		Assert.assertEquals("", result.getId());
	}

	/**
	 * Run the void setType(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetType_1() throws Exception {
		final AbstractResult fixture = new AbstractResult();
		fixture.setValue(new Value(1.0, 1.0, ""));
		fixture.setType("");
		final String type = "";

		fixture.setType(type);

		// TODO: add additional test code here
		Assert.assertEquals(type, fixture.getType());
	}

	/**
	 * Run the void setValue(Value) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetValue_1() throws Exception {
		final AbstractResult fixture = new AbstractResult();
		fixture.setValue(new Value(1.0, 1.0, ""));
		fixture.setType("");
		final Value value = new Value(1.0, 1.0, "");

		fixture.setValue(value);

		Assert.assertEquals(value, fixture.getValue());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
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
	 *
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
	 *
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(AbstractResultTest.class);
	}
}