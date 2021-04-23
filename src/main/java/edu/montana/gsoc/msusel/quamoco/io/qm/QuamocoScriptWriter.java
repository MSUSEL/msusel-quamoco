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
package edu.montana.gsoc.msusel.quamoco.io.qm;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import edu.montana.gsoc.msusel.quamoco.distiller.ModelDistiller;
import edu.montana.gsoc.msusel.quamoco.distiller.ModelManager;
import edu.montana.gsoc.msusel.quamoco.io.AbstractWriter;
import edu.montana.gsoc.msusel.quamoco.model.QualityModel;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.List;

/**
 * Tool to generate Quamoco Quality Model Scripts from the old style XML files
 * produced by the Quamoco Quality Model Editor.
 *
 * @author Isaac Griffith
 * @version 1.3.0
 */
@Log4j2
public class QuamocoScriptWriter extends AbstractWriter {

    /**
     * Logger associated with this class
     */
    private static final Logger LOG = LoggerFactory.getLogger(QuamocoScriptWriter.class);
    /**
     * Command line options object associated with this class.
     */
    private static final Options options;

    /**
     * Initializes the command line options object.
     */
    static {
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
        QuamocoScriptWriter.options.addOption(help);
        QuamocoScriptWriter.options.addOption(output);
    }

    /**
     * Starting point of execution.
     *
     * @param args Raw command line arguments.
     */
    public static void main(final String... args) {
        ModelManager manager = new ModelManager();
        final ModelDistiller dqm = new ModelDistiller(manager);
        final CommandLineParser parser = new DefaultParser();
        try {
            final CommandLine line = parser.parse(QuamocoScriptWriter.options, args);
            QuamocoScriptWriter.execute(line);
        } catch (final ParseException exp) {
            log.error("Parsing failed. Reason: " + exp.getMessage());
        }
    }

    /**
     * Executes the process as guided by the options in the given CommandLine
     *
     * @param line CommandLine used for processing command line options
     */
    @VisibleForTesting
    private static void execute(CommandLine line) {
        QuamocoScriptWriter gen = new QuamocoScriptWriter();

        if (line.getOptions().length == 0 || line.hasOption('h')) {
            final HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar QuamocoScriptGen", QuamocoScriptWriter.options, true);
            return;
        }
        String folder = null;
        if (line.hasOption('o')) {
            folder = line.getOptionValue('o');
        }

        List<QualityModel> models = gen.readInQualityModels("root", "object", "java", "csharp");

        if (folder != null) {
            for (QualityModel model : models) {
                gen.saveOutput(model.getName(), folder, gen.generate(model));
            }
        }

    }

    private void saveOutput(String name, String folder, String generate) {
    }

    /**
     * Reads quality models from the Jar
     *
     * @param args list of quality models to be read from the Jar file.
     * @return List of Quality Model objects created from the read files.
     */
    @VisibleForTesting
    private List<QualityModel> readInQualityModels(final String... args) {
        ModelManager manager = new ModelManager();
        final QMXMLReader qmRead = new QMXMLReader(manager);
        final List<QualityModel> models = Lists.newArrayList();
        if (args != null) {
            for (final String arg : args) {
                qmRead.read(arg);
            }
        }
        return models;
    }

    /**
     * Constructs a new QuamocoScriptGen
     */
    private QuamocoScriptWriter() {
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void writeData(QualityModel qm, PrintWriter pw) {

    }

    /**
     * For the given quality model and model map, this method generates the
     * script string for the given quality model
     *
     * @param model Quality Model for which a script is to be generated
     * @return String representing the script for the given quality model
     */
    private String generate(QualityModel model) {
        return "";
    }
}
