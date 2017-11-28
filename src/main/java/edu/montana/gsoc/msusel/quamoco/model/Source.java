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

import javax.annotation.Nonnull;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;
import java.util.Map;

/**
 * A source is a reference document that is the basis for the model element it
 * is associated with. For example, the quality attributes from ISO 25010 are
 * associated with the this source description.
 * <br>
 * General Rules:
 * <ul>
 * <li>Always when you take existing text or knowledge from a reference, cite it
 * with the corresponding source.</li>
 * <li>Source can be referenced by various model elements (e.g. Entities,
 * Factors, or Measures).</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Source extends QMElement {

    /**
     * An optional title providing a more detailed name of this Source
     */
    @Getter @Setter
    private String title;
    /**
     * 
     */
    @Getter @Setter
    private String description;
    @Getter @Setter
    private String name;

    /**
     * Constructs a new instance of Source
     * 
     * @param name
     *            name of the new Source instance
     */
    public Source(String name)
    {
        super();
        this.name = name;
    }

    /**
     * Constructs a new instance of Source
     * 
     * @param name
     *            name of the new Source instance
     * @param identifier
     *            unique identifier of this Source
     */
    public Source(String name, String identifier)
    {
        super(identifier);
        this.name = name;
    }

    @Builder(buildMethodName = "create")
    protected Source(String name, String description, String title, String identifier, Source originatesFrom, @Singular List<Tag> tags, @Singular List<Annotation> annotations)
    {
        super(identifier, originatesFrom, tags, annotations);
        this.name = name;
        this.description = description;
        this.title = title;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        Map<String, String> attrs = Maps.newHashMap();

        attrs.put("name", StringEscapeUtils.escapeXml10(getName()));
        attrs.put("description", StringEscapeUtils.escapeXml10(getDescription()));
        attrs.put("title", StringEscapeUtils.escapeXml10(getTitle()));

        return generateXMLTag("sources", null, attrs, Lists.newArrayList());
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
