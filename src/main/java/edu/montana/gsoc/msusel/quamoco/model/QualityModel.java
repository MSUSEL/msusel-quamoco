/**
 * The MIT License (MIT)
 * <p>
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2017 Montana State University, Gianforte School of Computing,
 * Software Engineering Laboratory
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package edu.montana.gsoc.msusel.quamoco.model;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.apache.commons.lang3.StringEscapeUtils.escapeXml10;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.io.JsonSerializable;
import edu.montana.gsoc.msusel.quamoco.io.ScriptSerializable;
import edu.montana.gsoc.msusel.quamoco.io.XMLSerializable;
import edu.montana.gsoc.msusel.quamoco.io.YamlSerializable;
import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measure.NormalizationMeasure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;
import lombok.*;

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
@Builder(buildMethodName = "create")
@ToString(of = {"name", "identifier", "fileName", "version"})
@EqualsAndHashCode(of = {"name", "identifier", "fileName", "version"})
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class QualityModel implements XMLSerializable, YamlSerializable, JsonSerializable, ScriptSerializable {

    /**
     * A textual explanation what the model contains.
     */
    @Getter
    @Setter
    private String description;
    /**
     * The name of a model should represent the content of the model. For
     * example, if it describes factors for the programming language Java, it
     * should be called Java.
     * If there is no specific reason to do otherwise, only capitalise the first
     * word in the name.
     */
    @Getter
    @Setter
    private String name;
    /**
     * The title is a more elaborated/detailed name for the model.
     * This is optional.
     * If there is no specific reason to do otherwise, only capitalise the first
     * word in the title.
     */
    @Getter
    @Setter
    private String title;
    /**
     *
     */
    @Getter
    @Setter
    private Source originatesFrom;
    /**
     *
     */
    @Singular
    private List<Tag> taggedBys = Lists.newArrayList();
    /**
     *
     */
    @Singular
    private Map<String, Entity> entities = Maps.newHashMap();
    /**
     *
     */
    @Singular
    private Map<String, Factor> factors = Maps.newHashMap();
    /**
     *
     */
    @Getter
    @Singular
    private List<Evaluation> evaluations = Lists.newArrayList();
    /**
     *
     */
    @Singular
    private Map<String, Measure> measures = Maps.newHashMap();
    /**
     *
     */
    @Singular
    private Map<String, MeasurementMethod> measurementMethods = Maps.newHashMap();
    /**
     *
     */
    @Singular
    private Map<String, Tool> tools = Maps.newHashMap();
    /**
     *
     */
    @Singular
    private List<Tag> tags = Lists.newArrayList();
    /**
     *
     */
    @Getter
    @Singular
    private List<Source> sources = Lists.newArrayList();
    /**
     * The quality models the current quality model depends on. These models
     * will be loaded together with the current model
     * You can only link in any way from the current model to models that are in
     * this requires list.
     */
    @Singular
    private List<QualityModel> requires = Lists.newArrayList();
    @Getter
    private String identifier;
    @Getter
    @Setter
    private String fileName;
    @Getter
    @Setter
    private String version;

    public QualityModel(String name) {
        this(name, UUID.randomUUID().toString());
    }

    public QualityModel(String name, String identifier) {
        this.name = name;
        this.identifier = identifier;
        entities = Maps.newHashMap();
        tools = Maps.newHashMap();
        measures = Maps.newHashMap();
        factors = Maps.newHashMap();
        measurementMethods = Maps.newHashMap();
        requires = Lists.newArrayList();
        sources = Lists.newArrayList();
        tags = Lists.newArrayList();
        taggedBys = Lists.newArrayList();
        evaluations = Lists.newArrayList();
    }

    public void addSource(Source src) {
        if (src == null || sources.contains(src))
            return;

        sources.add(src);
        src.updateQualifiedIdentifier(this);
    }

    public void removeSource(Source src) {
        if (src == null || !sources.contains(src))
            return;

        sources.remove(src);
        src.updateQualifiedIdentifier(null);
    }

    public void addTool(Tool tool) {
        if (tool == null) {
            return;
        }

        tools.put(tool.getName(), tool);
        tool.updateQualifiedIdentifier(this);
    }

    public boolean hasTool(String name) {
        return tools.containsKey(name);
    }

    public Tool getTool(String name) {
        return tools.get(name);
    }

    public List<Tool> getTools() {
        List<Tool> list = Lists.newArrayList();

        list.addAll(tools.values());

        return list;
    }

    public void addEntity(Entity ent) {
        if (ent == null)
            return;

        entities.put(ent.getName(), ent);
        ent.updateQualifiedIdentifier(this);
    }

    public boolean hasEntity(String name) {
        return entities.containsKey(name);
    }

    public Entity getEntity(String name) {
        return entities.get(name);
    }

    public List<Entity> getEntities() {
        List<Entity> list = Lists.newArrayList();

        list.addAll(entities.values());

        return list;
    }

    public void addMeasure(Measure meas) {
        if (meas == null)
            return;

        measures.put(meas.getName(), meas);
        meas.updateQualifiedIdentifier(this);
    }

    public boolean hasMeasure(String name) {
        return measures.containsKey(name);
    }

    public Measure getMeasure(String name) {
        return measures.get(name);
    }

    public List<Measure> getMeasures() {
        List<Measure> list = Lists.newArrayList();

        list.addAll(measures.values());

        return list;
    }

    public boolean hasNormalizationMeasure(String name) {
        return measures.containsKey(name) && measures.get(name) instanceof NormalizationMeasure;
    }

    public Measure getNormalizationMeasure(String name) {
        if (measures.get(name) instanceof NormalizationMeasure)
            return measures.get(name);
        else
            return null;
    }

    public void addFactor(Factor fac) {
        if (fac == null)
            return;

        factors.put(fac.getName(), fac);
        fac.updateQualifiedIdentifier(this);
    }

    public boolean hasFactor(String name) {
        return factors.containsKey(name);
    }

    public Factor getFactor(String name) {
        return factors.get(name);
    }

    public List<Factor> getFactors() {
        return Lists.newArrayList(factors.values());
    }

    public void addRequires(QualityModel model) {
        if (model == null || requires.contains(model))
            return;

        requires.add(model);
    }

    public void removeRequires(QualityModel model) {
        if (model == null || !requires.contains(model))
            return;

        requires.remove(model);
    }

    public List<QualityModel> getRequires() {
        return requires;
    }

    public void addTag(Tag tag) {
        if (tag == null || tags.contains(tag))
            return;

        tags.add(tag);
        tag.updateQualifiedIdentifier(this);
    }

    public void removeTag(Tag tag) {
        if (tag == null || !tags.contains(tag))
            return;

        tags.remove(tag);
        tag.updateQualifiedIdentifier(null);
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTaggedBy(Tag tag) {
        if (tag == null || taggedBys.contains(tag))
            return;

        taggedBys.add(tag);
    }

    public void removeTaggedBy(Tag tag) {
        if (tag == null || !taggedBys.contains(tag))
            return;

        taggedBys.remove(tag);
    }

    public List<Tag> getTaggedBy() {
        return taggedBys;
    }

    public void addEvaluation(Evaluation eval) {
        if (eval == null || evaluations.contains(eval)) {
            return;
        }

        evaluations.add(eval);
        eval.updateQualifiedIdentifier(this);
    }

    public void removeEvaluation(Evaluation eval) {
        if (eval == null || !evaluations.contains(eval))
            return;

        evaluations.remove(eval);
        eval.updateQualifiedIdentifier(null);
    }

    /**
     * @param method
     */
    public void addMeasurementMethod(MeasurementMethod method) {
        if (method == null || measurementMethods.containsKey(method.getIdentifier()))
            return;

        measurementMethods.put(method.getIdentifier(), method);
        method.updateQualifiedIdentifier(this);
    }

    /**
     * @param method
     */
    public void removeMeasurementMethod(MeasurementMethod method) {
        if (method == null || !measurementMethods.containsKey(method.getIdentifier()))
            return;

        measurementMethods.remove(method.getIdentifier());
        method.updateQualifiedIdentifier(null);
    }

    /**
     * @param identifier
     * @return
     */
    public MeasurementMethod getMeasurementMethod(String identifier) {
        return measurementMethods.get(identifier);
    }

    public boolean hasMeasurementMethod(String identifier) {
        return measurementMethods.containsKey(identifier);
    }

    public List<MeasurementMethod> getMeasurementMethods() {
        List<MeasurementMethod> list = Lists.newArrayList();

        list.addAll(measurementMethods.values());

        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String xmlTag() {
        StringBuilder builder = new StringBuilder();

        builder.append(
                String.format(
                        "<qm:QualityModel xmlns:qm=\"http://www.quamoco.de/qm/v17\" xmlns:xmi=\"http://www.omg.org/XMI\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" description=\"%s\" name=\"%s\" title=\"%s\" xmi:id=\"%s\" xmi:version=\"%s\"",
                        escapeXml10(getDescription()), escapeXml10(getName()), escapeXml10(getTitle()), getIdentifier(),
                        getVersion()));

        if (hasChildren()) {
            builder.append(">\n");
            if (hasRequires()) {
                requires.forEach(
                        (req) -> builder
                                .append(String.format("<requires href=\"%s\" />%n", req.getQualifiedIdentifier())));
            }

            if (hasTaggedBy()) {
                taggedBys.forEach(
                        (tag) -> builder
                                .append(String.format("<taggedBy href=\"%s\" />%n", tag.getQualifiedIdentifier())));
            }

            if (hasFactors()) {
                factors.forEach((key, fact) -> builder.append(fact.xmlTag()));
            }

            if (hasMeasures()) {
                measures.forEach((key, meas) -> builder.append(meas.xmlTag()));
            }

            if (hasEntities()) {
                entities.forEach((key, ent) -> builder.append(ent.xmlTag()));
            }

            if (hasTags()) {
                tags.forEach((tag) -> builder.append(tag.xmlTag()));
            }

            if (hasSources()) {
                sources.forEach((src) -> builder.append(src.xmlTag()));
            }

            if (hasTools()) {
                tools.forEach((key, tool) -> builder.append(tool.xmlTag()));
            }

            if (hasMeasurementMethods()) {
                measurementMethods.forEach((key, mm) -> builder.append(mm.xmlTag()));
            }

            if (hasEvaluations()) {
                evaluations.forEach((eval) -> builder.append(eval.xmlTag()));
            }

            builder.append("</qm:QualityModel>\n");
        } else {
            builder.append(" />\n");
        }

        return builder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toScript() {
        StringBuilder builder = new StringBuilder();

        if (hasRequires()) {
            requires.forEach((req) -> builder.append(String.format("require '%s'%n", req.getFileName())));
        }

        builder.append(String.format("model '%s' {%n", getName()));

        if (hasSources()) {
            builder.append("    sources {\n");
            sources.forEach((src) -> builder.append(src.toScript()));
            builder.append("    }\n");
        }

        if (hasTags()) {
            builder.append("    tags {\n");
            tags.forEach((tag) -> builder.append(tag.toScript()));
            builder.append("    }\n");
        }

        if (hasTaggedBy()) {
            taggedBys.forEach(
                    (tag) -> builder.append(String.format("<taggedBy href=\"%s\" />%n", tag.getQualifiedIdentifier())));
        }

        if (hasEntities()) {
            builder.append("    entities {\n");
            // TODO needs to be sorted using topological sort of dependencies
            entities.forEach((key, ent) -> builder.append(ent.toScript()));
            builder.append("    }\n");
        }

        if (hasFactors()) {
            builder.append("    factors {\n");
            // TODO needs to be sorted using topological sort of dependencies
            factors.forEach((key, fact) -> builder.append(fact.toScript()));
            builder.append("    }\n");
        }

        if (hasMeasures()) {
            builder.append("    measures {\n");
            // TODO needs to be sorted using topological sort of dependencies
            measures.forEach((key, meas) -> builder.append(meas.toScript()));
            builder.append("    }\n");
        }

        if (hasTools()) {
            builder.append("    tools {\n");
            tools.forEach((key, tool) -> builder.append(tool.toScript()));
            builder.append("    }\n");
        }

        if (hasMeasurementMethods()) {
            builder.append("    methods {\n");
            measurementMethods.forEach((key, mm) -> builder.append(mm.toScript()));
            builder.append("    }\n");
        }

        if (hasEvaluations()) {
            builder.append("    evaluations {\n");
            evaluations.forEach((eval) -> builder.append(eval.toScript()));
            builder.append("    }\n");
        }

        builder.append("}\n");

        return builder.toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toJson() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toYaml() {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @return
     */
    private boolean hasChildren() {
        return hasRequires() || hasTaggedBy() || hasFactors() || hasMeasures() || hasEntities() || hasTags()
                || hasSources() || hasTools() || hasMeasurementMethods() || hasEvaluations();
    }

    /**
     * @return
     */
    private boolean hasRequires() {
        return !requires.isEmpty();
    }

    /**
     * @return
     */
    private boolean hasTaggedBy() {
        return !taggedBys.isEmpty();
    }

    /**
     * @return
     */
    private boolean hasFactors() {
        return !factors.isEmpty();
    }

    /**
     * @return
     */
    private boolean hasMeasures() {
        return !measures.isEmpty();
    }

    /**
     * @return
     */
    private boolean hasEntities() {
        return !entities.isEmpty();
    }

    /**
     * @return
     */
    private boolean hasTags() {
        return !tags.isEmpty();
    }

    /**
     * @return
     */
    private boolean hasSources() {
        return !sources.isEmpty();
    }

    /**
     * @return
     */
    private boolean hasTools() {
        return !tools.isEmpty();
    }

    /**
     * @return
     */
    private boolean hasMeasurementMethods() {
        return !measurementMethods.isEmpty();
    }

    /**
     * @return
     */
    private boolean hasEvaluations() {
        return !evaluations.isEmpty();
    }

    /**
     * @return
     */
    public String getQualifiedIdentifier() {
        return fileName + "#" + identifier;
    }
}
