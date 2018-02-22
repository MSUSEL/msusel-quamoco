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
package edu.montana.gsoc.msusel.quamoco.model.measure;

import edu.montana.gsoc.msusel.quamoco.io.MeasuresType;
import edu.montana.gsoc.msusel.quamoco.model.*;
import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

/**
 * A special measure that is thought for normalizing when evaluating based on
 * measures. Normalization measures can be used for the evaluations of all
 * factors although they are not defined there.
 * <br>
 * General Rules:
 * <ul>
 * <li>Introduce normalization measures if a measure is necessary for
 * normalizing other measures</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class NormalizationMeasure extends Measure {

    /**
     * Constructs a new NormalizationMeasure with the given name
     * 
     * @param name
     *            The name of the NormalizationMeasure
     */
    public NormalizationMeasure(String name)
    {
        super(name);
    }

    /**
     * Constructs a new NormalizationMeasure with the given name
     * 
     * @param name
     *            The name of the NormalizationMeasure
     */
    public NormalizationMeasure(String name, String identifier)
    {
        super(name, identifier);
    }

    @Builder(buildMethodName = "create", builderMethodName = "normBuilder")
    protected NormalizationMeasure(String name, String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations,
                                   String title, String description, Entity characterizes, Measure refines, @Singular List<Factor> measures, MeasureType type) {
        super(name, identifier, originatesFrom, tags, annotations, title, description, characterizes, refines, measures, type);
    }

    /**
     * @return the normalizer
     */
    public boolean isNormalizer()
    {
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        return xmlTag(MeasuresType.NORMALIZATION_MEASURE.type());
    }
}
