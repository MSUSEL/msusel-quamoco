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
package edu.montana.gsoc.msusel.quamoco.model.eval;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * An evaluation describes how to calculate the degree to which the factor is
 * present is a system under analysis. There are various ways to calculate an
 * evaluation, i.e., by using the predefined operations for a single measure or
 * the weighted sum for factors, by writing QIESL syntax or a simple textual
 * specification, as well as performing a manual evaluation.
 * <br>
 * General Rules:
 * <ol>
 * <li>When evaluating a factor based on measures use only measures that are
 * defined there (and a normalization measure for normalizing).</li>
 * <li>When evaluating a factor based on factors use only factors that refine
 * the factor or have an impact.</li>
 * </ol>
 * 
 * @author Isaac Griffith
 * @version 1.3.0
 */
public abstract class Evaluation extends QMElement {

    /**
     * 
     */
    @Getter @Setter
    protected Double completeness;
    /**
     * <ul>
     * <li>A factor is always evaluated using points. Provide the number of
     * points that can be archived by an assessment for this factor in the best
     * case.
     * By default, the values is 100.</li>
     * <li>An evaluation result of 0 Points means that a factor is not present.
     * An evaluation result with maxPoints means that the factor is full
     * present.</li>
     * <li>For product factors and -ilities factors points are used to
     * characterize the degree to which a factor is present in the software
     * product. For use
     * case factors they are used to characterize the degree to which the use
     * case satisfies the factor. For stakeholder satisfaction factors they are
     * used to characterize the degree to which the stakeholder is
     * satisfied.</li>
     * </ul>
     */
    @Getter @Setter
    protected Double maximumPoints;
    @Setter
    protected String modelName;
    @Setter
    @Getter
    protected String name;
    /**
     * A title is an optional additional name for the evaluation.
     */
    @Getter @Setter
    protected String title;
    @Getter @Setter
    protected String description;
    @Getter @Setter
    protected Factor evaluates;

    public Evaluation()
    {
        super();
    }

    public Evaluation(String identifier)
    {
        super(identifier);
    }

    protected Evaluation(String name, Double completeness, Double maximumPoints, String title, String description, Factor evaluates,
                         String identifier, Source originatesFrom, List<Tag> taggedBy, List<Annotation> annotations) {
        super(identifier, originatesFrom, taggedBy, annotations);
        this.name = name;
        this.completeness = completeness;
        this.maximumPoints = maximumPoints;
        this.title = title;
        this.description = description;
        this.evaluates = evaluates;
    }

    public abstract double evaluate();

    public String getFullName() {
        StringBuilder builder = new StringBuilder();
        if (modelName != null) {
            builder.append(modelName);
            builder.append(File.separator);
        }
        if (evaluates != null) {
            builder.append(evaluates.getFullName());
            builder.append(File.separator);
        }
        builder.append(getName());

        return builder.toString();
    }

    protected String generateXMLTag(String type) {
        return generateXMLTag(type, Maps.newHashMap());
    }

    protected String generateXMLTag(String type, Map<String, String> attrs, List<String> content) {
        String tag = "evaluations";

        if (getDescription() != null)
            attrs.put("description", StringEscapeUtils.escapeXml10(getDescription()));
        if (getMaximumPoints() != null)
            attrs.put("maximumPoints", getMaximumPoints().toString());
        if (getEvaluates() != null)
            attrs.put("evaluates", StringEscapeUtils.escapeXml10(getEvaluates().getQualifiedIdentifier()));
        if (getCompleteness() != null)
            attrs.put("completeness", getCompleteness().toString());

        return generateXMLTag(tag, type, attrs, content);
    }

    protected String generateXMLTag(String type, Map<String, String> attrs)
    {
        return generateXMLTag(type, attrs, Lists.newArrayList());
    }
}
