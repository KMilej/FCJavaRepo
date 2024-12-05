package Core;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		LoginSystem loginSystem = new LoginSystem();
		List<User> users = loginSystem.getUsers();
		
		
		 Catalog catalog = new Catalog();

	        // Inicjalizacja danych
	        catalog.initializeStock();

	        // Pobranie i wyświetlenie listy
	        List<StockItem> stockList = catalog.getStockList();
	        for (StockItem item : stockList) {
	            System.out.println(item);
	        }

	        // Przykład wyszukiwania po ID
	        StockItem foundItem = catalog.findById("V002");
	        if (foundItem != null) {
	            System.out.println("Znaleziono przedmiot: " + foundItem);
	        } else {
	            System.out.println("Nie znaleziono przedmiotu o podanym ID.");
	        }
		
		
		
		System.out.println("Welcome to the Glencaldy Learning Centre");
		System.out.println("To see all options please log in");

		loginSystem.displayAllUsers(); // TEST
		 while (true) {
	            System.out.println("\nWelcome to the Learning Centre!");
	            System.out.println("1. Login");
	            System.out.println("2. Register");
	            System.out.println("3. Exit");
	            System.out.print("Choose an option: ");

	            int option = getIntInput(scanner, "Choose an option: ");
	          //  scanner.nextLine(); // Oczyszczenie bufora wejścia

	            switch (option) {
	                case 1:
	                    System.out.print("Enter User ID: ");
	                    String userID = scanner.nextLine();
	                    System.out.print("Enter Password: ");
	                    String password = scanner.nextLine();

	                    User loggedInUser = loginSystem.validateLogin(userID, password);
	                    if (loggedInUser != null) {
	                        System.out.println("Login successful! Welcome, " + loggedInUser.getFirstName() + " " + loggedInUser.getLastName());
	                        handleUserSession(loggedInUser, loginSystem);
	                    } else {
	                        System.out.println("Invalid User ID or Password. Please try again.");
	                    }
	                    break;

	                case 2:
	                    loginSystem.registerUser();
	                    break;

	                case 3:
	                	loginSystem.saveUsersToFile(); // Zapisujemy listę użytkowników przed wyjściem
	                    System.out.println("Thank you for using the Learning Centre system. Goodbye!");
	                    System.exit(0);
	                    break;

	                default:
	                    System.out.println("Invalid option. Please choose again.");
	            }
	        }
	    }

	    private static void handleUserSession(User user, LoginSystem loginSystem) {
	        Scanner scanner = new Scanner(System.in);

	        while (true) {
	            System.out.println("\nUser Menu - Logged in as: " + user.getFirstName() + " " + user.getLastName());
	            switch (user.getAccountType()) {
	                case FULL_MEMBER:
	                    System.out.println("1. Borrow Item");
	                    System.out.println("2. View Borrowed Items");
	                    System.out.println("3. Logout");
	                    break;
	                case CASUAL_USER:
	                    System.out.println("1. Search Catalogue");
	                    System.out.println("2. Logout");
	                    break;
	                case STAFF_USER:
	                    System.out.println("1. Borrow Item");
	                    System.out.println("2. View Borrowed Items");
	                    System.out.println("3. Logout");
	                    break;
	                case ADMIN:
	                    System.out.println("1. List All Users");
	                    System.out.println("2. Add New User");
	                    System.out.println("3. Logout");
	                    break;
	            }
	            System.out.print("Choose an option: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Oczyszczenie bufora wejścia

	            switch (user.getAccountType()) {
	                case FULL_MEMBER:
	                case STAFF_USER:
	                    switch (choice) {
	                        case 1:
	                            System.out.println("Borrowing items is not implemented yet.");
	                            break;
	                        case 2:
	                            System.out.println("Viewing borrowed items is not implemented yet.");
	                            break;
	                        case 3:
	                            System.out.println("Logging out...");
	                            return;
	                        default:
	                            System.out.println("Invalid option. Please try again.");
	                    }
	                    break;

	                case CASUAL_USER:
	                    switch (choice) {
	                        case 1:
	                            System.out.println("Searching catalogue is not implemented yet.");
	                            break;
	                        case 2:
	                            System.out.println("Logging out...");
	                            return;
	                        default:
	                            System.out.println("Invalid option. Please try again.");
	                    }
	                    break;

	                case ADMIN:
	                    AdminUser admin = (AdminUser) user;
	                    switch (choice) {
	                        case 1:
	                            admin.listAllUsers(loginSystem.getUsers());
	                            break;
	                        case 2:
	                            System.out.println("Adding a new user...");
	                            loginSystem.registerUser();
	                            break;
	                        case 3:
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
