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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import java.math.BigDecimal;

import edu.montana.gsoc.msusel.quamoco.processor.LinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;

/**
 * Typing inteface for edges which have a ranking capability.
 * FIXME Currently this also includes stuff with linear distributions, should
 * move this to another type
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public interface RankedEdge {

    /**
     * FIXME move to another type
     * 
     * @return the lowerBound
     */
    BigDecimal getLowerBound();

    /**
     * FIXME move to another type
     * 
     * @return the upperBound
     */
    BigDecimal getUpperBound();

    /**
     * FIXME move to another type
     * 
     * @param lowerBound
     *            the lowerBound to set
     */
    void setLowerBound(BigDecimal lowerBound);

    /**
     * FIXME move to another type
     * 
     * @param upperBound
     *            the upperBound to set
     */
    void setUpperBound(BigDecimal upperBound);

    /**
     * FIXME move to WeightedEdge
     * 
     * @param weight
     *            the weight to set
     */
    void setWeight(BigDecimal weight);

    /**
     * FIXME move to normalizable
     * 
     * @param normalizer
     *            The new normalizer
     */
    void setNormalizer(Normalizer normalizer);

    /**
     * FIXME move to another type
     * 
     * @param maximumPoints
     *            New value of Maximum ponts
     */
    void setMaxPoints(BigDecimal maximumPoints);

    /**
     * FIXME move to another type
     * 
     * @return Maximum points
     */
    BigDecimal getMaxPoints();

    /**
     * FIXME move to another type
     * 
     * @return the usesLinearDist
     */
    boolean isUsesLinearDist();

    /**
     * FIXME Move this to another Type
     * 
     * @param usesLinearDist
     *            the usesLinearDist to set
     */
    void setUsesLinearDist(boolean usesLinearDist);

    /**
     * FIXME move to another type
     * 
     * @return the linear distribution to use
     */
    LinearDistribution getDist();

    /**
     * FIXME move to another type
     * 
     * @param dist
     *            the new linear distribution
     */
    void setDist(LinearDistribution dist);

    /**
     * FIXME move to another type
     * 
     * @return The current normalizer
     */
    Normalizer getNormalizer();

    /**
     * @param rank
     *            The new rank of this RankedEdge
     */
    void setRank(BigDecimal rank);

    /**
     * @return The current rank of this RankedEdge
     */
    BigDecimal getRank();

}