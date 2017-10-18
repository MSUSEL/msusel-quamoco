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
package edu.montana.gsoc.msusel.quamoco.io;

import edu.montana.gsoc.msusel.quamoco.model.Entity;
import edu.montana.gsoc.msusel.quamoco.model.ProductPart;
import edu.montana.gsoc.msusel.quamoco.model.UseCase;
import org.w3c.dom.Element;

import edu.montana.gsoc.msusel.quamoco.model.Stakeholder;

/**
 * @author Isaac Griffith
 */
public class EntityFactory extends AbstractQMElementFactory {

    /**
     * 
     */
    private EntityFactory()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * @author Isaac Griffith
     */
    private static class Holder {
        /**
         * 
         */
        private static final EntityFactory INSTANCE = new EntityFactory();
    }

    /**
     * @return
     */
    public static EntityFactory instance()
    {
        return Holder.INSTANCE;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Entity create(Element e)
    {
        Entity ent = null;

        if (e.hasAttribute("xsi:type"))
        {
            EntityType type = EntityType.fromType(e.getAttribute("xsi:type"));
            switch (type)
            {
            case STAKEHOLDER:
                ent = createStakeholder(e);
                break;
            case USE_CASE:
                ent = createUseCase(e);
                break;
            case PRODUCT_PART:
            default:
                ent = createProductPart(e);
            }
        }
        else
            ent = createProductPart(e);

        return ent;
    }

    /**
     * @param e
     * @return
     */
    private Entity createStakeholder(Element e)
    {
        return (Stakeholder) Stakeholder.builder(e.getAttribute("name"), e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Entity createUseCase(Element e)
    {
        return (UseCase) UseCase.builder(e.getAttribute("name"), e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .create();
    }

    /**
     * @param e
     * @return
     */
    private Entity createProductPart(Element e)
    {
        return (ProductPart) ProductPart.builder(e.getAttribute("name"), e.getAttribute("xmi:id"))
                .description(e.hasAttribute("description") ? e.getAttribute("description") : "")
                .create();
    }
}
