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
package edu.montana.gsoc.msusel.quamoco.it.single;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FactorToFactorEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FactorNode;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.processor.NullProcessor;
import edu.montana.gsoc.msusel.quamoco.processor.evaluators.WeightedSumEvaluator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WeightedSumTest {

    @Test
    public void test() {
        MutableNetwork<Node, Edge> graph = NetworkBuilder.directed().allowsSelfLoops(false).build();
        FactorNode fn = new FactorNode(graph, "factor1", "owner");

        FactorNode sub1 = new FactorNode(graph, "subfactor1", "sub1");
        FactorNode sub2 = new FactorNode(graph, "subfactor2", "sub2");
        FactorNode sub3 = new FactorNode(graph, "subfactor3", "sub3");
        FactorNode sub4 = new FactorNode(graph, "subfactor4", "sub4");

        sub1.setProcessor(new NullProcessor(sub1));
        sub2.setProcessor(new NullProcessor(sub1));
        sub3.setProcessor(new NullProcessor(sub1));
        sub4.setProcessor(new NullProcessor(sub1));

        fn.setProcessor(new WeightedSumEvaluator(fn));

        FactorToFactorEdge f2f1 = new FactorToFactorEdge("f2f1", sub1, fn, InfluenceEffect.POSITIVE);
        FactorToFactorEdge f2f2 = new FactorToFactorEdge("f2f2", sub2, fn, InfluenceEffect.POSITIVE);
        FactorToFactorEdge f2f3 = new FactorToFactorEdge("f2f3", sub3, fn, InfluenceEffect.POSITIVE);
        FactorToFactorEdge f2f4 = new FactorToFactorEdge("f2f4", sub4, fn, InfluenceEffect.POSITIVE);

        graph.addNode(fn);
        graph.addNode(sub1);
        graph.addNode(sub2);
        graph.addNode(sub3);
        graph.addNode(sub4);
        graph.addEdge(sub1, fn, f2f1);
        graph.addEdge(sub2, fn, f2f2);
        graph.addEdge(sub3, fn, f2f3);
        graph.addEdge(sub4, fn, f2f4);

        f2f1.setRank(1);
        f2f2.setRank(1);
        f2f3.setRank(1);
        f2f4.setRank(1);

        f2f1.setWeight(0.25);
        f2f2.setWeight(0.25);
        f2f3.setWeight(0.25);
        f2f4.setWeight(0.25);

        assertEquals(0.25, f2f1.getValue(), 0.001);
        assertEquals(0.25, f2f2.getValue(), 0.001);
        assertEquals(0.25, f2f3.getValue(), 0.001);
        assertEquals(0.25, f2f4.getValue(), 0.001);

        assertEquals(1.0, fn.getValue(), 0.001);
    }
}
