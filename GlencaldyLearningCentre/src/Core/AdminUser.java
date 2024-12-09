package Core;

import java.util.List;

class AdminUser extends User {
	private static final long serialVersionUID = 1L;
	
    public AdminUser(String username, String password, String firstName, String lastName, String userID) {
        super(username, password, firstName, lastName, AccountType.ADMIN, userID);
    }

    public void addNewUser(List<User> users, User newUser) {
        users.add(newUser);
        System.out.println("User added: " + newUser);
    }

    public void listAllUsers(List<User> users) {
        System.out.println("\nList of all users:");
        for (User user : users) {
            System.out.println(user);
        }
    }
    public void deleteUser(List<User> users, String userID) {
    	
        User userToDelete = null;

        for (User user : users) {
            if (user.getUserID().equalsIgnoreCase(userID)) {
                userToDelete = user;
                break;
            }
        }

        if (userToDelete != null) {
            users.remove(userToDelete);
            System.out.println("User with ID " + userID + " has been deleted.");
        } else {
            System.out.println("User with ID " + userID + " not found.");
        }
    } 
}