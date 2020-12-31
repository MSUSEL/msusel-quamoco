/**
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
package edu.montana.gsoc.msusel.quamoco.processor;

import org.junit.Assert;
import org.junit.Test;

/**
 * The class <code>MetricsContextExceptionTest</code> contains tests for the
 * class <code>{@link MetricsContextException}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MetricsContextExceptionTest {
	/**
	 * Run the MetricsContextException() constructor test.
	 */
	@Test
	public void testMetricsContextException_1() {

		final MetricsContextException result = new MetricsContextException();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertNull(result.getCause());
		Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.processor.MetricsContextException", result.toString());
		Assert.assertNull(result.getMessage());
		Assert.assertNull(result.getLocalizedMessage());
	}

	/**
	 * Run the MetricsContextException(String) constructor test.
	 */
	@Test
	public void testMetricsContextException_2() {
		final String message = "";

		final MetricsContextException result = new MetricsContextException(message);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertNull(result.getCause());
		Assert.assertEquals("edu.montana.gsoc.msusel.quamoco.processor.MetricsContextException: ", result.toString());
		Assert.assertEquals("", result.getMessage());
		Assert.assertEquals("", result.getLocalizedMessage());
	}

	/**
	 * Run the MetricsContextException(Throwable) constructor test.
	 */
	@Test
	public void testMetricsContextException_3() {
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
	 */
	@Test
	public void testMetricsContextException_4() {
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
	 */
	@Test
	public void testMetricsContextException_5() {
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
}