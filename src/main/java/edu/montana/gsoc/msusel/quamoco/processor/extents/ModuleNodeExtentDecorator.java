package edu.montana.gsoc.msusel.quamoco.processor.extents;

import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.codetree.node.member.MethodNode;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.codetree.node.structural.ModuleNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class ModuleNodeExtentDecorator extends AbstractNodeExtentDecorator {

    public ModuleNodeExtentDecorator(AbstractNode node) {
        super(node);
    }

    @Override
    public NormalizationRange findRange(String metric) {
        return null;
    }

    @Override
    public BigDecimal findFileExtent(String metric) {
        return sumMetrics(metric, (List<FileNode>) (((ModuleNode) decorated).files()));
    }

    @Override
    public BigDecimal findMethodExtent(String metric) {
        ModuleNode m = (ModuleNode) decorated;
        return sumMetrics(metric, (List<MethodNode>) m.methods());
    }

    @Override
    public BigDecimal findClassExtent(String metric) {
        ModuleNode m = (ModuleNode) decorated;
        return sumMetrics(metric, (List<TypeNode>) m.types());
    }
}
