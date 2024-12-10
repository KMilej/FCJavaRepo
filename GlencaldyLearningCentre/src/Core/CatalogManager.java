package Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CatalogManager {
    private Catalog catalog;
    private static final String STOCK_DATABASE = "stockDataBase.dat";
    private int maxId = 0; // For generating unique IDs

    public CatalogManager() {
        this.catalog = new Catalog();
        System.out.println("Loading catalog from file...");
        
        // Spróbuj załadować dane z pliku
        if (!loadStockFromFile()) {
            System.out.println("No existing catalog found. Initializing test data...");
            initializeStock();
            saveStockToFile();
        } else {
            System.out.println("Catalog successfully loaded.");
        }

        System.out.println("Current catalog size: " + catalog.getStockList().size());
    }

    public void initializeStock() {
        catalog.getStockList().add(createNewStockItem("Java Programming", 10, StockType.BOOK, "John Smith"));
        catalog.getStockList().add(createNewStockItem("Effective Java", 7, StockType.BOOK, "Joshua Bloch"));
        catalog.getStockList().add(createNewStockItem("Clean Code", 5, StockType.BOOK, "Robert C. Martin"));

        catalog.getStockList().add(createNewStockItem("Science Journal", 15, StockType.JOURNAL, "Dr. Richard Roe"));
        catalog.getStockList().add(createNewStockItem("Nature Journal", 10, StockType.JOURNAL, "Dr. Marie Curie"));
        catalog.getStockList().add(createNewStockItem("Tech Monthly", 8, StockType.JOURNAL, "Dr. Alan Grant"));

        catalog.getStockList().add(createNewStockItem("Java Tutorial", 20, StockType.VIDEO, 120));
        catalog.getStockList().add(createNewStockItem("Python Advanced Guide", 15, StockType.VIDEO, 150));
        catalog.getStockList().add(createNewStockItem("Machine Learning Basics", 12, StockType.VIDEO, 180));

        catalog.getStockList().add(createNewStockItem("Rock Classics", 25, StockType.COMPACT_DISC, 70));
        catalog.getStockList().add(createNewStockItem("Pop Hits 2023", 20, StockType.COMPACT_DISC, 60));
        catalog.getStockList().add(createNewStockItem("Classical Masterpieces", 18, StockType.COMPACT_DISC, 80));
        
        System.out.println("Items added during initialization: " + catalog.getStockList().size());
        saveStockToFile();
    }


    
    public void displayCatalog() {
        System.out.println("\n=== Catalog ===");
        List<StockItem> stockList = catalog.getStockList();
        if (stockList.isEmpty()) {
            System.out.println("The catalog is empty.");
        } else {
            for (StockItem item : stockList) {
                System.out.println(item);
            }
        }
    }

    public List<StockItem> searchByTitle(String title) {
        return catalog.getStockList().stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void addItem(StockItem item) {
        catalog.getStockList().add(item);
    }

    public StockItem createNewStockItem(String title, int quantity, StockType type, Object additionalInfo) {
        String id = generateUniqueStockID(type);

        switch (type) {
            case BOOK:
                if (additionalInfo instanceof String) {
                    return new Book(id, title, quantity, (String) additionalInfo);
                } else {
                    throw new IllegalArgumentException("For BOOK, additionalInfo must be a String (author).");
                }

            case JOURNAL:
                if (additionalInfo instanceof String) {
                    return new Journal(id, title, quantity, (String) additionalInfo);
                } else {
                    throw new IllegalArgumentException("For JOURNAL, additionalInfo must be a String (author).");
                }

            case VIDEO:
                if (additionalInfo instanceof Integer) {
                    return new Video(id, title, quantity, (int) additionalInfo);
                } else {
                    throw new IllegalArgumentException("For VIDEO, additionalInfo must be an Integer (duration in minutes).");
                }

            case COMPACT_DISC:
                if (additionalInfo instanceof Integer) {
                    return new CompactDiscs(id, title, quantity, (int) additionalInfo);
                } else {
                    throw new IllegalArgumentException("For COMPACT_DISC, additionalInfo must be an Integer (duration in minutes).");
                }

            default:
                throw new IllegalArgumentException("Unsupported stock type: " + type);
        }
    }

    private String generateUniqueStockID(StockType type) {
        maxId++;
        String prefix;
        switch (type) {
            case BOOK:
                prefix = "B";
                break;
            case JOURNAL:
                prefix = "J";
                break;
            case VIDEO:
                prefix = "V";
                break;
            case COMPACT_DISC:
                prefix = "CD";
                break;
            default:
                prefix = "U";
        }
        return prefix + String.format("%04d", maxId);
    }

    public void saveStockToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STOCK_DATABASE))) {
            oos.writeObject(catalog.getStockList());
            System.out.println("Catalog saved to: " + new java.io.File(STOCK_DATABASE).getAbsolutePath());
            System.out.println("Items in catalog: " + catalog.getStockList().size());
        } catch (IOException e) {
            System.err.println("Error saving catalog: " + e.getMessage());
        }
    }

    public boolean loadStockFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STOCK_DATABASE))) {
            @SuppressWarnings("unchecked")
            List<StockItem> stockList = (List<StockItem>) ois.readObject();
            catalog.getStockList().clear();
            catalog.getStockList().addAll(stockList);
            updateMaxId(); // Zaktualizuj maxId po załadowaniu
            System.out.println("Catalog loaded from: " + new java.io.File(STOCK_DATABASE).getAbsolutePath());
            System.out.println("Catalog loaded. Items in catalog: " + catalog.getStockList().size());
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Catalog file not found.");
            return false;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading catalog: " + e.getMessage());
            return false;
        }
    }
    
    private void updateMaxId() {
        for (StockItem item : catalog.getStockList()) {
            String id = item.getId().replaceAll("[^0-9]", ""); // Usuwa litery, pozostawia cyfry
            try {
                int numericId = Integer.parseInt(id);
                if (numericId > maxId) {
                    maxId = numericId;
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid ID format: " + item.getId());
            }
        }
    }

}