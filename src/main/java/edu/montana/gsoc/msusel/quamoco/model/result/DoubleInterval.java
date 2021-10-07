/*
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
package edu.montana.gsoc.msusel.quamoco.model.result;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
@EqualsAndHashCode
@ToString
@Builder(buildMethodName = "create")
public class DoubleInterval implements Comparable<DoubleInterval> {

    @Getter
    @Builder.Default
    private double lower = 0.0;
    @Getter
    @Builder.Default
    private double upper = 1.0;

    /**
     *
     */
    public DoubleInterval(double lower, double upper) {
        this.lower = lower;
        this.upper = upper;
    }

    public boolean contains(double value) {
        return Double.compare(lower, value) <= 0 && Double.compare(value, upper) <= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(DoubleInterval o) {
        if (o == null)
            throw new IllegalArgumentException();

        double x1 = lower;
        double y1 = o.lower;
        double x2 = upper;
        double y2 = o.upper;
        double range1 = Math.abs(upper - lower);
        double range2 = Math.abs(o.upper - o.lower);

        if (Double.compare(x1, y1) == 0 && Double.compare(x2, y2) == 0)
            return 0;
        else return Double.compare(range1, range2);
    }
}
