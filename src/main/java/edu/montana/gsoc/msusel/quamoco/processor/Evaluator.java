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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.RankedEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

/**
 * Evaluator -
 *
 * @author Isaac Griffith
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
    public BigDecimal process()
    {
        final List<BigDecimal> values = new ArrayList<>();

        for (final Edge edge : owner.getGraph().inEdges(owner))
        {
            if (edge instanceof RankedEdge)
            {
                if (((RankedEdge) edge).getRank().compareTo(BigDecimal.ZERO) <= 0)
                    continue;
            }
            values.addAll(edge.getValues());
        }

        return thresholdValue(evaluate(values));
    }

    /**
     * @param value
     * @return
     */
    private BigDecimal thresholdValue(BigDecimal value)
    {
        if (value.compareTo(BigDecimal.ZERO) < 0)
            return BigDecimal.ZERO;

        if (value.compareTo(BigDecimal.ONE) > 0)
            return BigDecimal.ONE;

        return value;
    }

    /**
     * @param valueMap
     * @return
     */
    protected abstract BigDecimal evaluate(List<BigDecimal> valueMap);
}
