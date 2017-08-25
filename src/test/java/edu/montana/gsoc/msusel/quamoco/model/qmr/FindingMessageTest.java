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

import edu.montana.gsoc.msusel.quamoco.model.qmr.FindingMessage;

/**
 * The class <code>FindingMessageTest</code> contains tests for the class
 * <code>{@link FindingMessage}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:49 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class FindingMessageTest {

	/**
	 * Run the FindingMessage(String,String,String) constructor test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testFindingMessage_1() throws Exception {
		final String message = "";
		final String location = "";
		final String id = "";

		final FindingMessage result = new FindingMessage(message, location, id);

		// TODO: add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("", result.getLocation());
		Assert.assertEquals("", result.getMessage());
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
		final FindingMessage fixture = new FindingMessage("", "", "");
		final Object obj = new FindingMessage("", "", "");

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
		final FindingMessage fixture = new FindingMessage("", "", "");
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
		final FindingMessage fixture = new FindingMessage("", "", "");
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
		final FindingMessage fixture = new FindingMessage("", "", "");
		final Object obj = new FindingMessage("", "", "");

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
		final FindingMessage fixture = new FindingMessage("", "", "");
		final Object obj = new FindingMessage("", "", "");

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
		final FindingMessage fixture = new FindingMessage("", "", "");
		final Object obj = new FindingMessage("", "", "");

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
		final FindingMessage fixture = new FindingMessage("", "", "");
		final Object obj = new FindingMessage("", "", "");

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
	public void testEquals_8() throws Exception {
		final FindingMessage fixture = new FindingMessage((String) null, "", "");
		final Object obj = new FindingMessage((String) null, "", "");

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
		final FindingMessage fixture = new FindingMessage("", "", "");

		final String result = fixture.getId();

		// TODO: add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the String getLocation() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetLocation_1() throws Exception {
		final FindingMessage fixture = new FindingMessage("", "", "");

		final String result = fixture.getLocation();

		// TODO: add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the String getMessage() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetMessage_1() throws Exception {
		final FindingMessage fixture = new FindingMessage("", "", "");

		final String result = fixture.getMessage();

		// TODO: add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testHashCode_1() throws Exception {
		final FindingMessage fixture = new FindingMessage("", "", (String) null);

		final int result = fixture.hashCode();

		// TODO: add additional test code here
		Assert.assertEquals(29791, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testHashCode_2() throws Exception {
		final FindingMessage fixture = new FindingMessage((String) null, (String) null, "");

		final int result = fixture.hashCode();

		// TODO: add additional test code here
		Assert.assertEquals(29791, result);
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetId_1() throws Exception {
		final FindingMessage fixture = new FindingMessage("", "", "");
		final String id = "";

		fixture.setId(id);

		// TODO: add additional test code here
		Assert.assertEquals(id, fixture.getId());
	}

	/**
	 * Run the void setLocation(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetLocation_1() throws Exception {
		final FindingMessage fixture = new FindingMessage("", "", "");
		final String location = "";

		fixture.setLocation(location);

		Assert.assertEquals(location, fixture.getLocation());
	}

	/**
	 * Run the void setMessage(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetMessage_1() throws Exception {
		final FindingMessage fixture = new FindingMessage("", "", "");
		final String message = "";

		fixture.setMessage(message);

		Assert.assertEquals(message, fixture.getMessage());
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
		new org.junit.runner.JUnitCore().run(FindingMessageTest.class);
	}
}