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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.model.qm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.model.qm.Annotation;

/**
 * The class <code>AnnotationTest</code> contains tests for the class
 * <code>{@link Annotation}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:26 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class AnnotationTest {
	/**
	 * Run the Annotation(String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testAnnotation_1() throws Exception {
		final String key = "";
		final String value = "";
		final String id = "";

		final Annotation result = new Annotation(key, value, id);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("", result.getValue());
		Assert.assertEquals("", result.getKey());
		Assert.assertEquals("", result.getId());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Annotation fixture = new Annotation("", "", "");
		final Object obj = new Annotation("", "", "");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_2() throws Exception {
		final Annotation fixture = new Annotation("", "", "");
		final Object obj = null;

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_3() throws Exception {
		final Annotation fixture = new Annotation("", "", "");
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_4() throws Exception {
		final Annotation fixture = new Annotation("", "", "");
		final Object obj = new Annotation("", "", "");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_5() throws Exception {
		final Annotation fixture = new Annotation("", "", "");
		final Object obj = new Annotation("", "", "");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_6() throws Exception {
		final Annotation fixture = new Annotation("", "", "");
		final Object obj = new Annotation("", "", "");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_7() throws Exception {
		final Annotation fixture = new Annotation("", (String) null, "");
		final Object obj = new Annotation("", (String) null, "");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetId_1() throws Exception {
		final Annotation fixture = new Annotation("", "", "");

		final String result = fixture.getId();

		// add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the String getKey() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetKey_1() throws Exception {
		final Annotation fixture = new Annotation("", "", "");

		final String result = fixture.getKey();

		// add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the String getValue() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetValue_1() throws Exception {
		final Annotation fixture = new Annotation("", "", "");

		final String result = fixture.getValue();

		// add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testHashCode_1() throws Exception {
		final Annotation fixture = new Annotation((String) null, "", "");

		final int result = fixture.hashCode();

		// add additional test code here
		Assert.assertEquals(961, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testHashCode_2() throws Exception {
		final Annotation fixture = new Annotation("", (String) null, "");

		final int result = fixture.hashCode();

		// add additional test code here
		Assert.assertEquals(961, result);
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetId_1() throws Exception {
		final Annotation fixture = new Annotation("", "", "");
		final String id = "";

		fixture.setId(id);

		// add additional test code here
	}

	/**
	 * Run the void setKey(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetKey_1() throws Exception {
		final Annotation fixture = new Annotation("", "", "");
		final String key = "";

		fixture.setKey(key);

		// add additional test code here
	}

	/**
	 * Run the void setValue(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetValue_1() throws Exception {
		final Annotation fixture = new Annotation("", "", "");
		final String value = "";

		fixture.setValue(value);

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 5/30/15 3:26 PM
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
	 * @generatedBy CodePro at 5/30/15 3:26 PM
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
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(AnnotationTest.class);
	}
}