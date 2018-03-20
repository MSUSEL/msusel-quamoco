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
/* The MIT License (MIT)
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

import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.processor.LinearDistribution;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;
import lombok.Getter;
import lombok.Setter;

/**
 * Abstract base edge type for edges which have both a weight and a rank.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public abstract class WeightedRankedEdge extends AbstractEdge implements WeightedEdge, RankedEdge {

    /**
     * Weight applied to the input value
     */
    @Getter
    protected double weight;
    /**
     * Lower bound on proportion (0.0 to 1.0)
     */
    @Getter
    protected double lowerBound;
    /**
     * Upper bound on proportion (0.0 to 1.0)
     */
    @Getter
    protected double upperBound;
    /**
     * Flag indicating that a linear distribution should be applied to the
     * value.
     */
    @Getter
    @Setter
    protected boolean usesLinearDist;
    /**
     * Linear distribution to use if usesLinearDist is true
     */
    @Getter
    protected LinearDistribution dist;
    /**
     * Maximum points
     */
    @Getter
    protected double maxPoints;
    /**
     * Rank of the source in the evaluation of the dest
     */
    @Getter
    private int rank;
    /**
     * Flag indicating that the rank has been set
     */
    @Getter
    private boolean rankSet = false;
    /**
     * Flag indicating that the weight has been set
     */
    @Getter
    private boolean weightSet = false;

    /**
     * Constructs a new WeightedRankedEdge with the given name connecting the
     * source and dest nodes. Initially the weight is 1.0 and rank is 0.
     * MaxPoints is set to the default of 100 and upper bound is set to 1.0 while
     * lower bound is set to 0.0
     *
     * @param name Name of this edge
     * @param src  Source node
     * @param dest Dest node
     */
    WeightedRankedEdge(final String name, final Node src, final Node dest) {
        super(name, src, dest);
        weight = 1.0;
        lowerBound = 0.0;
        upperBound = 1.0;
        maxPoints = 100.0;
        rank = 1;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLowerBound(final double lowerBound) {
        if (Double.compare(upperBound, lowerBound) < 0) {
            throw new IllegalArgumentException(
                    "Value of upper bound: " + upperBound + " cannot be less than value of lower bound: " + lowerBound);
        }

        this.lowerBound = lowerBound;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setUpperBound(final double upperBound) {
        if (Double.compare(upperBound, lowerBound) < 0) {
            throw new IllegalArgumentException(
                    "Value of upper bound: " + upperBound + " cannot be less than value of lower bound: " + lowerBound);
        }

        this.upperBound = upperBound;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setWeight(final double weight) {
        if (Double.compare(weight, 0.0) < 0) {
            throw new IllegalArgumentException("Value of weight cannot be less than 0.0.");
        }
        if (Double.compare(weight, 1.0) > 0) {
            throw new IllegalArgumentException("Value of weight cannot be greater than 1.0.");
        }

//        if (weightSet)
//            return;

        this.weight = weight;
        weightSet = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setNormalizer(final Normalizer normalizer) {
        norm = normalizer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDist(final LinearDistribution dist) {
        this.dist = dist;

        if (dist == null)
            setUsesLinearDist(false);
        else
            setUsesLinearDist(true);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaxPoints(final double maxPoints) {
        if (Double.compare(maxPoints, 0.0) < 0) {
            throw new IllegalArgumentException("Value of maximum points cannot be less than 0");
        }

        this.maxPoints = maxPoints;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Normalizer getNormalizer() {
        return norm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Edge setRank(int rank) {
        this.rank = rank;
        rankSet = true;

        return this;
    }
}
