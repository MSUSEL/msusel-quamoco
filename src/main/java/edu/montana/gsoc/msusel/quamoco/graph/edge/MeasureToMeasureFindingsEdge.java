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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import com.google.common.collect.Sets;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

import java.util.Set;

/**
 * Edge connecting two MeasureNodes but which only aggregates Finding Sets
 *
 * @author Isaac Griffith
 * @version 1.23.0
 */
public class MeasureToMeasureFindingsEdge extends AbstractEdge implements FindingsEdge {

    /**
     * Constructs a new MeasureToMeasureFindingsEdge with the given name
     * connecting the source and dest nodes.
     * 
     * @param name
     *            Name of this edge
     * @param src
     *            Source node
     * @param dest
     *            Dest node
     */
    public MeasureToMeasureFindingsEdge(final String name, final Node src, final Node dest)
    {
        super(name, src, dest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Finding> getFindings()
    {
        final MeasureNode sn = (MeasureNode) source;
        Set<Finding> findings = Sets.newHashSet(sn.getFindings());

        return findings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getValue()
    {
        return 0.0;
    }
}
