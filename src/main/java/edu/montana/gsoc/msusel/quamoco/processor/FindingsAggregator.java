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
import java.util.List;
import java.util.Set;

import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

/**
 * Base class for the aggregation of Findings sets, as produced from
 * FindingNodes or MeasureNodes.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class FindingsAggregator extends Aggregator {

    /**
     * Constructs a new FindingsAggregator for the given node.
     * 
     * @param owner
     *            The node into which this FindingsAggregator will be installed.
     */
    public FindingsAggregator(final Node owner)
    {
        super(owner);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected BigDecimal aggregate(final List<BigDecimal> values)
    {
        // TODO Auto-generated method stub
        return BigDecimal.ZERO;
    }

    /**
     * Aggregates the collected findings sets from all input nodes.
     * 
     * @return The aggregated set of findings.
     */
    protected abstract Set<Finding> aggregate();

    /**
     * Process all findings sets incoming from input nodes, by calling the
     * aggregate method.
     * 
     * @return The processed set of findings.
     */
    public Set<Finding> processFindings()
    {
        return aggregate();
    }
}
