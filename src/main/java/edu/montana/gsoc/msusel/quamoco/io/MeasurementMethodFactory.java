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
package edu.montana.gsoc.msusel.quamoco.io;

import edu.montana.gsoc.msusel.quamoco.model.MeasurementMethod;
import org.w3c.dom.Element;

/**
 * @author Isaac Griffith
 */
public class MeasurementMethodFactory extends AbstractQMElementFactory {

    /**
     * 
     */
    private MeasurementMethodFactory()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @author Isaac Griffith
     */
    private static class Holder {

        /**
         * 
         */
        private static final MeasurementMethodFactory INSTANCE = new MeasurementMethodFactory();
    }

    /**
     * @return
     */
    public static MeasurementMethodFactory instance()
    {
        return Holder.INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MeasurementMethod create(Element e)
    {
        MeasurementMethod method = null;

        if (e.hasAttribute("xsi:type"))
        {
            MeasurementMethodType type = MeasurementMethodType.fromType(e.getAttribute("xsi:type"));
            switch (type)
            {
            case MANUAL_INSTRUMENT:
                break;
            case RULE_BASED_INSTRUMENT:
                // need to determine if it is a rule or metric based instrument
                // by
                // looking at what it is connected to.
                break;
            case METRIC_BASED_INSTRUMENT:
                break;
            case QIESL_AGGREGATION:
                break;
            case TEXT_AGGREGATION:
                break;
            case FINDINGS_INTERSECTION_MEASURE_AGGREGATION:
                break;
            case FINDINGS_UNION_MEASURE_AGGREGATION:
                break;
            case NUMBER_HISTOGRAM_COMP_MEASURE_AGGREGATION:
                break;
            case NUMBER_MAX_MEASURE_AGGREGATION:
                break;
            case NUMBER_MEAN_MEASURE_AGGREGATION:
                break;
            case NUMBER_MEDIAN_MEASURE_AGGREGATION:
                break;
            case NUMBER_MIN_MEASURE_AGGREGATION:
                break;
            case NUMBER_MODE_MEASURE_AGGREGATION:
                break;
            case NUMBER_RANGE_MEASURE_AGGREGATION:
                break;
            case NUMBER_STD_DEV_MEASURE_AGGREGATION:
                break;
            case NUMBER_SUMMATION_MEASURE_AGGREGATION:
                break;
            case NUMBER_VARIANCE_MEASURE_AGGREGATION:
                break;
            }
        }

        return method;
    }
}
