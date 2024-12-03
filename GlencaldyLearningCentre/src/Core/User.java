package Core;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private static int idCounter = 1;
	private String userID;
	private String username;
    private String password;
    private String firstName;
    private String lastName;
    private AccountType accountType; // Nowy atrybut

    public User(String username ,String password, String firstName, String lastName, AccountType accountType) {
        this.userID = generateUserID();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
    }

    private String generateUserID() {
        return "U" + String.format("%04d", idCounter++); // Generuje ID w formacie np. U0001, U0002
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
    
  
}