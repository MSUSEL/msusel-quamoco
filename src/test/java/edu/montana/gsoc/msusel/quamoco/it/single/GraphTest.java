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

import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import org.junit.After;
import org.junit.Test;

import java.util.Map;

public class GraphTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGraph() {
        System.out.println("Num Nodes: " + graph.nodes().size());
        System.out.println("Num Edges: " + graph.edges().size());

        Map<String, Integer> counts = Maps.newHashMap();
        for (Node n : graph.nodes()) {
            String key = n.getClass().getSimpleName();
            if (counts.containsKey(key)) {
                counts.put(key, counts.get(key) + 1);
            } else {
                counts.put(key, 1);
            }
            System.out.println(key + ": " + n);
        }

        for (Edge e : graph.edges()) {
            String key = e.getClass().getSimpleName();
            System.out.println(key + ": " + e.getName());
        }

        counts.forEach((key, count) -> System.out.printf("Key: %s, Count: %d%n", key, count));
    }
}
