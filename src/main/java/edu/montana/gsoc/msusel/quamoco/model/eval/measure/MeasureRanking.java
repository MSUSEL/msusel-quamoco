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
package edu.montana.gsoc.msusel.quamoco.model.eval.measure;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.io.factories.RankingType;
import edu.montana.gsoc.msusel.quamoco.model.*;
import edu.montana.gsoc.msusel.quamoco.model.eval.MeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.func.Function;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measure.NormalizationMeasure;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import java.util.List;
import java.util.Map;

/**
 * A class to provide the capability to rank and weight the evaluation of
 * measures which affect a factor.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class MeasureRanking extends MeasureEvaluation implements Ranking {

    /**
     * Rank associated with the measure or factor
     */
    @Getter @Setter
    private int rank = 0;
    /**
     * Weight associated with the measure or factor
     */
    @Getter @Setter
    private double weight = 0;

    /**
     * Constructs a new Ranking for the given measure
     */
    public MeasureRanking() {
        super();
    }

    /**
     * Constructs a new Ranking for the given measure
     *
     * @param identifier The unique identifier
     */
    public MeasureRanking(String identifier) {
        super(identifier);
    }

    @Builder(buildMethodName = "create")
    protected MeasureRanking(String name, int rank, double weight, Measure basedOn, NormalizationMeasure normalization, NormalizationRange range, Function function,
                             Double completeness, Double maximumPoints, String title, String description, Factor evaluates,
                             String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(name, basedOn, normalization, range, function, completeness, maximumPoints, title, description, evaluates, identifier, originatesFrom, tags, annotations);
        this.rank = rank;
        this.weight = weight;
    }

    /**
     * @return the measure
     */
    public Measure getMeasure() {
        return getBasedOn();
    }

    /**
     * @param measure the measure to set
     */
    public void setMeasure(Measure measure) {
        setBasedOn(measure);
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
        String tag = "rankings";
        String type = RankingType.MEASURE_RANKING.type();
        Map<String, String> attrs = Maps.newHashMap();
        if (getMeasure() != null)
            attrs.put("measure", getMeasure().getQualifiedIdentifier());
        attrs.put("weight", Double.toString(getWeight()));
        attrs.put("rank", Integer.toString(getRank()));
        if (getRange() != null)
            attrs.put("range", getRange().toString());

        List<String> content = Lists.newArrayList();
        if (normalization != null) {
            content.add(String.format("<normlizationMeasure href=\"%s\" />%n", normalization.getQualifiedIdentifier()));
        }
        if (function != null) {
            content.add(function.xmlTag());
        }

        return generateXMLTag(tag, type, attrs, content);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getCompleteness() {
        return 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCompleteness(Double completeness) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Double getMaximumPoints() {
        return 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMaximumPoints(Double maximumPoints) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Factor getEvaluates() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEvaluates(Factor factor) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getContributionPoints() {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setContributionPoints(double contPoints) {
        // TODO Auto-generated method stub

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
