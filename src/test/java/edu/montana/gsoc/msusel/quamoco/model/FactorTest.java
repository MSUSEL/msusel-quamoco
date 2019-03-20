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

import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.factor.ProductFactor;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class FactorTest {

    Factor element;

    @Before
    public void setup() {
        element = (Factor) ProductFactor.builder().name("factor").identifier("ID")
                .characterizes(mock(Entity.class))
                .refines(mock(Factor.class))
                .title("title")
                .description("description")
                .create();
    }

    @Test
    public void getCharacterizes() throws Exception {
        assertNotNull(element.getCharacterizes());
    }

    @Test
    public void setCharacterizes() throws Exception {
        element.setCharacterizes(null);
        assertNull(element.getCharacterizes());
        element.setCharacterizes(mock(Entity.class));
        assertNotNull(element.getCharacterizes());
    }

    @Test
    public void addInfluence() throws Exception {
        assertNotNull(element.getInfluences());
        assertTrue(element.getInfluences().isEmpty());
        element.addInfluence(mock(Impact.class));
        assertFalse(element.getInfluences().isEmpty());
    }

    @Test
    public void removeInfluence() throws Exception {
        Impact inf = mock(Impact.class);
        element.addInfluence(inf);
        assertFalse(element.getInfluences().isEmpty());
        element.removeInfluence(inf);
        assertTrue(element.getInfluences().isEmpty());
    }

    @Test
    public void setRefines() throws Exception {
        assertNotNull(element.getRefines());
    }

    @Test
    public void getRefines() throws Exception {
        element.setRefines(null);
        assertNull(element.getRefines());
        element.setRefines(mock(Factor.class));
        assertNotNull(element.getRefines());
    }

    @Test
    public void getInfluences() throws Exception {
        Impact inf = mock(Impact.class);
        element.addInfluence(inf);
        assertTrue(element.getInfluences().values().contains(inf));
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
    public void getName() throws Exception {
        assertEquals("factor", element.getName());
    }

    @Test
    public void setName() throws Exception {
        element.setName("NewName");
        assertEquals("NewName", element.getName());
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

    @Test
    public void generateXMLTag() throws Exception {
        System.out.println(element.xmlTag());
    }

    @Test
    public void hasAggregationAnnotation() throws Exception {
        fail();
    }

    @Test
    public void getAggregationAnnotationValue() throws Exception {
        fail();
    }

}