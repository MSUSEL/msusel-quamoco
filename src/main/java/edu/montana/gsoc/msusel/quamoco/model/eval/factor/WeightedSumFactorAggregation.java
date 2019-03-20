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
package edu.montana.gsoc.msusel.quamoco.model.eval.factor;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.io.factories.EvaluationType;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.eval.FactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measurement.FactorRanking;
import lombok.Builder;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

/**
 * An evaluation by calculating the weighted sum from the evaluation results of
 * various factors.
 * <br>
 * General Rules:
 * <ul>
 * <li>Use this evaluation when evaluating a factor that is refined by further
 * factors.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class WeightedSumFactorAggregation extends FactorAggregation {

    /**
     * Define Ranking or CP (Contribution Points) for all refining factors.
     * If rank or points are set to zero the factor is ignored.
     */
    @Getter
    private List<FactorRanking> rankings = Lists.newArrayList();

    /**
     * 
     */
    public WeightedSumFactorAggregation()
    {
        super();
        rankings = Lists.newArrayList();
    }

    /**
     * @param identifier
     */
    public WeightedSumFactorAggregation(String identifier)
    {
        super(identifier);
        rankings = Lists.newArrayList();
    }

    @Builder(buildMethodName = "create")
    protected WeightedSumFactorAggregation(String name, @Singular List<FactorRanking> rankings, Double completeness, Double maximumPoints, String title, String description, Factor evaluates,
                                           String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(name, completeness, maximumPoints, title, description, evaluates, identifier, originatesFrom, tags, annotations);
        if (rankings != null && !rankings.isEmpty())
            this.rankings = Lists.newArrayList(rankings);
    }

    /**
     * @param rank
     */
    public void addRanking(FactorRanking rank)
    {
        if (rank == null || rankings.contains(rank) || rank.getRank() <= 0)
            return;

        rankings.add(rank);
    }

    /**
     * @param rank
     */
    public void removeRanking(FactorRanking rank)
    {
        if (rank == null || !rankings.contains(rank))
            return;

        rankings.remove(rank);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        List<String> content = Lists.newArrayList();
        rankings.forEach((rank) -> content.add(rank.xmlTag()));

        return generateXMLTag(EvaluationType.WEIGHTED_SUM_FACTOR_AGGREGATION.type(), Maps.newHashMap(), content);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double evaluate()
    {
        throw new RuntimeException("Not Yet Implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toScript()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
