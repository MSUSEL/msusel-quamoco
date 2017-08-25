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
package edu.montana.gsoc.msusel.quamoco.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.stream.XMLStreamException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;

import edu.montana.gsoc.msusel.quamoco.distiller.ModelDistiller;
import edu.montana.gsoc.msusel.quamoco.distiller.QualityModelUtils;
import edu.montana.gsoc.msusel.quamoco.model.AbstractEntity;
import edu.montana.gsoc.msusel.quamoco.model.qm.Annotation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Characterizes;
import edu.montana.gsoc.msusel.quamoco.model.qm.Determines;
import edu.montana.gsoc.msusel.quamoco.model.qm.Entity;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluates;
import edu.montana.gsoc.msusel.quamoco.model.qm.Evaluation;
import edu.montana.gsoc.msusel.quamoco.model.qm.Factor;
import edu.montana.gsoc.msusel.quamoco.model.qm.FactorLink;
import edu.montana.gsoc.msusel.quamoco.model.qm.Function;
import edu.montana.gsoc.msusel.quamoco.model.qm.Influence;
import edu.montana.gsoc.msusel.quamoco.model.qm.InfluenceEffect;
import edu.montana.gsoc.msusel.quamoco.model.qm.IsA;
import edu.montana.gsoc.msusel.quamoco.model.qm.Measure;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasureLink;
import edu.montana.gsoc.msusel.quamoco.model.qm.MeasurementMethod;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationMeasure;
import edu.montana.gsoc.msusel.quamoco.model.qm.NormalizationRange;
import edu.montana.gsoc.msusel.quamoco.model.qm.OriginatesFrom;
import edu.montana.gsoc.msusel.quamoco.model.qm.Parent;
import edu.montana.gsoc.msusel.quamoco.model.qm.PartOf;
import edu.montana.gsoc.msusel.quamoco.model.qm.QualityModel;
import edu.montana.gsoc.msusel.quamoco.model.qm.Ranking;
import edu.montana.gsoc.msusel.quamoco.model.qm.Refines;
import edu.montana.gsoc.msusel.quamoco.model.qm.Requires;
import edu.montana.gsoc.msusel.quamoco.model.qm.Source;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tag;
import edu.montana.gsoc.msusel.quamoco.model.qm.TaggedBy;
import edu.montana.gsoc.msusel.quamoco.model.qm.Target;
import edu.montana.gsoc.msusel.quamoco.model.qm.Tool;

/**
 * Tool to generate Quamoco Quality Model Scripts from the old style XML files
 * produced by the Quamoco Quality Model Editor.
 * 
 * @author Isaac Griffith
 * @version 1.1.1
 */
public class QuamocoScriptGen {

    /**
     * Logger associated with this class
     */
    private static final Logger  LOG = LoggerFactory.getLogger(QuamocoScriptGen.class);
    /**
     * Command line options object associated with this class.
     */
    private static final Options options;

    /**
     * Initializes the command line options object.
     */
    static
    {
        final Option help = Option.builder("h")
                .required(false)
                .longOpt("help")
                .desc("prints this message")
                .hasArg(false)
                .build();
        final Option output = Option.builder("o")
                .required(false)
                .longOpt("output")
                .argName("FOLDER")
                .desc("Name of the folder to output revised quality models to")
                .hasArg(true)
                .numberOfArgs(1)
                .build();
        options = new Options();
        QuamocoScriptGen.options.addOption(help);
        QuamocoScriptGen.options.addOption(output);
    }

    /**
     * Starting point of execution.
     *
     * @param args
     *            Raw command line arguments.
     */
    public static void main(final String... args)
    {
        final ModelDistiller dqm = new ModelDistiller();
        final CommandLineParser parser = new DefaultParser();
        try
        {
            final CommandLine line = parser.parse(QuamocoScriptGen.options, args);
            QuamocoScriptGen.execute(line);
        }
        catch (final ParseException exp)
        {
            System.err.println("Parsing failed. Reason: " + exp.getMessage());
        }
    }

