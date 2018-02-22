package edu.montana.gsoc.msusel.quamoco.processor.extents;

import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.codetree.node.member.MethodNode;
import edu.montana.gsoc.msusel.codetree.node.structural.FileNode;
import edu.montana.gsoc.msusel.codetree.node.structural.ProjectNode;
import edu.montana.gsoc.msusel.codetree.node.type.TypeNode;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class ProjectNodeExtentDecorator extends AbstractNodeExtentDecorator {

    public ProjectNodeExtentDecorator(AbstractNode node) {
        super(node);
    }

    @Override
    public NormalizationRange findRange(String metric) {
        return null;
    }

    @Override
    public BigDecimal findFileExtent(String metric) {
        ProjectNode p = (ProjectNode) decorated;
        return sumMetrics(metric, (List<FileNode>) p.files());
    }

    @Override
    public BigDecimal findMethodExtent(String metric) {
        ProjectNode p = (ProjectNode) decorated;
        return sumMetrics(metric, (List<MethodNode>) p.methods());
    }

    @Override
    public BigDecimal findClassExtent(String metric) {
        ProjectNode p = (ProjectNode) decorated;
        return sumMetrics(metric, (List<TypeNode>) p.types());
    }
}
