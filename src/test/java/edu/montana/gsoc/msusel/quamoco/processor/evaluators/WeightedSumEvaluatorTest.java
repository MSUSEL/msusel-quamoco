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
package edu.montana.gsoc.msusel.quamoco.processor.evaluators;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.evaluators.WeightedSumEvaluator;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * The class <code>WeightedSumEvaluatorTest</code> contains tests for the class
 * <code>{@link WeightedSumEvaluator}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class WeightedSumEvaluatorTest {

    private WeightedSumEvaluator fixture;

    /**
     * Run the WeightedSumEvaluator(Node) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testWeightedSumEvaluator_1() throws Exception
    {
        final Node owner = new FactorNode(new DirectedSparseGraph<>(), "factor", "owner");

        final WeightedSumEvaluator result = new WeightedSumEvaluator(owner);

        // add additional test code here
        Assert.assertNotNull(result);
    }

    /**
     * Run the BigDecimal evaluate(List<BigDecimal>) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testEvaluate_1() throws Exception
    {
        final List<BigDecimal> values = Lists.newArrayList();
        values.add(new BigDecimal(10.0));
        values.add(new BigDecimal(15.0));
        values.add(new BigDecimal(20.0));

        final BigDecimal result = fixture.evaluate(values);

        // add additional test code here
        Assert.assertEquals(new BigDecimal(45.0), result);
    }

    /**
     * Run the BigDecimal evaluate(List<BigDecimal>) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testEvaluate_2() throws Exception
    {
        final List<BigDecimal> values = Lists.newArrayList();

        final BigDecimal result = fixture.evaluate(values);

        // add additional test code here
        Assert.assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Run the BigDecimal evaluate(List<BigDecimal>) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Test
    public void testEvaluate_3() throws Exception
    {
        final List<BigDecimal> values = null;

        final BigDecimal result = fixture.evaluate(values);

        // add additional test code here
        Assert.assertEquals(BigDecimal.ZERO, result);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    @Before
    public void setUp() throws Exception
    {
        final Node owner = new FactorNode(new DirectedSparseGraph<>(), "factor", "owner");
        fixture = new WeightedSumEvaluator(owner);
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 1/26/16 6:35 PM
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
     * @generatedBy CodePro at 1/26/16 6:35 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(WeightedSumEvaluatorTest.class);
    }
}