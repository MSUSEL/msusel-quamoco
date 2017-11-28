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

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

import edu.montana.gsoc.msusel.quamoco.distiller.Grade;
import edu.montana.gsoc.msusel.quamoco.distiller.GradeThresholdException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Properties reader for the default grade scheme for quamoco.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class GradeSchemePropertiesReader {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(GradeSchemePropertiesReader.class);

    /**
     * Constructs a new GradeSchemePropertiesReader
     */
    public GradeSchemePropertiesReader()
    {

    }

    /**
     * reads the default grade scheme from the JAR file and updates the Grade
     * enumeration with those values
     */
    public void read()
    {
        final Properties prop = new Properties();
        try
        {
            prop.load(GradeSchemePropertiesReader.class.getResourceAsStream("grade-default.properties"));

            for (final Grade g : Grade.getGrades())
            {
                final BigDecimal lower = new BigDecimal(prop.getProperty(g.getName() + "_GRADE.lower"));
                final BigDecimal upper = new BigDecimal(prop.getProperty(g.getName() + "_GRADE.upper"));
                try
                {
                    g.setThresholds(lower, upper);
                }
                catch (final GradeThresholdException e)
                {
                    GradeSchemePropertiesReader.LOG.warn(e.getMessage(), e);
                }
            }
        }
        catch (final IOException e)
        {
            GradeSchemePropertiesReader.LOG
                    .warn("A problem occurred while loading the grading scheme properties file.", e);
        }
    }
}
