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
package edu.montana.gsoc.msusel.quamoco.model.qm;

import java.util.List;

import com.google.common.collect.Lists;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import edu.montana.gsoc.msusel.quamoco.model.AbstractEntity;

/**
 * AbstractQMEntity -
 *
 * @author Isaac Griffith
 */
public abstract class AbstractQMEntity extends AbstractEntity {

    @XStreamAlias("description")
    @XStreamAsAttribute
    protected String                 description;
    @XStreamAlias("name")
    @XStreamAsAttribute
    protected String                 name;
    @XStreamImplicit
    protected final List<Annotation> annotations;

    /**
     *
     */
    public AbstractQMEntity()
    {
        description = "";
        annotations = Lists.newArrayList();
    }

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(final String description)
    {
        if (description == null)
        {
            throw new IllegalArgumentException();
        }

        this.description = description;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    /**
     * @param annotation
     *            the annotation to set
     */
    public void addAnnotation(final Annotation annotation)
    {
        if (annotation == null || annotations.contains(annotation))
        {
            return;
        }

        annotations.add(annotation);
    }

    /**
     * @param annotation
     */
    public void removeAnnotation(final Annotation annotation)
    {
        if (annotation == null || !annotations.contains(annotation))
        {
            return;
        }

        annotations.remove(annotations);
    }

    /**
     * @return the annotation
     */
    public List<Annotation> getAnnotations()
    {
        return annotations;
    }
}
