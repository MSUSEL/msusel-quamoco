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

import edu.montana.gsoc.msusel.quamoco.processor.Aggregator;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

/**
 * A value based aggregator for measures with type NUMBER. Simply this collects
 * the incoming values and returns the arithmetic mean of the set.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class NumberMeanAggregator extends Aggregator {

    /**
     * Constructs a new NumberMeanAggregator for the given node.
     * 
     * @param owner
     *            The node which contains and uses this aggregator
     */
    public NumberMeanAggregator(final Node owner)
    {
        super(owner);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BigDecimal aggregate(final List<BigDecimal> values)
    {
        BigDecimal total = BigDecimal.ZERO;
        if (values == null || values.isEmpty())
        {
            return BigDecimal.ZERO;
        }

        for (final BigDecimal value : values)
        {
            total = total.add(value);
        }

        return total.divide(new BigDecimal(values.size()), 15, RoundingMode.HALF_UP);
    }

}
