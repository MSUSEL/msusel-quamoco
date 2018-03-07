package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.QualityModel;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class ModelTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testModelTest() {
        QualityModel model = manager.getModelByName("Test");
        assertNotNull(model);

        assertEquals("Test", model.getName());
        assertEquals(0.98, model.getGradeBoundary2(), 0.001);
        assertEquals(0.96, model.getGradeBoundary3(), 0.001);
        assertEquals(0.94, model.getGradeBoundary4(), 0.001);
        assertEquals(0.92, model.getGradeBoundary5(), 0.001);
        assertEquals(0.90, model.getGradeBoundary6(), 0.001);
    }

    @Test
    public void testModelTestHier() {
        QualityModel model = manager.getModelByName("TestHier");
        assertNotNull(model);

        System.out.println("Tag: " + manager.findTag("Test.qm#_HDZAEBUEEei0lMAbFVod2Q"));

        assertEquals("TestHier", model.getName());
        assertEquals("Test Source", model.getOriginatesFrom().getName());
        assertEquals("Test Tag", model.getTaggedBy().get(0).getName());
        assertFalse(model.getRequires().isEmpty());
        assertEquals(0.98, model.getGradeBoundary2(), 0.001);
        assertEquals(0.96, model.getGradeBoundary3(), 0.001);
        assertEquals(0.94, model.getGradeBoundary4(), 0.001);
        assertEquals(0.92, model.getGradeBoundary5(), 0.001);
        assertEquals(0.90, model.getGradeBoundary6(), 0.001);
    }
}
