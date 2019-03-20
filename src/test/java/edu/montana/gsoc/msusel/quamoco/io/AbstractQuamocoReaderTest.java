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

import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import edu.montana.gsoc.msusel.quamoco.io.qmr.QMRXMLReader;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamReader;
import java.util.Map;

/**
 * The class <code>AbstractQuamocoReaderTest</code> contains tests for the class
 * <code>{@link AbstractQuamocoReader}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:42 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class AbstractQuamocoReaderTest {

	/**
	 * Run the Map<String, String> getAttributes(XMLStreamReader) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:42 PM
	 */
	@Test
	public void testGetAttributes_1() throws Exception {
		final AbstractQuamocoReader fixture = new QMRXMLReader(new ModelManager());
		final XMLStreamReader reader = EasyMock.createMock(XMLStreamReader.class);
		// TODO: add mock object expectations here

		EasyMock.expect(reader.getAttributeCount()).andReturn(2).atLeastOnce();
		EasyMock.expect(reader.getAttributeLocalName(0)).andReturn("id");
		EasyMock.expect(reader.getAttributeValue(0)).andReturn("test-id");
		EasyMock.expect(reader.getAttributeLocalName(1)).andReturn("name");
		EasyMock.expect(reader.getAttributeValue(1)).andReturn("Test Name");
		// EasyMock.expect(reader.getAttributeLocalName(2)).andReturn("");
		// EasyMock.expect(reader.getAttributeValue(2)).andReturn("");

		EasyMock.replay(reader);

		final Map<String, String> result = fixture.getAttributes(reader);

		// TODO: add additional test code here
		EasyMock.verify(reader);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
		Assert.assertTrue(result.containsKey("id"));
		Assert.assertEquals("test-id", result.get("id"));
		Assert.assertTrue(result.containsKey("name"));
		Assert.assertEquals("Test Name", result.get("name"));
	}

	/**
	 * Run the Map<String, String> getAttributes(XMLStreamReader) method test.
	 *
	 * @throws Exception
	 * @generatedBy CodePro at 5/30/15 3:42 PM
	 */
	@Test
	public void testGetAttributes_2() throws Exception {
		final AbstractQuamocoReader fixture = new QMRXMLReader(new ModelManager());
		final XMLStreamReader reader = null;

		final Map<String, String> result = fixture.getAttributes(reader);

		Assert.assertNotNull(result);
		Assert.assertEquals(0, result.size());
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
		new org.junit.runner.JUnitCore().run(AbstractQuamocoReaderTest.class);
	}
}