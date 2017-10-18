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

import javax.annotation.Nonnull;

import org.apache.commons.lang3.StringEscapeUtils;

import edu.montana.gsoc.msusel.quamoco.io.EvaluationType;

/**
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class QIESLEvaluation extends TextEvaluation {

    /**
     * 
     */
    public QIESLEvaluation()
    {
        super();
    }

    public QIESLEvaluation(String identifier)
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
                        "<evaluations xmi:id=\"%s\" xsi:type=\"%s\" description=\"%s\" specification=\"%s\" maximumPoints=\"%f\" evaluates=\"%s\" completeness=\"%f\"",
                        getIdentifier(), EvaluationType.QIESL_EVALUATION.type(),
                        StringEscapeUtils.escapeXml10(getDescription()),
                        StringEscapeUtils.escapeXml10(getSpecification()), getMaximumPoints(), getEvaluates(),
                        getCompleteness()));

        return builder.toString();
    }

    /**
     * Creates a new Builder for a TextEvaluation
     * 
     * @return the TextEvaluation.Builder instance
     */
    public static Builder builder()
    {
        return new QIESLEvaluationBuilder();
    }

    /**
     * Creates a new Builder for a TextEvaluation with the given
     * unique identifier
     * 
     * @param identifier
     *            Unique identifier
     * @return the TextEvaluation.Builder instance
     */
    public static Builder builder(String identifier)
    {
        return new QIESLEvaluationBuilder(identifier);
    }

    /**
     * Builder for TextEvaluations implemented using the fluent
     * interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class QIESLEvaluationBuilder extends Builder {

        /**
         * Constructs a new Builder for a TextEvaluation
         */
        private QIESLEvaluationBuilder()
        {
            super();
            element = new QIESLEvaluation();
        }

        /**
         * Constructs a new Builder for a TextEvaluation with the
         * given
         * identifier
         * 
         * @param identifier
         *            The identifier of the tool to construct
         */
        private QIESLEvaluationBuilder(String identifier)
        {
            super(identifier);
            element = new QIESLEvaluation(identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @Nonnull
        public QIESLEvaluation create()
        {
            return (QIESLEvaluation) element;
        }
    }
}
