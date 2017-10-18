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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.processor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.processor.MetricsContextException;

/**
 * The class <code>MetricsContextExceptionTest</code> contains tests for the
 * class <code>{@link MetricsContextException}</code>.
 *
 * @generatedBy CodePro at 1/26/16 8:05 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class MetricsContextExceptionTest {
	/**
	 * Run the MetricsContextException() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 8:05 PM
	 */
	@Test
	public void testMetricsContextException_1() throws Exception {

		final MetricsContextException result = new MetricsContextException();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(null, result.getCause());
		Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.processor.MetricsContextException", result.toString());
		Assert.assertEquals(null, result.getMessage());
		Assert.assertEquals(null, result.getLocalizedMessage());
	}

	/**
	 * Run the MetricsContextException(String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 8:05 PM
	 */
	@Test
	public void testMetricsContextException_2() throws Exception {
		final String message = "";

		final MetricsContextException result = new MetricsContextException(message);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(null, result.getCause());
		Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.processor.MetricsContextException: ", result.toString());
		Assert.assertEquals("", result.getMessage());
		Assert.assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Run the MetricsContextException(Throwable) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 8:05 PM
	 */
	@Test
	public void testMetricsContextException_3() throws Exception {
		final Throwable cause = new Throwable();

		final MetricsContextException result = new MetricsContextException(cause);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.processor.MetricsContextException: java.lang.Throwable",
				result.toString());
		Assert.assertEquals("java.lang.Throwable", result.getMessage());
		Assert.assertEquals("java.lang.Throwable", result.getLocalizedMessage());
	}

	/**
	 * Run the MetricsContextException(String,Throwable) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 8:05 PM
	 */
	@Test
	public void testMetricsContextException_4() throws Exception {
		final String message = "";
		final Throwable cause = new Throwable();

		final MetricsContextException result = new MetricsContextException(message, cause);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.processor.MetricsContextException: ", result.toString());
		Assert.assertEquals("", result.getMessage());
		Assert.assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Run the MetricsContextException(String,Throwable,boolean,boolean)
	 * constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 8:05 PM
	 */
	@Test
	public void testMetricsContextException_5() throws Exception {
		final String message = "";
		final Throwable cause = new Throwable();
		final boolean enableSuppression = true;
		final boolean writableStackTrace = true;

		final MetricsContextException result = new MetricsContextException(message, cause, enableSuppression,
				writableStackTrace);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.processor.MetricsContextException: ", result.toString());
		Assert.assertEquals("", result.getMessage());
		Assert.assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 1/26/16 8:05 PM
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 1/26/16 8:05 PM
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 *
	 * @generatedBy CodePro at 1/26/16 8:05 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(MetricsContextExceptionTest.class);
	}
}