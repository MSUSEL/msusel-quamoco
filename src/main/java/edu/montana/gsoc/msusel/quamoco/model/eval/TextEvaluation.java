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
package edu.montana.gsoc.msusel.quamoco.model.eval;

import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.io.factories.EvaluationType;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;
import java.util.Map;

/**
 * An evaluation where the specification is a semi-formal text.
 * <br>
 * General Rules:
 * <ul>
 * <li>Within one model, the textual specification should be used consistently
 * and marked out by a telling name.</li>
 * </ul>
 *
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class TextEvaluation extends Evaluation {

    /**
     * The textual specification can be used for writing any syntax; thus the
     * text will not be evaluated.
     */
    @Getter @Setter
    private String specification;

    /**
     *
     */
    public TextEvaluation() {
        super();
    }

    public TextEvaluation(String identifier) {
        super(identifier);
    }

    @Builder(buildMethodName = "create")
    protected TextEvaluation(String name, String specification, Double completeness, Double maximumPoints, String title, String description, Factor evaluates,
                             String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(name, completeness, maximumPoints, title, description, evaluates, identifier, originatesFrom, tags, annotations);
        this.specification = specification;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double evaluate() {
        throw new RuntimeException("Not yet implemented");
    }

    protected String xmlTag(String type) {
        String tag = "evaluations";
        Map<String, String> attrs = Maps.newHashMap();

        if (getSpecification() != null)
            attrs.put("specification", StringEscapeUtils.escapeXml10(getSpecification()));

        return generateXMLTag(type, attrs);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        return xmlTag(EvaluationType.TEXT_EVALUATION.type());
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
