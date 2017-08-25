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
 * An enumeration indicating the type of aggregation for a measure
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public enum AggregationType {

    /**
     * Indicates that the measure should aggregate incoming finding sets using
     * the intersection operator
     */
    FINDINGS_INTERSECTION,
    /**
     * Indicates that the measure should aggregate incoming finding sets using
     * the union operator
     */
    FINDINGS_UNION,
    /**
     * Indicates that the measure should aggregate incoming value sets using the
     * min operator
     */
    NUMBER_MIN,
    /**
     * Indicates that the measure should aggregate incoming value sets using the
     * max operator
     */
    NUMBER_MAX,
    /**
     * Indicates that the measure should aggregate incoming value sets using the
     * mean operator
     */
    NUMBER_MEAN,
    /**
     * Indicates that the measure should aggregate incoming value sets using the
     * median operator
     */
    NUMBER_MEDIAN,
    /**
     * An aggregation where the specification is a semi-formal text.
     */
    TEXT
}
