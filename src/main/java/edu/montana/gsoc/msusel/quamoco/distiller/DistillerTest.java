package edu.montana.gsoc.msusel.quamoco.distiller;
import com.google.common.graph.Network;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.QualityModel;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DistillerTest {

    public static void main(String[] args) {
        Path p = Paths.get("msusel-quamoco/data/test/Test.qm");

        buildGraph(p);
    }

    public static Network<Node, Edge> buildGraph(Path path) {
        ModelManager manager = new ModelManager();
        final ModelDistiller distiller = new ModelDistiller(manager);
        distiller.buildGraph(path);

        for (QualityModel model : manager.getModels()) {
            System.out.println(model.getName());
        }

        return distiller.getGraph();
    }
}
