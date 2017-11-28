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
package edu.montana.gsoc.msusel.quamoco.model;

import edu.montana.gsoc.msusel.quamoco.io.EvaluationType;
import lombok.Builder;
import lombok.Singular;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;

/**
 * The evaluation is done manually without using pre-defined calculation
 * criteria.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ManualEvaluation extends Evaluation {

    /**
     * 
     */
    public ManualEvaluation()
    {
        super();
    }

    public ManualEvaluation(String identifier)
    {
        super(identifier);
    }

    @Builder(buildMethodName = "create")
    protected ManualEvaluation(Double completeness, Double maximumPoints, String title, String description, Factor evaluates,
                          String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(completeness, maximumPoints, title, description, evaluates, identifier, originatesFrom, tags, annotations);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double evaluate()
    {
        throw new RuntimeException("Not yet implemented");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("<evaluations xmi:id=\"%s\" xsi:type=\"%s\"", getIdentifier(), EvaluationType.MANUAL_EVALUATION.type()));
        if (getDescription() != null)
            builder.append(String.format(" description=\"%s\"", StringEscapeUtils.escapeXml10(getDescription())));
        if (getMaximumPoints() != null)
            builder.append(String.format(" maximumPoints=\"%f\"", getMaximumPoints()));
        if (getEvaluates() != null)
            builder.append(String.format(" evaluates=\"%s\"", getEvaluates()));
        if (getCompleteness() != null)
            builder.append(String.format(" completeness=\"%f\"", getCompleteness()));
        builder.append(" />");

        return builder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toScript()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
