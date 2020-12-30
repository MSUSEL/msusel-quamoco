/**
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
package edu.montana.gsoc.msusel.quamoco.model;

import edu.montana.gsoc.msusel.quamoco.model.factor.ProductFactor;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.aggregation.FindingsIntersectionMeasureAggregation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class QMElementTest {

    QMElement element;

    @Before
    public void setUp() throws Exception {
        element = FindingsIntersectionMeasureAggregation.builder()
                .identifier("ID")
                .aggregate(mock(Measure.class))
                .description("description")
                .title("title")
                .determines(mock(Measure.class))
                .annotation(mock(Annotation.class))
                .originatesFrom(mock(Source.class))
                .tag(mock(Tag.class))
                .create();
    }

    @Test
    public void getOriginatesFrom() {
        assertNotNull(element.getOriginatesFrom());
    }

    @Test
    public void setOriginatesFrom() {
        Source src2 = mock(Source.class);
        element.setOriginatesFrom(null);
        assertNull(element.getOriginatesFrom());
        element.setOriginatesFrom(src2);
        assertEquals(src2, element.getOriginatesFrom());
    }

    @Test
    public void getTaggedBy() {
        assertNotNull(element.getTaggedBy());
        assertEquals(1, element.getTaggedBy().size());
    }

    @Test
    public void addTaggedBy() {
        Tag tag2 = mock(Tag.class);
        element.addTaggedBy(tag2);
        assertEquals(2, element.getTaggedBy().size());
    }

    @Test
    public void removeTaggedBy() {
        Tag tag = element.getTaggedBy().get(0);
        element.removeTaggedBy(tag);
        assertTrue(element.getTaggedBy().isEmpty());
    }

    @Test
    public void addAnnotation() {
        Annotation ann2 = mock(Annotation.class);
        element.addAnnotation(ann2);
        assertEquals(2, element.getAnnotations().size());
    }

    @Test
    public void hasAnnotations() {
        assertTrue(element.hasAnnotations());
    }

    @Test
    public void getAnnotations() {
        assertNotNull(element.getAnnotations());
        assertEquals(1, element.getAnnotations().size());
    }

    @Test
    public void getIdentifier() {
        assertEquals("ID", element.getIdentifier());
    }

    @Test
    public void getQualifiedIdentifier() {
        assertNull(element.getQualifiedIdentifier());
        QualityModel qm = mock(QualityModel.class);
        when(qm.getFileName()).thenReturn("file");
        element.updateQualifiedIdentifier(qm);
        assertEquals("file#ID", element.getQualifiedIdentifier());
    }

    @Test
    public void toJson() {
        element = ProductFactor.builder().name("Test").identifier("ID")
                .description("description")
                .create();

        String value = "{\n" +
                "  \"identifier\" : \"ID\",\n" +
                "  \"originatesFrom\" : null,\n" +
                "  \"taggedBy\" : [ ],\n" +
                "  \"annotations\" : [ ],\n" +
                "  \"qualifiedIdentifier\" : null,\n" +
                "  \"name\" : \"Test\",\n" +
                "  \"description\" : \"description\",\n" +
                "  \"characterizes\" : null,\n" +
                "  \"title\" : null,\n" +
                "  \"influences\" : { },\n" +
                "  \"refines\" : null,\n" +
                "  \"fullName\" : \"Test\",\n" +
                "  \"aggregationAnnotationValue\" : \"\"\n" +
                "}";

        assertEquals(value, element.toJson());
    }

    @Test
    public void toYaml() {
        element = ProductFactor.builder().name("Test").identifier("ID")
                .description("description")
                .create();

        String value = "---\n" +
                "identifier: \"ID\"\n" +
                "originatesFrom: null\n" +
                "taggedBy: []\n" +
                "annotations: []\n" +
                "qualifiedIdentifier: null\n" +
                "name: \"Test\"\n" +
                "description: \"description\"\n" +
                "characterizes: null\n" +
                "title: null\n" +
                "influences: {}\n" +
                "refines: null\n" +
                "fullName: \"Test\"\n" +
                "aggregationAnnotationValue: \"\"\n";

        assertEquals(value, element.toYaml());
    }
}