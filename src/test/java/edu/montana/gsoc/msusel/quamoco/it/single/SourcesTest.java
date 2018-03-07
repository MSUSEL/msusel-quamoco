package edu.montana.gsoc.msusel.quamoco.it.single;

import edu.montana.gsoc.msusel.quamoco.model.Source;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SourcesTest extends BaseTestClass {

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSources() {
        Source s = manager.findSourceByName("Test Source");
        assertNotNull(s);

        assertEquals("Test Source", s.getName());
        assertEquals("Test Source", s.getDescription());
        assertEquals("Test Source", s.getTitle());
    }

    @Test
    public void testHierSources() {
        Source s = manager.findSourceByName("TestHier Source");
        assertNotNull(s);

        assertEquals("TestHier Source", s.getName());
        assertEquals("TestHier Source", s.getDescription());
        assertEquals("TestHier Source", s.getTitle());
    }
}
