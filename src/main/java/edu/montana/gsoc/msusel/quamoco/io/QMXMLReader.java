/**
 * The MIT License (MIT)
 * <p>
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.quamoco.io;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measurement.FactorRanking;
import edu.montana.gsoc.msusel.quamoco.model.func.Function;
import edu.montana.gsoc.msusel.quamoco.model.Impact;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearDecreasingFunction;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearIncreasingFunction;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MeasureRanking;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.QualityModel;
import edu.montana.gsoc.msusel.quamoco.model.Ranking;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.Tool;

/**
 * Class to construct a Quality Model using the XML produced by the Quamoco
 * Quality Model Editor
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class QMXMLReader extends AbstractQuamocoReader {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(QMXMLReader.class);
    /**
     * Quality model under construction
     */
    @Getter
    private QualityModel model;

    /**
     * {@inheritDoc}
     */
    @Override
    public void firstPass(String file) throws ParserConfigurationException, SAXException, IOException {
        Document doc = getDocument(file);
        handleRoot(doc, (qm) -> createModel((Element) qm));

        Map<String, NodeHandler> map = Maps.newHashMap();
        map.put("factors", (n) -> model.addFactor(FactorFactory.instance().create((Element) n)));
        map.put("entities", (n) -> model.addEntity(EntityFactory.instance().create((Element) n)));
        map.put("measures", (n) -> model.addMeasure(MeasureFactory.instance().create((Element) n)));
        map.put("tools", (n) -> createTool((Element) n));
        map.put("tags", (n) -> createTag((Element) n));
        map.put("sources", (n) -> createSource((Element) n));

        for (Entry<String, NodeHandler> set : map.entrySet()) {
            NodeList nodes = doc.getElementsByTagName(set.getKey());
            handleNode(nodes, set.getValue());
        }
    }

    /**
     * @param qm
     */
    private void createModel(Element qm) {
        model = QualityModel.builder().name(qm.getAttribute("name")).identifier(qm.getAttribute("xmi:id"))
                .description(qm.getAttribute("description"))
                .title(qm.hasAttribute("title") ? qm.getAttribute("title") : "")
                .create();
    }

    /**
     * @param e
     */
    private void createTool(Element e) {
        model.addTool(
                Tool.builder()
                        .name(e.getAttribute("name"))
                        .identifier(e.getAttribute("xmi:id"))
                        .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                        .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                        .create());
    }

    /**
     * @param e
     */
    private void createTag(Element e) {
        model.addTag(
                Tag.builder()
                        .name(e.getAttribute("name"))
                        .identifier(e.getAttribute("xmi:id"))
                        .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                        .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                        .create());
    }

    /**
     * @param e
     */
    private void createSource(Element e) {
        model.addSource(
                Source.builder()
                        .name(e.getAttribute("name"))
                        .identifier(e.getAttribute("xmi:id"))
                        .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                        .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                        .create());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void secondPass(String file) throws ParserConfigurationException, SAXException, IOException {
        Document doc = getDocument(file);
        handleRoot(doc, (qm) -> updateQualityModel((Element) qm));

        Map<String, NodeHandler> map = Maps.newHashMap();
        map.put("factors", (n) -> updateFactor((Element) n));
        map.put("entities", (n) -> updateEntity((Element) n));
        map.put("measures", (n) -> updateMeasure((Element) n));
        map.put("tools", (n) -> updateTool((Element) n));
        map.put("tags", (n) -> updateTag((Element) n));
        map.put("sources", (n) -> updateSource((Element) n));
        map.put("measurementMethods", (n) -> createMeasurementMethod((Element) n));
        map.put("evaluations", (n) -> createEvaluation((Element) n));

        for (Entry<String, NodeHandler> set : map.entrySet()) {
            NodeList nodes = doc.getElementsByTagName(set.getKey());
            handleNode(nodes, set.getValue());
        }
    }

    /**
     * @param qm
     */
    private void updateQualityModel(Element qm) {
        NodeList nodes = qm.getElementsByTagName("originatesFrom");
        handleNode(nodes, (n) -> model.setOriginatesFrom(ModelManager.findSource(((Element) n).getAttribute("href"))));

        nodes = qm.getElementsByTagName("taggedBy");
        handleNode(nodes, (n) -> model.addTaggedBy(ModelManager.findTag(((Element) n).getAttribute("href"))));

        nodes = qm.getElementsByTagName("requires");
        handleNode(nodes, (n) -> model.addRequires(ModelManager.findModel(((Element) n).getAttribute("href"))));
    }

    /**
     * @param e
     */
    private void updateFactor(Element e) {
        Factor fact = ModelManager.findFactor(e.getAttribute("xmi:id"));
        Map<String, NodeHandler> map = Maps.newHashMap();

        handleOriginatesFrom(fact, e, map);

        if (e.hasAttribute("refines")) {
            fact.setRefines(ModelManager.findFactor(e.getAttribute("refines")));
        } else {
            map.put("refines", (n) -> {
                Element ele = (Element) n;
                if (ele.hasAttribute("parent"))
                    fact.setRefines(ModelManager.findFactor(ele.getAttribute("refines")));
                else
                    fact.setRefines(ModelManager.findFactor(getSingleHref(ele, "refines")));
            });
        }
        map.put("influences", (n) -> {
            Element ele = (Element) n;
            Impact impact = createImpact(ele);
            fact.addInfluence(impact);
        });

        if (e.hasAttribute("characterizes"))
            fact.setCharacterizes(ModelManager.findEntity(e.getAttribute("characterizes")));
        else {
            fact.setCharacterizes(ModelManager.findEntity(getSingleHref(e, "characterizes")));
        }
        e.getElementsByTagName("annotations");

        for (Entry<String, NodeHandler> set : map.entrySet()) {
            NodeList nodes = e.getElementsByTagName(set.getKey());
            handleNode(nodes, set.getValue());
        }
    }

    /**
     * @param ele
     * @return
     */
    private Impact createImpact(Element ele) {
        return Impact.builder().identifier(ele.getAttribute("xmi:id"))
                .effect(InfluenceEffect.valueOf(ele.getAttribute("effect")))
                .justification(ele.hasAttribute("justification") ? ele.getAttribute("justification") : "")
                .target(ModelManager.findFactor(ele.getAttribute("target")))
                .create();
    }

    /**
     * @param e
     */
    private void updateEntity(Element e) {
        Entity ent = ModelManager.findEntity(e.getAttribute("xmi:id"));

        Map<String, NodeHandler> map = Maps.newHashMap();
        map.put("isA", (n) -> {
            Element ele = (Element) n;
            if (ele.hasAttribute("parent"))
                ent.addIsA(ModelManager.findEntity(ele.getAttribute("parent")));
            else
                ent.addIsA(ModelManager.findEntity(getSingleHref(ele, "parent")));
        });

        handleOriginatesFrom(ent, e, map);

        for (Entry<String, NodeHandler> set : map.entrySet()) {
            NodeList nodes = e.getElementsByTagName(set.getKey());
            handleNode(nodes, set.getValue());
        }

        NodeList nodes = e.getElementsByTagName("partOf");
        if (nodes.getLength() > 0) {
            Node po = nodes.item(0);

            if (po.getNodeType() == Node.ELEMENT_NODE) {
                Element ele = (Element) po;
                if (ele.hasAttribute("parent"))
                    ent.setPartOf(ModelManager.findEntity(ele.getAttribute("parent")));
                else
                    ent.setPartOf(ModelManager.findEntity(getSingleHref(ele, "parent")));
            }
        }
    }

    private void handleOriginatesFrom(QMElement element, Element e, Map<String, NodeHandler> map) {
        if (!e.hasAttribute("originatesFrom"))
            map.put(
                    "originatesFrom",
                    (n) -> element.setOriginatesFrom(ModelManager.findSource(((Element) n).getAttribute("href"))));
        else
            element.setOriginatesFrom(ModelManager.findSource(e.getAttribute("originatesFrom")));
    }

    private void handleAnnotation(QMElement element, Map<String, NodeHandler> map) {
        map.put("annotations", (n) -> {
            Element ele = (Element) n;
            element.addAnnotation(
                    Annotation.builder()
                            .identifier(ele.getAttribute("xmi:id"))
                            .key(ele.getAttribute("key"))
                            .value(ele.hasAttribute("value") ? ele.getAttribute("value") : "")
                            .create());
        });
    }

    /**
     * @param e
     */
    private void updateMeasure(Element e) {
        Measure meas = ModelManager.findMeasure(e.getAttribute("xmi:id"));
        Map<String, NodeHandler> map = Maps.newHashMap();

        handleOriginatesFrom(meas, e, map);
        handleAnnotation(meas, map);

        map.put("measures", (n) -> meas.addMeasures(ModelManager.findFactor(((Element) n).getAttribute("xmi:id"))));
        e.getElementsByTagName("measures"); // can be multiple -> Factors has
        // parent attribute or tag
        if (e.hasAttribute("refines")) {
            meas.setRefines(ModelManager.findMeasure(e.getAttribute("refines")));
        } else {
            map.put("refines", (n) -> {
                Element ele = (Element) n;
                if (ele.hasAttribute("parent"))
                    meas.setRefines(ModelManager.findMeasure(ele.getAttribute("refines")));
                else
                    meas.setRefines(ModelManager.findMeasure(getSingleHref(ele, "refines")));
            });
        }
        if (e.hasAttribute("characterizes"))
            meas.setCharacterizes(ModelManager.findEntity(e.getAttribute("characterizes")));
        else {
            meas.setCharacterizes(ModelManager.findEntity(getSingleHref(e, "characterizes")));
        }

        for (Entry<String, NodeHandler> set : map.entrySet()) {
            NodeList nodes = e.getElementsByTagName(set.getKey());
            handleNode(nodes, set.getValue());
        }
    }

    /**
     * @param e
     */
    private void updateTool(Element e) {
        Tool tool = ModelManager.findTool(e.getAttribute("xmi:id"));
        Map<String, NodeHandler> map = Maps.newHashMap();

        handleOriginatesFrom(tool, e, map);
        handleAnnotation(tool, map);

        for (Entry<String, NodeHandler> set : map.entrySet()) {
            NodeList nodes = e.getElementsByTagName(set.getKey());
            handleNode(nodes, set.getValue());
        }
    }

    /**
     * @param e
     */
    private void updateTag(Element e) {
        Tag tag = ModelManager.findTag(e.getAttribute("xmi:id"));
    }

    /**
     * @param e
     */
    private void updateSource(Element e) {
        Source src = ModelManager.findSource(e.getAttribute("xmi:id"));
        this.handleNode(e.getElementsByTagName("annotations"), (n) -> {
            Element ele = (Element) n;
            Annotation ann = Annotation.builder()
                    .identifier(ele.getAttribute("xmi:id"))
                    .key(ele.getAttribute("key"))
                    .value(ele.hasAttribute("value") ? ele.getAttribute("value") : "")
                    .create();
            src.addAnnotation(ann);
        });
    }

    /**
     * @param e
     */
    private void createMeasurementMethod(Element e) {
        model.addMeasurementMethod(MeasurementMethodFactory.instance().create(e));
    }

    /**
     * @param e
     */
    private void createEvaluation(Element e) {
        Evaluation eval = EvaluationFactory.instance().create(e);

        NodeList nList = e.getElementsByTagName("rankings");
        for (int i = 0; i < nList.getLength(); i++) {
            Node n = nList.item(i);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element r = (Element) n;
                createRanking(r);
            }
        }

        model.addEvaluation(eval);
    }

    /**
     * @param r
     */
    private Ranking createRanking(Element r) {
        Ranking rank = null;

        if (r.getElementsByTagName("measure").getLength() > 0) {
            rank = (Ranking) MeasureRanking.builder().identifier(r.getAttribute("xmi:id"))
                    .rank(r.hasAttribute("rank") ? Integer.parseInt(r.getAttribute("rank")) : 0)
                    .weight(r.hasAttribute("weight") ? Double.parseDouble(r.getAttribute("weight")) : 0.0)
                    .basedOn(
                            ModelManager.findMeasure(
                                    r.hasAttribute("measure") ? r.getAttribute("measure")
                                            : getSingleHref(r, "measure")))
                    .function(null)
                    .normalization(
                            ModelManager.findNormMeasure(
                                    getSingleHref(r, "normlizationMeasure").isEmpty() ? null
                                            : getSingleHref(r, "normlizationMeasure")))
                    .range(r.hasAttribute("range") ? NormalizationRange.valueOf(r.getAttribute("range")) : null)
                    .create();
        } else {
            rank = FactorRanking.builder()
                    .factor(
                            ModelManager.findFactor(
                                    r.hasAttribute("factor") ? r.getAttribute("factor") : getSingleHref(r, "factor")))
                    .rank(r.hasAttribute("rank") ? Integer.parseInt(r.getAttribute("rank")) : 0)
                    .weight(r.hasAttribute("weight") ? Double.parseDouble(r.getAttribute("weight")) : 0.0)
                    .create();
        }

        return rank;
    }

    /**
     * @param r
     * @param tag
     * @return
     */
    private String getSingleHref(Element r, String tag) {
        String value = "";

        if (r.getElementsByTagName(tag).getLength() > 0) {
            NodeList nodes = r.getElementsByTagName(tag);
            Node n = nodes.item(0);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                value = ((Element) n).getAttribute("href");
            }
        }

        return value;
    }

    private Function createFunction(Element e) {
        Function func = null;

        switch (e.getAttribute("xsi:type")) {
            case "qm:LinearDecreasingFunction":
                func = (Function) LinearDecreasingFunction.builder().identifier(e.getAttribute("xmi:id"))
                        .lowerBound(e.hasAttribute("lowerBound") ? Double.parseDouble(e.getAttribute("lowerBound")) : 0.0)
                        .upperBound(e.hasAttribute("upperBound") ? Double.parseDouble(e.getAttribute("upperBound")) : 0.0)
                        .create();
                break;
            case "qm:LinearIncreasingFunction":
            default:
                func = (Function) LinearIncreasingFunction.builder().identifier(e.getAttribute("xmi:id"))
                        .lowerBound(e.hasAttribute("lowerBound") ? Double.parseDouble(e.getAttribute("lowerBound")) : 0.0)
                        .upperBound(e.hasAttribute("upperBound") ? Double.parseDouble(e.getAttribute("upperBound")) : 0.0)
                        .create();
        }

        return func;
    }

    /**
     * Retrieves an input stream for the file with the given name. If the file
     * cannot be read, then an attempt to read the file from the JAR is made.
     *
     * @param qm File name to construct a stream for.
     * @return An input stream for reading the file with the given name.
     */
    @VisibleForTesting
    private InputStream getInputStream(final String qm) {
        final Path file = Paths.get(qm);
        if (Files.exists(file)) {
            try {
                return Files.newInputStream(file, StandardOpenOption.READ);
            } catch (final IOException e) {
                QMXMLReader.LOG.warn(e.getMessage(), e);
                return QMXMLReader.class.getResourceAsStream("/com/sparqline/quamoco/models/" + qm + ".qm");
            }
        } else {
            return QMXMLReader.class.getResourceAsStream("/com/sparqline/quamoco/models/" + qm + ".qm");
        }
    }

    private void handleNode(NodeList nodes, NodeHandler nh) {
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);

            if (n.getNodeType() == Node.ELEMENT_NODE) {
                nh.handle(n);
            }
        }
    }

    private void handleRoot(Document doc, NodeHandler nh) {
        Element qm = doc.getDocumentElement();
        nh.handle(qm);
    }

    private Document getDocument(String file) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = dbFactory.newDocumentBuilder();
        Document doc = builder.parse(getInputStream(file));
        doc.getDocumentElement().normalize();
        return doc;
    }

    public void read(String arg) {
        try {
            firstPass(arg);
            secondPass(arg);
        } catch (Exception e) {

        }
    }
}
