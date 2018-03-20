/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.quamoco.processor;

/**
 * Provides the base interface for the LinearDistribution classes.
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public interface LinearDistribution {

    /**
     * Calculates the value of a measure given the max points and proportion of
     * that measure across a software system.
     * 
     * @param maxPoints
     *            Maximum points associated with the measure.
     * @param proportion
     *            Proportion that this measure affects the software system.
     * @return interpolated value of the measure according to the distribution
     */
    double calculate(double maxPoints, double proportion);

    /**
     * Calculates the value of a measure within a software system.
     * 
     * @param proportion
     *            Proportion that the measure affects the software system
     * @param lowerBound
     *            Minimum bounding value (in points)
     * @param lowerResult
     *            Lowest resulting value of the measure.
     * @param upperBound
     *            Maximum bounding value (in points)
     * @param upperResult
     *            Highest resulting value of the measure.
     * @return interpolated value of the measure according to the distribution.
     */
    double calculate(double proportion, double lowerBound, double lowerResult, double upperBound,
            double upperResult);
}
