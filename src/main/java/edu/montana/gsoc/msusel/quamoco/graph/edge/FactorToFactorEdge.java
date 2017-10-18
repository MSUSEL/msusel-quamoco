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
import java.math.RoundingMode;

import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;

/**
 * Edge connecting one FactorNode to another FactorNode.
 *
 * @author Isaac Griffith
 */
public class FactorToFactorEdge extends WeightedRankedEdge implements InfluenceEdge {

    /**
     * Influence type
     */
    private String inf;

    /**
     * Constructs a new MeasureToMeasureNumberEdge with the given name
     * connecting the source and dest nodes.
     * 
     * @param name
     *            Name of this edge
     * @param src
     *            Source node
     * @param dest
     *            Dest node
     * @param effect
     *            Influence type of this edge
     */
    public FactorToFactorEdge(final String name, final Node src, final Node dest, final InfluenceEffect effect)
    {
        super(name, src, dest);
        inf = effect == null ? InfluenceType.POS : effect.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getValue()
    {
        BigDecimal value = BigDecimal.ZERO;

        if (weight.compareTo(BigDecimal.ZERO) <= 0)
            return weight;

        value = src.getValue();

        if (inf != null)

        {
            if (inf.equals(InfluenceType.NEG))
            {
                value = getMaxPoints().subtract(value.multiply(getMaxPoints()));
                value = value.divide(getMaxPoints(), 15, RoundingMode.HALF_UP);
            }
        }

        value = value.multiply(weight);

        // if (norm != null /* && !(norm instanceof UnrangedNormalizer) */)
        // {
        // BigDecimal n = norm.normalize(value);
        // value = n;
        // }

        // }

        // value = 1 - value;

        return

        thresholdValue(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getInf()
    {
        return inf;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setInf(final String inf)
    {
        if (inf == null)
        {
            this.inf = inf;
            return;
        }

        if (inf.isEmpty())
        {
            throw new IllegalArgumentException("An influence type of empty string is invalid.");
        }

        if (!(inf.equals(InfluenceType.POS) || inf.equals(InfluenceType.NEG)))
        {
            throw new IllegalArgumentException(inf + " is not a valid influence type.");
        }

        this.inf = inf;
    }
}
