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

import org.eclipse.jdt.annotation.NonNull;

import com.google.common.collect.Lists;

/**
 * A tool is a software program, which is used to collect measurement data. This
 * can be, for example, a static analysis tool.
 * <br>
 * General Rules
 * <ul>
 * <li>Describe the used tool as precisely as possible.</li>
 * <li>You can create different tools for different tool versions, if
 * necessary.</li>
 * <li>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Tool extends QMElement {

    /**
     * Optional title providing a more detailed name than the simple name field
     */
    private String           title;
    /**
     * List of instruments that invoke this tool.
     */
    private List<Instrument> invokedBy;

    /**
     * Constructs a new instance of Tool
     * 
     * @param name
     *            name of the new Tool instance
     */
    public Tool(String name)
    {
        super(name);
        invokedBy = Lists.newArrayList();
    }

    /**
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public void setTitle(String title)
    {
        this.title = title;
    }

    /**
     * @return the invokedBy
     */
    public List<Instrument> getInvokedBy()
    {
        return invokedBy;
    }

    /**
     * Adds an instrument that invokes this tool
     * 
     * @param inst
     *            Instrument using this Tool
     */
    public void addInvokedBy(Instrument inst)
    {
        if (inst == null || invokedBy.contains(inst))
            return;

        invokedBy.add(inst);
    }

    /**
     * Removes an instrument that invoked this tool
     * 
     * @param inst
     *            Instrument which no longer invokes this tool
     */
    public void removeInvokedBy(Instrument inst)
    {
        if (inst == null || !invokedBy.contains(inst))
            return;

        invokedBy.remove(inst);
    }

    /**
     * Creates a new Builder for a Tool with the given simple name
     * 
     * @param name
     *            Simple Name
     * @return the Tool.Builder instance
     */
    public static Builder builder(String name)
    {
        return new Builder(name);
    }

    /**
     * Builder for Tools implemented using the fluent interface and method
     * chaining patterns.
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * Tool element under construction
         */
        private Tool element;

        /**
         * Constructs a new Builder for a Tool with the given name
         * 
         * @param name
         *            The name of the tag to construct
         */
        private Builder(String name)
        {
            element = new Tool(name);
        }

        /**
         * @return The newly constructed Tool element
         */
        @NonNull
        public Tool create()
        {
            return (Tool) element;
        }

        /**
         * Sets the element under construction's description
         * 
         * @param description
         *            the description to set
         * @return this
         */
        @NonNull
        public Builder description(String description)
        {
            element.setDescription(description);

            return this;
        }

        /**
         * Sets the element under construction's originatesFrom
         * 
         * @param originatesFrom
         *            the originatesFrom to set
         * @return this
         */
        public Builder originatesFrom(Source originatesFrom)
        {
            element.setOriginatesFrom(originatesFrom);

            return this;
        }

        /**
         * Sets the element under contruction's tagged by
         * 
         * @param taggedBy
         *            the taggedBy to set
         * @return this
         */
        @NonNull
        public Builder taggedBy(Tag taggedBy)
        {
            element.setTaggedBy(taggedBy);

            return this;
        }

        /**
         * Adds the given annotation to the element under construction.
         * 
         * @param ann
         *            Annotation to add
         * @return this
         */
        @NonNull
        public Builder annotation(Annotation ann)
        {
            element.addAnnotation(ann);

            return this;
        }

        /**
         * Sets the optional title of the Tool under construction
         * 
         * @param title
         *            Title of the Tool
         * @return this
         */
        @NonNull
        public Builder title(String title)
        {
            element.setTitle(title);

            return this;
        }

        /**
         * Adds a User of the Tool under construction
         * 
         * @param user
         *            QMElement which is marked by this Tool
         * @return this
         */
        @NonNull
        public Builder invokedBy(Instrument user)
        {
            element.addInvokedBy(user);

            return this;
        }
    }
}
