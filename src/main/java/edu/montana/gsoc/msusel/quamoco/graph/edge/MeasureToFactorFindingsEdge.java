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

import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import lombok.Getter;
import lombok.Setter;

/**
 * Edge connecting a MeasureNode to a FactorNode for the purpose of passing
 * and normalizing findings sets.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MeasureToFactorFindingsEdge extends WeightedRankedEdge implements InfluenceEdge, Normalizable {

    /**
     * Influence type
     */
    @Getter
    @Setter
    private String inf;

    /**
     * Constructs a new MeasureToFactorFindingsEdge with the given name
     * connecting the source and dest nodes.
     *
     * @param name   Name of this edge
     * @param src    Source node
     * @param dest   Dest node
     * @param effect Influence type of this edge
     */
    public MeasureToFactorFindingsEdge(final String name, final Node src, final Node dest, final InfluenceEffect effect) {
        super(name, src, dest);
        inf = effect == null ? InfluenceType.POS : effect.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getValue() {
        double value = 0.0;

        if (this.getRank() == 0 || Double.compare(this.getWeight(), 0.0) <= 0)
            return 1.0;

        if (norm != null) {
            value = norm.normalize(source.getFindings());
        }

        if (inf != null) {
            if (inf.equals(InfluenceType.NEG)) {
                value = (getMaxPoints() - (value * getMaxPoints()));
            }

            value = value / getMaxPoints();
        }

        if (usesLinearDist) {
            value = dist.calculate(getMaxPoints(), value / getMaxPoints());
        }

        if (inf == null && !usesLinearDist)
            value /= getMaxPoints();

        value = thresholdValue(value, lowerBound, upperBound);
        value = value * weight;


        return value;
    }
}
