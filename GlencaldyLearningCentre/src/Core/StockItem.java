package Core;

public class StockItem {
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
