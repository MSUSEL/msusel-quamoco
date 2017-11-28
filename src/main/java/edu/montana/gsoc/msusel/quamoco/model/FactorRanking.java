/**
 * The MIT License (MIT)
 * <p>
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.quamoco.model;

import javax.annotation.Nonnull;

import edu.montana.gsoc.msusel.quamoco.io.RankingType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;

/**
 * A class providing the ability to rank and weight the factors affecting the
 * evaluation of another Factor
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class FactorRanking extends QMElement implements Ranking {

    /**
     * Factor associated with this ranking
     */
    @Getter
    @Setter
    private Factor factor;
    /**
     * Rank associated with the measure or factor
     */
    @Getter
    @Setter
    @Builder.Default
    private int rank = 0;
    /**
     * Weight associated with the measure or factor
     */
    @Getter
    @Setter
    @Builder.Default
    private double weight = 0.0;
    /**
     * Contribution Points
     */
    @Getter
    @Setter
    @Builder.Default
    private double contributionPoints = 0.0;

    /**
     * Constructs a new Factor ranking
     */
    public FactorRanking() {
        super();
    }

    /**
     * @param identifier
     */
    public FactorRanking(String identifier) {
        super(identifier);
    }

    @Builder(buildMethodName = "create")
    protected FactorRanking(Factor factor, int rank, double weight, double contributionPoints, String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(identifier, originatesFrom, tags, annotations);
        this.factor = factor;
        this.rank = rank;
        this.weight = weight;
        this.contributionPoints = contributionPoints;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        return String.format(
                "<rankings xmi:id=\"%s\" xsi:type=\"%s\" factor=\"%s\" weight=\"%f\" rank=\"%d\" />%n",
                getIdentifier(), RankingType.FACTOR_RANKING.type(), getFactor().getQualifiedIdentifier(),
                getWeight(), getRank());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toScript() {
        // TODO Auto-generated method stub
        return null;
    }
}
