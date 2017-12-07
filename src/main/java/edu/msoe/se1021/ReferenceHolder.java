/**
 * Course: SE1021-021
 * Winter quarter, 2016-2017
 * Lab: Lab #2, Inheritance lab
 * Name: Curtis Copeland
 * Date: 12/6/2016
 */

package edu.msoe.se1021;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Holds an ArrayList of reference objects to easily print
 * all the Bibtex entries from one place.
 */

public class ReferenceHolder {
    ArrayList<Reference> references = new ArrayList<>();

    /**
     * Add a new reference to the references ArrayList
     * @param myReference
     */
    public void addReference(Reference myReference) {
        references.add(myReference);
    }

    /**
     * Prints the bibtex entries in order of each of the references
     */
    public void printAllBibtexEntries() {
        for (Reference reference : references) {
            System.out.println(reference.getBibtexEntry());
        }
    }

    /**
     *
     * @param uniqueID
     * @param in
     */
    public void updateReference(String uniqueID, Scanner in) {

    }
}