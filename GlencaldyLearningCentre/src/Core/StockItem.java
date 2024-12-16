// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// STOCK ITEM CLASS DEFINITION

//This class contains the structure for stock items, including attributes like ID, title, quantity, and type, with methods to manage and represent these attributes.


package Core;

import java.io.Serializable;

public class StockItem implements Serializable {
	 private static final long serialVersionUID = 1L;
    private String id;
    private String title;
    private int quantity;
    private StockType type; // Enum field for stock type
    

    // Constructor
    public StockItem(String id, String title, int quantity, StockType type) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.type = type;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public StockType getType() {
        return type;
    }

    public void setType(StockType type) {
        this.type = type;
    }

    // toString method
    @Override
    public String toString() {
        return "Type: " + type + ", ID: " + id + ", Title: " + title + ", Quantity: " + quantity;
    }
}
