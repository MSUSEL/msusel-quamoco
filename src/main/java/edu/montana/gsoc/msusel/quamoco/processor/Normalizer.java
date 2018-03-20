/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Normalizer -
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public abstract class Normalizer {

    /**
     * Edge containing this normalizer
     */
    @Getter
    @Setter
    protected Edge owner;
    /**
     * Range of normalization
     */
    @Getter
    @Setter
    protected NormalizationRange range;
    /**
     * Name of the normalization name
     */
    @Getter
    @Setter
    protected String metric;

    /**
     * Constructs a new normalizer for the given edge and which uses the named
     * name and range for the normalization of findings sets.
     *
     * @param owner      Containing edge
     * @param normMetric Name of the normalization name
     * @param range      Normalization range
     * @throws IllegalArgumentException if the given owning edge is null, the name name is null or
     *                                  empty, or the range is null
     */
    public Normalizer(final Edge owner, final String normMetric, NormalizationRange range) {
        if (owner == null) {
            throw new IllegalArgumentException("Normalizer owner cannot be null.");
        }

        if (range == null) {
            range = NormalizationRange.NA;
        }

        this.owner = owner;
        this.range = range;
        this.metric = normMetric;
    }

    /**
     * Conduct the normalization of the given set of findings.
     *
     * @param findings Finding set to normalize
     * @return normalized value for the findings set, representing the
     * proportion of the system affected by the given findings set.
     */
    public abstract double normalize(Set<Finding> findings);
}
