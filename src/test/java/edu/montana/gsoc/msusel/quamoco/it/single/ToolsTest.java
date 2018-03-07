package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.Tool;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ToolsTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTool() {
        Tool t = manager.findToolByName("Test Tool");
        assertNotNull(t);

        assertEquals("Test Tool", t.getName());
        assertEquals("Test Tool", t.getDescription());
        assertEquals("Test Tool", t.getTitle());
        assertNotNull(t.getOriginatesFrom());
        assertEquals("Test Source", t.getOriginatesFrom().getName());
        assertEquals(1, t.getTaggedBy().size());
        assertEquals("Test Tag", t.getTaggedBy().get(0).getName());
    }

    @Test
    public void testToolHier() {
        Tool t = manager.findToolByName("TestHierTool");
        assertNotNull(t);

        assertEquals("TestHierTool", t.getName());
        assertEquals("TestHierTool", t.getTitle());
        assertEquals("Test Hier Tool", t.getDescription());
        assertNotNull(t.getOriginatesFrom());
        assertEquals("TestHier Source", t.getOriginatesFrom().getName());
        assertEquals(1, t.getTaggedBy().size());
        assertEquals("TestHier Tag", t.getTaggedBy().get(0).getName());
    }
}
