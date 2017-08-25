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
package edu.montana.gsoc.msusel.quamoco.model.qm2;

import java.util.List;

/**
 * Abstract base class of all QMElements. This class contains the basic pieces
 * of all QMElements.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public abstract class QMElement {

    /**
     * Link to where the original information for this element can be found
     */
    protected Source           originatesFrom;
    /**
     * Tag for the element indicating additional information
     */
    protected Tag              taggedBy;
    /**
     * List of annotations
     */
    protected List<Annotation> annotations;
    /**
     * Fully qualified name based on the containing quality model, this is
     * automatically derived.
     */
    protected String           qualifiedName;
    /**
     * This can be used to textually describe and explain the element.
     */
    protected String           description;
    /**
     * A specific name to identify this element
     */
    protected String           name;

    /**
     * Constructs a new QMElement with the given name
     * 
     * @param name
     *            Name of this element
     */
    public QMElement(String name)
    {
        this.name = name;
    }

    /**
     * @return the element's description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the new description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the element's name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the new name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the element's originatesFrom
     */
    public Source getOriginatesFrom()
    {
        return originatesFrom;
    }

    /**
     * @param originatesFrom
     *            the new originatesFrom to set
     */
    public void setOriginatesFrom(Source originatesFrom)
    {
        if (this.originatesFrom != null)
            this.originatesFrom.removeReferencedBy(this);

        this.originatesFrom = originatesFrom;
        this.originatesFrom.addReferencedBy(this);
    }

    /**
     * @return the element's taggedBy
     */
    public Tag getTaggedBy()
    {
        return taggedBy;
    }

    /**
     * @param taggedBy
     *            the new taggedBy to set
     */
    public void setTaggedBy(Tag taggedBy)
    {
        if (this.taggedBy != null)
            this.taggedBy.removeUsedBy(this);

        this.taggedBy = taggedBy;
        taggedBy.addUsedBy(this);
    }

    /**
     * Adds the given annotation to this element, unless the given annotation is
     * null.
     * 
     * @param ann
     *            Annotation to add
     */
    public void addAnnotation(Annotation ann)
    {
        if (ann == null)
            return;

        annotations.add(ann);
    }

    /**
     * Updates the qualified name based on the containing quality model.
     * 
     * @param container
     */
    public void setQualifiedName(QualityModel container)
    {
        if (container != null)
            this.qualifiedName = container.getName() + "." + this.getClass().getSimpleName() + "." + name;
        else
            this.qualifiedName = this.getClass().getSimpleName() + "." + name;
    }

    /**
     * @return This element's fully qualified name
     */
    public String getQualifiedName()
    {
        return qualifiedName;
    }
}
