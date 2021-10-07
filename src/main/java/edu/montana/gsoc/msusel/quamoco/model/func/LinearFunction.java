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
package edu.montana.gsoc.msusel.quamoco.model.func;

import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public abstract class LinearFunction extends Function {

    @Getter @Setter
    private double lowerBound;
    @Getter @Setter
    private double upperBound;

    public LinearFunction()
    {
        super();
    }

    public LinearFunction(String identifier)
    {
        super(identifier);
    }

    protected LinearFunction(double lowerBound, double upperBound, String identifier, Source originatesFrom, List<Tag> taggedBy, List<Annotation> annotations) {
        super(identifier, originatesFrom, taggedBy, annotations);
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    
    /**
     * @param type
     * @return
     */
    public String generateXMLTag(String type) {
        return String.format(
                "<function xmi:id=\"%s\" xsi:type=\"%s\" lowerBound=\"%f\" upperBound=\"%f\" />%n",
                getIdentifier(), type, getLowerBound(), getUpperBound());
    }
}
