/**
 * The MIT License (MIT)
 * <p>
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.quamoco.model;

import javax.annotation.Nonnull;

import edu.montana.gsoc.msusel.quamoco.io.FactorType;
import lombok.Builder;
import lombok.Singular;

import java.util.List;

/**
 * Product quality attributes define one way to decompose the abstract concept
 * software quality. These quality attributes, as given in ISO 25010, relate to
 * the quality of the product without explicitly considering its use. These
 * quality attributes are colloquially called -illities, because they contain,
 * for example, reliability or maintainability. In the standard, the top level
 * attributes are refined by so-called quality characteristics.
 * <ul>
 * <li>Product quality attributes model the -ilities of the ISO 25010.</li>
 * <li>These factors do characterize the entity Product.</li>
 * </ul>
 *
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class ProductQualityAttribute extends QualityAspect {

    /**
     * Constructs a new ProductQualityAttribute with the given name
     *
     * @param name
     *            The name
     */
    public ProductQualityAttribute(String name) {
        super(name);
    }

    /**
     * @param name
     * @param identifier
     */
    public ProductQualityAttribute(String name, String identifier) {
        super(name, identifier);
    }

    @Builder(buildMethodName = "create")
    protected ProductQualityAttribute(String name, String description, Entity characterizes, String title, @Singular List<Impact> influences, Factor refines,
                                      String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(name, description, characterizes, title, influences, refines,
                identifier, originatesFrom, tags, annotations);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        return generateXMLTag(FactorType.PRODUCT_QUALITY_ATTRIBUTE.type());
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
