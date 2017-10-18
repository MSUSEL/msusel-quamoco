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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.processor;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.graph.INode;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.processor.AggregatorFactory;
import edu.montana.gsoc.msusel.quamoco.processor.EvaluatorFactory;
import edu.montana.gsoc.msusel.quamoco.processor.ProcessorFactory;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * The class <code>ProcessorFactoryTest</code> contains tests for the class
 * <code>{@link ProcessorFactory}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class ProcessorFactoryTest {
	/**
	 * Run the ProcessorFactory getInstance(INode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Test
	public void testGetInstance_1() throws Exception {
		final INode node = new FactorNode(new DirectedSparseGraph<>(), "factor", "owner");
		final INode node2 = new FactorNode(new DirectedSparseGraph<>(), "factor2", "owner");

		final ProcessorFactory result = ProcessorFactory.getInstance(node);
		final ProcessorFactory result2 = ProcessorFactory.getInstance(node2);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertTrue(result instanceof EvaluatorFactory);
		Assert.assertSame(result, result2);
	}

	/**
	 * Run the ProcessorFactory getInstance(INode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Test
	public void testGetInstance_2() throws Exception {
		final INode node = new MeasureNode(new DirectedSparseGraph<>(), "measure", "owner");
		final INode node2 = new MeasureNode(new DirectedSparseGraph<>(), "measure2", "owner");

		final ProcessorFactory result = ProcessorFactory.getInstance(node);
		final ProcessorFactory result2 = ProcessorFactory.getInstance(node2);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertTrue(result instanceof AggregatorFactory);
		Assert.assertSame(result, result2);
	}

	/**
	 * Run the ProcessorFactory getInstance(INode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Test
	public void testGetInstance_3() throws Exception {
		final INode node = null;

		final ProcessorFactory result = ProcessorFactory.getInstance(node);

		// add additional test code here
		Assert.assertNull(result);
	}

	/**
	 * Run the ProcessorFactory getInstance(INode) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Test
	public void testGetInstance_4() throws Exception {
		final INode node = new MeasureNode(new DirectedSparseGraph<>(), "measure", "owner");
		final INode node2 = new FactorNode(new DirectedSparseGraph<>(), "factor2", "owner");

		final ProcessorFactory result = ProcessorFactory.getInstance(node);
		final ProcessorFactory result2 = ProcessorFactory.getInstance(node2);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertNotNull(result2);
		Assert.assertTrue(result instanceof AggregatorFactory);
		Assert.assertTrue(result2 instanceof EvaluatorFactory);
		Assert.assertNotSame(result, result2);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
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
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(ProcessorFactoryTest.class);
	}
}