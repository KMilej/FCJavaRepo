// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// RESERVATION CLASS DEFINITION

// This class contains the structure for managing reservations, including details about the reserved item, user, reservation ID, and reservation date.


package Core;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Reservation implements Serializable {

    /* PROPERTIES */
    private static final long serialVersionUID = 1L;
    private String reservationId;
    private String userId;
    private StockItem reservedItem;
    private LocalDateTime reservationDate;

    /* METHODS */
    public Reservation(String reservationId, String userId, StockItem reservedItem) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.reservedItem = reservedItem;
        this.reservationDate = LocalDateTime.now();
    }

    // Gets the reservation ID.
    public String getReservationId() {
        return reservationId;
    }

    // Gets the user ID associated with the reservation.
    public String getUserId() {
        return userId;
    }

    // Gets the reserved item.
    public StockItem getReservedItem() {
        return reservedItem;
    }

    // Gets the reservation date.
    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    // Returns a string representation of the reservation details.
    @Override
    public String toString() {
        return "Reservation ID: " + reservationId + ", User ID: " + userId + ", Item: " + reservedItem +
               ", Date: " + reservationDate;
    }
}
