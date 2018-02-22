package edu.montana.gsoc.msusel.quamoco.processor.extents;

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

    public FieldNodeExtentDecorator(AbstractNode node) {
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
