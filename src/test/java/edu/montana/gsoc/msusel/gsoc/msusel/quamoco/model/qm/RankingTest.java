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
package edu.montana.gsoc.msusel.gsoc.msusel.quamoco.model.qm;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.model.qm.FactorLink;
import edu.montana.gsoc.msusel.quamoco.model.qm.Function;
import edu.montana.gsoc.msusel.quamoco.model.qm.FunctionType;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasureLink;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationMeasure;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.model.qm.Ranking;

/**
 * The class <code>RankingTest</code> contains tests for the class
 * <code>{@link Ranking}</code>.
 *
 * @generatedBy CodePro at 6/6/15 1:35 PM
 * @author isaac
 * @version $Revision: BigDecimal.ONE $
 */
public class RankingTest {

    private Ranking fixture;

    /**
     * Run the Ranking(String,String,String,String,String,String,String,String)
     * constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testRanking_1() throws Exception
    {
        final String rank = "2";
        final String range = "NA";
        final String weight = "BigDecimal.ONE";
        final String measure = "measure";
        final String normalizationMeasure = "norm";
        final String ownerId = "owner";
        final String id = "id";

        final Ranking result = new Ranking(rank, range, weight, new MeasureLink(measure), null,
                new NormalizationMeasure(normalizationMeasure), ownerId, id);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("norm", result.getNormalizationMeasure().getHREF());
        Assert.assertEquals(null, result.getFactor());
        Assert.assertEquals("measure", result.getMeasure().getHREF());
        Assert.assertEquals("owner", result.getOwnerId());
        Assert.assertEquals(null, result.getFunction());
        Assert.assertEquals("NA", result.getRange().toString());
        Assert.assertEquals("BigDecimal.ONE", result.getWeight());
        Assert.assertEquals("2", result.getRank());
        Assert.assertEquals("id", result.getId());
        Assert.assertEquals("", result.getDescription());
        Assert.assertEquals(null, result.getName());
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_1() throws Exception
    {
        final Ranking obj = new Ranking("", "NA", "", new MeasureLink("measure"), null, null, "owner", "id");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(true, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_2() throws Exception
    {
        final Ranking obj = new Ranking("", "CLASS", "", new MeasureLink("measure"), null, null, "owner", "id");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_3() throws Exception
    {
        final Ranking obj = null;

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_4() throws Exception
    {
        final Object obj = new Object();

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_5() throws Exception
    {
        final Ranking obj = new Ranking("", "NA", "", null, new FactorLink("factor"), null, "owner", "id");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_6() throws Exception
    {
        final Ranking obj = new Ranking("", "NA", "", new MeasureLink("measure"), null, null, "owner", "id");
        obj.setFunction(new Function(BigDecimal.ONE, BigDecimal.ONE, "", ""));

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_7() throws Exception
    {
        final Ranking obj = new Ranking("1", "NA", "", new MeasureLink("measure"), null, null, "owner", "id");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the boolean equals(Object) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testEquals_8() throws Exception
    {
        final Ranking obj = new Ranking("", "NA", "", new MeasureLink("measure"), null,
                new NormalizationMeasure("norm"), "owner", "id");

        final boolean result = fixture.equals(obj);

        // add additional test code here
        Assert.assertEquals(false, result);
    }

    /**
     * Run the String getFactor() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetFactor_1() throws Exception
    {
        fixture.setFactor(new FactorLink("factor"));
        final FactorLink result = fixture.getFactor();

        // add additional test code here
        Assert.assertEquals("factor", result.getHREF());
    }

    /**
     * Run the Function getFunction() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetFunction_1() throws Exception
    {
        fixture.setFunction(new Function(BigDecimal.ZERO, BigDecimal.ONE, FunctionType.INCREASING, "function"));
        final Function result = fixture.getFunction();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(BigDecimal.ONE, result.getUpperBound());
        Assert.assertEquals(BigDecimal.ZERO, result.getLowerBound());
        Assert.assertEquals("function", result.getId());
        Assert.assertEquals(FunctionType.INCREASING, result.getType());
    }

    /**
     * Run the String getId() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetId_1() throws Exception
    {
        final String result = fixture.getId();

        // add additional test code here
        Assert.assertEquals("id", result);
    }

    /**
     * Run the String getMeasure() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetMeasure_1() throws Exception
    {
        final String result = fixture.getMeasure().getHREF();

        // add additional test code here
        Assert.assertEquals("measure", result);
    }

    /**
     * Run the String getNormalizationMeasure() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetNormalizationMeasure_1() throws Exception
    {
        fixture.setNormalizationMeasure(new NormalizationMeasure("norm"));
        final String result = fixture.getNormalizationMeasure().getHREF();

        // add additional test code here
        Assert.assertEquals("norm", result);
    }

    /**
     * Run the String getOwnerId() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetOwnerId_1() throws Exception
    {
        final String result = fixture.getOwnerId();

        // add additional test code here
        Assert.assertEquals("owner", result);
    }

    /**
     * Run the String getRange() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetRange_1() throws Exception
    {
        final String result = fixture.getRange().toString();

        // add additional test code here
        Assert.assertEquals("NA", result);
    }

    /**
     * Run the String getRank() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetRank_1() throws Exception
    {
        final String result = fixture.getRank();

        // add additional test code here
        Assert.assertEquals("", result);
    }

    /**
     * Run the String getWeight() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testGetWeight_1() throws Exception
    {
        final String result = fixture.getWeight();

        // add additional test code here
        Assert.assertEquals("", result);
    }

    /**
     * Run the void setFactor(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetFactor_1() throws Exception
    {
        final String factor = "factor";

        Assert.assertNotNull(fixture.getMeasure());
        fixture.setFactor(null);
        Assert.assertNotNull(fixture.getMeasure());
        Assert.assertNull(fixture.getFactor());

        Assert.assertNull(fixture.getFactor());
        fixture.setFactor(new FactorLink(factor));

        // add additional test code here
        Assert.assertEquals(factor, fixture.getFactor().getHREF());
        Assert.assertNull(fixture.getMeasure());
    }

    /**
     * Run the void setFunction(Function) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetFunction_1() throws Exception
    {
        final Function function = new Function(BigDecimal.ONE, BigDecimal.ONE, "", "");

        fixture.setFunction(function);

        // add additional test code here
        Assert.assertEquals(function, fixture.getFunction());
    }

    /**
     * Run the void setId(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetId_1() throws Exception
    {
        final String id = "newId";

        fixture.setId(id);

        // add additional test code here
        Assert.assertEquals(id, fixture.getId());

        try
        {
            fixture.setId(null);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        try
        {
            fixture.setId("");
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    /**
     * Run the void setMeasure(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetMeasure_1() throws Exception
    {
        fixture.setFactor(new FactorLink("factor"));
        Assert.assertNull(fixture.getMeasure());

        fixture.setMeasure(null);
        Assert.assertNull(fixture.getMeasure());

        final String measure = "measure2";
        fixture.setMeasure(new MeasureLink(measure));

        // add additional test code here
        Assert.assertNotNull(fixture.getMeasure());
        Assert.assertNull(fixture.getFactor());
        Assert.assertEquals(measure, fixture.getMeasure().getHREF());
    }

    /**
     * Run the void setNormalizationMeasure(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetNormalizationMeasure_1() throws Exception
    {
        final String normalizationMeasure = "measure";

        Assert.assertNull(fixture.getNormalizationMeasure());
        fixture.setNormalizationMeasure(new NormalizationMeasure(normalizationMeasure));

        Assert.assertEquals(normalizationMeasure, fixture.getNormalizationMeasure().getHREF());
    }

    /**
     * Run the void setOwnerId(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetOwnerId_1() throws Exception
    {
        final String ownerId = "newOwner";

        Assert.assertEquals("owner", fixture.getOwnerId());
        fixture.setOwnerId(ownerId);

        Assert.assertEquals(ownerId, fixture.getOwnerId());

        try
        {
            fixture.setOwnerId(null);
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }

        try
        {
            fixture.setOwnerId("");
            Assert.fail();
        }
        catch (final IllegalArgumentException e)
        {

        }
    }

    /**
     * Run the void setRange(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetRange_1() throws Exception
    {
        final String range = "CLASS";

        Assert.assertEquals(NormalizationRange.NA, fixture.getRange());
        fixture.setRange(range);

        Assert.assertEquals(NormalizationRange.valueOf(range), fixture.getRange());
    }

    /**
     * Run the void setRank(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetRank_1() throws Exception
    {
        final String rank = "2";

        Assert.assertEquals("", fixture.getRank());
        fixture.setRank(rank);

        Assert.assertEquals(rank, fixture.getRank());
    }

    /**
     * Run the void setWeight(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test
    public void testSetWeight_1() throws Exception
    {
        final String weight = "0.5";

        Assert.assertEquals("", fixture.getWeight());
        fixture.setWeight(weight);

        Assert.assertEquals(weight, fixture.getWeight());
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization afails for some reason
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Before
    public void setUp() throws Exception
    {
        fixture = new Ranking("", "NA", "", new MeasureLink("measure"), null, null, "owner", "id");
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @After
    public void tearDown() throws Exception
    {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(RankingTest.class);
    }
}