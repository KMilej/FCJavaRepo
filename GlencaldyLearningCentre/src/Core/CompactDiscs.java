// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// COMPACT DISC CLASS DEFINITION

// The CompactDiscs class represents a specific type of stock item: Compact Discs (CDs).
// This class extends the StockItem class, adding an attribute for the duration of the CD.


package Core;

public class CompactDiscs extends StockItem {

    /* PROPERTIES */
    private static final long serialVersionUID = 1L;
    private int duration; // Długość w minutach

    /* METHODS */
    public CompactDiscs(String id, String title, int quantity, int duration) {
        super(id, title, quantity, StockType.COMPACT_DISC);
        this.duration = duration;
    }

    // Gets the duration of the CD.
    public int getDuration() {
        return duration;
    }

    // Sets the duration of the CD.
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Returns a string representation of the CD, including its duration.
    @Override
    public String toString() {
        return super.toString() + ", Duration: " + duration + " mins";
    }
}
