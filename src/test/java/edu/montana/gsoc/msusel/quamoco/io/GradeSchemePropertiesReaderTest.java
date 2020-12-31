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
package edu.montana.gsoc.msusel.quamoco.io;

import edu.montana.gsoc.msusel.quamoco.distiller.Grade;
import org.junit.Assert;
import org.junit.Test;

/**
 * The class <code>GradeSchemePropertiesReaderTest</code> contains tests for the
 * class <code>{@link GradeSchemePropertiesReader}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class GradeSchemePropertiesReaderTest {

    /**
     * Run the GradeSchemePropertiesReader() constructor test.
     */
    @Test
    public void testGradeSchemePropertiesReader_1() {
        final GradeSchemePropertiesReader fixture = new GradeSchemePropertiesReader();

        Assert.assertNotNull(fixture);
    }

    /**
     * Run the void read() method test.
     */
    @Test
    public void testRead_1() {
        final GradeSchemePropertiesReader fixture = new GradeSchemePropertiesReader();
        fixture.read();

        Assert.assertEquals(1.5, Grade.A.getUpperThreshold(), 0.001);
        Assert.assertEquals(0.98, Grade.A.getLowerThreshold(), 0.001);

        Assert.assertEquals(0.98, Grade.B.getUpperThreshold(), 0.001);
        Assert.assertEquals(0.96, Grade.B.getLowerThreshold(), 0.001);

        Assert.assertEquals(0.96, Grade.C.getUpperThreshold(), 0.001);
        Assert.assertEquals(0.94, Grade.C.getLowerThreshold(), 0.001);

        Assert.assertEquals(0.94, Grade.D.getUpperThreshold(), 0.001);
        Assert.assertEquals(0.92, Grade.D.getLowerThreshold(), 0.001);

        Assert.assertEquals(0.92, Grade.E.getUpperThreshold(), 0.001);
        Assert.assertEquals(0.90, Grade.E.getLowerThreshold(), 0.001);

        Assert.assertEquals(0.90, Grade.F.getUpperThreshold(), 0.001);
        Assert.assertEquals(0.0, Grade.F.getLowerThreshold(), 0.001);

        Assert.assertEquals(0.0, Grade.U.getUpperThreshold(), 0.001);
        Assert.assertEquals(-1.0, Grade.U.getLowerThreshold(), 0.001);
    }
}