    /**
     * Executes the process as guided by the options in the given CommandLine
     * 
     * @param line
     *            CommandLine used for processing command line options
     */
    @VisibleForTesting
    static void execute(CommandLine line)
    {
        QuamocoScriptGen gen = new QuamocoScriptGen();

        if (line.getOptions().length == 0 || line.hasOption('h'))
        {
            final HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar QuamocoScriptGen", QuamocoScriptGen.options, true);
            return;
        }
        String folder = null;
        if (line.hasOption('o'))
        {
            folder = line.getOptionValue('o');
        }

        List<QualityModel> models = gen.readInQualityModels("root", "object", "java", "csharp");

        Map<String, QualityModel> map = QualityModelUtils.createModelMap(models);
        if (folder != null)
        {
            for (QualityModel model : models)
            {
                gen.saveOutput(model.getName(), folder, gen.generate(model, map));
            }
        }

    }

    /**
     * Reads quality models from the Jar
     *
     * @param args
     *            list of quality models to be read from the Jar file.
     * @return List of Quality Model objects created from the read files.
     */
    @VisibleForTesting
    List<QualityModel> readInQualityModels(final String... args)
    {
        final QMReader qmread = new QMReader();
        final List<QualityModel> models = Lists.newArrayList();
        if (args != null)
        {
            try
            {
                for (final String arg : args)
                {
                    qmread.read(arg);
                    models.add(qmread.getModel());
                }
            }
            catch (FileNotFoundException | XMLStreamException e)
            {
                LOG.warn(e.getMessage(), e);
            }
        }
        return models;
    }

    /**
     * Constructs a new QuamocoScriptGen
     */
    public QuamocoScriptGen()
    {
        // TODO Auto-generated constructor stub
    }

    /**
     * For the given quality model and model map, this method generates the
     * script string for the given quality model
     * 
     * @param model
     *            Quality Model for which a script is to be generated
     * @param modelMap
     *            Map of existing quality models indexed by their identifiers
     * @return String representing the script for the given quality model
     */
    public String generate(QualityModel model, Map<String, QualityModel> modelMap)
    {
        StringBuilder builder = new StringBuilder();

        OriginatesFrom f = model.getOriginatesFrom();
        List<Requires> reqs = model.getRequires();
        TaggedBy t = model.getTaggedBy();

        if (t != null)
        {
            Tag tag = (Tag) QualityModelUtils.findEntity(modelMap, t.getHREF());
            builder.append(String.format("@taggedBy %s%n", tag.getName().replaceAll(" ", "_")));
        }

        if (f != null)
        {
            Source src = (Source) QualityModelUtils.findEntity(modelMap, f.getHREF());
            builder.append(String.format("@originatesFrom %s%n", src.getName().replaceAll(" ", "_")));
        }

        for (Requires req : reqs)
        {
            QualityModel qm = modelMap.get(req.getHREF());
            if (qm != null)
                builder.append(String.format("@requires %s%n", qm.getName()));
        }

        builder.append("model " + model.getName() + " {\n");
        if (model.getDescription() != null)
            builder.append("\t[" + model.getDescription() + "]\n");
        builder.append("\n\t// Entities\n");
        for (Entity ent : model.getEntities())
        {
            builder.append(generate(ent, model, modelMap));
        }

        builder.append("\n\t// Factors\n");
        for (Factor fac : model.getFactors())
        {
            builder.append(generate(fac, model, modelMap));
        }

        builder.append("\n\t// Evaluations\n");
        for (Evaluation eval : model.getEvaluations())
        {
            builder.append(generate(eval, model, modelMap));
        }

        builder.append("\n\t// Measures\n");
        for (Measure meas : model.getMeasures())
        {
            builder.append(generate(meas, model, modelMap));
        }

        builder.append("\n\t// Measurement Methods\n");
        for (MeasurementMethod meth : model.getMethods())
        {
            builder.append(generate(meth, model, modelMap));
        }

        builder.append("\n\t// Tools\n");
        for (Tool tool : model.getTools())
        {
            builder.append(generate(tool, model, modelMap));
        }

        builder.append("\n\t// Tags\n");
        for (Tag tg : model.getTags())
        {
            builder.append(generate(tg, model, modelMap));
        }

        builder.append("\n\t// Sources\n");
        for (Source s : model.getSources())
        {
            builder.append(generate(s, model, modelMap));
        }

        builder.append("\n}");

        return builder.toString();
    }

