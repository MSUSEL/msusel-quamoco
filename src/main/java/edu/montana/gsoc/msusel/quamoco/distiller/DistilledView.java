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

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class DistilledView {

    public static void main(String args[]) {
        Path p2 = Paths.get("msusel-quamoco/data/test/TestHier.qm");
        Path dot = Paths.get(".");

        ModelManager manager = new ModelManager();
        final ModelDistiller distiller = new ModelDistiller(manager);
        distiller.readInQualityModels(p2);
        distiller.buildGraph(p2);
        Network<Node, Edge> graph = distiller.getGraph();

        saveDOTFile("/home/isaac/test/linux2win/distilled.dot", graph, null);
    }


    public static String generateDot(Network<Node, Edge> graph, String name) {
        StringBuilder builder = new StringBuilder();
        if (name != null)
            builder.append("digraph \"" + name.replaceAll("\"", "") + "\" {\n");
        else
            builder.append("digraph {\n");

        Set<Node> set = Sets.newHashSet();
        for (Edge e : graph.edges()) {
            EndpointPair<Node> pair = graph.incidentNodes(e);
            set.add(pair.nodeU());
            set.add(pair.nodeV());
            builder.append("\t\"" + pair.source().getName().replaceAll("\"", "") + "\" -> \"" + pair.target().getName().replaceAll("\"", "") + "\"\n");
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
