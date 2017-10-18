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
package edu.montana.gsoc.msusel.quamoco.model;

import java.util.List;

import javax.annotation.Nonnull;

import edu.montana.gsoc.msusel.quamoco.io.EvaluationType;
import org.apache.commons.lang3.StringEscapeUtils;

import com.google.common.collect.Lists;

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
 * @version 1.1.1
 */
public class WeightedSumFactorAggregation extends FactorAggregation {

    /**
     * Define Ranking or CP (Contribution Points) for all refining factors.
     * If rank or points are set to zero the factor is ignored.
     */
    private List<FactorRanking> rankings;

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

    /**
     * @param rank
     */
    public void addRanking(FactorRanking rank)
    {
        if (rank == null || rankings.contains(rank))
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
     * @return
     */
    public List<FactorRanking> getRankings()
    {
        return rankings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "<evaluations xmi:id=\"%s\" xsi:type=\"%s\" description=\"%s\" maximumPoints=\"%f\" evaluates=\"%s\" completeness=\"%f\"",
                        getIdentifier(), EvaluationType.HISTOGRAM_COMP_FACTOR_AGGREGATION.type(),
                        StringEscapeUtils.escapeXml10(getDescription()), getMaximumPoints(), getEvaluates(),
                        getCompleteness()));

        if (rankings.size() > 0)
        {
            builder.append(">\n");
            rankings.forEach((rank) -> builder.append(rank.xmlTag()));
            builder.append("</evaluations>");
        }
        else
        {
            builder.append(" />\n");
        }

        return builder.toString();
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
     * Creates a new Builder for a WeightedSumFactorAggregation
     * 
     * @return the WeightedSumFactorAggregation.Builder instance
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Creates a new Builder for a WeightedSumFactorAggregation with the given
     * unique identifier
     * 
     * @param identifier
     *            Unique identifier
     * @return the WeightedSumFactorAggregation.Builder instance
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder for WeightedSumFactorAggregations implemented using the fluent
     * interface and method chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractFactorAggregationBuilder {

        /**
         * Constructs a new Builder for a WeightedSumFactorAggregation
         */
        private Builder()
        {
            element = new WeightedSumFactorAggregation();
        }

        /**
         * Constructs a new Builder for a WeightedSumFactorAggregation with the
         * given
         * identifier
         * 
         * @param identifier
         *            The identifier of the tool to construct
         */
        private Builder(String identifier)
        {
            element = new WeightedSumFactorAggregation(identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
        public WeightedSumFactorAggregation create()
        {
            return (WeightedSumFactorAggregation) element;
        }

        /**
         * Adds the given FactorRanking to this evaluation
         * 
         * @param ranking
         *            FactorRanking to add
         * @return this
         */
        @Nonnull
        public Builder ranking(FactorRanking rank)
        {
            ((WeightedSumFactorAggregation) element).addRanking(rank);

            return this;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toYaml()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toJson()
    {
        // TODO Auto-generated method stub
        return null;
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
