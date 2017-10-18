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
package edu.montana.gsoc.msusel.quamoco.model.result;

/**
 * @author Isaac Griffith
 *
 */
public class DoubleInterval implements Comparable<DoubleInterval> {

    private double lower;
    private double upper;
    
    /**
     * 
     */
    public DoubleInterval(double lower, double upper)
    {
        this.lower = lower;
        this.upper = upper;
    }
    
    /**
     * @return the lower
     */
    public double getLower()
    {
        return lower;
    }

    /**
     * @return the upper
     */
    public double getUpper()
    {
        return upper;
    }

    public boolean contains(double value) {
        return Double.compare(lower, value) <= 0 && Double.compare(value, upper) <= 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(DoubleInterval o)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(lower);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(upper);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        DoubleInterval other = (DoubleInterval) obj;
        if (Double.doubleToLongBits(lower) != Double.doubleToLongBits(other.lower))
        {
            return false;
        }
        if (Double.doubleToLongBits(upper) != Double.doubleToLongBits(other.upper))
        {
            return false;
        }
        return true;
    }

    
}
