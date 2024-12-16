// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// LOAN MANAGER CLASS DEFINITION

// This class is responsible for managing loans in the Glencaldy Learning Centre system.
// It provides functionality for creating new loans, checking loan history for users, 
// and displaying all active loans. The class ensures that stock items are only loaned if 
// they are available in sufficient quantity and manages the relationship between users 
// and their borrowed items.

package Core;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoanManager {

    /* PROPERTIES */
    private List<Loan> loans = new ArrayList<>();
    private int loanCounter = 0; // Counter for generating unique loan IDs

    /* METHODS */

    // Handles the creation of a new loan.
    public void handleLoanCreation(LoanManager loanManager, CatalogManager catalogManager, LoginSystem loginSystem, Scanner scanner) {
        System.out.println("\n=== Create a New Loan ===");

        // Ask for Username
        System.out.print("Enter the username of the user: ");
        String username = scanner.nextLine();

        User user = loginSystem.getUsers().stream()
                .filter(u -> u.getUsername().equalsIgnoreCase(username))
                .findFirst()
                .orElse(null);

        if (user == null) {
            System.out.println("User not found. Returning to menu.");
            return;
        }

        // Ask for the book title
        System.out.print("Enter the title of the book to loan: ");
        String title = scanner.nextLine();

        List<StockItem> foundItems = catalogManager.searchByTitle(title);

        if (foundItems.isEmpty()) {
            System.out.println("No items found with title: " + title);
            return;
        }

        // Display found items
        System.out.println("Found items:");
        for (int i = 0; i < foundItems.size(); i++) {
            System.out.println((i + 1) + ". " + foundItems.get(i));
        }

        System.out.print("Choose an item (1): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear input buffer

        if (choice < 1 || choice > foundItems.size()) {
            System.out.println("Invalid choice. Returning to menu.");
            return;
        }

        StockItem selectedItem = foundItems.get(choice - 1);

        // Check stock availability
        if (selectedItem.getQuantity() <= 0) {
            System.out.println("This item is out of stock and cannot be loaned.");
            return;
        }

        // Confirm loan
        System.out.print("Do you want to loan this item to " + user.getUsername() + "? (y/n): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (!confirmation.equals("y")) {
            System.out.println("Loan creation cancelled.");
            return;
        }

        // Create Loan
        LocalDateTime returnDate = LocalDateTime.now().plusWeeks(2); // 2 weeks loan period
        Loan newLoan = loanManager.createLoan(user.getUserID(), selectedItem, returnDate);

        // Reduce quantity in stock
        selectedItem.setQuantity(selectedItem.getQuantity() - 1);

        System.out.println("Loan created successfully for user: " + user.getUsername());
        System.out.println("Loan Details: " + newLoan);
    }

    // Creates a new loan and adds it to the list of loans.
    public Loan createLoan(String userId, StockItem item, LocalDateTime returnDate) {
        String loanId = "L" + (++loanCounter);
        Loan newLoan = new Loan(loanId, userId, item, returnDate);
        loans.add(newLoan);

        // Reduce the quantity of the borrowed item
        item.setQuantity(item.getQuantity() - 1);

        return newLoan;
    }

    // Retrieves all loans for a specific user.
    public List<Loan> getLoansForUser(String userId) {
        List<Loan> userLoans = new ArrayList<>();
        for (Loan loan : loans) {
            if (loan.getUserId().equals(userId)) {
                userLoans.add(loan);
            }
        }
        return userLoans;
    }

    // Displays all active loans.
    public void displayAllLoans() {
        if (loans.isEmpty()) {
            System.out.println("No loans found.");
        } else {
            for (Loan loan : loans) {
                System.out.println(loan);
            }
        }
    }

    // Displays loan history for a specific user.
    public void displayLoanHistoryForUser(String userId) {
        System.out.println("\n=== Loan History for User: " + userId + " ===");
        List<Loan> userLoans = getLoansForUser(userId);

        if (userLoans.isEmpty()) {
            System.out.println("No loans found for this user.");
        } else {
            for (Loan loan : userLoans) {
                System.out.println(loan);
            }
        }
    }
}
