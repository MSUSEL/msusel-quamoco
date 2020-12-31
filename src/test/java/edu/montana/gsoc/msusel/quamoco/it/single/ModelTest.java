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

import edu.montana.gsoc.msusel.quamoco.model.QualityModel;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class ModelTest extends BaseTestClass {

    @Test
    public void testModelTest() {
        QualityModel model = manager.getModelByName("Test");
        assertNotNull(model);

        assertEquals("Test", model.getName());
        assertEquals(0.98, model.getGradeBoundary2(), 0.001);
        assertEquals(0.96, model.getGradeBoundary3(), 0.001);
        assertEquals(0.94, model.getGradeBoundary4(), 0.001);
        assertEquals(0.92, model.getGradeBoundary5(), 0.001);
        assertEquals(0.90, model.getGradeBoundary6(), 0.001);
    }

    @Test
    public void testModelTestHier() {
        QualityModel model = manager.getModelByName("TestHier");
        assertNotNull(model);

        assertEquals("TestHier", model.getName());
        assertEquals("Test Source", model.getOriginatesFrom().getName());
        assertEquals("Test Tag", model.getTaggedBy().get(0).getName());
        assertFalse(model.getRequires().isEmpty());
        assertEquals(0.98, model.getGradeBoundary2(), 0.001);
        assertEquals(0.96, model.getGradeBoundary3(), 0.001);
        assertEquals(0.94, model.getGradeBoundary4(), 0.001);
        assertEquals(0.92, model.getGradeBoundary5(), 0.001);
        assertEquals(0.90, model.getGradeBoundary6(), 0.001);
    }
}
