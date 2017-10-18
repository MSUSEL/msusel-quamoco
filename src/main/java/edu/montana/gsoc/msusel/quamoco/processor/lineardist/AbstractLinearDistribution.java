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
package edu.montana.gsoc.msusel.quamoco.processor.lineardist;

import java.math.BigDecimal;
import java.math.RoundingMode;

import edu.montana.gsoc.msusel.quamoco.processor.LinearDistribution;

/**
 * Base implementation of a LinearDistribution
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class AbstractLinearDistribution implements LinearDistribution {

    /**
     * {@inheritDoc}
     */
    @Override
    public BigDecimal calculate(final BigDecimal proportion, final BigDecimal lowerBound, final BigDecimal lowerResult,
            final BigDecimal upperBound, final BigDecimal upperResult)
    {
        if (proportion.compareTo(lowerBound) <= 0)
        {
            return lowerResult;
        }
        else if (proportion.compareTo(upperBound) >= 0)
        {
            return upperResult;
        }
        else if (upperBound.compareTo(lowerBound) == 0)
        {
            return upperResult;
        }
        else
        {
            BigDecimal slopeNum = upperResult.subtract(lowerResult);
            BigDecimal slopeDen = upperBound.subtract(lowerBound);
            final BigDecimal slope = slopeNum.divide(slopeDen, 15, RoundingMode.HALF_UP);
            return slope.multiply(proportion.subtract(lowerBound)).add(lowerResult);
        }
    }
}
