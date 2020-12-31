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
package edu.montana.gsoc.msusel.quamoco.graph.node;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.distiller.QuamocoContext;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.RankedEdge;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.processor.FindingsAggregator;
import edu.montana.gsoc.msusel.quamoco.processor.Normalizer;
import edu.montana.gsoc.msusel.quamoco.processor.extents.Extent;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * MeasureNode -
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MeasureNode extends Node {

    /**
     * The type associated with this measure
     */
    @Getter
    @Setter
    private MeasureType type;
    /**
     * The method associated with this measure
     */
    @Getter
    @Setter
    private String method;
    /**
     * The set of findings collected in this node
     */
    private Set<Finding> findings;

    /**
     * Constructs a new MeasureNode which is contained in the given graph,
     * identified by the given name, extracted from the quamoco model entity
     * with
     * the given identifier.
     *
     * @param name  Identifier of this node
     * @param owner Identifier of the quamoco model entity this node came from
     */
    public MeasureNode(final String name, final String owner) {
        this(null, name, owner);
    }

    public MeasureNode(MutableNetwork<Node, Edge> graph, final String name, final String owner) {
        super(graph, name, owner);
        type = MeasureType.FINDINGS;
        findings = Sets.newHashSet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getValue() {
        if (!calculated) {
            if (type == MeasureType.NUMBER) {
                return processor.process();
            } else if (type == MeasureType.FINDINGS) {
                return 0.0;
            }

            return 1.0;
        } else {
            return value;
        }
    }

    public double normalize(double value) {
        double norm = (value - getLowerResult()) / (getUpperResult() - getLowerResult());
        return Double.isNaN(norm) ? 0.0 : norm;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTag() {
        return String.format(
                "<nodes name=\"%s\" description=\"%s\" owner=\"%s\" type=\"MEASURE\">\n",
                StringEscapeUtils.escapeXml10(name), StringEscapeUtils.escapeXml10(description), ownedBy) +
                "\t</nodes>";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Finding> getFindings() {
        if (type.equals(MeasureType.FINDINGS)) {
            findings = ((FindingsAggregator) processor).processFindings();
        }

        return findings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getLowerResult() {
        final List<Double> values = collectFindingExtents();

        return values.isEmpty() ? 0.0 : Collections.min(values);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getUpperResult() {
        final List<Double> values = collectFindingExtents();

        return values.isEmpty() ? 1.0 : Collections.max(values);
    }

    /**
     * @return the list of extents of the findings attached to this
     * measure
     */
    private List<Double> collectFindingExtents() {
        final List<Double> values = Lists.newArrayList();

        if (type.equals(MeasureType.FINDINGS)) {
            for (final Edge e : graph.inEdges(this)) {
                final Node n = getOpposite(e);
                if (e instanceof RankedEdge) {
                    final RankedEdge we = (RankedEdge) e;
                    final Normalizer norm = we.getNormalizer();

                    if (n instanceof MeasureNode) {
                        values.add(
                                Extent.getInstance().findMeasureExtent(
                                        norm.getMetric(), norm.getRange(), (MeasureNode) n));
                    } else if (n instanceof FindingNode) {
                        values.add(
                                Extent.getInstance().findFindingExtent(
                                        QuamocoContext.instance().getProject(), norm.getMetric(),
                                        norm.getRange(), (FindingNode) n));
                    }
                }
            }
        } else {
            for (final Edge e : graph.inEdges(this)) {
                final Node n = getOpposite(e);
                values.add(n.getValue());
            }
        }

        return values;
    }
}
