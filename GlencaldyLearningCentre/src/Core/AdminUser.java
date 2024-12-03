package Core;

import java.util.List;

class AdminUser extends User {
    public AdminUser(String username, String password, String firstName, String lastName) {
        super(username, password, firstName, lastName, AccountType.ADMIN);
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
}