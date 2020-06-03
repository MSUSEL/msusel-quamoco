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
package edu.montana.gsoc.msusel.quamoco.processor;

/**
 * Exception thrown when an issue occurs within the MetricsContext class.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class MetricsContextException extends Exception {

    /**
     * Constructs a new MetricsContextException
     */
    public MetricsContextException()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new MetricsContextException with the given message
     * 
     * @param message
     *            The message
     */
    public MetricsContextException(final String message)
    {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new MetricsContextException caused by the given Throwable
     * 
     * @param cause
     *            Cause of this MetricsContextException
     */
    public MetricsContextException(final Throwable cause)
    {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new MetricsContextException caused by the given Throwable
     * but with the provided message.
     * 
     * @param message
     *            The message
     * @param cause
     *            Cause of this MetricsContextException
     */
    public MetricsContextException(final String message, final Throwable cause)
    {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new MetricsContextException with the given message and
     * cause, but with capability to enable/disable suppression and indication
     * of whether or not to write to the stack trace.
     * 
     * @param message
     *            The message
     * @param cause
     *            Cause of this MetricsContextException
     * @param enableSuppression
     *            flag indicating whether or not to suppress this exception
     * @param writableStackTrace
     *            flag indicating whether or not to write to the stack trace
     */
    public MetricsContextException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

}
