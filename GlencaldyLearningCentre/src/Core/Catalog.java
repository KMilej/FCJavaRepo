package Core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<StockItem> stockList;

    public Catalog() {
        this.stockList = new ArrayList<>();
    }

    public List<StockItem> getStockList() {
        return stockList;
    }
}
