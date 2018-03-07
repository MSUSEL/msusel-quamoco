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
package edu.montana.gsoc.msusel.quamoco.model;

import edu.montana.gsoc.msusel.quamoco.io.factories.EntityType;
import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import edu.montana.gsoc.msusel.quamoco.model.entity.ProductPart;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class EntityTest {

    Entity element;

    @Before
    public void setUp() throws Exception {
        element = ProductPart.builder().name("entity").identifier("ID")
                .description("description")
                .title("title")
                .isA(mock(Entity.class))
                .isA(mock(Entity.class))
                .partOf(mock(Entity.class))
                .create();
    }

    @Test
    public void getPartOf() throws Exception {
        assertNotNull(element.getPartOf());
    }

    @Test
    public void setPartOf() throws Exception {
        element.setPartOf(null);
        assertNull(element.getPartOf());
        Entity ent = mock(Entity.class);
        element.setPartOf(ent);
        assertEquals(ent, element.getPartOf());
    }

    @Test
    public void isAs() throws Exception {
        assertEquals(2, element.isAs().size());
    }

    @Test
    public void hasIsAs() throws Exception {
        assertTrue(element.hasIsAs());
    }

    @Test
    public void addIsA() throws Exception {
        Entity ent = mock(Entity.class);
        int size = 2;
        assertEquals(size, element.isAs().size());
        element.addIsA(null);
        assertEquals(size, element.isAs().size());
        size++;
        element.addIsA(ent);
        assertEquals(size, element.isAs().size());
        element.addIsA(ent);
        assertEquals(size, element.isAs().size());
    }

    @Test
    public void removeIsA() throws Exception {
        Entity ent = mock(Entity.class);
        int size = 2;
        assertEquals(size, element.isAs().size());
        element.addIsA(ent);
        assertEquals(size + 1, element.isAs().size());
        element.removeIsA(ent);
        assertEquals(size, element.isAs().size());
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
        assertEquals("entity", element.getName());
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
        String tag = element.generateXMLTag(EntityType.PRODUCT_PART.type());
        String value = "<entities xmi:id=\"ID\" xsi:type=\"qm:ProductPart\" name=\"entity\" description=\"description\" title=\"title\">\n" +
                "<isA parent=\"null\" />\n" +
                "<isA parent=\"null\" />\n" +
                "</entities>\n";
        assertEquals(value, tag);

        tag = element.generateXMLTag(EntityType.STAKEHOLDER.type());
        value = "<entities xmi:id=\"ID\" xsi:type=\"qm:Stakeholder\" name=\"entity\" description=\"description\" title=\"title\">\n" +
                "<isA parent=\"null\" />\n" +
                "<isA parent=\"null\" />\n" +
                "</entities>\n";
        assertEquals(value, tag);

        tag = element.generateXMLTag(EntityType.USE_CASE.type());
        value = "<entities xmi:id=\"ID\" xsi:type=\"qm:UseCase\" name=\"entity\" description=\"description\" title=\"title\">\n" +
                "<isA parent=\"null\" />\n" +
                "<isA parent=\"null\" />\n" +
                "</entities>\n";
        assertEquals(value, tag);
    }

}