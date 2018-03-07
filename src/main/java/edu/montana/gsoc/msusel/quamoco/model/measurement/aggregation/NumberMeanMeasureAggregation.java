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
package edu.montana.gsoc.msusel.quamoco.model.measurement.aggregation;

import edu.montana.gsoc.msusel.quamoco.io.factories.MeasurementMethodType;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

/**
 * Indicates that the measure should aggregate incoming value sets using the
 * mean operator
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class NumberMeanMeasureAggregation extends FormBasedMeasureAggregation {

    /**
     * Constructs a new NumberMeanMeasureAggregation.
     */
    public NumberMeanMeasureAggregation() {
        super();
    }

    /**
     * Constructs a new NumberMeanMeasureAggregation with the given unique
     * identifier.
     *
     * @param identifier
     *            The unique identifier
     */
    public NumberMeanMeasureAggregation(String identifier) {
        super(identifier);
    }

    @Builder(buildMethodName = "create")
    protected NumberMeanMeasureAggregation(@Singular List<Measure> aggregates, Measure determines, String metric, String description, String title,
                                           String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(aggregates, determines, metric, description, title, identifier, originatesFrom, tags, annotations);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        return generateXMLTag(MeasurementMethodType.NUMBER_MEAN_MEASURE_AGGREGATION.type());
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
