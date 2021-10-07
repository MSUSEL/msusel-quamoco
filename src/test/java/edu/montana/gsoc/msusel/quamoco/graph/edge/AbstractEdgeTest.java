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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The class <code>AbstractEdgeTest</code> contains tests for the class
 * <code>{@link AbstractEdge}</code>.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class AbstractEdgeTest {

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_2() {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge3();
		final Object obj = null;

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertFalse(result);
	}

	/**
	 * Run the boolean equals(Object) method test.
	 */
	@Test
	public void testEquals_3() {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge4();
		final Object obj = new Object();

		final boolean result = fixture.equals(obj);

		// TODO: add additional test code here
		Assert.assertFalse(result);
	}

	/**
	 * Run the long getId() method test.
	 */
	@Test
	public void testGetId_1() {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge();
		final long id = 1;
		fixture.setId(id);
		final long result = fixture.getId();

		// TODO: add additional test code here
		Assert.assertEquals(id, result);
	}

	/**
	 * Run the String getName() method test.
	 */
	@Test
	public void testGetName_1() {
		final AbstractEdge fixture = AbstractEdgeFactory.createAbstractEdge2();

		final String result = fixture.getName();

		// TODO: add additional test code here
		Assert.assertEquals("", result);
	}
}