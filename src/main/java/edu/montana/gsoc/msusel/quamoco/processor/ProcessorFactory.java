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
package edu.montana.gsoc.msusel.quamoco.processor;

import edu.montana.gsoc.msusel.quamoco.graph.INode;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;

/**
 * Multiton object used to assign the correct processor to a given node in a
 * distilled quality model graph.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class ProcessorFactory {

    /**
     * Constructs a new ProcessorFactory
     */
    protected ProcessorFactory()
    {
    }

    /**
     * Internal private class used to hold the singleton instance of each type of
     * processor factory
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class FactoryHelper {

        /**
         * The Processor Factory for FactorNodes
         */
        private static final ProcessorFactory FACTOR_INSTANCE  = EvaluatorFactory.getInstance();
        /**
         * The Processor Factory for MeasureNodes
         */
        private static final ProcessorFactory MEASURE_INSTANCE = AggregatorFactory.getInstance();
    }

    /**
     * Singleton Factory Method used to retrieve an instanceof the
     * ProcessorFactory given the type of node provided.
     * 
     * @param node
     *            Node for which a processor is needed
     * @return Either the Factor or Measure node processor factory, or null if
     *         the provided node is neither a FactorNode or MeasureNode
     */
    public static ProcessorFactory getInstance(final INode node)
    {
        if (node instanceof FactorNode)
        {
            return FactoryHelper.FACTOR_INSTANCE;
        }
        else if (node instanceof MeasureNode)
        {
            return FactoryHelper.MEASURE_INSTANCE;
        }
        else
        {
            return null;
        }
    }

    /**
     * Constructs a processor for the provided Node. In the case that the node
     * is a FactorNode, an Evaluator is provided, and in the case that the node
     * is a MeasureNode then an Aggregator is provided. In all other cases a
     * NullProcessor is provided.
     *
     * @param node
     *            Node a processor is required for.
     * @return The newly constructed processor.
     */
    public abstract Processor createProcessor(INode node);

}
