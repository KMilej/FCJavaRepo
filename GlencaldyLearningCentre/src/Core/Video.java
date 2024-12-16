// Software Development: Object Oriented Programming
// H171 35
// Fife College

// OUTCOMES 1-3 : Creating a Glencaldy Learning Centre computer-based system in Java Programming
// AUTHOR: Kamil Milej
// DATE: 12/12/2024

// VIDEO CLASS DEFINITION

// This class contains the structure for video stock items, including attributes like duration, ID, title, quantity, and type, with methods to manage and represent these attributes.


package Core;

public class Video extends StockItem {

    /* PROPERTIES */
    private static final long serialVersionUID = 1L;
    private int duration;

    /* METHODS */

    // Constructor
    public Video(String id, String title, int quantity, int duration) {
        super(id, title, quantity, StockType.VIDEO);
        this.duration = duration;
    }

    // Gets the duration of the video.
    public int getDuration() {
        return duration;
    }

    // Sets the duration of the video.
    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Returns a string representation of the video.
    @Override
    public String toString() {
        return super.toString() + ", Duration: " + duration + " mins";
    }
}
