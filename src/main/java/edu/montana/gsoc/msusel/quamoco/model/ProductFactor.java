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
package edu.montana.gsoc.msusel.quamoco.model;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import edu.montana.gsoc.msusel.quamoco.io.FactorType;
import lombok.Builder;
import lombok.Singular;

import javax.annotation.Nonnull;
import java.io.StringWriter;
import java.util.List;

/**
 * Product factors are properties of specific parts of the software product.
 * These parts are specified as artifacts or product entities, such as,
 * Conciseness or Appropriateness.
 *
 * Use product factors to characterize parts of the software.
 * A product factor must make sense, without referring to the impact.
 * Positive example: [Structuredness @Expression].
 * The structuredness is defined, independent of the impact it has on
 * understandability.
 *
 * Negative example: [Efficiency @Expression].
 * You should not introduce this factor and use it to collect all measures that
 * have an impact on performance. Not doing so, assures that a new measure can
 * be uniquely assigned to a factor, without having in mind its impact.
 *
 * An impact of a product-factor to a product quality attribute or a quality
 * in use factor should point to a leaf in the hierarchy.
 * This way it is assured that a justification is given for each of the impacted
 * factors.
 * Example: Instead of modeling an impact to [Maintainability] you should model
 * two impacts to [Analyzability], [Modifyability] and give a special
 * justification for both of them. If you would only model one impact to
 * [Maintainability] the justification is less clearer.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ProductFactor extends Factor {

    /**
     * Constructs a new ProductFactor with the given name
     * 
     * @param name
     *            The name
     */
    public ProductFactor(String name)
    {
        super(name);
    }

    /**
     * @param name
     * @param identifier
     */
    public ProductFactor(String name, String identifier)
    {
        super(name, identifier);
    }

    @lombok.Builder(buildMethodName = "create")
    public ProductFactor(String name, String description, Entity characterizes, String title, @Singular List<Impact> influences, Factor refines,
                String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations)
    {
        super(name, description, characterizes, title,influences, refines,
                identifier, originatesFrom, tags, annotations);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        return generateXMLTag(FactorType.PRODUCT_FACTOR.type());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toScript()
    {
        // TODO Auto-generated method stub
        return null;
    }
}
