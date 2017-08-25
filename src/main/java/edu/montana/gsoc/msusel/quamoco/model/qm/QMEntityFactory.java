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
package edu.montana.gsoc.msusel.quamoco.model.qm;

import java.math.BigDecimal;
import java.util.Map;

/**
 * QMEntityFactory -
 *
 * @author Isaac Griffith
 */
public class QMEntityFactory {

    /**
     * 
     */
    private static final String TITLE       = "title";
    /**
     * 
     */
    private static final String TYPE        = "{http://www.w3.org/2001/XMLSchema-instance}type";
    /**
     * 
     */
    private static final String NAME        = "name";
    /**
     * 
     */
    private static final String DESCRIPTION = "description";
    /**
     * 
     */
    private static final String ID          = "{http://www.omg.org/XMI}id";
    /**
     * 
     */
    private static final String DOT_QM      = ".qm#";
    private static final String NORM        = "normalizer";

    /**
     * @param attrs
     * @return
     */
    public static Annotation createAnnotation(final String modelName, final Map<String, String> attrs)
    {
        return new Annotation(attrs.get("key"), attrs.get("value"),
                QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * @param modelName
     * @param attrs
     * @return
     */
    private static String extractIdentifier(final String modelName, final Map<String, String> attrs)
    {
        return modelName + QMEntityFactory.DOT_QM + attrs.get(QMEntityFactory.ID);
    }

    /**
     * @param attrs
     * @return
     */
    public static Entity createEntity(final String modelName, final Map<String, String> attrs)
    {
        return new Entity(attrs.get(QMEntityFactory.NAME),
                attrs.containsKey(QMEntityFactory.DESCRIPTION) ? attrs.get(QMEntityFactory.DESCRIPTION) : "",
                attrs.containsKey("originatesFrom") ? new OriginatesFrom(attrs.get("originatesFrom")) : null,
                attrs.get(QMEntityFactory.TITLE), QMEntityFactory.extractIdentifier(modelName, attrs), null);
    }

    /**
     * @param attrs
     * @param characterizes
     * @return
     */
    public static Measure createMeasure(final String modelName, final Map<String, String> attrs,
            final String characterizes)
    {
        return new Measure(attrs.get(QMEntityFactory.NAME), attrs.get(QMEntityFactory.DESCRIPTION),
                attrs.get(QMEntityFactory.TITLE), characterizes == null ? null : new Characterizes(characterizes),
                attrs.get("type"), attrs.get("taggedBy"), null, null,
                QMEntityFactory.extractIdentifier(modelName, attrs),
                attrs.get(QMEntityFactory.NORM) == null ? false : true);
    }

    /**
     * @param attrs
     * @param evalhref
     * @param maxpts
     * @return
     */
    public static Evaluation createEvaluation(final String modelName, final Map<String, String> attrs)
    {
        BigDecimal maxpts = new BigDecimal(100);
        if (attrs.get("maximumPoints") != null)
        {
            maxpts = new BigDecimal(attrs.get("maximumPoints"));
        }

        String evalhref = null;
        if (attrs.get("evaluates") != null)
        {
            evalhref = modelName + QMEntityFactory.DOT_QM + attrs.get("evaluates");
        }

        Evaluates e = evalhref == null ? null : new Evaluates(evalhref);

        return new Evaluation(attrs.get(QMEntityFactory.NAME), attrs.get(QMEntityFactory.DESCRIPTION),
                attrs.get("specification"), maxpts, attrs.get("completeness"), e, attrs.get(QMEntityFactory.TYPE),
                QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * @param attrs
     * @return
     */
    public static Factor createFactor(final String modelName, final Map<String, String> attrs, String characterizes)
    {
        return new Factor(attrs.get(QMEntityFactory.NAME), attrs.get(QMEntityFactory.DESCRIPTION),
                characterizes == null ? null : new Characterizes(characterizes), null, null, null,
                QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * @param attrs
     * @param lb
     * @param ub
     * @return
     */
    public static Function createFunction(final String modelName, final Map<String, String> attrs)
    {
        BigDecimal lb = BigDecimal.ZERO;
        if (attrs.get("lowerBound") != null)
        {
            lb = new BigDecimal(attrs.get("lowerBound"));
        }
        BigDecimal ub = BigDecimal.ONE;
        if (attrs.get("upperBound") != null)
        {
            ub = new BigDecimal(attrs.get("upperBound"));
        }
        return new Function(lb, ub, attrs.get(QMEntityFactory.TYPE),
                QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * @param attrs
     * @param target
     * @return
     */
    public static Influence createInfluences(final String modelName, final Map<String, String> attrs)
    {
        String target = attrs.get("target");
        if (target != null && !target.contains(QMEntityFactory.DOT_QM))
        {
            target = modelName + QMEntityFactory.DOT_QM + target;
        }

        InfluenceEffect effect = InfluenceEffect.POSITIVE;
        if (attrs.get("effect") != null)
        {
            effect = InfluenceEffect.valueOf(attrs.get("effect"));
        }

        return new Influence(effect, attrs.get("justification"), target == null ? null : new Target(target),
                QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * @param attrs
     * @param determines
     * @param mmtool
     * @return
     */
    public static MeasurementMethod createMeasurementMethod(final String modelName, final Map<String, String> attrs)
    {
        String determines = null;
        if (attrs.get("determines") != null)
        {
            determines = modelName + QMEntityFactory.DOT_QM + attrs.get("determines");
        }
        String mmtool = null;
        if (attrs.get("tool") != null)
        {
            mmtool = modelName + QMEntityFactory.DOT_QM + attrs.get("tool");
        }

        return new MeasurementMethod(attrs.get(QMEntityFactory.NAME), attrs.get(QMEntityFactory.DESCRIPTION),
                determines == null ? null : new Determines(determines), mmtool, attrs.get("metric"), null,
                attrs.get(QMEntityFactory.TYPE), QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * @param attrs
     * @return
     */
    public static QualityModel createQualityModel(final Map<String, String> attrs)
    {
        return new QualityModel(attrs.get(QMEntityFactory.NAME).toLowerCase().split("-")[0],
                attrs.get(QMEntityFactory.DESCRIPTION), null, null, attrs.get(QMEntityFactory.ID));
    }

    /**
     * @param eval
     * @param attrs
     * @param normMeas
     * @param meashref
     * @param fachref
     * @return
     */
    public static Ranking createRanking(final String modelName, final Evaluation eval, final Map<String, String> attrs)
    {
        String normMeas = null;
        if (attrs.get("normlizationMeasure") != null)
        {
            normMeas = modelName + QMEntityFactory.DOT_QM + attrs.get("normlizationMeasure");
        }
        MeasureLink meashref = null;
        if (attrs.get("measure") != null)
        {
            meashref = new MeasureLink(modelName + QMEntityFactory.DOT_QM + attrs.get("measure"));
        }
        FactorLink fachref = null;
        if (attrs.get("factor") != null)
        {
            fachref = new FactorLink(modelName + QMEntityFactory.DOT_QM + attrs.get("factor"));
        }

        if (attrs.get("rank") == null)
            return null;
        if (attrs.get("weight") == null)
            return null;

        return new Ranking(attrs.get("rank"), attrs.get("range"), attrs.get("weight"), meashref, fachref,
                normMeas == null ? null : new NormalizationMeasure(normMeas), eval.getId(),
                QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * @param attrs
     * @return
     */
    public static Source createSource(final String modelName, final Map<String, String> attrs)
    {
        return new Source(attrs.get(QMEntityFactory.NAME), attrs.get(QMEntityFactory.DESCRIPTION),
                QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * @param attrs
     * @return
     */
    public static Tag createTag(final String modelName, final Map<String, String> attrs)
    {
        return new Tag(attrs.get(QMEntityFactory.NAME), attrs.get(QMEntityFactory.DESCRIPTION),
                QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * @param attrs
     * @return
     */
    public static Tool createTool(final String modelName, final Map<String, String> attrs)
    {
        return new Tool(attrs.get(QMEntityFactory.NAME), attrs.get(QMEntityFactory.DESCRIPTION), null,
                QMEntityFactory.extractIdentifier(modelName, attrs));
    }

    /**
     * 
     */
    private QMEntityFactory()
    {
    }
}
