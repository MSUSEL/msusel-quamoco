/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
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

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Queue;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import edu.montana.gsoc.msusel.quamoco.io.QMXMLReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.graph.node.Node;
import edu.montana.gsoc.msusel.quamoco.model.QualityModel;

/**
 * Distills a processing graph from a set of Quamoco Quality Models.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ModelDistiller {

    /**
     * Logger
     */
    private static final Logger        LOG = LoggerFactory.getLogger(ModelDistiller.class);
    /**
     * Processing graph to be created
     */
    private MutableNetwork<Node, Edge> graph;
    /**
     * Language
     */
    private String                     language;
    /**
     * List of known quality models
     */
    List<QualityModel>                 models;

    /**
     * Constructor
     */
    public ModelDistiller()
    {
        graph = NetworkBuilder.directed()
                .allowsParallelEdges(true)
                .allowsSelfLoops(false)
                .expectedNodeCount(10000)
                .expectedEdgeCount(10000)
                .build();
        models = Lists.newArrayList();
    }

    /**
     * Controls the construction of the graph.
     */
    public void buildGraph()
    {
        final String[] files = selectQMFiles();
        buildGraph(files);
    }

    /**
     * @param files
     */
    public void buildGraph(String... files)
    {
        models = readInQualityModels(files);
        final DistilledGraphCreator creator = new DistilledGraphCreator();
        graph = creator.buildGraph(models);
    }

    /**
     * Controls the construction of the graph based on the given path to a
     * Quality Model file.
     * 
     * @param path
     *            path to the quality model to load
     */
    public void buildGraph(Path path)
    {
        models = readInQualityModels(path);
        final DistilledGraphCreator creator = new DistilledGraphCreator();
        graph = creator.buildGraph(models);
    }

    /**
     * @return The processing graph.
     */
    public MutableNetwork<Node, Edge> getGraph()
    {
        return graph;
    }

    /**
     * @return the language
     */
    public String getLanguage()
    {
        return language;
    }

    /**
     * Reads quality models from the Jar
     *
     * @param args
     *            list of quality models to be read from the Jar file.
     * @return List of Quality Model objects created from the read files.
     */
    private List<QualityModel> readInQualityModels(final String... args)
    {
        final QMXMLReader qmRead = new QMXMLReader();
        final List<QualityModel> models = Lists.newArrayList();
        if (args != null)
        {
            try
            {
                for (final String arg : args)
                {
                    qmRead.firstPass(arg);
                    models.add(qmRead.getModel());
                }

                for (final String arg : args)
                {
                    qmRead.secondPass(arg);
                }
            }
            catch (ParserConfigurationException | SAXException | IOException e)
            {
                ModelDistiller.LOG.warn(e.getMessage(), e);
            }
        }

        return models;
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
    private List<QualityModel> readInQualityModels(Path path)
    {
        final QMXMLReader qmRead = new QMXMLReader();
        final List<QualityModel> models = Lists.newArrayList();
        final Path baseDir = path.toAbsolutePath().getParent();
        Queue<Path> paths = Queues.newArrayDeque();
        Queue<Path> pStack = Queues.newArrayDeque();
        paths.offer(path);

        Map<String, QualityModel> modelMap = new HashMap<>();

        while (!paths.isEmpty())
        {
            Path p = paths.poll();
            pStack.offer(p);
            if (Files.exists(p))
            {
                try
                {
                    final XMLInputFactory factory = XMLInputFactory.newInstance();
                    final InputStream stream = Files.newInputStream(p, StandardOpenOption.READ);
                    final XMLStreamReader reader = factory.createXMLStreamReader(stream);
                    while (reader.hasNext())
                    {
                        final int event = reader.next();

                        switch (event)
                        {
                        case XMLStreamConstants.START_ELEMENT:
                            if (reader.getLocalName().equals("requires"))
                            {
                                String other = reader.getAttributeValue(null, "href");
                                if (other.contains("#"))
                                {
                                    String x = other.split("#")[0];

                                    if (!modelMap.containsKey(x))
                                    {
                                        if (baseDir != null)
                                        {
                                            Path next = baseDir.resolve(x);
                                            paths.offer(next);
                                        }
                                        else
                                        {
                                            paths.offer(Paths.get(x));
                                        }
                                    }
                                }
                            }
                        }
                    }

                    qmRead.firstPass(p.toString());
                    QualityModel model = qmRead.getModel();
                    modelMap.put(p.getFileName().toString(), model);
                    models.add(qmRead.getModel());
                }
                catch (XMLStreamException | ParserConfigurationException | SAXException | IOException e)
                {
                    LOG.warn("Could not read file at: " + path.toString());
                }
            }
        }

        while (!pStack.isEmpty())
        {
            try
            {
                qmRead.secondPass(pStack.poll().toString());
            }
            catch (ParserConfigurationException | SAXException | IOException e)
            {
                e.printStackTrace();
            }
        }

        return models;
    }

    /**
     * @return List of string names representing the selected quality model
     *         files.
     */
    private String[] selectQMFiles()
    {
        String[] retVal = null;
        if (language != null && !language.isEmpty())
        {
            final Properties prop = new Properties();
            try
            {
                final InputStream stream = this.getClass().getResourceAsStream("languages.properties");
                prop.load(stream);
                stream.close();

                retVal = ((String) prop.get(language)).split(",");
            }
            catch (final IOException e)
            {
                ModelDistiller.LOG.warn(e.getMessage(), e);
            }
        }

        return retVal;
    }

    /**
     * @param language
     *            the language to set
     */
    public void setLanguage(final String language)
    {
        this.language = language;
    }

    /**
     * @return List of all loaded quality models
     */
    public List<QualityModel> getModelList()
    {
        return models;
    }

    /**
     * @param qmFileLocations
     */
    public void buildGraph(Map<Class, String> qmFileLocations)
    {
        // TODO Auto-generated method stub
        
    }
}
