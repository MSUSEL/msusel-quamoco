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
 * @version 1.1.1
 */
public abstract class Evaluation extends QMElement {

    /**
     * 
     */
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
    protected Double maximumPoints;
    /**
     * A title is an optional additional name for the evaluation.
     */
    protected String title;
    protected String description;
    protected Factor evaluates;

    public Evaluation()
    {
        super();
    }

    public Evaluation(String identifier)
    {
        super(identifier);
    }

    /**
     * @return the completeness
     */
    public Double getCompleteness()
    {
        return completeness;
    }

    /**
     * @param completeness
     *            the completeness to set
     */
    public void setCompleteness(Double completeness)
    {
        this.completeness = completeness;
    }

    /**
     * @return the maximumPoints
     */
    public Double getMaximumPoints()
    {
        return maximumPoints;
    }

    /**
     * @param maximumPoints
     *            the maximumPoints to set
     */
    public void setMaximumPoints(Double maximumPoints)
    {
        this.maximumPoints = maximumPoints;
    }

    public Factor getEvaluates()
    {
        return evaluates;
    }

    public void setEvaluates(Factor factor)
    {
        if (factor == null)
            return;

        this.evaluates = factor;
    }

    public abstract double evaluate();

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * Base Builder for Evaluation classes
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public abstract static class AbstractEvaluationBuilder extends AbstractQMElementBuilder {

        /**
         * Sets the element under construction's description
         * 
         * @param description
         *            the description to set
         * @return this
         */
        @Nonnull
        public AbstractEvaluationBuilder description(String description)
        {
            ((Evaluation) element).setDescription(description);

            return this;
        }

        /**
         * Sets the optional title of the TextEvaluation under
         * construction
         * 
         * @param title
         *            Title of the TextEvaluation
         * @return this
         */
        @Nonnull
        public AbstractEvaluationBuilder title(String title)
        {
            ((Evaluation) element).setTitle(title);

            return this;
        }

        /**
         * Sets the maximum points for this Evaluation
         * 
         * @param maximumPoints
         *            Max Points
         * @return this
         */
        @Nonnull
        public AbstractEvaluationBuilder maxPts(double maximumPoints)
        {
            ((Evaluation) element).setMaximumPoints(maximumPoints);

            return this;
        }

        /**
         * Sets the percentage (0.0 - 1.0) of completeness for this evaluation
         * of the given factor.
         * 
         * @param complete
         *            Percentage complete
         * @return this
         */
        @Nonnull
        public AbstractEvaluationBuilder completeness(double complete)
        {
            ((Evaluation) element).setCompleteness(complete);

            return this;
        }

        /**
         * Sets the factor evaluated by this evaluation
         * 
         * @param factor
         *            Factor to be evaluated
         * @return this
         */
        @Nonnull
        public AbstractEvaluationBuilder evaluates(Factor factor)
        {
            ((Evaluation) element).setEvaluates(factor);

            return this;
        }
    }
}
