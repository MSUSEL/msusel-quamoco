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

import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.eval.measure.SingleMeasureEvaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class EvaluationTest {

    Evaluation element;

    @Before
    public void setUp() throws Exception {
        element = SingleMeasureEvaluation.builder()
                .identifier("ID")
                .completeness(100d)
                .description("description")
                .evaluates(mock(Factor.class))
                .maximumPoints(100d)
                .title("title")
                .create();
    }

    @Test
    public void getCompleteness() throws Exception {
        assertEquals(100, element.getCompleteness(), 0.001);
    }

    @Test
    public void setCompleteness() throws Exception {
        element.setCompleteness(0.0);
        assertEquals(0.0, element.getCompleteness(), 0.001);
    }

    @Test
    public void getMaximumPoints() throws Exception {
        assertEquals(100, element.getMaximumPoints(), 0.001);
    }

    @Test
    public void setMaximumPoints() throws Exception {
        element.setMaximumPoints(0.0);
        assertEquals(0.0, element.getMaximumPoints(), 0.001);
    }

    @Test
    public void getEvaluates() throws Exception {
        assertNotNull(element.getEvaluates());
    }

    @Test
    public void setEvaluates() throws Exception {
        element.setEvaluates(null);
        assertNotNull(element.getEvaluates());
        Factor fac = mock(Factor.class);
        element.setEvaluates(fac);
        assertEquals(fac, element.getEvaluates());
    }

    @Test
    public void evaluate() throws Exception {
        fail();
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals("description", element.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        element.setDescription("newDescription");
        assertEquals("newDescription", element.getDescription());
    }

    @Test
    public void getTitle() throws Exception {
        assertEquals("title", element.getTitle());
    }

    @Test
    public void setTitle() throws Exception {
        element.setTitle("new_title");
        assertEquals("new_title", element.getTitle());
    }

}