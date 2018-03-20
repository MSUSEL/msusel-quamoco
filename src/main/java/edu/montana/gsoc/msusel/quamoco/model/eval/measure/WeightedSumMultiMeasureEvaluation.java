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
package edu.montana.gsoc.msusel.quamoco.model.eval.measure;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.io.factories.EvaluationType;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.eval.MultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

/**
 * Indicates that the factor should aggregate incoming measures using
 * the weighted summation operator
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class WeightedSumMultiMeasureEvaluation extends MultiMeasureEvaluation {

    @Getter
    private List<MeasureRanking> rankings = Lists.newArrayList();

    /**
     *
     */
    public WeightedSumMultiMeasureEvaluation() {
        super();
        rankings = Lists.newArrayList();
    }

    /**
     * @param identifier
     */
    public WeightedSumMultiMeasureEvaluation(String identifier) {
        super(identifier);
        rankings = Lists.newArrayList();
    }

    @Builder(buildMethodName = "create")
    protected WeightedSumMultiMeasureEvaluation(String name, @Singular List<MeasureRanking> rankings, Double completeness, Double maximumPoints, String title, String description, Factor evaluates,
                                                String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(name, completeness, maximumPoints, title, description, evaluates, identifier, originatesFrom, tags, annotations);
        if (rankings != null && !rankings.isEmpty())
            rankings = Lists.newArrayList(rankings);
    }

    public void addRanking(MeasureRanking rank) {
        if (rank == null || rankings.contains(rank) || rank.getRank() <= 0)
            return;

        rankings.add(rank);
    }

    public void removeRanking(MeasureRanking rank) {
        if (rank == null || !rankings.contains(rank))
            return;

        rankings.remove(rank);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double evaluate() {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        List<String> content = Lists.newArrayList();
        rankings.forEach((rank) -> content.add(rank.xmlTag()));

        return generateXMLTag(EvaluationType.WEIGHTED_SUM_MULTI_MEASURE_EVALUATION.type(), Maps.newHashMap(), content);
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
