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
package edu.montana.gsoc.msusel.quamoco.graph.node;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringEscapeUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.graph.MutableNetwork;

/**
 * Node representing a factor in the Quamoco processing graph. A
 * Factor can be a quality characteristic, sub-characteristic or intermediary,
 * but it is not a direct measure related to the product.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class FactorNode extends Node {

    /**
     * The method associated with aggregation.
     */
    @Getter
    @Setter
    private String method;
    /**
     * The set of all findings connected to this factor (via the graph)
     */
    @Getter
    private Set<Finding> findings;

    /**
     * Constructs a new Factor node in the given graph, with the given name, and
     * associated with the owner id in a Quality Model.
     *
     * @param graph Graph in which this factor will be located.
     * @param name  Name of the factor
     * @param owner Id of the entity in a quality model this node represents.
     */
    public FactorNode(final MutableNetwork<Node, Edge> graph, final String name, final String owner) {
        super(graph, name, owner);
        method = FactorMethod.MEAN;
        findings = Sets.newHashSet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getValue() {
        if (!calculated) {
            value = processor.process();
        }

        calculated = true;
        return value;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTag() {
        return String.format(
                "<nodes name=\"%s\" description=\"%s\" owner=\"%s\" type=\"FACTOR\">%n",
                StringEscapeUtils.escapeXml10(name), StringEscapeUtils.escapeXml10(description), ownedBy) +
                "\t</nodes>";
    }

    /**
     * Sets the method indicating how aggregation is performed.
     *
     * @param method The new method.
     */
    public void setMethod(final String method) {
        final List<String> methods = Lists.newArrayList();
        methods.add(FactorMethod.MANUAL);
        methods.add(FactorMethod.MEAN);
        methods.add(FactorMethod.ONE);
        methods.add(FactorMethod.RANKING);

        if (method == null || method.isEmpty() || !methods.contains(method)) {
            throw new IllegalArgumentException();
        }

        this.method = method;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getLowerResult() {
        final List<BigDecimal> values = Lists.newArrayList();
        for (final Edge e : graph.inEdges(this)) {
            final Node n = getOpposite(e);
            values.add(n.getValue());
        }

        return values.isEmpty() ? BigDecimal.ZERO : Collections.min(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getUpperResult() {
        final List<BigDecimal> values = Lists.newArrayList();
        for (final Edge e : graph.inEdges(this)) {
            final Node n = getOpposite(e);
            values.add(n.getValue());
        }

        return values.isEmpty() ? BigDecimal.ONE : Collections.max(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Finding> getFindings() {
        if (findings == null || findings.isEmpty()) {
            for (Edge edge : graph.inEdges(this)) {
                Node n = getOpposite(edge);
                findings.addAll(n.getFindings());
            }
        }

        return findings;
    }
}
