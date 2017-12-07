package edu.msoe.se1021;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

/**
 * SE1021 – 031 & 032
 * Winter 2016
 * <p>
 * Name: Brad Dennis, Ph.D.
 * Created: 12/30/2015
 */
public class ReferenceHolderTest {
    private ReferenceHolder holder;
    private String expected;
    private final ByteArrayOutputStream sout = new ByteArrayOutputStream();
    private final ByteArrayOutputStream serr = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        Reference.instanceCount = ReferenceTest.ID_INDEX;

        System.setOut(new PrintStream(sout));
        System.setErr(new PrintStream(serr));

        holder = new ReferenceHolder();
        Reference ref1 = new Reference("HappyAuthor", "HappyTitle", 2000);
        Reference ref2 = new Reference("HappyAuthor2", "HappyTitle2", 1999);
        holder.addReference(ref1);
        holder.addReference(ref2);

        expected = "@REFERENCE { REF" + (ReferenceTest.ID_INDEX + ReferenceTest.ID_OFFSET) + ",\n"
                + "author = \"HappyAuthor\",\n"
                + "title = \"HappyTitle\",\n"
                + "year = \"2000\"\n"
                + "},\n";
        expected += "@REFERENCE { REF" + (ReferenceTest.ID_INDEX + ReferenceTest.ID_OFFSET + 1) + ",\n"
                + "author = \"HappyAuthor2\",\n"
                + "title = \"HappyTitle2\",\n"
                + "year = \"1999\"\n"
                + "},\n";
    }

    @After
    public void tearDown() throws Exception {
        sout.flush();
        serr.flush();
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    public void testAddReference() throws Exception {
        expected += "@REFERENCE { REF" + (ReferenceTest.ID_INDEX  + ReferenceTest.ID_OFFSET + 2) + ",\n"
                + "author = \"HappyAuthor3\",\n"
                + "title = \"HappyTitle3\",\n"
                + "year = \"1998\"\n"
                + "},\n";

        holder.addReference(new Reference("HappyAuthor3", "HappyTitle3", 1998));
        holder.printAllBibtexEntries();
        assertEquals(expected.replaceAll("\\s+",""), sout.toString().replaceAll("\\s+",""));
    }

    @Test
    public void testPrintAllBibtexEntries() throws Exception {
        holder.printAllBibtexEntries();
        assertEquals(expected.replaceAll("\\s+",""), sout.toString().replaceAll("\\s+",""));
    }
}