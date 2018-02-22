package edu.montana.gsoc.msusel.quamoco.processor.extents;

import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;
import edu.montana.gsoc.msusel.metrics.MeasuresTable;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class FileNodeExtentDecorator extends AbstractNodeExtentDecorator {

    public FileNodeExtentDecorator(AbstractNode node) {
        super(node);
    }

    @Override
    public NormalizationRange findRange(String metric) {
        return NormalizationRange.FILE;
    }

    @Override
    public BigDecimal findFileExtent(String metric) {
        return new BigDecimal((double) MeasuresTable.instance.retrieve(this, metric));
    }

    @Override
    public BigDecimal findMethodExtent(String metric) {
        FileNode f = (FileNode) decorated;
        return sumMetrics(metric, f.methods());
    }

    @Override
    public BigDecimal findClassExtent(String metric) {
        FileNode f = (FileNode) decorated;
        return sumMetrics(metric, (List<TypeNode>) f.types());
    }
}
