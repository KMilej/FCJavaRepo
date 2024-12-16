// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// USER CLASS DEFINITION

//This class contains the structure and behavior for a user, including attributes like username, password, account type, login history, and methods for managing user actions such as changing passwords and viewing login history.


package Core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    private String userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private AccountType accountType;
    private List<String> loginHistory; // Login History 

    public User(String username, String password, String firstName, String lastName, AccountType accountType, String userID) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
        this.loginHistory = new ArrayList<>();
    }
    
    public void addLoginRecord(String timestamp) {
    	if (loginHistory == null) {
            loginHistory = new ArrayList<>(); // Zainicjalizuj, jeśli jest null
        }
        loginHistory.add(timestamp);
    }

    public void viewLoginHistory() {
        System.out.println("\nLogin History:");
        if (loginHistory.isEmpty()) {
            System.out.println("No login history available.");
        } else {
            for (String record : loginHistory) {
                System.out.println(record);
            }
        }
    }

    public String getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (Username: " + username + ", ID: " + userID + ", Type: " + accountType + ")";
    }
    
    public void changePassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your current password: ");
        String currentPassword = scanner.nextLine();

        if (!this.password.equals(currentPassword)) {
            System.out.println("Incorrect password. Please try again.");
            return;
        }

        System.out.print("Enter your new password: ");
        String newPassword = scanner.nextLine();

        System.out.print("Confirm your new password: ");
        String confirmPassword = scanner.nextLine();

        if (!newPassword.equals(confirmPassword)) {
            System.out.println("Passwords do not match. Please try again.");
            return;
        }

        this.password = newPassword;
        System.out.println("Your password has been successfully updated.");
    }
}
