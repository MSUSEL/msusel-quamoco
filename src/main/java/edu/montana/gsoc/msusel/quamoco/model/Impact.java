/**
 * The MIT License (MIT)
 *
 * SparQLine Quamoco Implementation
 * Copyright (c) 2015-2017 Isaac Griffith, SparQLine Analytics, LLC
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

import java.util.UUID;
import javax.annotation.Nonnull;

import edu.montana.gsoc.msusel.quamoco.io.XMLSerializable;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * The Impact concept defines an influence of one factor to another. More
 * precisely, an impact specifies that the degree of which a product possesses a
 * factor influences the degree of which the product possesses another factor.
 * The effect of the influence can be either positive or negative. If the impact
 * has a positive effect, the degree of which the product possesses the target
 * factor is heightened if the product possesses the source factor. In contrast,
 * if the impact has a negative effect, the degree of which the target factor is
 * possessed by the product is hindered if the product possesses the source
 * factor. Please note that therefore a positive impact does not mean that the
 * involved factors are required from a quality perspective. For each impact, a
 * rationale, i.e. a detailed justification that describes the impact, needs to
 * be specified. It is crucial to provide a rational, since this ensures that
 * the model contains only relevant impacts.
 * <br>
 * General Rules:
 * <ul>
 * <li>In the base model, impact should only be used between different types of
 * factors. More precisely, only product factors must have an impact on -ilities
 * factors or Use case factors. These two types of factors may have impact on
 * stakeholder satisfaction factors.</li>
 * <li>Justify for each impact, the reason why the factor has a direct effect on
 * the other factor. This is helpful to ensure that a quality model defines only
 * relevant impacts.</li>
 * <li>The justification must have clear why the impact is either positive or
 * negative.</li>
 * </ul>
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class Impact implements XMLSerializable {

    /**
     * Provides a textual description of the rational why this impact exists,
     * and why it ieither positive or negative
     */
    private String          justification;
    /**
     * Describes whether the effect of the impact is positive or negative. If
     * the impact has a positive effect, the degree of which the product
     * possesses the target factor is heightened if the product possesses the
     * source factor. In contrast, if the impact has a negative effect, the
     * degree of which the target factor is possessed by the product is hindered
     * if the product possesses the source factor.
     */
    private InfluenceEffect effect;
    /**
     * The target of this impact
     */
    private Factor          target;
    private String          identifier;

    public Impact()
    {
        identifier = UUID.randomUUID().toString();
    }

    public Impact(String identifier)
    {
        this.identifier = identifier;
    }

    /**
     * @return the identifier
     */
    public String getIdentifier()
    {
        return identifier;
    }

    /**
     * @param identifier
     *            the identifier to set
     */
    public void setIdentifier(String identifier)
    {
        this.identifier = identifier;
    }

    /**
     * @return the effect
     */
    public InfluenceEffect getEffect()
    {
        return effect;
    }

    /**
     * @param effect
     *            the effect to set
     */
    public void setEffect(InfluenceEffect effect)
    {
        this.effect = effect;
    }

    /**
     * @return the justification
     */
    public String getJustification()
    {
        return justification;
    }

    /**
     * @param justification
     *            the justification to set
     */
    public void setJustification(String justification)
    {
        this.justification = justification;
    }

    /**
     * @return the target
     */
    public Factor getTarget()
    {
        return target;
    }

    /**
     * @param target
     *            the target to set
     */
    public void setTarget(Factor target)
    {
        this.target = target;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag()
    {
        StringBuilder builder = new StringBuilder();
        
        builder.append(
                String.format(
                        "<influences xmi:id=\"%s\" target=\"%s\" justification=\"%s\" effect=\"%s\" />%n",
                        getIdentifier(), getTarget().getQualifiedIdentifier(),
                        StringEscapeUtils.escapeXml10(getJustification()), getEffect().toString()));

        return builder.toString();
    }

    /**
     * Returns a builder used to construct an Impact via method chaining and a
     * fluent interface
     * 
     * @return the builder
     */
    public static Builder builder()
    {
        return new Builder();
    }

    /**
     * Returns a builder used to construct an Impact with the given identifier
     * via method chaining and a fluent interface
     * 
     * @param identifier
     *            Unique identifier of the Impact to be created
     * @return The builder
     */
    public static Builder builder(String identifier)
    {
        return new Builder(identifier);
    }

    /**
     * Builder for Impact Objects
     * 
     * @author Isaac Griffith
     * @version 1.1.1
     */
    public static class Builder {

        /**
         * Impact object to be created.
         */
        private Impact impact;

        /**
         * Constructs a new Impact Builder
         */
        public Builder()
        {
            impact = new Impact();
        }

        /**
         * Constructs a new Impact Builder for an Impact object with the given
         * identifier
         * 
         * @param identifier
         *            Unique Identifier
         */
        public Builder(String identifier)
        {
            impact = new Impact(identifier);
        }

        /**
         * @return The impact newly built by this builder
         */
        public Impact create()
        {
            return impact;
        }

        /**
         * Sets the target of the Impact being built.
         * 
         * @param factor
         *            The target Factor
         * @return this
         */
        @Nonnull
        public Builder target(Factor factor)
        {
            impact.setTarget(factor);

            return this;
        }

        /**
         * Sets the effect (positive or negative) of the Impact being built
         * 
         * @param effect
         *            Effect of the Impact
         * @return this
         */
        @Nonnull
        public Builder effect(InfluenceEffect effect)
        {
            impact.setEffect(effect);

            return this;
        }

        /**
         * Sets the text justification of the Impact being built.
         * 
         * @param just
         *            The text justification.
         * @return this
         */
        @Nonnull
        public Builder justification(String just)
        {
            impact.setJustification(just);

            return this;
        }
    }
}
