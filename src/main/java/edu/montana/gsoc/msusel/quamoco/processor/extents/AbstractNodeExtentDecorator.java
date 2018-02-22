package edu.montana.gsoc.msusel.quamoco.processor.extents;

import com.google.common.annotations.VisibleForTesting;
import edu.montana.gsoc.msusel.codetree.INode;
import edu.montana.gsoc.msusel.codetree.node.AbstractNode;
import edu.montana.gsoc.msusel.metrics.MeasuresTable;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public abstract class AbstractNodeExtentDecorator extends AbstractNode {

    protected AbstractNode decorated;

    public AbstractNodeExtentDecorator(AbstractNode node) {
        super(null, null);
        this.decorated = node;
    }

    @Override
    public Object type() {
        return decorated.type();
    }

    @Override
    public Object name() {
        return decorated.name();
    }

    @Override
    public void update(INode other) {
        decorated.update(other);
    }

    @Override
    public INode cloneNoChildren() {
        return decorated.cloneNoChildren();
    }

    @Override
    public Object extractTree(Object tree) {
        return decorated.extractTree(tree);
    }

    public abstract NormalizationRange findRange(String metric);

    public abstract BigDecimal findFileExtent(String metric);

    public abstract BigDecimal findMethodExtent(String metric);

    public abstract BigDecimal findClassExtent(String metric);

    /**
     * Sums the values of the given name across the given collection of nodes.
     *
     * @param metric
     *            Name of the name to be summed.
     * @param nodes
     *            Collection of nodes
     * @return Sum of the named name
     * @throws IllegalArgumentException
     *             if the name name is null, empty, or no such name has been
     *             stored in any of the nodes
     */
    @VisibleForTesting
    BigDecimal sumMetrics(final String metric, Collection<? extends AbstractNode> nodes) {
        if (metric == null || metric.isEmpty())
            throw new IllegalArgumentException("Metric name cannot be null or empty");

        BigDecimal value = BigDecimal.ZERO;

        for (AbstractNode node : nodes) {
            value = value.add(new BigDecimal((double) MeasuresTable.instance.retrieve(node, metric)));
        }

        return value;
    }
}
