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
package edu.montana.gsoc.msusel.quamoco.graph.edge;

import edu.montana.gsoc.msusel.quamoco.graph.edge.AbstractEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FactorToFactorEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.FindingToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToFactorNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureFindingsNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.edge.ValueToMeasureEdge;
import edu.montana.gsoc.msusel.quamoco.model.InfluenceEffect;

/**
 * The class <code>AbstractEdgeFactory</code> implements static methods that
 * return instances of the class <code>{@link AbstractEdge}</code>.
 *
 * @generatedBy CodePro at 5/30/15 3:23 PM
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class AbstractEdgeFactory {

	/**
	 * Prevent creation of instances of this class.
	 *
	 * @generatedBy CodePro at 5/30/15 3:23 PM
	 */
	private AbstractEdgeFactory() {
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:23 PM
	 */
	public static AbstractEdge createAbstractEdge() {
		return new FactorToFactorEdge("", null, null, InfluenceEffect.POSITIVE);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:23 PM
	 */
	public static AbstractEdge createAbstractEdge2() {
		return new FindingToMeasureEdge("", null, null);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:23 PM
	 */
	public static AbstractEdge createAbstractEdge3() {
		return new MeasureToFactorFindingsEdge("", null, null, InfluenceEffect.POSITIVE);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:23 PM
	 */
	public static AbstractEdge createAbstractEdge4() {
		return new ValueToMeasureEdge("", null, null);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:24 PM
	 */
	public static AbstractEdge createAbstractEdge5() {
		return new MeasureToFactorNumberEdge("", null, null, InfluenceEffect.POSITIVE);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:24 PM
	 */
	public static AbstractEdge createAbstractEdge6() {
		return new MeasureToMeasureFindingsEdge("", null, null);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:24 PM
	 */
	public static AbstractEdge createAbstractEdge7() {
		return new MeasureToMeasureNumberEdge("", null, null);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:24 PM
	 */
	public static AbstractEdge createAbstractEdge8() {
		return new MeasureToMeasureFindingsNumberEdge("", null, null);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:23 PM
	 */
	public static AbstractEdge createAbstractEdge9() {
		return new FactorToFactorEdge("", null, null, InfluenceEffect.POSITIVE);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:23 PM
	 */
	public static AbstractEdge createAbstractEdge10() {
		return new FindingToMeasureEdge("", null, null);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:23 PM
	 */
	public static AbstractEdge createAbstractEdge11() {
		return new MeasureToFactorFindingsEdge("", null, null, InfluenceEffect.POSITIVE);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:23 PM
	 */
	public static AbstractEdge createAbstractEdge12() {
		return new ValueToMeasureEdge("", null, null);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:24 PM
	 */
	public static AbstractEdge createAbstractEdge13() {
		return new MeasureToFactorNumberEdge("", null, null, InfluenceEffect.POSITIVE);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:24 PM
	 */
	public static AbstractEdge createAbstractEdge14() {
		return new MeasureToMeasureFindingsEdge("", null, null);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:24 PM
	 */
	public static AbstractEdge createAbstractEdge15() {
		return new MeasureToMeasureNumberEdge("", null, null);
	}

	/**
	 * Create an instance of the class <code>{@link AbstractEdge}</code>.
	 *
	 * @generatedBy CodePro at 5/30/15 3:24 PM
	 */
	public static AbstractEdge createAbstractEdge16() {
		return new MeasureToMeasureFindingsNumberEdge("", null, null);
	}
}