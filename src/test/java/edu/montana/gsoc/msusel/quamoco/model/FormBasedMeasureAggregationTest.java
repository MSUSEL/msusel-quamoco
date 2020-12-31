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

import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.aggregation.FindingsIntersectionMeasureAggregation;
import edu.montana.gsoc.msusel.quamoco.model.measurement.aggregation.FormBasedMeasureAggregation;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class FormBasedMeasureAggregationTest {

    FormBasedMeasureAggregation element;

    @Mock
    Annotation ann;
    @Mock
    Tag tag;
    @Mock
    Source src;
    @Mock
    Measure meas;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        element = (FormBasedMeasureAggregation) FindingsIntersectionMeasureAggregation.builder()
                .identifier("ID")
                .aggregate(meas)
                .description("description")
                .title("title")
                .determines(meas)
                .annotation(ann)
                .originatesFrom(src)
                .tag(tag)
                .create();
    }

    @Test
    public void addAggregate() {
        Measure meas2 = mock(Measure.class);
        element.addAggregate(meas);
        assertEquals(1, element.getAggregates().size());
        element.addAggregate(meas2);
        assertEquals(2, element.getAggregates().size());
    }

    @Test
    public void removeAggregate() {
        element.removeAggregate(meas);
        assertTrue(element.getAggregates().isEmpty());
    }

    @Test
    public void getAggregates() {
        assertNotNull(element.getAggregates());
        assertEquals(1, element.getAggregates().size());
    }

}