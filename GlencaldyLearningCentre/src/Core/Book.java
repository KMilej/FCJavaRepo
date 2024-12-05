package Core;

public class Book extends StockItem {
    private String author;

    public Book(String id, String title, int quantity, String author) {
        super(id, title, quantity, StockType.BOOK); // Use StockType enum
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