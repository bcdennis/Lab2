/**
 * Course: SE1021-021
 * Winter quarter, 2016-2017
 * Lab: Lab #2, Inheritance lab
 * Name: Curtis Copeland
 * Date: 12/6/2016
 */

package edu.msoe.se1021;

/**
 * General Reference object. Inherited by Article and Book classes.
 * Contains information common to both articles and classes, and can
 * return that information in a string.
 */
public class Reference {
    protected static int instanceCount = 0;
    private final int myUniqueID;
    private String author;
    private int publicationYear;
    private String title;

    /**
     * Creates a new Reference object.
     * @param author
     * @param title
     * @param publicationYear
     */
    public Reference(String author, String title, int publicationYear) {
        setAuthor(author);
        setPublicationYear(publicationYear);
        setTitle(title);
        myUniqueID = instanceCount;
        instanceCount++;
    }

    public int getMyUniqueID() {
        return myUniqueID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Returns a string with the unique ID, author, title, and year on separate lines.
     * @return
     */
    public String getBibtexEntry() {
        return "@REFERENCE { REF" + getMyUniqueID() + "," +
                "\nauthor = \"" + getAuthor() + "\"," +
                "\ntitle = \"" + getTitle() + "\"," +
                "\nyear = \"" + getPublicationYear() + "\"" +
                "\n},";
    }
}
