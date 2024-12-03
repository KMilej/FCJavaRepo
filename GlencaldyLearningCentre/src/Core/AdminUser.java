package Core;

import java.util.List;

public class AdminUser extends User {

    public AdminUser(String userID, String password, String firstName, String lastName) {
        super(userID, password, firstName, lastName, AccountType.ADMIN);
    }

    public void addNewUser(List<User> users, User newUser) {
        users.add(newUser);
        System.out.println("User added: " + newUser.getFirstName() + " " + newUser.getLastName());
    }

    public void listAllUsers(List<User> users) {
        System.out.println("List of all users:");
        for (User user : users) {
            System.out.println(user);
        }
    }
}