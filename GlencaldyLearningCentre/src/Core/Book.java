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
    private String author;

    public Book(String id, String title, int quantity, String author) {
        super(id, title, quantity, StockType.BOOK); 
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
}