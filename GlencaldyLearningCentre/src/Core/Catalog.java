package Core;

import java.util.ArrayList;
import java.util.List;

public class Catalog {
	private List<StockItem> stockList;

	// Konstruktor
	public Catalog() {
		this.stockList = new ArrayList<>();
	}

	// Metoda do inicjalizacji danych
	public void initializeStock() {
		// Dodawanie książek
		stockList.add(new Book("B001", "Java Programming", 10, "John Smith"));
		stockList.add(new Book("B002", "Python Basics", 8, "Jane Doe"));
		stockList.add(new Book("B003", "Data Structures", 5, "Alan Turing"));

		// Dodawanie czasopism
		stockList.add(new StockItem("J001", "Science Journal", 15, StockType.JOURNAL));
		stockList.add(new StockItem("J002", "Technology Journal", 12, StockType.JOURNAL));
		stockList.add(new StockItem("J003", "Engineering Journal", 7, StockType.JOURNAL));

		// Dodawanie wideo
		stockList.add(new Video("V001", "Java Tutorial", 20, 120));
		stockList.add(new Video("V002", "Machine Learning Video", 18, 150));
		stockList.add(new Video("V003", "Data Science Crash Course", 10, 90));

		// Dodawanie płyt CD
		stockList.add(new CompactDiscs("CD001", "Rock Classics", 25, 70));
		stockList.add(new CompactDiscs("CD002", "Jazz Essentials", 15, 50));
		stockList.add(new CompactDiscs("CD003", "Pop Hits", 30, 60));
	}

	// Metoda do pobrania listy
	public List<StockItem> getStockList() {
		return stockList;
	}

	// Możesz dodać inne metody, np. do wyszukiwania lub filtrowania
	public StockItem findById(String id) {
		for (StockItem item : stockList) {
			if (item.getId().equals(id)) {
				return item;
			}
		}
		return null;
	}

	public List<StockItem> filterByType(StockType type) {
		List<StockItem> filteredList = new ArrayList<>();
		for (StockItem item : stockList) {
			if (item.getType() == type) {
				filteredList.add(item);
			}
		}
		return filteredList;
	}

	public void addItem(StockItem item) {
		stockList.add(item);

	}
	public boolean removeById(String id) {
	    return stockList.removeIf(item -> item.getId().equals(id));
	}
}
