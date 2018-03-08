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
package edu.montana.gsoc.msusel.quamoco.processor.extents;

import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;
import edu.montana.gsoc.msusel.metrics.MeasuresTable;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.math.BigDecimal;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class FieldNodeExtentDecorator extends AbstractNodeExtentDecorator {

    public FieldNodeExtentDecorator(INode node) {
        super(node);
    }

    @Override
    public NormalizationRange findRange(String metric) {
        AbstractNode parent = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(decorated);
        if (MeasuresTable.instance.hasMetric(this, metric)) {
            return NormalizationRange.CLASS;
        } else {
            return NormalizationRange.FILE;
        }
    }

    @Override
    public BigDecimal findFileExtent(String metric) {
        AbstractNode type = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(decorated);
        AbstractNode file = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(type);

        if (file instanceof FileNode) {
            return new BigDecimal((double) MeasuresTable.instance.retrieve(file, metric));
        }

        return BigDecimal.ZERO;
    }

    @Override
    public BigDecimal findMethodExtent(String metric) {
        return null;
    }

    @Override
    public BigDecimal findClassExtent(String metric) {
        AbstractNode p = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(decorated);

        if (p instanceof TypeNode) {
            return new BigDecimal((double) MeasuresTable.instance.retrieve(p, metric));
        }

        return BigDecimal.ZERO;
    }
}
