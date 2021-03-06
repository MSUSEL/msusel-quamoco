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
package edu.montana.gsoc.msusel.quamoco.distiller;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * An enumeration representing a grade.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public enum Grade {

    A("A"), B("B"), C("C"), D("D"), E("E"), F("F"), U("U");

    /**
     * @return List of all enum literals
     */
    public static List<Grade> getGrades()
    {
        return Arrays.asList(Grade.values());
    }

    /**
     * The Grade
     */
    private String     name;
    /**
     * The lower threshold value for this grade.
     */
    private BigDecimal lower;

    /**
     * The upper threshold value for this grade.
     */
    private BigDecimal upper;

    /**
     * Constructor
     *
     * @param name
     *            Name of this grade.
     */
    private Grade(final String name)
    {
        this.name = name;
        lower = BigDecimal.ZERO;
        upper = BigDecimal.ONE;
    }

    /**
     * Determine if the value should be assigned the selected grade.
     *
     * @param val
     *            value to be evaluated.
     * @return 0 if the value should be assigned the grade, >= 1 if the value
     *         should be assigned a grader higher than this one, or <= -1 if the
     *         value should be assigned a lower grade than this one.
     */
    public int evaluate(final BigDecimal val)
    {
        if (val.compareTo(lower) > 0 && val.compareTo(upper) <= 0)
        {
            return 0;
        }
        else if (val.compareTo(lower) <= 0)
        {
            return -1;
        }
        else
        {
            return 1;
        }
    }

    /**
     * @return the grade name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the lower and upper thresholds for this grade.
     *
     * @param lower
     *            Lower threshold
     * @param upper
     *            Upper threshold
     * @throws GradeThresholdException
     *             if the lower threshold is greater than the upper threshold.
     */
    public void setThresholds(final BigDecimal lower, final BigDecimal upper) throws GradeThresholdException
    {
        if (lower.compareTo(upper) > 0)
        {
            throw new GradeThresholdException(
                    "In Grade " + name + ", the lower grade threshold cannot exceed the upper grade threshold.");
        }

        this.lower = lower;
        this.upper = upper;
    }

    /**
     * @return the lower threshold
     */
    public BigDecimal getLowerThreshold()
    {
        return lower;
    }

    /**
     * @return the upper threshold
     */
    public BigDecimal getUpperThreshold()
    {
        return upper;
    }
}
