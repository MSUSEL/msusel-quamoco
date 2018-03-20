/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.quamoco.distiller;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.graph.Network;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.WeightedRankedEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.MeasureNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

import java.util.List;

/**
 * This class is used to update the weights associated with the edges between
 * factors of a distilled quality model graph.
 * 
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class WeightUpdater {

    /**
     * Constructs a new Weight Updater
     */
    public WeightUpdater()
    {
    }

    /**
     * Updates the weights of the edges between factors for the given graph.
     * 
     * @param graph
     *            Distilled quality model processing graph to update
     */
    public void updateWeights(Network<Node, Edge> graph)
    {
        List<Node> nodes = getFactors(graph);

        nodes.forEach((factor) -> updateWeights(factor, graph));

        nodes = getMeasures(graph);

        nodes.forEach((measure) -> updateWeights(measure, graph));
    }

    /**
     * Updates the incoming edge weights for the given factor in the given graph
     * 
     * @param factor
     *            Factor Node whose incoming edge weights require updating.
     * @param graph
     *            Distilled quality model processing graph
     */
    @VisibleForTesting
    void updateWeights(Node factor, Network<Node, Edge> graph)
    {
        List<WeightedRankedEdge> edges = getWeightedEdges(factor, graph);

        int highestRanking = 0;
        int numRankings = 0;

        for (WeightedRankedEdge edge : edges)
        {
            if (edge.getRank() > 0)
                numRankings += 1;
            if (edge.getRank() > highestRanking)
                highestRanking = edge.getRank();
        }

        double[] weights = new double[numRankings + 1];
        for (int i = 1; i <= numRankings; i++)
        {
            double weight = 0.0;
            for (int j = i; j <= numRankings; j++)
            {
                weight += (1.0 / j);
            }
            weights[i] = weight / numRankings;
        }

        int weightIndex = 1;
        for (int i = 1; i <= highestRanking; i++) {
            double weight = 0.0;
            int usagesOfRanking = 0;
            for (WeightedRankedEdge edge : edges) {
                if (edge.getRank() == i)
                    usagesOfRanking += 1;
            }

            if (usagesOfRanking > 0) {
                for (int j = 1; j <= usagesOfRanking; j++) {
                    weight += weights[weightIndex];
                    weightIndex += 1;
                }
                weight /= (double) usagesOfRanking;

                for (WeightedRankedEdge edge : edges) {
                    if (edge.getRank() == i) {
                        edge.setWeight(weight);
                    }
                }
            }
        }

        for (WeightedRankedEdge edge : edges) {
            if (edge.getRank() == 0) {
                edge.setWeight(0.0);
                edge.setMaxPoints(100.0);
            }
        }
    }

    /**
     * Retrieves the list of incoming weighted-ranked edges of the given factor
     * in the given graph.
     * 
     * @param factor
     *            Factor whose edges are required
     * @param graph
     *            Distilled quality model processing graph
     * @return List of incoming weighted ranked edges of the given factor node
     */
    @VisibleForTesting
    List<WeightedRankedEdge> getWeightedEdges(Node factor, Network<Node, Edge> graph)
    {
        List<WeightedRankedEdge> edges = Lists.newArrayList();

        for (Edge edge : graph.inEdges(factor)) {
            if (edge instanceof WeightedRankedEdge)
            {
                edges.add((WeightedRankedEdge) edge);
            }
        }

        return edges;
    }

    /**
     * Retrieves the list of factors filtered from the set of vertices in the
     * given graph.
     * 
     * @param graph
     *            Distilled quality model processing graph
     * @return List of factor nodes contained within the graph
     */
    @VisibleForTesting
    List<Node> getFactors(Network<Node, Edge> graph)
    {
        List<Node> factors = Lists.newArrayList();
        for(Node node : graph.nodes()) {
            if (node instanceof FactorNode)
            {
                factors.add(node);
            }
        }

        return factors;
    }

    List<Node> getMeasures(Network<Node, Edge> graph) {
        List<Node> measures = Lists.newArrayList();
        for (Node node : graph.nodes()) {
            if (node instanceof MeasureNode) {
                measures.add(node);
            }
        }

        return measures;
    }
}
