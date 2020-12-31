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

import edu.montana.gsoc.msusel.quamoco.model.eval.TextEvaluation;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class TextEvaluationTest {

    TextEvaluation element;

    @Before
    public void setUp() throws Exception {
        element = TextEvaluation.builder().identifier("ID")
                .specification("spec")
                .create();
    }

//    @Test
//    public void evaluate() {
//        fail();
//    }

    @Test
    public void getSpecification() {
        assertEquals("spec", element.getSpecification());
    }

    @Test
    public void setSpecification() {
        element.setSpecification(null);
        assertNull(element.getSpecification());
        element.setSpecification("newSpec");
        assertEquals("newSpec", element.getSpecification());
    }

    @Test
    public void xmlTag() throws Exception {
        String value = "<evaluations xmi:id=\"ID\" xsi:type=\"qm:TextEvaluation\" specification=\"spec\" />\n";
        assertEquals(value, element.xmlTag());
    }

//    @Test
//    public void toScript() {
//        fail();
//    }

}