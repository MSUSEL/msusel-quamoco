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
/**
 *
 */
package edu.montana.gsoc.msusel.quamoco.distiller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import edu.montana.gsoc.msusel.quamoco.model.*;
import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import edu.montana.gsoc.msusel.quamoco.graph.INode;

import static org.mockito.Mockito.mock;

/**
 * The class <code>QualityModelUtilsTest</code> contains tests for the class
 * <code>{@link QualityModelUtils}</code>.
 *
 * @author isaac
 * @version $Revision: 1.0 $
 */
public class QualityModelUtilsTest {

    private List<QualityModel> models;

    public Map<String, QualityModel> createModelMap() {
        final Map<String, QualityModel> modelMap = Maps.newHashMap();
        modelMap.put("java", QualityModel.builder().name("java").fileName("java.qm").identifier("ID").create());
        return modelMap;
    }

    /**
     * Run the Map<String, QualityModel> createModelMap(List<QualityModel>)
     * method test.
     */
    @Test
    public void testCreateModelMap_1() throws Exception {
        final Map<String, QualityModel> result = QualityModelUtils.createModelMap(models);

        Assert.assertNotNull(result);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(true, result.containsKey("java"));
        Assert.assertEquals(true, result.containsKey("csharp"));
        Assert.assertEquals(true, result.containsKey("object"));
        Assert.assertEquals(true, result.containsKey("root"));
    }

    /**
     * Run the Map<String, QualityModel> createModelMap(List<QualityModel>)
     * method test.
     */
    @Test
    public void testCreateModelMap_2() throws Exception {
        models.add(null);
        final Map<String, QualityModel> result = QualityModelUtils.createModelMap(models);

        Assert.assertNotNull(result);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(true, result.containsKey("java"));
        Assert.assertEquals(true, result.containsKey("csharp"));
        Assert.assertEquals(true, result.containsKey("object"));
        Assert.assertEquals(true, result.containsKey("root"));
    }

    /**
     * Run the QMElement findEntity(Map<String,QualityModel>,String) method
     * test.
     */
    @Test
    public void testFindEntity_1() throws Exception {
        final Map<String, QualityModel> modelMap = Maps.newHashMap();
        final String id = "java";

        final QMElement result = QualityModelUtils.findEntity(modelMap, id);

        Assert.assertNull(result);
    }

    /**
     * Run the QMElement findEntity(Map<String,QualityModel>,String) method
     * test.
     */
    @Test
    public void testFindEntity_2() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();
        final String id = "ID";

        final QMElement result = QualityModelUtils.findEntity(modelMap, id);

