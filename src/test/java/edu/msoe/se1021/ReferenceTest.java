package edu.msoe.se1021;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * <p>
 * Name: Brad Dennis, Ph.D.
 * Created: 12/30/2015
 */
public class ReferenceTest {

    public static final int ID_INDEX = 0;
    public static final int ID_OFFSET = 0;
    public static final String ID_PREFIX = "";
    Reference  ref;

    @Before
    public void setUp() throws Exception {
        Reference.instanceCount = ID_INDEX;
        ref = new Reference("HappyAuthor", "HappyTitle", 2000);
    }

    @After
    public void tearDown() throws Exception {
        ref = null;
    }

    @Test
    public void testGetBibtexEntry() throws Exception {

        String expected = "@REFERENCE { REF" + (ID_INDEX + ID_OFFSET) + ",\n"
                + "author = \"HappyAuthor\",\n"
                + "title = \"HappyTitle\",\n"
                + "year = \"2000\"\n"
                + "},\n";

        assertEquals(expected.replaceAll("\\s+",""), ref.getBibtexEntry().replaceAll("\\s+",""));
    }

    @Test
    public void testGetAuthor() throws Exception {
        assertEquals("HappyAuthor", ref.getAuthor());
    }

    @Test
    public void testSetAuthor() throws Exception {
        ref.setAuthor("SomeAuthor");
        assertEquals("SomeAuthor", ref.getAuthor());
    }

    @Test
    public void testGetTitle() throws Exception {
        assertEquals("HappyTitle", ref.getTitle());

    }

    @Test
    public void testSetTitle() throws Exception {
        ref.setTitle("SomeTitle");

        assertEquals("SomeTitle", ref.getTitle());
    }

    @Test
    public void testGetPublicationYear() throws Exception {
        assertEquals(2000, ref.getPublicationYear());
    }

    @Test
    public void testSetPublicationYear() throws Exception {
        ref.setPublicationYear(1999);

        assertEquals(1999, ref.getPublicationYear());
    }

    @Test
    public void testPublicationYearAbsoluteValue() throws Exception {
        ref.setPublicationYear(-2000);

        assertEquals(2000, ref.getPublicationYear());
    }

    @Test
    public void testGetMyUniqueID() throws Exception {
        assertEquals(ID_PREFIX + (ID_INDEX + ID_OFFSET), ""+ref.getMyUniqueID());
    }

    @Test
    public void testMyUniqueIDIncrements() throws Exception {
        assertEquals(ID_PREFIX + (ID_INDEX + ID_OFFSET), ""+ref.getMyUniqueID());

        Reference ref2 = new Reference("HappyAuthor", "HappyTitle", 2000);

        assertEquals(ID_PREFIX + (ID_INDEX + ID_OFFSET + 1),""+ ref2.getMyUniqueID());
    }
}