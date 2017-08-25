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

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Normalizable;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.RangedNormalizer;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.UnrangedNormalizer;

/**
 * Factory class implemented as a singleton which constructs the required
 * Normalizers for edges in the distilled quality model graph.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class NormalizerFactory {

    /**
     * constructs a new normalizer factory
     */
    private NormalizerFactory()
    {
    }

    /**
     * Private static inner class which holds the singlton instance
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
     * Given the edge, metric, and range this method constructs a new normalizer
     * for use in the given edge.
     * 
     * @param edge
     *            The edge
     * @param metric
     *            The normalization metric
     * @param range
     *            The normalization range
     * @return A Normalizer for the given edge, or null if the metric is null,
     *         the range is null, the metric is empty, or the edge is not
     *         subject to normalization.
     */
    public Normalizer createNormalizer(final Edge edge, final String metric, final NormalizationRange range)
    {
        Normalizer retVal = null;

        if (metric == null || range == null || metric.isEmpty()
                || !((edge instanceof FindingsEdge) || (edge instanceof Normalizable)))
        {
            retVal = new NullNormalizer(edge, metric, range);
        }
        else if (range.equals(NormalizationRange.NA))
        {
            retVal = new UnrangedNormalizer(edge, metric);
        }
        else
        {
            retVal = new RangedNormalizer(edge, metric, range);
        }

        return retVal;
    }
}