    /**
     * Generates the script section for the given entity in the given model
     * using the provided model map for reference.
     * 
     * @param ent
     *            Entity to generate a script portion for
     * @param model
     *            Model containing the entity
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given entity.
     */
    @VisibleForTesting
    String generate(Entity ent, QualityModel model, Map<String, QualityModel> modelMap)
    {
        OriginatesFrom of = ent.getOriginatesFrom();
        String name = ent.getName();
        List<IsA> is = ent.getIsAs();
        String title = ent.getTitle();
        String desc = ent.getDescription();
        PartOf part = ent.getPartOf();

        StringBuilder builder = new StringBuilder();

        if (of != null)
        {
            Source src = (Source) QualityModelUtils.findEntity(modelMap, of.getHREF());
            builder.append("\t@originatesFrom " + src.getName().replaceAll(" ", "_") + "\n");
        }
        builder.append("\tentity " + name.replaceAll(" ", "_"));
        if (!is.isEmpty())
        {
            builder.append(" < ");
            for (int i = 0; i < is.size(); i++)
            {
                IsA isa = is.get(i);
                Entity e = (Entity) QualityModelUtils.findEntity(modelMap, isa.getHREF());
                if (e != null)
                {
                    if (i >= 1)
                        builder.append(" , ");
                    builder.append(e.getName().replaceAll(" ", "_"));
                }
            }
        }
        if (title != null)
            builder.append("\n\t\t(\"" + title + "\")");
        if (desc != null)
            builder.append("\n\t\t[\"" + desc + "\"]");
        if (part != null)
        {
            Entity e = (Entity) QualityModelUtils.findEntity(modelMap, part.getParent().getHREF());
            if (e != null)
                builder.append("partOf " + e.getName().replaceAll(" ", "_"));
        }
        builder.append(";\n\n");

        return builder.toString();

    }

    /**
     * Generates the script section for the given factor in the given model
     * using the provided model map for reference.
     * 
     * @param fac
     *            Factor to generate a script portion for
     * @param model
     *            Model containing the factor
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given factor.
     */
    @VisibleForTesting
    String generate(Factor fac, QualityModel model, Map<String, QualityModel> modelMap)
    {
        List<Annotation> anns = fac.getAnnotations();
        OriginatesFrom of = fac.getOriginatesFrom();
        String name = fac.getName();
        Characterizes ch = fac.getCharacterizes();
        Refines ref = fac.getRefines();
        String title = fac.getTitle();
        String desc = fac.getDescription();
        List<Influence> inf = fac.getInfluences();

        StringBuilder builder = new StringBuilder();
        for (Annotation a : anns)
        {
            builder.append("\t@" + a.getKey() + " " + a.getValue() + "\n");
        }
        if (of != null)
        {
            Source src = (Source) QualityModelUtils.findEntity(modelMap, of.getHREF());
            builder.append("\t@originatesFrom " + src.getName().replaceAll(" ", "_") + "\n");
        }
        builder.append("\tfactor " + name.replaceAll(" ", "_"));
        if (ch != null)
        {
            Entity e = (Entity) QualityModelUtils.findEntity(modelMap, ch.getHREF());
            builder.append("@" + e.getName().replaceAll(" ", "_"));
        }
        if (ref != null)
        {
            Factor f = (Factor) QualityModelUtils.findEntity(modelMap, ref.getHREF());
            builder.append(" < " + f.getName().replaceAll(" ", "_"));
        }
        if (title != null)
        {
            builder.append("\n\t\t(\"" + title + "\")\n");
        }
        if (desc != null)
        {
            builder.append("\n\t\t[\"" + desc + "\"]\n");
        }
        if (!inf.isEmpty())
        {
            builder.append("\t{\n");
            for (Influence i : inf)
            {
                builder.append(generate(i, model, modelMap));
            }
            builder.append("\t}");
        }
        builder.append(";\n");

        return builder.toString();
    }

    /**
     * Generates the script section for the given influence in the given model
     * using the provided model map for reference.
     * 
     * @param i
     *            Influence to generate a script portion for
     * @param model
     *            Model containing the influence
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given influence.
     */
    @VisibleForTesting
    String generate(Influence i, QualityModel model, Map<String, QualityModel> modelMap)
    {
        InfluenceEffect eff = i.getEffect();
        i.getJustification();
        Target t = i.getTarget();

        StringBuilder builder = new StringBuilder();
        builder.append("\t\tinfluences ");

        if (t != null)
        {
            Factor f = (Factor) QualityModelUtils.findEntity(modelMap, t.getHREF());
            builder.append(f.getName());
        }
        if (eff != null)
        {
            if (eff == InfluenceEffect.NEGATIVE)
                builder.append(" Negatively");
            else
                builder.append(" Positively");
        }
        builder.append(";\n");

        return builder.toString();
    }

