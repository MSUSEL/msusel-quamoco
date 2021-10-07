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
package edu.montana.gsoc.msusel.quamoco.io;

import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import edu.montana.gsoc.msusel.quamoco.io.qm.QMXMLReader;
import edu.montana.gsoc.msusel.quamoco.model.*;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.factor.WeightedSumFactorAggregation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MeasureRanking;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.WeightedSumMultiMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.func.Function;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearFunction;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.FactorRanking;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.measurement.ToolBasedInstrument;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

/**
 * The class <code>QMReaderTest</code> contains tests for the class
 * <code>{@link QMXMLReader}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class QMXMLReaderTest {

    /**
     * Run the QMReader() constructor test.
     */
    @Test
    public void testQMXMLReader_1()
    {
        final QMXMLReader result = new QMXMLReader(new ModelManager());

        // TODO: add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the QualityModel getModel() method test.
     */
    @Test
    public void testGetModel_1()
    {
        final QMXMLReader fixture = new QMXMLReader(new ModelManager());
        QualityModel result = fixture.getModel();
        assertNull(result);

        fixture.read("data/test/Test.qm");
        result = fixture.getModel();
        assertNotNull(result);
    }

    /**
     * Run the void read(String) method test.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testRead_2()
    {
        final QMXMLReader fixture = new QMXMLReader(new ModelManager());

        fixture.read("");
    }

    /**
     * Run the void read(String) method test.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testRead_3()
    {
        final QMXMLReader fixture = new QMXMLReader(new ModelManager());

        fixture.read(null);
    }
}