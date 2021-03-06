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
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureMethod;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsIntersectAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMaxAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMeanAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMedianAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.NumberMinAggregator;

/**
 * Factory used to select the appropriate aggregator for a given MeasureNode
 * based on its current state.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class AggregatorFactory extends ProcessorFactory {

    /**
     * Constructs a new AggregatorFactory
     */
    private AggregatorFactory()
    {
    }

    /**
     * Private static internal class used to hold the singleton instance of
     * AggregatorFactory
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class FactoryHelper {

        /**
         * The singleton instance
         */
        private static final AggregatorFactory INSTANCE = new AggregatorFactory();
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
        if (node instanceof MeasureNode)
        {
            final MeasureNode mnode = (MeasureNode) node;

            if (mnode.getType().equals(MeasureType.FINDINGS))
            {
                if (mnode.getMethod().equals(MeasureMethod.UNION))
                {
                    return new FindingsUnionAggregator(mnode);
                }
                else if (mnode.getMethod().equals(MeasureMethod.INTERSECT))
                {
                    return new FindingsIntersectAggregator(mnode);
                }
            }
            else if (mnode.getType().equals(MeasureType.NUMBER))
            {
                if (mnode.getMethod().equals(MeasureMethod.MEAN))
                {
                    return new NumberMeanAggregator(mnode);
                }
                else if (mnode.getMethod().equals(MeasureMethod.MAX))
                {
                    return new NumberMaxAggregator(mnode);
                }
                else if (mnode.getMethod().equals(MeasureMethod.MIN))
                {
                    return new NumberMinAggregator(mnode);
                }
                else if (mnode.getMethod().equals(MeasureMethod.MEDIAN))
                {
                    return new NumberMedianAggregator(mnode);
                }
            }
        }

        return new NullProcessor((Node) node);
    }
}
