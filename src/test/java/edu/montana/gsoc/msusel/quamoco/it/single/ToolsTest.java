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
package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.Tool;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ToolsTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTool() {
        Tool t = manager.findToolByName("Test Tool");
        assertNotNull(t);

        assertEquals("Test Tool", t.getName());
        assertEquals("Test Tool", t.getDescription());
        assertEquals("Test Tool", t.getTitle());
        assertNotNull(t.getOriginatesFrom());
        assertEquals("Test Source", t.getOriginatesFrom().getName());
        assertEquals(1, t.getTaggedBy().size());
        assertEquals("Test Tag", t.getTaggedBy().get(0).getName());
    }

    @Test
    public void testToolHier() {
        Tool t = manager.findToolByName("TestHierTool");
        assertNotNull(t);

        assertEquals("TestHierTool", t.getName());
        assertEquals("TestHierTool", t.getTitle());
        assertEquals("Test Hier Tool", t.getDescription());
        assertNotNull(t.getOriginatesFrom());
        assertEquals("TestHier Source", t.getOriginatesFrom().getName());
        assertEquals(1, t.getTaggedBy().size());
        assertEquals("TestHier Tag", t.getTaggedBy().get(0).getName());
    }
}
