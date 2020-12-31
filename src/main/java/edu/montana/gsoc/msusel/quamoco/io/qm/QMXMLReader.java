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
package edu.montana.gsoc.msusel.quamoco.io.qm;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import edu.montana.gsoc.msusel.quamoco.io.AbstractQuamocoReader;
import edu.montana.gsoc.msusel.quamoco.io.NodeHandler;
import edu.montana.gsoc.msusel.quamoco.io.factories.*;
import edu.montana.gsoc.msusel.quamoco.model.*;
import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.MeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MeasureRanking;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.WeightedSumMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.func.Function;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.FactorRanking;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.measurement.ToolBasedInstrument;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
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
import java.util.Map;
import java.util.Map.Entry;

/**
 * Class to construct a Quality Model using the XML produced by the Quamoco
 * Quality Model Editor
 *
 * @author Isaac Griffith
 * @version 1.3.0
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
     * Constructs a new instance
     *
     * @param manager
     */
    public QMXMLReader(ModelManager manager) {
        super(manager);
        model = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void firstPass(String file) throws ParserConfigurationException, SAXException, IOException {
        Document doc = getDocument(file);
        handleRoot(doc, (qm) -> createModel(file, (Element) qm));

        Map<String, NodeHandler> map = Maps.newHashMap();
        map.put("factors", (n) -> model.addFactor(FactorFactory.instance().create((Element) n, manager)));
        map.put("entities", (n) -> model.addEntity(EntityFactory.instance().create((Element) n, manager)));
        map.put("measures", (n) -> model.addMeasure(MeasureFactory.instance().create((Element) n, manager)));
        map.put("tools", (n) -> createTool((Element) n));
        map.put("tags", (n) -> createTag((Element) n));
        map.put("sources", (n) -> createSource((Element) n));

        processNodes(doc, map);
    }

    private void processNodes(Document doc, Map<String, NodeHandler> map) {
        for (Entry<String, NodeHandler> set : map.entrySet()) {
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = "QualityModel/" + set.getKey();
            try {
                NodeList nodes = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
                handleNode(nodes, set.getValue());
            } catch (XPathExpressionException ex) {

            }
        }
    }

    /**
     * @param qm
     */
    private void createModel(String file, Element qm) {
        model = QualityModel.builder()
                .name(qm.getAttribute("name"))
                .fileName(Paths.get(file).getFileName().toString())
                .identifier(qm.getAttribute("xmi:id"))
                .description(qm.getAttribute("description"))
                .title(qm.hasAttribute("title") ? qm.getAttribute("title") : "")
                .gradeBoundary2(qm.hasAttribute("schoolGradeBoundary2") ? Double.parseDouble(qm.getAttribute("schoolGradeBoundary2")) : 0.98)
                .gradeBoundary3(qm.hasAttribute("schoolGradeBoundary2") ? Double.parseDouble(qm.getAttribute("schoolGradeBoundary2")) : 0.96)
                .gradeBoundary4(qm.hasAttribute("schoolGradeBoundary2") ? Double.parseDouble(qm.getAttribute("schoolGradeBoundary2")) : 0.94)
                .gradeBoundary5(qm.hasAttribute("schoolGradeBoundary2") ? Double.parseDouble(qm.getAttribute("schoolGradeBoundary2")) : 0.92)
                .gradeBoundary6(qm.hasAttribute("schoolGradeBoundary2") ? Double.parseDouble(qm.getAttribute("schoolGradeBoundary2")) : 0.90)
                .create();
        manager.addModel(model);
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
        map.put("requires", (n) -> model.addRequires(manager.getModel(((Element) n).getAttribute("href").split("#")[1])));
        map.put("originatesFrom", (n) -> model.setOriginatesFrom(manager.findSource(((Element) n).getAttribute("href"))));
        map.put("taggedBy", (n) -> model.addTaggedBy(manager.findTag(((Element) n).getAttribute("href"))));

        processNodes(doc, map);
    }

    public void thirdPass(String file) throws ParserConfigurationException, SAXException, IOException {
        Document doc = getDocument(file);
        handleRoot(doc, (qm) -> updateQualityModel((Element) qm));

        Map<String, NodeHandler> map = Maps.newHashMap();

        map.put("measurementMethods", (n) -> createMeasurementMethod((Element) n));
        map.put("evaluations", (n) -> createEvaluation((Element) n));

        processNodes(doc, map);
    }

    /**
     * @param qm
     */
    private void updateQualityModel(Element qm) {
        model = manager.getModelByName(qm.getAttribute("name"));
    }

    /**
     * @param e
     */
    private void updateFactor(Element e) {
        Factor fact = manager.findFactor(e.getAttribute("xmi:id"));
        Map<String, NodeHandler> map = Maps.newHashMap();

        handleOriginatesFrom(fact, e, map);
        handleTaggedBy(fact, e, map);

        if (e.hasAttribute("refines")) {
            fact.setRefines(manager.findFactor(e.getAttribute("refines")));
        } else {
            map.put("refines", (n) -> {
                Element ele = (Element) n;
                if (ele.hasAttribute("parent"))
                    fact.setRefines(manager.findFactor(ele.getAttribute("parent")));
                else
                    fact.setRefines(manager.findFactor(getSingleHref(ele, "refines")));
            });
        }
        map.put("influences", (n) -> fact.addInfluence(createImpact((Element) n)));

        if (e.hasAttribute("characterizes"))
            fact.setCharacterizes(manager.findEntity(e.getAttribute("characterizes")));
        else {
            fact.setCharacterizes(manager.findEntity(getSingleHref(e, "characterizes")));
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
        Impact impact = Impact.builder().identifier(ele.getAttribute("xmi:id"))
                .effect(ele.hasAttribute("effect") ? InfluenceEffect.valueOf(ele.getAttribute("effect")) : InfluenceEffect.POSITIVE)
                .justification(ele.hasAttribute("justification") ? ele.getAttribute("justification") : "")
                .create();
        if (ele.hasAttribute("target")) {
            impact.setTarget(manager.findFactor(ele.getAttribute("target")));
        } else {
            NodeList list = ele.getElementsByTagName("target");
            for (int i = 0; i < list.getLength(); i++) {
                Node n = list.item(i);
                if (n.getNodeType() == Node.ELEMENT_NODE) {
                    impact.setTarget(manager.findFactor(((Element) n).getAttribute("href")));
                }
            }
        }

        return impact;
    }

    /**
     * @param e
     */
    private void updateEntity(Element e) {
        Entity ent = manager.findEntity(e.getAttribute("xmi:id"));

        Map<String, NodeHandler> map = Maps.newHashMap();
        map.put("isA", (n) -> {
            Element ele = (Element) n;
            if (ele.hasAttribute("parent"))
                ent.addIsA(manager.findEntity(ele.getAttribute("parent")));
            else
                ent.addIsA(manager.findEntity(getSingleHref(ele, "parent")));
        });

        handleOriginatesFrom(ent, e, map);
        handleTaggedBy(ent, e, map);

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
                    ent.setPartOf(manager.findEntity(ele.getAttribute("parent")));
                else
                    ent.setPartOf(manager.findEntity(getSingleHref(ele, "parent")));
            }
        }
    }

    private void handleOriginatesFrom(QMElement element, Element e, Map<String, NodeHandler> map) {
        if (!e.hasAttribute("originatesFrom"))
            map.put(
                    "originatesFrom",
                    (n) -> element.setOriginatesFrom(manager.findSource(((Element) n).getAttribute("href"))));
        else {
            element.setOriginatesFrom(manager.findSource(e.getAttribute("originatesFrom")));
        }
    }

    private void handleTaggedBy(QMElement element, Element e, Map<String, NodeHandler> map) {
        if (!e.hasAttribute("taggedBy"))
            map.put(
                    "taggedBy",
                    (n) -> element.addTaggedBy(manager.findTag(((Element) n).getAttribute("href"))));
        else {
            element.addTaggedBy(manager.findTag(e.getAttribute("taggedBy")));
        }
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
        Measure meas = manager.findMeasure(e.getAttribute("xmi:id"));
        Map<String, NodeHandler> map = Maps.newHashMap();

        handleOriginatesFrom(meas, e, map);
        handleTaggedBy(meas, e, map);
        handleAnnotation(meas, map);

        if (e.hasAttribute("measures")) {
            meas.addMeasures(manager.findFactor(e.getAttribute("measures")));
        }
        map.put("measures", (n) -> meas.addMeasures(manager.findFactor(((Element) n).getAttribute("parent")))); // can be multiple -> Factors has
        map.put("refines", (n) -> meas.setRefines(manager.findMeasure(((Element) n).getAttribute("parent"))));

        // parent attribute or tag
        if (e.hasAttribute("parent"))
            meas.setRefines(manager.findMeasure(e.getAttribute("parent")));
        else if (e.hasAttribute("refines"))
            meas.setRefines(manager.findMeasure(e.getAttribute("refines")));

        if (e.hasAttribute("characterizes"))
            meas.setCharacterizes(manager.findEntity(e.getAttribute("characterizes")));
        else {
            meas.setCharacterizes(manager.findEntity(getSingleHref(e, "characterizes")));
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
        Tool tool = manager.findTool(e.getAttribute("xmi:id"));
        Map<String, NodeHandler> map = Maps.newHashMap();

        handleOriginatesFrom(tool, e, map);
        handleTaggedBy(tool, e, map);
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
        Tag tag = manager.findTag(e.getAttribute("xmi:id"));

        Map<String, NodeHandler> map = Maps.newHashMap();
        handleOriginatesFrom(tag, e, map);
    }

    /**
     * @param e
     */
    private void updateSource(Element e) {
        Source src = manager.findSource(e.getAttribute("xmi:id"));
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
        Measure determines = manager.findMeasure(e.hasAttribute("determines") ? e.getAttribute("determines") : getSingleHref(e, "determines"));
        MeasurementMethod method = MeasurementMethodFactory.instance().create(e, manager, determines);
        model.addMeasurementMethod(method);
        method.setModelName(model.getName());

        Map<String, NodeHandler> map = Maps.newHashMap();

        handleOriginatesFrom(method, e, map);
        handleTaggedBy(method, e, map);

        if (method instanceof ToolBasedInstrument) {
            ((ToolBasedInstrument) method).setTool(manager.findTool(e.hasAttribute("tool") ? e.getAttribute("tool") : getSingleHref(e, "tool")));
        }

        for (Entry<String, NodeHandler> set : map.entrySet()) {
            NodeList nodes = e.getElementsByTagName(set.getKey());
            handleNode(nodes, set.getValue());
        }
    }

    /**
     * @param e
     */
    private void createEvaluation(Element e) {
        Evaluation eval = EvaluationFactory.instance().create(e, manager);

        Map<String, NodeHandler> map = Maps.newHashMap();

        eval.setEvaluates(manager.findFactor(e.hasAttribute("evaluates") ? e.getAttribute("evaluates") : getSingleHref(e, "evaluates")));

        handleOriginatesFrom(eval, e, map);
        handleTaggedBy(eval, e, map);

        if (eval instanceof WeightedSumFactorAggregation) {
            map.put("rankings", (r) -> ((WeightedSumFactorAggregation) eval).addRanking((FactorRanking) createRanking((Element) r, eval)));
        } else if (eval instanceof WeightedSumMultiMeasureEvaluation) {
            map.put("rankings", (r) -> ((WeightedSumMultiMeasureEvaluation) eval).addRanking((MeasureRanking) createRanking((Element) r, eval)));
        } else if (eval instanceof MeasureEvaluation) {
            map.put("function", (n) -> ((MeasureEvaluation) eval).setFunction((Function) FunctionFactory.getInstance().create((Element) n, manager)));
        }

        for (Entry<String, NodeHandler> set : map.entrySet()) {
            NodeList nodes = e.getElementsByTagName(set.getKey());
            handleNode(nodes, set.getValue());
        }

        model.addEvaluation(eval);
    }

    /**
     * @param r
     */
    private Ranking createRanking(Element r, Evaluation eval) {
        final Ranking rank;

        if (!r.hasAttribute("weight") || !r.hasAttribute("rank"))
            return null;

        if (r.hasAttribute("measure") || r.getElementsByTagName("measure").getLength() > 0) {
            rank = MeasureRanking.builder()
                    .identifier(r.getAttribute("xmi:id"))
                    .rank(r.hasAttribute("rank") ? Integer.parseInt(r.getAttribute("rank")) : 0)
                    .weight(r.hasAttribute("weight") ? Double.parseDouble(r.getAttribute("weight")) : 0.0)
                    .basedOn(
                            manager.findMeasure(
                                    r.hasAttribute("measure") ? r.getAttribute("measure")
                                            : getSingleHref(r, "measure")))
                    .function(null)
                    .normalization(
                            manager.findNormMeasure(
                                    r.hasAttribute("normlizationMeasure") ? r.getAttribute("normlizationMeasure")
                                            : getSingleHref(r, "normlizationMeasure")))
                    .range(r.hasAttribute("range") ? NormalizationRange.valueOf(r.getAttribute("range")) : null)
                    .create();

            Map<String, NodeHandler> map = Maps.newHashMap();
            map.put("function", (n) -> ((MeasureRanking) rank).setFunction((Function) FunctionFactory.getInstance().create((Element) n, manager)));

            for (Entry<String, NodeHandler> set : map.entrySet()) {
                NodeList nodes = r.getElementsByTagName(set.getKey());
                handleNode(nodes, set.getValue());
            }
        } else if (r.hasAttribute("factor") || r.getElementsByTagName("factor").getLength() > 0) {
            Factor factor = manager.findFactor(r.hasAttribute("factor") ? r.getAttribute("factor") : getSingleHref(r, "factor"));
            rank = FactorRanking.builder()
                    .identifier(r.getAttribute("xmi:id"))
                    .factor(factor)
                    .rank(r.hasAttribute("rank") ? Integer.parseInt(r.getAttribute("rank")) : 0)
                    .weight(r.hasAttribute("weight") ? Double.parseDouble(r.getAttribute("weight")) : 0.0)
                    .influence(factor.getInfluenceOn(eval.getEvaluates()))
                    .create();
        } else {
            rank = null;
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
                return QMXMLReader.class.getResourceAsStream("/edu/montana/gsoc/msusel/quamoco/models/" + qm + ".qm");
            }
        } else {
            return QMXMLReader.class.getResourceAsStream("/edu/montana/gsoc/msusel/quamoco/models/" + qm + ".qm");
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
        if (arg == null || arg.isEmpty())
            throw new IllegalArgumentException("qm model to read cannot be null or empty");
        try {
            firstPass(arg);
            secondPass(arg);
        } catch (Exception e) {
        }
    }
}
