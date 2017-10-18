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

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.model.qm.AbstractQMEntity;
import edu.montana.gsoc.msusel.quamoco.model.qm.Entity;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Factor;
import edu.montana.gsoc.msusel.quamoco.model.qm.Measure;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasurementMethodType;
import edu.montana.gsoc.msusel.quamoco.model.qm.OriginatesFrom;
import edu.montana.gsoc.msusel.quamoco.model.qm.QualityModel;
import edu.montana.gsoc.msusel.quamoco.model.qm.Ranking;
import edu.montana.gsoc.msusel.quamoco.model.qm.Requires;
import edu.montana.gsoc.msusel.quamoco.model.qm.Source;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tag;
import edu.montana.gsoc.msusel.quamoco.model.qm.TaggedBy;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tool;

/**
 * The class <code>QualityModelTest</code> contains tests for the class
 * <code>{@link QualityModel}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:27 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class QualityModelTest {

	private QualityModel fixture;

	/**
	 * Run the QualityModel(String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testQualityModel_1() throws Exception {
		final String name = null;
		final String description = "desc";
		final String originatesFrom = "href";
		final String taggedBy = "tag";
		final String id = "id";

		try {
			new QualityModel(name, description, new OriginatesFrom(originatesFrom), new TaggedBy(taggedBy), id);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
		}
	}

	/**
	 * Run the QualityModel(String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testQualityModel_2() throws Exception {
		final String name = "";
		final String description = "desc";
		final String originatesFrom = "href";
		final String taggedBy = "tag";
		final String id = "id";

		try {
			new QualityModel(name, description, new OriginatesFrom(originatesFrom), new TaggedBy(taggedBy), id);

			Assert.fail();
		} catch (final IllegalArgumentException e) {
		}
	}

	/**
	 * Run the QualityModel(String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testQualityModel_3() throws Exception {
		final String name = "name";
		final String description = "desc";
		final String originatesFrom = "href";
		final String taggedBy = "tag";
		final String id = null;

		try {
			new QualityModel(name, description, new OriginatesFrom(originatesFrom), new TaggedBy(taggedBy), id);

			Assert.fail();
		} catch (final IllegalArgumentException e) {
		}
	}

	/**
	 * Run the QualityModel(String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testQualityModel_4() throws Exception {
		final String name = "name";
		final String description = "desc";
		final String originatesFrom = "href";
		final String taggedBy = "tag";
		final String id = "";

		try {
			new QualityModel(name, description, new OriginatesFrom(originatesFrom), new TaggedBy(taggedBy), id);

			Assert.fail();
		} catch (final IllegalArgumentException e) {
		}
	}

	/**
	 * Run the QualityModel(String,String,String,String,String) constructor
	 * test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testQualityModel_5() throws Exception {
		final String name = "name";
		final String description = "desc";
		final String originatesFrom = "href";
		final String taggedBy = "tag";
		final String id = "id";

		try {
			final QualityModel result = new QualityModel(name, description, new OriginatesFrom(originatesFrom),
					new TaggedBy(taggedBy), id);

			// add additional test code here
			Assert.assertNotNull(result);
			Assert.assertEquals("tag", result.getTaggedBy().getHREF());
			Assert.assertEquals("href", result.getOriginatesFrom().getHREF());
			Assert.assertEquals("desc", result.getDescription());
			Assert.assertEquals("name", result.getName());
			Assert.assertEquals("id", result.getId());
		} catch (final IllegalArgumentException e) {
			Assert.fail();
		}
	}

	/**
	 * Run the void addEntity(Entity) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddEntity_1() throws Exception {
		final Entity ent = null;

		Assert.assertTrue(fixture.getEntities().isEmpty());
		fixture.addEntity(ent);

		// add additional test code here
		Assert.assertTrue(fixture.getEntities().isEmpty());
	}

	/**
	 * Run the void addEntity(Entity) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddEntity_2() throws Exception {
		final Entity ent = new Entity("name", "", null, "", "id", null);

		Assert.assertTrue(fixture.getEntities().isEmpty());
		fixture.addEntity(ent);

		// add additional test code here
		Assert.assertFalse(fixture.getEntities().isEmpty());
	}

	/**
	 * Run the void addEntity(Entity) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddEntity_3() throws Exception {
		final Entity ent = new Entity("name", "", null, "", "id", null);
		fixture.addEntity(new Entity("name", "", null, "", "id", null));

		Assert.assertFalse(fixture.getEntities().isEmpty());
		Assert.assertEquals(1, fixture.getEntities().size());
		fixture.addEntity(ent);

		// add additional test code here
		Assert.assertFalse(fixture.getEntities().isEmpty());
		Assert.assertEquals(1, fixture.getEntities().size());
	}

	/**
	 * Run the void addEvaluation(Evaluation) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddEvaluation_1() throws Exception {
		final Evaluation eval = null;

		fixture.addEvaluation(eval);

		// add additional test code here
		Assert.assertTrue(fixture.getEvaluations().isEmpty());
	}

	/**
	 * Run the void addEvaluation(Evaluation) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddEvaluation_2() throws Exception {
		final Evaluation eval = new Evaluation("name", "", "", BigDecimal.ONE, "", null, "", "id");

		fixture.addEvaluation(eval);

		// add additional test code here
		Assert.assertFalse(fixture.getEvaluations().isEmpty());
		Assert.assertEquals(1, fixture.getEvaluations().size());
	}

	/**
	 * Run the void addEvaluation(Evaluation) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddEvaluation_3() throws Exception {
		final Evaluation eval = new Evaluation("name", "", "", BigDecimal.ONE, "", null, "", "id");

		fixture.addEvaluation(eval);

		// add additional test code here
		Assert.assertFalse(fixture.getEvaluations().isEmpty());
		Assert.assertEquals(1, fixture.getEvaluations().size());

		fixture.addEvaluation(eval);

		Assert.assertFalse(fixture.getEvaluations().isEmpty());
		Assert.assertEquals(1, fixture.getEvaluations().size());
	}

	/**
	 * Run the void addFactor(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddFactor_1() throws Exception {
		final Factor fac = null;

		fixture.addFactor(fac);

		// add additional test code here
		Assert.assertTrue(fixture.getFactors().isEmpty());
	}

	/**
	 * Run the void addFactor(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddFactor_2() throws Exception {
		final Factor fac = new Factor("factor", "", null, null, "", null, "factor");

		fixture.addFactor(fac);

		// add additional test code here
		Assert.assertFalse(fixture.getFactors().isEmpty());
		Assert.assertEquals(1, fixture.getFactors().size());
	}

	/**
	 * Run the void addFactor(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddFactor_3() throws Exception {
		final Factor fac = new Factor("factor", "", null, null, "", null, "factor");

		fixture.addFactor(fac);

		// add additional test code here
		Assert.assertFalse(fixture.getFactors().isEmpty());
		Assert.assertEquals(1, fixture.getFactors().size());

		fixture.addFactor(fac);

		Assert.assertFalse(fixture.getFactors().isEmpty());
		Assert.assertEquals(1, fixture.getFactors().size());
	}

	/**
	 * Run the void addMeasure(Measure) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddMeasure_1() throws Exception {
		final Measure meas = null;

		Assert.assertTrue(fixture.getMeasures().isEmpty());
		fixture.addMeasure(meas);

		// add additional test code here
		Assert.assertTrue(fixture.getMeasures().isEmpty());
	}

	/**
	 * Run the void addMeasure(Measure) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddMeasure_2() throws Exception {
		final Measure meas = new Measure("name", "", "", null, "", "", null, null, "id", false);

		Assert.assertTrue(fixture.getMeasures().isEmpty());
		fixture.addMeasure(meas);

		// add additional test code here
		Assert.assertFalse(fixture.getMeasures().isEmpty());
	}

	/**
	 * Run the void addMeasure(Measure) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddMeasure_3() throws Exception {
		final Measure meas = new Measure("name", "", "", null, "", "", null, null, "id", false);

		Assert.assertTrue(fixture.getMeasures().isEmpty());
		fixture.addMeasure(meas);

		// add additional test code here
		Assert.assertFalse(fixture.getMeasures().isEmpty());

		fixture.addMeasure(meas);

		Assert.assertFalse(fixture.getMeasures().isEmpty());
		Assert.assertEquals(1, fixture.getMeasures().size());
	}

	/**
	 * Run the void addMethod(MeasurementMethod) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddMethod_1() throws Exception {
		final MeasurementMethod mm = null;

		Assert.assertTrue(fixture.getMethods().isEmpty());
		fixture.addMethod(mm);

		// add additional test code here
		Assert.assertTrue(fixture.getMethods().isEmpty());
	}

	/**
	 * Run the void addMethod(MeasurementMethod) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddMethod_2() throws Exception {
		final MeasurementMethod mm = new MeasurementMethod("name", "", null, "", "", null,
				MeasurementMethodType.FINDINGS_UNION, "id");

		Assert.assertTrue(fixture.getMethods().isEmpty());
		fixture.addMethod(mm);

		// add additional test code here
		Assert.assertFalse(fixture.getMethods().isEmpty());
	}

	/**
	 * Run the void addMethod(MeasurementMethod) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddMethod_3() throws Exception {
		final MeasurementMethod mm = new MeasurementMethod("name", "", null, "", "", null,
				MeasurementMethodType.FINDINGS_UNION, "id");

		Assert.assertTrue(fixture.getMethods().isEmpty());
		fixture.addMethod(mm);

		// add additional test code here
		Assert.assertFalse(fixture.getMethods().isEmpty());
		Assert.assertEquals(1, fixture.getMethods().size());

		fixture.addMethod(mm);
		Assert.assertFalse(fixture.getMethods().isEmpty());
		Assert.assertEquals(1, fixture.getMethods().size());
	}

	/**
	 * Run the void addRequires(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddRequires_1() throws Exception {
		final Requires req = null;

		fixture.addRequires(req);

		Assert.assertTrue(fixture.getRequires().isEmpty());
	}

	/**
	 * Run the void addRequires(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddRequires_2() throws Exception {
		final Requires req = new Requires("href");

		fixture.addRequires(req);

		// add additional test code here
		Assert.assertFalse(fixture.getRequires().isEmpty());
		Assert.assertTrue(fixture.getRequires().contains(req));
	}

	/**
	 * Run the void addRequires(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddRequires_3() throws Exception {
		final Requires req = new Requires("href");

		fixture.addRequires(req);
		Assert.assertFalse(fixture.getRequires().isEmpty());
		Assert.assertTrue(fixture.getRequires().contains(req));
		Assert.assertEquals(1, fixture.getRequires().size());
		fixture.addRequires(req);
		Assert.assertEquals(1, fixture.getRequires().size());
	}

	/**
	 * Run the void addRequires(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddRequires_4() throws Exception {
		final Requires req = new Requires("href");
		final Requires req2 = new Requires("href2");

		fixture.addRequires(req);
		Assert.assertFalse(fixture.getRequires().isEmpty());
		Assert.assertTrue(fixture.getRequires().contains(req));
		Assert.assertEquals(1, fixture.getRequires().size());
		fixture.addRequires(req2);
		Assert.assertEquals(2, fixture.getRequires().size());
		Assert.assertTrue(fixture.getRequires().contains(req2));
	}

	/**
	 * Run the void addSource(Source) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddSource_1() throws Exception {
		final Source src = null;

		Assert.assertTrue(fixture.getSources().isEmpty());
		fixture.addSource(src);

		// add additional test code here
		Assert.assertTrue(fixture.getSources().isEmpty());
	}

	/**
	 * Run the void addSource(Source) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddSource_2() throws Exception {
		final Source src = new Source("name", "", "id");

		Assert.assertTrue(fixture.getSources().isEmpty());
		fixture.addSource(src);

		// add additional test code here
		Assert.assertFalse(fixture.getSources().isEmpty());
	}

	/**
	 * Run the void addSource(Source) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddSource_3() throws Exception {
		final Source src = new Source("name", "", "id");

		Assert.assertTrue(fixture.getSources().isEmpty());
		fixture.addSource(src);

		// add additional test code here
		Assert.assertFalse(fixture.getSources().isEmpty());

		fixture.addSource(src);

		Assert.assertFalse(fixture.getSources().isEmpty());
		Assert.assertEquals(1, fixture.getSources().size());
	}

	/**
	 * Run the void addTag(Tag) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddTag_1() throws Exception {
		final Tag tag = null;

		Assert.assertTrue(fixture.getTags().isEmpty());
		fixture.addTag(tag);

		// add additional test code here
		Assert.assertTrue(fixture.getTags().isEmpty());
	}

	/**
	 * Run the void addTag(Tag) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddTag_2() throws Exception {
		final Tag tag = new Tag("name", "", "id");

		fixture.addTag(tag);

		// add additional test code here
		Assert.assertEquals(1, fixture.getTags().size());
		fixture.addTag(tag);
		Assert.assertEquals(1, fixture.getTags().size());
	}

	/**
	 * Run the void addTag(Tag) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddTag_3() throws Exception {
		final Tag tag = new Tag("name", "", "id");

		fixture.addTag(tag);

		// add additional test code here
		Assert.assertEquals(1, fixture.getTags().size());
	}

	/**
	 * Run the void addTool(Tool) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddTool_1() throws Exception {
		final Tool tool = null;

		Assert.assertTrue(fixture.getTools().isEmpty());
		fixture.addTool(tool);

		// add additional test code here
		Assert.assertTrue(fixture.getTools().isEmpty());
	}

	/**
	 * Run the void addTool(Tool) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddTool_2() throws Exception {
		final Tool tool = new Tool("name", "", null, "id");

		Assert.assertTrue(fixture.getTools().isEmpty());
		fixture.addTool(tool);

		// add additional test code here
		Assert.assertFalse(fixture.getTools().isEmpty());
		Assert.assertTrue(fixture.getTools().contains(tool));
	}

	/**
	 * Run the void addTool(Tool) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testAddTool_3() throws Exception {
		final Tool tool = new Tool("name", "", null, "id");

		Assert.assertTrue(fixture.getTools().isEmpty());
		fixture.addTool(tool);

		// add additional test code here
		Assert.assertFalse(fixture.getTools().isEmpty());
		Assert.assertTrue(fixture.getTools().contains(tool));

		fixture.addTool(tool);
		Assert.assertEquals(1, fixture.getTools().size());
	}

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final QualityModel obj = new QualityModel("name", "description", new OriginatesFrom("href"),
				new TaggedBy("tag"), "id");

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
	 * @generatedBy CodePro at 5/30/15 3:27 PM
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
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testEquals_4() throws Exception {
		final Object obj = new QualityModel("name2", "description", new OriginatesFrom("href"), new TaggedBy("tag"),
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
	public void testEquals_5() throws Exception {
		final Object obj = new QualityModel("name", "description", new OriginatesFrom("href"), new TaggedBy("tag"),
				"id2");

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
		final Object obj = new QualityModel("name", "", new OriginatesFrom("href"), new TaggedBy("tag"), "id");

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
		final Object obj = new QualityModel("name", "description", new OriginatesFrom("origin"), new TaggedBy("tag"),
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
	public void testEquals_8() throws Exception {
		final Object obj = new QualityModel("name", "description", new OriginatesFrom("href"), new TaggedBy("other"),
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
	public void testEquals_9() throws Exception {
		final Object obj = new QualityModel("name", null, new OriginatesFrom("href"), new TaggedBy("other"), "id");

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
		final Object obj = new QualityModel("name", "description", null, new TaggedBy("other"), "id");

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
		final Object obj = new QualityModel("name", "description", new OriginatesFrom("href"), null, "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the AbstractQMEntity find(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testFind_1() throws Exception {
		fixture.addEntity(new Entity("name", "", null, "", "entity", null));
		final String id = "entity";

		try {
			final AbstractQMEntity result = fixture.find(id);

			// add additional test code here
			Assert.assertNotNull(result);
			Assert.assertEquals("", result.getDescription());
			Assert.assertEquals("name", result.getName());
			Assert.assertEquals(id, result.getId());
		} catch (final IllegalArgumentException e) {
			Assert.fail();
		}
	}

	/**
	 * Run the AbstractQMEntity find(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testFind_2() throws Exception {
		fixture.addEntity(new Entity("name", "", null, "", "entity", null));

		try {
			fixture.find("");
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}
	}

	/**
	 * Run the AbstractQMEntity find(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testFind_3() throws Exception {
		fixture.addEntity(new Entity("name", "", null, "", "entity", null));

		try {
			fixture.find(null);
			Assert.fail();
		} catch (final IllegalArgumentException e) {

		}
	}

	/**
	 * Run the List<AbstractQMEntity> getContained() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetContained_1() throws Exception {
		fixture.addEntity(new Entity("entity", "", null, "", "entity", null));
		fixture.addFactor(new Factor("factor", "", null, null, "", null, "factor"));
		final List<AbstractQMEntity> result = fixture.getContained();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
	}

	/**
	 * Run the String getDescription() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetDescription_1() throws Exception {
		final String result = fixture.getDescription();

		// add additional test code here
		Assert.assertEquals("description", result);
	}

	/**
	 * Run the List<Evaluation> getEvaluations() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetEvaluations_1() throws Exception {
		final List<Evaluation> result = fixture.getEvaluations();
		fixture.addEvaluation(new Evaluation("name", "", "", BigDecimal.ONE, "", null, "", "id"));

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
	}

	/**
	 * Run the List<Factor> getFactors() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetFactors_1() throws Exception {
		fixture.addFactor(new Factor("name", "", null, null, "", null, "id"));
		final List<Factor> result = fixture.getFactors();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetId_1() throws Exception {
		final String result = fixture.getId();

		// add additional test code here
		Assert.assertEquals("id", result);
	}

	/**
	 * Run the List<Measure> getMeasures() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetMeasures_1() throws Exception {
		fixture.addMeasure(new Measure("name", "", "", null, null, null, null, null, "id", false));
		final List<Measure> result = fixture.getMeasures();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
	}

	/**
	 * Run the List<MeasurementMethod> getMethods() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetMethods_1() throws Exception {
		final List<MeasurementMethod> result = fixture.getMethods();
		fixture.addMethod(
				new MeasurementMethod("name", "", null, "", "", null, MeasurementMethodType.FINDINGS_UNION, "id"));

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(1, result.size());
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetName_1() throws Exception {
		final String result = fixture.getName();

		// add additional test code here
		Assert.assertEquals("name", result);
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
	 * Run the String getTaggedBy() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testGetTaggedBy_1() throws Exception {
		final String result = fixture.getTaggedBy().getHREF();

		// add additional test code here
		Assert.assertEquals("tag", result);
	}

	/**
	 * Run the boolean hasKey(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testHasKey_1() throws Exception {
		fixture.addTool(new Tool("name", "", null, "tool1"));
		final String id = "tool1";

		final boolean result = fixture.hasKey(id);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the boolean hasKey(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testHasKey_2() throws Exception {
		final String id = null;

		final boolean result = fixture.hasKey(id);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the boolean hasKey(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testHasKey_3() throws Exception {
		final String id = "";

		final boolean result = fixture.hasKey(id);

		// add additional test code here
		Assert.assertEquals(false, result);
	}

	/**
	 * Run the void removeEntity(Entity) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveEntity_1() throws Exception {
		fixture.addEntity(new Entity("name", "", null, "", "id", null));
		final Entity ent = null;

		Assert.assertFalse(fixture.getEntities().isEmpty());
		fixture.removeEntity(ent);

		// add additional test code here
		Assert.assertFalse(fixture.getEntities().isEmpty());
	}

	/**
	 * Run the void removeEntity(Entity) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveEntity_2() throws Exception {
		final Entity ent = new Entity("name", "", null, "", "id", null);
		fixture.addEntity(ent);

		Assert.assertFalse(fixture.getEntities().isEmpty());
		fixture.removeEntity(ent);

		// add additional test code here
		Assert.assertTrue(fixture.getEntities().isEmpty());
	}

	/**
	 * Run the void removeEntity(Entity) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveEntity_3() throws Exception {
		final Entity ent = new Entity("name", "", null, "", "id", null);
		final Entity ent2 = new Entity("name2", "", null, "", "id2", null);
		fixture.addEntity(ent);

		Assert.assertFalse(fixture.getEntities().isEmpty());
		fixture.removeEntity(ent2);

		// add additional test code here
		Assert.assertFalse(fixture.getEntities().isEmpty());
	}

	@Test
	public void testGetEntities_1() throws Exception {
		fixture.addEntity(new Entity("name", "", null, "", "id", null));

		final List<Entity> result = fixture.getEntities();

		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
	}

	/**
	 * Run the void removeEvaluation(Evaluation) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveEvaluation_1() throws Exception {
		final Evaluation eval = null;
		fixture.addEvaluation(new Evaluation("name", "", "", new BigDecimal(3.0), "", null, "", "id"));

		Assert.assertEquals(1, fixture.getEvaluations().size());
		fixture.removeEvaluation(eval);

		// add additional test code here
		Assert.assertFalse(fixture.getEvaluations().isEmpty());
	}

	/**
	 * Run the void removeEvaluation(Evaluation) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveEvaluation_2() throws Exception {
        final Evaluation eval = new Evaluation("name", "", "", new BigDecimal(3.0), "", null, "", "id");
		fixture.addEvaluation(eval);

		Assert.assertEquals(1, fixture.getEvaluations().size());
		fixture.removeEvaluation(eval);

		// add additional test code here
		Assert.assertTrue(fixture.getEvaluations().isEmpty());
	}

	/**
	 * Run the void removeEvaluation(Evaluation) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveEvaluation_3() throws Exception {
		final Evaluation eval = new Evaluation("name", "", "", BigDecimal.ONE, "", null, "", "id");
		eval.addRanking(new Ranking("ranking", "NA", "", null, null, null, "name", "rid"));

		fixture.addEvaluation(eval);

		Assert.assertFalse(fixture.getEvaluations().isEmpty());
		Assert.assertEquals(1, fixture.getContained().size());
		fixture.removeEvaluation(eval);

		// add additional test code here
		Assert.assertTrue(fixture.getEvaluations().isEmpty());
		Assert.assertTrue(fixture.getContained().isEmpty());
	}

	/**
	 * Run the void removeEvaluation(Evaluation) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveEvaluation_4() throws Exception {
		final Evaluation eval = new Evaluation("name", "", "", BigDecimal.ONE, "", null, "", "id");
		eval.addRanking(new Ranking("ranking", "NA", "", null, null, null, "name", "rid"));
        final Evaluation eval2 = new Evaluation("other", "", "", BigDecimal.ONE, "", null, "", "id2");

		fixture.addEvaluation(eval);

		Assert.assertFalse(fixture.getEvaluations().isEmpty());
		Assert.assertEquals(1, fixture.getContained().size());
		fixture.removeEvaluation(eval2);

		// add additional test code here
		Assert.assertFalse(fixture.getEvaluations().isEmpty());
		Assert.assertFalse(fixture.getContained().isEmpty());
	}

	/**
	 * Run the void removeFactor(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveFactor_1() throws Exception {
		final Factor fac = null;

		fixture.addFactor(new Factor("name", "", null, null, "", null, "id"));
		Assert.assertEquals(1, fixture.getFactors().size());
		fixture.removeFactor(fac);

		// add additional test code here
		Assert.assertFalse(fixture.getFactors().isEmpty());
	}

	/**
	 * Run the void removeFactor(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveFactor_2() throws Exception {
		final Factor fac = new Factor("name", "", null, null, "", null, "id");
		fixture.addFactor(fac);

		Assert.assertFalse(fixture.getFactors().isEmpty());
		fixture.removeFactor(fac);

		// add additional test code here
		Assert.assertTrue(fixture.getFactors().isEmpty());
	}

	/**
	 * Run the void removeFactor(Factor) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveFactor_3() throws Exception {
		final Factor fac = new Factor("name", "", null, null, "", null, "id");
		fixture.addFactor(new Factor("other", "", null, null, "", null, "other_id"));

		Assert.assertFalse(fixture.getFactors().isEmpty());
		fixture.removeFactor(fac);

		// add additional test code here
		Assert.assertFalse(fixture.getFactors().isEmpty());
	}

	/**
	 * Run the void removeMeasure(Measure) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveMeasure_1() throws Exception {
		Measure meas = new Measure("", "", "", null, "", "", null, null, "id", false);
		fixture.addMeasure(meas);
		meas = null;

		Assert.assertFalse(fixture.getMeasures().isEmpty());
		fixture.removeMeasure(meas);
		Assert.assertFalse(fixture.getMeasures().isEmpty());
	}

	/**
	 * Run the void removeMeasure(Measure) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveMeasure_2() throws Exception {
		final Measure meas = new Measure("", "", "", null, "", "", null, null, "id", false);
		fixture.addMeasure(meas);
		Assert.assertFalse(fixture.getMeasures().isEmpty());
		fixture.removeMeasure(meas);
		Assert.assertTrue(fixture.getMeasures().isEmpty());
	}

	/**
	 * Run the void removeMeasure(Measure) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveMeasure_3() throws Exception {
		final Measure meas = new Measure("", "", "", null, "", "", null, null, "id", false);

		fixture.addMeasure(new Measure("name", "", "", null, "", "", null, null, "id", false));
		Assert.assertFalse(fixture.getMeasures().isEmpty());
		fixture.removeMeasure(meas);
		Assert.assertFalse(fixture.getMeasures().isEmpty());
	}

	/**
	 * Run the void removeMethod(MeasurementMethod) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveMethod_1() throws Exception {
		final MeasurementMethod mm = null;

		fixture.addMethod(
				new MeasurementMethod("name", "", null, null, "", null, MeasurementMethodType.TOOL_INSTRUMENT, "id"));
		Assert.assertEquals(1, fixture.getMethods().size());
		fixture.removeMethod(mm);

		// add additional test code here
		Assert.assertEquals(1, fixture.getMethods().size());
	}

	/**
	 * Run the void removeMethod(MeasurementMethod) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveMethod_2() throws Exception {
		final MeasurementMethod mm = new MeasurementMethod("name", "", null, null, "", null,
				MeasurementMethodType.TOOL_INSTRUMENT, "id");

		fixture.addMethod(mm);
		Assert.assertEquals(1, fixture.getMethods().size());
		fixture.removeMethod(mm);

		// add additional test code here
		Assert.assertTrue(fixture.getMethods().isEmpty());
	}

	/**
	 * Run the void removeMethod(MeasurementMethod) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveMethod_3() throws Exception {
		final MeasurementMethod mm = new MeasurementMethod("name", "", null, null, "", null,
				MeasurementMethodType.TOOL_INSTRUMENT, "id");

		fixture.addMethod(mm);
		final MeasurementMethod mm2 = new MeasurementMethod("other", "", null, null, "", null,
				MeasurementMethodType.TOOL_INSTRUMENT, "other");
		Assert.assertEquals(1, fixture.getMethods().size());
		fixture.removeMethod(mm2);

		// add additional test code here
		Assert.assertFalse(fixture.getMethods().isEmpty());
		Assert.assertEquals(1, fixture.getMethods().size());
	}

	/**
	 * Run the void removeRequires(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveRequires_1() throws Exception {
		final Requires req = null;

		Assert.assertTrue(fixture.getRequires().isEmpty());
		fixture.removeRequires(req);

		// add additional test code here
		Assert.assertTrue(fixture.getRequires().isEmpty());
	}

	/**
	 * Run the void removeRequires(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveRequires_2() throws Exception {
		final Requires req = new Requires("href");
		fixture.addRequires(req);

		Assert.assertFalse(fixture.getRequires().isEmpty());
		fixture.removeRequires(req);

		// add additional test code here
		Assert.assertTrue(fixture.getRequires().isEmpty());
	}

	/**
	 * Run the void removeRequires(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveRequires_3() throws Exception {
		final Requires req = new Requires("href");
		final Requires req2 = new Requires("other");
		fixture.addRequires(req);

		Assert.assertFalse(fixture.getRequires().isEmpty());
		fixture.removeRequires(req2);

		// add additional test code here
		Assert.assertFalse(fixture.getRequires().isEmpty());
	}

	/**
	 * Run the void removeSource(Source) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveSource_1() throws Exception {
		fixture.addSource(new Source("name", "", "id"));
		final Source src = null;

		Assert.assertFalse(fixture.getSources().isEmpty());
		fixture.removeSource(src);

		// add additional test code here
		Assert.assertFalse(fixture.getSources().isEmpty());
	}

	/**
	 * Run the void removeSource(Source) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveSource_2() throws Exception {
		fixture.addSource(new Source("name", "", "id"));
		final Source src = new Source("name", "", "id");

		Assert.assertFalse(fixture.getSources().isEmpty());
		fixture.removeSource(src);

		// add additional test code here
		Assert.assertTrue(fixture.getSources().isEmpty());
	}

	/**
	 * Run the void removeSource(Source) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveSource_3() throws Exception {
		fixture.addSource(new Source("name", "", "id"));
		final Source src = new Source("other", "", "other");

		Assert.assertFalse(fixture.getSources().isEmpty());
		fixture.removeSource(src);

		// add additional test code here
		Assert.assertFalse(fixture.getSources().isEmpty());
	}

	/**
	 * Run the void removeTag(AbstractQMEntity) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveTag_1() throws Exception {
		final Tag tag = null;

		fixture.addTag(new Tag("name", "", "id"));
		Assert.assertEquals(1, fixture.getTags().size());
		fixture.removeTag(tag);

		// add additional test code here
		Assert.assertEquals(1, fixture.getTags().size());
	}

	/**
	 * Run the void removeTag(AbstractQMEntity) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveTag_2() throws Exception {
		final Tag tag = new Tag("name", "", "id");
		fixture.addTag(tag);

		Assert.assertEquals(1, fixture.getTags().size());
		fixture.removeTag(tag);

		// add additional test code here
		Assert.assertTrue(fixture.getTags().isEmpty());
	}

	/**
	 * Run the void removeTag(AbstractQMEntity) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveTag_3() throws Exception {
		final Tag tag = new Tag("name", "", "id");

		fixture.addTag(new Tag("other", "", "id"));
		Assert.assertEquals(1, fixture.getTags().size());
		fixture.removeTag(tag);

		// add additional test code here
		Assert.assertFalse(fixture.getTags().isEmpty());
	}

	/**
	 * Run the void removeTool(Tool) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveTool_1() throws Exception {
		final Tool tool = null;
		fixture.addTool(new Tool("name", "", null, "id"));

		Assert.assertFalse(fixture.getTools().isEmpty());
		fixture.removeTool(tool);

		// add additional test code here
		Assert.assertFalse(fixture.getTools().isEmpty());
	}

	/**
	 * Run the void removeTool(Tool) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveTool_2() throws Exception {
		final Tool tool = new Tool("name", "", null, "id");

		fixture.addTool(tool);

		Assert.assertFalse(fixture.getTools().isEmpty());
		fixture.removeTool(tool);

		// add additional test code here
		Assert.assertTrue(fixture.getTools().isEmpty());
	}

	/**
	 * Run the void removeTool(Tool) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testRemoveTool_3() throws Exception {
		final Tool tool = new Tool("name", "", null, "id");

		fixture.addTool(new Tool("other", "", null, "id2"));

		Assert.assertFalse(fixture.getTools().isEmpty());
		fixture.removeTool(tool);

		// add additional test code here
		Assert.assertFalse(fixture.getTools().isEmpty());
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetDescription_1() throws Exception {
		final String description = "";

		fixture.setDescription(description);

		// add additional test code here
		Assert.assertEquals(description, fixture.getDescription());
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetDescription_2() throws Exception {
		final String description = null;

		fixture.setDescription(description);

		// add additional test code here
		Assert.assertEquals("", fixture.getDescription());
	}

	/**
	 * Run the void setDescription(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetDescription_3() throws Exception {
		final String description = "other";

		fixture.setDescription(description);

		// add additional test code here
		Assert.assertEquals(description, fixture.getDescription());
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetId_1() throws Exception {
		final String id = "";
		final String oldId = fixture.getId();

		try {
			fixture.setId(id);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
			Assert.assertEquals(oldId, fixture.getId());
		}
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetId_2() throws Exception {
		final String id = null;
		final String oldId = fixture.getId();

		try {
			fixture.setId(id);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
			Assert.assertEquals(oldId, fixture.getId());
		}
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetId_3() throws Exception {
		final String id = "newID";

		try {
			fixture.setId(id);
			Assert.assertEquals(id, fixture.getId());
		} catch (final IllegalArgumentException e) {
			Assert.fail();
		}
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetName_1() throws Exception {
		final String name = "";
		final String oldName = fixture.getName();

		try {
			fixture.setName(name);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
			Assert.assertEquals(oldName, fixture.getName());
		}
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetName_2() throws Exception {
		final String name = null;
		final String oldName = fixture.getName();

		try {
			fixture.setName(name);
			Assert.fail();
		} catch (final IllegalArgumentException e) {
			Assert.assertEquals(oldName, fixture.getName());
		}
	}

	/**
	 * Run the void setName(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetName_3() throws Exception {
		final String name = "newName";
		final String oldName = fixture.getName();

		try {
			fixture.setName(name);
			Assert.assertEquals(name, fixture.getName());
			Assert.assertNotEquals(name, oldName);
		} catch (final IllegalArgumentException e) {
			Assert.fail();
		}
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

		Assert.assertEquals(originatesFrom, fixture.getOriginatesFrom().getHREF());
	}

	/**
	 * Run the void setTaggedBy(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:27 PM
	 */
	@Test
	public void testSetTaggedBy_1() throws Exception {
		final String taggedBy = "tagged";

		fixture.setTaggedBy(new TaggedBy(taggedBy));

		Assert.assertEquals(taggedBy, fixture.getTaggedBy().getHREF());
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
		fixture = new QualityModel("name", "description", new OriginatesFrom("href"), new TaggedBy("tag"), "id");
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
		new org.junit.runner.JUnitCore().run(QualityModelTest.class);
	}
}