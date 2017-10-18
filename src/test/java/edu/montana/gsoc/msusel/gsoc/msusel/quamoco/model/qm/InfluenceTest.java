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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.model.qm.Influence;
import edu.montana.gsoc.msusel.quamoco.model.qm.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.qm.Target;

/**
 * The class <code>InfluenceTest</code> contains tests for the class
 * <code>{@link Influence}</code>.
 *
 * @generatedBy CodePro at 6/6/15 1:35 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class InfluenceTest {

	/**
	 * Run the Influence(String,String,String,String) constructor test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testInfluence_1() throws Exception {
		final InfluenceEffect effect = InfluenceEffect.POSITIVE;
		final String justification = "";
		final Target target = new Target("target");
		final String id = "id";

		final Influence result = new Influence(effect, justification, target, id);

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("", result.getJustification());
		Assert.assertEquals("POSITIVE", result.getEffect().toString());
		Assert.assertEquals("id", result.getId());
		Assert.assertEquals("target", result.getTarget().getHREF());
	}
	
	/**
     * Run the Influence(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInfluence_2() throws Exception {
        final InfluenceEffect effect = InfluenceEffect.POSITIVE;
        final String justification = "";
        final Target target = new Target("target");
        final String id = "";

        final Influence result = new Influence(effect, justification, target, id);
    }
    
    /**
     * Run the Influence(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInfluence_3() throws Exception {
        final InfluenceEffect effect = InfluenceEffect.POSITIVE;
        final String justification = "";
        final Target target = new Target("target");
        final String id = null;

        final Influence result = new Influence(effect, justification, target, id);
    }
    
    /**
     * Run the Influence(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInfluence_4() throws Exception {
        final InfluenceEffect effect = InfluenceEffect.POSITIVE;
        final String justification = "";
        final Target target = new Target("");
        final String id = "id";

        final Influence result = new Influence(effect, justification, target, id);
    }
    
    /**
     * Run the Influence(String,String,String,String) constructor test.
     *
     * @throws Exception
     * @generatedBy CodePro at 6/6/15 1:35 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testInfluence_5() throws Exception {
        final InfluenceEffect effect = InfluenceEffect.POSITIVE;
        final String justification = "";
        final Target target = new Target(null);
        final String id = "id";

        final Influence result = new Influence(effect, justification, target, id);
    }

	/**
	 * Run the boolean equals(Object) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testEquals_1() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final Object obj = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

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
	public void testEquals_2() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final Object obj = null;

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
	public void testEquals_3() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
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
	public void testEquals_4() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final Object obj = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

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
	public void testEquals_5() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final Object obj = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

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
	public void testEquals_6() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final Object obj = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

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
	public void testEquals_7() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final Object obj = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

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
	public void testEquals_8() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final Object obj = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

		final boolean result = fixture.equals(obj);

		// add additional test code here
		Assert.assertEquals(true, result);
	}

	/**
	 * Run the String getEffect() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testGetEffect_1() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

		final String result = fixture.getEffect().toString();

		// add additional test code here
		Assert.assertEquals("POSITIVE", result);
	}

	/**
	 * Run the String getId() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testGetId_1() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");

		final String result = fixture.getId();

		// add additional test code here
		Assert.assertEquals("id", result);
	}

	/**
	 * Run the String getJustification() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testGetJustification_1() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "just", null, "id");

		final String result = fixture.getJustification();

		// add additional test code here
		Assert.assertEquals("just", result);
	}

	/**
	 * Run the String getTarget() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testGetTarget_1() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", new Target("target"), "id");

		final String result = fixture.getTarget().getHREF();

		// add additional test code here
		Assert.assertEquals("target", result);
	}

	/**
	 * Run the void setEffect(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testSetEffect_1() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final String effect = "NEGATIVE";

		fixture.setEffect(InfluenceEffect.valueOf(effect));

		Assert.assertEquals(effect, fixture.getEffect().toString());
	}

	/**
	 * Run the void setId(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testSetId_1() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final String id = "";

		fixture.setId(id);

		Assert.assertEquals(id, fixture.getId());
	}

	/**
	 * Run the void setJustification(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testSetJustification_1() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final String justification = "just";

		fixture.setJustification(justification);

		Assert.assertEquals(justification, fixture.getJustification());
	}

	/**
	 * Run the void setTarget(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Test
	public void testSetTarget_1() throws Exception {
		final Influence fixture = new Influence(InfluenceEffect.POSITIVE, "", null, "id");
		final String target = "target";

		fixture.setTarget(new Target(target));

		Assert.assertEquals(target, fixture.getTarget().getHREF());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@Before
	public void setUp() throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	@After
	public void tearDown() throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 * @generatedBy CodePro at 6/6/15 1:35 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(InfluenceTest.class);
	}
}