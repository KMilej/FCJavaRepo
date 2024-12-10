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
		List<User> users = loginSystem.getUsers();
		
		Catalog catalog = new Catalog();
		
		CatalogManager catalogManager = new CatalogManager();
        // Twoja logika programu
        catalogManager.displayCatalog();

        // Na końcu programu zapisz dane
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            catalogManager.saveStockToFile();
            System.out.println("Catalog saved before exiting.");
        })); // automatycznie zapisuje przy wylaczeniu aplikacji
	    
//		catalogManager.displayCatalog();
//		catalogManager.manageCatalog(scanner);
		
		
		System.out.println("Welcome to the Glencaldy Learning Centre");
		System.out.println("To see all options please log in");

		loginSystem.displayAllUsers(); // TEST
		 while (true) {
	            System.out.println("\nWelcome to the Learning Centre!");
	            System.out.println("1. Login");
	            System.out.println("2. Register");
	            System.out.println("3. Exit");

	            int option = getIntInput(scanner, "Choose an option: ");
	            scanner.nextLine(); // Oczyszczenie bufora wejścia
	            
	            switch (option) {
	                case 1:
	                    System.out.print("Enter User ID: ");
	                    String userID = scanner.nextLine();
	                    System.out.print("Enter Password: ");
	                    String password = scanner.nextLine();

	                    User loggedInUser = loginSystem.validateLogin(userID, password);
	                    if (loggedInUser != null) {
	                        // Dodanie sformatowanego rekordu logowania
	                        LocalDateTime now = LocalDateTime.now();
	                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	                        String timestamp = now.format(formatter);
	                        loggedInUser.addLoginRecord("Logged in at: " + timestamp);

	                        System.out.println("Login successful! Welcome, " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
	                        handleUserSession(loggedInUser, loginSystem, catalog, catalogManager);
	                    } else {
	                        System.out.println("Invalid User ID or Password. Please try again.");
	                    }
	                    break;

	                case 2:
	                    loginSystem.registerUser();
	                    break;

	                case 3:
	                	catalogManager.saveStockToFile();
	                	loginSystem.saveUsersToFile(); // Zapisujemy listę użytkowników przed wyjściem
	                    System.out.println("Thank you for using the Learning Centre system. Goodbye!");
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }
	    }

	private static void handleUserSession(User user, LoginSystem loginSystem, Catalog catalog, CatalogManager catalogManager) {
	    Scanner scanner = new Scanner(System.in);

	    while (true) {
	        System.out.println("\nUser Menu - Logged in as: " + user.getFirstName() + " " + user.getLastName());
	        switch (user.getAccountType()) {
	        case FULL_MEMBER:
	            System.out.println("\n=== Full Member Menu ===");
	            System.out.println("1. Search Catalogue by Stock Item Title");
	            System.out.println("2. Borrow Item");
	            System.out.println("3. Borrow Item History");
	            System.out.println("4. Reserve Item");
	            System.out.println("5. Reserve Item History");
	            System.out.println("6. Change Password");
	            System.out.println("7. View Login History");
	            System.out.println("8. Fine");
	            System.out.println("9. Logout");
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
	                    System.out.println("Borrowing items is not implemented yet.");
	                    break;

	                case 3:
	                    System.out.println("Borrow Item History is not implemented yet.");
	                    break;

	                case 4:
	                    System.out.println("Reserving items is not implemented yet.");
	                    break;

	                case 5:
	                    System.out.println("Reserve Item History is not implemented yet.");
	                    break;

	                case 6:
	                    user.changePassword();
	                    loginSystem.saveUsersToFile();
	                    break;

	                case 7:
	                    user.viewLoginHistory(); // Display login history
	                    break;

	                case 8:
	                    System.out.println("Fine details are not implemented yet.");
	                    break;

	                case 9:
	                    System.out.println("Logging out...");
	                    return;

	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	            break;

	            case STAFF_USER:
		            System.out.println("\n=== Full Member Menu ===");
		            System.out.println("1. Search Catalogue by Stock Item Title");
		            System.out.println("2. Borrow Item");
		            System.out.println("3. Borrow Item History");
		            System.out.println("4. Reserve Item");
		            System.out.println("5. Reserve Item History");
		            System.out.println("6. Change Password");
		            System.out.println("7. View Login History");
		            System.out.println("8. Fine");
		            System.out.println("9. Logout");
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
		                    System.out.println("Borrowing items is not implemented yet.");
		                    break;

		                case 3:
		                    System.out.println("Borrow Item History is not implemented yet.");
		                    break;

		                case 4:
		                    System.out.println("Reserving items is not implemented yet.");
		                    break;

		                case 5:
		                    System.out.println("Reserve Item History is not implemented yet.");
		                    break;

		                case 6:
		                    user.changePassword();
		                    loginSystem.saveUsersToFile();
		                    break;

		                case 7:
		                    user.viewLoginHistory(); // Display login history
		                    break;

		                case 8:
		                    System.out.println("Fine details are not implemented yet.");
		                    break;

		                case 9:
		                    System.out.println("Logging out...");
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
	                scanner.nextLine(); // Oczyszczenie bufora wejścia
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
	                        user.changePassword();
	                        break;
	                    case 3:
	                        System.out.println("Logging out...");
	                        loginSystem.saveUsersToFile();
	                        return;
	                    case 4:
		                    user.viewLoginHistory(); // Wyświetl historię logowania
		                    break;
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
	                    
	                    break;

	                case 6:
	                    System.out.println("\nEditing an existing stock item...");
	                    
	                    break;

	                case 7:
	                    System.out.println("\nRecording a loan...");
	                    
	                    break;

	                case 8:
	                    System.out.println("\nRecording loan history...");
	                    
	                    break;

	                case 9:
	                    System.out.println("Logging out...");
	                    return;

	                default:
	                    System.out.println("Invalid option. Please try again.");
	            }
	            break;
	        }
	    }
	}
	    private static int getIntInput(Scanner scanner, String prompt) {
	        while (true) {
	            System.out.print(prompt);
	            try {
	                return scanner.nextInt();
	            } catch (InputMismatchException e) {
	                System.out.println("Invalid input. Please enter a number.");
	                scanner.nextLine(); // Oczyszczenie bufora wejścia
	            }
	        }
	    }
}