        Assert.assertNull(result);
    }

    /**
     * Run the QMElement findEntity(Map<String,QualityModel>,String) method
     * test.
     */
    @Test
    public void testFindEntity_3() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();
        final String id = "java.qm#mock-object";

        final Evaluation entity = SingleMeasureEvaluation.builder().identifier("mock-object").create();
        modelMap.get("java").addEvaluation(entity);

        final QMElement result = QualityModelUtils.findEntity(modelMap, id);

        Assert.assertNotNull(result);
        Assert.assertEquals(entity, result);
    }

    /**
     * Run the QMElement findEntity(Map<String,QualityModel>,String) method
     * test.
     */
    @Test
    public void testFindEntity_4() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();

        final Evaluation entity = SingleMeasureEvaluation.builder().identifier("mock-object").create();
        modelMap.get("java").addEvaluation(entity);

        final QMElement result = QualityModelUtils.findEntity(modelMap, "java.qm#other");

        Assert.assertNull(result);
    }

    /**
     * Run the QMElement findEntity(Map<String,QualityModel>,String) method
     * test.
     */
    @Test
    public void testFindEntity_5() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();

        final Evaluation entity = SingleMeasureEvaluation.builder().identifier("mock-object").create();
        modelMap.get("java").addEvaluation(entity);

        final QMElement result = QualityModelUtils.findEntity(modelMap, entity.getQualifiedIdentifier());

        Assert.assertNotNull(result);
        Assert.assertEquals(entity, result);
    }

    /**
     * Run the QMElement findEntity(Map<String,QualityModel>,String) method
     * test.
     */
    @Test
    public void testFindEntity_6() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();

        final Evaluation entity = SingleMeasureEvaluation.builder().identifier("mock-object").create();
        modelMap.get("java").addEvaluation(entity);

        final QMElement result = QualityModelUtils.findEntity(modelMap, "other");

        Assert.assertNull(result);
    }

    /**
     * Run the QMElement findEntity(Map<String,QualityModel>,String) method
     * test.
     */
    @Test
    public void testFindEntity_7() throws Exception {
        final Map<String, QualityModel> modelMap = null;

        final String id = "java";
        final QMElement result = QualityModelUtils.findEntity(modelMap, id);

        Assert.assertNull(result);
    }

    /**
     * Run the QMElement findEntity(Map<String,QualityModel>,String) method
     * test.
     */
    @Test
    public void testFindEntity_8() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();

        final String id = null;
        final QMElement result = QualityModelUtils.findEntity(modelMap, id);

        Assert.assertNull(result);
    }

    /**
     * Run the List<MeasurementMethod> getAllMeasurementMethods(List
     * <QualityModel>) method test.
     */
    @Test
    public void testGetAllMeasurementMethods_1() throws Exception {
        final List<QualityModel> models = null;
        final List<MeasurementMethod> result = QualityModelUtils.getAllMeasurementMethods(models);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    /**
     * Run the List<MeasurementMethod> getAllMeasurementMethods(List
     * <QualityModel>) method test.
     */
    @Test
    public void testGetAllMeasurementMethods_2() throws Exception {
        final List<QualityModel> models = Lists.newArrayList();
        final List<MeasurementMethod> result = QualityModelUtils.getAllMeasurementMethods(models);

        Assert.assertNotNull(result);
        Assert.assertTrue(result.isEmpty());
    }

    /**
     * Run the List<MeasurementMethod> getAllMeasurementMethods(List
     * <QualityModel>) method test.
     */
    @Test
    public void testGetAllMeasurementMethods_3() throws Exception {
        Tool tool = mock(Tool.class);
        final MeasurementMethod mm1 = RuleBasedInstrument.builder().identifier("mm1").tool(Tool.builder().identifier("java.qm#mm1").create()).create();
        final MeasurementMethod mm2 = RuleBasedInstrument.builder().identifier("mm2").tool(Tool.builder().identifier("java.qm#mm2").create()).create();
        final MeasurementMethod mm3 = RuleBasedInstrument.builder().identifier("mm3").tool(Tool.builder().identifier("java.qm#mm3").create()).create();
        models.get(0).addMeasurementMethod(mm1);
        models.get(0).addMeasurementMethod(mm2);
        models.get(1).addMeasurementMethod(mm3);
        final List<MeasurementMethod> result = QualityModelUtils.getAllMeasurementMethods(models);

        Assert.assertNotNull(result);
        Assert.assertEquals(false, result.isEmpty());
        Assert.assertEquals(3, result.size());
    }

    /**
     * Run the Evaluation getEvaluates(Node,Map<String,QualityModel>) method
     * test.
     */
    @Test
    public void testGetEvaluates_1() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();
        final String id = "java.qm#mock-object";

        final Evaluation entity = SingleMeasureEvaluation.builder().identifier("mock-object").create();
        modelMap.get("java").addEvaluation(entity);

        final INode dest = EasyMock.createMock(INode.class);
        EasyMock.expect(dest.getOwnedBy()).andReturn(id);
        EasyMock.replay(dest);

        final Evaluation result = QualityModelUtils.getEvaluates(dest, modelMap);

        Assert.assertEquals(entity, result);
    }

    /**
     * Run the Evaluation getEvaluates(Node,Map<String,QualityModel>) method
     * test.
     */
    @Test
    public void testGetEvaluates_2() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();
        final String id = "java.qm#mock-object";

        final Evaluation entity = SingleMeasureEvaluation.builder().identifier("mock-object").create();
        modelMap.get("java").addEvaluation(entity);

        final INode dest = EasyMock.createMock(INode.class);
        EasyMock.expect(dest.getOwnedBy()).andReturn(null);
        EasyMock.replay(dest);

        final Evaluation result = QualityModelUtils.getEvaluates(dest, modelMap);
        Assert.assertNull(result);
    }

    /**
     * Run the Evaluation getEvaluates(Node,Map<String,QualityModel>) method
     * test.
     */
    @Test
    public void testGetEvaluates_3() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();
        final String id = "java.qm#mock-object";

        final Evaluation entity = SingleMeasureEvaluation.builder().identifier("mock-object").create();
        modelMap.get("java").addEvaluation(entity);

        final INode dest = EasyMock.createMock(INode.class);
        EasyMock.expect(dest.getOwnedBy()).andReturn("java.qm#other");
        EasyMock.replay(dest);

        final Evaluation result = QualityModelUtils.getEvaluates(dest, modelMap);
        Assert.assertNull(result);
    }

    /**
     * Run the Factor getFactor(Node,Map<String,QualityModel>) method test.
     */
    @Test
    public void testGetFactor_1() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();
        final String id = "java.qm#mock-object";

        final Factor factor = ProductFactor.builder().name("mock-object").identifier(id).create();
        modelMap.get("java").addFactor(factor);

        final Factor result = QualityModelUtils.getFactor(factor.getQualifiedIdentifier(), modelMap);
        Assert.assertEquals(factor, result);
    }

    /**
     * Run the Factor getFactor(Node,Map<String,QualityModel>) method test.
     */
    @Test
    public void testGetFactor_2() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();
        final String id = "java.qm#mock-object";

        final Factor factor = ProductFactor.builder().name("mock-object").identifier(id).create();
        modelMap.get("java").addFactor(factor);

        final INode dest = EasyMock.createMock(INode.class);
        EasyMock.expect(dest.getOwnedBy()).andReturn(null);
        EasyMock.replay(dest);

        final Factor result = QualityModelUtils.getFactor(dest, modelMap);
        Assert.assertNull(result);
    }

    /**
     * Run the Factor getFactor(Node,Map<String,QualityModel>) method test.
     */
    @Test
    public void testGetFactor_3() throws Exception {
        final Map<String, QualityModel> modelMap = createModelMap();
        final String id = "java.qm#mock-object";

        final Factor factor = ProductFactor.builder().name("mock-object").identifier(id).create();
        modelMap.get("java").addFactor(factor);

        final INode dest = EasyMock.createMock(INode.class);
        EasyMock.expect(dest.getOwnedBy()).andReturn("java.qm#other");
        EasyMock.replay(dest);

        final Factor result = QualityModelUtils.getFactor(dest, modelMap);
        Assert.assertNull(result);
    }

    /**
     * Perform pre-test initialization.
     *
     * @throws Exception if the initialization fails for some reason
     */
    @Before
    public void setUp() throws Exception {
        models = Lists.newArrayList();
        final QualityModel qm1 = QualityModel.builder().name("java").fileName("java.qm").identifier("java").create();
        final QualityModel qm2 = QualityModel.builder().name("csharp").fileName("csharp.qm").identifier("csharp").create();
        final QualityModel qm3 = QualityModel.builder().name("root").fileName("root.qm").identifier("root").create();
        final QualityModel qm4 = QualityModel.builder().name("object").fileName("object.qm").identifier("object").create();
        models.add(qm1);
        models.add(qm2);
        models.add(qm3);
        models.add(qm4);
    }

    /**
     * Perform post-test clean-up.
     *
     * @throws Exception if the clean-up fails for some reason
     */
    @After
    public void tearDown() throws Exception {
        // TODO: add additional tear down code here
    }

    /**
     * Launch the test.
     *
     * @param args the command line arguments
     */
    public static void main(final String[] args) {
        new org.junit.runner.JUnitCore().run(QualityModelUtilsTest.class);
    }
}