    /**
     * Generates the script section for the given evaluation in the given model
     * using the provided model map for reference.
     * 
     * @param ent
     *            Evaluation to generate a script portion for
     * @param model
     *            Model containing the evaluation
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given evaluation.
     */
    @VisibleForTesting
    String generate(Evaluation eval, QualityModel model, Map<String, QualityModel> modelMap)
    {
        String name = eval.getName();
        String type = eval.getType();
        Evaluates ev = eval.getEvaluates();
        // String title = eval.getTitle();
        BigDecimal maxpts = eval.getMaximumPoints();
        String comp = eval.getCompleteness();
        String spec = eval.getSpecification();
        List<Ranking> ranks = eval.getRankings();

        StringBuilder builder = new StringBuilder();
        builder.append("\tevaluation " + name + " : ");
        if (type != null)
        {
            switch (type)
            {
            case "qm:WeightedSumMultiMeasureEvaluation":
                builder.append("WeightedSumMultiMeasureEvaluation");
                break;
            case "qm:WeightedSumFactorAggregation":
                builder.append("WeightedSumFactorAggregation");
                break;
            case "qm:QIESLEvaluation":
                builder.append("QIESLEvaluation");
                break;
            }
        }

        builder.append(" -> ");
        if (ev != null)
        {
            Factor f = (Factor) QualityModelUtils.findEntity(modelMap, ev.getHREF());
            builder.append(f.getName());
        }
        // if (title != null) {
        // builder.append("\n\t\t(\"" + title + "\")");
        // }
        builder.append("[" + maxpts + ", ");
        if (comp != null)
            builder.append(comp + "%");
        builder.append(", ");
        if (spec != null)
            builder.append(spec);
        builder.append("] {\n");

        for (Ranking r : ranks)
            builder.append(generate(r, model, modelMap));
        builder.append("\n\t}\n");

        return builder.toString();
    }

    /**
     * Generates the script section for the given ranking in the given model
     * using the provided model map for reference.
     * 
     * @param r
     *            Ranking to generate a script portion for
     * @param model
     *            Model containing the ranking
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given ranking.
     */
    @VisibleForTesting
    String generate(Ranking r, QualityModel model, Map<String, QualityModel> modelMap)
    {
        MeasureLink m = r.getMeasure();
        FactorLink f = r.getFactor();
        Function fn = r.getFunction();
        String name = r.getName();
        NormalizationRange range = r.getRange();
        String rank = r.getRank();
        String weight = r.getWeight();
        NormalizationMeasure nm = r.getNormalizationMeasure();
        String desc = r.getDescription();

        StringBuilder builder = new StringBuilder();
        builder.append("\t\tranking");
        if (m != null)
        {
            Measure me = (Measure) QualityModelUtils.findEntity(modelMap, m.getHREF());
            builder.append(" measure " + me.getName().replaceAll(" ", "_"));
        }
        else if (f != null)
        {
            Factor fa = (Factor) QualityModelUtils.findEntity(modelMap, f.getHREF());
            builder.append(" factor " + fa.getName().replaceAll(" ", "_"));
        }
        builder.append(" (" + rank + ", " + weight + ")");
        if (range != null)
        {
            builder.append("\n\t\t\t@");
            switch (range)
            {
            case CLASS:
                builder.append("Class");
                break;
            case FILE:
                builder.append("File");
                break;
            case METHOD:
                builder.append("Method");
                break;
            case NA:
                builder.append("NA");
                break;
            }
        }
        builder.append(" using ");

        if (fn != null)
        {
            builder.append(generate(fn, model, modelMap));
        }

        if (nm != null)
        {
            Measure ms = (Measure) QualityModelUtils.findEntity(modelMap, nm.getHREF());
            builder.append(" normalizedBy " + ms.getName());
        }
        builder.append(";\n");

        return builder.toString();
    }

    /**
     * Generates the script section for the given function in the given model
     * using the provided model map for reference.
     * 
     * @param fn
     *            Function to generate a script portion for
     * @param model
     *            Model containing the function
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given Function.
     */
    @VisibleForTesting
    String generate(Function fn, QualityModel model, Map<String, QualityModel> modelMap)
    {
        BigDecimal lb = fn.getLowerBound();
        String type = fn.getType();
        BigDecimal ub = fn.getUpperBound();

        StringBuilder builder = new StringBuilder();
        builder.append("function : ");
        if (type != null)
            builder.append(type.substring(3));
        builder.append("(" + lb + ", " + ub + ")");

        return builder.toString();
    }

