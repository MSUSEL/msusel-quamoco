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
package edu.montana.gsoc.msusel.quamoco.processor.normalizers;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;
import edu.montana.gsoc.msusel.quamoco.processor.extents.Extent;

import java.util.Set;

/**
 * Class used to normalize un-ranged sets of findings.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class RangedNormalizer extends Normalizer {

    /**
     * Constructs a new RangedNormalizer for the given edge using the provided
     * normalization name.
     * 
     * @param owner
     *            The Edge in which this normalizer was installed
     * @param normMetric
     *            the name of the name used for normalization
     * @param range
     *            The range of this normalizer
     */
    public RangedNormalizer(final Edge owner, final String normMetric, final NormalizationRange range)
    {
        super(owner, normMetric, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double normalize(final Set<Finding> findings)
    {
        if (findings == null || findings.isEmpty())
            return 0.0;

        Extent ext = Extent.getInstance();
        double totalAffected = 0.0;

        for (final Finding f : findings)
        {
            totalAffected += ext.findExtent(f, metric, range);
        }

        double extent = ext.findExtent(metric, range);

        double value = 0.0;
        if (Double.compare(0.0, extent) == 0 || Double.compare(extent, totalAffected) == 0)
            return 0.0;
        else
            value = totalAffected / extent;

        return value;
    }
}
