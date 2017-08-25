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
package edu.montana.gsoc.msusel.quamoco.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.annotations.VisibleForTesting;

import edu.montana.gsoc.msusel.quamoco.model.qm.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Characterizes;
import edu.montana.gsoc.msusel.quamoco.model.qm.Determines;
import edu.montana.gsoc.msusel.quamoco.model.qm.Entity;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluates;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Factor;
import edu.montana.gsoc.msusel.quamoco.model.qm.FactorLink;
import edu.montana.gsoc.msusel.quamoco.model.qm.Function;
import edu.montana.gsoc.msusel.quamoco.model.qm.Influence;
import edu.montana.gsoc.msusel.quamoco.model.qm.IsA;
import edu.montana.gsoc.msusel.quamoco.model.qm.Measure;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasureLink;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationMeasure;
import edu.montana.gsoc.msusel.quamoco.model.qm.OriginatesFrom;
import edu.montana.gsoc.msusel.quamoco.model.qm.Parent;
import edu.montana.gsoc.msusel.quamoco.model.qm.PartOf;
import edu.montana.gsoc.msusel.quamoco.model.qm.QMEntityFactory;
import edu.montana.gsoc.msusel.quamoco.model.qm.QualityModel;
import edu.montana.gsoc.msusel.quamoco.model.qm.Ranking;
import edu.montana.gsoc.msusel.quamoco.model.qm.Refines;
import edu.montana.gsoc.msusel.quamoco.model.qm.Requires;
import edu.montana.gsoc.msusel.quamoco.model.qm.Source;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tag;
import edu.montana.gsoc.msusel.quamoco.model.qm.TaggedBy;
import edu.montana.gsoc.msusel.quamoco.model.qm.Target;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tool;

