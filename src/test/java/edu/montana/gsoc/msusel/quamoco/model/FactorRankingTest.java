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

import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measurement.FactorRanking;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class FactorRankingTest {

    private FactorRanking element;

    @Mock
    Factor fac;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public void setUp() throws Exception {
        element = FactorRanking.builder()
                .identifier("ID")
                .factor(fac)
                .rank(5)
                .weight(1.0)
                .create();
    }

    @Test
    public void getFactor() {
        assertNotNull(element.getFactor());
        assertEquals(fac, element.getFactor());
    }

    @Test
    public void setFactor() {
        Factor fac2 = mock(Factor.class);
        element.setFactor(null);
        assertNull(element.getFactor());
        element.setFactor(fac2);
        assertEquals(fac2, element.getFactor());
    }

    @Test
    public void getRank() {
        assertEquals(5, element.getRank());
    }

    @Test
    public void setRank() {
        element.setRank(1);
        assertEquals(1, element.getRank());
    }

    @Test
    public void getWeight() {
        assertEquals(1.0, element.getWeight(), 0.001);
    }

    @Test
    public void setWeight() {
        element.setWeight(0.5);
        assertEquals(0.5, element.getWeight(), 0.001);
    }

    @Test
    public void getContributionPoints() {
        assertEquals(0, element.getContributionPoints(), 0.001);
    }

    @Test
    public void setContributionPoints() {
        element.setContributionPoints(10.0);
        assertEquals(10, element.getContributionPoints(), 0.001);
    }

//    @Test
//    public void toScript() {
//        fail();
//    }

    @Test
    public void xmlTag() throws Exception {
        String value = "<rankings xmi:id=\"ID\" xsi:type=\"qm:FactorRanking\" factor=\"null\" weight=\"1.000000\" rank=\"5\" />\n";
        assertEquals(value, element.xmlTag());
    }
}