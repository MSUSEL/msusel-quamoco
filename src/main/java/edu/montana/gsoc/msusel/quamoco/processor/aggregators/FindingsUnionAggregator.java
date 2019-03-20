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
package edu.montana.gsoc.msusel.quamoco.processor.aggregators;

import com.google.common.collect.Sets;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.FindingsAggregator;

import java.util.Set;

/**
 * A findings based aggregator for measures with type FINDINGS. Simply this
 * collects the incoming findings sets and returns the union of all the sets.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class FindingsUnionAggregator extends FindingsAggregator {

    /**
     * Constructs a new FindingsUnionAggregator for the given node.
     * 
     * @param owner
     *            The node which contains and uses this aggregator
     */
    public FindingsUnionAggregator(final Node owner)
    {
        super(owner);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Set<Finding> aggregate()
    {
        final MutableNetwork<Node, Edge> graph = owner.getGraph();
        final Set<Finding> retVal = Sets.newHashSet();

        for (final Edge edge : graph.inEdges(owner))
        {
            if (edge instanceof FindingsEdge) {
                retVal.addAll(((FindingsEdge) edge).getFindings());
            }
//            final Node other = owner.getOpposite(edge);
//            retVal.addAll(other.getFindings());
        }

        return retVal;
    }

}
