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
package edu.montana.gsoc.msusel.quamoco.model.measurement.aggregation;

import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import lombok.Singular;

import java.util.List;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public abstract class FormBasedMeasureAggregation extends MeasureAggregation {

    /**
     *
     */
    public FormBasedMeasureAggregation() {
        super();
    }

    public FormBasedMeasureAggregation(String identifier) {
        super(identifier);
    }

    protected FormBasedMeasureAggregation(@Singular List<Measure> aggregates, Measure determines, String metric, String description, String title,
                                          String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(aggregates, determines, metric, description, title, identifier, originatesFrom, tags, annotations);
    }

    public void addAggregate(Measure measure) {
        if (measure == null || aggregates.contains(measure))
            return;

        aggregates.add(measure);
    }

    public void removeAggregate(Measure measure) {
        if (measure == null || !aggregates.contains(measure)) {
            return;
        }

        aggregates.remove(measure);
    }
}
