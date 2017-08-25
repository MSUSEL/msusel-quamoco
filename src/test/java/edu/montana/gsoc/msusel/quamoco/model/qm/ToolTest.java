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
package edu.montana.gsoc.msusel.quamoco.model.qm;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.model.qm.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.qm.OriginatesFrom;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tool;

/**
 * The class <code>ToolTest</code> contains tests for the class
 * <code>{@link Tool}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:26 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class ToolTest {

    private Tool fixture;

    /**
     * Run the Tool(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testTool_1() throws Exception
    {
        final String name = "";
        final String description = "";
        final String originatesFrom = "href";
        final String id = "";

        try
        {
            new Tool(name, description, new OriginatesFrom(originatesFrom), id);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
        }
    }

    /**
     * Run the Tool(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testTool_2() throws Exception
    {
        final String name = null;
        final String description = "";
        final String originatesFrom = "href";
        final String id = "id";

        try
        {
            new Tool(name, description, new OriginatesFrom(originatesFrom), id);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
        }
    }

    /**
     * Run the Tool(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testTool_3() throws Exception
    {
        final String name = "name";
        final String description = "";
        final String originatesFrom = "href";
        final String id = null;

        try
        {
            new Tool(name, description, new OriginatesFrom(originatesFrom), id);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
        }
    }

    /**
     * Run the Tool(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testTool_4() throws Exception
    {
        final String name = "name";
        final String description = null;
        final String originatesFrom = "href";
        final String id = "id";

        fixture = new Tool(name, description, new OriginatesFrom(originatesFrom), id);
        Assert.assertNotNull(fixture);
    }

    /**
     * Run the Tool(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testTool_5() throws Exception
    {
        final String name = "name";
        final String description = null;
        final String originatesFrom = "href";
        final String id = null;

        try
        {
            new Tool(name, description, new OriginatesFrom(originatesFrom), id);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
        }
    }

    /**
     * Run the Tool(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testTool_6() throws Exception
    {
        final String name = null;
        final String description = null;
        final String originatesFrom = "href";
        final String id = null;

        try
        {
            new Tool(name, description, new OriginatesFrom(originatesFrom), id);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {
        }
    }

    /**
     * Run the Tool(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testTool_7() throws Exception
    {
        final String name = "name";
        final String description = "";
        final String originatesFrom = "href";
        final String id = "id";

        final Tool result = new Tool(name, description, new OriginatesFrom(originatesFrom), id);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("href", result.getOriginatesFrom().getHREF());
        Assert.assertTrue(result.getAnnotations().isEmpty());
        Assert.assertEquals("", result.getDescription());
        Assert.assertEquals("name", result.getName());
        Assert.assertEquals("id", result.getId());
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testEquals_1() throws Exception
    {
        fixture.addAnnotation(new Annotation("key", "value", "id"));
        final Tool obj = new Tool("name", "", new OriginatesFrom("href"), "id");
        obj.addAnnotation(new Annotation("key", "value", "id"));

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
    public void testEquals_2() throws Exception
    {
        fixture.addAnnotation(new Annotation("key", "value", "id"));
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
    public void testEquals_3() throws Exception
    {
        fixture.addAnnotation(new Annotation("key", "value", "id"));
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
    public void testEquals_4() throws Exception
    {
        fixture.addAnnotation(new Annotation("key", "value", "id"));
        final Tool obj = new Tool("name", "", new OriginatesFrom("href"), "id");
        obj.addAnnotation(new Annotation("key", "value", "id"));

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
    public void testEquals_5() throws Exception
    {
        fixture.addAnnotation(new Annotation("key", "value", "id"));
        final Tool obj = new Tool("name", "", new OriginatesFrom("href"), "id");
        obj.addAnnotation(new Annotation("key", "value", "id"));

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
    public void testEquals_6() throws Exception
    {
        fixture.addAnnotation(new Annotation("key", "value", "id"));
        final Tool obj = new Tool("name", "", new OriginatesFrom("href"), "id");
        obj.addAnnotation(new Annotation("key", "value", "id"));

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
    public void testEquals_7() throws Exception
    {
        fixture.addAnnotation(new Annotation("key", "value", "id"));
        final Tool obj = new Tool("name", "", new OriginatesFrom("href"), "id");
        obj.addAnnotation(new Annotation("key", "value", "id"));

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
    public void testEquals_8() throws Exception
    {
        fixture.addAnnotation(new Annotation("key", "value", "id"));
        final Tool obj = new Tool("name", "", new OriginatesFrom("href"), "id");
        obj.addAnnotation(new Annotation("key", "value", "id"));

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
    public void testEquals_9() throws Exception
    {
        fixture.addAnnotation(new Annotation("key", "value", "id"));
        final Tool obj = new Tool("name", "", new OriginatesFrom("href"), "id");
        obj.addAnnotation(new Annotation("key", "value", "id"));

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the Annotation getAnnotation() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testGetAnnotation_1() throws Exception
    {
        Assert.assertTrue(fixture.getAnnotations().isEmpty());
        final Annotation ann = new Annotation("key", "value", "id");
        fixture.addAnnotation(new Annotation("key", "value", "id"));

        Assert.assertEquals(1, fixture.getAnnotations().size());
        final Annotation result = fixture.getAnnotations().get(0);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(ann, result);
    }

    /**
     * Run the String getOriginatesFrom() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testGetOriginatesFrom_1() throws Exception
    {
        Assert.assertNotNull(fixture.getOriginatesFrom());

        final OriginatesFrom originatesFrom = new OriginatesFrom("href2");
        fixture.setOriginatesFrom(originatesFrom);
        Assert.assertEquals(originatesFrom, fixture.getOriginatesFrom());
    }

    /**
     * Run the int hashCode() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testHashCode_1() throws Exception
    {
        final int result = fixture.hashCode();

        Assert.assertEquals(107825790, result);
    }

    /**
     * Run the int hashCode() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testHashCode_2() throws Exception
    {
        final int result = fixture.hashCode();

        // add additional test code here
        Assert.assertEquals(107825790, result);
    }

    /**
     * Run the void addAnnotation(Annotation) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testAddAnnotation_1() throws Exception
    {
        final Annotation annotation = new Annotation("key", "value", "id");

        Assert.assertEquals(0, fixture.getAnnotations().size());
        fixture.addAnnotation(annotation);

        Assert.assertEquals(1, fixture.getAnnotations().size());
    }

    @Test
    public void testAddAnnotation_2() throws Exception
    {
        final Annotation annotation = null;

        Assert.assertTrue(fixture.getAnnotations().isEmpty());
        fixture.addAnnotation(annotation);

        Assert.assertTrue(fixture.getAnnotations().isEmpty());
    }

    @Test
    public void testAddAnnotation_3() throws Exception
    {
        final Annotation annotation = new Annotation("key", "value", "id");

        Assert.assertTrue(fixture.getAnnotations().isEmpty());
        fixture.addAnnotation(annotation);

        Assert.assertEquals(1, fixture.getAnnotations().size());

        fixture.addAnnotation(new Annotation("key", "value", "id"));

        Assert.assertEquals(1, fixture.getAnnotations().size());
    }

    /**
     * Run the void setOriginatesFrom(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Test
    public void testSetOriginatesFrom_1() throws Exception
    {
        Assert.assertNotNull(fixture.getOriginatesFrom());
        final OriginatesFrom originatesFrom = new OriginatesFrom("href2");

        fixture.setOriginatesFrom(originatesFrom);

        Assert.assertEquals(originatesFrom, fixture.getOriginatesFrom());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @Before
    public void setUp() throws Exception
    {
        fixture = new Tool("name", "", new OriginatesFrom("href"), "id");
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    @After
    public void tearDown() throws Exception
    {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 5/30/15 3:26 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(ToolTest.class);
    }
}