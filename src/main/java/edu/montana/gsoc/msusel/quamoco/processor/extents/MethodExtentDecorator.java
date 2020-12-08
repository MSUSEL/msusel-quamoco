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

import edu.isu.isuese.datamodel.Measurable;
import edu.isu.isuese.datamodel.Measure;
import edu.isu.isuese.datamodel.Type;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.util.Objects;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MethodExtentDecorator extends AbstractExtentDecorator {

    public MethodExtentDecorator(Measurable node) {
        super(node);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NormalizationRange findRange(String metric) {
        Measurable p = decorated.getParent();
        if (Measure.hasMetric(decorated, metric)) {
            return NormalizationRange.METHOD;
        } else if (Measure.hasMetric(p, metric)) {
            return NormalizationRange.CLASS;
        } else {
            return NormalizationRange.FILE;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double findFileExtent(String metric) {
        Measurable type = decorated.getParent();
        Measurable file = type.getParent();

        return Objects.requireNonNull(Measure.retrieve(file, metric)).getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double findMethodExtent(String metric) {
        return Objects.requireNonNull(Measure.retrieve(decorated, metric)).getValue();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double findClassExtent(String metric) {
        Measurable p = decorated.getParent();

        System.out.println("MethodExtentDecorator.findClassExtent Metric: " + metric);
        System.out.println("P: " + p.getRefKey());

        if (p instanceof Type) {
            return Objects.requireNonNull(Measure.retrieve(p, metric)).getValue();
        }

        return 0.0;
    }
}
