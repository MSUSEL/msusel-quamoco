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
package edu.montana.gsoc.msusel.quamoco.processor.extents;

import edu.isu.isuese.datamodel.File;
import edu.isu.isuese.datamodel.Measurable;
import edu.isu.isuese.datamodel.Measure;
import edu.isu.isuese.datamodel.Metric;
import edu.montana.gsoc.msusel.quamoco.distiller.QuamocoContext;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.util.Objects;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class FileExtentDecorator extends AbstractExtentDecorator {

    public FileExtentDecorator(Measurable node) {
        super(node);
    }

    @Override
    public NormalizationRange findRange(String metric) {
        return NormalizationRange.FILE;
    }

    @Override
    public double findFileExtent(String metric) {
        Measure meas = Measure.retrieve(decorated, metric);
        if (meas == null)
            meas = Measure.retrieve(decorated, QuamocoContext.instance().getMetricRepoKey() + ":" + metric);
        return Objects.requireNonNull(meas).getValue();
    }

    @Override
    public double findMethodExtent(String metric) {
        File f = (File) decorated;
        return sumMetrics(metric, f.getAllMethods());
    }

    @Override
    public double findClassExtent(String metric) {
        File f = (File) decorated;
        return sumMetrics(metric, f.getAllTypes());
    }
}
