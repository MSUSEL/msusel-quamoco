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

import edu.montana.gsoc.msusel.quamoco.processor.LinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;

/**
 * Typing interface for edges which have a ranking capability.
 * FIXME Currently this also includes stuff with linear distributions, should
 * move this to another type
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public interface RankedEdge {

    /**
     * FIXME move to another type
     * 
     * @return the lowerBound
     */
    double getLowerBound();

    /**
     * FIXME move to another type
     * 
     * @return the upperBound
     */
    double getUpperBound();

    /**
     * FIXME move to another type
     * 
     * @param lowerBound
     *            the lowerBound to set
     */
    void setLowerBound(double lowerBound);

    /**
     * FIXME move to another type
     * 
     * @param upperBound
     *            the upperBound to set
     */
    void setUpperBound(double upperBound);

    /**
     * FIXME move to WeightedEdge
     * 
     * @param weight
     *            the weight to set
     */
    void setWeight(double weight);

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
     *            New value of Maximum points
     */
    void setMaxPoints(double maximumPoints);

    /**
     * FIXME move to another type
     * 
     * @return Maximum points
     */
    double getMaxPoints();

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
    Edge setRank(int rank);

    /**
     * @return The current rank of this RankedEdge
     */
    int getRank();

}