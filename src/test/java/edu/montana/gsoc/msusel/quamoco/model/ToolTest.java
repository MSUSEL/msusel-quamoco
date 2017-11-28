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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ToolTest {

    Tool element;

    @Before
    public void setUp() throws Exception {
        element = Tool.builder()
                .name("tool")
                .identifier("ID")
                .description("description")
                .title("title")
                .create();
    }

    @Test
    public void getTitle() throws Exception {
        assertEquals("title", element.getTitle());
    }

    @Test
    public void setTitle() throws Exception {
        element.setTitle("NewTitle");
        assertEquals("NewTitle", element.getTitle());
    }

    @Test
    public void getName() throws Exception {
        assertEquals("tool", element.getName());
    }

    @Test
    public void setName() throws Exception {
        element.setName("NewName");
        assertEquals("NewName", element.getName());
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals("description", element.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        element.setDescription("NewDescription");
        assertEquals("NewDescription", element.getDescription());
    }

    @Test
    public void xmlTag() throws Exception {
        String value = "<tools xmi:id=\"ID\" name=\"tool\" description=\"description\" title=\"title\" />\n";
        assertEquals(value, element.xmlTag());
    }

    @Test
    public void toScript() throws Exception {
        fail();
    }

}