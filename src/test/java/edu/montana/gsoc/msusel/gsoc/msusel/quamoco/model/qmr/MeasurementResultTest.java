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

import edu.montana.gsoc.msusel.quamoco.model.qmr.FindingMessage;
import edu.montana.gsoc.msusel.quamoco.model.qmr.MeasurementResult;
import edu.montana.gsoc.msusel.quamoco.model.qmr.Value;

/**
 * The class <code>MeasurementResultTest</code> contains tests for the class
 * <code>{@link MeasurementResult}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:49 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class MeasurementResultTest {

	/**
	 * Run the MeasurementResult() constructor test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testMeasurementResult_1() throws Exception {

		final MeasurementResult result = new MeasurementResult();

		// TODO: add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(null, result.getResultsFrom());
		Assert.assertEquals(null, result.getResultsType());
		Assert.assertEquals(0, result.getCount());
		Assert.assertEquals(null, result.getMessage());
		Assert.assertEquals(null, result.getValue());
		Assert.assertEquals(null, result.getType());
		Assert.assertEquals(null, result.getId());
	}

	/**
	 * Run the void addFindingMessage(FindingMessage) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testAddFindingMessage_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final FindingMessage fm = null;

		fixture.addFindingMessage(fm);

		Assert.assertEquals(1, fixture.getFindingMessages().size());
	}

	/**
	 * Run the void addFindingMessage(FindingMessage) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testAddFindingMessage_2() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final FindingMessage fm = new FindingMessage("", "", "");

		fixture.addFindingMessage(fm);

		Assert.assertEquals(1, fixture.getFindingMessages().size());
	}

	/**
	 * Run the void addFindingMessage(FindingMessage) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testAddFindingMessage_3() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final FindingMessage fm = new FindingMessage("other", "", "");

		fixture.addFindingMessage(fm);

		Assert.assertEquals(2, fixture.getFindingMessages().size());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final MeasurementResult obj = new MeasurementResult();
		obj.setResultsFrom("");
		obj.setCount(1);
		obj.setMessage("");
		obj.setResultsType("");
		obj.value = new Value(1.0, 1.0, "");
		obj.addFindingMessage(new FindingMessage("", "", ""));
		obj.type = "";

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
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
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
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
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
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final MeasurementResult obj = new MeasurementResult();
		obj.setMessage("");

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
	public void testEquals_5() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final MeasurementResult obj = new MeasurementResult();
		obj.setResultsFrom("");
		obj.setMessage("");

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
	public void testEquals_6() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final MeasurementResult obj = new MeasurementResult();
		obj.setResultsFrom("");
		obj.setMessage("");
		obj.value = new Value(1.0, 1.0, "");

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
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final MeasurementResult obj = new MeasurementResult();
		obj.setResultsFrom("");
		obj.setMessage("");
		obj.value = new Value(1.0, 1.0, "");

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
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = null;
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final MeasurementResult obj = new MeasurementResult();
		obj.setResultsFrom("");
		obj.setMessage("");
		obj.value = null;

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the int getCount() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetCount_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";

		final int result = fixture.getCount();

		// TODO: add additional test code here
		Assert.assertEquals(1, result);
	}

	/**
	 * Run the String getMessage() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetMessage_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";

		final String result = fixture.getMessage();

		// TODO: add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the String getResultsFrom() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetResultsFrom_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";

		final String result = fixture.getResultsFrom();

		// TODO: add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the String getResultsType() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetResultsType_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";

		final String result = fixture.getResultsType();

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
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage((String) null);
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";

		final int result = fixture.hashCode();

		// TODO: add additional test code here
		Assert.assertEquals(-33494850, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testHashCode_2() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom((String) null);
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = null;
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";

		final int result = fixture.hashCode();

		// TODO: add additional test code here
		Assert.assertEquals(29791, result);
	}

	/**
	 * Run the void removeFindingMessage(FindingMessage) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testRemoveFindingMessage_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final FindingMessage fm = null;

		fixture.removeFindingMessage(fm);

		Assert.assertEquals(1, fixture.getFindingMessages().size());
	}

	/**
	 * Run the void removeFindingMessage(FindingMessage) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testRemoveFindingMessage_2() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final FindingMessage fm = new FindingMessage("", "", "");

		fixture.removeFindingMessage(fm);

		Assert.assertEquals(0, fixture.getFindingMessages().size());
	}

	/**
	 * Run the void removeFindingMessage(FindingMessage) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testRemoveFindingMessage_3() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final FindingMessage fm = new FindingMessage("other", "", "");

		fixture.removeFindingMessage(fm);

		Assert.assertEquals(1, fixture.getFindingMessages().size());
	}

	/**
	 * Run the void setCount(int) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetCount_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final int count = 1;

		fixture.setCount(count);

		Assert.assertEquals(count, fixture.getCount());
	}

	/**
	 * Run the void setMessage(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetMessage_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final String message = "";

		fixture.setMessage(message);

		Assert.assertEquals(message, fixture.getMessage());
	}

	/**
	 * Run the void setResultsFrom(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetResultsFrom_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final String resultsFrom = "";

		fixture.setResultsFrom(resultsFrom);

		Assert.assertEquals(resultsFrom, fixture.getResultsFrom());
	}

	/**
	 * Run the void setResultsType(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetResultsType_1() throws Exception {
		final MeasurementResult fixture = new MeasurementResult();
		fixture.setResultsFrom("");
		fixture.setCount(1);
		fixture.setMessage("");
		fixture.setResultsType("");
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addFindingMessage(new FindingMessage("", "", ""));
		fixture.type = "";
		final String resultsType = "";

		fixture.setResultsType(resultsType);

		Assert.assertEquals(resultsType, fixture.getResultsType());
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
		new org.junit.runner.JUnitCore().run(MeasurementResultTest.class);
	}
}