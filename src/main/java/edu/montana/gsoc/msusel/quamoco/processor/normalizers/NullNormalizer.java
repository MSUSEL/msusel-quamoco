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
package edu.montana.gsoc.msusel.quamoco.processor.normalizers;

import java.math.BigDecimal;
import java.util.Set;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;

/**
 * A normalizer which simply return a 0.0 value.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class NullNormalizer extends Normalizer {

    /**
     * Constructs a new NullNormalizer for the given edge using the provided
     * normalization metric.
     * 
     * @param owner
     *            The Edge in which this normalizer was installed
     * @param normMetric
     *            the name of the metric used for normalization
     * @param range
     *            The range of this normalizer
     */
    public NullNormalizer(final Edge owner, final String normMetric, final NormalizationRange range)
    {
        super(owner, normMetric, range);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal normalize(final Set<Finding> findings)
    {
        if (findings == null || findings.isEmpty())
        {
            return BigDecimal.ZERO;
        }

        return BigDecimal.ZERO;
    }

}
