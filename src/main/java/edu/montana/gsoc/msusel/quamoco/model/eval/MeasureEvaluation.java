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
package edu.montana.gsoc.msusel.quamoco.model.eval;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.model.*;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.func.Function;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measure.NormalizationMeasure;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public abstract class MeasureEvaluation extends FormBasedEvaluation {

    /**
     * There should be typically only one measure available. If the factor is
     * measured by more than one measure, select the measure that shall be used
     * for this evaluation.
     */
    @Getter
    @Setter
    protected Measure basedOn;
    /**
     * Define a normalization measure for normalizing the measure that is used
     * for evaluation.
     */
    @Getter
    @Setter
    protected NormalizationMeasure normalization;
    /**
     * Normalize a measure of type finding by the suitable entity. Available
     * ranges are methodRange, classRange, and fileRange.
     */
    @Getter
    @Setter
    protected NormalizationRange range;
    /**
     * Select the function (Linear Increasing Points or Linear Decreasing
     * Points) and define upper and lower bounds.
     */
    @Getter
    @Setter
    protected Function function;

    /**
     *
     */
    public MeasureEvaluation() {
        super();
    }

    public MeasureEvaluation(String identifier) {
        super(identifier);
    }

    protected MeasureEvaluation(String name, Measure basedOn, NormalizationMeasure normalization, NormalizationRange range, Function function,
                                Double completeness, Double maximumPoints, String title, String description, Factor evaluates,
                                String identifier, Source originatesFrom, List<Tag> taggedBy, List<Annotation> annotations) {
        super(name, completeness, maximumPoints, title, description, evaluates, identifier, originatesFrom, taggedBy, annotations);
        this.basedOn = basedOn;
        this.normalization = normalization;
        this.range = range;
        this.function = function;
    }

    public String generateXMLTag(String type) {
        Map<String, String> attrs = Maps.newHashMap();
        List<String> content = Lists.newArrayList();

        if (getBasedOn() != null)
            attrs.put("basedOn", getBasedOn().getQualifiedIdentifier());
        if (getRange() != null)
            attrs.put("range", getRange().toString());

        if (normalization != null) {
            content.add(String.format("<normlizationMeasure href=\"%s\" />%n", normalization.getQualifiedIdentifier()));
        }
        if (function != null) {
            content.add(function.xmlTag());
        }

        return generateXMLTag(type, attrs, content);
    }
}
