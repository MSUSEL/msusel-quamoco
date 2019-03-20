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

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

/**
 * DistilledGraphCreator - builds the Quamoco processing graph.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class DistilledGraphCreator {

    /**
     * Builder method to initialize and modify the graph based on data from the
     * known quality models.
     *
     * @param manager
     *            The ModelManager
     * @return Graph constructed from information contained within the provided
     *         QualityModels and DecoratorContext.
     */
    public MutableNetwork<Node, Edge> buildGraph(ModelManager manager)
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(false)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final GraphModifier nodePop = new NodePopulator();
        final GraphModifier edgePop = new EdgePopulator();
        final GraphModifier processPop = new ProcessorPopulator();
        final GraphModifier normPop = new NormalizerPopulator();

        final DistillerData data = new DistillerData(manager);
        nodePop.modifyGraph(data, graph);
        edgePop.modifyGraph(data, graph);
        processPop.modifyGraph(data, graph);
        normPop.modifyGraph(data, graph);

        WeightUpdater updater = new WeightUpdater();
        updater.updateWeights(graph);

        return graph;
    }
}
