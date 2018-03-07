package edu.montana.gsoc.msusel.quamoco.distiller;

import com.google.common.collect.Sets;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.Network;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Set;

public class DistilledView {

    public static void main(String args[]) {
        Path p2 = Paths.get("msusel-quamoco/data/test/Test.qm");
        Path p = Paths.get("msusel-quamoco/data/test/TestHier.qm");
        Path dot = Paths.get(".");

        ModelManager manager = new ModelManager();
        final ModelDistiller distiller = new ModelDistiller(manager);
        distiller.readInQualityModels(p2.toString(), p.toString());
        distiller.buildGraph(p);
        Network<Node, Edge> graph = distiller.getGraph();

        saveDOTFile("/home/isaac/test/linux2win/distilled.dot", graph, null);
    }

    public static String generateDot(Network<Node, Edge> graph, String name) {
        StringBuilder builder = new StringBuilder();
        if (name != null)
            builder.append("digraph \"" + name + "\" {\n");
        else
            builder.append("digraph {\n");

        Set<Node> set = Sets.newHashSet();
        for (Edge e : graph.edges()) {
            EndpointPair<Node> pair = graph.incidentNodes(e);
            set.add(pair.nodeU());
            set.add(pair.nodeV());
            builder.append("\t\"" + pair.source().getName() + "\" -> \"" + pair.target().getName() + "\"\n");
        }

        for (Node n : graph.nodes()) {
            if (!set.contains(n))
                builder.append("\t\"" + n.getName() + "\"\n");
        }

        builder.append("}");

        return builder.toString();
    }

    static void saveDOTFile(String filename, Network<Node, Edge> graph, String name) {
        String dot = generateDot(graph, name);

        Path p = Paths.get(filename);

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(p, StandardOpenOption.CREATE, StandardOpenOption.WRITE))) {
            pw.print(dot);
        } catch (IOException e) {
            //log.error(e.getMessage());
        }
    }
}
