package Core;

public class User {
    private String userID;
    private String password;
    private String firstName;
    private String lastName;
    private AccountType accountType; // Nowy atrybut

    public User(String userID, String password, String firstName, String lastName, AccountType accountType) {
        this.userID = userID;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountType = accountType;
    }

    public String getUserID() {
        return userID;
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
        return firstName + " " + lastName + " (ID: " + userID + ", Type: " + accountType + ")";
    }
}