    /**
     * Generates the script section for the given measure in the given model
     * using the provided model map for reference.
     * 
     * @param ent
     *            Entity to generate a script portion for
     * @param model
     *            Model containing the measure
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given measure.
     */
    @VisibleForTesting
    String generate(Measure meas, QualityModel model, Map<String, QualityModel> modelMap)
    {
        List<Annotation> anns = meas.getAnnotations();
        OriginatesFrom of = meas.getOriginatesFrom();
        Characterizes ch = meas.getCharacterizes();
        String desc = meas.getDescription();
        List<Measure> ms = meas.getMeasures();
        String name = meas.getName();
        Set<Parent> p = meas.getParents();
        Refines ref = meas.getRefines();
        String tb = meas.getTaggedBy();
        String title = meas.getTitle();
        String type = meas.getType();
        boolean norm = meas.isNomalizationMeasure();

        StringBuilder builder = new StringBuilder();
        for (Annotation a : anns)
        {
            builder.append("\t@" + a.getKey() + " " + a.getValue() + "\n");
        }
        if (of != null)
        {
            Source src = (Source) QualityModelUtils.findEntity(modelMap, of.getHREF());
            builder.append("\t@originatesFrom " + src.getName().replaceAll(" ", "_") + "\n");
        }
        if (tb != null)
        {
            Tag t = (Tag) QualityModelUtils.findEntity(modelMap, tb);
            if (t != null)
                builder.append("\t@taggedBy " + t.getName().replaceAll(" ", "_") + "\n");
        }
        if (norm)
        {
            builder.append("\tnormalization-measure ");
        }
        else
        {
            builder.append("\tmeasure ");
        }
        builder.append(name.replaceAll(" ", "_"));
        if (ch != null)
        {
            Entity e = (Entity) QualityModelUtils.findEntity(modelMap, ch.getHREF());
            builder.append("@" + e.getName().replaceAll(" ", "_"));
        }
        if (!p.isEmpty())
        {
            builder.append(" < ");
            Parent[] ps = p.toArray(new Parent[0]);
            for (int i = 0; i < ps.length; i++)
            {
                AbstractEntity m = QualityModelUtils.findEntity(modelMap, ps[i].getHREF());
                if (i >= 1)
                    builder.append(", ");
                if (m instanceof Measure)
                    builder.append(((Measure) m).getName().replaceAll(" ", "_"));
                else if (m instanceof Factor)
                    builder.append(((Factor) m).getName().replaceAll(" ", "_"));
            }
        }

        builder.append(" : " + type);
        // if (title != null)
        // builder.append("\n\t\t(\"" + title + "\")");
        // if (desc != null)
        // builder.append("\n\t\t[\"" + desc + "\")");
        if (!ms.isEmpty())
        {
            builder.append("{\n");
            for (Measure mea : ms)
            {
                builder.append(generate(mea, model, modelMap) + "\n");
            }
            builder.append("\t}");
        }
        else
        {
            builder.append(";\n\n");
        }

        return builder.toString();
    }

    /**
     * Generates the script section for the given measurement method in the
     * given model using the provided model map for reference.
     * 
     * @param meth
     *            MeasurementMethod to generate a script portion for
     * @param model
     *            Model containing the measurement method
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given measurement method.
     */
    @VisibleForTesting
    String generate(MeasurementMethod meth, QualityModel model, Map<String, QualityModel> modelMap)
    {
        List<Annotation> anns = meth.getAnnotations();
        String desc = meth.getDescription();
        Determines det = meth.getDetermines();
        String met = meth.getMetric();
        String name = meth.getName();
        OriginatesFrom of = meth.getOriginatesFrom();
        String tool = meth.getTool();
        String type = meth.getType();

        StringBuilder builder = new StringBuilder();
        for (Annotation a : anns)
        {
            builder.append("\t@" + a.getKey() + " " + a.getValue() + "\n");
        }
        if (of != null)
        {
            Source src = (Source) QualityModelUtils.findEntity(modelMap, of.getHREF());
            builder.append("\t@originatesFrom " + src.getName().replaceAll(" ", "_") + "\n");
        }
        // if (tb != null) {
        // Tag t = (Tag) QualityModelUtils.findEntity(modelMap, tb);
        // builder.append("\t@taggedBy " + t.getName() + "\n");
        // }
        builder.append("\tmethod ");
        if (name != null)
            builder.append(name.replaceAll(" ", "_"));
        else if (met != null)
            builder.append(met);
        builder.append(" : ");

        builder.append(type.substring(3));
        if (det != null)
        {
            builder.append(" -> ");
            Measure d = (Measure) QualityModelUtils.findEntity(modelMap, det.getHREF());
            builder.append(d.getName().replaceAll(" ", "_"));
        }
        if (tool != null)
        {
            builder.append(" by ");
            Tool t = (Tool) QualityModelUtils.findEntity(modelMap, tool);
            builder.append(t.getName().replaceAll(" ", "_"));
        }
        if (desc != null)
        {
            builder.append("\n\t\t[\"" + desc + "\"]");
        }
        builder.append(";\n\n");

        return builder.toString();
    }

