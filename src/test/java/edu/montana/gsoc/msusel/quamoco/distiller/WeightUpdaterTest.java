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

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FactorToFactorEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WeightUpdaterTest {

    MutableNetwork<Node, Edge> graph;
    FactorNode root;

    @Test
    public void test() {
        WeightUpdater wu = new WeightUpdater();
        wu.updateWeights(graph);
    }

    @Before
    public void setUp() throws Exception
    {
        graph = NetworkBuilder.directed().allowsSelfLoops(false).build();

        root = new FactorNode("root", "root");
        FactorNode f1 = new FactorNode("f1", "f1");
        FactorNode f2 = new FactorNode("f2", "f2");
        FactorNode f3 = new FactorNode("f3", "f3");

        graph.addEdge(f1, root, new FactorToFactorEdge("ffe1", f1, root, InfluenceEffect.POSITIVE).setRank(1));
        graph.addEdge(f2, root, new FactorToFactorEdge("ffe2", f2, root, InfluenceEffect.POSITIVE).setRank(2));
        graph.addEdge(f3, root, new FactorToFactorEdge("ffe3", f3, root, InfluenceEffect.POSITIVE).setRank(3));
    }

    @After
    public void tearDown() throws Exception
    {
        // TODO: add additional tear down code here
    }
}
