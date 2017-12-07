/**
 * Course: SE1021-021
 * Winter quarter, 2016-2017
 * Lab: Lab #2, Inheritance lab
 * Name: Curtis Copeland
 * Date: 12/6/2016
 */

package edu.msoe.se1021;

/**
 * Specialized type of Reference, see constructor for requirements.
 * Contains information about a Book, and can return that information
 * in a String.
 */
public class Book extends Reference {
    private String publisher;

    /**
     * Creates a new Book reference.
     * @param author
     * @param title
     * @param publicationYear
     * @param publisher
     */
    public Book(String author, String title, int publicationYear, String publisher) {
        super(author, title, publicationYear);
        setPublisher(publisher);
    }


    /**
     * Overrides the Reference getBibtexEntry method
     * @return string with the ID, author, title, publisher, and year values on separate lines.
     */
    @Override
    public String getBibtexEntry() {
        return "@BOOK { REF" + getMyUniqueID() + "," +
                "\nauthor = \"" + getAuthor() + "\"," +
                "\ntitle = \"" + getTitle() + "\"," +
                "\npublisher = \"" + getPublisher() + "\"," +
                "\nyear = \"" + getPublicationYear() + "\"" +
                "\n},";
    }

    public String getPublisher() {
        return "";
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
