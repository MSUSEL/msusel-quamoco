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
package edu.montana.gsoc.msusel.quamoco.processor;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.montana.gsoc.msusel.CodeTree;
import edu.montana.gsoc.msusel.node.FileNode;
import edu.montana.gsoc.msusel.node.MethodNode;
import edu.montana.gsoc.msusel.node.ProjectNode;
import edu.montana.gsoc.msusel.node.TypeNode;
import edu.montana.gsoc.msusel.quamoco.processor.MetricsContext;

/**
 * The class <code>MetricsContextTest</code> contains tests for the class
 * <code>{@link MetricsContext}</code>.
 *
 * @generatedBy CodePro at 2/1/16 4:21 PM
 * @author fate
 * @version $Revision: 1.0 $
 */
public class MetricsContextTest {

    private MetricsContext fixture;
    private FileNode       file;
    private TypeNode       type;
    private ProjectNode    project;
    private MethodNode     method;

    /**
     * Run the List<Double> getAllClassValues(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetAllClassValues_1() throws Exception
    {
        final String metric = "LOC";

        final List<Double> result = fixture.getAllClassValues(metric);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }

    /**
     * Run the List<Double> getAllClassValues(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllClassValues_2() throws Exception
    {
        final String metric = "";

        fixture.getAllClassValues(metric);
    }

    /**
     * Run the List<Double> getAllClassValues(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllClassValues_3() throws Exception
    {
        final String metric = null;

        fixture.getAllClassValues(metric);
    }

    /**
     * Run the List<Double> getAllFileValues(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetAllFileValues_1() throws Exception
    {
        final String metric = "LOC";

        final List<Double> result = fixture.getAllFileValues(metric);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result.size());
    }

    /**
     * Run the List<Double> getAllFileValues(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllFileValues_2() throws Exception
    {
        final String metric = "";

        fixture.getAllFileValues(metric);
    }

    /**
     * Run the List<Double> getAllFileValues(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllFileValues_3() throws Exception
    {
        final String metric = "";

        fixture.getAllFileValues(metric);
    }

    /**
     * Run the List<Double> getAllMethodValues(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetAllMethodValues_1() throws Exception
    {
        final String metric = "LOC";

        final List<Double> result = fixture.getAllMethodValues(metric);

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertEquals(4, result.size());
    }

    /**
     * Run the List<Double> getAllMethodValues(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllMethodValues_2() throws Exception
    {
        final String metric = "";

        fixture.getAllMethodValues(metric);
    }

    /**
     * Run the List<Double> getAllMethodValues(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetAllMethodValues_3() throws Exception
    {
        final String metric = null;

        fixture.getAllMethodValues(metric);
    }

    /**
     * Run the double getFileMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetFileMetric_1() throws Exception
    {
        final String file = "path";
        final String metric = "LOC";

        double result = fixture.getFileMetric(file, metric);

        // add additional test code here
        Assert.assertEquals(10.0, result, 0.1);
        result = fixture.getFileMetric("path2", metric);
        Assert.assertEquals(20.0, result, 0.1);
        result = fixture.getFileMetric("path3", metric);
        Assert.assertEquals(30.0, result, 0.1);
    }

    /**
     * Run the double getFileMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFileMetric_2() throws Exception
    {
        final String file = "";
        final String metric = "LOC";

        fixture.getFileMetric(file, metric);
    }

    /**
     * Run the double getFileMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFileMetric_3() throws Exception
    {
        final String file = null;
        final String metric = "LOC";

        fixture.getFileMetric(file, metric);
    }

    /**
     * Run the double getFileMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFileMetric_4() throws Exception
    {
        final String file = "path1";
        final String metric = "";

        fixture.getFileMetric(file, metric);
    }

    /**
     * Run the double getFileMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetFileMetric_5() throws Exception
    {
        final String file = "path1";
        final String metric = null;

        fixture.getFileMetric(file, metric);
    }

    /**
     * Run the double getFileMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetFileMetric_6() throws Exception
    {
        final String file = "test";
        final String metric = "LOC";

        final double result = fixture.getFileMetric(file, metric);

        // add additional test code here
        Assert.assertEquals(Double.NaN, result, 0.1);
    }

    /**
     * Run the MetricsContext getInstance() method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetInstance_1() throws Exception
    {
        final MetricsContext result = MetricsContext.getInstance();
        final MetricsContext result2 = MetricsContext.getInstance();

        // add additional test code here
        Assert.assertNotNull(result);
        Assert.assertNotNull(result2);
        Assert.assertSame(result, result2);
    }

    /**
     * Run the double getMethodMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodMetric_1() throws Exception
    {
        final String method = "";
        final String metric = "LOC";

        fixture.getMethodMetric(method, metric);
    }

    /**
     * Run the double getMethodMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodMetric_2() throws Exception
    {
        final String method = null;
        final String metric = "LOC";

        fixture.getMethodMetric(method, metric);
    }

    /**
     * Run the double getMethodMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodMetric_3() throws Exception
    {
        final String method = "method1";
        final String metric = "";

        fixture.getMethodMetric(method, metric);
    }

    /**
     * Run the double getMethodMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetMethodMetric_4() throws Exception
    {
        final String method = "method1";
        final String metric = null;

        fixture.getMethodMetric(method, metric);
    }

    /**
     * Run the double getMethodMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetMethodMetric_5() throws Exception
    {
        final String method = "Type#method1";
        final String metric = "LOC";

        final double result = fixture.getMethodMetric(method, metric);

        // add additional test code here
        Assert.assertEquals(Double.NaN, result, 0.1);
    }

    /**
     * Run the double getMethodMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetMethodMetric_6() throws Exception
    {
        final String method = "namespace.Type#method";
        final String metric = "LOC";

        final double result = fixture.getMethodMetric(this.method.getQIdentifier(), metric);

        // add additional test code here
        Assert.assertEquals(10.0, result, 0.1);
    }

    /**
     * Run the double getProjectMetric(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetProjectMetric_1() throws Exception
    {
        final String metric = null;

        fixture.getProjectMetric(metric);
    }

    /**
     * Run the double getProjectMetric(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetProjectMetric_2() throws Exception
    {
        final String metric = "";

        fixture.getProjectMetric(metric);
    }

    /**
     * Run the double getProjectMetric(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetProjectMetric_3() throws Exception
    {
        final String metric = "LOC";

        final double result = fixture.getProjectMetric(metric);

        // add additional test code here
        Assert.assertEquals(600.0, result, 0.1);
    }

    /**
     * Run the double getProjectMetric(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetProjectMetric_4() throws Exception
    {
        final String metric = "NIV";

        final double result = fixture.getProjectMetric(metric);

        // add additional test code here
        Assert.assertEquals(Double.NaN, result, 0.1);
    }

    /**
     * Run the double getProjectMetric(String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetProjectMetric_5() throws Exception
    {
        final String metric = "NOM";

        final double result = fixture.getProjectMetric("NOM");

        // add additional test code here
        Assert.assertEquals(Double.NaN, result, 0.1);
    }

    /**
     * Run the double getTypeMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetTypeMetric_1() throws Exception
    {
        final String type = "";
        final String metric = "LOC";

        fixture.getTypeMetric(type, metric);
    }

    /**
     * Run the double getTypeMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetTypeMetric_2() throws Exception
    {
        final String type = null;
        final String metric = "LOC";

        fixture.getTypeMetric(type, metric);
    }

    /**
     * Run the double getTypeMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetTypeMetric_3() throws Exception
    {
        final String type = "type1";
        final String metric = "";

        fixture.getTypeMetric(type, metric);
    }

    /**
     * Run the double getTypeMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGetTypeMetric_4() throws Exception
    {
        final String type = "type1";
        final String metric = null;

        fixture.getTypeMetric(type, metric);
    }

    /**
     * Run the double getTypeMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetTypeMetric_5() throws Exception
    {
        final double result = fixture.getTypeMetric("type4", "LOC");

        // add additional test code here
        Assert.assertEquals(Double.NaN, result, 0.1);
    }

    /**
     * Run the double getTypeMetric(String,String) method test.
     *
     * @throws Exception
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Test
    public void testGetTypeMetric_6() throws Exception
    {
        final double result = fixture.getTypeMetric("namespace.Type", "LOC");

        // add additional test code here
        Assert.assertEquals(10.0, result, 0.1);
    }

    @Test
    public void testGetParent_1() throws Exception
    {
        Assert.assertEquals(file, fixture.getParent(type));
    }

    @Test
    public void testGetParent_2() throws Exception
    {
        FileNode fn = FileNode.builder("test").create();
        Assert.assertNull(fixture.getParent(fn));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetParent_3() throws Exception
    {
        fixture.getParent(null);
    }

    @Test
    public void testUpdate_1() throws Exception
    {
        Assert.assertEquals(10.0, fixture.getFileMetric("path", "LOC"), 0.001);
        FileNode fn = FileNode.builder("path").parent(project.getQIdentifier()).metric("LOC", 20.0).create();

        fixture.update(fn);

        Assert.assertEquals(20.0, fixture.getFileMetric("path", "LOC"), 0.001);
    }

    @Test
    public void testUpdate_2() throws Exception
    {
        Assert.assertEquals(600.0, fixture.getProjectMetric("LOC"), 0.001);
        ProjectNode pn = ProjectNode.builder("Test").metric("LOC", 800.0).create();
        fixture.update(pn);
        Assert.assertEquals(800.0, fixture.getProjectMetric("LOC"), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdate_3() throws Exception
    {
        fixture.update(null);
    }

    @Test
    public void testUpdate_4() throws Exception
    {
        Assert.assertEquals(600.0, fixture.getProjectMetric("LOC"), 0.001);
        ProjectNode pn = ProjectNode.builder("Test2").metric("LOC", 800.0).create();
        fixture.update(pn);
        Assert.assertEquals(800.0, fixture.getProjectMetric("LOC"), 0.001);
        Assert.assertNotEquals(project.getName(), pn.getName());
    }

    @Test
    public void testUpdate_5() throws Exception
    {
        TypeNode tn = TypeNode.builder("Type", "namespace.Type").range(1, 100).metric("LOC", 20.0).create();
        fixture.update(tn);
        Assert.assertEquals(10.0, fixture.getTypeMetric("namespace.Type", "LOC"), 0.001);
    }

    @Test
    public void testMerge_1() throws Exception
    {
        fixture = MetricsContext.getCleanInstance();
        CodeTree tree = fixture.tree;
        fixture.tree = null;
        fixture.merge(null);

        assertNull(fixture.tree);
        fixture.tree = tree;
    }

    @Test
    public void testMerge_2() throws Exception
    {
        fixture.merge(null);

        assertNotNull(fixture.tree);
    }

    @Test
    public void testMerge_3() throws Exception
    {
        CodeTree tree = new CodeTree();
        ProjectNode pnode = ProjectNode.builder("Test2")
                .file(file = FileNode.builder("path4").create())
                .file(FileNode.builder("path5").create())
                .file(FileNode.builder("path6").create())
                .create();

        tree.setProject(pnode);

        fixture.merge(tree);

        assertNotNull(fixture.tree);
        assertEquals(3, fixture.tree.getUtils().getFiles().size());

    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception
     *             if the initialization fails for some reason
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @Before
    public void setUp() throws Exception
    {
        fixture = MetricsContext.getCleanInstance();
        final String metric = "LOC";

        CodeTree tree = new CodeTree();
        project = ProjectNode.builder("Test")
                .file(
                        file = FileNode.builder("path")
                                .type(
                                        type = TypeNode.builder("Type", "namespace.Type")
                                                .range(1, 100)
                                                .metric(metric, 10.0)
                                                .method(
                                                        method = MethodNode.builder("method", "namespace.Type#method")
                                                                .range(20, 100)
                                                                .metric("LOC", 10.0)
                                                                .create())
                                                .method(
                                                        MethodNode.builder("method1", "namespace.Type#method1")
                                                                .range(10, 20)
                                                                .metric("LOC", 10.0)
                                                                .create())
                                                .create())
                                .metric(metric, 10.0)
                                .create())
                .file(
                        FileNode.builder("path2")
                                .type(
                                        TypeNode.builder("Type2", "namespace.Type2")
                                                .range(1, 100)
                                                .metric(metric, 20.0)
                                                .method(
                                                        MethodNode.builder("method2", "namespace.Type2#method2")
                                                                .range(20, 50)
                                                                .metric(metric, 20.0)
                                                                .create())
                                                .create())
                                .metric(metric, 20.0)
                                .create())
                .file(
                        FileNode.builder("path3")
                                .type(
                                        TypeNode.builder("Type3", "namespace.Type3")
                                                .range(1, 100)
                                                .metric(metric, 30.0)
                                                .method(
                                                        MethodNode.builder("method3", "namespace.Type3#method3")
                                                                .range(20, 50)
                                                                .metric(metric, 30.0)
                                                                .create())
                                                .create())
                                .metric(metric, 30.0)
                                .create())
                .metric(metric, 600.0)
                .metric("NOM", 60.0)
                .create();

        tree.setProject(project);
        fixture.merge(tree);
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception
     *             if the clean-up fails for some reason
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    @After
    public void tearDown() throws Exception
    {
        // Add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args
     *            the command line arguments
     * @generatedBy CodePro at 2/1/16 4:21 PM
     */
    public static void main(final String[] args)
    {
        new org.junit.runner.JUnitCore().run(MetricsContextTest.class);
    }
}