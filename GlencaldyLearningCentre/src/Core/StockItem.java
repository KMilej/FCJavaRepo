// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// STOCK ITEM CLASS DEFINITION

// This class contains the structure for stock items, including attributes like ID, title, quantity, and type, with methods to manage and represent these attributes.


package Core;

import java.io.Serializable;

public class StockItem implements Serializable {

    /* PROPERTIES */
    private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private int quantity;
    private StockType type; // Enum field for stock type

    /* METHODS */

    // Constructor
    public StockItem(String id, String title, int quantity, StockType type) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.type = type;
    }

    // Gets the ID of the stock item.
    public String getId() {
        return id;
    }

    // Sets the ID of the stock item.
    public void setId(String id) {
        this.id = id;
    }

    // Gets the title of the stock item.
    public String getTitle() {
        return title;
    }

    // Sets the title of the stock item.
    public void setTitle(String title) {
        this.title = title;
    }

    // Gets the quantity of the stock item.
    public int getQuantity() {
        return quantity;
    }

    // Sets the quantity of the stock item.
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Gets the type of the stock item.
    public StockType getType() {
        return type;
    }

    // Sets the type of the stock item.
    public void setType(StockType type) {
        this.type = type;
    }

    // Returns a string representation of the stock item.
    @Override
    public String toString() {
        return "Type: " + type + ", ID: " + id + ", Title: " + title + ", Quantity: " + quantity;
    }
}