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
import java.util.Set;

import com.google.common.collect.Sets;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.uci.ics.jung.graph.DirectedSparseGraph;

/**
 * A node which collects findings into a Set. Findings are simply reports of
 * that a static analysis rule was activated in a tool.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class FindingNode extends Node {

    /**
     * Associated static analysis rule name for which the collected findings are
     * reports of
     */
    private String             ruleName;
    /**
     * The name of the tool providing the findings for this node
     */
    private final String       toolName;
    /**
     * The set of findings accumulated in this node.
     */
    private final Set<Finding> findings;

    /**
     * Constructs a new FindingNode which is contained in the given graph,
     * identified by the given name, extracted from the quamoco model entity
     * with the given identifier.
     * 
     * @param graph
     *            Graph to which this node belongs
     * @param name
     *            Identifier of this node
     * @param owner
     *            Identifier of the quamoco model entity this node came from
     * @param ruleName
     *            Name of the rule to which this finding indicates a violation
     *            of
     * @param toolName
     *            Tool which provides the rules
     */
    public FindingNode(final DirectedSparseGraph<Node, Edge> graph, final String key, final String owner,
            final String ruleName, final String toolName)
    {
        super(graph, key, owner);
        this.ruleName = ruleName;
        this.toolName = toolName;
        findings = Sets.newHashSet();
    }

    /**
     * @return Name of the rule this finding is a report of
     */
    public String getRuleName()
    {
        return ruleName;
    }

    /**
     * @param ruleName
     *            New name of the rule for this finding
     */
    public void setRuleName(final String ruleName)
    {
        this.ruleName = ruleName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getValue()
    {
        calculated = true;
        return BigDecimal.ZERO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getXMLTag()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Finding> getFindings()
    {
        return findings;
    }

    /**
     * Adds a new violation (finding) to this FindingNode. If the finding was
     * new (not a repeat or null) then this method returns true, otherwise it
     * returns false.
     * 
     * @param finding
     *            An instance of a violation of the rule linked to this finding
     *            node
     * @return true if the finding was able to be added, false otherwise
     */
    public boolean addFinding(final Finding finding)
    {
        if (finding == null)
        {
            return false;
        }

        findings.add(finding);
        return true;
    }

    /**
     * @return The tool providing findings for this FindingNode
     */
    public String getToolName()
    {
        return toolName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getLowerResult()
    {
        return BigDecimal.ZERO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal getUpperResult()
    {
        return BigDecimal.ONE;
    }
}
