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
package edu.montana.gsoc.msusel.quamoco.graph.node;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.node.FileNode;

/**
 * The class <code>FindingTest</code> contains tests for the class
 * <code>{@link Finding}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class FindingTest {

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testFinding_1() throws Exception
    {
        final INode location = FileNode.builder("/some/path").create();
        final String issueKey = "issueKey";
        final String issueName = "issueName";

        final Finding result = new Finding(location, issueKey, issueName);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("issueName", result.getIssueName());
        Assert.assertEquals("issueKey", result.getIssueKey());
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testFinding_2() throws Exception
    {
        final INode location = FileNode.builder("/some/path").create();
        final String issueKey = "";
        final String issueName = "issueName";

        try
        {
            new Finding(location, issueKey, issueName);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testFinding_3() throws Exception
    {
        final INode location = FileNode.builder("/some/path").create();
        final String issueKey = "issueKey";
        final String issueName = "";

        try
        {
            new Finding(location, issueKey, issueName);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testFinding_4() throws Exception
    {
        final INode location = FileNode.builder("/some/path").create();
        final String issueKey = null;
        final String issueName = "issueName";

        try
        {
            new Finding(location, issueKey, issueName);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testFinding_5() throws Exception
    {
        final INode location = FileNode.builder("/some/path").create();
        final String issueKey = "issueKey";
        final String issueName = null;

        try
        {
            new Finding(location, issueKey, issueName);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testFinding_6() throws Exception
    {
        final INode location = null;
        final String issueKey = "issueKey";
        final String issueName = "issueName";

        try
        {
            new Finding(location, issueKey, issueName);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testEquals_1() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");
        final Finding obj = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");

        final boolean result = fixture.equals(obj);

        System.out.println(fixture);
        System.out.println(obj);

        // add additional test code here
        Assert.assertTrue(result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testEquals_2() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");
        final Object obj = null;

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertFalse(result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testEquals_3() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");
        final Object obj = new Object();

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertFalse(result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testEquals_4() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");
        final Finding obj = new Finding(FileNode.builder("/some/path").create(), "otherKey", "issueName");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertFalse(result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testEquals_5() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");
        final Finding obj = new Finding(FileNode.builder("/some/path").create(), "issueKey", "otherName");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertFalse(result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testEquals_6() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");
        final Finding obj = new Finding(FileNode.builder("/other/path").create(), "issueKey", "issueName");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertFalse(result);
    }

    /**
     * Run the String getIssueKey() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetIssueKey_1() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");

        final String result = fixture.getIssueKey();

        // add additional test code here
        Assert.assertEquals("issueKey", result);
    }

    /**
     * Run the String getIssueName() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetIssueName_1() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");

        final String result = fixture.getIssueName();

        // add additional test code here
        Assert.assertEquals("issueName", result);
    }

    /**
     * Run the CodeNode getLocation() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetLocation_1() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");

        final INode result = fixture.getLocation();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("/some/path", result.getQIdentifier());
        Assert.assertEquals(1, ((FileNode) result).getLength());
        Assert.assertEquals("FILE", result.getType());
    }

    /**
     * Run the void setIssueKey(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetIssueKey_1() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");
        final String issueKey = "";

        fixture.setIssueKey(issueKey);

        // add additional test code here
        Assert.assertEquals("issueKey", fixture.getIssueKey());

        fixture.setIssueKey(null);
        Assert.assertEquals("issueKey", fixture.getIssueKey());

        fixture.setIssueKey("otherKey");
        Assert.assertEquals("otherKey", fixture.getIssueKey());
    }

    /**
     * Run the void setIssueName(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetIssueName_1() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");
        String issueName = "";

        fixture.setIssueName(issueName);

        Assert.assertEquals("issueName", fixture.getIssueName());

        fixture.setIssueName(null);
        Assert.assertEquals("issueName", fixture.getIssueName());

        issueName = "otherName";
        fixture.setIssueName(issueName);

        Assert.assertEquals(issueName, fixture.getIssueName());
    }

    /**
     * Run the void setLocation(CodeNode) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetLocation_1() throws Exception
    {
        final Finding fixture = new Finding(FileNode.builder("/some/path").create(), "issueKey", "issueName");
        final INode location = FileNode.builder("/some/other/path").create();

        fixture.setLocation(location);

        // add additional test code here
        Assert.assertEquals(location, fixture.getLocation());

        fixture.setLocation(null);
        Assert.assertNotNull(fixture.getLocation());
        Assert.assertEquals(location, fixture.getLocation());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Before
    public void setUp() throws Exception
    {
        // add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 1/26/16 6:38 PM
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
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(FindingTest.class);
    }
}