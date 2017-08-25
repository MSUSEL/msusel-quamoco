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
package edu.montana.gsoc.msusel.quamoco.model.qm2;

import java.util.List;

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
public class Evaluation {

    /**
     * 
     */
    private Percentage     completeness;
    /**
     * 
     */
    private Factor         evaluates;
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
    private Double         maximumPoints;
    /**
     * 
     */
    private String         specification;
    /**
     * A title is an optional additional name for the evaluation.
     */
    private String         title;
    /**
     * 
     */
    private EvaluationType type;
    /**
     * 
     */
    private List<Ranking>  rankings;
    protected String       qualifiedName;
    protected String       name;
    protected String       description;

    /**
     * @return the completeness
     */
    public Percentage getCompleteness()
    {
        return completeness;
    }

    /**
     * @param completeness
     *            the completeness to set
     */
    public void setCompleteness(Percentage completeness)
    {
        this.completeness = completeness;
    }

    /**
     * @return the evaluates
     */
    public Factor getEvaluates()
    {
        return evaluates;
    }

    /**
     * @param evaluates
     *            the evaluates to set
     */
    public void setEvaluates(Factor evaluates)
    {
        this.evaluates = evaluates;
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
     * @return the type
     */
    public EvaluationType getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(EvaluationType type)
    {
        this.type = type;
    }
}
