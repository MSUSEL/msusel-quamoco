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
package edu.montana.gsoc.msusel.quamoco.model.result;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class DoubleIntervalTest {

    DoubleInterval element;

    @Before
    public void setUp() throws Exception {
        element = DoubleInterval.builder()
                .upper(1.0)
                .lower(0.0)
                .create();
    }

    @Test
    public void contains() {
        assertTrue(element.contains(0.5));
        assertFalse(element.contains(-1.0));
        assertFalse(element.contains(1.1));
    }

    @Test
    public void compareTo() {
        DoubleInterval element2 = DoubleInterval.builder()
                .upper(1.0)
                .lower(0.0)
                .create();

        assertEquals(0, element.compareTo(element2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void compareTo2() {
        DoubleInterval element2 = null;

        assertEquals(0, element.compareTo(element2));
    }

    @Test
    public void compareTo3() {
        DoubleInterval element2 = DoubleInterval.builder()
                .upper(1.0)
                .lower(0.5)
                .create();

        assertEquals(1, element.compareTo(element2));
    }

    @Test
    public void compareTo4() {
        DoubleInterval element2 = DoubleInterval.builder()
                .upper(2.0)
                .lower(0.0)
                .create();

        assertEquals(-1, element.compareTo(element2));
    }

    @Test
    public void compareTo5() {
        DoubleInterval element2 = DoubleInterval.builder()
                .upper(2.0)
                .lower(1.0)
                .create();

        assertEquals(0, element.compareTo(element2));
    }
}