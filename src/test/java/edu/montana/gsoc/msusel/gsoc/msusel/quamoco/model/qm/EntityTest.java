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

import edu.montana.gsoc.msusel.quamoco.model.qm.Entity;
import edu.montana.gsoc.msusel.quamoco.model.qm.IsA;
import edu.montana.gsoc.msusel.quamoco.model.qm.OriginatesFrom;
import edu.montana.gsoc.msusel.quamoco.model.qm.Parent;
import edu.montana.gsoc.msusel.quamoco.model.qm.PartOf;

/**
 * The class <code>EntityTest</code> contains tests for the class
 * <code>{@link Entity}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:26 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class EntityTest {

	private Entity fixture;

	/**
	 * Run the Entity(String,String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEntity_1() throws Exception {
		final String name = "name";
		final String description = "";
		final String originatesFrom = "href";
		final String title = "title";
		final String id = "id";
		final String partOf = "part";

		final Entity result = new Entity(name, description, new OriginatesFrom(originatesFrom), title, id,
				new PartOf("partof", new Parent(partOf)));

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("part", result.getPartOf().getParent().getHREF());
		Assert.assertEquals("href", result.getOriginatesFrom().getHREF());
		Assert.assertEquals("title", result.getTitle());
		Assert.assertEquals("", result.getDescription());
		Assert.assertEquals("name", result.getName());
		Assert.assertEquals("id", result.getId());
	}

	/**
	 * Run the Entity(String,String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEntity_2() throws Exception {
		final String name = "";
		final String description = "";
		final String originatesFrom = "";
		final String title = "";
		final String id = "";
		final String partOf = "";

		try {
			new Entity(name, description, new OriginatesFrom(originatesFrom), title, id,
					new PartOf("partof", new Parent(partOf)));
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

	}

	/**
	 * Run the Entity(String,String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEntity_3() throws Exception {
		final String name = null;
		final String description = "";
		final String originatesFrom = "";
		final String title = "";
		final String id = "";
		final String partOf = "";

		try {
			new Entity(name, description, new OriginatesFrom(originatesFrom), title, id,
					new PartOf("partof", new Parent(partOf)));
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

	}

	/**
	 * Run the Entity(String,String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEntity_4() throws Exception {
		final String name = "";
		final String description = null;
		final String originatesFrom = "";
		final String title = "";
		final String id = "";
		final String partOf = "";

		try {
			new Entity(name, description, new OriginatesFrom(originatesFrom), title, id,
					new PartOf("partof", new Parent(partOf)));
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

	}

	/**
	 * Run the Entity(String,String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEntity_5() throws Exception {
		final String name = "";
		final String description = "";
		final String originatesFrom = "";
		final String title = null;
		final String id = "";
		final String partOf = "";

		try {
			new Entity(name, description, new OriginatesFrom(originatesFrom), title, id,
					new PartOf("partof", new Parent(partOf)));
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

	}

	/**
	 * Run the Entity(String,String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEntity_6() throws Exception {
		final String name = "";
		final String description = "";
		final String originatesFrom = "";
		final String title = "";
		final String id = null;
		final String partOf = "";

		try {
			new Entity(name, description, new OriginatesFrom(originatesFrom), title, id,
					new PartOf("partof", new Parent(partOf)));
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

	}

	/**
	 * Run the Entity(String,String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEntity_7() throws Exception {
		final String name = "name";
		final String description = null;
		final String originatesFrom = "";
		final String title = "title";
		final String id = "id";
		final String partOf = "";

		try {
			new Entity(name, description, new OriginatesFrom(originatesFrom), title, id,
					new PartOf("partof", new Parent(partOf)));
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

	}

	/**
	 * Run the Entity(String,String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEntity_8() throws Exception {
		final String name = "name";
		final String description = "";
		final String originatesFrom = "";
		final String title = null;
		final String id = "id";
		final String partOf = "";

		try {
			new Entity(name, description, new OriginatesFrom(originatesFrom), title, id,
					new PartOf("partof", new Parent(partOf)));
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

	}

	/**
	 * Run the Entity(String,String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEntity_9() throws Exception {
		final String name = "name";
		final String description = "";
		final String originatesFrom = "";
		final String title = "title";
		final String id = null;
		final String partOf = "";

		try {
			new Entity(name, description, new OriginatesFrom(originatesFrom), title, id,
					new PartOf("partof", new Parent(partOf)));
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}

	}

	/**
	 * Run the void addIsA(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testAddIsA_1() throws Exception {
		final IsA isa = new IsA("isa");
		fixture.addIsA(isa);
		final IsA isa2 = null;

		Assert.assertEquals(1, fixture.getIsAs().size());
		fixture.addIsA(isa2);
		Assert.assertEquals(1, fixture.getIsAs().size());
	}

	/**
	 * Run the void addIsA(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testAddIsA_2() throws Exception {
		final IsA isa = new IsA("isa");
		fixture.addIsA(isa);
		final IsA isa2 = new IsA("isa");

		Assert.assertEquals(1, fixture.getIsAs().size());
		fixture.addIsA(isa2);
		Assert.assertEquals(1, fixture.getIsAs().size());
	}

	/**
	 * Run the void addIsA(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testAddIsA_3() throws Exception {
		final IsA isa = new IsA("isa");
		fixture.addIsA(isa);
		final IsA isa2 = new IsA("isa2");

		Assert.assertEquals(1, fixture.getIsAs().size());
		fixture.addIsA(isa2);
		Assert.assertEquals(2, fixture.getIsAs().size());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Entity obj = new Entity("name", "", new OriginatesFrom("href"), "title", "id",
				new PartOf("part", new Parent("parent")));

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_2() throws Exception {
		final Object obj = null;

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_3() throws Exception {
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the String getOriginatesFrom() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetOriginatesFrom_1() throws Exception {
		final String result = fixture.getOriginatesFrom().getHREF();

		// add additional test code here
		Assert.assertEquals("href", result);
	}

	/**
	 * Run the String getPartOf() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetPartOf_1() throws Exception {
		final String result = fixture.getPartOf().getParent().getHREF();

		// add additional test code here
		Assert.assertEquals("parent", result);
	}

	/**
	 * Run the String getTitle() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetTitle_1() throws Exception {
		final String result = fixture.getTitle();

		// add additional test code here
		Assert.assertEquals("title", result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testHashCode_1() throws Exception {
		final int result = fixture.hashCode();

		// add additional test code here
		Assert.assertEquals(-141633170, result);
	}

	/**
	 * Run the int hashCode() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testHashCode_2() throws Exception {
		final int result = fixture.hashCode();

		// add additional test code here
		Assert.assertEquals(-141633170, result);
	}

	/**
	 * Run the void removeIsA(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testRemoveIsA_1() throws Exception {
		final IsA isa = new IsA("isa");
		fixture.addIsA(isa);
		final IsA isa2 = null;
		final IsA isa3 = new IsA("isa3");

		Assert.assertEquals(1, fixture.getIsAs().size());
		fixture.removeIsA(isa3);
		Assert.assertEquals(1, fixture.getIsAs().size());
		fixture.removeIsA(isa2);
		Assert.assertEquals(1, fixture.getIsAs().size());
		fixture.removeIsA(isa);
		Assert.assertTrue(fixture.getIsAs().isEmpty());
	}

	/**
	 * Run the void setOriginatesFrom(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetOriginatesFrom_1() throws Exception {
		Assert.assertNotNull(fixture.getOriginatesFrom());
		final OriginatesFrom originatesFrom = new OriginatesFrom("href2");

		fixture.setOriginatesFrom(originatesFrom);

		Assert.assertEquals(originatesFrom, fixture.getOriginatesFrom());
	}

	/**
	 * Run the void setPartOf(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetPartOf_1() throws Exception {
		Assert.assertNotNull(fixture.getPartOf());

		final String result = fixture.getPartOf().getParent().getHREF();

		// add additional test code here
		Assert.assertEquals("parent", result);
	}

	/**
	 * Run the void setTitle(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetTitle_1() throws Exception {
		final String title = "title";

		fixture.setTitle(title);

		Assert.assertEquals(title, fixture.getTitle());
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
		fixture = new Entity("name", "", new OriginatesFrom("href"), "title", "id",
				new PartOf("part", new Parent("parent")));
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
		new org.junit.runner.JUnitCore().run(EntityTest.class);
	}
}