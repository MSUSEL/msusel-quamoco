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
package edu.montana.gsoc.msusel.quamoco.io;

import edu.montana.gsoc.msusel.quamoco.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

/**
 * The class <code>QMReaderTest</code> contains tests for the class
 * <code>{@link QMXMLReader}</code>.
 *
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class QMXMLReaderTest {

    /**
     * Run the QMReader() constructor test.
     */
    @Test
    public void testQMXMLReader_1() throws Exception
    {
        final QMXMLReader result = new QMXMLReader();

        // TODO: add additional test code here
        assertNotNull(result);
    }

    /**
     * Run the QualityModel getModel() method test.
     */
    @Test
    public void testGetModel_1() throws Exception
    {
        final QMXMLReader fixture = new QMXMLReader();
        QualityModel result = fixture.getModel();
        assertNull(result);

        fixture.read("testdata/test.qm");
        result = fixture.getModel();
        assertNotNull(result);
    }

    /**
     * Run the void read(String) method test.
     */
    @Test
    public void testRead_1() throws Exception
    {
        final QMXMLReader fixture = new QMXMLReader();

        fixture.read("testdata/test.qm");

        final QualityModel result = fixture.getModel();

        assertNotNull(result);
        assertEquals("Test", result.getName());
        assertEquals(
                "This module contains the part of the base quality model that is specific for the programming language Java.    ",
                result.getDescription());
        assertEquals("_nTsl8AczEd-2cMROGu2IWg", result.getIdentifier());
//        assertEquals("root.qm#_R7EQ4U8cEeCyVsuO56b1rA", result.getTaggedBy().get(0).getQualifiedIdentifier());
        assertEquals(1, result.getFactors().size());
//        assertEquals(1, result.getEvaluations().size()); // 1
//        assertEquals(3, result.getMeasures().size()); // 3
//        assertEquals(3, result.getMeasurementMethods().size()); // 3
//        assertEquals(1, result.getRequires().size()); // 1
        assertEquals(1, result.getTools().size()); // 1
        assertEquals(1, result.getTags().size()); // 1
        assertEquals(1, result.getSources().size()); // 1
//        assertEquals("object.qm#_vVIPYKUsEd-NpKpUUyVKCQ", result.getRequires().get(0).getQualifiedIdentifier());

        final Factor fac = result.getFactors().get(0);
        assertEquals("test.qm#_9Ir9hYXWEeCT8pJoQsn4HQ", fac.getQualifiedIdentifier());
        assertEquals(
                "An source code identifier is conform to naming convention regarding capitalization if no coding conventions rule of the respective programming language, which restricts capitalization, is violated. Domain, technology, library and project coding conventions are excluded.",
                fac.getDescription());
        assertEquals("Conformity to Naming Convention regarding Capitalization", fac.getName());
        assertEquals(null, fac.getTitle());
        assertEquals("root.qm#_ztWGsIeSEeCvOcxPw9PG9g", fac.getRefines().getQualifiedIdentifier());
        assertEquals("root.qm#_n3OgULtaEd-4Dvfk12g7Xw", fac.getCharacterizes().getQualifiedIdentifier());
        assertEquals(1, fac.getInfluences().size());
        assertTrue(fac.getAnnotations().isEmpty());

        final Impact inf = fac.getInfluences().get(0);
        assertEquals("test.qm#_96AFtIXWEeCT8pJoQsn4HQ", inf.getIdentifier());
        assertEquals(
                "Analyzability is positively influenced because people reading the source code are used to patterns of the coding convention.",
                inf.getJustification());
        assertEquals("POSITIVE", inf.getEffect().toString());
        assertEquals("root.qm#_hCU1x-P0Ed6mXujsf-O9qQ", inf.getTarget().getQualifiedIdentifier());

        final Evaluation eval = result.getEvaluations().get(0);
        assertEquals("test.qm#_2j4dEJGlEeC4ia6L3LOvxA", eval.getQualifiedIdentifier());
        assertEquals(
                "a measure that validates that everything that should have been cloned is actually cloned is missing",
                eval.getDescription());
        assertEquals(50, eval.getCompleteness(), 0.001);
        assertEquals("object.qm#_9UAcsoXWEeCT8pJoQsn4HQ", eval.getEvaluates().getQualifiedIdentifier());

        final Ranking rank1;
        if (eval instanceof WeightedSumFactorAggregation) {
            assertEquals(2, ((WeightedSumFactorAggregation) eval).getRankings().size());
            rank1 = ((WeightedSumFactorAggregation) eval).getRankings().get(0);
        } else if (eval instanceof WeightedSumMultiMeasureEvaluation) {
            assertEquals(2, ((WeightedSumMultiMeasureEvaluation) eval).getRankings().size());
            rank1 = ((WeightedSumMultiMeasureEvaluation) eval).getRankings().get(0);
        } else rank1 = null;

        if (rank1 != null && rank1 instanceof MeasureRanking) {
            MeasureRanking mrank1 = (MeasureRanking) rank1;
            assertEquals("test.qm#_eRtawJv6EeCW5eP_GFwpfw", mrank1.getQualifiedIdentifier());
            assertEquals("test.qm#_paC_EhdREeCWcbKUk5fWYg", mrank1.getMeasure().getQualifiedIdentifier());
            assertEquals("CLASS", mrank1.getRange().toString());
            assertEquals(1, rank1.getRank());
            assertEquals(0.75, rank1.getWeight(), 0.001);
            assertEquals("root.qm#_6wmhsOHIEd-_QLJMFBuPpg", mrank1.getNormalization().getQualifiedIdentifier());
            assertNotNull(mrank1.getFunction());

            final Function fn1 = mrank1.getFunction();
            assertEquals("test.qm#_eRtawZv6EeCW5eP_GFwpfw", fn1.getQualifiedIdentifier());
            if (fn1 instanceof LinearFunction)
                assertEquals(0.0, ((LinearFunction) fn1).getLowerBound(), 0.001);
        }
        
        final Ranking rank2;
        if (eval instanceof WeightedSumFactorAggregation) {
            assertEquals(2, ((WeightedSumFactorAggregation) eval).getRankings().size());
            rank2 = ((WeightedSumFactorAggregation) eval).getRankings().get(1);
        } else if (eval instanceof WeightedSumMultiMeasureEvaluation) {
            assertEquals(2, ((WeightedSumMultiMeasureEvaluation) eval).getRankings().size());
            rank2 = ((WeightedSumMultiMeasureEvaluation) eval).getRankings().get(1);
        } else rank2 = null;

        if (rank2 != null && rank2 instanceof FactorRanking) {
            FactorRanking frank2 = (FactorRanking) rank2;
            assertEquals("test.qm#_eRtawpv6EeCW5eP_GFwpfw", frank2.getQualifiedIdentifier());
            assertEquals("test.qm#_pZ9fsRdREeCWcbKUk5fWYg", frank2.getFactor().getQualifiedIdentifier());
            assertEquals(2, frank2.getRank());
            assertEquals(0.25, frank2.getWeight(), 0.001);
        }
        
        final Measure meas1 = result.getMeasures().get(0);
        assertEquals("test.qm#_paBxQxdREeCWcbKUk5fWYg", meas1.getQualifiedIdentifier());
        assertEquals(
                "\"This class defines a covariant version of the equals() method, but inherits the normal equals(Object) method defined in the base java.lang.Object class.\r\n"
                        + "The class should probably define a boolean equals(Object) method.\" [1]",
                meas1.getDescription());
        assertEquals("Covariant equals() method defined, Object.equals(Object) inherited", meas1.getName());
        assertEquals(MeasureType.FINDINGS, meas1.getType());
        assertEquals("root.qm#_uliZAQQNEeGSsdo78OGnBA", meas1.getOriginatesFrom().getQualifiedIdentifier());
        assertTrue(meas1.getMeasures().isEmpty());
        assertNull(meas1.getCharacterizes());
        assertNull(meas1.getRefines());
        assertNull(meas1.getTaggedBy());
        assertNull(meas1.getTitle());

        final Measure meas2 = result.getMeasures().get(1);
        assertEquals("test.qm#_s1W3wPDPEd-dO4k3YfzrzA", meas2.getQualifiedIdentifier());
        assertEquals(
                "\"This rule warns if a non-constant public static field is found. In a multi-threaded environment access to those fields must be synchronized. \" [1]",
                meas2.getDescription());
        assertEquals("Non constant and static", meas2.getName());
        assertEquals(MeasureType.FINDINGS, meas2.getType());
        assertTrue(meas2.getMeasures().isEmpty());
        assertTrue(meas2.getAnnotations().isEmpty());
        assertNull(meas2.getCharacterizes());
        assertNull(meas2.getRefines());
        assertNull(meas2.getTaggedBy());
        assertNull(meas2.getTitle());

        final Measure meas3 = result.getMeasures().get(2);
        assertEquals(MeasureType.NONE, meas3.getType());
        assertEquals("test.qm#_y3MI4MTqEeCkhKnv06OAoA", meas3.getQualifiedIdentifier());
        assertEquals("The number of classes, interfaces, and enums.", meas3.getDescription());
        assertEquals("#Types", meas3.getName());

        final MeasurementMethod mm1 = result.getMeasurementMethods().get(0);
        if (mm1 instanceof ToolBasedInstrument) {
            assertEquals("test.qm#_9LpQ43MWEd-Ywpz7Oo8Ghw", mm1.getQualifiedIdentifier());
            assertEquals("test.qm#_qwch0JuUEd6lZqfHOw9WKg", mm1.getDetermines().getQualifiedIdentifier());
            assertEquals("test.qm#_D6iLF6UeEd-NpKpUUyVKCQ", ((ToolBasedInstrument) mm1).getTool().getQualifiedIdentifier());
            assertEquals("Insufficient Comment", mm1.getName());
            assertFalse(mm1.getAnnotations().isEmpty());
        }

        final List<Annotation> mm1a = new ArrayList<>(mm1.getAnnotations());
        assertEquals(1, mm1a.size());
        assertEquals("test.qm#_oQk9IKucEeCjgf2sYoj_Lg", mm1a.get(0).getIdentifier());
        assertEquals("Block-Id", mm1a.get(0).getKey());
        assertEquals("edu.tum.cs.conqat.quamoco.model.QJavaDoc", mm1a.get(0).getValue());

        final MeasurementMethod mm2 = result.getMeasurementMethods().get(1);
        if (mm2 instanceof ToolBasedInstrument) {
            assertEquals("test.qm#_pZ9fmBdREeCWcbKUk5fWYg", mm2.getQualifiedIdentifier());
            assertEquals("test.qm#_lpVKU1qYEeC1KZOCQoCvzA", mm2.getDetermines().getQualifiedIdentifier());
            assertEquals("test.qm#_D6lOQKUeEd-NpKpUUyVKCQ", ((ToolBasedInstrument) mm2).getTool().getQualifiedIdentifier());
            assertEquals("UWF_UNWRITTEN_FIELD", mm2.getName());
            assertEquals("root.qm#_uliZAQQNEeGSsdo78OGnBA", mm2.getOriginatesFrom().getQualifiedIdentifier());
        }

        final MeasurementMethod mm3 = result.getMeasurementMethods().get(2);
        if (mm3 instanceof ToolBasedInstrument) {
            assertEquals("test.qm#_6hvW0ab7EeCXmfDlLBltgw", mm3.getQualifiedIdentifier());
            assertEquals("test.qm#_iCg1kB5IEeCp6rP-KrdnJA", ((ToolBasedInstrument) mm3).getTool().getQualifiedIdentifier());
            assertEquals("#Statements", mm3.getName());
            assertEquals("object.qm#_nTzIGVqYEeC1KZOCQoCvzA", mm3.getDetermines().getQualifiedIdentifier());
        }

        final Tool tool = result.getTools().get(0);
        assertEquals("test.qm#_D6iLF6UeEd-NpKpUUyVKCQ", tool.getQualifiedIdentifier());
        assertEquals("The tool JavaDoc Analysis.", tool.getDescription());
        assertEquals("JavaDoc Analysis", tool.getName());
        assertFalse(tool.getAnnotations().isEmpty());

        final List<Annotation> ann1 = new ArrayList<>(tool.getAnnotations());
        assertEquals(1, ann1.size());
        assertEquals("test.qm#_oQVFhaucEeCjgf2sYoj_Lg", ann1.get(0).getIdentifier());
        assertEquals("Block-Id", ann1.get(0).getKey());
        assertEquals("edu.tum.cs.conqat.quamoco.model.QJavaDoc", ann1.get(0).getValue());

        final Tag tag = result.getTags().get(0);
        assertEquals("test.qm#_WAAF8E8cEeCyVsuO56b1rA", tag.getQualifiedIdentifier());
        assertEquals("component", tag.getDescription());
        assertEquals("component", tag.getName());

        final Source src = result.getSources().get(0);
        assertEquals("test.qm#_IcgR4KPMEd-Pv7j9Ez0GHQ", src.getQualifiedIdentifier());
        assertEquals(
                "ISO/IEC FCD 25010: Systems and software engineering - System and software product Quality Requirements and Evaluation (SQuaRE) - System and software quality models. http://www.iso.org/iso/catalogue_detail.htm?csnumber=35733. Accessed on 01.11.2011.",
                src.getDescription());
        assertEquals("ISO 25010 v1.81", src.getName());
        assertFalse(src.getAnnotations().isEmpty());

        final List<Annotation> ann2 = new ArrayList<>(src.getAnnotations());
        assertEquals(1, ann2.size());
        assertEquals("test.qm#_z38MgARqEeGUKsTjqjurSA", ann2.get(0).getIdentifier());
        assertEquals("url", ann2.get(0).getKey());
        assertEquals("http://www.iso.org/iso/catalogue_detail.htm?csnumber=35733", ann2.get(0).getValue());
    }

    /**
     * Run the void read(String) method test.
     */
    @Test
    public void testRead_2() throws Exception
    {
        final QMXMLReader fixture = new QMXMLReader();

        fixture.read("");

        final QualityModel result = fixture.getModel();

        assertNotNull(result);
        assertEquals("model", result.getName());
    }

    /**
     * Run the void read(String) method test.
     */
    @Test
    public void testRead_3() throws Exception
    {
        final QMXMLReader fixture = new QMXMLReader();

        fixture.read(null);

        final QualityModel result = fixture.getModel();

        assertNotNull(result);
        assertEquals("model", result.getName());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     */
    @Before
    public void setUp() throws Exception
    {
        // TODO: add additional set up code here
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     */
    @After
    public void tearDown() throws Exception
    {
        // TODO: add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(QMXMLReaderTest.class);
    }
}