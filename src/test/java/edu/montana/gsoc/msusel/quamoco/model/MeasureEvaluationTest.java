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

import edu.montana.gsoc.msusel.quamoco.io.EvaluationType;
import edu.montana.gsoc.msusel.quamoco.model.eval.MeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.func.Function;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measure.NormalizationMeasure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class MeasureEvaluationTest {

    MeasureEvaluation element;

    @Before
    public void setUp() throws Exception {
        element = SingleMeasureEvaluation.builder().identifier("ID")
                .normalization(mock(NormalizationMeasure.class))
                .range(NormalizationRange.CLASS)
                .basedOn(mock(Measure.class))
                .function(mock(Function.class))
                .create();
    }

    @Test
    public void getRange() throws Exception {
        assertEquals(NormalizationRange.CLASS, element.getRange());
    }

    @Test
    public void setRange() throws Exception {
        element.setRange(NormalizationRange.FILE);
        assertEquals(NormalizationRange.FILE, element.getRange());
    }

    @Test
    public void getNormalization() throws Exception {
        assertNotNull(element.getNormalization());
    }

    @Test
    public void setNormalization() throws Exception {
        element.setNormalization(null);
        assertNull(element.getNormalization());
        element.setNormalization(mock(NormalizationMeasure.class));
        assertNotNull(element.getNormalization());
    }

    @Test
    public void getFunction() throws Exception {
        assertNotNull(element.getFunction());
    }

    @Test
    public void setFunction() throws Exception {
        element.setFunction(null);
        assertNull(element.getFunction());
        element.setFunction(mock(Function.class));
        assertNotNull(element.getFunction());
    }

    @Test
    public void getBasedOn() throws Exception {
        assertNotNull(element.getBasedOn());
    }

    @Test
    public void setBasedOn() throws Exception {
        element.setBasedOn(null);
        assertNull(element.getBasedOn());
        element.setBasedOn(mock(Measure.class));
        assertNotNull(element.getBasedOn());
    }

    @Test
    public void generateXMLTag() throws Exception {
        String value = "<evaluations xmi:id=\"ID\" xsi:type=\"qm:SingleMeasureEvaluation\" basedOn=\"null\" range=\"CLASS\">\n" +
                "<normlizationMeasure href=\"null\" />\n" +
                "null</evaluations>";

        assertEquals(value, element.generateXMLTag(EvaluationType.SINGLE_MEASURE_EVALUATION.type()));
    }

}