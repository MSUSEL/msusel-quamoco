/*
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
package edu.montana.gsoc.msusel.quamoco.graph;

import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.processor.Processor;

import java.util.List;

/**
 * Defines the basic interface of nodes for a Distilled Quality Model processing
 * graph.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public interface INode {

    /**
     * @return the description of the node
     */
    String getDescription();

    /**
     * @return the name of the node
     */
    String getName();

    /**
     * @return the identifier of the quality model entity from which this node
     *         is derived
     */
    String getOwnedBy();

    /**
     * @param description
     *            the new description of this node
     */
    void setDescription(String description);

    /**
     * @param name
     *            the new name of this node
     */
    void setName(String name);

    /**
     * @param ownedBy
     *            the ownedBy to set
     */
    void setOwnedBy(String ownedBy);

    /**
     * @return The processor assigned to this node.
     */
    Processor getProcessor();

    /**
     * @param processor
     *            The new processor assigned to this node.
     */
    void setProcessor(Processor processor);

    /**
     * @return The value of the lower result derived for this node
     */
    double getLowerResult();

    /**
     * @return The value of the upper result derived for this node
     */
    double getUpperResult();

    /**
     * @return The set of values incoming into this node
     */
    List<Double> getValues();

    /**
     * @return The set of findings incoming into this node
     */
    List<Finding> getFindings();

}