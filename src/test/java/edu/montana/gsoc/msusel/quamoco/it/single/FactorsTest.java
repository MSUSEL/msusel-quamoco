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

import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactorsTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testMaintainability() {
        Factor f = manager.findFactorByName("Maintainability");
        assertNotNull(f);

        assertEquals("Test Maintainability", f.getTitle());
        assertEquals("Test for Maintainability", f.getDescription());
        assertNotNull(f.getOriginatesFrom());
        assertEquals("Test Source", f.getOriginatesFrom().getName());
        assertEquals(2, f.getInfluences().size());
        assertTrue(f.hasTags());
        assertEquals("Test Tag", f.getTaggedBy().get(0).getName());
    }

    @Test
    public void testProductQuality() {
        Factor f = manager.findFactorByName("Quality @Product");
        assertNotNull(f);

        assertEquals("Software Quality", f.getTitle());
        assertEquals("Product Quality", f.getDescription());
        assertEquals("Product", f.getCharacterizes().getName());
        assertNotNull(f.getOriginatesFrom());
        assertEquals("Test Source", f.getOriginatesFrom().getName());
        assertTrue(f.hasTags());
        assertEquals("Test Tag", f.getTaggedBy().get(0).getName());
    }

    @Test
    public void testSourceCodePartQuality() {
        Factor f = manager.findFactorByName("Quality @Source Code Part");
        assertNotNull(f);

        assertEquals("Source Code Part Quality", f.getDescription());
        assertEquals("Source Code Part", f.getCharacterizes().getName());
        assertNotNull(f.getRefines());
        assertEquals("Quality @Product", f.getRefines().getFullName());
        assertNotNull(f.getOriginatesFrom());
        assertEquals("Test Source", f.getOriginatesFrom().getName());
        assertTrue(f.hasTags());
        assertEquals("Test Tag", f.getTaggedBy().get(0).getName());
    }

    @Test
    public void testSecurity() {
        Factor f = manager.findFactorByName("Security");
        assertNotNull(f);

        assertEquals("Security", f.getDescription());
        assertNotNull(f.getOriginatesFrom());
        assertEquals("Test Source", f.getOriginatesFrom().getName());
        assertEquals(2, f.getInfluences().size());
        assertTrue(f.hasTags());
        assertEquals("Test Tag", f.getTaggedBy().get(0).getName());
    }

    @Test
    public void testReliability() {
        Factor f = manager.findFactorByName("Reliability");
        assertNotNull(f);

        assertEquals("Reliability", f.getName());
        assertEquals("Reliability", f.getTitle());
        assertEquals("Reliability", f.getDescription());
        assertEquals("TestHier Source", f.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", f.getTaggedBy().get(0).getName());
        assertNull(f.getRefines());
        assertEquals(2, f.getInfluences().size());
    }

    @Test
    public void testRelManual() {
        Factor f = manager.findFactorByName("RelManual");
        assertNotNull(f);

        assertEquals("RelManual", f.getName());
        assertEquals("RelManual", f.getTitle());
        assertEquals("RelManual", f.getDescription());
        assertEquals("TestHier Source", f.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", f.getTaggedBy().get(0).getName());
        assertNull(f.getRefines());
        assertEquals(1, f.getInfluences().size());
    }

    @Test
    public void testRelMultMeasure() {
        Factor f = manager.findFactorByName("RelMultMeasure");
        assertNotNull(f);

        assertEquals("RelMultMeasure", f.getName());
        assertEquals("RelMultMeasure", f.getTitle());
        assertEquals("RelMultMeasure", f.getDescription());
        assertEquals("TestHier Source", f.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", f.getTaggedBy().get(0).getName());
        assertNull(f.getRefines());
        assertEquals(1, f.getInfluences().size());
    }

    @Test
    public void testRelQIESL() {
        Factor f = manager.findFactorByName("RelQIESL");
        assertNotNull(f);

        assertEquals("RelQIESL", f.getName());
        assertEquals("RelQIESL", f.getTitle());
        assertEquals("RelQIESL", f.getDescription());
        assertEquals("TestHier Source", f.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", f.getTaggedBy().get(0).getName());
        assertNull(f.getRefines());
        assertEquals(1, f.getInfluences().size());
    }

    @Test
    public void testRelText() {
        Factor f = manager.findFactorByName("RelText");
        assertNotNull(f);

        assertEquals("RelText", f.getName());
        assertEquals("RelText", f.getTitle());
        assertEquals("RelText", f.getDescription());
        assertEquals("TestHier Source", f.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", f.getTaggedBy().get(0).getName());
        assertNull(f.getRefines());
        assertEquals(1, f.getInfluences().size());
    }

    @Test
    public void testUnionFactor() {
        Factor f = manager.findFactorByName("UnionFactor");
        assertNotNull(f);

        assertEquals("UnionFactor", f.getName());
        assertEquals("UnionFactor", f.getTitle());
        assertEquals("UnionFactor", f.getDescription());
        assertEquals("TestHier Source", f.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", f.getTaggedBy().get(0).getName());
        assertNull(f.getRefines());
        assertEquals(1, f.getInfluences().size());
    }
}
