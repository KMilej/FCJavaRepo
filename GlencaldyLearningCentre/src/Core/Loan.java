// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// LOAN CLASS DEFINITION

// This class contains the structure for managing loans, including details about the borrowed item, user, loan ID, loan date, and return date.

package Core;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Loan implements Serializable {
    private static final long serialVersionUID = 1L;
    private String loanId;            // Unique ID for the loan
    private String userId;            // ID of the user borrowing the item
    private StockItem borrowedItem;   // The item being borrowed
    private LocalDateTime loanDate;   // Date when the loan was created
    private LocalDateTime returnDate; // Expected return date

    public Loan(String loanId, String userId, StockItem borrowedItem, LocalDateTime returnDate) {
        this.loanId = loanId;
        this.userId = userId;
        this.borrowedItem = borrowedItem;
        this.loanDate = LocalDateTime.now(); // Sets the current time as the loan date
        this.returnDate = returnDate;
    }

    // Getters and Setters
    public String getLoanId() {
        return loanId;
    }

    public String getUserId() {
        return userId;
    }

    public StockItem getBorrowedItem() {
        return borrowedItem;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
        return "Loan ID: " + loanId +
               ", User ID: " + userId +
               ", Item: " + borrowedItem +
               ", Loan Date: " + loanDate.format(formatter) +
               ", Return Date: " + returnDate.format(formatter);
    }
}