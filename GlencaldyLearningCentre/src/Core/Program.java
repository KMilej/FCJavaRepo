
// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// PROGRAM CLASS DEFINITION

//This class contains the main entry point for the application, managing user interactions, login, catalog operations, and session handling for different user roles.

package Core;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LoginSystem loginSystem = new LoginSystem();
		ReservationManager reservationManager = new ReservationManager();
		Catalog catalog = new Catalog();
		LoanManager loan = new LoanManager();
		CatalogManager catalogManager = new CatalogManager();

		Runtime.getRuntime().addShutdownHook(new Thread(() -> {
			catalogManager.saveStockToFile();
			System.out.println("Catalog saved before exiting.");
		})); // automatically saves when the program is closed

		loginSystem.displayAllUsers(); // TEST Display predefined users for testing (remove in production)

		System.out.println("Welcome to the Glencaldy Learning Centre");
		System.out.println("To see all options please log in");
		System.out.println("we hope you will be satisfied with our services");

		// Main program loop
		while (true) {
			System.out.println("\nWelcome to the Learning Centre!");
			System.out.println("1. Login");
			System.out.println("2. Register");
			System.out.println("3. Exit");

			int option = getIntInput(scanner, "Choose an option: ");
			scanner.nextLine();

			switch (option) {
			case 1:
				System.out.print("Enter User ID: ");
				String userID = scanner.nextLine();
				System.out.print("Enter Password: ");
				String password = scanner.nextLine();
				
				// Validate login
				User loggedInUser = loginSystem.validateLogin(userID, password);
				if (loggedInUser != null) {
					// Record login time
					LocalDateTime now = LocalDateTime.now();
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String timestamp = now.format(formatter);
					loggedInUser.addLoginRecord("Logged in at: " + timestamp);

					System.out.println("Login successful! Welcome, " + loggedInUser.getFirstName() + " "
							+ loggedInUser.getLastName());
					// Handle session for logged-in user
					handleUserSession(loggedInUser, loginSystem, catalog, catalogManager, reservationManager, loan);
				} else {
					System.out.println("Invalid User ID or Password. Please try again.");
				}
				break;

			case 2:
				loginSystem.registerUser();
				break;

			case 3:
				catalogManager.saveStockToFile();
				loginSystem.saveUsersToFile(); // save user when we use 3 option
				System.out.println("Thank you for using the Learning Centre system. Goodbye!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid option. Please choose again.");
			}
		}
	}
	 // Handles the session for a logged-in user based on their role
	private static void handleUserSession(User user, LoginSystem loginSystem, Catalog catalog,
			CatalogManager catalogManager, ReservationManager reservationManager, LoanManager loan) {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nUser Menu - Logged in as: " + user.getFirstName() + " " + user.getLastName());
			switch (user.getAccountType()) {
			case FULL_MEMBER:
				System.out.println("\n=== Full Member Menu ===");
				System.out.println("1. Search Catalogue by Stock Item Title");
				System.out.println("2. Loan Item History");
				System.out.println("3. Reserve Item");
				System.out.println("4. Reserve Item History");
				System.out.println("5. Change Password");
				System.out.println("6. View Login History");
				System.out.println("7. Logout");
				System.out.print("Choose an option: ");

				int fullMemberChoice = scanner.nextInt();
				scanner.nextLine(); // Clear input buffer

				switch (fullMemberChoice) {
				case 1:
					System.out.print("Enter title to search: ");
					String title = scanner.nextLine();
					List<StockItem> foundItems = catalogManager.searchByTitle(title);
					if (foundItems.isEmpty()) {
						System.out.println("No items found with title: " + title);
						System.out.println("This is what we have in stock: ");
						catalogManager.displayCatalog();
					} else {
						System.out.println("Found items:");
						for (StockItem item : foundItems) {
							System.out.println(item);
						}
					}
					break;

				case 2:
					loan.displayLoanHistoryForUser(user.getUserID());
					break;

				case 3:
					reservationManager.reserveItem(scanner, user, catalogManager);
					break;

				case 4:
					reservationManager.displayReservations(user);
					break;

				case 5:
					user.changePassword(scanner);
					loginSystem.saveUsersToFile();
					break;

				case 6:
					user.viewLoginHistory(); // Display login history
					break;

				case 7:
					System.out.println("Logging out...");
					System.out.println("Thank you for using the Learning Centre system. Goodbye!");	
				//	System.exit(0);
					return;

				default:
					System.out.println("Invalid option. Please try again.");
				}
				break;

			case STAFF_USER:
				System.out.println("\n=== STAFF USER Menu ===");
				System.out.println("1. Search Catalogue by Stock Item Title");
				System.out.println("2. Loan Item History");
				System.out.println("3. Reserve Item");
				System.out.println("4. Reserve Item History");
				System.out.println("5. Change Password");
				System.out.println("6. View Login History");
				System.out.println("7. Logout");
				System.out.print("Choose an option: ");

				int staffChoice = scanner.nextInt();
				scanner.nextLine(); // Clear input buffer

				switch (staffChoice) {
				case 1:
					System.out.print("Enter title to search: ");
					String title = scanner.nextLine();
					List<StockItem> foundItems = catalogManager.searchByTitle(title);
					if (foundItems.isEmpty()) {
						System.out.println("No items found with title: " + title);
						System.out.println("This is what we have in stock: ");
						catalogManager.displayCatalog();
					} else {
						System.out.println("Found items:");
						for (StockItem item : foundItems) {
							System.out.println(item);
						}
					}
					break;

				case 2:
					loan.displayLoanHistoryForUser(user.getUserID());
					break;

				case 3:
					reservationManager.reserveItem(scanner, user, catalogManager);
					break;

				case 4:
					reservationManager.displayReservations(user);
					break;

				case 5:
					user.changePassword(scanner);
					loginSystem.saveUsersToFile();
					break;

				case 6:
					user.viewLoginHistory(); // Display login history
					break;

				case 7:
					System.out.println("Logging out...");
					catalogManager.saveStockToFile();
					loginSystem.saveUsersToFile(); // save user when we use 3 option
					System.out.println("Thank you for using the Learning Centre system. Goodbye!");
					return;

				default:
					System.out.println("Invalid option. Please try again.");
				}
				break;

			case CASUAL_USER:
				System.out.println("1. Search Catalogue by Stock Item Title");
				System.out.println("2. Change Password");
				System.out.println("3. View Login History");
				System.out.println("4. Logout");
				System.out.print("Choose an option: ");
				int casualChoice = scanner.nextInt();
				scanner.nextLine();
				switch (casualChoice) {
				case 1:
					System.out.print("Enter title to search: ");
					String title = scanner.nextLine();
					List<StockItem> foundItems = catalogManager.searchByTitle(title);
					if (foundItems.isEmpty()) {
						System.out.println("No items found with title: " + title);
						System.out.println("This is what we have in stock: ");
						catalogManager.displayCatalog();
					} else {
						System.out.println("Found items:");
						for (StockItem item : foundItems) {
							System.out.println(item);
						}
					}
					break;

				case 2:
					user.changePassword(scanner);
					break;
				case 3:
					user.viewLoginHistory();
					break;
				case 4:
					System.out.println("Logging out...");
					catalogManager.saveStockToFile();
					loginSystem.saveUsersToFile(); // save user when we use 3 option
					System.out.println("Thank you for using the Learning Centre system. Goodbye!");
					return;
				default:
					System.out.println("Invalid option. Please try again.");
				}
				break;

			case ADMIN:
				AdminUser admin = (AdminUser) user;
				System.out.println("\n=== Admin Menu ===");
				System.out.println("1. List All Users");
				System.out.println("2. Add New User");
				System.out.println("3. Delete User");
				System.out.println("4. List All Stock Items");
				System.out.println("5. Add New Stock Item");
				System.out.println("6. Edit Existing Stock Item");
				System.out.println("7. Record Loan");
				System.out.println("8. Record Loan History");
				System.out.println("9. Logout");
				System.out.print("Choose an option: ");
				int adminChoice = scanner.nextInt();
				scanner.nextLine(); // Clear input buffer

				switch (adminChoice) {
				case 1:
					admin.listAllUsers(loginSystem.getUsers());
					break;

				case 2:
					System.out.println("Adding a new user...");
					loginSystem.registerUser();
					break;

				case 3:
					admin.listAllUsers(loginSystem.getUsers());
					System.out.print("Enter User ID to delete: ");
					String userIDToDelete = scanner.nextLine();
					admin.deleteUser(loginSystem.getUsers(), userIDToDelete);
					break;

				case 4:
					System.out.println("\nListing all stock items...");
					catalogManager.displayCatalog(); // Method to display all stock items
					break;

				case 5:
					System.out.println("\nAdding a new stock item...");
					catalogManager.addNewStockItem(scanner);
					break;

				case 6:
					System.out.println("\nEditing an existing stock item...");
					catalogManager.editExistingStockItem(scanner);
					break;

				case 7:
					System.out.println("\nRecording a loan...");
					loan.handleLoanCreation(loan, catalogManager, loginSystem, scanner);
					break;

				case 8:
					System.out.println("\nRecording loan history...");
					loan.displayAllLoans();
					break;

				case 9:
					System.out.println("Logging out...");
					catalogManager.saveStockToFile();
					loginSystem.saveUsersToFile(); // save user when we use 3 option
					System.out.println("Thank you for using the Learning Centre system. Goodbye!");					
					return;

				default:
					System.out.println("Invalid option. Please try again.");
				}
				break;
			}
		}
	}
	// Helper method to safely get integer input
	private static int getIntInput(Scanner scanner, String prompt) {
		while (true) {
			System.out.print(prompt);
			try {
				return scanner.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.nextLine();
			}
		}
	}
}