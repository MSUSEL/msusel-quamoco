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
package edu.montana.gsoc.msusel.quamoco.processor;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.INode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>ProcessorFactoryTest</code> contains tests for the class
 * <code>{@link ProcessorFactory}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class ProcessorFactoryTest {

	/**
	 * Run the ProcessorFactory getInstance(INode) method test.
	 */
	@Test
	public void testGetInstance_1() {
	    final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();

		final INode node = new FactorNode(graph, "factor", "owner");
		final INode node2 = new FactorNode(graph, "factor2", "owner");

		final ProcessorFactory result = ProcessorFactory.getInstance(node);
		final ProcessorFactory result2 = ProcessorFactory.getInstance(node2);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertTrue(result instanceof EvaluatorFactory);
		Assert.assertSame(result, result2);
	}

	/**
	 * Run the ProcessorFactory getInstance(INode) method test.
	 */
	@Test
	public void testGetInstance_2() {
	    final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();

		final INode node = new MeasureNode(graph, "measure", "owner");
		final INode node2 = new MeasureNode(graph, "measure2", "owner");

		final ProcessorFactory result = ProcessorFactory.getInstance(node);
		final ProcessorFactory result2 = ProcessorFactory.getInstance(node2);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertTrue(result instanceof AggregatorFactory);
		Assert.assertSame(result, result2);
	}

	/**
	 * Run the ProcessorFactory getInstance(INode) method test.
	 */
	@Test
	public void testGetInstance_3() {
		final INode node = null;

		final ProcessorFactory result = ProcessorFactory.getInstance(node);

		// add additional test code here
		Assert.assertNull(result);
	}

	/**
	 * Run the ProcessorFactory getInstance(INode) method test.
	 */
	@Test
	public void testGetInstance_4() {
	    final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
		final INode node = new MeasureNode(graph, "measure", "owner");
		final INode node2 = new FactorNode(graph, "factor2", "owner");

		final ProcessorFactory result = ProcessorFactory.getInstance(node);
		final ProcessorFactory result2 = ProcessorFactory.getInstance(node2);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertNotNull(result2);
		Assert.assertTrue(result instanceof AggregatorFactory);
		Assert.assertTrue(result2 instanceof EvaluatorFactory);
		Assert.assertNotSame(result, result2);
	}
}