    /**
     * Generates the script section for the given tool in the given model
     * using the provided model map for reference.
     * 
     * @param tool
     *            Tool to generate a script portion for
     * @param model
     *            Model containing the tool
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given tool.
     */
    @VisibleForTesting
    String generate(Tool tool, QualityModel model, Map<String, QualityModel> modelMap)
    {
        List<Annotation> anns = tool.getAnnotations();
        String desc = tool.getDescription();
        String name = tool.getName();
        OriginatesFrom of = tool.getOriginatesFrom();

        StringBuilder builder = new StringBuilder();
        for (Annotation a : anns)
        {
            builder.append("\t@" + a.getKey() + " " + a.getValue() + "\n");
        }
        builder.append("\ttool " + name.replaceAll(" ", "_"));
        if (of != null)
        {
            Source src = (Source) QualityModelUtils.findEntity(modelMap, of.getHREF());
            builder.append(" from " + src.getName().replaceAll(" ", "_"));
        }
        if (desc != null)
        {
            builder.append(" [\"" + desc + "\"]");
        }
        builder.append(";\n\n");
        return builder.toString();
    }

    /**
     * Generates the script section for the given tag in the given model
     * using the provided model map for reference.
     * 
     * @param tg
     *            Tag to generate a script portion for
     * @param model
     *            Model containing the entity
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given tag.
     */
    @VisibleForTesting
    String generate(Tag tg, QualityModel model, Map<String, QualityModel> modelMap)
    {
        String desc = tg.getDescription();
        String name = tg.getName();

        StringBuilder builder = new StringBuilder();
        builder.append("\ttag " + name);
        if (desc != null)
            builder.append(" [\"" + desc + "\"]");
        builder.append(";\n");

        return builder.toString();
    }

    /**
     * Generates the script section for the given source in the given model
     * using the provided model map for reference.
     * 
     * @param s
     *            Source to generate a script portion for
     * @param model
     *            Model containing the source
     * @param modelMap
     *            Map of existing quality models, indexed by identifier, from
     *            which to lookup references
     * @return String representing the portion of the given Model's script for
     *         the given source.
     */
    @VisibleForTesting
    String generate(Source s, QualityModel model, Map<String, QualityModel> modelMap)
    {
        List<Annotation> anns = s.getAnnotations();
        String name = s.getName();
        String desc = s.getDescription();
        String url = null;

        StringBuilder builder = new StringBuilder();
        for (Annotation a : anns)
        {
            if (a.getKey().equals("url"))
                url = a.getValue();
            else
                builder.append("\t@" + a.getKey() + " " + a.getValue() + "\n");
        }
        builder.append("\tsource " + name);
        if (url != null)
            builder.append(" @ " + url);
        if (desc != null)
            builder.append("\n\t\t[\"" + desc + "\"]");
        builder.append(";\n");

        return builder.toString();
    }

    /**
     * Saves the script text for the given model name to the given folder.
     * 
     * @param modelName
     *            Name of the model to save
     * @param folder
     *            Folder in which to save the model
     * @param text
     *            Text representing the script to save
     */
    public void saveOutput(String modelName, String folder, String text)
    {
        Path p = Paths.get(folder + "/" + modelName + ".qm");

        try
        {
            Files.deleteIfExists(p);
        }
        catch (IOException e1)
        {
            e1.printStackTrace();
        }

        try (PrintWriter pw = new PrintWriter(
                Files.newBufferedWriter(p, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)))
        {
            pw.println(text);
            pw.flush();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
