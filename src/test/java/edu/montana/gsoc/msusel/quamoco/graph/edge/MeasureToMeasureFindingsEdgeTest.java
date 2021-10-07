/*
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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.isu.isuese.datamodel.File;
import edu.montana.gsoc.msusel.quamoco.graph.node.*;
import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.processor.aggregators.FindingsUnionAggregator;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * The class <code>MeasureToMeasureFindingsEdgeTest</code> contains tests for
 * the class <code>{@link MeasureToMeasureFindingsEdge}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MeasureToMeasureFindingsEdgeTest extends DBSpec {

    private MeasureToMeasureFindingsEdge fixture;

    /**
     * Run the MeasureToMeasureFindingsEdge(String) constructor test.
     */
    @Test
    public void testMeasureToMeasureFindingsEdge_1() {
        final String name = "edge";

        final MeasureToMeasureFindingsEdge result = new MeasureToMeasureFindingsEdge(name, null, null);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(0.0, result.getValue(), 0.001);
        Assert.assertEquals("edge", result.getName());
    }

    /**
     * Run the Set<Finding> getFindings() method test.
     */
    @Test
    public void testGetFindings_1() {
        final List<Finding> result = fixture.getFindings();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }

    /**
     * Run the double getValue() method test.
     */
    @Test
    public void testGetValue_1() {
        final double result = fixture.getValue();

        // add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     */
    @Before
    public void setUp() throws Exception
    {
        final MutableNetwork<Node, Edge> graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        final MeasureNode dest = new MeasureNode("dest", "owner");
        dest.setGraph(graph);
        dest.setType(MeasureType.FINDINGS);
        final MeasureNode src = new MeasureNode("src", "owner");
        src.setGraph(graph);
        src.setType(MeasureType.FINDINGS);
        final FindingNode srcsrc = new FindingNode("key", "owner", "rule", "tool");
        final FindingToMeasureEdge f2m = new FindingToMeasureEdge("preedge", srcsrc, src);
        fixture = new MeasureToMeasureFindingsEdge("fixture", src, dest);
        src.setProcessor(new FindingsUnionAggregator(src));

        srcsrc.addFinding(new FileFinding(File.builder().fileKey("path0").create(), "issue", "issue"));
        srcsrc.addFinding(new FileFinding(File.builder().fileKey("path1").create(), "issue", "issue"));
        srcsrc.addFinding(new FileFinding(File.builder().fileKey("path2").create(), "issue", "issue"));

        graph.addEdge(src, dest, fixture);
        graph.addEdge(srcsrc, src, f2m);
    }
}