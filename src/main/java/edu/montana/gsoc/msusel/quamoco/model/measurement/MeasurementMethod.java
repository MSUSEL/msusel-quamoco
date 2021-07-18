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
package edu.montana.gsoc.msusel.quamoco.model.measurement;

import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.model.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.QMElement;
import edu.montana.gsoc.msusel.quamoco.model.Source;
import edu.montana.gsoc.msusel.quamoco.model.Tag;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.apache.commons.lang3.StringEscapeUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public abstract class MeasurementMethod extends QMElement {

    @Getter
    @Setter
    protected Measure determines;
    @Setter
    @Getter
    protected String name;
    @Getter
    @Setter
    protected String description;
    @Getter
    @Setter
    protected String title;
    @Getter
    @Setter
    protected String modelName;

    public MeasurementMethod(String name) {
        super();
        this.name = name;
    }

    public MeasurementMethod(String name, String identifier) {
        super(identifier);
        this.name = name;
    }

    protected MeasurementMethod(Measure determines, String name, String description, String title,
                                String identifier, Source originatesFrom, @Singular List<Tag> tags,
                                @Singular List<Annotation> annotations)
    {
        super(identifier, originatesFrom, tags, annotations);
        this.determines = determines;
        this.name = name;
        this.description = description;
        this.title = title;
    }

    public String getFullName() {
        StringBuilder builder = new StringBuilder();
        if (modelName != null) {
            builder.append(modelName);
            builder.append(File.separator);
        }
        if (determines != null) {
            builder.append(determines.getFullName());
            builder.append(File.separator);
        }
        builder.append(name);

        return builder.toString();
    }

    public String generateXMLTag(String type) {
        return generateXMLTag(type, Maps.newHashMap());
    }

    protected String generateXMLTag(String type, Map<String, String> attrMap) {
        StringBuilder builder = new StringBuilder();

        builder.append(String.format("<measurementMethods xmi:id=\"%s\"", getIdentifier()));
        builder.append(String.format(" xsi:type=\"%s\"", type));
        if (getDescription() != null)
            builder.append(String.format(" description=\"%s\"", StringEscapeUtils.escapeXml10(getDescription())));
        if (getOriginatesFrom() != null)
            builder.append(String.format(" originatesFrom=\"%s\"", getOriginatesFrom().getQualifiedIdentifier()));
        if (getName() != null)
            builder.append(String.format(" name=\"%s\"", StringEscapeUtils.escapeXml10(getName())));
        if (getQualifiedIdentifier() != null)
            builder.append(String.format(" determines=\"%s\"", getDetermines().getQualifiedIdentifier()));
        attrMap.forEach((key, value) -> {
            if (value != null) builder.append(String.format(" %s=\"%s\"", key, value));
        });

        if (hasAnnotations()) {
            builder.append(">\n");
            annotations.forEach((ann) -> builder.append(ann.xmlTag()));
            builder.append("</measurementMethods>\n");
        } else {
            builder.append(" />\n");
        }

        return builder.toString();
    }
}
