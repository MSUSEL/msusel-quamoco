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

import java.math.BigDecimal;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.codetree.node.FileNode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.processor.NullProcessor;

/**
 * The class <code>FindingNodeTest</code> contains tests for the class
 * <code>{@link FindingNode}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:38 PM
 * @author fate
 * @version $Revision: BigDecimal.ONE $
 */
public class FindingNodeTest {

    private FindingNode fixture;

    /**
     * Run the FindingNode(MutableNetwork
     * <Node,Edge>,String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testFindingNode_1() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final String key = "node";
        final String owner = "owner";
        final String ruleName = "rule";
        final String toolName = "tool";

        final FindingNode result = new FindingNode(graph, key, owner, ruleName, toolName);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("rule", result.getRuleName());
        Assert.assertEquals(null, result.getXMLTag());
        Assert.assertEquals("tool", result.getToolName());
        Assert.assertEquals(BigDecimal.ZERO, result.getValue());
        Assert.assertEquals("owner", result.getOwnedBy());
        Assert.assertEquals("", result.getDescription());
        Assert.assertEquals(null, result.getProcessor());
        Assert.assertEquals("node", result.getName());
    }

    /**
     * Run the void addFinding(Finding) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testAddFinding_1() throws Exception
    {
        Assert.assertTrue(fixture.getFindings().isEmpty());
        final Finding finding = new Finding(FileNode.builder("path").create(), "issueKey", "issueName");

        fixture.addFinding(finding);

        // add additional test code here
        Assert.assertFalse(fixture.getFindings().isEmpty());
        Assert.assertEquals(1, fixture.getFindings().size());
    }

    /**
     * Run the Set<Finding> getFindings() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetFindings_1() throws Exception
    {
        fixture.addFinding(new Finding(FileNode.builder("path").create(), "issueKey", "issueName"));
        final Set<Finding> result = fixture.getFindings();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    /**
     * Run the BigDecimal getLowerResult() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetLowerResult_1() throws Exception
    {
        final BigDecimal result = fixture.getLowerResult();

        Assert.assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Run the String getRuleName() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetRuleName_1() throws Exception
    {
        final String result = fixture.getRuleName();

        // add additional test code here
        Assert.assertEquals("rule", result);
    }

    /**
     * Run the String getToolName() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetToolName_1() throws Exception
    {
        final String result = fixture.getToolName();

        // add additional test code here
        Assert.assertEquals("tool", result);
    }

    /**
     * Run the BigDecimal getUpperResult() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetUpperResult_1() throws Exception
    {
        final BigDecimal result = fixture.getUpperResult();

        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the BigDecimal getValue() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testGetValue_1() throws Exception
    {
        final BigDecimal result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Run the void setRuleName(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:38 PM
     */
    @Test
    public void testSetRuleName_1() throws Exception
    {
        final String ruleName = "other";

        fixture.setRuleName(ruleName);

        // add additional test code here
        Assert.assertEquals(ruleName, fixture.getRuleName());
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
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        fixture = new FindingNode(graph, "node", "owner", "rule", "tool");
        fixture.processor = new NullProcessor(fixture);
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
        new org.junit.runner.JUnitCore().run(FindingNodeTest.class);
    }
}