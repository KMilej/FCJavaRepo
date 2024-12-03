package Core;

public class StockItem {
    private String stockID;
    private String title;
    private String type;

    public StockItem(String stockID, String title, String type) {
        this.stockID = stockID;
        this.title = title;
        this.type = type;
    }

    public String getStockID() {
        return stockID;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return title + " (ID: " + stockID + ", Type: " + type + ")";
    }
}
