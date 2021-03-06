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

import java.io.FileNotFoundException;
import java.util.Map;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import com.google.common.collect.Maps;

/**
 * Abstract base class for Quamoco XML reader.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class AbstractQuamocoReader {

    /**
     * Constructs a new instance
     */
    public AbstractQuamocoReader()
    {
    }

    /**
     * Retrieves a map of the attributes associated with the current tag in the
     * XML Stream
     * 
     * @param reader
     *            The XML Stream reader
     * @return Map of attribute values indexed by local name.
     */
    protected Map<String, String> getAttributes(final XMLStreamReader reader)
    {
        final Map<String, String> retVal = Maps.newHashMap();

        if (reader != null)
        {
            for (int i = 0; i < reader.getAttributeCount(); i++)
            {
                retVal.put(reader.getAttributeName(i).toString(), reader.getAttributeValue(i));
            }
        }

        return retVal;
    }

    /**
     * Reads in a quality model from the given file.
     * 
     * @param qm
     *            Name of the file to read.
     * @throws XMLStreamException
     *             If the file is not a well-formed XML document
     * @throws FileNotFoundException
     *             If the file cannot be found
     */
    public abstract void read(String file) throws FileNotFoundException, XMLStreamException;

}
