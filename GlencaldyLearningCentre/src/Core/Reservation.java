// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// RESERVATION CLASS DEFINITION

//This class contains the structure for managing reservations, including details about the reserved item, user, reservation ID, and reservation date.


package Core;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reservation implements Serializable {
    private static final long serialVersionUID = 1L;
    private String reservationId;
    private String userId;
    private StockItem reservedItem;
    private LocalDateTime reservationDate;

    public Reservation(String reservationId, String userId, StockItem reservedItem) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.reservedItem = reservedItem;
        this.reservationDate = LocalDateTime.now();
    }

    public String getReservationId() {
        return reservationId;
    }

    public String getUserId() {
        return userId;
    }

    public StockItem getReservedItem() {
        return reservedItem;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", User ID: " + userId + ", Item: " + reservedItem +
               ", Date: " + reservationDate;
    }
}
