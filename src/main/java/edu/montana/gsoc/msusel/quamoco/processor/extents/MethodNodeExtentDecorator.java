package edu.montana.gsoc.msusel.quamoco.processor.extents;

import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;
import edu.montana.gsoc.msusel.metrics.MeasuresTable;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.math.BigDecimal;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class MethodNodeExtentDecorator extends AbstractNodeExtentDecorator {

    public MethodNodeExtentDecorator(AbstractNode node) {
        super(node);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public NormalizationRange findRange(String metric) {
        AbstractNode p = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(decorated);
        if (MeasuresTable.instance.hasMetric(this, metric)) {
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
    public BigDecimal findFileExtent(String metric) {
        AbstractNode type = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(decorated);
        AbstractNode file = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(type);

        return new BigDecimal((double) MeasuresTable.instance.retrieve(file, metric));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal findMethodExtent(String metric) {
        return new BigDecimal((double) MeasuresTable.instance.retrieve(decorated, metric));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal findClassExtent(String metric) {
        AbstractNode p = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(decorated);

        if (p instanceof TypeNode) {
            return new BigDecimal((double) MeasuresTable.instance.retrieve(p, metric));
        }

        return BigDecimal.ZERO;
    }
}
