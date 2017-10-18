/**
 * The MIT License (MIT)
 *
 * SparQLine Quamoco Implementation
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class MultiMeasureEvaluation extends FormBasedEvaluation {

    /**
     * 
     */
    public MultiMeasureEvaluation()
    {
        super();
    }

    /**
     * @param identifier
     */
    public MultiMeasureEvaluation(String identifier)
    {
        super(identifier);
    }
    
    protected String generateXMLTag(String type)
    {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "<evaluations xmi:id=\"%s\" xsi:type=\"%s\" description=\"%s\" maximumPoints=\"%f\" evaluates=\"%s\" completeness=\"%f\" />%n",
                        getIdentifier(), type,
                        StringEscapeUtils.escapeXml10(getDescription()), getMaximumPoints(),
                        getEvaluates().getQualifiedIdentifier(),
                        getCompleteness()));

        return builder.toString();
    }

    /**
     * Base Builder for MultiMeasureEvauations
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public abstract static class AbstractMultiMeasureEvaluationBuilder extends AbstractFormBasedEvaluationBuilder {

    }
}
