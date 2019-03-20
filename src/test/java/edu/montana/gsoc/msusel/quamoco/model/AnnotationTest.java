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

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnnotationTest {

    private Annotation annotation;

    @Before
    public void setUp() throws Exception {
        annotation = Annotation.builder().identifier("ID").key("Key").value("Value").create();
    }

    @Test
    public void getKey() throws Exception {
        assertEquals("Key", annotation.getKey());
    }

    @Test
    public void setKey() throws Exception {
        annotation.setKey("NewKey");
        assertEquals("NewKey", annotation.getKey());
    }

    @Test
    public void getValue() throws Exception {
        assertEquals("Value", annotation.getValue());
    }

    @Test
    public void setValue() throws Exception {
        annotation.setValue("NewValue");
        assertEquals("NewValue", annotation.getValue());
    }

    @Test
    public void getIdentifier() throws Exception {
        assertEquals("ID", annotation.getIdentifier());
    }

    @Test
    public void toYaml() throws Exception {
        fail();
    }

    @Test
    public void toJson() throws Exception {
        fail();
    }

    @Test
    public void toScript() throws Exception {
        fail();
    }

    @Test
    public void xmlTag() throws Exception {
        fail();
    }

}