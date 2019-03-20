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

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.io.qm.QMXMLReader;
import edu.montana.gsoc.msusel.quamoco.model.QualityModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Distills a processing graph from a set of Quamoco Quality Models.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class ModelDistiller {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(ModelDistiller.class);
    /**
     * Processing graph to be created
     */
    private MutableNetwork<Node, Edge> graph;
    /**
     * Language
     */
    private String language;
    /**
     *
     */
    private ModelManager manager;

    /**
     * Constructor
     */
    public ModelDistiller(ModelManager manager) {
        graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        this.manager = manager;
    }

    /**
     * Controls the construction of the graph.
     */
    public void buildGraph() {
        final String[] files = selectQMFiles();
        buildGraph(files);
    }

    /**
     * @param files
     */
    public void buildGraph(String... files) {
        readInQualityModels(files);
        final DistilledGraphCreator creator = new DistilledGraphCreator();
        graph = creator.buildGraph(manager);
    }

    /**
     * Controls the construction of the graph based on the given path to a
     * Quality Model file.
     *
     * @param path
     *            path to the quality model to load
     */
    public void buildGraph(Path path) {
        //readInQualityModels(path);
        final DistilledGraphCreator creator = new DistilledGraphCreator();
        graph = creator.buildGraph(manager);
    }

    /**
     * @return The processing graph.
     */
    public MutableNetwork<Node, Edge> getGraph() {
        return graph;
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Reads quality models from the Jar
     *
     * @param args
     *            list of quality models to be read from the Jar file.
     * @return List of Quality Model objects created from the read files.
     */
    public void readInQualityModels(final String... args) {
        final QMXMLReader qmRead = new QMXMLReader(manager);
        if (args != null) {
            try {
                for (final String arg : args) {
                    qmRead.firstPass(arg);
                }

                for (final String arg : args) {
                    qmRead.secondPass(arg);
                }

                for (final String arg : args) {
                    qmRead.thirdPass(arg);
                }
            } catch (ParserConfigurationException | SAXException | IOException e) {
                ModelDistiller.LOG.warn(e.getMessage(), e);
            }
        }
    }

    /**
     * Reads in a set of quality models starting from the given path. If the
     * path is a file and it actually exists, it will be treated as the lowest
     * level quality model (closest to a language). Any other quality models
     * that the given model depends upon will then be loaded as needed.
     *
     * @param path
     *            Path to the lowest level quality model.
     * @return List of quality models loaded
     */
    public List<QualityModel> readInQualityModels(Path path) {
        final QMXMLReader qmRead = new QMXMLReader(manager);
        final List<QualityModel> models = Lists.newArrayList();
        final Path baseDir = path.toAbsolutePath().getParent();

        Stack<Path> stack = new Stack<>();
        Queue<Path> queue = Queues.newArrayDeque();
        queue.offer(path);

        try {
            while (!queue.isEmpty()) {
                Path p = queue.poll();
                if (!stack.contains(p))
                    stack.push(p);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = dbFactory.newDocumentBuilder();
                Document doc = builder.parse(Files.newInputStream(p, StandardOpenOption.READ));
                doc.getDocumentElement().normalize();

                XPath xPath = XPathFactory.newInstance().newXPath();
                String expression = "QualityModel/requires";
                try {
                    NodeList nodes = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
                    if (nodes.getLength() > 0) {
                        for (int i = 0; i < nodes.getLength(); i++) {
                            if (nodes.item(i).getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                                Element e = (Element) nodes.item(i);
                                if (e.hasAttribute("href")) {
                                    Path p2 = Paths.get(baseDir.toAbsolutePath().toString(), e.getAttribute("href").split("#")[0]);
                                    if (!queue.contains(p2))
                                        queue.offer(p2);
                                }
                            }
                        }
                    }
                } catch (XPathExpressionException ex) {

                }
            }
        } catch (Exception e) {

        }

        List<String> list = Lists.newArrayList();
        while (!stack.empty())
            list.add(stack.pop().toAbsolutePath().toString());

        readInQualityModels(list.toArray(new String[0]));

        return models;
    }

    /**
     * @return List of string names representing the selected quality model
     *         files.
     */
    private String[] selectQMFiles() {
        String[] retVal = null;
        if (language != null && !language.isEmpty()) {
            final Properties prop = new Properties();
            try {
                final InputStream stream = this.getClass().getResourceAsStream("languages.properties");
                prop.load(stream);
                stream.close();

                retVal = ((String) prop.get(language)).split(",");
            } catch (final IOException e) {
                ModelDistiller.LOG.warn(e.getMessage(), e);
            }
        }

        return retVal;
    }

    /**
     * @param language
     *            the language to set
     */
    public void setLanguage(final String language) {
        this.language = language;
    }

    /**
     * @param qmFileLocations
     */
    public void buildGraph(Map<Class, String> qmFileLocations) {
        // TODO Auto-generated method stub

    }
}
