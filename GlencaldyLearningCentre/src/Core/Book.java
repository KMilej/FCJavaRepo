// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// BOOK CLASS DEFINITION

// The Book class represents a specific type of stock item in the library system. It extends the StockItem class and includes an additional attribute for the author's name.


package Core;

public class Book extends StockItem {
    
    /* PROPERTIES */
    private static final long serialVersionUID = 1L;
    private String author;

    /* METHODS */
    public Book(String id, String title, int quantity, String author) {
        super(id, title, quantity, StockType.BOOK); 
        this.author = author;
    }

    // Gets the author of the book.
    public String getAuthor() {
        return author;
    }

    // Sets the author of the book.
    public void setAuthor(String author) {
        this.author = author;
    }

    // Returns a string representation of the book, including author information.
    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
}
