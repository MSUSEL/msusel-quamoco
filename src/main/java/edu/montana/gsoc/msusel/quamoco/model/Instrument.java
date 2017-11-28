/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.quamoco.model;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * A tool is a software program, which is used to collect measurement data. This
 * can be, for example, a static analysis tool.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class Instrument extends MeasurementMethod {

    /**
     * Constructs a new instance of Instrument
     * 
     * @param metric
     *            name of the new Instrument instance
     */
    public Instrument(String metric)
    {
        super(metric);
    }

    public Instrument(String metric, String identifier)
    {
        super(metric, identifier);
    }

    protected Instrument(Measure determines, String metric, String description, String title,
                                String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations)
    {
        super(determines, metric, description, title, identifier, originatesFrom, tags, annotations);
    }
}
