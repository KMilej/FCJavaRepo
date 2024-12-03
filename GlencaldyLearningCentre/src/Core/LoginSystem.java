package Core;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginSystem {
	
	 private List<User> users = new ArrayList<>();

	 public LoginSystem() {
		    // Dodanie przykładowych użytkowników
		    users.add(new AdminUser("admin", "admin123", "Admin", "User"));
		    users.add(new User("jdoe", "pass123", "John", "Doe", AccountType.FULL_MEMBER));
		    users.add(new User("jsmith", "pass123", "Jane", "Smith", AccountType.FULL_MEMBER));
		    users.add(new User("mtaylor", "pass123", "Mark", "Taylor", AccountType.FULL_MEMBER));
		    users.add(new User("padams", "pass123", "Paul", "Adams", AccountType.CASUAL_USER));
		    users.add(new User("lclark", "pass123", "Lucy", "Clark", AccountType.CASUAL_USER));
		    users.add(new User("ehill", "pass123", "Emma", "Hill", AccountType.CASUAL_USER));
		    users.add(new User("abrown", "pass123", "Alice", "Brown", AccountType.STAFF_USER));
		    users.add(new User("jwilson", "pass123", "James", "Wilson", AccountType.STAFF_USER));
		    users.add(new User("swalker", "pass123", "Sophia", "Walker", AccountType.STAFF_USER));
		}

	 public User validateLogin(String username, String password) {
		    for (User user : users) {
		        if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
		            return user;
		        }
		    }
		    return null; // Nieprawidłowe dane logowania
		}

	    public List<User> getUsers() {
	        return users;
	    }
	    
	    public void registerUser() {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter Username: ");
	        String username = scanner.nextLine();
	        
	        for (User user : users) {
	            if (user.getUsername().equals(username)) {
	                System.out.println("Username already exists. Please choose a different username.");
	                return;
	            }
	        }
	        
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

	        // Tworzenie użytkownika z automatycznie wygenerowanym UserID
	        User newUser = new User(username, password, firstName, lastName, accountType);
	        users.add(newUser);
	        System.out.println("Registration successful! Your User ID is: " + newUser.getUserID());
	    }
	    
	    public void displayAllUsers() {
	        System.out.println("\n<<TESTING>> Predefined Users:");
	        for (User user : users) {
	            System.out.println(user + " | Password: " + user.getPassword());
	        }
	    }
	  
	}
