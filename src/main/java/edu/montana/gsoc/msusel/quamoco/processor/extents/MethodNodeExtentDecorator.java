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

import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;
import edu.montana.gsoc.msusel.metrics.MeasuresTable;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class MethodNodeExtentDecorator extends AbstractNodeExtentDecorator {

    public MethodNodeExtentDecorator(INode node) {
        super(node);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NormalizationRange findRange(String metric) {
        AbstractNode p = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(decorated);
        if (MeasuresTable.instance.hasMetric(decorated, metric)) {
            return NormalizationRange.METHOD;
        } else if (MeasuresTable.instance.hasMetric(p, metric)) {
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
        AbstractNode type = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(decorated);
        AbstractNode file = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(type);

        return (double) MeasuresTable.instance.retrieve(file, metric);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double findMethodExtent(String metric) {
        return (double) MeasuresTable.instance.retrieve((AbstractNode) decorated, metric);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double findClassExtent(String metric) {
        AbstractNode p = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(decorated);

        if (p instanceof TypeNode) {
            return (double) MeasuresTable.instance.retrieve(p, metric);
        }

        return 0.0;
    }
}
