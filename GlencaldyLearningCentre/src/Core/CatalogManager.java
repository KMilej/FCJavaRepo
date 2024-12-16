// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// CATALOG MANAGER CLASS DEFINITION

// The CatalogManager class handles the management of the catalog in the library system.
// It supports loading, saving, and managing stock items such as books, journals, videos, and compact discs.

package Core;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CatalogManager {

    /* PROPERTIES */
    private Catalog catalog;
    private static final String STOCK_DATABASE = "stockDataBase.dat";
    private int maxId = 0; // For generating unique IDs

    /* METHODS */
    public CatalogManager() {
        this.catalog = new Catalog();
        System.out.println("Loading catalog from file...");

        if (!loadStockFromFile()) {
            System.out.println("No existing catalog found. Initializing test data...");
            initializeStock();
            saveStockToFile();
        } else {
            System.out.println("Catalog successfully loaded.");
        }

        System.out.println("Current catalog size: " + catalog.getStockList().size());
    }

    // Initializes the catalog with test data.
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

    // Displays all stock items in the catalog.
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

    // Searches for stock items by title and returns a list of matches.
    public List<StockItem> searchByTitle(String title) {
        return catalog.getStockList().stream()
                .filter(item -> item.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    // Adds a new stock item to the catalog.
    public void addItem(StockItem item) {
        catalog.getStockList().add(item);
    }

    // Creates a new stock item based on the provided parameters.
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

    // Adds a new stock item based on user input.
    public void addNewStockItem(Scanner scanner) {
        System.out.println("\n=== Add New Stock Item ===");
        System.out.println("Choose Stock Type: ");
        System.out.println("1. Book");
        System.out.println("2. Journal");
        System.out.println("3. Video");
        System.out.println("4. Compact Disc");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear input buffer

        System.out.print("Enter Title: ");
        String title = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Clear input buffer

        Object additionalInfo = null;
        StockType type = null;

        switch (choice) {
            case 1:
                type = StockType.BOOK;
                System.out.print("Enter Author: ");
                additionalInfo = scanner.nextLine();
                break;
            case 2:
                type = StockType.JOURNAL;
                System.out.print("Enter Author: ");
                additionalInfo = scanner.nextLine();
                break;
            case 3:
                type = StockType.VIDEO;
                System.out.print("Enter Duration (in minutes): ");
                additionalInfo = scanner.nextInt();
                scanner.nextLine(); // Clear input buffer
                break;
            case 4:
                type = StockType.COMPACT_DISC;
                System.out.print("Enter Duration (in minutes): ");
                additionalInfo = scanner.nextInt();
                scanner.nextLine(); // Clear input buffer
                break;
            default:
                System.out.println("Invalid choice. Returning to admin menu.");
                return;
        }

        try {
            StockItem newItem = createNewStockItem(title, quantity, type, additionalInfo);
            catalog.getStockList().add(newItem);
            saveStockToFile();
            System.out.println("New stock item added successfully: " + newItem);
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating stock item: " + e.getMessage());
        }
    }

    // Edits an existing stock item based on user input.
    public void editExistingStockItem(Scanner scanner) {
        System.out.println("\n=== Edit Existing Stock Item ===");
        System.out.print("Enter the ID of the item to edit: ");
        String itemId = scanner.nextLine();

        StockItem itemToEdit = catalog.getStockList().stream()
                .filter(item -> item.getId().equalsIgnoreCase(itemId))
                .findFirst()
                .orElse(null);

        if (itemToEdit == null) {
            System.out.println("Item with ID " + itemId + " not found.");
            return;
        }

        System.out.println("Editing item: " + itemToEdit);
        System.out.println("What would you like to edit?");
        System.out.println("1. Title");
        System.out.println("2. Quantity");

        if (itemToEdit instanceof Book || itemToEdit instanceof Journal) {
            System.out.println("3. Author");
        } else if (itemToEdit instanceof Video || itemToEdit instanceof CompactDiscs) {
            System.out.println("3. Duration (in minutes)");
        }

        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear input buffer

        switch (choice) {
            case 1:
                System.out.println("Current Title: " + itemToEdit.getTitle());
                System.out.print("Enter new Title: ");
                String newTitle = scanner.nextLine();
                itemToEdit.setTitle(newTitle);
                break;

            case 2:
                System.out.println("Current Quantity: " + itemToEdit.getQuantity());
                System.out.print("Enter new Quantity: ");
                int newQuantity = scanner.nextInt();
                scanner.nextLine(); // Clear input buffer
                itemToEdit.setQuantity(newQuantity);
                break;

            case 3:
                if (itemToEdit instanceof Book) {
                    Book book = (Book) itemToEdit;
                    System.out.println("Current Author: " + book.getAuthor());
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                    book.setAuthor(newAuthor);
                } else if (itemToEdit instanceof Journal) {
                    Journal journal = (Journal) itemToEdit;
                    System.out.println("Current Author: " + journal.getAuthor());
                    System.out.print("Enter new Author: ");
                    String newAuthor = scanner.nextLine();
                    journal.setAuthor(newAuthor);
                } else if (itemToEdit instanceof Video) {
                    Video video = (Video) itemToEdit;
                    System.out.println("Current Duration: " + video.getDuration());
                    System.out.print("Enter new Duration (in minutes): ");
                    int newDuration = scanner.nextInt();
                    scanner.nextLine(); // Clear input buffer
                    video.setDuration(newDuration);
                } else if (itemToEdit instanceof CompactDiscs) {
                    CompactDiscs cd = (CompactDiscs) itemToEdit;
                    System.out.println("Current Duration: " + cd.getDuration());
                    System.out.print("Enter new Duration (in minutes): ");
                    int newDuration = scanner.nextInt();
                    scanner.nextLine(); // Clear input buffer
                    cd.setDuration(newDuration);
                } else {
                    System.out.println("Invalid option for this item type.");
                }
                break;

            default:
                System.out.println("Invalid option. Returning to admin menu.");
                return;
        }

        saveStockToFile();
        System.out.println("Item updated successfully: " + itemToEdit);
    }

    // Generates a unique stock ID based on stock type and maxId.
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

    // Saves the catalog to a file.
    public void saveStockToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(STOCK_DATABASE))) {
            oos.writeObject(catalog.getStockList());
            System.out.println("Catalog saved to: " + new java.io.File(STOCK_DATABASE).getAbsolutePath());
            System.out.println("Items in catalog: " + catalog.getStockList().size());
        } catch (IOException e) {
            System.err.println("Error saving catalog: " + e.getMessage());
        }
    }

    // Loads the catalog from a file.
    public boolean loadStockFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(STOCK_DATABASE))) {
            @SuppressWarnings("unchecked")
            List<StockItem> stockList = (List<StockItem>) ois.readObject();
            catalog.getStockList().clear();
            catalog.getStockList().addAll(stockList);
            updateMaxId();
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

    // Updates the maxId to reflect the highest ID in the catalog.
    private void updateMaxId() {
        for (StockItem item : catalog.getStockList()) {
            String id = item.getId().replaceAll("[^0-9]", "");
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
