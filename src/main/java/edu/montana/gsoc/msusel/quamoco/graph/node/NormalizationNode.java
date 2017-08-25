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
package edu.montana.gsoc.msusel.quamoco.graph.node;

import java.math.BigDecimal;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * Node originally meant to provide the means by which normalization was to
 * occur, currently this node is no longer needed and should be removed
 * FIXME: Remove this class
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class NormalizationNode extends MeasureNode {

    private NormalizationRange range;

    /**
     * @param graph
     * @param owner
     */
    public NormalizationNode(final DirectedSparseGraph<Node, Edge> graph, final String name, final String owner)
    {
        super(graph, name, owner);
        range = NormalizationRange.NA;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getValue()
    {
        return BigDecimal.ZERO;
    }

    /**
     * @return
     */
    public NormalizationRange getRange()
    {
        return range;
    }

    /**
     * @param range
     */
    public void setRange(final NormalizationRange range)
    {
        this.range = range;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTag()
    {
        return String.format("<nodes name=\"%s\" owner=\"%s\" type=\"NORMALIZATION\" />", name, ownedBy);
    }

}