/**
 * Class to construct a Quality Model using the XML produced by the Quamoco
 * Quality Model Editor
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class QMReader extends AbstractQuamocoReader {

    /**
     * Logger
     */
    private static final Logger LOG    = LoggerFactory.getLogger(QMReader.class);
    /**
     * Constant for hash symbol
     */
    private static final String HASH   = "#";
    /**
     * Constant for parent attribute
     */
    private static final String PARENT = "parent";
    /**
     * Constant for file name separator
     */
    private static final String DOT_QM = ".qm#";
    /**
     * Constant for href attribute
     */
    private static final String HREF   = "href";
    /**
     * Quality model under construction
     */
    private QualityModel        model;

    /**
     * Constructs a new Quality model
     */
    public QMReader()
    {
        model = new QualityModel("model", "", null, null, "model_id");
    }

    /**
     * @return The deserialized quality model
     */
    public QualityModel getModel()
    {
        return model;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void read(final String qm) throws FileNotFoundException, XMLStreamException
    {
        if (qm == null || qm.isEmpty())
        {
            return;
        }

        model = null;
        Factor factor = null;
        Evaluation eval = null;
        Measure measure = null;
        Influence inf = null;
        MeasurementMethod method = null;
        Tool tool = null;
        Ranking rank = null;
        Annotation annot = null;
        Function func = null;
        Entity entity = null;
        Source source = null;
        boolean isRefines = false;
        boolean innerMeasure = false;

        final XMLInputFactory factory = XMLInputFactory.newInstance();
        final InputStream stream = getInputStream(qm);
        final XMLStreamReader reader = factory.createXMLStreamReader(stream);
        while (reader.hasNext())
        {
            final int event = reader.next();

            switch (event)
            {
            case XMLStreamConstants.START_ELEMENT:
                final Map<String, String> attrs = getAttributes(reader);
                switch (reader.getLocalName())
                {
                case "QualityModel":
                    model = QMEntityFactory.createQualityModel(attrs);
                    break;
                case "taggedBy":
                    model.setTaggedBy(new TaggedBy(attrs.get(QMReader.HREF)));
                    break;
                case "entities":
                    entity = QMEntityFactory.createEntity(model.getName(), attrs);
                    break;
                case "factors":
                    factor = QMEntityFactory.createFactor(model.getName(), attrs, getCharacterizes(attrs));
                    break;
                case "evaluations":
                    eval = QMEntityFactory.createEvaluation(model.getName(), attrs);
                    break;
                case "measures":
                    if (measure != null)
                    {
                        innerMeasure = true;
                        updateMeasureParent(measure, attrs);
                    }
                    else
                    {
                        innerMeasure = false;
                        final String parent = getParent(attrs);
                        final String characterizes = getCharacterizes(attrs);

                        measure = QMEntityFactory.createMeasure(model.getName(), attrs, characterizes);
                        model.addMeasure(measure);
                        if (parent != null && !parent.isEmpty())
                        {
                            measure.addParent(new Parent(parent));
                        }
                    }
                    break;
                case "measurementMethods":
                    method = QMEntityFactory.createMeasurementMethod(model.getName(), attrs);
                    model.addMethod(method);
                    break;
                case "tools":
                    tool = QMEntityFactory.createTool(model.getName(), attrs);
                    model.addTool(tool);
                    break;
                case "tags":
                    final Tag tag = QMEntityFactory.createTag(model.getName(), attrs);
                    model.addTag(tag);
                    break;
                case "sources":
                    source = QMEntityFactory.createSource(model.getName(), attrs);
                    model.addSource(source);
                    break;
                case "requires":
                    model.addRequires(new Requires(attrs.get(QMReader.HREF)));
                    break;
                case "characterizes":
                    setCharacterizes(factor, measure, attrs);
                    break;
                case "influences":
                    inf = QMEntityFactory.createInfluences(model.getName(), attrs);
                    break;
                case "refines":
                    setRefines(factor, measure, attrs);
                    isRefines = true;
                    break;
                case "evaluates":
                    setEvaluates(eval, attrs);
                    break;
                case "rankings":
                    rank = QMEntityFactory.createRanking(model.getName(), eval, attrs);
                    break;
                case "originatesFrom":
                    setOriginatesFrom(measure, method, tool, entity, attrs);
                    break;
                case PARENT:
                    setParent(factor, measure, entity, isRefines, attrs);
                    break;
                case "annotations":
                    annot = QMEntityFactory.createAnnotation(model.getName(), attrs);
                    setAnnotation(factor, measure, method, tool, annot, source);
                    break;
                case "determines":
                    method.setDetermines(new Determines(attrs.get(QMReader.HREF)));
                    break;
                case "tool":
                    method.setTool(attrs.get(QMReader.HREF));
                    break;
                case "factor":
                    if (rank != null)
                        rank.setFactor(new FactorLink(attrs.get(QMReader.HREF)));
                    break;
                case "measure":
                    if (rank != null)
                        rank.setMeasure(new MeasureLink(attrs.get(QMReader.HREF)));
                    break;
                case "normlizationMeasure":
                    if (rank != null)
                        rank.setNormalizationMeasure(new NormalizationMeasure(attrs.get(QMReader.HREF)));
                    break;
                case "function":
                    if (rank != null)
                    {
                        func = QMEntityFactory.createFunction(model.getName(), attrs);
                        rank.setFunction(func);
                    }
                    break;
                case "target":
                    inf.setTarget(new Target(attrs.get(QMReader.HREF)));
                    break;
                case "isA":
                    entity.addIsA(new IsA(model.getName() + QMReader.DOT_QM + attrs.get(QMReader.PARENT)));
                    break;
                case "partOf":
                    entity.setPartOf(
                            new PartOf(
                                    attrs.get("{http://www.omg.org/XMI}id"),
                                    new Parent(model.getName() + QMReader.DOT_QM + attrs.get(QMReader.PARENT))));
                    break;
                }
                break;
            case XMLStreamConstants.END_ELEMENT:
                switch (reader.getLocalName())
                {
                case "entities":
                    model.addEntity(entity);
                    entity = null;
                    break;
                case "factors":
                    model.addFactor(factor);
                    factor = null;
                    break;
                case "evaluations":
                    model.addEvaluation(eval);
                    isRefines = false;
                    eval = null;
                    break;
                case "measures":
                    if (!innerMeasure)
                    {
                        measure = null;
                    }
                    innerMeasure = !innerMeasure;
                    isRefines = false;
                    break;
                case "measurementMethods":
                    method = null;
                    break;
                case "tools":
                    tool = null;
                    break;
                case "sources":
                    model.addSource(source);
                    source = null;
                    break;
                case "influences":
                    factor.addInfluence(inf);
                    inf = null;
                    break;
                case "refines":
                    isRefines = false;
                    break;
                case "rankings":
                    if (eval != null && rank != null)
                    {
                        eval.addRanking(rank);
                    }
                    rank = null;
                    break;
                case "annotations":
                    annot = null;
                    break;
                case "function":
                    func = null;
                    break;
                }
                break;
            }
        }
    }

    /**
     * Retrieves an input stream for the file with the given name. If the file
     * cannot be read, then an attempt to read the file from the JAR is made.
     * 
     * @param qm
     *            File name to construct a stream for.
     * @return An input stream for reading the file with the given name.
     */
    @VisibleForTesting
    InputStream getInputStream(final String qm)
    {
        final Path file = Paths.get(qm);
        if (Files.exists(file))
        {
            try
            {
                return Files.newInputStream(file, StandardOpenOption.READ);
            }
            catch (final IOException e)
            {
                QMReader.LOG.warn(e.getMessage(), e);
                return QMReader.class.getResourceAsStream("/edu/montana/gsoc/msusel/quamoco/models/" + qm + ".qm");
            }
        }
        else
        {
            return QMReader.class.getResourceAsStream("/edu/montana/gsoc/msusel/quamoco/models/" + qm + ".qm");
        }
    }

    /**
     * Updates the given Measure's parent using the provided map of attributes.
     * 
     * @param measure
     *            Measure to update
     * @param attrs
     *            Attributes
     */
    @VisibleForTesting
    void updateMeasureParent(final Measure measure, final Map<String, String> attrs)
    {
        String parent = getMeasureParent(attrs.get(QMReader.PARENT));
        if (parent == null)
        {
            parent = getMeasureParent(attrs.get(QMReader.HREF));
        }
        if (parent != null && !parent.isEmpty())
        {
            measure.addParent(new Parent(parent));
        }
    }

    /**
     * Constructs a qualified identifier for the given parent identifier.
     * 
     * @param parent
     *            Parent identifier
     * @return qualified identifier
     */
    @VisibleForTesting
    String getMeasureParent(final String parent)
    {
        String returnValue = null;
        if (parent != null)
        {
            if (!parent.contains(QMReader.HASH))
            {
                returnValue = model.getName() + QMReader.DOT_QM + parent;
            }
        }
        return returnValue;
    }

    /**
     * Retrieves the fully qualified identifier for the characterizes field.
     * 
     * @param attrs
     *            Attribute map containing the initial characterizes identifier
     * @return fully qualified characterizes identifier
     */
    @VisibleForTesting
    String getCharacterizes(final Map<String, String> attrs)
    {
        String characterizes = null;
        if (attrs.get("characterizes") != null)
        {
            characterizes = model.getName() + QMReader.DOT_QM + attrs.get("characterizes");
        }
        return characterizes;
    }

    /**
     * Retrieves the fully qualified parent identifier
     * 
     * @param attrs
     *            Attribute Map containing the initial parent identifer
     * @return fully qualified parent identifier
     */
    @VisibleForTesting
    String getParent(final Map<String, String> attrs)
    {
        String parent = null;
        if (attrs.get(QMReader.PARENT) != null)
        {
            parent = model.getName() + QMReader.DOT_QM + attrs.get(QMReader.PARENT);
        }
        return parent;
    }

    /**
     * Adds the given annotation to the appropriate entity
     * 
     * @param factor
     *            Factor to add to
     * @param measure
     *            Measure to add to
     * @param method
     *            MeasurementMethod to add to
     * @param tool
     *            Tool to add to
     * @param annot
     *            Annotation to add to
     * @param source
     *            Source to add to
     */
    @VisibleForTesting
    void setAnnotation(final Factor factor, final Measure measure, final MeasurementMethod method, final Tool tool,
            final Annotation annot, final Source source)
    {
        if (factor != null)
        {
            factor.addAnnotation(annot);
        }
        else if (measure != null)
        {
            measure.addAnnotation(annot);
        }
        else if (method != null)
        {
            method.addAnnotation(annot);
        }
        else if (source != null)
        {
            source.addAnnotation(annot);
        }
        else if (tool != null)
        {
            tool.addAnnotation(annot);
        }
    }

    /**
     * Sets the characterizes value for either a factor or measure.
     * 
     * @param factor
     *            Factor to set characterizes for
     * @param measure
     *            Measure to set characterizes for
     * @param attrs
     *            Attribute map
     */
    @VisibleForTesting
    void setCharacterizes(final Factor factor, final Measure measure, final Map<String, String> attrs)
    {
        if (factor != null)
        {
            if (factor.getCharacterizes() == null)
            {
                factor.setCharacterizes(new Characterizes(attrs.get(QMReader.HREF)));
            }
        }
        else if (measure != null)
        {
            if (measure.getCharacterizes() == null)
            {
                measure.setCharacterizes(new Characterizes(attrs.get(QMReader.HREF)));
            }
        }
    }

    /**
     * Sets the Evaluation evaluates qualified identifier
     * 
     * @param eval
     *            Evaluation to set
     * @param attrs
     *            Attribute map
     */
    @VisibleForTesting
    void setEvaluates(final Evaluation eval, final Map<String, String> attrs)
    {
        String href = attrs.get(QMReader.HREF);
        if (href != null && !href.contains(QMReader.HASH))
        {
            href = model.getName() + QMReader.DOT_QM + href;
        }
        eval.setEvaluates(new Evaluates(href));
    }

    /**
     * Sets the OriginatesFrom field for the given QMEntity.
     * 
     * @param measure
     *            Measure to set
     * @param method
     *            MeasurementMethod to set
     * @param tool
     *            Tool to set
     * @param entity
     *            Entity to set
     * @param attrs
     *            Attribute map
     */
    @VisibleForTesting
    void setOriginatesFrom(final Measure measure, final MeasurementMethod method, final Tool tool, final Entity entity,
            final Map<String, String> attrs)
    {
        if (tool != null)
        {
            tool.setOriginatesFrom(new OriginatesFrom(attrs.get(QMReader.HREF)));
        }
        else if (method != null)
        {
            method.setOriginatesFrom(new OriginatesFrom(attrs.get(QMReader.HREF)));
        }
        else if (measure != null)
        {
            measure.setOriginatesFrom(new OriginatesFrom(attrs.get(QMReader.HREF)));
        }
        else if (entity != null)
        {
            entity.setOriginatesFrom(new OriginatesFrom(attrs.get(QMReader.HREF)));
        }
    }

    /**
     * Sets the parent identifier for an entity
     * 
     * @param factor
     *            Factor to set
     * @param measure
     *            Measure to set
     * @param entity
     *            Entity to set
     * @param isRefines
     *            boolean true if the entity refines the parent
     * @param attrs
     *            Attribute map
     */
    @VisibleForTesting
    void setParent(final Factor factor, final Measure measure, final Entity entity, final boolean isRefines,
            final Map<String, String> attrs)
    {
        if (factor != null)
        {
            factor.setRefines(new Refines(attrs.get(QMReader.HREF)));
        }
        else if (measure != null)
        {
            if (isRefines)
            {
                measure.setRefines(new Refines(attrs.get(QMReader.HREF)));
            }
            else
            {
                measure.addParent(new Parent(attrs.get(QMReader.HREF)));
            }
        }
        else if (entity != null)
        {
            entity.addIsA(new IsA(attrs.get(QMReader.HREF)));
        }
    }

    /**
     * Sets the refines field for the given entities
     * 
     * @param factor
     *            Factor to set
     * @param measure
     *            Measure to set
     * @param attrs
     *            attribute map
     */
    @VisibleForTesting
    void setRefines(final Factor factor, final Measure measure, final Map<String, String> attrs)
    {
        if (factor != null)
        {
            factor.setRefines(new Refines(model.getName() + QMReader.DOT_QM + attrs.get(QMReader.PARENT)));
        }
        else if (measure != null)
        {
            measure.setRefines(new Refines(model.getName() + QMReader.DOT_QM + attrs.get(QMReader.PARENT)));
        }
    }
}
