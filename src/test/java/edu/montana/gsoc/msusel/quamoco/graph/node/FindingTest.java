/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
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

import edu.isu.isuese.datamodel.File;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.Assert;
import org.junit.Test;

/**
 * The class <code>FindingTest</code> contains tests for the class
 * <code>{@link Finding}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class FindingTest extends DBSpec {

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     */
    @Test
    public void testFinding_1() {
        final File location = File.builder().fileKey("/some/path").create();
        final String issueKey = "issueKey";
        final String issueName = "issueName";

        final Finding result = new FileFinding(location, issueKey, issueName);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("issueName", result.getIssueName());
        Assert.assertEquals("issueKey", result.getIssueKey());
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     */
    @Test
    public void testFinding_2() {
        final File location = File.builder().fileKey("/some/path").create();
        final String issueKey = "";
        final String issueName = "issueName";

        try
        {
            new FileFinding(location, issueKey, issueName);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     */
    @Test
    public void testFinding_3() {
        final File location = File.builder().fileKey("/some/path").create();
        final String issueKey = "issueKey";
        final String issueName = "";

        try
        {
            new FileFinding(location, issueKey, issueName);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFinding_4() {
        final File location = File.builder().fileKey("/some/path").create();
        final String issueKey = null;
        final String issueName = "issueName";

        new FileFinding(location, issueKey, issueName);
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFinding_5() {
        final File location = File.builder().fileKey("/some/path").create();
        final String issueKey = "issueKey";
        final String issueName = null;

        new FileFinding(location, issueKey, issueName);
    }

    /**
     * Run the Finding(CodeNode,String,String) constructor test.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFinding_6() {
        final File location = null;
        final String issueKey = "issueKey";
        final String issueName = "issueName";

        new FileFinding(location, issueKey, issueName);
    }

    /**
     * Run the String getIssueKey() method test.
     */
    @Test
    public void testGetIssueKey_1() {
        final Finding fixture = new FileFinding(File.builder().fileKey("/some/path").create(), "issueKey", "issueName");

        final String result = fixture.getIssueKey();

        // add additional test code here
        Assert.assertEquals("issueKey", result);
    }

    /**
     * Run the String getIssueName() method test.
     */
    @Test
    public void testGetIssueName_1() {
        final Finding fixture = new FileFinding(File.builder().fileKey("/some/path").create(), "issueKey", "issueName");

        final String result = fixture.getIssueName();

        // add additional test code here
        Assert.assertEquals("issueName", result);
    }

    /**
     * Run the CodeNode getLocation() method test.
     */
    @Test
    public void testGetLocation_1() {
        final FileFinding fixture = new FileFinding(File.builder().fileKey("/some/path").create(), "issueKey", "issueName");

        final File result = fixture.getLocation();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("/some/path", result.getFileKey());
//        Assert.assertEquals("FILE", result.type());
    }

    /**
     * Run the void setIssueKey(String) method test.
     */
    @Test
    public void testSetIssueKey_1() {
        final Finding fixture = new FileFinding(File.builder().fileKey("/some/path").create(), "issueKey", "issueName");
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
     */
    @Test
    public void testSetIssueName_1() {
        final Finding fixture = new FileFinding(File.builder().fileKey("/some/path").create(), "issueKey", "issueName");
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
     */
    @Test
    public void testSetLocation_1() {
        final FileFinding fixture = new FileFinding(File.builder().fileKey("/some/path").create(), "issueKey", "issueName");
        final File location = File.builder().fileKey("/some/other/path").create();

        fixture.setLocation(location);

        // add additional test code here
        Assert.assertEquals(location, fixture.getLocation());

        fixture.setLocation(null);
        Assert.assertNotNull(fixture.getLocation());
        Assert.assertEquals(location, fixture.getLocation());
    }
}