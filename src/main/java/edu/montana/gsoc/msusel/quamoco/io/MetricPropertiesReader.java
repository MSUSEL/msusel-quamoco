/**
 * The MIT License (MIT)
 *
 * SparQLine Quamoco Implementation
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Properties reader for files describing the language specific metrics produced
 * by quamoco
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public final class MetricPropertiesReader {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(MetricPropertiesReader.class);

    /**
     * Constructs a new MetricPropertiesReader
     */
    private MetricPropertiesReader()
    {
    }

    /**
     * Static method to read the metric properties stored in the JAR
     * 
     * @return array of metric properites.
     */
    public static String[] read()
    {
        Properties prop = new Properties();
        String temp = "";
        try
        {
            prop.load(MetricPropertiesReader.class.getResourceAsStream("metrics.properties"));
            temp = prop.getProperty("metrics");
            prop = new Properties();
        }
        catch (final IOException e)
        {
            MetricPropertiesReader.LOG.warn("A problem occurred while loading the metric properties file.", e);
        }

        return temp.split(",");
    }
}
