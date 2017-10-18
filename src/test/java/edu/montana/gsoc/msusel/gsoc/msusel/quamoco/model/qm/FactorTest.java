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

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.model.qm.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Characterizes;
import edu.montana.gsoc.msusel.quamoco.model.qm.Factor;
import edu.montana.gsoc.msusel.quamoco.model.qm.Influence;
import edu.montana.gsoc.msusel.quamoco.model.qm.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.qm.OriginatesFrom;
import edu.montana.gsoc.msusel.quamoco.model.qm.Refines;
import edu.montana.gsoc.msusel.quamoco.model.qm.Target;

/**
 * The class <code>FactorTest</code> contains tests for the class
 * <code>{@link Factor}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:27 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class FactorTest {

	private Factor fixture;

	/**
	 * Run the Factor(String,String,String,String,String,String,String)
	 * constructor test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testFactor_1() throws Exception {
		final String name = "factor";
		final String description = "";
		final Characterizes characterises = new Characterizes("href");
		final OriginatesFrom originatesFrom = new OriginatesFrom("href");
		final String title = "";
		final Refines refines = new Refines("href");
		final String id = "id";

		final Factor result = new Factor(name, description, characterises, originatesFrom, title, refines, id);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("href", result.getRefines().getHREF());
		Assert.assertEquals("href", result.getCharacterizes().getHREF());
		Assert.assertEquals("href", result.getOriginatesFrom().getHREF());
		Assert.assertEquals("", result.getTitle());
		Assert.assertTrue(result.getAnnotations().isEmpty());
		Assert.assertEquals("", result.getDescription());
		Assert.assertEquals("factor", result.getName());
		Assert.assertEquals("id", result.getId());
	}

	/**
	 * Run the void addInfluence(Influence) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddInfluence_1() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", null, "id"));
		final Influence inf = null;

		Assert.assertEquals(1, fixture.getInfluences().size());
		fixture.addInfluence(inf);
		Assert.assertEquals(1, fixture.getInfluences().size());
		// add additional test code here

	}

	/**
	 * Run the void addInfluence(Influence) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddInfluence_2() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", null, "id"));
		final Influence inf = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

		Assert.assertEquals(1, fixture.getInfluences().size());
		fixture.addInfluence(inf);
		Assert.assertEquals(1, fixture.getInfluences().size());
	}

	/**
	 * Run the void addInfluence(Influence) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddInfluence_3() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", null, "id"));
		final Influence inf = new Influence(InfluenceEffect.NEGATIVE, "", null, "id");

		Assert.assertEquals(1, fixture.getInfluences().size());
		fixture.addInfluence(inf);
		Assert.assertEquals(2, fixture.getInfluences().size());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_2() throws Exception {
		final Factor obj = new Factor("factor", "", new Characterizes("href"), new OriginatesFrom("href"), "",
				new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_3() throws Exception {
		final Factor obj = new Factor("factorx", "", new Characterizes("href"), new OriginatesFrom("href"), "",
				new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_4() throws Exception {
		final Factor obj = new Factor("factor", "darkness", new Characterizes("href"), new OriginatesFrom("href"), "",
				new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_5() throws Exception {
		final Factor obj = new Factor("factor", "", new Characterizes("href"), new OriginatesFrom("href"), "",
				new Refines("href"), "id2");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_6() throws Exception {
		final Factor obj = new Factor("factor", "", new Characterizes("href2"), new OriginatesFrom("href"), "",
				new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_7() throws Exception {
		final Factor obj = new Factor("factor", "", new Characterizes("href"), new OriginatesFrom("href2"), "",
				new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_8() throws Exception {
		final Factor obj = new Factor("factor", "", new Characterizes("href"), new OriginatesFrom("href"), "",
				new Refines("href2"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_9() throws Exception {
		final Factor obj = new Factor("factor", "", null, new OriginatesFrom("href"), "", new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_10() throws Exception {
		final Factor obj = new Factor("factor", "", new Characterizes("href"), null, "", new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_11() throws Exception {
		final Factor obj = new Factor("factor", "", new Characterizes("href"), new OriginatesFrom("href"), "", null,
				"id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_12() throws Exception {
		final Factor obj = new Factor("factor", "description", new Characterizes("href"), new OriginatesFrom("href"),
				"", new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_13() throws Exception {
		final Factor obj = new Factor("factor", null, new Characterizes("href"), new OriginatesFrom("href"), "",
				new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_14() throws Exception {
		final Factor obj = new Factor("factor", "", new Characterizes("href"), new OriginatesFrom("href"), null,
				new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_15() throws Exception {
		final Factor obj = new Factor("factor", "", new Characterizes("href"), new OriginatesFrom("href"), "title",
				new Refines("href"), "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the Annotation getAnnotation() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetAnnotation_1() throws Exception {
		fixture.addAnnotation(new Annotation("", "", ""));

		final List<Annotation> result = fixture.getAnnotations();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertEquals(1, result.size());
	}

	/**
	 * Run the String getCharacterises() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetCharacterises_1() throws Exception {
		final String result = fixture.getCharacterizes().getHREF();

		// add additional test code here
		Assert.assertEquals("href", result);
	}

	/**
	 * Run the List<Influence> getInfluences() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetInfluences_1() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", null, "id"));

		final List<Influence> result = fixture.getInfluences();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
	}

	/**
	 * Run the String getOriginatesFrom() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetOriginatesFrom_1() throws Exception {
		final String result = fixture.getOriginatesFrom().getHREF();

		// add additional test code here
		Assert.assertEquals("href", result);
	}

	/**
	 * Run the String getRefines() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetRefines_1() throws Exception {
		final String result = fixture.getRefines().getHREF();

		// add additional test code here
		Assert.assertEquals("href", result);
	}

	/**
	 * Run the String getTitle() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetTitle_1() throws Exception {
		final String result = fixture.getTitle();

		// add additional test code here
		Assert.assertEquals("", result);
	}

	/**
	 * Run the String influenceEffect(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testInfluenceEffect_1() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", new Target("factor"), "id"));
		final Factor fac = new Factor("factor", "", null, null, "", null, "factor");

		final String result = fixture.influenceEffect(fac).toString();

		// add additional test code here
		Assert.assertEquals("POSITIVE", result);
	}

	/**
	 * Run the String influenceEffect(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testInfluenceEffect_2() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", new Target("factor"), "id"));
		final Factor fac = new Factor("factor", "", null, null, "", null, "factor");

		final String result = fixture.influenceEffect(fac).toString();

		// add additional test code here
		Assert.assertEquals("POSITIVE", result);
	}

	/**
	 * Run the String influenceEffect(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testInfluenceEffect_3() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", new Target("factor"), "id"));
		final Factor fac = new Factor("factor", "", null, null, "", null, "factor");

		final String result = fixture.influenceEffect(fac).toString();

		// add additional test code here
		Assert.assertEquals("POSITIVE", result);
	}

	/**
	 * Run the boolean influences(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testInfluences_1() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", new Target("factor"), "id"));
		final Factor fac = new Factor("factor", "", null, null, "", null, "factor");

		final boolean result = fixture.influences(fac);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean influences(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testInfluences_2() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", new Target("factor"), "id"));
		final Factor fac = new Factor("factor", "", null, null, "", null, "factor");

		final boolean result = fixture.influences(fac);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean influences(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testInfluences_3() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", new Target("factor"), "id"));
		final Factor fac = new Factor("factor", "", null, null, "", null, "factor");

		final boolean result = fixture.influences(fac);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the void removeInfluence(Influence) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveInfluence_1() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", null, "id"));
		final Influence inf = null;

		Assert.assertEquals(1, fixture.getInfluences().size());
		fixture.removeInfluence(inf);
		Assert.assertEquals(1, fixture.getInfluences().size());

		// add additional test code here
	}

	/**
	 * Run the void removeInfluence(Influence) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveInfluence_2() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", null, "id"));
		final Influence inf = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

		Assert.assertEquals(1, fixture.getInfluences().size());
		fixture.removeInfluence(inf);
		Assert.assertTrue(fixture.getInfluences().isEmpty());
	}

	/**
	 * Run the void removeInfluence(Influence) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveInfluence_3() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", null, "id"));
		final Influence inf = new Influence(InfluenceEffect.NEGATIVE, "", null, "id2");

		Assert.assertFalse(fixture.getInfluences().contains(inf));
		Assert.assertEquals(1, fixture.getInfluences().size());
		fixture.removeInfluence(inf);
		Assert.assertEquals(1, fixture.getInfluences().size());
	}

	/**
	 * Run the void setAnnotation(Annotation) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddAnnotation_1() throws Exception {
		fixture.addInfluence(new Influence(InfluenceEffect.POSITIVE, "", null, "id"));
		final Annotation annotation = new Annotation("key", "", "id");

		Assert.assertTrue(fixture.getAnnotations().isEmpty());
		fixture.addAnnotation(annotation);

		// add additional test code here
		Assert.assertFalse(fixture.getAnnotations().isEmpty());
		Assert.assertEquals(1, fixture.getAnnotations().size());
		Assert.assertTrue(fixture.getAnnotations().contains(annotation));

		fixture.addAnnotation(null);
		Assert.assertEquals(1, fixture.getAnnotations().size());

		fixture.addAnnotation(annotation);
		Assert.assertEquals(1, fixture.getAnnotations().size());
	}

	/**
	 * Run the void setCharacterises(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetCharacterises_1() throws Exception {
		final String characterises = "char";

		fixture.setCharacterizes(new Characterizes(characterises));

		// add additional test code here
		Assert.assertNotNull(fixture.getCharacterizes());
		Assert.assertEquals("char", fixture.getCharacterizes().getHREF());
	}

	/**
	 * Run the void setOriginatesFrom(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetOriginatesFrom_1() throws Exception {
		final String originatesFrom = "origin";

		fixture.setOriginatesFrom(new OriginatesFrom(originatesFrom));

		// add additional test code here
		Assert.assertNotNull(fixture.getOriginatesFrom());
		Assert.assertEquals("origin", fixture.getOriginatesFrom().getHREF());
	}

	/**
	 * Run the void setRefines(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetRefines_1() throws Exception {
		final String refines = "refine";

		fixture.setRefines(new Refines(refines));

		// add additional test code here
		Assert.assertNotNull(fixture.getRefines());
		Assert.assertEquals("refine", fixture.getRefines().getHREF());
	}

	/**
	 * Run the void setTitle(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetTitle_1() throws Exception {
		final String title = "title";

		fixture.setTitle(title);

		// add additional test code here
		Assert.assertEquals(title, fixture.getTitle());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Before
	public void setUp() throws Exception {
		final String name = "factor";
		final String description = "";
		final Characterizes characterises = new Characterizes("href");
		final OriginatesFrom originatesFrom = new OriginatesFrom("href");
		final String title = "";
		final Refines refines = new Refines("href");
		final String id = "id";

		fixture = new Factor(name, description, characterises, originatesFrom, title, refines, id);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * @generatedBy CodePro at 5/30/15 3:27 PM
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
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(FactorTest.class);
	}
}