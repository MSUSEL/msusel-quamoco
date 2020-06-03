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

import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.apache.commons.lang3.StringEscapeUtils;

import java.util.List;

/**
 * A tag is a keyword that can be added to model elements.
 * <br>
 * General Rules:
 * <ul>
 * <li>Tags can be assigned to various model elements (e.g. Entities, Factors,
 * or Measures).</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class Tag extends QMElement {

    /**
     * Optional title providing a more detailed name for this Tag
     */
    @Getter @Setter
    private String title;
    @Getter @Setter
    private String description;
    @Getter @Setter
    private String name;

    /**
     * Constructs a new instance of Tag
     * 
     * @param name
     *            name of the new Tag instance
     */
    private Tag(String name)
    {
        super();
        this.name = name;
    }

    /**
     * Constructs a new instance of Tag
     * 
     * @param name
     *            name of the new Tag instance
     * @param identifier
     *            the unique identifier
     */
    public Tag(String name, String identifier)
    {
        super(identifier);
        this.name = name;
    }

    @Builder(buildMethodName = "create")
    protected Tag(String name, String description, String title, String identifier, Source originatesFrom, @Singular List<Annotation> annotations)
    {
        super(identifier, originatesFrom, Lists.newArrayList(), annotations);
        this.name = name;
        this.description = description;
        this.title = title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Tag> getTaggedBy()
    {
        return Lists.newArrayList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addTaggedBy(Tag tag)
    {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeTaggedBy(Tag tag)
    {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        return String.format(
                "<tags xmi:id=\"%s\" name=\"%s\" description=\"%s\" />%n", getIdentifier(), StringEscapeUtils.escapeXml10(getName()),
                StringEscapeUtils.escapeXml10(getDescription()));
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
