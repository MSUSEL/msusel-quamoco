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
import edu.montana.gsoc.msusel.quamoco.processor.evaluators.ManualEvaluator;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorMethod;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.processor.evaluators.SingleMeasureEvaluator;
import edu.montana.gsoc.msusel.quamoco.processor.evaluators.WeightedSumEvaluator;

/**
 * Factory used to generate the appropriate evaluators for a FactorNode given
 * the node's current state.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class EvaluatorFactory extends ProcessorFactory {

    /**
     * Constructs a new EvaluatorFactory
     */
    private EvaluatorFactory()
    {
    }

    /**
     * Private static inner class used to hold the singleton instance of
     * EvaluatorFactory
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class FactoryHelper {

        /**
         * The singleton instance
         */
        private static final EvaluatorFactory INSTANCE = new EvaluatorFactory();
    }

    /**
     * @return The singleton instance of this factory
     */
    public static ProcessorFactory getInstance()
    {
        return FactoryHelper.INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Processor createProcessor(final INode node)
    {
        if (node instanceof FactorNode)
        {
            final FactorNode factorNode = (FactorNode) node;

            switch (factorNode.getMethod()) {
                case FactorMethod.ONE:
                    return new SingleMeasureEvaluator(factorNode);
                case FactorMethod.RANKING:
                    return new WeightedSumEvaluator(factorNode);
                case FactorMethod.MANUAL:
                    return new ManualEvaluator(factorNode);
                default:
                    return new WeightedSumEvaluator(factorNode);
            }
        }

        return null;
    }
}
