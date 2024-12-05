package Core;

public class CompactDiscs extends StockItem {
    private int duration; // Długość w minutach

    public CompactDiscs(String id, String title, int quantity, int duration) {
        super(id, title, quantity, StockType.COMPACT_DISC);
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return super.toString() + ", Duration: " + duration + " mins";
    }
}
