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

import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Normalizable;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.RangedNormalizer;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingsEdge;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.UnrangedNormalizer;

/**
 * Factory class implemented as a singleton which constructs the required
 * Normalizers for edges in the distilled quality model graph.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class NormalizerFactory {

    /**
     * constructs a new normalizer factory
     */
    private NormalizerFactory()
    {
    }

    /**
     * Private static inner class which holds the singleton instance
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class FactoryHelper {

        /**
         * The singleton instance of the normalizer factory
         */
        private static final NormalizerFactory INSTANCE = new NormalizerFactory();
    }

    /**
     * @return The singleton instance of this factory
     */
    public static NormalizerFactory getInstance()
    {
        return FactoryHelper.INSTANCE;
    }

    /**
     * Given the edge, name, and range this method constructs a new normalizer
     * for use in the given edge.
     * 
     * @param edge
     *            The edge
     * @param metric
     *            The normalization name
     * @param range
     *            The normalization range
     * @return A Normalizer for the given edge, or null if the name is null,
     *         the range is null, the name is empty, or the edge is not
     *         subject to normalization.
     */
    public Normalizer createNormalizer(final Edge edge, final String metric, final NormalizationRange range)
    {
        Normalizer retVal = null;

        if (isBadMetric(metric) || isBadRange(range) || isFIndingsOrNormalizable(edge))
        {
            retVal = createNullNormalizer(edge, metric, range);
        }
        else if (range.equals(NormalizationRange.NA))
        {
            retVal = createUnrangedNormalizer(edge, metric);
        }
        else
        {
            retVal = createRangedNormalizer(edge, metric, range);
        }

        return retVal;
    }

    private RangedNormalizer createRangedNormalizer(Edge edge, String metric, NormalizationRange range) {
        return new RangedNormalizer(edge, metric, range);
    }

    private UnrangedNormalizer createUnrangedNormalizer(Edge edge, String metric) {
        return new UnrangedNormalizer(edge, metric);
    }

    private NullNormalizer createNullNormalizer(Edge edge, String metric, NormalizationRange range) {
        return new NullNormalizer(edge, metric, range);
    }

    boolean isFIndingsOrNormalizable(Edge edge) {
        return !((edge instanceof FindingsEdge) || (edge instanceof Normalizable));
    }

    boolean isBadRange(NormalizationRange range) {
        return range == null;
    }

    boolean isBadMetric(String metric) {
        return metric == null || metric.isEmpty();
    }
}
