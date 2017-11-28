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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import java.math.BigDecimal;
import java.math.RoundingMode;

import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import lombok.Getter;
import lombok.Setter;

/**
 * Edge connection a Measure node to a Factor node and for which the Measure has
 * type NUMBER. Thus, this edge does not pass findings.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MeasureToFactorNumberEdge extends WeightedRankedEdge implements InfluenceEdge {

    @Getter @Setter
    private String inf;

    /**
     * Constructs a new MeasureToFactorNumberEdge with the given name
     * connecting the source and dest nodes.
     * 
     * @param name
     *            Name of this edge
     * @param src
     *            Source node
     * @param dest
     *            Dest node
     */
    public MeasureToFactorNumberEdge(final String name, final Node src, final Node dest, final InfluenceEffect effect)
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

        if (this.getRank().compareTo(value) == 0)
            return value;

        value = source.getValue();

        if (inf != null && inf.equals(InfluenceType.NEG))
        {
            value = (getMaxPoints().subtract(getMaxPoints().multiply(value)))
                    .divide(getMaxPoints(), 15, RoundingMode.HALF_UP);
        }

        if (usesLinearDist)
        {
            value = dist.calculate(value.multiply(getMaxPoints()).divide(getMaxPoints(), 15, RoundingMode.HALF_UP), getMaxPoints());
        }
        else
        {
            value = value.multiply(weight);
        }

        return value;
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
            throw new IllegalArgumentException("Influence cannot be the empty string.");
        }

        if (!inf.equals(InfluenceType.NEG) && !inf.equals(InfluenceType.POS))
        {
            throw new IllegalArgumentException(
                    "Influence must be either: " + InfluenceType.POS + " or " + InfluenceType.NEG);
        }
        this.inf = inf;
    }
}
