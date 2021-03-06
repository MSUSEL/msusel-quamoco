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

import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.FindingsAggregator;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * A findings based aggregator for measures with type FINDINGS. Simply this
 * collects the incoming findings sets and returns the intersection of all the
 * sets.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class FindingsIntersectAggregator extends FindingsAggregator {

    /**
     * Constructs a new FindignsUnionAggregator for the given node.
     * 
     * @param owner
     *            The node which contains and uses this aggregator
     */
    public FindingsIntersectAggregator(final Node owner)
    {
        super(owner);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected Set<Finding> aggregate()
    {
        final DirectedSparseGraph<Node, Edge> graph = owner.getGraph();
        Set<Finding> retVal = Sets.newHashSet();
        boolean first = true;

        for (final Edge edge : graph.getInEdges(owner))
        {
            Node n = graph.getOpposite(owner, edge);
            if (retVal.isEmpty() && first)
            {
                retVal.addAll(n.getFindings());
                first = false;
            }
            else
            {
                List<Finding> temp = Lists.newArrayList();
                retVal.forEach((finding) -> {
                    if (n.getFindings().contains(finding))
                        temp.add(finding);
                });
                retVal.clear();
                retVal.addAll(temp);
            }
        }

        return retVal;
    }
}
