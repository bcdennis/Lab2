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
public class ArticleTest {
    private Article art;

    @Before
    public void setUp() throws Exception {
        Reference.instanceCount = ReferenceTest.ID_INDEX;
        art = new Article("HappyAuthor", "HappyTitle", 2000, "HappyJournal", 1, 10);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetBibtexEntry() throws Exception {
        String expected = "@ARTICLE { REF" + (ReferenceTest.ID_INDEX  + ReferenceTest.ID_OFFSET) + ",\n"
                + "author = \"HappyAuthor\",\n"
                + "title = \"HappyTitle\",\n"
                + "journal = \"HappyJournal\",\n"
                + "pages = \"1-10\",\n"
                + "year = \"2000\"\n"
                + "},\n";

        assertEquals(expected.replaceAll("\\s+",""), art.getBibtexEntry().replaceAll("\\s+",""));
    }

    @Test
    public void testGetStartingPage() throws Exception {
        assertEquals(1, art.getStartingPage());
    }

    @Test
    public void testSetEndingPageLessThanStartingPage() throws Exception {
        art.setEndingPage(-1);
        assertEquals(art.getStartingPage(), art.getEndingPage());

    }


    @Test
    public void testSetStartingPageLessThanZero() throws Exception {
        art.setStartingPage(-1);
        assertEquals(1, art.getStartingPage());

    }

    @Test
    public void testSetStartingPage() throws Exception {
        art.setStartingPage(2);
        String expected = "@ARTICLE { REF" + (ReferenceTest.ID_INDEX  + ReferenceTest.ID_OFFSET) + ",\n"
                + "author = \"HappyAuthor\",\n"
                + "title = \"HappyTitle\",\n"
                + "journal = \"HappyJournal\",\n"
                + "pages = \"2-10\",\n"
                + "year = \"2000\"\n"
                + "},\n";

        assertEquals(expected.replaceAll("\\s+",""), art.getBibtexEntry().replaceAll("\\s+",""));
    }

    @Test
    public void testGetEndingPage() throws Exception {
        assertEquals(10, art.getEndingPage());
    }

    @Test
    public void testSetEndingPage() throws Exception {
        art.setEndingPage(2);
        String expected = "@ARTICLE { REF" + (ReferenceTest.ID_INDEX  + ReferenceTest.ID_OFFSET) + ",\n"
                + "author = \"HappyAuthor\",\n"
                + "title = \"HappyTitle\",\n"
                + "journal = \"HappyJournal\",\n"
                + "pages = \"1-2\",\n"
                + "year = \"2000\"\n"
                + "},\n";

        assertEquals(expected.replaceAll("\\s+",""), art.getBibtexEntry().replaceAll("\\s+",""));
    }

    @Test
    public void testGetJournal() throws Exception {
        assertEquals("HappyJournal", art.getJournal());
    }

    @Test
    public void testSetJournal() throws Exception {
        art.setJournal("HappyJournal2");
        String expected = "@ARTICLE { REF" + (ReferenceTest.ID_INDEX  + ReferenceTest.ID_OFFSET) + ",\n"
                + "author = \"HappyAuthor\",\n"
                + "title = \"HappyTitle\",\n"
                + "journal = \"HappyJournal2\",\n"
                + "pages = \"1-10\",\n"
                + "year = \"2000\"\n"
                + "},\n";

        assertEquals(expected.replaceAll("\\s+",""), art.getBibtexEntry().replaceAll("\\s+",""));

    }
}