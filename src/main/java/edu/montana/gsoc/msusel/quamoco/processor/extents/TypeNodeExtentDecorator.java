package edu.montana.gsoc.msusel.quamoco.processor.extents;

import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.codetree.node.member.MethodNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;
import edu.montana.gsoc.msusel.metrics.MeasuresTable;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class TypeNodeExtentDecorator extends AbstractNodeExtentDecorator {

    public TypeNodeExtentDecorator(AbstractNode node) {
        super(node);
    }

    @Override
    public NormalizationRange findRange(String metric) {
        if (MeasuresTable.instance.hasMetric(decorated, metric)) {
            return NormalizationRange.CLASS;
        } else {
            return NormalizationRange.FILE;
        }
    }

    @Override
    public BigDecimal findFileExtent(String metric) {
        AbstractNode file = (AbstractNode) MeasuresTable.getInstance().getTree().getUtils().findParent(this);
        return new BigDecimal((double) MeasuresTable.instance.retrieve(file, metric));
    }

    @Override
    public BigDecimal findMethodExtent(String metric) {
        TypeNode t = (TypeNode) decorated;
        return sumMetrics(metric, (List<MethodNode>) t.methods());
    }

    @Override
    public BigDecimal findClassExtent(String metric) {
        return new BigDecimal((double) MeasuresTable.instance.retrieve(decorated, metric));
    }


}
