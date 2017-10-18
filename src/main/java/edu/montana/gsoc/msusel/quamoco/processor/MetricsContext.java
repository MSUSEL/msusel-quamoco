/**
 * The MIT License (MIT)
 *
 * SparQLine Quamoco Implementation
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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

import java.util.List;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.sparqline.codetree.CodeTree;
import com.sparqline.codetree.INode;
import com.sparqline.codetree.node.FileNode;
import com.sparqline.codetree.node.MethodNode;
import com.sparqline.codetree.node.ProjectNode;
import com.sparqline.codetree.node.TypeNode;

/**
 * Singleton class providing global access to the main code tree of the system
 * as well as several convenience methods for accessing metrics at different
 * scopes.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class MetricsContext {

    /**
     * The system code tree
     */
    protected CodeTree tree = new CodeTree();

    /**
     * A private static inner class used to hold the singleton instance
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    private static class FactoryHelper {

        /**
         * The singleton instance
         */
        private static final MetricsContext INSTANCE = new MetricsContext();
    }

    /**
     * Constructs a new instance of MetricsContext
     */
    private MetricsContext()
    {
        tree = new CodeTree();
    }

    /**
     * @return The singleton instance
     */
    public static MetricsContext getInstance()
    {
        return FactoryHelper.INSTANCE;
    }

    /**
     * @return A fresh reset of the singleton instance
     */
    public static MetricsContext getCleanInstance()
    {
        return FactoryHelper.INSTANCE.clean();

    }

    /**
     * Retrieves the value of the metric for the FileNode with the given
     * identifier.
     * 
     * @param identifier
     *            FileNode's identifier
     * @param metric
     *            Metric name
     * @return double value of the metric, or NaN if there is no such file node
     *         with the given identifier
     * @throws IllegalArgumentException
     *             if the metric name is null or empty or if the identifier is
     *             null or empty
     */
    public double getFileMetric(final String identifier, final String metric)
    {
        if (metric == null || metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric name cannot be null or the empty string.");
        }

        if (identifier == null || identifier.isEmpty())
        {
            throw new IllegalArgumentException("Identifier name cannot be null or the empty string.");
        }

        FileNode fn = tree.getUtils().getFile(identifier);
        if (fn != null)
            return fn.getMetric(metric);
        return Double.NaN;
    }

    /**
     * Retrieves the value of the metric for the MethodNode with the given
     * identifier.
     * 
     * @param identifier
     *            MethodNode's identifier
     * @param metric
     *            Metric name
     * @return double value of the metric, or NaN if there is no such method
     *         node with the given identifier
     * @throws IllegalArgumentException
     *             if the metric name is null or empty or if the identifier is
     *             null or empty
     */
    public double getMethodMetric(final String identifier, final String metric)
    {
        if (metric == null || metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric name cannot be null or the empty string.");
        }

        if (identifier == null || identifier.isEmpty())
        {
            throw new IllegalArgumentException("Identifier name cannot be null or the empty string.");
        }

        MethodNode mn = tree.getUtils().findMethod(identifier);
        if (mn != null)
            return mn.getMetric(metric);
        return Double.NaN;
    }

    /**
     * @param identifier
     * @param metric
     * @return
     * @throws MetricsContextException
     */
    public double getTypeMetric(final String identifier, final String metric)
    {
        if (metric == null || metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric name cannot be null or the empty string.");
        }

        if (identifier == null || identifier.isEmpty())
        {
            throw new IllegalArgumentException("Identifier name cannot be null or the empty string.");
        }

        TypeNode tn = tree.getUtils().findType(identifier);
        if (tn != null)
            return tn.getMetric(metric);
        return Double.NaN;
    }

    /**
     * Retrieves the system project value of the metric with the given name
     * 
     * @param metric
     *            Metric name
     * @return double value of the project-level metric, or NaN if there is no
     *         project in the code tree.
     * @throws IllegalArgumentException
     *             if the metric name is null or empty
     */
    public double getProjectMetric(final String metric)
    {
        if (metric == null || metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric name cannot be null or the empty string.");
        }

        ProjectNode pn = tree.getProject();
        if (pn != null)
            return pn.getMetric(metric);
        return Double.NaN;
    }

    /**
     * Retrieves a listing of the values for the given metric across all types
     * in the system.
     * 
     * @param metric
     *            Metric name
     * @return List of all types' values for the given metric
     * @throws IllegalArgumentException
     *             if the metric name is null or empty
     */
    public List<Double> getAllClassValues(final String metric)
    {
        if (metric == null || metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric name cannot be null or the empty string.");
        }

        final List<Double> list = Lists.newArrayList();

        tree.getUtils().getTypes().forEach((type) -> {
            double value = type.getMetric(metric);
            if (!Double.isNaN(value))
                list.add(value);
        });

        return list;
    }

    /**
     * Retrieves a listing of the values for the given metric across all files
     * in the system.
     * 
     * @param metric
     *            Metric name
     * @return List of all files' values for the given metric
     * @throws IllegalArgumentException
     *             if the metric name is null or empty
     */
    public List<Double> getAllFileValues(final String metric)
    {
        if (metric == null || metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric name cannot be null or the empty string.");
        }

        final List<Double> list = Lists.newArrayList();

        tree.getUtils().getFiles().forEach((file) -> {
            double value = file.getMetric(metric);
            if (!Double.isNaN(value))
                list.add(value);
        });

        return list;
    }

    /**
     * Retrieves a listing of the values for the given metric across all methods
     * in the system.
     * 
     * @param metric
     *            Metric name
     * @return List of all methods' values for the given metric
     * @throws IllegalArgumentException
     *             if the metric name is null or empty
     */
    public List<Double> getAllMethodValues(final String metric)
    {
        if (metric == null || metric.isEmpty())
        {
            throw new IllegalArgumentException("Metric name cannot be null or the empty string.");
        }

        final List<Double> list = Lists.newArrayList();

        tree.getUtils().getMethods().forEach((method) -> {
            double value = method.getMetric(metric);
            if (!Double.isNaN(value))
                list.add(value);
        });

        return list;
    }

    /**
     * Retrieves the parent node of the provided node.
     * 
     * @param cnode
     *            Node whose parent is being requested.
     * @return Parent of the provided node, null if no such parent exists or the
     *         parent identifier is null.
     * @throws IllegalArgumentException
     *             if the provided node is null
     */
    public INode getParent(INode cnode)
    {
        if (cnode == null)
            throw new IllegalArgumentException("INode cannot be null");

        if (cnode instanceof MethodNode)
        {
            for (TypeNode type : tree.getUtils().getTypes())
            {
                if (type.hasMethod((MethodNode) cnode))
                    return type;
            }
        }
        else if (cnode instanceof TypeNode)
        {
            for (FileNode file : tree.getUtils().getFiles())
            {
                if (file.hasType((TypeNode) cnode))
                    return file;
            }
        }

        return null;
    }

    /**
     * Updates a node in the code tree with the values of the given node.
     * 
     * @param node
     *            node used for the update.
     * @throws IllegalArgumentException
     *             if the given node is null.
     */
    public void update(INode node)
    {
        if (node == null)
            throw new IllegalArgumentException("Node cannot be null.");
        if (node instanceof ProjectNode)
            tree.getUtils().updateRootProject((ProjectNode) node);
        else if (node instanceof FileNode)
            tree.getUtils().updateFile((FileNode) node);
    }

    /**
     * Merges the current code tree with the provided one.
     * 
     * @param tree
     *            Tree to merge into the currently held tree.
     */
    public void merge(CodeTree tree)
    {
        if (tree == null)
            return;

        if (this.tree == null)
            this.tree = tree;
        else
            this.tree.getUtils().merge(tree);
    }

    /**
     * @return resets the metrics context to empty
     */
    @VisibleForTesting
    MetricsContext clean()
    {
        tree = null;
        return this;
    }

    /**
     * @return The current code tree stored in the metrics context
     */
    public CodeTree getTree()
    {
        return tree;
    }

    /**
     * Sets the code tree when a merge operation is inappropriate
     * 
     * @param tree
     *            The new tree.
     */
    public void setTree(CodeTree tree)
    {
        this.tree = tree;
    }
}
