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

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import edu.montana.gsoc.msusel.quamoco.model.qmr.EvaluationResult;
import edu.montana.gsoc.msusel.quamoco.model.qmr.Value;

/**
 * The class <code>EvaluationResultTest</code> contains tests for the class
 * <code>{@link EvaluationResult}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:49 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class EvaluationResultTest {

	/**
	 * Run the EvaluationResult() constructor test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEvaluationResult_1() throws Exception {

		final EvaluationResult result = new EvaluationResult();

		// TODO: add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(null, result.getRatioAffected());
		Assert.assertEquals(null, result.getResultsFrom());
		Assert.assertEquals(null, result.getResultsType());
		Assert.assertEquals(null, result.getValue());
		Assert.assertEquals(null, result.getType());
		Assert.assertEquals(null, result.getId());
	}

	/**
	 * Run the void addEvalResult(EvaluationResult) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testAddEvalResult_1() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult result = null;

		fixture.addEvalResult(result);

		Assert.assertEquals(0, fixture.getEvalResults().size());
	}

	/**
	 * Run the void addEvalResult(EvaluationResult) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testAddEvalResult_2() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult result = new EvaluationResult();

		fixture.addEvalResult(result);

		Assert.assertEquals(1, fixture.getEvalResults().size());
	}

	/**
	 * Run the void addEvalResult(EvaluationResult) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testAddEvalResult_3() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult result = new EvaluationResult();

		fixture.addEvalResult(new EvaluationResult());
		Assert.assertEquals(1, fixture.getEvalResults().size());
		fixture.addEvalResult(result);
		Assert.assertEquals(1, fixture.getEvalResults().size());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult obj = new EvaluationResult();
		obj.setResultsType("");
		obj.setResultsFrom("");
		obj.setRatioAffected("");
		obj.type = "";
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
	public void testEquals_2() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult obj = new EvaluationResult();
		obj.setRatioAffected("");

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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult obj = new EvaluationResult();
		obj.setResultsFrom("");
		obj.setRatioAffected("");

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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult obj = new EvaluationResult();
		obj.setResultsFrom("");
		obj.setRatioAffected("");
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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult obj = new EvaluationResult();
		obj.setResultsFrom("");
		obj.setRatioAffected("");
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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = null;
		final EvaluationResult obj = new EvaluationResult();
		obj.setResultsFrom("");
		obj.setRatioAffected("");
		obj.value = null;

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the List<EvaluationResult> getEvalResults() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetEvalResults_1() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");

		final List<EvaluationResult> result = fixture.getEvalResults();

		// TODO: add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(0, result.size());
	}

	/**
	 * Run the String getRatioAffected() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testGetRatioAffected_1() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");

		final String result = fixture.getRatioAffected();

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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");

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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");

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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected((String) null);
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");

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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom((String) null);
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = null;

		final int result = fixture.hashCode();

		// TODO: add additional test code here
		Assert.assertEquals(29791, result);
	}

	/**
	 * Run the void removeEvalResult(EvaluationResult) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testRemoveEvalResult_1() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.addEvalResult(new EvaluationResult());
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult result = null;

		fixture.removeEvalResult(result);

		Assert.assertEquals(1, fixture.getEvalResults().size());
	}

	/**
	 * Run the void removeEvalResult(EvaluationResult) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testRemoveEvalResult_2() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final EvaluationResult result = new EvaluationResult();

		fixture.removeEvalResult(result);

		Assert.assertEquals(0, fixture.getEvalResults().size());
	}

	/**
	 * Run the void removeEvalResult(EvaluationResult) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testRemoveEvalResult_3() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		fixture.addEvalResult(new EvaluationResult());
		final EvaluationResult result = new EvaluationResult();
		result.setId("other");

		fixture.removeEvalResult(result);

		Assert.assertEquals(1, fixture.getEvalResults().size());
	}

	/**
	 * Run the void setEvalResults(List<EvaluationResult>) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetEvalResults_1() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final List<EvaluationResult> evalResults = Lists.newArrayList();

		Assert.assertEquals(0, fixture.getEvalResults().size());
		evalResults.add(new EvaluationResult());
		fixture.setEvalResults(evalResults);
		Assert.assertEquals(1, fixture.getEvalResults().size());
	}

	/**
	 * Run the void setRatioAffected(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetRatioAffected_1() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
		final String ratioAffected = "0.5";

		fixture.setRatioAffected(ratioAffected);

		Assert.assertEquals(ratioAffected, fixture.getRatioAffected());
	}

	/**
	 * Run the void setResultsFrom(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:49 PM
	 */
	@Test
	public void testSetResultsFrom_1() throws Exception {
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
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
		final EvaluationResult fixture = new EvaluationResult();
		fixture.setResultsType("");
		fixture.setResultsFrom("");
		fixture.setRatioAffected("");
		fixture.type = "";
		fixture.value = new Value(1.0, 1.0, "");
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
		new org.junit.runner.JUnitCore().run(EvaluationResultTest.class);
	}
}