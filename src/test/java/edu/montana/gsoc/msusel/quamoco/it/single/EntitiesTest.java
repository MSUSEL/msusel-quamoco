package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.entity.Entity;
import org.junit.After;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EntitiesTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testComment() {
        Entity e = manager.findEntityByName("Comment");
        assertNotNull(e);

        assertTrue(e.hasIsAs());
        assertEquals("Product Part", e.isAs().get(0).getName());
        assertEquals("Test Source", e.getOriginatesFrom().getName());
        assertTrue(e.hasTags());
        assertEquals("Test Tag", e.getTaggedBy().get(0).getName());
    }

    @Test
    public void testProduct() {
        Entity e = manager.findEntityByName("Product");
        assertNotNull(e);

        assertEquals("Test Source", e.getOriginatesFrom().getName());
    }

    @Test
    public void testProductPart() {
        Entity e = manager.findEntityByName("Product Part");
        assertNotNull(e);

        assertEquals("Product", e.getPartOf().getName());
        assertEquals("Test Source", e.getOriginatesFrom().getName());
    }

    @Test
    public void testSourceCode() {
        Entity e = manager.findEntityByName("Source Code");
        assertNotNull(e);

        assertEquals("Product", e.getPartOf().getName());
        assertEquals("Test Source", e.getOriginatesFrom().getName());
    }

    @Test
    public void testSourceCodePart() {
        Entity e = manager.findEntityByName("Source Code Part");
        assertNotNull(e);

        assertTrue(e.hasIsAs());
        assertEquals("Product Part", e.isAs().get(0).getName());
        assertEquals("Source Code", e.getPartOf().getName());
        assertEquals("Test Source", e.getOriginatesFrom().getName());
    }

    @Test
    public void testClass() {
        Entity e = manager.findEntityByName("Class");
        assertNotNull(e);

        assertEquals("Type", e.getTitle());
        assertEquals("Class Type", e.getDescription());
        assertEquals("TestHier Source", e.getOriginatesFrom().getName());
        assertEquals("TestHier Tag", e.getTaggedBy().get(0).getName());
        assertTrue(e.hasIsAs());
        assertEquals("Source Code Part", e.isAs().get(0).getName());
    }
}
