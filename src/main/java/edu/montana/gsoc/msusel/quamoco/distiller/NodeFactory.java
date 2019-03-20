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
package edu.montana.gsoc.msusel.quamoco.distiller;

import com.google.common.annotations.VisibleForTesting;
import edu.montana.gsoc.msusel.quamoco.graph.node.*;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.ManualInstrument;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.measurement.ToolBasedInstrument;
import edu.montana.gsoc.msusel.quamoco.model.measurement.aggregation.FindingsUnionMeasureAggregation;

public class NodeFactory {

    private NodeFactory() {

    }

    private static final class Holder {
        public static final NodeFactory INSTANCE = new NodeFactory();
    }

    public static NodeFactory getInstance() {
        return Holder.INSTANCE;
    }

    public Node createNode(QMElement element) {
        if (element instanceof Factor) {
            return createFactorNode((Factor) element);
        } else if (element instanceof Measure) {
            return createMeasureNode((Measure) element);
        } else if (element instanceof MeasurementMethod) {
            return createProviderNode((MeasurementMethod) element);
        }
        return null;
    }

    private Node createFactorNode(Factor element) {
        String name = element.getFullName();

        final FactorNode node = new FactorNode(name, element.getIdentifier());
//        if (!element.getAnnotations().isEmpty() && element.hasAggregationAnnotation()) {
//            node.setMethod(element.getAggregationAnnotationValue());
//        } else {
//            node.setMethod(FactorMethod.MEAN);
//        }

        return node;
    }

    private Node createProviderNode(MeasurementMethod element) {
        Node node = null;
        String repo = "";

        if (element instanceof ManualInstrument) {
            repo = ValueNode.MANUAL;
        } else if (element instanceof ToolBasedInstrument && ((ToolBasedInstrument) element).getTool() != null) {
            repo = ((ToolBasedInstrument) element).getTool().getName();
        }

        if (element instanceof ToolBasedInstrument) {

            MeasureType type = null;
            if (element.getDetermines() != null) {
                final Measure determines = element.getDetermines();

                type = determines.getType();
            }

            if (type == MeasureType.FINDINGS) {
                node = new FindingNode(element.getName(), element.getIdentifier(), element.getName(), repo);
            } else {
                node = new ValueNode(element.getName(), element.getIdentifier(), repo);
            }
        } else if (element instanceof FindingsUnionMeasureAggregation) {
            node = new FindingsUnionNode(element.getName(), element.getIdentifier());
        } else if (element instanceof ManualInstrument) {
            ManualInstrument mi = (ManualInstrument) element;
            MeasureType type = MeasureType.NUMBER;
            if (mi.getDetermines() != null)
                type = mi.getDetermines().getType();

            if (type == MeasureType.NUMBER)
                node = new ValueNode(element.getName(), element.getIdentifier(), repo);
            else
                node = new FindingNode(element.getName(), element.getIdentifier(), element.getName(), repo);
        }

        return node;
    }

    private Node createMeasureNode(Measure element) {
        MeasureNode node;

        if (element.isNormalizer()) {
            node = new NormalizationNode(element.getFullName(), element.getIdentifier());
            setMeasureNodeProperties(element, node);
        } else {
            node = new MeasureNode(element.getFullName(), element.getIdentifier());
            setMeasureNodeProperties(element, node);
        }

        return node;
    }

    /**
     * Sets a given MeasureNode's properties.
     *
     * @param measure Measure the MeasureNode represents
     * @param node    Node for which properties will be set.
     */
    @VisibleForTesting
    void setMeasureNodeProperties(final Measure measure, final MeasureNode node) {
        // TODO Need to add a field to qm files in order to specify the
        // MeasureMethod correctly
        node.setType(measure.getType());
        if (measure.getType().equals(MeasureType.FINDINGS))
            node.setMethod(MeasureMethod.UNION);
        else
            node.setMethod(MeasureMethod.MEAN);
    }
}
