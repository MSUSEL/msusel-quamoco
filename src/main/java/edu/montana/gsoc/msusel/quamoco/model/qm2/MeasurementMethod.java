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
 * @author Isaac Griffith
 */
public class MeasurementMethod {

    private Measure               determines;
    private String                metric;
    private Instrument            tool;
    private MeasurementMethodType type;

    /**
     * @return the determines
     */
    public Measure getDetermines()
    {
        return determines;
    }

    /**
     * @param determines
     *            the determines to set
     */
    public void setDetermines(Measure determines)
    {
        this.determines = determines;
    }

    /**
     * @return the metric
     */
    public String getMetric()
    {
        return metric;
    }

    /**
     * @param metric
     *            the metric to set
     */
    public void setMetric(String metric)
    {
        this.metric = metric;
    }

    /**
     * @return the tool
     */
    public Instrument getTool()
    {
        return tool;
    }

    /**
     * @param tool
     *            the tool to set
     */
    public void setTool(Instrument tool)
    {
        this.tool = tool;
    }

    /**
     * @return the type
     */
    public MeasurementMethodType getType()
    {
        return type;
    }

    /**
     * @param type
     *            the type to set
     */
    public void setType(MeasurementMethodType type)
    {
        this.type = type;
    }
}
