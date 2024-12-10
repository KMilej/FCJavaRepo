package Core;

public class Journal extends StockItem {
    private String author;

    public Journal(String id, String title, int quantity, String author) {
        super(id, title, quantity, StockType.JOURNAL); // Use StockType enum
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