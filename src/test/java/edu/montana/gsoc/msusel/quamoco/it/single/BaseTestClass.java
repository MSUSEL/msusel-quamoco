package edu.montana.gsoc.msusel.quamoco.it.single;

import com.google.common.graph.Network;
import edu.montana.gsoc.msusel.quamoco.distiller.ModelDistiller;
import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import org.junit.Before;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class BaseTestClass {

    ModelManager manager;
    Network<Node, Edge> graph;

    @Before
    public void setUp() throws Exception {
        Path p2 = Paths.get("data/test/Test.qm");
        Path p = Paths.get("data/test/TestHier.qm");
        assertTrue(Files.exists(p));
        manager = new ModelManager();
        final ModelDistiller distiller = new ModelDistiller(manager);
        distiller.readInQualityModels(p2.toString(), p.toString());
        distiller.buildGraph(p);
        graph = distiller.getGraph();
    }
}
