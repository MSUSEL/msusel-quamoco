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
package edu.montana.gsoc.msusel.quamoco.model.measurement;

import edu.montana.gsoc.msusel.quamoco.io.factories.MeasurementMethodType;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

/**
 * A manual instrument describes a manual way to collect the data for a measure.
 * This can, for example, be part of a code review.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class ManualInstrument extends Instrument {

    /**
     * Constructs an new ManualInstrument with the given name
     *
     * @param metric The simple name of this instrument
     */
    public ManualInstrument(String metric) {
        super(metric);
    }

    /**
     * Constructs an new ManualInstrument with the given name and identifier.
     *
     * @param metric     The simple name of this instrument
     * @param identifier The unique identifier of this instrument
     */
    private ManualInstrument(String metric, String identifier) {
        super(metric, identifier);
    }

    @Builder(buildMethodName = "create")
    protected ManualInstrument(Measure determines, String metric, String description, String title,
                               String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations)
    {
        super(determines, metric, description, title, identifier, originatesFrom, tags, annotations);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        return generateXMLTag(MeasurementMethodType.MANUAL_INSTRUMENT.type());
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
