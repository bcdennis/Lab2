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
public class BookTest {
    Book book;

    @Before
    public void setUp() throws Exception {
        Reference.instanceCount = ReferenceTest.ID_INDEX;
        book = new Book("HappyAuthor", "HappyTitle", 2000, "HappyPublisher");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetBibtexEntry() throws Exception {
        String expected = "@BOOK { REF" + (ReferenceTest.ID_INDEX  + ReferenceTest.ID_OFFSET) + ",\n"
                + "author = \"HappyAuthor\",\n"
                + "title = \"HappyTitle\",\n"
                + "publisher = \"HappyPublisher\",\n"
                + "year = \"2000\"\n"
                + "},\n";

        assertEquals(expected.replaceAll("\\s+",""), book.getBibtexEntry().replaceAll("\\s+",""));
    }

    @Test
    public void testGetPublisher() throws Exception {
        assertEquals("HappyPublisher", book.getPublisher());
    }

    @Test
    public void testSetPublisher() throws Exception {
        book.setPublisher("SomePublisher");
        assertEquals("SomePublisher", book.getPublisher());
    }
}