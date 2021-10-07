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
package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import org.junit.After;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class EntitiesTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testComment() {
        Entity e = manager.findEntityByName("Comment");
        assertNotNull(e);

        assertTrue(e.hasIsAs());
        assertEquals("Product Part", e.isAs().get(0).getName());
        assertEquals("Test Source", e.getOriginatesFrom().getName());
        assertTrue(e.hasTags());
        assertEquals("Test Tag", e.getTaggedBy().get(0).getName());
    }

    @Test
    public void testProduct() {
        Entity e = manager.findEntityByName("Product");
        assertNotNull(e);

        assertEquals("Test Source", e.getOriginatesFrom().getName());
    }

    @Test
    public void testProductPart() {
        Entity e = manager.findEntityByName("Product Part");
        assertNotNull(e);

        assertEquals("Product", e.getPartOf().getName());
        assertEquals("Test Source", e.getOriginatesFrom().getName());
    }

    @Test
    public void testSourceCode() {
        Entity e = manager.findEntityByName("Source Code");
        assertNotNull(e);

        assertEquals("Product", e.getPartOf().getName());
        assertEquals("Test Source", e.getOriginatesFrom().getName());
    }

    @Test
    public void testSourceCodePart() {
        Entity e = manager.findEntityByName("Source Code Part");
        assertNotNull(e);

        assertTrue(e.hasIsAs());
        assertEquals("Product Part", e.isAs().get(0).getName());
        assertEquals("Source Code", e.getPartOf().getName());
        assertEquals("Test Source", e.getOriginatesFrom().getName());
    }

    @Test
    public void testClass() {
        Entity e = manager.findEntityByName("Class");
        assertNotNull(e);

        assertEquals("Type", e.getTitle());
        assertEquals("Class Type", e.getDescription());
        assertEquals("TestHier Source", e.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", e.getTaggedBy().get(0).getName());
        assertTrue(e.hasIsAs());
        assertEquals("Source Code Part", e.isAs().get(0).getName());
    }
}
