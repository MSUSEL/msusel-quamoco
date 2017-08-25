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
package edu.montana.gsoc.msusel.quamoco.io;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.quamoco.io.QMRReader;
import edu.montana.gsoc.msusel.quamoco.model.qmr.EvaluationResult;
import edu.montana.gsoc.msusel.quamoco.model.qmr.FindingMessage;
import edu.montana.gsoc.msusel.quamoco.model.qmr.MeasurementResult;
import edu.montana.gsoc.msusel.quamoco.model.qmr.QualityModelResult;
import edu.montana.gsoc.msusel.quamoco.model.qmr.Value;

/**
 * The class <code>QMRReaderTest</code> contains tests for the class
 * <code>{@link QMRReader}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:42 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class QMRReaderTest {

	/**
	 * Run the QMRReader() constructor test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:42 PM
	 */
	@Test
	public void testQMRReader_1() throws Exception {

		final QMRReader result = new QMRReader();

		// TODO: add additional test code here
		Assert.assertNotNull(result);
		Assert.assertEquals(null, result.getResult());
	}

	/**
	 * Run the QualityModelResult getResult() method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:42 PM
	 */
	@Test
	public void testGetResult_1() throws Exception {
		final QMRReader fixture = new QMRReader();

		final QualityModelResult result = fixture.getResult();

		// TODO: add additional test code here
		Assert.assertEquals(null, result);
	}

	/**
	 * Run the void read(String) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:42 PM
	 */
	@Test
	public void testRead_1() throws Exception {
		final QMRReader fixture = new QMRReader();
		fixture.read("testdata/test.qmr");

		final QualityModelResult result = fixture.getResult();
		Assert.assertNotNull(result);
		Assert.assertEquals("test", result.getSystem());
		Assert.assertEquals("2013-05-29T09:09:31.253+0200", result.getDate());

		Assert.assertEquals(3, result.getMeasurementResults().size());
		final MeasurementResult mr1 = result.getMeasurementResults().get(0);
		Assert.assertEquals("_taU0kMguEeKB3pQmwdg3FA", mr1.getId());
		Assert.assertEquals(1, mr1.getCount());
		Assert.assertEquals("qm:FindingsMeasurementResult", mr1.getType());
		Assert.assertEquals("java.qm#_9LpQ43MWEd-Ywpz7Oo8Ghw", mr1.getResultsFrom());
		Assert.assertEquals("qm:ToolBasedInstrument", mr1.getResultsType());

		Assert.assertEquals(1, mr1.getFindingMessages().size());
		final FindingMessage msg1 = mr1.getFindingMessages().get(0);
		Assert.assertEquals("_taVboMguEeKB3pQmwdg3FA", msg1.getId());
		Assert.assertEquals("filestats.FileCreationDate.GENERIC_EXECUTE has insufficient comment.", msg1.getLocation());
		Assert.assertEquals("test/src/filestats/FileCreationDate.java:17-17", msg1.getMessage());

		final MeasurementResult mr2 = result.getMeasurementResults().get(1);
		Assert.assertEquals("_taWCsMguEeKB3pQmwdg3FA", mr2.getId());
		Assert.assertEquals(0, mr2.getCount());
		Assert.assertEquals("qm:FindingsMeasurementResult", mr2.getType());
		Assert.assertEquals("java.qm#_9LpQ7XMWEd-Ywpz7Oo8Ghw", mr2.getResultsFrom());
		Assert.assertEquals("qm:ToolBasedInstrument", mr2.getResultsType());

		final MeasurementResult mr3 = result.getMeasurementResults().get(2);
		Assert.assertEquals("_tcJZgsguEeKB3pQmwdg3FA", mr3.getId());
		Assert.assertEquals(1, mr3.getCount());
		Assert.assertEquals("qm:FindingsMeasurementResult", mr3.getType());
		Assert.assertEquals("java.qm#_9LpQ53MWEd-Ywpz7Oo8Ghw", mr3.getResultsFrom());
		Assert.assertEquals("qm:ToolBasedInstrument", mr3.getResultsType());

		Assert.assertEquals(1, mr3.getFindingMessages().size());
		final FindingMessage msg2 = mr3.getFindingMessages().get(0);
		Assert.assertEquals("_tcJZg8guEeKB3pQmwdg3FA", msg2.getId());
		Assert.assertEquals("Avoid unused local variables such as 'iLastError'.", msg2.getLocation());
		Assert.assertEquals("test/src/filestats/FileCreationDate.java:68-68", msg2.getMessage());

		Assert.assertEquals(4, result.getEvaluationResults().size());
		final EvaluationResult er1 = result.getEvaluationResults().get(0);
		Assert.assertEquals("_tcGWMMguEeKB3pQmwdg3FA", er1.getId());
		Assert.assertEquals(null, er1.getRatioAffected());
		Assert.assertEquals("java.qm#_yi0EYJKiEeCZ2qLvmkZpQQ", er1.getResultsFrom());
		Assert.assertEquals("qm:WeightedSumMultiMeasureEvaluation", er1.getResultsType());
		Assert.assertEquals("qm:MultiMeasureEvaluationResult", er1.getType());
		Assert.assertEquals(3, er1.getEvalResults().size());

		final Value v1 = er1.getValue();
		Assert.assertNotNull(v1);
		Assert.assertEquals(0.9999999999999998, v1.getUpper(), 0.000001);
		Assert.assertEquals(0.9999999999999998, v1.getLower(), 0.000001);
		Assert.assertEquals("_tcGWN8guEeKB3pQmwdg3FA", v1.getId());

		final EvaluationResult er2 = result.getEvaluationResults().get(1);
		Assert.assertEquals("_tcGWMcguEeKB3pQmwdg3FA", er2.getId());
		Assert.assertEquals(null, er2.getRatioAffected());
		Assert.assertEquals("java.qm#_Bj1BMKC0EeCXeaQmNuK36Q", er2.getResultsFrom());
		Assert.assertEquals(null, er2.getResultsType());
		Assert.assertEquals(null, er2.getType());

		final Value v2 = er2.getValue();
		Assert.assertNotNull(v2);
		Assert.assertEquals(1.0, v2.getUpper(), 0.01);
		Assert.assertEquals(1.0, v2.getLower(), 0.01);
		Assert.assertEquals("_tcGWMsguEeKB3pQmwdg3FA", v2.getId());

		final EvaluationResult er3 = result.getEvaluationResults().get(2);
		Assert.assertEquals("_tcGWM8guEeKB3pQmwdg3FA", er3.getId());
		Assert.assertEquals(null, er3.getRatioAffected());
		Assert.assertEquals("java.qm#_Bj1BMqC0EeCXeaQmNuK36Q", er3.getResultsFrom());
		Assert.assertEquals(null, er3.getResultsType());
		Assert.assertEquals(null, er3.getType());

		final Value v3 = er3.getValue();
		Assert.assertNotNull(v3);
		Assert.assertEquals(1.0, v3.getUpper(), 0.01);
		Assert.assertEquals(1.0, v3.getLower(), 0.01);
		Assert.assertEquals("_tcGWNMguEeKB3pQmwdg3FA", v3.getId());

		final EvaluationResult er4 = result.getEvaluationResults().get(3);
		Assert.assertEquals("_tcGWNcguEeKB3pQmwdg3FA", er4.getId());
		Assert.assertEquals(null, er4.getRatioAffected());
		Assert.assertEquals("java.qm#_Bj1BNKC0EeCXeaQmNuK36Q", er4.getResultsFrom());
		Assert.assertEquals(null, er4.getResultsType());
		Assert.assertEquals(null, er4.getType());

		final Value v4 = er4.getValue();
		Assert.assertNotNull(v4);
		Assert.assertEquals(1.0, v4.getUpper(), 0.01);
		Assert.assertEquals(1.0, v4.getLower(), 0.01);
		Assert.assertEquals("_tcGWNsguEeKB3pQmwdg3FA", v4.getId());
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *             if the initialization fails for some reason
	 * @generatedBy CodePro at 5/30/15 3:42 PM
	 */
	@Before
	public void setUp() throws Exception {
		// TODO: add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *             if the clean-up fails for some reason
	 * @generatedBy CodePro at 5/30/15 3:42 PM
	 */
	@After
	public void tearDown() throws Exception {
		// TODO: add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args
	 *            the command line arguments
	 * @generatedBy CodePro at 5/30/15 3:42 PM
	 */
	public static void main(final String[] args) {
		new org.junit.runner.JUnitCore().run(QMRReaderTest.class);
	}
}