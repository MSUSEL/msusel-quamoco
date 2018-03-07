package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.MeasureType;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measure.NormalizationMeasure;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class MeasuresTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testProductMean() {
        Measure m = manager.findMeasureByName("Mean @Product");
        assertNotNull(m);

        assertEquals("Mean", m.getTitle());
        assertEquals("Mean", m.getDescription());
        assertEquals("Product", m.getCharacterizes().getName());
        assertEquals(MeasureType.NUMBER, m.getType());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testProductPartParent() {
        Measure m = manager.findMeasureByName("Parent @Product Part");
        assertNotNull(m);

        assertEquals("Parent Measure", m.getTitle());
        assertEquals("Parent measure", m.getDescription());
        assertEquals("Product Part", m.getCharacterizes().getName());
        assertEquals(MeasureType.FINDINGS, m.getType());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testSourcCodePartTestMeasure() {
        Measure m = manager.findMeasureByName("Test Measure @Source Code Part");
        assertNotNull(m);

        assertEquals("Test measure", m.getTitle());
        assertEquals("Test Measure", m.getDescription());
        assertEquals("Source Code Part", m.getCharacterizes().getName());
        assertEquals(MeasureType.FINDINGS, m.getType());
        assertNotNull(m.getRefines());
        assertEquals("Parent @Product Part", m.getRefines().getFullName());
        assertEquals(2, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testSourceCodePartTestNormalization() {
        Measure m = manager.findMeasureByName("Test Normalization @Source Code Part");
        assertNotNull(m);

        assertEquals("Test Normalization", m.getTitle());
        assertEquals("Test Normalization", m.getDescription());
        assertTrue(m instanceof NormalizationMeasure);
        assertTrue(m.isNormalizer());
        assertEquals("Source Code Part", m.getCharacterizes().getName());
        assertEquals(MeasureType.NUMBER, m.getType());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("Test Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("Test Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testManualMeas() {
        Measure m = manager.findMeasureByName("ManualMeas");
        assertNotNull(m);

        assertEquals("Manual Measure", m.getTitle());
        assertEquals("Manual Measure", m.getDescription());
        assertEquals(MeasureType.NUMBER, m.getType());
        assertFalse(m instanceof NormalizationMeasure);
        assertFalse(m.isNormalizer());
        assertEquals(1, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertFalse(m.hasTags());
    }

    @Test
    public void testMeasure1() {
        Measure m = manager.findMeasureByName("Measure1");
        assertNotNull(m);

        assertEquals("Measure1", m.getTitle());
        assertEquals("Measure1", m.getDescription());
        assertEquals(MeasureType.FINDINGS, m.getType());
        assertFalse(m instanceof NormalizationMeasure);
        assertFalse(m.isNormalizer());
        assertEquals(1, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testMeasure2() {
        Measure m = manager.findMeasureByName("Measure2");
        assertNotNull(m);

        assertEquals("Measure2", m.getTitle());
        assertEquals("Measure2", m.getDescription());
        assertEquals(MeasureType.FINDINGS, m.getType());
        assertFalse(m instanceof NormalizationMeasure);
        assertFalse(m.isNormalizer());
        assertEquals(1, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testMeasure3() {
        Measure m = manager.findMeasureByName("Measure3");
        assertNotNull(m);

        assertEquals("TestHier Measure 3", m.getTitle());
        assertEquals("TestHier Measure 3", m.getDescription());
        assertEquals(MeasureType.FINDINGS, m.getType());
        assertFalse(m instanceof NormalizationMeasure);
        assertFalse(m.isNormalizer());
        assertEquals(1, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testNormMeas() {
        Measure m = manager.findMeasureByName("NormMeas");
        assertNotNull(m);

        assertEquals("Test Hier NormMeas", m.getTitle());
        assertEquals("Test Hier NormMeas", m.getDescription());
        assertEquals(MeasureType.NUMBER, m.getType());
        assertTrue(m instanceof NormalizationMeasure);
        assertTrue(m.isNormalizer());
        assertEquals(0, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testQIESLMeas() {
        Measure m = manager.findMeasureByName("QIESLMeas");
        assertNotNull(m);

        assertEquals("QIESL Measure", m.getTitle());
        assertEquals("QIESL Measure", m.getDescription());
        assertEquals(MeasureType.NUMBER, m.getType());
        assertEquals(1, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testTextMeas() {
        Measure m = manager.findMeasureByName("TextMeas");
        assertNotNull(m);

        assertEquals("Text Measure", m.getTitle());
        assertEquals("Text Measure", m.getDescription());
        assertEquals(MeasureType.FINDINGS, m.getType());
        assertEquals(1, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testToolMeas() {
        Measure m = manager.findMeasureByName("ToolMeas");
        assertNotNull(m);

        assertEquals("Tool Measure", m.getTitle());
        assertEquals("Tool Measure", m.getDescription());
        assertEquals(MeasureType.FINDINGS, m.getType());
        assertEquals(1, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }

    @Test
    public void testUnionMeas() {
        Measure m = manager.findMeasureByName("UnionMeas");
        assertNotNull(m);

        assertEquals("UnionMeas", m.getTitle());
        assertEquals("UnionMeas", m.getDescription());
        assertEquals(MeasureType.FINDINGS, m.getType());
        assertEquals(1, m.getMeasures().size());
        assertNotNull(m.getOriginatesFrom());
        assertEquals("TestHier Source", m.getOriginatesFrom().getName());
        assertTrue(m.hasTags());
        assertEquals("TestHier Tag", m.getTaggedBy().get(0).getName());
    }
}
