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
package edu.montana.gsoc.msusel.quamoco.model;

import edu.montana.gsoc.msusel.quamoco.io.XMLSerializable;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import lombok.*;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.UUID;

/**
 * The Impact concept defines an influence of one factor to another. More
 * precisely, an impact specifies that the degree of which a product possesses a
 * factor influences the degree of which the product possesses another factor.
 * The effect of the influence can be either positive or negative. If the impact
 * has a positive effect, the degree of which the product possesses the target
 * factor is heightened if the product possesses the source factor. In contrast,
 * if the impact has a negative effect, the degree of which the target factor is
 * possessed by the product is hindered if the product possesses the source
 * factor. Please note that therefore a positive impact does not mean that the
 * involved factors are required from a quality perspective. For each impact, a
 * rationale, i.e. a detailed justification that describes the impact, needs to
 * be specified. It is crucial to provide a rational, since this ensures that
 * the model contains only relevant impacts.
 * <br>
 * General Rules:
 * <ul>
 * <li>In the base model, impact should only be used between different types of
 * factors. More precisely, only product factors must have an impact on -ilities
 * factors or Use case factors. These two types of factors may have impact on
 * stakeholder satisfaction factors.</li>
 * <li>Justify for each impact, the reason why the factor has a direct effect on
 * the other factor. This is helpful to ensure that a quality model defines only
 * relevant impacts.</li>
 * <li>The justification must have clear why the impact is either positive or
 * negative.</li>
 * </ul>
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
@EqualsAndHashCode(exclude = {"justification"})
@ToString(of = {"identifier", "effect"})
@Builder(buildMethodName = "create")
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Impact implements XMLSerializable {

    /**
     * Provides a textual description of the rational why this impact exists,
     * and why it is either positive or negative
     */
    @Getter
    @Setter
    private String justification;
    /**
     * Describes whether the effect of the impact is positive or negative. If
     * the impact has a positive effect, the degree of which the product
     * possesses the target factor is heightened if the product possesses the
     * source factor. In contrast, if the impact has a negative effect, the
     * degree of which the target factor is possessed by the product is hindered
     * if the product possesses the source factor.
     */
    @Getter
    @Setter
    private InfluenceEffect effect;
    /**
     * The target of this impact
     */
    @Getter
    @Setter
    private Factor target;
    @Getter
    @Setter
    @Builder.Default
    private String identifier = UUID.randomUUID().toString();

    public Impact(String identifier) {
        this.identifier = identifier;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("<influences xmi:id=\"%s\"", getIdentifier()));
        if (getTarget() != null)
            builder.append(String.format(" target=\"%s\"", getTarget().getQualifiedIdentifier()));
        if (getJustification() != null)
            builder.append(String.format(" justification=\"%s\"", StringEscapeUtils.escapeXml10(getJustification())));
        if (getEffect() != null)
            builder.append(String.format(" effect=\"%s\"", getEffect().toString()));
        builder.append(" />\n");

        return builder.toString();
    }
}
