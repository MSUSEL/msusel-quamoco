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

import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.qm.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Characterizes;
import edu.montana.gsoc.msusel.quamoco.model.qm.Measure;
import edu.montana.gsoc.msusel.quamoco.model.qm.OriginatesFrom;
import edu.montana.gsoc.msusel.quamoco.model.qm.Parent;
import edu.montana.gsoc.msusel.quamoco.model.qm.Refines;

/**
 * The class <code>MeasureTest</code> contains tests for the class
 * <code>{@link Measure}</code>.
 *
 * @generatedBy CodePro at 6/6/15 1:35 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class MeasureTest {

    private Measure fixture;

    /**
     * Run the
     * Measure(String,String,String,String,String,String,String,String,String)
     * constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testMeasure_1() throws Exception {
        final String name = "name";
        final String description = "";
        final String title = "title";
        final Characterizes characterises = new Characterizes("href");
        final String type = MeasureType.FINDINGS;
        final String taggedBy = "tag";
        final OriginatesFrom originatesFrom = new OriginatesFrom("href");
        final Refines refines = new Refines("href");
        final String id = "id";

        final Measure result = new Measure(name, description, title, characterises, type, taggedBy, originatesFrom,
                refines, id, false);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("tag", result.getTaggedBy());
        Assert.assertEquals("href", result.getCharacterizes().getHREF());
        Assert.assertEquals("href", result.getOriginatesFrom().getHREF());
        Assert.assertEquals("href", result.getRefines().getHREF());
        Assert.assertEquals("title", result.getTitle());
        Assert.assertEquals(MeasureType.FINDINGS, result.getType());
        Assert.assertEquals("", result.getDescription());
        Assert.assertEquals("name", result.getName());
        Assert.assertEquals("id", result.getId());
    }

    /**
     * Run the void addAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddAnnotation_1() throws Exception {
        final Annotation ann = null;

        fixture.addAnnotation(ann);

        Assert.assertTrue(fixture.getAnnotations().isEmpty());
    }

    /**
     * Run the void addAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddAnnotation_2() throws Exception {
        final Annotation ann = new Annotation("key", "value", "id");

        fixture.addAnnotation(ann);

        Assert.assertEquals(1, fixture.getAnnotations().size());
    }

    /**
     * Run the void addAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddAnnotation_3() throws Exception {
        final Annotation ann = new Annotation("key", "value", "id");

        fixture.addAnnotation(ann);
        final Annotation ann2 = new Annotation("key", "value", "id");

        fixture.addAnnotation(ann2);

        Assert.assertEquals(1, fixture.getAnnotations().size());
    }

    /**
     * Run the void addAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetAnnotations_1() throws Exception {
        final Annotation ann = new Annotation("other", "", "other");

        Assert.assertNotNull(fixture.getAnnotations());
    }

    /**
     * Run the void addAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetAnnotations_2() throws Exception {
        final Annotation ann = new Annotation("other", "", "other");

        Assert.assertNotNull(fixture.getAnnotations());
    }

    /**
     * Run the void addAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetMeasures_1() throws Exception {
        fixture.addMeasure(new Measure("", "", "", null, "", "", null, null, "id", false));

        Assert.assertNotNull(fixture.getMeasures());
        Assert.assertEquals(1, fixture.getMeasures().size());
    }

    /**
     * Run the void addAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetMeasures_2() throws Exception {
        Assert.assertNotNull(fixture.getMeasures());
    }

    /**
     * Run the void addMeasure(Measure) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddMeasure_1() throws Exception {
        final Measure measure = null;

        fixture.addMeasure(measure);

        Assert.assertTrue(fixture.getMeasures().isEmpty());
    }

    /**
     * Run the void addMeasure(Measure) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddMeasure_2() throws Exception {
        final Measure measure = new Measure("", "", "", null, "", "", null, null, "id", false);

        fixture.addMeasure(measure);

        Assert.assertEquals(1, fixture.getMeasures().size());

        fixture.addMeasure(measure);
        Assert.assertEquals(1, fixture.getMeasures().size());
    }

    /**
     * Run the void addMeasure(Measure) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddMeasure_3() throws Exception {
        final Measure measure = new Measure("", "", "", null, "", "", null, null, "id", false);

        fixture.addMeasure(measure);
        final Measure measure2 = new Measure("other", "", "", null, "", "", null, null, "other", false);

        fixture.addMeasure(measure);
        fixture.addMeasure(measure2);

        Assert.assertEquals(2, fixture.getMeasures().size());
    }

    /**
     * Run the void addParent(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddParent_1() throws Exception {
        final Parent parent = null;

        fixture.addParent(parent);

        Assert.assertTrue(fixture.getParents().isEmpty());
    }

    /**
     * Run the void addParent(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddParent_2() throws Exception {
        final String parent = "href";

        fixture.addParent(new Parent(parent));

        Assert.assertEquals(1, fixture.getParents().size());
    }

    /**
     * Run the void addParent(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddParent_3() throws Exception {
        final String parent = "parent";

        fixture.addParent(new Parent(parent));
        fixture.addParent(new Parent(parent));

        Assert.assertEquals(1, fixture.getParents().size());
    }

    /**
     * Run the void addParent(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testAddParent_4() throws Exception {
        final String parent = "other";

        fixture.addParent(new Parent(parent));
        fixture.addParent(new Parent("parent"));

        Assert.assertEquals(2, fixture.getParents().size());
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_1() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_2() throws Exception {
        final Object obj = new Measure("other", "", "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_3() throws Exception {
        final Object obj = new Measure("name", "desc", "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_4() throws Exception {
        final Object obj = new Measure("name", null, "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_5() throws Exception {
        final Object obj = new Measure("name", "", "title", null, MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_6() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("other"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_7() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("href"), MeasureType.NUMBER, "href",
                new OriginatesFrom("href"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_8() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("href"), MeasureType.FINDINGS, "other",
                new OriginatesFrom("href"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_9() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("href"), MeasureType.FINDINGS, null,
                new OriginatesFrom("href"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_10() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("other"), new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_11() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                null, new Refines("href"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_12() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), new Refines("other"), "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_13() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), null, "id", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_14() throws Exception {
        final Object obj = new Measure("name", "", "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), new Refines("href"), "other", false);

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_15() throws Exception {
        final Object obj = null;

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_16() throws Exception {
        final Object obj = new Object();

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the String getCharacterises() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetCharacterises_1() throws Exception {
        final String result = fixture.getCharacterizes().getHREF();

        // add additional test code here
        Assert.assertEquals("href", result);
    }

    /**
     * Run the String getOriginatesFrom() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetOriginatesFrom_1() throws Exception {
        final String result = fixture.getOriginatesFrom().getHREF();

        // add additional test code here
        Assert.assertEquals("href", result);
    }

    /**
     * Run the Set<String> getParents() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetParents_1() throws Exception {
        final Set<Parent> result = fixture.getParents();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    /**
     * Run the Set<String> getParents() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetParents_2() throws Exception {
        fixture.addParent(new Parent("parent"));
        final Set<Parent> result = fixture.getParents();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    /**
     * Run the String getRefines() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetRefines_1() throws Exception {
        final String result = fixture.getRefines().getHREF();

        // add additional test code here
        Assert.assertEquals("href", result);
    }

    /**
     * Run the String getTaggedBy() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetTaggedBy_1() throws Exception {
        final String result = fixture.getTaggedBy();

        // add additional test code here
        Assert.assertEquals("href", result);
    }

    /**
     * Run the String getTitle() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetTitle_1() throws Exception {
        final String result = fixture.getTitle();

        // add additional test code here
        Assert.assertEquals("title", result);
    }

    /**
     * Run the String getType() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetType_1() throws Exception {
        final String result = fixture.getType();

        // add additional test code here
        Assert.assertEquals(MeasureType.FINDINGS, result);
    }

    /**
     * Run the void removeAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testRemoveAnnotation_1() throws Exception {
        final Annotation ann = null;

        fixture.removeAnnotation(ann);

        Assert.assertTrue(fixture.getAnnotations().isEmpty());
    }

    /**
     * Run the void removeAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testRemoveAnnotation_2() throws Exception {
        final Annotation ann = new Annotation("key", "value", "id");
        fixture.addAnnotation(ann);
        fixture.removeAnnotation(ann);

        Assert.assertTrue(fixture.getAnnotations().isEmpty());
    }

    /**
     * Run the void removeAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testRemoveAnnotation_3() throws Exception {
        final Annotation ann = new Annotation("key", "", "id");
        fixture.addAnnotation(ann);

        fixture.removeAnnotation(new Annotation("other", "", "other"));

        Assert.assertFalse(fixture.getAnnotations().isEmpty());
    }

    /**
     * Run the void removeMeasure(Measure) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testRemoveMeasure_1() throws Exception {
        fixture.addMeasure(new Measure("", "", "", null, "", "", null, null, "id", false));

        final Measure measure = null;

        Assert.assertEquals(1, fixture.getMeasures().size());
        fixture.removeMeasure(measure);

        Assert.assertFalse(fixture.getMeasures().isEmpty());
    }

    /**
     * Run the void removeMeasure(Measure) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testRemoveMeasure_2() throws Exception {
        final Measure measure = new Measure("", "", "", null, "", "", null, null, "id", false);

        fixture.addMeasure(measure);
        Assert.assertEquals(1, fixture.getMeasures().size());
        fixture.removeMeasure(measure);

        Assert.assertTrue(fixture.getMeasures().isEmpty());
    }

    /**
     * Run the void removeMeasure(Measure) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testRemoveMeasure_3() throws Exception {
        fixture.addMeasure(new Measure("", "", "", null, "", "", null, null, "id", false));
        final Measure measure = new Measure("Other", "", "", null, "", "", null, null, "other", false);

        fixture.removeMeasure(measure);

        Assert.assertEquals(1, fixture.getMeasures().size());
    }

    /**
     * Run the void setCharacterises(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetCharacterises_1() throws Exception {
        final String characterises = "char";

        fixture.setCharacterizes(new Characterizes(characterises));

        Assert.assertEquals(characterises, fixture.getCharacterizes().getHREF());
    }

    /**
     * Run the void setOriginatesFrom(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetOriginatesFrom_1() throws Exception {
        final String originatesFrom = "origin";

        fixture.setOriginatesFrom(new OriginatesFrom(originatesFrom));

        Assert.assertEquals(originatesFrom, fixture.getOriginatesFrom().getHREF());
    }

    /**
     * Run the void setRefines(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetRefines_1() throws Exception {
        final String refines = "ref";

        fixture.setRefines(new Refines(refines));

        Assert.assertEquals(refines, fixture.getRefines().getHREF());
    }

    /**
     * Run the void setTaggedBy(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetTaggedBy_1() throws Exception {
        final String taggedBy = "tag";

        fixture.setTaggedBy(taggedBy);

        Assert.assertEquals(taggedBy, fixture.getTaggedBy());
    }

    /**
     * Run the void setTitle(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetTitle_1() throws Exception {
        final String title = "newTitle";

        fixture.setTitle(title);

        Assert.assertEquals(title, fixture.getTitle());
    }

    /**
     * Run the void setType(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetType_1() throws Exception {
        final String type = MeasureType.NUMBER;

        try {
            fixture.setType(type);
            Assert.assertEquals(type, fixture.getType());
        }
        catch (final IllegalArgumentException e) {
            Assert.fail();
        }
    }

    /**
     * Run the void setType(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetType_2() throws Exception {
        final String type = MeasureType.FINDINGS;

        try {
            fixture.setType(type);
            Assert.assertEquals(type, fixture.getType());
        }
        catch (final IllegalArgumentException e) {
            Assert.fail();
        }
    }

    /**
     * Run the void setType(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetType_3() throws Exception {
        final String type = null;

        try {
            fixture.setType(type);
            Assert.assertEquals(type, fixture.getType());
        }
        catch (final IllegalArgumentException e) {
            Assert.fail();
        }
    }

    /**
     * Run the void setType(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetType_4() throws Exception {
        final String type = "test";

        try {
            fixture.setType(type);
            Assert.fail();
        }
        catch (final IllegalArgumentException e) {
        }
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Before
    public void setUp() throws Exception {
        fixture = new Measure("name", "", "title", new Characterizes("href"), MeasureType.FINDINGS, "href",
                new OriginatesFrom("href"), new Refines("href"), "id", false);
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 6/6/15 1:35 PM
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
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    public static void main(final String[] args) {
        new org.junit.runner.JUnitCore().run(MeasureTest.class);
    }
}