/**
 * The MIT License (MIT)
 *
 * SparQLine Quamoco Implementation
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import java.math.BigDecimal;
import java.math.RoundingMode;

import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

/**
 * This edge type connects two MeasureNodes whose type is both NUMBER (rather
 * than FINDINGS) and is only concerned with the aggregation of these values.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MeasureToMeasureNumberEdge extends WeightedRankedEdge {

    /**
     * Constructs a new MeasureToMeasureNumberEdge with the given name
     * connecting the source and dest nodes.
     * 
     * @param name
     *            Name of this edge
     * @param src
     *            Source node
     * @param dest
     *            Dest node
     */
    public MeasureToMeasureNumberEdge(final String name, final Node src, final Node dest)
    {
        super(name, src, dest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getValue()
    {
        BigDecimal value = BigDecimal.ZERO;

        if (this.getRank().compareTo(value) == 0)
            return value;

        if (usesLinearDist)
        {
            BigDecimal proportion = src.getValue();
            // if (proportion <= 1.0) {
            // proportion = proportion * getMaxPoints();
            // }
            value = dist.calculate(getMaxPoints(), proportion.divide(getMaxPoints(), 15, RoundingMode.HALF_UP));
        }
        else
        {
            value = src.getValue().multiply(weight);
        }

        return value;
    }
}
