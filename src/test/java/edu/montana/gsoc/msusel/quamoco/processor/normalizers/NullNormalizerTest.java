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
package edu.montana.gsoc.msusel.quamoco.processor.normalizers;

import com.google.common.collect.Sets;
import edu.isu.isuese.datamodel.File;
import edu.montana.gsoc.msusel.quamoco.graph.edge.MeasureToMeasureNumberEdge;
import edu.montana.gsoc.msusel.quamoco.graph.node.FileFinding;
import edu.montana.gsoc.msusel.quamoco.graph.node.Finding;
import edu.montana.gsoc.msusel.quamoco.model.NormalizationRange;
import org.javalite.activejdbc.test.DBSpec;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * The class <code>NullNormalizerTest</code> contains tests for the class
 * <code>{@link NullNormalizer}</code>.
 *
 * @author fate
 * @version $Revision: BigDecimal.ONE $
 */
public class NullNormalizerTest extends DBSpec {

    private NullNormalizer fixture;

    /**
     * Run the NullNormalizer(Edge,String,NormalizationRange) constructor test.
     */
    @Test
    public void testNullNormalizer_1() throws Exception {
        final NormalizationRange range = NormalizationRange.CLASS;

        final NullNormalizer result = new NullNormalizer(
                new MeasureToMeasureNumberEdge("edge", null, null), "LOC", range);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals("LOC", result.getMetric());
    }

    /**
     * Run the BigDecimal normalize(List<Finding>) method test.
     */
    @Test
    public void testNormalize_2() throws Exception {
        final Set<Finding> findings = Sets.newHashSet();
        findings.add(new FileFinding(File.builder().fileKey("path").create(), "issue", "issue"));
        final double result = fixture.normalize(findings);

        // add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Run the BigDecimal normalize(List<Finding>) method test.
     */
    @Test
    public void testNormalize_3() throws Exception {
        final Set<Finding> findings = null;
        final double result = fixture.normalize(findings);

        // add additional test code here
        Assert.assertEquals(0.0, result, 0.001);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     */
    @Before
    public void setUp() throws Exception {
        fixture = new NullNormalizer(
                new MeasureToMeasureNumberEdge("edge", null, null), "LOC", NormalizationRange.CLASS);
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     */
    @After
    public void tearDown() throws Exception {
        // Add additional tear down code here
    }
}