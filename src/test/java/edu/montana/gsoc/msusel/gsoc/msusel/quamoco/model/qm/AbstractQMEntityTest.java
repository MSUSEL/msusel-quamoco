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

import edu.montana.gsoc.msusel.quamoco.model.qm.AbstractQMEntity;
import edu.montana.gsoc.msusel.quamoco.model.qm.Entity;

/**
 * The class <code>AbstractQMEntityTest</code> contains tests for the class
 * <code>{@link AbstractQMEntity}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:26 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class AbstractQMEntityTest {

	private AbstractQMEntity fixture;

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetDescription_1() throws Exception {
		final String result = fixture.getDescription();

		// add additional test code here
		Assert.assertEquals("description", result);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetName_1() throws Exception {
		final String result = fixture.getName();

		// add additional test code here
		Assert.assertEquals("name", result);
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetDescription_1() throws Exception {
		String description = "description";

		fixture.setDescription(description);
		Assert.assertEquals(description, fixture.getDescription());

		description = null;
		try {
			fixture.setDescription(description);
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

		// add additional test code here
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetName_1() throws Exception {
		String name = "name";

		fixture.setName(name);

		// add additional test code here
		Assert.assertEquals(name, fixture.getName());

		name = null;
		try {
			fixture.setName(name);
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

		name = "";
		try {
			fixture.setName(name);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
		}
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Before
	public void setUp() throws Exception {
		fixture = new Entity("name", "description", null, "title", "id", null);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
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
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(AbstractQMEntityTest.class);
	}
}