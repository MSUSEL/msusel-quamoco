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
package edu.montana.gsoc.msusel.quamoco.processor.aggregators;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMedianAggregator;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * The class <code>NumberMedianAggregatorTest</code> contains tests for the
 * class <code>{@link NumberMedianAggregator}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:36 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class NumberMedianAggregatorTest {

    private NumberMedianAggregator fixture;

    /**
     * Run the NumberMedianAggregator(Node) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:36 PM
     */
    @Test
    public void testNumberMedianAggregator_1() throws Exception
    {
        final Node owner = new MeasureNode(new DirectedSparseGraph<>(), "measure", "owner");

        final NumberMedianAggregator result = new NumberMedianAggregator(owner);

        // add additional test code here
        Assert.assertNotNull(result);
    }

    /**
     * Run the BigDecimal aggregate(Map<Node,BigDecimal>) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:36 PM
     */
    @Test
    public void testAggregate_1() throws Exception
    {
        final List<BigDecimal> values = Lists.newArrayList();
        values.add(new BigDecimal(10.0));
        values.add(new BigDecimal(20.0));
        values.add(new BigDecimal(3.0));
        values.add(new BigDecimal(13.0));
        values.add(new BigDecimal(25.0));

        final BigDecimal result = fixture.aggregate(values);

        // add additional test code here
        Assert.assertEquals(new BigDecimal(13.0), result);
    }

    /**
     * Run the BigDecimal aggregate(Map<Node,BigDecimal>) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:36 PM
     */
    @Test
    public void testAggregate_2() throws Exception
    {
        final List<BigDecimal> values = Lists.newArrayList();
        values.add(new BigDecimal(10.0));
        values.add(new BigDecimal(20.0));
        values.add(new BigDecimal(3.0));
        values.add(new BigDecimal(5.0));

        final BigDecimal result = fixture.aggregate(values);

        // add additional test code here
        Assert.assertEquals(new BigDecimal(7.5).setScale(5, RoundingMode.HALF_UP), result);
    }

    /**
     * Run the BigDecimal aggregate(Map<Node,BigDecimal>) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:36 PM
     */
    @Test
    public void testAggregate_3() throws Exception
    {
        final List<BigDecimal> values = Lists.newArrayList();

        final BigDecimal result = fixture.aggregate(values);

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Run the BigDecimal aggregate(Map<Node,BigDecimal>) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:36 PM
     */
    @Test
    public void testAggregate_4() throws Exception
    {
        final List<BigDecimal> values = null;

        final BigDecimal result = fixture.aggregate(values);

        // add additional test code here
        Assert.assertEquals(BigDecimal.ONE, result);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 1/26/16 6:36 PM
     */
    @Before
    public void setUp() throws Exception
    {
        final DirectedSparseGraph<Node, Edge> graph = new DirectedSparseGraph<>();
        final MeasureNode node = new MeasureNode(graph, "measure", "owner");
        fixture = new NumberMedianAggregator(node);
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 1/26/16 6:36 PM
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
     * @generatedBy CodePro at 1/26/16 6:36 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(NumberMedianAggregatorTest.class);
    }
}