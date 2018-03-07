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
