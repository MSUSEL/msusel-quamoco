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
import edu.montana.gsoc.msusel.quamoco.model.qm.Determines;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasurementMethodType;
import edu.montana.gsoc.msusel.quamoco.model.qm.OriginatesFrom;

/**
 * The class <code>MeasurementMethodTest</code> contains tests for the class
 * <code>{@link MeasurementMethod}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:26 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class MeasurementMethodTest {

	private MeasurementMethod fixture;

	/**
	 * Run the
	 * MeasurementMethod(String,String,String,String,String,String,String,
	 * String) constructor test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testMeasurementMethod_1() throws Exception {
		final String name = "name";
		final String description = "";
		final Determines determines = new Determines("href");
		final String tool = "tool";
		final String metric = "metric";
		final OriginatesFrom originatesFrom = new OriginatesFrom("href");
		final String type = MeasurementMethodType.TOOL_INSTRUMENT;
		final String id = "id";

		final MeasurementMethod result = new MeasurementMethod(name, description, determines, tool, metric,
				originatesFrom, type, id);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("href", result.getDetermines().getHREF());
		Assert.assertEquals(tool, result.getTool());
		Assert.assertEquals("href", result.getOriginatesFrom().getHREF());
		Assert.assertEquals(metric, result.getMetric());
		Assert.assertTrue(result.getAnnotations().isEmpty());
		Assert.assertEquals(type, result.getType());
		Assert.assertEquals(description, result.getDescription());
		Assert.assertEquals(name, result.getName());
		Assert.assertEquals(id, result.getId());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("href"), "tool", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
		final MeasurementMethod obj = null;

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
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testEquals_4() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name2", "", new Determines("href"), "tool", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_5() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", null, new Determines("href"), "tool", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_6() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "desc", new Determines("href"), "tool", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_7() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", null, "tool", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_8() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("det"), "tool", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_9() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("href"), null, "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_10() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("href"), "", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_11() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("href"), "tool", null,
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_12() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("href"), "tool", "",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_13() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("href"), "tool", "metric", null,
				MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_14() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("href"), "tool", "metric",
				new OriginatesFrom("origin"), MeasurementMethodType.TOOL_INSTRUMENT, "id");

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
	public void testEquals_15() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("href"), "tool", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.MANUAL_INSTRUMENT, "id");

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
	public void testEquals_16() throws Exception {
		final MeasurementMethod obj = new MeasurementMethod("name", "", new Determines("href"), "tool", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "other");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the Annotation getAnnotation() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
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
	 * Run the String getDetermines() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetDetermines_1() throws Exception {
		final String result = fixture.getDetermines().getHREF();

		// add additional test code here
		Assert.assertEquals("href", result);
	}

	/**
	 * Run the String getMetric() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetMetric_1() throws Exception {
		final String result = fixture.getMetric();

		// add additional test code here
		Assert.assertEquals("metric", result);
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
	 * Run the String getTool() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetTool_1() throws Exception {
		final String result = fixture.getTool();

		// add additional test code here
		Assert.assertEquals("tool", result);
	}

	/**
	 * Run the String getType() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testGetType_1() throws Exception {
		final String result = fixture.getType();

		// add additional test code here
		Assert.assertEquals(MeasurementMethodType.TOOL_INSTRUMENT, result);
	}

	/**
	 * Run the void setAnnotation(Annotation) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testAddAnnotation_1() throws Exception {
		final Annotation annotation = new Annotation("key", "value", "id");

		fixture.addAnnotation(annotation);

		// add additional test code here
		Assert.assertTrue(fixture.getAnnotations().contains(annotation));
		Assert.assertEquals(1, fixture.getAnnotations().size());

		fixture.addAnnotation(null);
		Assert.assertEquals(1, fixture.getAnnotations().size());

		fixture.addAnnotation(annotation);
		Assert.assertEquals(1, fixture.getAnnotations().size());
	}

	/**
	 * Run the void setDetermines(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetDetermines_1() throws Exception {
		final String determines = "determines";

		fixture.setDetermines(new Determines(determines));

		// add additional test code here
		Assert.assertEquals(determines, fixture.getDetermines().getHREF());
	}

	/**
	 * Run the void setMetric(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetMetric_1() throws Exception {
		final String metric = "metric2";

		fixture.setMetric(metric);

		// add additional test code here
		Assert.assertEquals(metric, fixture.getMetric());
	}

	/**
	 * Run the void setOriginatesFrom(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetOriginatesFrom_1() throws Exception {
		final String originatesFrom = "origin";

		fixture.setOriginatesFrom(new OriginatesFrom(originatesFrom));

		// add additional test code here
		Assert.assertEquals(originatesFrom, fixture.getOriginatesFrom().getHREF());
	}

	/**
	 * Run the void setTool(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetTool_1() throws Exception {
		final String tool = "tool";

		fixture.setTool(tool);

		// add additional test code here
		Assert.assertEquals(tool, fixture.getTool());

		fixture.setTool(null);
		Assert.assertNull(fixture.getTool());

		fixture.setTool("");
		Assert.assertEquals("", fixture.getTool());
	}

	/**
	 * Run the void setType(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:26 PM
	 */
	@Test
	public void testSetType_1() throws Exception {
		final String type = MeasurementMethodType.TOOL_INSTRUMENT;

		fixture.setType(type);

		// add additional test code here
		Assert.assertEquals(type, fixture.getType());

		fixture.setType(null);
		Assert.assertNull(fixture.getType());

		fixture.setType("");
		Assert.assertEquals("", fixture.getType());
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
		fixture = new MeasurementMethod("name", "", new Determines("href"), "tool", "metric",
				new OriginatesFrom("href"), MeasurementMethodType.TOOL_INSTRUMENT, "id");
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
		new org.junit.runner.JUnitCore().run(MeasurementMethodTest.class);
	}
}