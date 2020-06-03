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
package edu.montana.gsoc.msusel.quamoco.io.factories;

import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.func.Function;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearDecreasingFunction;
import edu.montana.gsoc.msusel.quamoco.model.func.LinearIncreasingFunction;
import org.w3c.dom.Element;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class FunctionFactory extends AbstractQMElementFactory {

    private FunctionFactory() {
        super();
    }

    private final static class Holder {

        public static final FunctionFactory INSTANCE = new FunctionFactory();
    }
    public static FunctionFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public QMElement create(Element e, ModelManager manager) {
        Function function = null;
        this.manager = manager;

        if (e.hasAttribute("xsi:type"))
        {
            FunctionType type = FunctionType.fromType(e.getAttribute("xsi:type"));
            switch (type) {
                case LINEAR_INCREASING:
                    function = createLinearIncreasingFunction(e);
                    break;
                case LINEAR_DECREASING:
                    function = createLinearDecreasingFunction(e);
                    break;
            }
        }

        return function;
    }

    private Function createLinearDecreasingFunction(Element e) {
        return LinearDecreasingFunction.builder()
                .identifier(e.getAttribute("xmi:id"))
                .lowerBound(e.hasAttribute("lowerBound") ? Double.valueOf(e.getAttribute("lowerBound")) : 0.0)
                .upperBound(e.hasAttribute("upperBound") ? Double.valueOf(e.getAttribute("upperBound")) : 1.0)
                .create();
    }

    private Function createLinearIncreasingFunction(Element e) {
        return LinearIncreasingFunction.builder()
                .identifier(e.getAttribute("xmi:id"))
                .lowerBound(e.hasAttribute("lowerBound") ? Double.valueOf(e.getAttribute("lowerBound")) : 0.0)
                .upperBound(e.hasAttribute("upperBound") ? Double.valueOf(e.getAttribute("upperBound")) : 1.0)
                .create();
    }
}
