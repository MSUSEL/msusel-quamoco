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

import edu.montana.gsoc.msusel.quamoco.model.qm.Parent;
import edu.montana.gsoc.msusel.quamoco.model.qm.PartOf;

/**
 * The class <code>PartOfTest</code> contains tests for the class
 * <code>{@link PartOf}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class PartOfTest {

	private PartOf fixture;

	/**
	 * Run the PartOf(String,Parent) constructor test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testPartOf_1() throws Exception {
		final String id = "";
		final Parent parent = new Parent("parent");

		PartOf result = null;
		try {
			result = new PartOf(id, parent);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
		}

		try {
			result = new PartOf(null, parent);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
		}

		try {
			result = new PartOf("part", null);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
		}

		result = new PartOf("part", parent);
		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("part", result.getId());
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testGetId_1() throws Exception {
		final String result = fixture.getId();

		// add additional test code here
		Assert.assertEquals("part", result);
	}

	/**
	 * Run the Parent getParent() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testGetParent_1() throws Exception {
		final Parent result = fixture.getParent();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("parent", result.getHREF());
		Assert.assertEquals("parent", result.toString());
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testSetId_1() throws Exception {
		final String id = null;

		try {
			fixture.setId(id);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
		}
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testSetId_2() throws Exception {
		final String id = "";

		try {
			fixture.setId(id);
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testSetId_3() throws Exception {
		final String id = "id";

		fixture.setId(id);

		// add additional test code here
		Assert.assertEquals(id, fixture.getId());
	}

	/**
	 * Run the void setParent(Parent) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Test
	public void testSetParent_1() throws Exception {
		final Parent parent = new Parent("parent");

		fixture.setParent(parent);

		// add additional test code here
		Assert.assertEquals(parent, fixture.getParent());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	@Before
	public void setUp() throws Exception {
		fixture = new PartOf("part", new Parent("parent"));
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * @generatedBy CodePro at 1/26/16 6:38 PM
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
	 * @generatedBy CodePro at 1/26/16 6:38 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(PartOfTest.class);
	}
}