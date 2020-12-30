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
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.INode;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.processor.Processor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Abstract base class for the nodes in the distilled quality model processing
 * graph.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
@EqualsAndHashCode(of = {"name", "ownedBy"})
@ToString(of = "name")
public abstract class Node implements INode {

    /**
     * Graph to which this node belongs
     */
    @Getter
    @Setter
    protected MutableNetwork<Node, Edge> graph;
    /**
     * Value associated with node after evaluation
     */
    protected double value = 0.0;
    /**
     * lower result of this node (min of all incoming values)
     */
    protected double lowerResult = 0.0;
    /**
     * upper result of this node (max of all incoming values)
     */
    protected double upperResult = 1.0;
    /**
     * fully qualified identifier of the quamoco model entity from which this
     * node was derived
     */
    @Getter
    protected String ownedBy;
    /**
     * name of this node
     */
    @Getter
    protected String name;
    /**
     * description of this node
     * TODO remove this
     */
    @Getter
    protected String description;
    /**
     * The process associated with this node, which facilitates the evaluation
     */
    @Getter
    @Setter
    protected Processor processor;
    /**
     * Boolean flag indicating that this node has already successfully been
     * calculated.
     */
    @Getter
    protected boolean calculated;

    /**
     * Constructs a new Node which is contained in the given graph,
     * identified by the given name, extracted from the quamoco model entity
     * with
     * the given identifier.
     *
     * @param name
     *            Identifier of this node
     * @param owner
     *            Identifier of the quamoco model entity this node came from
     */
    public Node(MutableNetwork<Node, Edge> graph, final String name, final String owner) {
        if (name == null || name.isEmpty() || owner == null || owner.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.graph = graph;
        this.name = name;
        description = "";
        ownedBy = owner;
        calculated = false;
    }

    /**
     * Constructs a new Node which is contained in the given graph,
     * identified by the given name, extracted from the quamoco model entity
     * with
     * the given identifier.
     *
     * @param name
     *            Identifier of this node
     * @param owner
     *            Identifier of the quamoco model entity this node came from
     */
    public Node(final String name, final String owner) {
        this(null, name, owner);
    }

    /**
     * @return The evaluated value of this node, which is dependent on all
     *         incoming nodes.
     */
    public abstract double getValue();

    protected void setValue(double value) {
        this.value = value;
    }

    /**
     * @return The xml tag associated with node
     */
    public abstract String getXMLTag();

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDescription(final String description) {
        if (description == null) {
            this.description = "";
        } else {
            this.description = description;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setName(final String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setOwnedBy(final String ownedBy) {
        if (ownedBy == null || ownedBy.isEmpty()) {
            throw new IllegalArgumentException();
        }

        this.ownedBy = ownedBy;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Double> getValues() {
        final List<Double> list = Lists.newArrayList();
        list.add(getValue());

        return list;
    }

    public Node getOpposite(Edge e) {
        EndpointPair<Node> pair = graph.incidentNodes(e);
        if (pair.target().equals(this))
            return pair.source();
        else
            return pair.target();
    }
}
