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
 * Contains information about an Article, and can return that information
 * in a String.
 */
public class Article extends Reference {
    private int endingPage;
    private String journal;
    private int startingPage;

    /**
     * Creates a new Article reference.
     * @param author
     * @param title
     * @param publicationYear
     * @param journal
     * @param startingPage
     * @param endingPage
     */
    public Article(String author, String title, int publicationYear, String journal, int startingPage, int endingPage) {
        super(author, title, publicationYear);
        setJournal(journal);
        setStartingPage(startingPage);
        setEndingPage(endingPage);
    }

    /**
     * Overrides the Reference getBibtexEntry method
     * @return string with the ID, author, title, journal, pages, and year values on separate lines.
     */
    @Override
    public String getBibtexEntry() {
        return "@ARTICLE { REF" + getMyUniqueID() + "," +
                "\nauthor = \"" + getAuthor() + "\"," +
                "\ntitle = \"" + getTitle() + "\"," +
                "\njournal = \"" + getJournal() + "\"," +
                "\npages = \"" + getStartingPage() + "-" + getEndingPage() + "\"," +
                "\nyear = \"" + getPublicationYear() + "\"" +
                "\n},";
    }


    public int getEndingPage() {
        return endingPage;
    }

    public void setEndingPage(int endingPage) {
        this.endingPage = endingPage;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public int getStartingPage() {
        return startingPage;
    }

    public void setStartingPage(int startingPage) {
        this.startingPage = startingPage;
    }
}
