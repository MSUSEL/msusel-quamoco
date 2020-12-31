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

import edu.montana.gsoc.msusel.quamoco.model.eval.measure.MeasureRanking;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MeasureRankingTest {

    MeasureRanking element;

    @Before
    public void setUp() throws Exception {
        element = MeasureRanking.builder().identifier("ID")
                .rank(5)
                .weight(0.5)
                .basedOn(mock(Measure.class))
                .create();
    }

    @Test
    public void getMeasure() {
        assertNotNull(element.getMeasure());
    }

    @Test
    public void setMeasure() {
        element.setMeasure(null);
        assertNull(element.getMeasure());
        element.setMeasure(mock(Measure.class));
        assertNotNull(element.getMeasure());
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
        assertEquals(0.5, element.getWeight(), 0.001);
    }

    @Test
    public void setWeight() {
        element.setWeight(1.0);
        assertEquals(1.0, element.getWeight(), 0.001);
    }

//    @Test
//    public void evaluate() {
//        fail();
//    }

    @Test
    public void xmlTag() throws Exception {
        String value = "<rankings xmi:id=\"ID\" xsi:type=\"qm:MeasureRanking\" weight=\"0.5\" rank=\"5\" />\n";
        assertEquals(value, element.xmlTag());
    }

    @Test
    public void getCompleteness() {
        assertEquals(0.0, element.getCompleteness(), 0.001);
    }

//    @Test
//    public void setCompleteness() throws Exception {
//    }

    @Test
    public void getMaximumPoints() {
        assertEquals(0.0, element.getMaximumPoints(), 0.001);
    }

//    @Test
//    public void setMaximumPoints() {
//    }

    @Test
    public void getEvaluates() {
        assertNull(element.getEvaluates());
    }

//    @Test
//    public void setEvaluates() {
//    }

    @Test
    public void getContributionPoints() {
        assertEquals(0.0, element.getContributionPoints(), 0.001);
    }

//    @Test
//    public void setContributionPoints() {
//    }

//    @Test
//    public void toScript() {
//        fail();
//    }

}