package Core;

import java.util.ArrayList;
import java.util.List;

public class LoginSystem {
	
	 private List<User> users = new ArrayList<>();

	    public LoginSystem() {
	        // Inicjalizacja użytkowników
	        users.add(new AdminUser("A001", "admin123", "Admin", "User"));
	        users.add(new User("U001", "pass123", "John", "Doe", AccountType.FULL_MEMBER));
	        users.add(new User("U002", "pass123", "Jane", "Smith", AccountType.CASUAL_USER));
	        users.add(new User("U003", "pass123", "Alice", "Brown", AccountType.STAFF_USER));
	    }

	    public User validateLogin(String userID, String password) {
	        for (User user : users) {
	            if (user.getUserID().equals(userID) && user.getPassword().equals(password)) {
	                return user;
	            }
	        }
	        return null; // Nieprawidłowe dane logowania
	    }

	    public List<User> getUsers() {
	        return users;
	    }
	}
