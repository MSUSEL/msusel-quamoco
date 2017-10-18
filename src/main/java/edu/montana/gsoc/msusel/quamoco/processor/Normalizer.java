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
package edu.montana.gsoc.msusel.quamoco.processor;

import java.math.BigDecimal;
import java.util.Set;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

/**
 * Normalizer -
 *
 * @author Isaac Griffith
 */
public abstract class Normalizer {

    /**
     * Edge containing this normalizer
     */
    protected Edge owner;
    /**
     * Range of normalization
     */
    protected NormalizationRange range;
    /**
     * Name of the normalization metric
     */
    protected String             normMetric;

    /**
     * Consturcts a new normalizer for the given edge and which uses the named
     * metric and range for the normalization of findings sets.
     * 
     * @param owner
     *            Containing edge
     * @param normMetric
     *            Name of the normalization metric
     * @param range
     *            Normalization range
     * @throws IllegalARgumentException
     *             if the given owning edge is null, the metric name is null or
     *             empty, or the range is null
     */
    public Normalizer(final Edge owner, final String normMetric, final NormalizationRange range)
    {
        if (owner == null)
        {
            throw new IllegalArgumentException("Normalizer owner cannot be null.");
        }

        if (normMetric == null || normMetric.isEmpty())
        {
            throw new IllegalArgumentException("Normalization metric name cannot be null or empty");
        }

        if (range == null)
        {
            throw new IllegalArgumentException("Normalization Range cannot be null");
        }

        this.owner = owner;
        this.range = range;
        this.normMetric = normMetric;
    }

    /**
     * @return Range of normalization
     */
    public NormalizationRange getNormalizationRange()
    {
        return range;
    }

    /**
     * @return Name of the normalization metric
     */
    public String getMetric()
    {
        return normMetric;
    }

    /**
     * Conduct the normalization of the given set of findings.
     * 
     * @param findings
     *            Finding set to normalize
     * @return normalized value for the findings set, representing the
     *         proportion of the system affected by the given findings set.
     */
    public abstract BigDecimal normalize(Set<Finding> findings);
}
