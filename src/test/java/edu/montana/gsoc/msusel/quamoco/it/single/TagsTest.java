package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.Tag;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TagsTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testTag() {
        Tag t = manager.findTagByName("Test Tag");
        assertNotNull(t);

        assertEquals("Test Tag", t.getName());
        assertEquals("Test Tag", t.getDescription());
        assertEquals("Test Tag", t.getTitle());
        assertNotNull(t.getOriginatesFrom());
        assertEquals("Test Source", t.getOriginatesFrom().getName());
    }

    @Test
    public void testHierTag() {
        Tag t = manager.findTagByName("TestHier Tag");
        assertNotNull(t);

        assertEquals("TestHier Tag", t.getName());
        assertEquals("TestHier Tag", t.getDescription());
        assertEquals("TestHier Tag", t.getTitle());
    }
}
