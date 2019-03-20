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

import com.google.common.collect.Sets;
import com.google.common.graph.MutableNetwork;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * A node which collects findings into a Set. Findings are simply reports of
 * that a static analysis rule was activated in a tool.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class FindingNode extends Node {

    /**
     * Associated static analysis rule name for which the collected findings are
     * reports of
     */
    @Getter
    @Setter
    private String ruleName;
    /**
     * The name of the tool providing the findings for this node
     */
    @Getter
    private final String toolName;
    /**
     * The set of findings accumulated in this node.
     */
    @Getter
    private Set<Finding> findings;

    /**
     * Constructs a new FindingNode which is contained in the given graph,
     * identified by the given name, extracted from the quamoco model entity
     * with the given identifier.
     *
     * @param key      Identifier of this node
     * @param owner    Identifier of the quamoco model entity this node came from
     * @param ruleName Name of the rule to which this finding indicates a violation
     *                 of
     * @param toolName Tool which provides the rules
     */
    public FindingNode(final String key, final String owner,
                       final String ruleName, final String toolName) {
        this(null, key, owner, ruleName, toolName);
    }

    public FindingNode(MutableNetwork<Node, Edge> graph, final String key, final String owner,
                       final String ruleName, final String toolName) {
        super(graph, key, owner);
        this.ruleName = ruleName;
        this.toolName = toolName;
        findings = Sets.newHashSet();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getValue() {
//        calculated = true;
        return 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTag() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Adds a new violation (finding) to this FindingNode. If the finding was
     * new (not a repeat or null) then this method returns true, otherwise it
     * returns false.
     *
     * @param finding An instance of a violation of the rule linked to this finding
     *                node
     * @return true if the finding was able to be added, false otherwise
     */
    public boolean addFinding(final Finding finding) {
        if (finding == null) {
            return false;
        }

        findings.add(finding);
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getLowerResult() {
        return 0.0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getUpperResult() {
        return 1.0;
    }
}
