/**
 * The MIT License (MIT)
 *
 * MSUSEL Quamoco Implementation
 * Copyright (c) 2015-2018 Montana State University, Gianforte School of Computing,
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
package edu.montana.gsoc.msusel.quamoco.distiller;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.graph.EndpointPair;
import com.google.common.graph.MutableNetwork;
import com.google.common.graph.NetworkBuilder;
import edu.montana.gsoc.msusel.quamoco.model.*;
import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import edu.montana.gsoc.msusel.quamoco.model.eval.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.factor.Factor;
import edu.montana.gsoc.msusel.quamoco.model.measure.Measure;
import edu.montana.gsoc.msusel.quamoco.model.measure.NormalizationMeasure;
import edu.montana.gsoc.msusel.quamoco.model.measurement.MeasurementMethod;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Isaac Griffith
 * @version 1.2.0
 */
public class ModelManager {

    Map<String, QualityModel> models;

    /**
     *
     */
    public ModelManager() {
        models = Maps.newHashMap();
    }

    public void addModel(QualityModel model) {
        if (model != null) {
            models.put(model.getIdentifier(), model);
        }
    }

    private QualityModel selectModel(String identifier) {
        String modelKey = identifier.split("\\.qm#")[0];

        if (models.containsKey(modelKey)) {
            return getModelByName(modelKey);
        }

        return null;
    }

    private QMElement findElement(String identifier, Predicate<QualityModel> predHas, Function<QualityModel, QMElement> fnGet) {
        QMElement retVal = null;

        QualityModel model = selectModel(identifier);
        if (model != null) {
            retVal = fnGet.apply(model);
        } else {
            for (QualityModel m : models.values()) {
                if (predHas.test(m)) {
                    retVal = fnGet.apply(m);
                    break;
                }
            }
        }

        return retVal;
    }

    private String trimIdentifier(String identifier) {
        if (identifier.contains(".qm#"))
            return identifier.split("\\.qm#")[1];
        return identifier;
    }

    /**
     * @param identifier
     * @return
     */
    public Source findSource(String identifier) {
        return (Source) findElement(identifier,
                (m) -> m.hasSource(trimIdentifier(identifier)),
                (m) -> m.getSource(trimIdentifier(identifier)));
    }

    /**
     * @param identifier
     * @return
     */
    public Tag findTag(String identifier) {
        return (Tag) findElement(identifier,
                (m) -> m.hasTag(trimIdentifier(identifier)),
                (m) -> m.getTag(trimIdentifier(identifier)));
    }

    /**
     * @param attribute
     * @return
     */
    public static QualityModel findModel(String attribute) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * @param identifier
     * @return
     */
    public Factor findFactor(String identifier) {
        return (Factor) findElement(identifier,
                (m) -> m.hasFactor(trimIdentifier(identifier)),
                (m) -> m.getFactor(trimIdentifier(identifier)));
    }

    /**
     * @param identifier
     * @return
     */
    public Measure findMeasure(String identifier) {
        return (Measure) findElement(identifier,
                (m) -> m.hasMeasure(identifier),
                (m) -> m.getMeasure(identifier));
    }

    /**
     * @param identifier
     * @return
     */
    public NormalizationMeasure findNormMeasure(String identifier) {
        return (NormalizationMeasure) findElement(identifier,
                (m) -> m.hasNormalizationMeasure(trimIdentifier(identifier)),
                (m) -> m.getNormalizationMeasure(trimIdentifier(identifier)));
    }

    /**
     * @param identifier
     * @return
     */
    public Entity findEntity(String identifier) {
        return (Entity) findElement(identifier,
                (m) -> m.hasEntity(trimIdentifier(identifier)),
                (m) -> m.getEntity(trimIdentifier(identifier)));
    }

    /**
     * @param identifier
     * @return
     */
    public Tool findTool(String identifier) {
        return (Tool) findElement(identifier,
                (m) -> m.hasTool(trimIdentifier(identifier)),
                (m) -> m.getTool(trimIdentifier(identifier)));
    }

