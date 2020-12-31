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

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.isu.isuese.datamodel.File;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.processor.NullProcessor;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * The class <code>FindingNodeTest</code> contains tests for the class
 * <code>{@link FindingNode}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class FindingNodeTest extends DBSpec {

    private FindingNode fixture;

    /**
     * Run the FindingNode(MutableNetwork
     * <Node,Edge>,String,String,String,String) constructor test.
     */
    @Test
    public void testFindingNode_1() {
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
        Assert.assertNull(result.getXMLTag());
        Assert.assertEquals("tool", result.getToolName());
        Assert.assertEquals(0.0, result.getValue(), 0.001);
        Assert.assertEquals("owner", result.getOwnedBy());
        Assert.assertEquals("", result.getDescription());
        Assert.assertNull(result.getProcessor());
        Assert.assertEquals("node", result.getName());
    }

    /**
     * Run the void addFinding(Finding) method test.
     */
    @Test
    public void testAddFinding_1() {
        Assert.assertTrue(fixture.getFindings().isEmpty());
        final Finding finding = new FileFinding(File.builder().fileKey("path").create(), "issueKey", "issueName");

        fixture.addFinding(finding);

        // add additional test code here
        Assert.assertFalse(fixture.getFindings().isEmpty());
        Assert.assertEquals(1, fixture.getFindings().size());
    }

    /**
     * Run the Set<Finding> getFindings() method test.
     */
    @Test
    public void testGetFindings_1() {
        fixture.addFinding(new FileFinding(File.builder().fileKey("path").create(), "issueKey", "issueName"));
        final List<Finding> result = fixture.getFindings();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.size());
    }

    /**
     * Run the BigDecimal getLowerResult() method test.
     */
    @Test
    public void testGetLowerResult_1() {
        final double result = fixture.getLowerResult();

        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the String getRuleName() method test.
     */
    @Test
    public void testGetRuleName_1() {
        final String result = fixture.getRuleName();

        // add additional test code here
        Assert.assertEquals("rule", result);
    }

    /**
     * Run the String getToolName() method test.
     */
    @Test
    public void testGetToolName_1() {
        final String result = fixture.getToolName();

        // add additional test code here
        Assert.assertEquals("tool", result);
    }

    /**
     * Run the BigDecimal getUpperResult() method test.
     */
    @Test
    public void testGetUpperResult_1() {
        final double result = fixture.getUpperResult();

        Assert.assertEquals(1.0, result, 0.001);
    }

    /**
     * Run the BigDecimal getValue() method test.
     */
    @Test
    public void testGetValue_1() {
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the void setRuleName(String) method test.
     */
    @Test
    public void testSetRuleName_1() {
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
}