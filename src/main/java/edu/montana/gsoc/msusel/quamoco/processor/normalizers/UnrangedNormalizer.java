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
package edu.montana.gsoc.msusel.quamoco.processor.normalizers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Set;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.Extent;
import edu.montana.gsoc.msusel.quamoco.processor.MetricsContext;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;

/**
 * Class used to normalize un-ranged sets of findings.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class UnrangedNormalizer extends Normalizer {

    /**
     * Constructs a new UnrangedNormalizer for the given edge using the provided
     * normalization metric.
     * 
     * @param owner
     *            The Edge in which this normalizer was installed
     * @param normMetric
     *            the name of the metric used for normalization
     */
    public UnrangedNormalizer(final Edge owner, final String normMetric)
    {
        super(owner, normMetric, NormalizationRange.NA);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal normalize(final Set<Finding> findings)
    {
        if (findings == null || findings.isEmpty())
            return BigDecimal.ZERO;

        BigDecimal totalAffected = BigDecimal.ZERO;
        NormalizationRange newRange = Extent.getInstance()
                .findRange(MetricsContext.getInstance().getTree(), normMetric, range, findings);

        Extent ext = Extent.getInstance();
        for (final Finding f : findings)
        {
            totalAffected = totalAffected.add(ext.findExtent(f, normMetric, newRange));
        }

        BigDecimal extent = ext.findExtent(normMetric, newRange);

        if (BigDecimal.ZERO.compareTo(extent) == 0 && extent.compareTo(totalAffected) == 0)
            return BigDecimal.ZERO;
        else
            return totalAffected.divide(ext.findExtent(normMetric, range), 15, RoundingMode.HALF_UP);
    }

}
