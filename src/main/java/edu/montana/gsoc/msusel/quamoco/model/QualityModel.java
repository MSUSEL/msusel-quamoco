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

import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.apache.commons.lang3.StringEscapeUtils.escapeXml10;

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
 * @version 1.2.0
 */
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
    private List<Tag> taggedBys;
    /**
     *
     */
    private Map<String, Entity> entities;
    /**
     *
     */
    private Map<String, Factor> factors;
    /**
     *
     */
    @Getter
    private Map<String, Evaluation> evaluations;
    /**
     *
     */
    private Map<String, Measure> measures;
    /**
     *
     */
    private Map<String, MeasurementMethod> measurementMethods;
    /**
     *
     */
    private Map<String, Tool> tools;
    /**
     *
     */
    private Map<String, Tag> tags;
    /**
     *
     */
    @Getter
    private Map<String, Source> sources;
    /**
     * The quality models the current quality model depends on. These models
     * will be loaded together with the current model
     * You can only link in any way from the current model to models that are in
     * this requires list.
     */
    private List<QualityModel> requires;
    @Getter
    private String identifier;
    @Getter
    @Setter
    private String fileName;
    @Getter
    @Setter
    private String version;
    @Getter
    @Setter
    private double gradeBoundary2;
    @Getter
    @Setter
    private double gradeBoundary3;
    @Getter
    @Setter
    private double gradeBoundary4;
    @Getter
    @Setter
    private double gradeBoundary5;
    @Getter
    @Setter
    private double gradeBoundary6;


    public QualityModel(String name) {
        this(name, UUID.randomUUID().toString());
    }

    public QualityModel(String name, String identifier) {
        this(name, identifier, "", "", "", "", null, Maps.newHashMap(), Maps.newHashMap(),
                Maps.newHashMap(), Maps.newHashMap(), Maps.newHashMap(), Maps.newHashMap(), Maps.newHashMap(),
                Lists.newArrayList(), Maps.newHashMap(), Lists.newArrayList(), null, null, null, null, null);
    }

    @Builder(buildMethodName = "create")
    public QualityModel(String name, String identifier, String fileName, String version, String title, String description, Source originatesFrom,
                        @Singular Map<String, Entity> entities, @Singular Map<String, Tool> tools, @Singular Map<String, Measure> measures,
                        @Singular Map<String, Factor> factors, @Singular Map<String, MeasurementMethod> measurementMethods,
                        @Singular Map<String, Source> sources, @Singular Map<String, Tag> tags, @Singular List<Tag> taggedBys,
                        @Singular Map<String, Evaluation> evaluations, @Singular List<QualityModel> requires, Double gradeBoundary2, Double gradeBoundary3,
                        Double gradeBoundary4, Double gradeBoundary5, Double gradeBoundary6) {
        this.name = name;
        this.identifier = identifier;
        this.fileName = fileName;
        this.version = version;
        this.title = title;
        this.description = description;
        this.originatesFrom = originatesFrom;
        this.entities = Maps.newHashMap(entities);
        this.tools = Maps.newHashMap(tools);
        this.measures = Maps.newHashMap(measures);
        this.factors = Maps.newHashMap(factors);
        this.measurementMethods = Maps.newHashMap(measurementMethods);
        this.requires = Lists.newArrayList(requires);
        this.sources = Maps.newHashMap(sources);
        this.tags = Maps.newHashMap(tags);
        this.taggedBys = Lists.newArrayList(taggedBys);
        this.evaluations = Maps.newHashMap(evaluations);
        this.gradeBoundary2 = gradeBoundary2 == null ? 0.98 : gradeBoundary2;
        this.gradeBoundary3 = gradeBoundary3 == null ? 0.96 : gradeBoundary3;
        this.gradeBoundary4 = gradeBoundary4 == null ? 0.94 : gradeBoundary4;
        this.gradeBoundary5 = gradeBoundary5 == null ? 0.92 : gradeBoundary5;
        this.gradeBoundary6 = gradeBoundary6 == null ? 0.90 : gradeBoundary6;
    }

    public void addSource(Source src) {
        if (src == null || sources.containsKey(src.getIdentifier()))
            return;

        sources.put(src.getIdentifier(), src);
        src.updateQualifiedIdentifier(this);
    }

    public void removeSource(Source src) {
        if (src == null || !sources.containsValue(src))
            return;

        sources.remove(src.getIdentifier());
        src.updateQualifiedIdentifier(null);
    }

    public void addTool(Tool tool) {
        if (tool == null) {
            return;
        }

        tools.put(tool.getIdentifier(), tool);
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

        entities.put(ent.getIdentifier(), ent);
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

        measures.put(meas.getIdentifier(), meas);
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

        factors.put(fac.getIdentifier(), fac);
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
        if (tag == null || tags.containsKey(tag.getIdentifier()))
            return;

        tags.put(tag.getIdentifier(), tag);
        tag.updateQualifiedIdentifier(this);
    }

    public void removeTag(Tag tag) {
        if (tag == null || !tags.containsValue(tag))
            return;

        tags.remove(tag.getIdentifier());
        tag.updateQualifiedIdentifier(null);
    }

    public List<Tag> getTags() {
        return Lists.newArrayList(tags.values());
    }

    public boolean hasTagNamed(String name) {
        return hasElementNamed(name, tags);
    }


    public Tag findTagNamed(String name) {
        return (Tag) findElementNamed(name, tags);
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
        if (eval == null || evaluations.containsKey(eval.getIdentifier())) {
            return;
        }

        evaluations.put(eval.getIdentifier(), eval);
        eval.updateQualifiedIdentifier(this);
        eval.setModelName(this.getName());
    }

    public void removeEvaluation(Evaluation eval) {
        if (eval == null || !evaluations.containsKey(eval.getIdentifier()))
            return;

        evaluations.remove(eval.getIdentifier());
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
                tags.forEach((key, tag) -> builder.append(tag.xmlTag()));
            }

            if (hasSources()) {
                sources.forEach((key, src) -> builder.append(src.xmlTag()));
            }

            if (hasTools()) {
                tools.forEach((key, tool) -> builder.append(tool.xmlTag()));
            }

            if (hasMeasurementMethods()) {
                measurementMethods.forEach((key, mm) -> builder.append(mm.xmlTag()));
            }

            if (hasEvaluations()) {
                evaluations.forEach((key, eval) -> builder.append(eval.xmlTag()));
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
            sources.forEach((key, src) -> builder.append(src.toScript()));
            builder.append("    }\n");
        }

        if (hasTags()) {
            builder.append("    tags {\n");
            tags.forEach((key, tag) -> builder.append(tag.toScript()));
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
            evaluations.forEach((key, eval) -> builder.append(eval.toScript()));
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

    public boolean hasSource(String identifier) {
        return sources.containsKey(identifier);
    }

    public Source getSource(String identifier) {
        return sources.get(identifier);
    }

    public boolean hasTag(String identifier) {
        return tags.containsKey(identifier);
    }

    public Tag getTag(String identifier) {
        return tags.get(identifier);
    }

    public boolean hasToolNamed(String name) {
        return hasElementNamed(name, tools);
    }

    public Tool findToolNamed(String name) {
        return (Tool) findElementNamed(name, tools);
    }

    public boolean hasSourceNamed(String name) {
        return hasElementNamed(name, sources);
    }

    public Source findSourceNamed(String name) {
        return (Source) findElementNamed(name, sources);
    }

    public boolean hasEntityNamed(String name) {
        return hasElementNamed(name, entities);
    }

    public Entity findEntityNamed(String name) {
        return (Entity) findElementNamed(name, entities);
    }

    public boolean hasFactorNamed(String name) {
        return hasElementNamed(name, factors);
    }

    public Factor findFactorNamed(String name) {
        return (Factor) findElementNamed(name, factors);
    }

    public boolean hasMeasureNamed(String name) {
        return hasElementNamed(name, measures);
    }

    public Measure findMeasureNamed(String name) {
        return (Measure) findElementNamed(name, measures);
    }

    public boolean hasEvaluationNamed(String name) {
        return hasElementNamed(name, evaluations);
    }

    public Evaluation findEvaluationNamed(String name) {
        return (Evaluation) findElementNamed(name, evaluations);
    }

    public boolean hasMeasurementMethodNamed(String name) {
        return hasElementNamed(name, measurementMethods);
    }

    public MeasurementMethod findMeasurementMethodNamed(String name) {
        return (MeasurementMethod) findElementNamed(name, measurementMethods);
    }

    private boolean hasElementNamed(String name, Map<String, ? extends QMElement> map) {
        for (QMElement element : map.values()) {
            if (element.getFullName().equals(name))
                return true;
        }

        return false;
    }

    private QMElement findElementNamed(String name, Map<String, ? extends QMElement> map) {
        for (QMElement element : map.values()) {
            if (element.getFullName().equals(name))
                return element;
        }

        return null;
    }
}
