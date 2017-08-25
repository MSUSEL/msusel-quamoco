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

/**
 * A special measure that is thought for normalizing when evaluating based on
 * measures. Normalization measures can be used for the evaluations of all
 * factors although they are not defined there.
 * <br>
 * General Rules:
 * <ul>
 * <li>Introduce normalization measures if a measure is necessary for
 * normalizing other measures</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class NormalizationMeasure extends Measure {

    /**
     * Constructs a new NormalizationMeasure with the given name
     * 
     * @param name
     *            The name of the NormalizationMeasure
     */
    public NormalizationMeasure(String name)
    {
        super(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isNormalizer()
    {
        return true;
    }

    // /**
    // * Creates a new Builder for a Measure with the given simple name.
    // *
    // * @param name
    // * Simple Name
    // * @return the NormalizationMeasure.Builder instance
    // */
    // public static Builder builder(String name)
    // {
    // return new Builder(name);
    // }
    //
    // /**
    // * Builder for Measures implemented using the fluent interface and method
    // * chaining patterns.
    // *
    // * @author Isaac Griffith
    // * @version 1.1.1
    // */
    // public static class Builder {
    //
    // /**
    // * NormalizationMeasure element under construction
    // */
    // private NormalizationMeasure element;
    //
    // /**
    // * Creates a new Builder for a Measure with the given simple name.
    // *
    // * @param name
    // * Simple Name
    // * @return the NormalizationMeasure.Builder instance
    // */
    // private Builder(String name)
    // {
    // element = new NormalizationMeasure(name);
    // }
    //
    // /**
    // * @return The newly constructed NormalizationMeasure element
    // */
    // @NonNull
    // public NormalizationMeasure create()
    // {
    // return element;
    // }
    //
    // /**
    // * Sets the element under construction's description
    // *
    // * @param description
    // * the description to set
    // * @return this
    // */
    // @NonNull
    // public Builder description(String description)
    // {
    // element.setDescription(description);
    //
    // return this;
    // }
    //
    // /**
    // * Sets the element under construction's originatesFrom
    // *
    // * @param originatesFrom
    // * the originatesFrom to set
    // * @return this
    // */
    // public Builder originatesFrom(Source originatesFrom)
    // {
    // element.setOriginatesFrom(originatesFrom);
    //
    // return this;
    // }
    //
    // /**
    // * Sets the element under contruction's tagged by
    // *
    // * @param taggedBy
    // * the taggedBy to set
    // * @return this
    // */
    // @NonNull
    // public Builder taggedBy(Tag taggedBy)
    // {
    // element.setTaggedBy(taggedBy);
    //
    // return this;
    // }
    //
    // /**
    // * Adds the given annotation to the element under construction.
    // *
    // * @param ann
    // * Annotation to add
    // * @return this
    // */
    // @NonNull
    // public Builder annotation(Annotation ann)
    // {
    // element.addAnnotation(ann);
    //
    // return this;
    // }
    //
    // /**
    // * Sets the entity characterized by this measure
    // *
    // * @param ent
    // * Entity characterized
    // * @return this
    // */
    // @NonNull
    // public Builder characterizes(Entity ent)
    // {
    // element.setCharacterizes(ent);
    //
    // return this;
    // }
    //
    // /**
    // * Sets the given measure as a measure which the measure under
    // * construction refines. And adds the measure under construction to the
    // * given measure's refined-by list
    // *
    // * @param measure
    // * Measure refined-by the measure under construction
    // * @return this
    // */
    // @NonNull
    // public Builder refines(Measure measure)
    // {
    // element.addRefines(measure);
    // measure.addRefinedBy(element);
    //
    // return this;
    // }
    //
    // /**
    // * Sets the given measure as a measure refining the measure under
    // * construction and updates the measure under construction's list of
    // * refined-by measures.
    // *
    // * @param measure
    // * Measure refining the measure under construction
    // * @return this
    // */
    // @NonNull
    // public Builder refinedBy(Measure measure)
    // {
    // element.addRefinedBy(measure);
    // measure.addRefines(element);
    //
    // return this;
    // }
    //
    // /**
    // * Sets the title of the measure under construction
    // *
    // * @param title
    // * New title
    // * @return this
    // */
    // @NonNull
    // public Builder title(String title)
    // {
    // element.setTitle(title);
    //
    // return this;
    // }
    //
    // /**
    // * Sets the type of the measure under construction to the given measure
    // * type
    // *
    // * @param type
    // * Measure type
    // * @return this
    // */
    // @NonNull
    // public Builder type(MeasureType type)
    // {
    // element.setType(type);
    //
    // return this;
    // }
    // }
}
