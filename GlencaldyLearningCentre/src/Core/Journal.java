// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// JOURNAL CLASS DEFINITION

// The Journal class represents a specific type of stock item in the library system: Journals.
// This class extends the StockItem class, adding an attribute for the author's name.

package Core;

public class Journal extends StockItem {

    /* PROPERTIES */
    private static final long serialVersionUID = 1L;
    private String author;

    /* METHODS */
    public Journal(String id, String title, int quantity, String author) {
        super(id, title, quantity, StockType.JOURNAL); // Use StockType enum
        this.author = author;
    }

    // Gets the author of the journal.
    public String getAuthor() {
        return author;
    }

    // Sets the author of the journal.
    public void setAuthor(String author) {
        this.author = author;
    }

    // Returns a string representation of the journal, including the author's name.
    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
}
