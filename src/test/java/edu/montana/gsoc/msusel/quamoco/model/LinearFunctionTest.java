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
package edu.montana.gsoc.msusel.quamoco.model;

import edu.montana.gsoc.msusel.quamoco.io.FunctionType;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearFunction;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearIncreasingFunction;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinearFunctionTest {

    LinearFunction element;

    @Before
    public void setUp() throws Exception {
        element = LinearIncreasingFunction.builder()
                .identifier("ID")
                .upperBound(1.0)
                .lowerBound(0.0)
                .create();
    }

    @Test
    public void getLowerBound() throws Exception {
        assertEquals(0.0, element.getLowerBound(), 0.001);
    }

    @Test
    public void setLowerBound() throws Exception {
        element.setLowerBound(1.0);
        assertEquals(1.0, element.getLowerBound(), 0.001);
    }

    @Test
    public void getUpperBound() throws Exception {
        assertEquals(1.0, element.getUpperBound(), 0.001);
    }

    @Test
    public void setUpperBound() throws Exception {
        element.setUpperBound(0.0);
        assertEquals(0.0, element.getUpperBound(), 0.001);
    }

    @Test
    public void generateXMLTag() throws Exception {
        String tag = element.generateXMLTag(FunctionType.LINEAR_INCREASING.type());
        String value = "<function xmi:id=\"ID\" xsi:type=\"qm:LinearIncreasingFunction\" lowerBound=\"0.000000\" upperBound=\"1.000000\" />\n";
        assertEquals(value, tag);

        tag = element.generateXMLTag(FunctionType.LINEAR_DECREASING.type());
        value = "<function xmi:id=\"ID\" xsi:type=\"qm:LinearDecreasingFunction\" lowerBound=\"0.000000\" upperBound=\"1.000000\" />\n";
        assertEquals(value, tag);
    }

}