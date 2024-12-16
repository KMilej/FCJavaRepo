// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// CATALOG CLASS DEFINITION

// The Catalog class represents a collection of stock items in the library system.
// It serves as a centralized inventory for managing items such as books, DVDs, etc.
// This class is Serializable, allowing it to be saved and loaded as needed.


package Core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    
    /* PROPERTIES */
    private static final long serialVersionUID = 1L;
    private List<StockItem> stockList;

    /* METHODS */
    public Catalog() {
        this.stockList = new ArrayList<>();
    }

    // Returns the list of stock items in the catalog.
    public List<StockItem> getStockList() {
        return stockList;
    }
}