    /**
     * Produces a sorted list of known quality models, which are sorted by least
     * dependent first.
     *
     * @param models Unsorted List of known quality models
     * @return Sorted List of known quality models in ascending order of
     * dependence
     */
    @VisibleForTesting
    static List<QualityModel> getSortedModelList(List<QualityModel> models) {
        MutableNetwork<QualityModel, String> g = NetworkBuilder.directed().allowsSelfLoops(false).build();

        if (models != null) {
            for (QualityModel model : models) {
                g.addNode(model);
            }
            for (QualityModel model : models) {
                for (QualityModel qm : model.getRequires()) {
                    g.addEdge(model, qm, "requires: " + model.getName() + " - " + qm.getName());
                }
            }
        }
        return topologicalSort(g);
    }

    /**
     * Conducts a topological sort of a dependency graph between quality models.
     *
     * @param graph Dependency graph of the quality models. Note that edges flow
     *              in opposite direction of dependency.
     * @return Topologically sorted list of quality models
     */
    @VisibleForTesting
    static List<QualityModel> topologicalSort(MutableNetwork<QualityModel, String> graph) {
        List<QualityModel> list = Lists.newArrayList();
        List<QualityModel> set = Lists.newArrayList();

        for (QualityModel q : graph.nodes()) {
            if (graph.inDegree(q) <= 0) {
                set.add(q);
            }
        }

        while (!set.isEmpty()) {
            QualityModel q = set.remove(0);
            list.add(q);
            List<String> toRemove = Lists.newArrayList();
            for (String edge : graph.outEdges(q)) {
                QualityModel x = getOpposite(q, edge, graph);
                toRemove.add(edge);
                if (graph.inDegree(x) <= 1) {
                    set.add(x);
                }
            }
            for (String edge : toRemove) {
                graph.removeEdge(edge);
            }
        }
        if (graph.edges().size() > 0) {
            System.out.println("Graph has Cycles");
        }
        return list;
    }

    private static <N, E> N getOpposite(N q, E edge, MutableNetwork<N, E> graph) {
        EndpointPair<N> pair = graph.incidentNodes(edge);

        if (pair.nodeU().equals(q)) {
            return pair.nodeV();
        } else {
            return pair.nodeU();
        }
    }

    public List<QualityModel> getModels() {
        return Lists.newArrayList(models.values());
    }

    public List<MeasurementMethod> getAllMeasurementMethods() {
        List<MeasurementMethod> methods = Lists.newArrayList();
        for (QualityModel model : getModels()) {
            methods.addAll(model.getMeasurementMethods());
        }

        return methods;
    }

    public List<Evaluation> getAllEvaluations() {
        List<Evaluation> evals = Lists.newArrayList();
        for (QualityModel model : getModels()) {
            evals.addAll(model.getEvaluations().values());
        }

        return evals;
    }

    public Tool findToolByName(String name) {
        return (Tool) findElement(name,
                (m) -> m.hasToolNamed(name),
                (m) -> m.findToolNamed(name));
    }

    public Tag findTagByName(String name) {
        return (Tag) findElement(name,
                (m) -> m.hasTagNamed(name),
                (m) -> m.findTagNamed(name));
    }

    public Source findSourceByName(String name) {
        return (Source) findElement(name,
                (m) -> m.hasSourceNamed(name),
                (m) -> m.findSourceNamed(name));
    }

    public Entity findEntityByName(String name) {
        return (Entity) findElement(name,
                (m) -> m.hasEntityNamed(name),
                (m) -> m.findEntityNamed(name));
    }

    public Measure findMeasureByName(String name) {
        return (Measure) findElement(name,
                (m) -> m.hasMeasureNamed(name),
                (m) -> m.findMeasureNamed(name));
    }

    public Factor findFactorByName(String name) {
        return (Factor) findElement(name,
                (m) -> m.hasFactorNamed(name),
                (m) -> m.findFactorNamed(name));
    }

    public Evaluation findEvaluationByName(String name) {
        return (Evaluation) findElement(name,
                (m) -> m.hasEvaluationNamed(name),
                (m) -> m.findEvaluationNamed(name));
    }

    public MeasurementMethod findMeasurementMethodByName(String name) {
        return (MeasurementMethod) findElement(name,
                (m) -> m.hasMeasurementMethodNamed(name),
                (m) -> m.findMeasurementMethodNamed(name));
    }

    public QualityModel getModelByName(String name) {
        for (QualityModel model : models.values()) {
            if (model.getName().equals(name))
                return model;
        }

        return null;
    }

    public QualityModel getModel(String id) {
        return models.get(id);
    }
}