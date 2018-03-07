/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.quamoco.processor;

import edu.montana.gsoc.msusel.quamoco.graph.edge.Edge;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.NullNormalizer;
import edu.montana.gsoc.msusel.quamoco.processor.normalizers.RangedNormalizer;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>NormalizerTest</code> contains tests for the class
 * <code>{@link Normalizer}</code>.
 *
 * @generatedBy CodePro at 1/26/16 6:35 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class NormalizerTest {

	private Normalizer fixture;

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Test
	public void testNormalizer_1() throws Exception {
		final Edge edge = EasyMock.createMock(Edge.class);
		final String metric = "LOC";
		final NormalizationRange range = NormalizationRange.CLASS;

		EasyMock.replay(edge);

		final Normalizer result = new RangedNormalizer(edge, metric, range);

		EasyMock.verify(edge);
		Assert.assertNotNull(result);
		Assert.assertEquals("LOC", result.getMetric());
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testNormalizer_2() throws Exception {
		final String metric = "LOC";
		final NormalizationRange range = NormalizationRange.CLASS;

		new RangedNormalizer(null, metric, range);
	}

	/**
	 * Run the String getName() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Test
	public void testGetMetric_1() throws Exception {
		final String result = fixture.getMetric();

		// add additional test code here
		Assert.assertEquals("LOC", result);
	}

	/**
	 * Run the NormalizationRange getNormalizationRange() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Test
	public void testGetNormalizationRange_1() throws Exception {
		final NormalizationRange result = fixture.getRange();

		// add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals("CLASS", result.name());
		Assert.assertEquals("CLASS", result.toString());
		Assert.assertEquals(1, result.ordinal());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	@Before
	public void setUp() throws Exception {
		fixture = new NullNormalizer(EasyMock.createNiceMock(Edge.class), "LOC", NormalizationRange.CLASS);
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
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
	 *
	 * @generatedBy CodePro at 1/26/16 6:35 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(NormalizerTest.class);
	}
}