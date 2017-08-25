/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.quamoco.processor;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Sets;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.INode;
import edu.montana.gsoc.msusel.node.FieldNode;
import edu.montana.gsoc.msusel.node.FileNode;
import edu.montana.gsoc.msusel.node.MethodNode;
import edu.montana.gsoc.msusel.node.ModuleNode;
import edu.montana.gsoc.msusel.node.NamespaceNode;
import edu.montana.gsoc.msusel.node.ProjectNode;
import edu.montana.gsoc.msusel.node.StatementNode;
import edu.montana.gsoc.msusel.node.TypeNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.graph.node.FindingNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.util.CodeTreeUtils;

/**
 * Class used to evaluate the extent that a set of findings has across a
 * software system. This is accomplished by evaluating the set based on some
 * normalizing metric across some given range.
 * <br>
 * We assume that if a finding is locates on a line within a method then that
 * entire method is affected by that finding. If the finding is located within a
 * type but not within a method of that type, then we assume the entire type is
 * affected by that finding. Finally, we assume that if the finding is within a
 * file, but not located within a method or type defined in the file, then it
 * affects the entire file.
 * <br>
 * Once the location of each finding in the set is identified. We then need to
 * be able to evaluate the effect of this finding set on the entire software
 * system. This is where ranges and metrics come into play. There are four
 * ranges: Method, Class, File, and NA. Basically we need to calculate the total
 * value of the metric across all the effected entities and then divide this by
 * the total value of the metric across the system. This is done as follows for
 * each of the ranges:
 * <ul>
 * <li>Method: if each finding only affects a method, then summing the metric
 * value for each affected method and dividing by the sum of the metric for all
 * the methods in the system is the correct proportion. If any finding affects a
 * type or file, then we sum (for that finding) the metric for all contained
 * methods.
 * <li>Type: if each finding only affects a type, then summing the metric value
 * for each affected type and dividing by the sum of the metric for all types in
 * the system will provided the correct proportion. On the other hand if any
 * finding affects only a method, then we need to use the metric value for the
 * type containing the method. If the finding affects a file, then we must sum
 * the metric values for all contained types.
 * <li>File: if each finding only affects a file, then summing the metric value
 * for each affect file and dividing by the sum of the metric for all files will
 * provide the correct proportion. On the other hand if any finding affects a
 * method or type, then we must use the metric value for the containing file.
 * <li>NA: This one is much simpler. Regardless of what the finding affects, we
 * always select the smallest possible unit (File, Type, or Method). We then sum
 * the metric value for each finding and divide by the system value for that
 * metric.
 * </ul>
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Extent {

    /**
     * Map of project-wide metric extents: key = range, value = (key = metric
     * name, value = metric) extent value
     */
    private final Map<NormalizationRange, Map<String, BigDecimal>> totalMetricExtents;
    /**
     * The metric context for the system.
     */
    private final MetricsContext                                   context;

    /**
     * A private static inner class used to hold the singleton instance of this
     * Extent class.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class ExtentHelper {

        /**
         * The singleton instance
         */
        private static final Extent INSTANCE = new Extent();
    }

    /**
     * Constructs a new extent object
     */
    private Extent()
    {
        context = MetricsContext.getInstance();
        totalMetricExtents = new HashMap<>();
        for (final NormalizationRange range : NormalizationRange.values())
        {
            totalMetricExtents.put(range, new HashMap<String, BigDecimal>());
        }
    }

    /**
     * @return The single instance of Extent
     */
    public static Extent getInstance()
    {
        return ExtentHelper.INSTANCE;
    }

    /**
     * Determines the extent for a MeasureNode given the normalization metric
     * and normalization range.
     * 
     * @param metric
     *            Normalization metric
     * @param range
     *            Normalization range
     * @param measures
     *            MeasureNode to normalize
     * @return Normalized value of the findings in the given measure node.
     * @throws IllegalArgumentException
     *             if the measure is null or its type is NUMBER, the metric is
     *             null or empty, or the range is null.
     */
    public BigDecimal findMeasureExtent(final String metric, final NormalizationRange range, final MeasureNode measure)
    {
        if (measure == null)
        {
            throw new IllegalArgumentException("Measure cannot be null");
        }

        if (measure.getType() == MeasureType.NUMBER)
        {
            throw new IllegalArgumentException("Cannot find extent of Numerical Value");
        }

        if (metric == null || metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric name cannot be null or the empty string.");
        }

        if (range == null)
        {
            throw new IllegalArgumentException("Range cannot be null.");
        }

        final Set<Finding> findingsSet = Sets.newHashSet();
        findingsSet.addAll(measure.getFindings());

        BigDecimal total = findFindingsExtent(metric, findingsSet, range);

        return total.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ZERO : total;
    }

    /**
     * Finds the extent of a given Finding for the provided normalization metric
     * and range
     * 
     * @param finding
     *            Finding whose extent is required
     * @param metric
     *            Normalization metric
     * @param range
     *            Normalization range
     * @return Extent of the normalization metric for the given finding
     */
    public BigDecimal findExtent(final Finding finding, final String metric, final NormalizationRange range)
    {
        BigDecimal value = BigDecimal.ZERO;
        INode c = finding.getLocation();

        switch (range)
        {
        case CLASS:
            value = findClassExtent(context.getTree(), c, metric);
            break;
        case FILE:
            value = findFileExtent(context.getTree(), c, metric);
            break;
        case METHOD:
            value = findMethodExtent(context.getTree(), c, metric);
            break;
        }

        return value;
    }

    /**
     * Finds the method range extent for a given node in the provide code tree
     * for the given normalization metric.
     * 
     * @param tree
     *            CodeTree used to evaluate metric
     * @param node
     *            Node whose extent is to be evaluated
     * @param metric
     *            Normalization metric
     * @return method range extent of node
     */
    @VisibleForTesting
    BigDecimal findMethodExtent(CodeTree tree, INode node, String metric)
    {
        BigDecimal value = BigDecimal.ZERO;
        CodeTreeUtils utils = tree.getUtils();

        if (node instanceof FieldNode)
        {

        }
        else if (node instanceof StatementNode)
        {
            INode m = utils.findParent(node);
            if (m instanceof TypeNode)
            {
                value = new BigDecimal(m.getMetric(metric));
            }
        }
        else if (node instanceof MethodNode)
        {
            value = new BigDecimal(node.getMetric(metric));
        }
        else if (node instanceof TypeNode)
        {
            TypeNode t = (TypeNode) node;
            value = sumMetrics(metric, t.getMethods());
        }
        else if (node instanceof FileNode)
        {
            FileNode f = (FileNode) node;
            value = sumMetrics(metric, f.getMethods());
        }
        else if (node instanceof ModuleNode)
        {
            ModuleNode m = (ModuleNode) node;
            value = sumMetrics(metric, m.getMethods());
        }
        // else if (c instanceof NamespaceNode)
        // {
        // NamespaceNode p = (NamespaceNode) c;
        // value = sumMetrics(metric, p.getMethods());
        // }
        else if (node instanceof ProjectNode)
        {
            ProjectNode p = (ProjectNode) node;
            value = sumMetrics(metric, p.getMethods());
        }

        return value;
    }

    /**
     * Finds the file range extent for a given node in the provide code tree
     * for the given normalization metric.
     * 
     * @param tree
     *            CodeTree used to evaluate metric
     * @param node
     *            Node whose extent is to be evaluated
     * @param metric
     *            Normalization metric
     * @return file range extent of node
     */
    @VisibleForTesting
    BigDecimal findFileExtent(CodeTree tree, INode node, String metric)
    {
        BigDecimal value = BigDecimal.ZERO;
        CodeTreeUtils utils = tree.getUtils();

        if (node instanceof FieldNode)
        {
            INode t = utils.findParent(node);
            INode f = utils.findParent(t);
            if (f instanceof FileNode)
            {
                value = new BigDecimal(f.getMetric(metric));
            }
        }
        else if (node instanceof StatementNode)
        {
            INode m = utils.findParent(node);
            INode t = utils.findParent(m);
            INode f = utils.findParent(t);
            value = new BigDecimal(f.getMetric(metric));
        }
        else if (node instanceof MethodNode)
        {
            INode t = utils.findParent(node);
            INode f = utils.findParent(t);
            value = new BigDecimal(f.getMetric(metric));
        }
        else if (node instanceof TypeNode)
        {
            INode f = utils.findParent(node);
            value = new BigDecimal(f.getMetric(metric));
        }
        else if (node instanceof FileNode)
        {
            value = new BigDecimal(node.getMetric(metric));
        }
        else if (node instanceof ModuleNode)
        {
            ModuleNode m = (ModuleNode) node;
            value = sumMetrics(metric, m.getFiles());
        }
        else if (node instanceof NamespaceNode)
        {
            NamespaceNode p = (NamespaceNode) node;
            Set<FileNode> files = Sets.newHashSet();
            for (TypeNode tn : p.getTypes())
            {
                files.add((FileNode) utils.findParent(tn));
            }
            value = sumMetrics(metric, files);
        }
        else if (node instanceof ProjectNode)
        {
            ProjectNode p = (ProjectNode) node;
            value = sumMetrics(metric, p.getFiles());
        }

        return value;
    }

    /**
     * Finds the class range extent for a given node in the provide code tree
     * for the given normalization metric.
     * 
     * @param tree
     *            CodeTree used to evaluate metric
     * @param node
     *            Node whose extent is to be evaluated
     * @param metric
     *            Normalization metric
     * @return class range extent of node
     */
    @VisibleForTesting
    BigDecimal findClassExtent(CodeTree tree, INode c, String metric)
    {
        BigDecimal value = BigDecimal.ZERO;
        CodeTreeUtils utils = tree.getUtils();

        if (c instanceof FieldNode)
        {
            INode p = utils.findParent(c);
            if (p instanceof TypeNode)
            {
                value = new BigDecimal(p.getMetric(metric));
            }
        }
        else if (c instanceof StatementNode)
        {
            INode m = utils.findParent(c);
            INode p = utils.findParent(m);
            if (p instanceof TypeNode)
            {
                value = new BigDecimal(p.getMetric(metric));
            }
        }
        else if (c instanceof MethodNode)
        {
            INode p = utils.findParent(c);
            if (p instanceof TypeNode)
            {
                value = new BigDecimal(p.getMetric(metric));
            }
        }
        else if (c instanceof TypeNode)
        {
            value = new BigDecimal(c.getMetric(metric));
        }
        else if (c instanceof FileNode)
        {
            FileNode f = (FileNode) c;
            value = sumMetrics(metric, f.getTypes());
        }
        else if (c instanceof ModuleNode)
        {
            ModuleNode m = (ModuleNode) c;
            value = sumMetrics(metric, m.getTypes());
        }
        else if (c instanceof NamespaceNode)
        {
            NamespaceNode p = (NamespaceNode) c;
            value = sumMetrics(metric, p.getTypes());
        }
        else if (c instanceof ProjectNode)
        {
            ProjectNode p = (ProjectNode) c;
            value = sumMetrics(metric, p.getTypes());
        }

        return value;
    }

    /**
     * Sums the values of the given metric across the given collection of nodes.
     * 
     * @param metric
     *            Name of the metric to be summed.
     * @param nodes
     *            Collection of nodes
     * @return Sum of the named metric
     * @throws IllegalArgumentException
     *             if the metric name is null, empty, or no such metric has been
     *             stored in any of the nodes
     */
    @VisibleForTesting
    BigDecimal sumMetrics(final String metric, Collection<? extends INode> nodes)
    {
        if (metric == null || metric.isEmpty())
            throw new IllegalArgumentException("Metric name cannot be null or empty");

        BigDecimal value = BigDecimal.ZERO;

        for (INode node : nodes)
        {
            value = value.add(new BigDecimal(node.getMetric(metric)));
        }

        return value;
    }

    /**
     * Finds the system-wide extent of the given metric for the given range.
     * 
     * @param metric
     *            Metric name
     * @param range
     *            Normalization range
     * @return total value of the given metric in the system for the given
     *         range.
     * @throws IllegalArgumentException
     *             if the metric name is null or empty or the range is null.
     */
    public BigDecimal findExtent(final String metric, final NormalizationRange range)
    {
        if (metric == null || metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric cannot be null or empty");
        }

        if (range == null)
        {
            throw new IllegalArgumentException("Range cannot be null.");
        }

        if (totalMetricExtents.containsKey(range))
        {
            if (totalMetricExtents.get(range).containsKey(metric))
            {
                return totalMetricExtents.get(range).get(metric);
            }
        }

        BigDecimal total = BigDecimal.ZERO;
        List<Double> values = null;
        switch (range)
        {
        case CLASS:
            values = context.getAllClassValues(metric);
            break;
        case FILE:
            values = context.getAllFileValues(metric);
            break;
        case METHOD:
            values = context.getAllMethodValues(metric);
            break;
        case NA:
            return new BigDecimal(context.getProjectMetric(metric));
        }

        for (Double value : values)
        {
            total = total.add(new BigDecimal(value));
        }

        totalMetricExtents.get(range).put(metric, total);

        return total.compareTo(BigDecimal.ZERO) == 0 ? BigDecimal.ONE : total;
    }

    /**
     * Clears the current set of project-wide extents.
     */
    public void clearExtents()
    {
        totalMetricExtents.clear();
        for (final NormalizationRange range : NormalizationRange.values())
        {
            totalMetricExtents.put(range, new HashMap<String, BigDecimal>());
        }
    }

    /**
     * Detects the appropriate range of a set of findings when the prior range
     * is NA
     * 
     * @param prior
     *            The prior range (assumed to be NormalizationRange.NA)
     * @param findings
     *            The set of findings to search for the proper range over.
     * @return The new normalization range to be used.
     */
    public NormalizationRange findRange(CodeTree tree, String metric, NormalizationRange prior, Set<Finding> findings)
    {
        NormalizationRange newRange = prior;
        CodeTreeUtils utils = tree.getUtils();
        // First find the minimal range;
        for (final Finding f : findings)
        {
            INode c = f.getLocation();
            NormalizationRange temp = null;
            if (c instanceof TypeNode)
            {
                if (c.hasMetric(metric))
                {
                    temp = NormalizationRange.CLASS;
                }
                else
                {
                    temp = NormalizationRange.FILE;
                }
            }
            else if (c instanceof MethodNode)
            {
                INode p = utils.findParent(c);
                if (c.hasMetric(metric))
                {
                    temp = NormalizationRange.METHOD;
                }
                else if (p.hasMetric(metric))
                {
                    temp = NormalizationRange.CLASS;
                }
                else
                {
                    temp = NormalizationRange.FILE;
                }
            }
            else if (c instanceof FileNode)
            {
                temp = NormalizationRange.FILE;
            }
            else if (c instanceof StatementNode)
            {
                INode p = utils.findParent(c);
                INode p2 = utils.findParent(p);
                if (p.hasMetric(metric))
                {
                    temp = NormalizationRange.METHOD;
                }
                else if (p2.hasMetric(metric))
                {
                    temp = NormalizationRange.CLASS;
                }
                else
                {
                    temp = NormalizationRange.FILE;
                }
            }
            else if (c instanceof FieldNode)
            {
                INode p = utils.findParent(c);
                if (p.hasMetric(metric))
                {
                    temp = NormalizationRange.CLASS;
                }
                else
                {
                    temp = NormalizationRange.FILE;
                }
            }
            else
            {
                temp = NormalizationRange.FILE;
            }

            if (temp.compareTo(newRange) < 0)
                newRange = temp;
        }

        return newRange;
    }

    /**
     * Calculates the ratio of the affect a FindingNode has on the entire
     * system. Essentially, this is the ratio of the sum of the normalizing
     * metric across each affected item divided by the total of that metric
     * (within the range of those types of items) across the system.
     * 
     * @param metric
     *            Metric used for normalizing
     * @param normalizationRange
     *            Range for normalizing
     * @param n
     *            The Finging Node whose findings are to be evaluated.
     * @return The ratio representing the presence that this FindingNode has
     *         within the system as a whole.
     */
    public BigDecimal findFindingExtent(CodeTree tree, String metric, NormalizationRange normalizationRange,
            FindingNode n)
    {
        BigDecimal value = BigDecimal.ZERO;
        NormalizationRange range = normalizationRange;
        if (!n.getFindings().isEmpty())
        {
            if (range == NormalizationRange.NA)
            {
                range = findRange(tree, metric, range, n.getFindings());
            }

            value = findFindingsExtent(metric, n.getFindings(), range);
        }

        value = value.divide(findExtent(metric, range));

        return value;
    }

    /**
     * Find the total extent (for the provided metric) that the set of findings
     * has within the system. Basically just a simple total of the metric for
     * the items affected by the provided set of findings.
     * 
     * @param metric
     *            Metric whose extent is to be calculated
     * @param findings
     *            Findings whose locations are to be summed to provide the
     *            extent
     * @param range
     *            Range of the extent
     * @return The extent of affect this set of findings has within the entire
     *         system (unnormalized)
     */
    private BigDecimal findFindingsExtent(String metric, Set<Finding> findings, NormalizationRange range)
    {
        BigDecimal value = BigDecimal.ZERO;

        for (Finding f : findings)
        {
            value = value.add(findExtent(f, metric, range));
        }

        return value;
    }
}
