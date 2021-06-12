/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.quamoco.processor.extents;

import com.google.common.annotations.VisibleForTesting;
import edu.isu.isuese.datamodel.File;
import edu.isu.isuese.datamodel.Measurable;
import edu.isu.isuese.datamodel.Measure;
import edu.isu.isuese.datamodel.Project;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public abstract class AbstractExtentDecorator implements Measurable {

    protected Measurable decorated;

    public AbstractExtentDecorator(Measurable node) {
        this.decorated = node;
    }

    public abstract NormalizationRange findRange(String metric);

    public abstract double findFileExtent(String metric);

    public abstract double findMethodExtent(String metric);

    public abstract double findClassExtent(String metric);

    /**
     * @return The parent Measurable of this Measurable
     */
    @Override
    public Measurable getParent() {
        return decorated.getParent();
    }

    @Override
    public Project getParentProject() { return decorated.getParentProject(); }

    /**
     * @return The parent file of this Measurable
     */
    @Override
    public File getParentFile() {
        return decorated.getParentFile();
    }

    /**
     * @return A key based on the id of this Measurable which will be used when constructing the reference held by a Measure
     */
    @Override
    public String getRefKey() {
        return decorated.getRefKey();
    }

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
    double sumMetrics(final String metric, Collection<? extends Measurable> nodes) {
        if (metric == null || metric.isEmpty())
            throw new IllegalArgumentException("Metric name cannot be null or empty");

        double value = 0.0;

        for (Measurable node : nodes) {
            value = value + (Double) Objects.requireNonNull(Measure.retrieve(node, metric)).getValue();
        }

        return value;
    }

    public void addMeasure(Measure meas) {
        decorated.addMeasure(meas);
    }

    public void removeMeasure(Measure meas) {
        decorated.removeMeasure(meas);
    }

    public List<Measure> getMeasures() {
        return decorated.getMeasures();
    }

    public double getValueFor(String metricKey) {
        return decorated.getValueFor(metricKey);
    }
}
