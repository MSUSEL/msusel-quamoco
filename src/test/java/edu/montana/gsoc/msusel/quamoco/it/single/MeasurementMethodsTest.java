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
package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.measurement.ToolBasedInstrument;
import edu.montana.gsoc.msusel.quamoco.model.measurement.aggregation.TextAggregation;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MeasurementMethodsTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMeanTest() {
        MeasurementMethod m = manager.findMeasurementMethodByName("Test/Mean @Product/Mean Test");
        assertNotNull(m);

        assertEquals("Mean Test", m.getName());
        assertEquals("Mean Test", m.getTitle());
        assertEquals("Mean Test", m.getDescription());
        assertEquals("Mean @Product", m.getDetermines().getFullName());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testTest2() {
        ToolBasedInstrument m = (ToolBasedInstrument) manager.findMeasurementMethodByName("Test/Test Measure @Source Code Part/Test2");
        assertNotNull(m);

        assertEquals("Test2", m.getName());
        assertEquals("Test Tool", m.getTool().getName());
        assertEquals("Test Measure @Source Code Part", m.getDetermines().getFullName());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testTest() {
        ToolBasedInstrument m = (ToolBasedInstrument) manager.findMeasurementMethodByName("Test/Test Normalization @Source Code Part/Test");
        assertNotNull(m);

        assertEquals("Test", m.getName());
        assertEquals("Test Tool", m.getTool().getName());
        assertEquals("Test Normalization @Source Code Part", m.getDetermines().getFullName());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testHierManual() {
        MeasurementMethod m = manager.findMeasurementMethodByName("TestHier/ManualMeas/TestHier Manual");
        assertNotNull(m);

        assertEquals("TestHier Manual", m.getName());
        assertEquals("TestHier Manual", m.getTitle());
        assertEquals("TestHier Manual", m.getDescription());
        assertEquals("ManualMeas", m.getDetermines().getFullName());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testHierTest1() {
        ToolBasedInstrument m = (ToolBasedInstrument) manager.findMeasurementMethodByName("TestHier/Measure1/Test1");
        assertNotNull(m);

        assertEquals("Test1", m.getName());
        assertEquals("Measure1", m.getDetermines().getFullName());
        assertEquals("TestHierTool", m.getTool().getName());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testHierTest2() {
        ToolBasedInstrument m = (ToolBasedInstrument) manager.findMeasurementMethodByName("TestHier/Measure2/Test2");
        assertNotNull(m);

        assertEquals("Test2", m.getName());
        assertEquals("Measure2", m.getDetermines().getFullName());
        assertEquals("TestHierTool", m.getTool().getName());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testHierTest3() {
        ToolBasedInstrument m = (ToolBasedInstrument) manager.findMeasurementMethodByName("TestHier/Measure3/Test3");
        assertNotNull(m);

        assertEquals("Test3", m.getName());
        assertEquals("Measure3", m.getDetermines().getFullName());
        assertEquals("TestHierTool", m.getTool().getName());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testHierQIESLAggr() {
        TextAggregation m = (TextAggregation) manager.findMeasurementMethodByName("TestHier/QIESLMeas/TestHier QIESL Aggr");
        assertNotNull(m);

        assertEquals("TestHier QIESL Aggr", m.getName());
        assertEquals("TestHier QIESL Aggr", m.getTitle());
        assertEquals("TestHier QIESL Aggr", m.getDescription());
        assertEquals("QIESLMeas", m.getDetermines().getFullName());
        assertEquals("", m.getSpecification());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testHierTextAggr() {
        TextAggregation m = (TextAggregation) manager.findMeasurementMethodByName("TestHier/TextMeas/TestHier Text Aggr");
        assertNotNull(m);

        assertEquals("TestHier Text Aggr", m.getName());
        assertEquals("TestHier Text Aggr", m.getTitle());
        assertEquals("TestHier Text Aggr", m.getDescription());
        assertEquals("TextMeas", m.getDetermines().getFullName());
        assertEquals("", m.getSpecification());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testHierTest4() {
        ToolBasedInstrument m = (ToolBasedInstrument) manager.findMeasurementMethodByName("TestHier/ToolMeas/Test4");
        assertNotNull(m);

        assertEquals("Test4", m.getName());
        assertEquals("ToolMeas", m.getDetermines().getFullName());
        assertEquals("TestHierTool", m.getTool().getName());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testUnion() {
        MeasurementMethod m = manager.findMeasurementMethodByName("TestHier/UnionMeas/TestHier Union Aggr");
        assertNotNull(m);

        assertEquals("TestHier Union Aggr", m.getName());
        assertEquals("UnionMeas", m.getDetermines().getFullName());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
        assertEquals("TestHier Union Aggr", m.getDescription());
        assertEquals("TestHier Union Aggr", m.getTitle());
    }

    @Test
    public void testHierMean() {
        MeasurementMethod m = manager.findMeasurementMethodByName("TestHier/NormMeas/TestHier Mean");
        assertNotNull(m);

        assertEquals("TestHier Mean", m.getName());
        assertEquals("NormMeas", m.getDetermines().getFullName());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
        assertEquals("TestHier Mean", m.getDescription());
        assertEquals("TestHier Mean", m.getTitle());
    }
}
