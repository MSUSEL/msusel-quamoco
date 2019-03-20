/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2019 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory and Idaho State University, Informatics and
 * Computer Science, Empirical Software Engineering Laboratory
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
package edu.montana.gsoc.msusel.quamoco.graph.node;

/**
 * Interface holding the constants associated with the aggregation method for
 * the measure.
 * FIXME: This should be an Enumeration
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public interface MeasureMethod {

    /**
     * Indicates that the measure will aggregate findings by taking the union of
     * all incoming sets
     */
    String UNION     = "Union";
    /**
     * Indicates that the measure will aggregate findings by taking the
     * intersection of all incoming sets
     */
    String INTERSECT = "Intersect";
    /**
     * Indicates that the measure will aggregate incoming values via the
     * arithmetic mean
     */
    String MEAN      = "Mean";
    /**
     * Indicates that the measure will aggregate incoming values by taking the
     * min of the values
     */
    String MIN       = "Min";
    /**
     * Indicates that the measure will aggregate incoming values by taking the
     * max of the values
     */
    String MAX       = "Max";
    /**
     * Indicates that the measure will aggregate incoming values by taking the
     * median of the value
     */
    String MEDIAN    = "Median";

}