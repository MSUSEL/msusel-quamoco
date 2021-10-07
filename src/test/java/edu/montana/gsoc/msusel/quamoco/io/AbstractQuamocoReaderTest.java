/*
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
import org.junit.Assert;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamReader;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * The class <code>AbstractQuamocoReaderTest</code> contains tests for the class
 * <code>{@link AbstractQuamocoReader}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class AbstractQuamocoReaderTest {

	/**
	 * Run the Map<String, String> getAttributes(XMLStreamReader) method test.
	 */
	@Test
	public void testGetAttributes_1() {
		final AbstractQuamocoReader fixture = new QMRXMLReader(new ModelManager());
		XMLStreamReader reader = mock(XMLStreamReader.class);
		// TODO: add mock object expectations here

		when(reader.getAttributeCount()).thenReturn(2);
		when(reader.getAttributeValue(0)).thenReturn("test-id");
		when(reader.getAttributeValue(1)).thenReturn("Test Name");
		when(reader.getAttributeName(0)).thenReturn(QName.valueOf("id"));
		when(reader.getAttributeName(1)).thenReturn(QName.valueOf("name"));

		final Map<String, String> result = fixture.getAttributes(reader);

		// TODO: add additional test code here
		Assert.assertNotNull(reader);
		Assert.assertNotNull(result);
		Assert.assertEquals(2, result.size());
		Assert.assertTrue(result.containsKey("id"));
		Assert.assertEquals("test-id", result.get("id"));
		Assert.assertTrue(result.containsKey("name"));
		Assert.assertEquals("Test Name", result.get("name"));
	}

	/**
	 * Run the Map<String, String> getAttributes(XMLStreamReader) method test.
	 */
	@Test
	public void testGetAttributes_2() {
		final AbstractQuamocoReader fixture = new QMRXMLReader(new ModelManager());
		final XMLStreamReader reader = null;

		final Map<String, String> result = fixture.getAttributes(reader);

		Assert.assertNotNull(result);
		Assert.assertEquals(0, result.size());
	}
}