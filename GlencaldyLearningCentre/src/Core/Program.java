package Core;

import java.util.List;

public class Program {

	public static void main(String[] args) {
		System.out.println("Welcome to the Glencaldy Learning Centre");
		System.out.println("To see all options please log in");
		
		 LoginSystem loginSystem = new LoginSystem();
		 List<User> users = loginSystem.getUsers();

	        // Przykład logowania
	        System.out.println("Logging in...");
	        User loggedInUser = loginSystem.validateLogin("U001", "pass123"); // Przykładowe dane logowania

	        if (loggedInUser != null) {
	            System.out.println("Login successful: " + loggedInUser);

	            // Obsługa na podstawie typu użytkownika
	            switch (loggedInUser.getAccountType()) {
	                case FULL_MEMBER:
	                    System.out.println("Full Member - up to 4 loans allowed.");
	                    // Dodaj logikę dla Full Member
	                    break;

	                case STAFF_USER:
	                    System.out.println("Staff Member - up to 6 loans allowed.");
	                    // Dodaj logikę dla Staff Member
	                    break;

	                case CASUAL_USER:
	                    System.out.println("Casual User - can only use items within the Learning Centre.");
	                    // Dodaj logikę dla Casual User
	                    break;

	                case ADMIN:
	                    System.out.println("Admin - Access to all system functionalities.");
	                    AdminUser admin = (AdminUser) loggedInUser;
	                    admin.listAllUsers(users);
	                    admin.addNewUser(users, new User("U005", "pass123", "NewUser", "Example", AccountType.FULL_MEMBER));
	                    break;

	                default:
	                    System.out.println("Unknown account type.");
	                    break;
	            }
	        } else {
	            System.out.println("Invalid login credentials.");
	        }
	    }
}
