/**
 * The MIT License (MIT)
 * <p>
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.quamoco.distiller;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.graph.node.*;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;
import lombok.Getter;

import java.util.Map;
import java.util.Set;

/**
 * A Parameter Object containing maps of Identifiers and Nodes,
 * a Map of Quality Models indexed by Name, and a List of known Quality Models.
 * This object is used in the construction of the Quamoco Processing Graph.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class DistillerData {

    /**
     * Map of known quality models indexed by name.
     */
    @Getter
    private ModelManager manager;
    /**
     * Map of factor nodes indexed by the item they represents, in a quality
     * model, identifier
     */
    private final BiMap<QMElement, Node> factorMap = HashBiMap.create();
    /**
     * Map of measure nodes indexed by the item they represents, in a quality
     * model, identifier
     */
    final BiMap<QMElement, Node> measureMap = HashBiMap.create();
    /**
     * Map of value and finding nodes indexed by the item they represents, in a
     * quality model, identifier
     */
    final BiMap<QMElement, Node> valuesMap = HashBiMap.create();
    /**
     * Map of findings union nodes indexed by the item they represents, in a
     * quality model, identifier
     */
    final BiMap<QMElement, Node> unionsMap = HashBiMap.create();
    /**
     * Map of known evaluator, indexed by the id of the item evaluated
     */
    private Map<Factor, Evaluation> evaluatesMap;

    /**
     * Constructs a new DistillerData object for the given list of QualityModel
     * objects.
     *
     * @param manager
     *            The model manager
     */
    public DistillerData(ModelManager manager) {
        this.manager = manager;
        evaluatesMap = Maps.newHashMap();
    }

    /**
     * @return Map of evaluations
     */
    public Map<Factor, Evaluation> getEvalMap() {
        return evaluatesMap;
    }

    /**
     * @param source
     *            The measure whose owner is required
     * @return The QMElement from which the given node was derived
     */
    public QMElement getMeasureOwner(Node source) {
        return measureMap.inverse().get(source);
    }

    /**
     * Retrieves the MeasureNode associated with the Given Measure entity from
     * the Quamoco instance
     *
     * @param measure
     *            Measure Entity
     * @return Measure Node
     */
    public Node getMeasure(Measure measure) {
        return measureMap.get(measure);
    }

    /**
     * Retrieves the Factor entity from which the given FactorNode was derived
     *
     * @param source
     *            FactorNode
     * @return Factor entity
     */
    public QMElement getFactorOwner(Node source) {
        return factorMap.inverse().get(source);
    }

    /**
     * Retrieves the FactorNode derived from the given Factor entity
     *
     * @param factor
     *            Factor Entity
     * @return FactorNode
     */
    public Node getFactor(Factor factor) {
        return factorMap.get(factor);
    }

    /**
     * Retrieves the MeasurementMethod entity from which the given ValueNode was
     * derived
     *
     * @param source
     *            ValueNode
     * @return MeasurementMethod entity
     */
    public QMElement getValueOwner(Node source) {
        return valuesMap.inverse().get(source);
    }

    /**
     * Retrieves the associated ValueNode for the given MeasurementMethod entity
     *
     * @param method
     *            MeasurementMethod entity
     * @return The associated ValueNode for the given MeasurementMethod entity,
     *         or null if no such association exists.
     */
    public Node getValue(MeasurementMethod method) {
        if (method == null || !valuesMap.containsKey(method))
            return null;

        return valuesMap.get(method);
    }

    /**
     * Retrieves the associated MeasurementMethod entity associated with the
     * given FindingsUnion node.
     *
     * @param source
     *            FindingsUnionNode
     * @return MeasurementMethod associated with the given node, or null if no
     *         such association exists.
     */
    public QMElement getUnionOwner(Node source) {
        if (source == null || !unionsMap.containsValue(source))
            return null;

        return unionsMap.inverse().get(source);
    }

    /**
     * Adds a the provided Node representing the given entity to both the
     * provided graph and Map.
     *
     * @param entity
     *            Entity the node represents.
     * @param node
     *            Node to be added.
     */
    public void addNode(final QMElement entity, final Node node) {
        node.setOwnedBy(entity.getIdentifier());

        if (node instanceof FactorNode) {
            factorMap.put(entity, node);
        } else if (node instanceof MeasureNode) {
            measureMap.put(entity, node);
        } else if (node instanceof ValueNode) {
            valuesMap.put(entity, node);
        } else if (node instanceof FindingsUnionNode) {
            unionsMap.put(entity, node);
        }
    }

    /**
     * @return The set of Factor entities present across all loaded quality
     *         models.
     */
    public Set<QMElement> getFactors() {
        return factorMap.keySet();
    }

    /**
     * @return The set of Measure entities present across all loaded quality
     *         models
     */
    public Set<QMElement> getMeasures() {
        return measureMap.keySet();
    }

    /**
     * @return The set of MeasurementMethod entities present across all loaded
     *         quality models
     */
    public Set<QMElement> getValues() {
        return valuesMap.keySet();
    }

    /**
     * Adds a FindingsUnionNode associated with the given MeasurementMethod
     * entity.
     *
     * @param method
     *            MeasurementMethod entity
     * @param node
     *            FindingsUnionNode
     */
    public void addUnion(MeasurementMethod method, Node node) {
        if (method != null && node != null)
            unionsMap.put(method, node);
    }

    /**
     * Adds the given value node for the given measurement method to the data.
     *
     * @param method
     *            MeasurementMethod
     * @param node
     *            ValueNode
     */
    public void addValue(MeasurementMethod method, Node node) {
        if (method != null && node != null)
            valuesMap.put(method, node);
    }

    /**
     * @param method
     *            Retrieves a FindingsUnion Node for the given MeasurementMethod
     *            entity.
     * @return A finding node which is a union for the given measurement method
     *         entity
     */
    public Node getUnion(MeasurementMethod method) {
        return unionsMap.get(method);
    }

    /**
     * @return Set of all union measurement methods across all loaded Quality
     *         Models.
     */
    public Set<QMElement> getUnions() {
        return unionsMap.keySet();
    }
}
