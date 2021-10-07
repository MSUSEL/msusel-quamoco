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
package edu.montana.gsoc.msusel.quamoco.model.measurement.aggregation;

import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.io.factories.MeasurementMethodType;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import lombok.Builder;
import lombok.Singular;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;
import java.util.Map;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class QIESLAggregation extends TextAggregation {

    /**
     * /**
     * Constructs a new QIESLAggregation.
     */
    public QIESLAggregation() {
        super();
    }

    /**
     * Constructs a new QIESLAggregation with the given unique
     * identifier.
     *
     * @param identifier The unique identifier
     */
    public QIESLAggregation(String identifier) {
        super(identifier);
    }

    @Builder(buildMethodName = "create", builderMethodName = "qieslBuilder")
    protected QIESLAggregation(String specification, @Singular List<Measure> aggregates, Measure determines, String metric, String description, String title,
                               String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations) {
        super(specification, aggregates, determines, metric, description, title, identifier, originatesFrom, tags, annotations);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        Map<String, String> attrMap = Maps.newHashMap();
        attrMap.put("specification", StringEscapeUtils.escapeXml10(getSpecification()));
        return generateXMLTag(MeasurementMethodType.QIESL_AGGREGATION.type(), attrMap);
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
