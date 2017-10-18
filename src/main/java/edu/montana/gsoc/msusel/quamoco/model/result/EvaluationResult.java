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

import edu.montana.gsoc.msusel.quamoco.model.Evaluation;

/**
 * @author Isaac Griffith
 */
public abstract class EvaluationResult extends AbstractResult {

    private Evaluation resultFrom;
    private DoubleInterval value;

    /**
     * 
     */
    public EvaluationResult()
    {
        super();
    }

    public EvaluationResult(String identifier)
    {
        super(identifier);
    }

    /**
     * @return the value
     */
    public DoubleInterval getValue()
    {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(DoubleInterval value)
    {
        this.value = value;
    }

    /**
     * @return the resultFrom
     */
    public Evaluation getResultFrom()
    {
        return resultFrom;
    }

    /**
     * @param resultFrom the resultFor to set
     */
    public void setResultFrom(Evaluation resultFrom)
    {
        this.resultFrom = resultFrom;
    }
}
