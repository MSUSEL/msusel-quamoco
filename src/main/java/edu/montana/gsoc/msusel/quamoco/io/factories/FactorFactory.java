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
package edu.montana.gsoc.msusel.quamoco.io.factories;

import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import edu.montana.gsoc.msusel.quamoco.model.factor.*;
import org.w3c.dom.Element;

/**
 * @author Isaac Griffith
 * @version 1.3.0
 */
public class FactorFactory extends AbstractQMElementFactory {

    /**
     * 
     */
    private FactorFactory()
    {

    }

    /**
     * @author Isaac Griffith
     */
    private static class Holder {

        /**
         * 
         */
        private static final FactorFactory INSTANCE = new FactorFactory();
    }

    /**
     * @return
     */
    public static FactorFactory instance()
    {
        return Holder.INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Factor create(Element e, ModelManager manager)
    {
        Factor factor = null;
        this.manager = manager;

        if (e.hasAttribute("xsi:type"))
        {
            FactorType type = FactorType.fromType(e.getAttribute("xsi:type"));
            switch (type)
            {
            case PRODUCT_QUALITY_ATTRIBUTE:
                factor = createProductQualityAttribute(e);
                break;
            case QUALITY_IN_USE_ATTRIBUTE:
                factor = createQualityInUseAttribute(e);
                break;
            case GOAL:
                factor = createGoal(e);
                break;
            case TECHNICAL_ISSUE:
                factor = createTechnicalIssue(e);
                break;
            case REQUIREMENT:
                factor = createRequirement(e);
                break;
            case STAKEHOLDER_SATISFACTION:
                factor = createStakeholderSatisfaction(e);
                break;
            case PRODUCT_FACTOR:
            default:
                factor = createProductFactor(e);
            }
        }
        else
            factor = createProductFactor(e);

        return factor;
    }

    /**
     * @param e
     * @return
     */
    private Factor createProductFactor(Element e)
    {
        return (Factor) ProductFactor.builder().name(e.getAttribute("name")).identifier(e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Factor createProductQualityAttribute(Element e)
    {
        return (Factor) ProductQualityAttribute.builder().name(e.getAttribute("name")).identifier(e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Factor createQualityInUseAttribute(Element e)
    {
        return (Factor) QualityInUseAttribute.builder().name(e.getAttribute("name")).identifier(e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Factor createGoal(Element e)
    {
        return (Factor) Goal.builder()
                .name(e.getAttribute("name"))
                .identifier(e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Factor createTechnicalIssue(Element e)
    {
        return (Factor) TechnicalIssue.builder().name(e.getAttribute("name")).identifier(e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Factor createRequirement(Element e)
    {
        return (Factor) Requirement.builder().name(e.getAttribute("name")).identifier(e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Factor createStakeholderSatisfaction(Element e)
    {
        return (Factor) StakeholderSatisfaction.builder().name(e.getAttribute("name")).identifier(e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .title(e.hasAttribute("title") ? e.getAttribute("title") : "")
                .create();
    }
}
