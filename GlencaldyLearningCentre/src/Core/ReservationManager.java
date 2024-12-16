// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// RESERVATION MANAGER CLASS DEFINITION

// This class contains methods for managing reservations, including reserving items, displaying user-specific reservations, and viewing all reservations.


package Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReservationManager {

    /* PROPERTIES */
    private List<Reservation> reservations = new ArrayList<>();
    private int reservationCounter = 0; // Counter for generating unique reservation IDs

    /* METHODS */

    // Allows a user to reserve an item from the catalog.
    public void reserveItem(Scanner scanner, User user, CatalogManager catalogManager) {
        System.out.print("Enter the title of the item to reserve: ");
        String title = scanner.nextLine();

        List<StockItem> foundItems = catalogManager.searchByTitle(title);
        if (foundItems.isEmpty()) {
            System.out.println("No items found with title: " + title);
            return;
        }

        System.out.println("Found items:");
        for (int i = 0; i < foundItems.size(); i++) {
            System.out.println((i + 1) + ". " + foundItems.get(i));
        }

        System.out.print("Choose an item from the list and type number: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer

        if (choice < 1 || choice > foundItems.size()) {
            System.out.println("Invalid choice. Returning to menu.");
            return;
        }

        StockItem itemToReserve = foundItems.get(choice - 1);

        if (itemToReserve.getQuantity() <= 0) {
            System.out.println("This item is fully reserved and unavailable.");
            return;
        }

        System.out.println("You selected: " + itemToReserve);
        System.out.print("Do you want to reserve this item? (y/n): ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (!confirmation.equals("y")) {
            System.out.println("Reservation cancelled. Returning to menu.");
            return;
        }

        itemToReserve.setQuantity(itemToReserve.getQuantity() - 1);
        String reservationId = "R" + (++reservationCounter);
        Reservation newReservation = new Reservation(reservationId, user.getUserID(), itemToReserve);
        reservations.add(newReservation);

        System.out.println("Item reserved successfully: " + newReservation);
    }

    // Displays all reservations made by a specific user.
    public void displayReservations(User user) {
        System.out.println("\n=== Reservation History ===");
        List<Reservation> userReservations = reservations.stream()
                .filter(reservation -> reservation.getUserId().equals(user.getUserID()))
                .collect(Collectors.toList());

        if (userReservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            userReservations.forEach(System.out::println);
        }
    }

    // Displays all reservations in the system.
    public void displayAllReservations() {
        System.out.println("\n=== All Reservations ===");
        if (reservations.isEmpty()) {
            System.out.println("No reservations made yet.");
        } else {
            reservations.forEach(System.out::println);
        }
    }
}
