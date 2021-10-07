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
package edu.montana.gsoc.msusel.quamoco.processor.extents;

import edu.isu.isuese.datamodel.Module;
import edu.isu.isuese.datamodel.System;
import edu.isu.isuese.datamodel.*;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class NodeExtentDecoratorFactory {

    private NodeExtentDecoratorFactory() {

    }

    public static NodeExtentDecoratorFactory getInstance() {
        return Holder.INSTANCE;
    }

    public AbstractExtentDecorator getDecorator(Measurable node) {
        if (node instanceof Type) {
            return new TypeExtentDecorator(node);
        } else if (node instanceof Method) {
            return new MethodExtentDecorator(node);
        } else if (node instanceof File) {
            return new FileExtentDecorator(node);
        } else if (node instanceof Field) {
            return new FieldExtentDecorator(node);
        } else if (node instanceof Module) {
            return new ModuleExtentDecorator(node);
        } else if (node instanceof Namespace) {
            return new NamespaceExtentDecorator(node);
        } else if (node instanceof Project) {
            return new ProjectNodeExtentDecorator(node);
        } else if (node instanceof PatternInstance) {
            return new PatternInstanceExtentDecorator(node);
        } else if (node instanceof System) {
            return new SystemExtentDecorator(node);
        } else if (node instanceof Literal) {
            return new LiteralExtentDecorator(node);
        } else if (node instanceof Initializer) {
            return new InitializerExtentDecorator(node);
        }
        else {
            return new FileExtentDecorator(node);
        }
    }

    private static final class Holder {
        private static final NodeExtentDecoratorFactory INSTANCE = new NodeExtentDecoratorFactory();
    }
}