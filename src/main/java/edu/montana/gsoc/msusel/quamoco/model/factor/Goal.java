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
package edu.montana.gsoc.msusel.quamoco.model.factor;

import edu.montana.gsoc.msusel.quamoco.io.factories.FactorType;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.Impact;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import lombok.Builder;
import lombok.Singular;

import java.util.List;
import java.util.Map;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class Goal extends Factor {

    /**
     * @param name
     */
    public Goal(String name) {
        super(name);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param name
     * @param identifier
     */
    public Goal(String name, String identifier) {
        super(name, identifier);
    }

    @Builder(buildMethodName = "create")
    protected Goal(String name, String description, Entity characterizes, String title, @Singular Map<String, Impact> influences, Factor refines,
                   String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(name, description, characterizes, title, influences, refines,
                identifier, originatesFrom, tags, annotations);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        return generateXMLTag(FactorType.GOAL.type());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toScript() {
        // TODO Auto-generated method stub
        return null;
    }
}
