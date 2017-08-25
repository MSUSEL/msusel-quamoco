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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.io.QMReader;
import edu.montana.gsoc.msusel.quamoco.model.qm.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Factor;
import edu.montana.gsoc.msusel.quamoco.model.qm.Function;
import edu.montana.gsoc.msusel.quamoco.model.qm.Influence;
import edu.montana.gsoc.msusel.quamoco.model.qm.Measure;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.qm.Parent;
import edu.montana.gsoc.msusel.quamoco.model.qm.QualityModel;
import edu.montana.gsoc.msusel.quamoco.model.qm.Ranking;
import edu.montana.gsoc.msusel.quamoco.model.qm.Source;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tag;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tool;

/**
 * The class <code>QMReaderTest</code> contains tests for the class
 * <code>{@link QMReader}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:42 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class QMReaderTest {

    /**
     * Run the QMReader() constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testQMReader_1() throws Exception
    {
        final QMReader result = new QMReader();

        // TODO: add additional test code here
        Assert.assertNotNull(result);
    }

    /**
     * Run the QualityModel getModel() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testGetModel_1() throws Exception
    {
        final QMReader fixture = new QMReader();

        final QualityModel result = fixture.getModel();

        Assert.assertNotNull(result);
    }

    /**
     * Run the void read(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testRead_1() throws Exception
    {
        final QMReader fixture = new QMReader();

        fixture.read("testdata/test.qm");

        final QualityModel result = fixture.getModel();

        Assert.assertNotNull(result);
        Assert.assertEquals("test", result.getName());
        Assert.assertEquals(
                "This module contains the part of the base quality model that is specific for the programming language Java.    ",
                result.getDescription());
        Assert.assertEquals("_nTsl8AczEd-2cMROGu2IWg", result.getId());
        Assert.assertEquals("root.qm#_R7EQ4U8cEeCyVsuO56b1rA", result.getTaggedBy().getHREF());
        Assert.assertEquals(1, result.getFactors().size());
        Assert.assertEquals(1, result.getEvaluations().size());
        Assert.assertEquals(3, result.getMeasures().size());
        Assert.assertEquals(3, result.getMethods().size());
        Assert.assertEquals(1, result.getRequires().size());
        Assert.assertEquals(1, result.getTools().size());
        Assert.assertEquals(1, result.getTags().size());
        Assert.assertEquals(1, result.getSources().size());
        Assert.assertEquals("object.qm#_vVIPYKUsEd-NpKpUUyVKCQ", result.getRequires().get(0).getHREF());

        final Factor fac = result.getFactors().get(0);
        Assert.assertEquals("test.qm#_9Ir9hYXWEeCT8pJoQsn4HQ", fac.getId());
        Assert.assertEquals(
                "An source code identifier is conform to naming convention regarding capitalization if no coding conventions rule of the respective programming language, which restricts capitalization, is violated. Domain, technology, library and project coding conventions are excluded.",
                fac.getDescription());
        Assert.assertEquals("Conformity to Naming Convention regarding Capitalization", fac.getName());
        Assert.assertEquals(null, fac.getTitle());
        Assert.assertEquals("root.qm#_ztWGsIeSEeCvOcxPw9PG9g", fac.getRefines().getHREF());
        Assert.assertEquals("root.qm#_n3OgULtaEd-4Dvfk12g7Xw", fac.getCharacterizes().getHREF());
        Assert.assertEquals(1, fac.getInfluences().size());
        Assert.assertTrue(fac.getAnnotations().isEmpty());

        final Influence inf = fac.getInfluences().get(0);
        Assert.assertEquals("test.qm#_96AFtIXWEeCT8pJoQsn4HQ", inf.getId());
        Assert.assertEquals(
                "Analyzability is positively influenced because people reading the source code are used to patterns of the coding convention.",
                inf.getJustification());
        Assert.assertEquals("POSITIVE", inf.getEffect().toString());
        Assert.assertEquals("root.qm#_hCU1x-P0Ed6mXujsf-O9qQ", inf.getTarget().getHREF());

        final Evaluation eval = result.getEvaluations().get(0);
        Assert.assertEquals("test.qm#_2j4dEJGlEeC4ia6L3LOvxA", eval.getId());
        Assert.assertEquals(
                "a measure that validates that everything that should have been cloned is actually cloned is missing",
                eval.getDescription());
        Assert.assertEquals("WeightedSumMultiMeasureEvaluation", eval.getName());
        Assert.assertEquals("50", eval.getCompleteness());
        Assert.assertEquals("object.qm#_9UAcsoXWEeCT8pJoQsn4HQ", eval.getEvaluates().getHREF());
        Assert.assertEquals(2, eval.getRankings().size());

        final Ranking rank1 = eval.getRankings().get(0);
        Assert.assertEquals("test.qm#_eRtawJv6EeCW5eP_GFwpfw", rank1.getId());
        Assert.assertEquals("test.qm#_paC_EhdREeCWcbKUk5fWYg", rank1.getMeasure().getHREF());
        Assert.assertEquals(null, rank1.getFactor());
        Assert.assertEquals("CLASS", rank1.getRange().toString());
        Assert.assertEquals("1", rank1.getRank());
        Assert.assertEquals("0.75", rank1.getWeight());
        Assert.assertEquals("root.qm#_6wmhsOHIEd-_QLJMFBuPpg", rank1.getNormalizationMeasure().getHREF());
        Assert.assertNotNull(rank1.getFunction());

        final Function fn1 = rank1.getFunction();
        Assert.assertEquals("test.qm#_eRtawZv6EeCW5eP_GFwpfw", fn1.getId());
        Assert.assertEquals("qm:LinearDecreasingFunction", fn1.getType());
        Assert.assertEquals(BigDecimal.ZERO, fn1.getLowerBound());
        
        final Ranking rank2 = eval.getRankings().get(1);
        Assert.assertEquals("test.qm#_eRtawpv6EeCW5eP_GFwpfw", rank2.getId());
        Assert.assertEquals(null, rank2.getMeasure());
        Assert.assertEquals("test.qm#_pZ9fsRdREeCWcbKUk5fWYg", rank2.getFactor().getHREF());
        Assert.assertEquals("CLASS", rank2.getRange().toString());
        Assert.assertEquals("2", rank2.getRank());
        Assert.assertEquals("0.25", rank2.getWeight());
        Assert.assertEquals("root.qm#_6wmhsOHIEd-_QLJMFBuPpg", rank2.getNormalizationMeasure().getHREF());
        Assert.assertNotNull(rank2.getFunction());

        final Function fn2 = rank2.getFunction();
        Assert.assertEquals("test.qm#_eRtaw5v6EeCW5eP_GFwpfw", fn2.getId());
        Assert.assertEquals("qm:LinearDecreasingFunction", fn2.getType());
        Assert.assertEquals(BigDecimal.ZERO, fn2.getLowerBound());
        
        final Measure meas1 = result.getMeasures().get(0);
        Assert.assertEquals("test.qm#_paBxQxdREeCWcbKUk5fWYg", meas1.getId());
        Assert.assertEquals(
                "\"This class defines a covariant version of the equals() method, but inherits the normal equals(Object) method defined in the base java.lang.Object class.\r\n"
                        + "The class should probably define a boolean equals(Object) method.\" [1]",
                meas1.getDescription());
        Assert.assertEquals("Covariant equals() method defined, Object.equals(Object) inherited", meas1.getName());
        Assert.assertEquals("FINDINGS", meas1.getType());
        Assert.assertEquals("root.qm#_uliZAQQNEeGSsdo78OGnBA", meas1.getOriginatesFrom().getHREF());
        Assert.assertTrue(meas1.getParents().contains(new Parent("object.qm#_9U50kIXWEeCT8pJoQsn4HQ")));
        Assert.assertTrue(meas1.getParents().contains(new Parent("object.qm#_9Y7Y8IXWEeCT8pJoQsn4HQ")));
        Assert.assertTrue(meas1.getMeasures().isEmpty());
        Assert.assertNull(meas1.getCharacterizes());
        Assert.assertNull(meas1.getRefines());
        Assert.assertNull(meas1.getTaggedBy());
        Assert.assertNull(meas1.getTitle());

        final Measure meas2 = result.getMeasures().get(1);
        Assert.assertEquals("test.qm#_s1W3wPDPEd-dO4k3YfzrzA", meas2.getId());
        Assert.assertEquals(
                "\"This rule warns if a non-constant public static field is found. In a multi-threaded environment access to those fields must be synchronized. \" [1]",
                meas2.getDescription());
        Assert.assertEquals("Non constant and static", meas2.getName());
        Assert.assertEquals("FINDINGS", meas2.getType());
        Assert.assertTrue(meas2.getParents().contains(new Parent("test.qm#_9j89MIXWEeCT8pJoQsn4HQ")));
        Assert.assertTrue(meas2.getMeasures().isEmpty());
        Assert.assertTrue(meas2.getAnnotations().isEmpty());
        Assert.assertNull(meas2.getCharacterizes());
        Assert.assertNull(meas2.getRefines());
        Assert.assertNull(meas2.getTaggedBy());
        Assert.assertNull(meas2.getTitle());

        final Measure meas3 = result.getMeasures().get(2);
        Assert.assertEquals("qm:NormalizationMeasure", meas3.getType());
        Assert.assertEquals("test.qm#_y3MI4MTqEeCkhKnv06OAoA", meas3.getId());
        Assert.assertEquals("The number of classes, interfaces, and enums.", meas3.getDescription());
        Assert.assertEquals("#Types", meas3.getName());

        final MeasurementMethod mm1 = result.getMethods().get(0);
        Assert.assertEquals("qm:ToolBasedInstrument", mm1.getType());
        Assert.assertEquals("test.qm#_9LpQ43MWEd-Ywpz7Oo8Ghw", mm1.getId());
        Assert.assertEquals("test.qm#_qwch0JuUEd6lZqfHOw9WKg", mm1.getDetermines().getHREF());
        Assert.assertEquals("test.qm#_D6iLF6UeEd-NpKpUUyVKCQ", mm1.getTool());
        Assert.assertEquals("Insufficient Comment", mm1.getMetric());
        Assert.assertFalse(mm1.getAnnotations().isEmpty());

        final List<Annotation> mm1a = new ArrayList<>(mm1.getAnnotations());
        Assert.assertEquals(1, mm1a.size());
        Assert.assertEquals("test.qm#_oQk9IKucEeCjgf2sYoj_Lg", mm1a.get(0).getId());
        Assert.assertEquals("Block-Id", mm1a.get(0).getKey());
        Assert.assertEquals("edu.tum.cs.conqat.quamoco.model.QJavaDoc", mm1a.get(0).getValue());

        final MeasurementMethod mm2 = result.getMethods().get(1);
        Assert.assertEquals("qm:ToolBasedInstrument", mm2.getType());
        Assert.assertEquals("test.qm#_pZ9fmBdREeCWcbKUk5fWYg", mm2.getId());
        Assert.assertEquals("test.qm#_lpVKU1qYEeC1KZOCQoCvzA", mm2.getDetermines().getHREF());
        Assert.assertEquals("test.qm#_D6lOQKUeEd-NpKpUUyVKCQ", mm2.getTool());
        Assert.assertEquals("UWF_UNWRITTEN_FIELD", mm2.getMetric());
        Assert.assertEquals("root.qm#_uliZAQQNEeGSsdo78OGnBA", mm2.getOriginatesFrom().getHREF());

        final MeasurementMethod mm3 = result.getMethods().get(2);
        Assert.assertEquals("qm:ToolBasedInstrument", mm3.getType());
        Assert.assertEquals("test.qm#_6hvW0ab7EeCXmfDlLBltgw", mm3.getId());
        Assert.assertEquals("test.qm#_iCg1kB5IEeCp6rP-KrdnJA", mm3.getTool());
        Assert.assertEquals("#Statements", mm3.getMetric());
        Assert.assertEquals("object.qm#_nTzIGVqYEeC1KZOCQoCvzA", mm3.getDetermines().getHREF());

        final Tool tool = result.getTools().get(0);
        Assert.assertEquals("test.qm#_D6iLF6UeEd-NpKpUUyVKCQ", tool.getId());
        Assert.assertEquals("The tool JavaDoc Analysis.", tool.getDescription());
        Assert.assertEquals("JavaDoc Analysis", tool.getName());
        Assert.assertFalse(tool.getAnnotations().isEmpty());

        final List<Annotation> ann1 = new ArrayList<>(tool.getAnnotations());
        Assert.assertEquals(1, ann1.size());
        Assert.assertEquals("test.qm#_oQVFhaucEeCjgf2sYoj_Lg", ann1.get(0).getId());
        Assert.assertEquals("Block-Id", ann1.get(0).getKey());
        Assert.assertEquals("edu.tum.cs.conqat.quamoco.model.QJavaDoc", ann1.get(0).getValue());

        final Tag tag = result.getTags().get(0);
        Assert.assertEquals("test.qm#_WAAF8E8cEeCyVsuO56b1rA", tag.getId());
        Assert.assertEquals("component", tag.getDescription());
        Assert.assertEquals("component", tag.getName());

        final Source src = result.getSources().get(0);
        Assert.assertEquals("test.qm#_IcgR4KPMEd-Pv7j9Ez0GHQ", src.getId());
        Assert.assertEquals(
                "ISO/IEC FCD 25010: Systems and software engineering - System and software product Quality Requirements and Evaluation (SQuaRE) - System and software quality models. http://www.iso.org/iso/catalogue_detail.htm?csnumber=35733. Accessed on 01.11.2011.",
                src.getDescription());
        Assert.assertEquals("ISO 25010 v1.81", src.getName());
        Assert.assertFalse(src.getAnnotations().isEmpty());

        final List<Annotation> ann2 = new ArrayList<>(src.getAnnotations());
        Assert.assertEquals(1, ann2.size());
        Assert.assertEquals("test.qm#_z38MgARqEeGUKsTjqjurSA", ann2.get(0).getId());
        Assert.assertEquals("url", ann2.get(0).getKey());
        Assert.assertEquals("http://www.iso.org/iso/catalogue_detail.htm?csnumber=35733", ann2.get(0).getValue());
    }

    /**
     * Run the void read(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testRead_2() throws Exception
    {
        final QMReader fixture = new QMReader();

        fixture.read("");

        final QualityModel result = fixture.getModel();

        Assert.assertNotNull(result);
        Assert.assertEquals("model", result.getName());
    }

    /**
     * Run the void read(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    @Test
    public void testRead_3() throws Exception
    {
        final QMReader fixture = new QMReader();

        fixture.read(null);

        final QualityModel result = fixture.getModel();

        Assert.assertNotNull(result);
        Assert.assertEquals("model", result.getName());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 5/30/15 3:42 PM
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
     * @generatedBy CodePro at 5/30/15 3:42 PM
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
     * @generatedBy CodePro at 5/30/15 3:42 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(QMReaderTest.class);
    }
}