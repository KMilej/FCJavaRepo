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
	
	 private List<User> users = new ArrayList<>();
	 private static final String GlencaldyUsers = "GlencaldyUsers.dat";
	 
	 public LoginSystem() {
	        // Ładowanie użytkowników z pliku
	        loadUsersFromFile();
	        if (users.isEmpty()) {
	            // Jeśli brak danych w pliku, dodajemy użytkowników domyślnych
	            addDefaultUsers();
	            saveUsersToFile();
	        }
	    }

	  private void addDefaultUsers() {
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
	 
	 public void saveUsersToFile() {
	        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(GlencaldyUsers))) {
	            oos.writeObject(users);
	            System.out.println("Users saved to file.");
	        } catch (IOException e) {
	            System.out.println("Error saving users: " + e.getMessage());
	        }
	    }

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

	 
	 public User validateLogin(String username, String password) {
		    for (User user : users) {
		        if (user.getUsername().equals(username) && user.getPassword().equals(password)) { // Wrażliwe na wielkość liter
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
	            if (user.getUsername().equalsIgnoreCase(username)) { // Porównanie niezależne od wielkości liter
	                System.out.println("Username already exists (case-insensitive). Please choose a different username.");
	                return; // Przerwanie rejestracji
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
