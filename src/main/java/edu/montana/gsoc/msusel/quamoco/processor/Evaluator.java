/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * Evaluator -
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public abstract class Evaluator extends Processor {

    /**
     *
     */
    public Evaluator(final Node owner)
    {
        super(owner);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double process()
    {
        final List<Double> values = new ArrayList<>();

        for (final Edge edge : owner.getGraph().inEdges(owner))
        {
//            if (edge instanceof RankedEdge)
//            {
//                if (Double.compare(((RankedEdge) edge).getRank(), 0.0) <= 0)
//                    continue;
//            }
            values.addAll(edge.getValues());
        }

        return evaluate(values);
    }

    /**
     * @param value
     * @return
     */
    private double thresholdValue(double value)
    {
        if (Double.compare(value, 0.0) < 0)
            return 0.0;

        if (Double.compare(value, 1.0) > 0)
            return 1.0;

        return value;
    }

    /**
     * @param valueMap
     * @return
     */
    protected abstract double evaluate(List<Double> valueMap);
}
