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

import edu.montana.gsoc.msusel.quamoco.io.EvaluationType;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * An evaluation where the specification is a semi-formal text.
 * <br>
 * General Rules:
 * <ul>
 * <li>Within one model, the textual specification should be used consistently
 * and marked out by a telling name.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class TextEvaluation extends Evaluation {

    /**
     * The textual specification can be used for writing any syntax; thus the
     * text will not be evaluated.
     */
    private String specification;

    /**
     * 
     */
    public TextEvaluation()
    {
        super();
    }

    public TextEvaluation(String identifier)
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
     * @return the specification
     */
    public String getSpecification()
    {
        return specification;
    }

    /**
     * @param specification
     *            the specification to set
     */
    public void setSpecification(String specification)
    {
        this.specification = specification;
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
                        getIdentifier(), EvaluationType.TEXT_EVALUATION.type(),
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
        return new Builder();
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
        return new Builder(identifier);
    }

    /**
     * Builder for TextEvaluations implemented using the fluent
     * interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder extends AbstractEvaluationBuilder {

        /**
         * Constructs a new Builder for a TextEvaluation
         */
        protected Builder()
        {
            element = new TextEvaluation();
        }

        /**
         * Constructs a new Builder for a TextEvaluation with the
         * given
         * identifier
         * 
         * @param identifier
         *            The identifier of the tool to construct
         */
        protected Builder(String identifier)
        {
            element = new TextEvaluation(identifier);
        }

        /**
         * {@inheritDoc}
         */
        @Nonnull
        public TextEvaluation create()
        {
            return (TextEvaluation) element;
        }

        /**
         * Sets the text specification for this evaluation
         * 
         * @param spec
         *            The Text Specification of the evaluation
         * @return this
         */
        @Nonnull
        public Builder specification(String spec)
        {
            ((TextEvaluation) element).setSpecification(spec);

            return this;
        }
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
}
