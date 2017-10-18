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

/**
 * Exception thrown when the root of the quality models to be distilled cannot
 * be found.
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class RootNotFoundException extends Exception {

    /**
     * Constructs a new RootNotFoundException
     */
    public RootNotFoundException()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new RootNotFoundException with the given message
     * 
     * @param message
     *            The message
     */
    public RootNotFoundException(final String message)
    {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new RootNotFoundException caused by the given Throwable
     * 
     * @param cause
     *            Cause of this RootNotFoundException
     */
    public RootNotFoundException(final Throwable cause)
    {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new RootNotFoundException caused by the given Throwable
     * but with the provided message.
     * 
     * @param message
     *            The message
     * @param cause
     *            Cause of this RootNotFoundException
     */
    public RootNotFoundException(final String message, final Throwable cause)
    {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * Constructs a new RootNotFoundException with the given message and
     * cause, but with capability to enable/disable suppression and indication
     * of whether or not to write to the stack trace.
     * 
     * @param message
     *            The message
     * @param cause
     *            Cause of this RootNotFoundException
     * @param enableSuppression
     *            flag indicating whether or not to suppress this exception
     * @param writableStackTrace
     *            flag indicating whether or not to write to the stack trace
     */
    public RootNotFoundException(final String message, final Throwable cause, final boolean enableSuppression,
            final boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

}
