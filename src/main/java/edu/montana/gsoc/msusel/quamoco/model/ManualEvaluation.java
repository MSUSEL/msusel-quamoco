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

import edu.montana.gsoc.msusel.quamoco.io.EvaluationType;
import org.apache.commons.lang3.StringEscapeUtils;

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

        builder.append(
                String.format(
                        "<evaluations xmi:id=\"%s\" xsi:type=\"%s\" description=\"%s\" maximumPoints=\"%f\" evaluates=\"%s\" completeness=\"%f\" />%n",
                        getIdentifier(), EvaluationType.MANUAL_EVALUATION.type(),
                        StringEscapeUtils.escapeXml10(getDescription()), getMaximumPoints(), getEvaluates(),
                        getCompleteness()));

        return builder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toYaml()
    {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toJson()
    {
        // TODO Auto-generated method stub
        return null;
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

    /**
     * @return
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * @param identifier
     * @return
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractEvaluationBuilder {

        /**
         * 
         */
        public Builder()
        {
            element = new ManualEvaluation();
        }

        /**
         * @param identifier
         */
        public Builder(String identifier)
        {
            element = new ManualEvaluation(identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ManualEvaluation create()
        {
            return (ManualEvaluation) element;
        }

    }
}
