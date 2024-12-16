// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// LOGIN SYSTEM CLASS DEFINITION

// This class contains methods for managing user authentication, registration, and persistent storage of user data.

package Core;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginSystem {

	/* PROPERTIES */
	private List<User> users = new ArrayList<>();
	private static final String GlencaldyUsers = "GlencaldyUsers.dat";
	private static Scanner scanner = new Scanner(System.in);

	/* METHODS */

	// Constructor
	public LoginSystem() {
		loadUsersFromFile();
		if (users.isEmpty()) {
			addDefaultUsers();
			saveUsersToFile();
		}
	}

	// Adds default users to the system.
	private void addDefaultUsers() {
		users.add(new AdminUser("admin", "admin123", "Admin", "User", generateUniqueUserID()));
		users.add(new User("jdoe", "pass123", "John", "Doe", AccountType.FULL_MEMBER, generateUniqueUserID()));
		users.add(new User("jsmith", "pass123", "Jane", "Smith", AccountType.FULL_MEMBER, generateUniqueUserID()));
		users.add(new User("mtaylor", "pass123", "Mark", "Taylor", AccountType.FULL_MEMBER, generateUniqueUserID()));
		users.add(new User("padams", "pass123", "Paul", "Adams", AccountType.CASUAL_USER, generateUniqueUserID()));
		users.add(new User("lclark", "pass123", "Lucy", "Clark", AccountType.CASUAL_USER, generateUniqueUserID()));
		users.add(new User("ehill", "pass123", "Emma", "Hill", AccountType.CASUAL_USER, generateUniqueUserID()));
		users.add(new User("abrown", "pass123", "Alice", "Brown", AccountType.STAFF_USER, generateUniqueUserID()));
		users.add(new User("jwilson", "pass123", "James", "Wilson", AccountType.STAFF_USER, generateUniqueUserID()));
		users.add(new User("swalker", "pass123", "Sophia", "Walker", AccountType.STAFF_USER, generateUniqueUserID()));
	}

	// Saves the list of users to a file.
	public void saveUsersToFile() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GlencaldyUsers))) {
			oos.writeObject(users);
			System.out.println("Users saved to file.");
		} catch (IOException e) {
			System.out.println("Error saving users: " + e.getMessage());
		}
	}

	// Loads the list of users from a file.
	@SuppressWarnings("unchecked")
	public void loadUsersFromFile() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(GlencaldyUsers))) {
			users = (List<User>) ois.readObject();
			System.out.println("Users loaded from file.");
		} catch (FileNotFoundException e) {
			System.out.println("No user file found. Default users will be created.");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error loading users: " + e.getMessage());
		}
	}

	// Validates the login credentials for a user.
	public User validateLogin(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	// Returns the list of users.
	public List<User> getUsers() {
		return users;
	}

	// Registers a new user in the system.
	public void registerUser() {
	    while (true) {
	        System.out.print("Enter Username (minimum 4 characters): ");
	        String username = scanner.nextLine(); // Declare `username` inside the loop.

	        if (username.length() < 4) {
	            System.out.println("Username must be at least 4 characters long. Please try again.");
	            continue;
	        }

	        boolean usernameExists = users.stream()
	                .anyMatch(user -> user.getUsername().equalsIgnoreCase(username));

	        if (usernameExists) {
	            System.out.println("Username already exists. Please choose a different username.");
	        } else {
	            System.out.print("Enter Password: ");
	            String password = scanner.nextLine();

	            System.out.print("Enter First Name: ");
	            String firstName = scanner.nextLine();

	            System.out.print("Enter Last Name: ");
	            String lastName = scanner.nextLine();

	            System.out.println("Choose Account Type: 1 - Full Member, 2 - Casual User");
	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            AccountType accountType;
	            switch (choice) {
	                case 1:
	                    accountType = AccountType.FULL_MEMBER;
	                    break;
	                case 2:
	                    accountType = AccountType.CASUAL_USER;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Registration failed.");
	                    return;
	            }

	            String uniqueID = generateUniqueUserID();
	            User newUser = new User(username, password, firstName, lastName, accountType, uniqueID);
	            users.add(newUser);
	            System.out.println("Registration successful! Your User ID is: " + newUser.getUserID());
	            break; // Exit the loop after successful registration.
	        }
	    }
	}


	// Displays all users in the system.
	public void displayAllUsers() {
		System.out.println("\n<<TESTING>> Predefined Users:");
		for (User user : users) {
			System.out.println(user + " | Password: " + user.getPassword());
		}
	}

	// Generates a unique user ID.
	private String generateUniqueUserID() {
		int maxID = users.stream().mapToInt(user -> Integer.parseInt(user.getUserID().substring(1))).max().orElse(0);

		return "U" + String.format("%04d", maxID + 1);
	}
}
