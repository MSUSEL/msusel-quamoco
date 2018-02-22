package edu.montana.gsoc.msusel.quamoco.processor.extents;

import com.google.common.collect.Sets;
import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.codetree.node.structural.NamespaceNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;
import edu.montana.gsoc.msusel.metrics.MeasuresTable;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class NamespaceNodeExtentDecorator extends AbstractNodeExtentDecorator {

    public NamespaceNodeExtentDecorator(AbstractNode node) {
        super(node);
    }

    @Override
    public NormalizationRange findRange(String metric) {
        return null;
    }

    @Override
    public BigDecimal findFileExtent(String metric) {
        NamespaceNode p = (NamespaceNode) decorated;
        Set<FileNode> files = Sets.newHashSet();
        for (TypeNode tn : (List<TypeNode>) p.types()) {
            files.add((FileNode) MeasuresTable.getInstance().getTree().getUtils().findParent(tn));
        }

        return sumMetrics(metric, files);
    }

    @Override
    public BigDecimal findMethodExtent(String metric) {
        NamespaceNode p = (NamespaceNode) decorated;
        return sumMetrics(metric, p.methods());
    }

    @Override
    public BigDecimal findClassExtent(String metric) {
        NamespaceNode p = (NamespaceNode) decorated;
        return sumMetrics(metric, (List<TypeNode>) p.types());
    }
}
