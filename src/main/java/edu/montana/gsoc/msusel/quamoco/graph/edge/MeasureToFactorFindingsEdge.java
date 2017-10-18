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
 * Edge connecting a MeasureNode to a FactorNode for the purpose of passing
 * and normalizing findings sets.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MeasureToFactorFindingsEdge extends WeightedRankedEdge implements InfluenceEdge, Normalizable {

    /**
     * Influence type
     */
    private String inf;

    /**
     * Constructs a new MeasureToFactorFindingsEdge with the given name
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
    public MeasureToFactorFindingsEdge(final String name, final Node src, final Node dest, final InfluenceEffect effect)
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

        value = norm.normalize(src.getFindings());

        if (inf != null && inf.equals(InfluenceType.NEG))
        {
            value = (getMaxPoints().subtract(getMaxPoints().multiply(value)))
                    .divide(getMaxPoints(), 15, RoundingMode.HALF_UP);
        }

        if (usesLinearDist)
        {
            value = dist.calculate(getMaxPoints(), value);
        }

        value = value.multiply(weight);
        // value = thresholdValue(value);
        return value;
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
        this.inf = inf;
    }
}
