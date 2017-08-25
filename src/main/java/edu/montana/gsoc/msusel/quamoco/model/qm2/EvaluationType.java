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

/**
 * An enumeration indicating the different means by which a factor evaluates its
 * inputs.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public enum EvaluationType {

    /**
     * Indicates that the factor's values are manually provided
     */
    MANUAL,
    /**
     * Indicates that the factor should take the mean of incoming measure values
     */
    MEAN,
    /**
     * Indicates that the factor only takes in a single measure and basically
     * passes that value on
     */
    SINGLE_MEASURE,
    /**
     * Indicates that the factor only takes in other factor values and produces
     * a weighted sum of those input values
     */
    WEIGHTED_SUM_FACTOR_AGGREGATION,
    /**
     * An evaluation where the specification is a semi-formal text.
     */
    TEXT
}
