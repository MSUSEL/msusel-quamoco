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
 * A quality model is the basic module of Quamoco quality models. A quality
 * model contains entities, factors, measures, evaluations, aggregations, tools,
 * and tags. It is a means for structuring the complete model into sensible
 * parts. Usually, a quality model defines a quality model for a specific
 * technology and depends on the root model.
 * <br>
 * General Rules:
 * <ul>
 * <li>Build a separate quality model for each technology.</li>
 * <li>Set a dependency on the root model and other appropriate models. For
 * example, a quality model for Java should also depend on the object-oriented
 * quality model.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class QualityModel {

    private String                  qualifiedName;
    /**
     * A textual explanation what the model contains.
     */
    private String                  description;
    /**
     * The name of a model should represent the content of the model. For
     * example, if it describes factors for the programming language Java, it
     * should be called Java.
     * If there is no specific reason to do otherwise, only captialise the first
     * word in the name.
     */
    private String                  name;
    /**
     * The title is a more elaborated/detailed name for the model.
     * This is optional.
     * If there is no specific reason to do otherwise, only captialise the first
     * word in the title.
     */
    private String                  title;
    /**
     * 
     */
    private Source                  originatesFrom;
    /**
     * 
     */
    private Tag                     taggedBy;
    /**
     * 
     */
    private List<Entity>            entities;
    /**
     * 
     */
    private List<Factor>            factors;
    /**
     * 
     */
    private List<Evaluation>        evaluations;
    /**
     * 
     */
    private List<Measure>           measures;
    /**
     * 
     */
    private List<MeasurementMethod> methods;
    /**
     * 
     */
    private List<Instrument>        tools;
    /**
     * 
     */
    private List<Tag>               tags;
    /**
     * 
     */
    private List<Source>            sources;
    /**
     * The quality models the current quality model depends on. These models
     * will be loaded together with the current model
     * You can only link in any way from the current model to models that are in
     * this requires list.
     */
    private List<QualityModel>      requires;

    /**
     * @return the description
     */
    public String getDescription()
    {
        return description;
    }

    /**
     * @param description
     *            the description to set
     */
    public void setDescription(String description)
    {
        this.description = description;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the originatesFrom
     */
    public Source getOriginatesFrom()
    {
        return originatesFrom;
    }

    /**
     * @param originatesFrom
     *            the originatesFrom to set
     */
    public void setOriginatesFrom(Source originatesFrom)
    {
        this.originatesFrom = originatesFrom;
    }

    /**
     * @return the sources
     */
    public List<Source> getSources()
    {
        return sources;
    }

    /**
     * @param sources
     *            the sources to set
     */
    public void setSources(List<Source> sources)
    {
        this.sources = sources;
    }

}
