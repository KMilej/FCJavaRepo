package JavaDiceGame;

public class Player {
    private String name;
    private int score;

    // Constructor to initialize player with name and score (optional handicap)
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    // Get the player's name
    public String getName() {
        return name;
    }

    // Get the player's score
    public int getScore() {
        return score;
    }

    // Set a new score for the player
    public void setScore(int score) {
        this.score = score;
    }

    // Add points to the player's score
    public void addScore(int points) {
        this.score += points;
    }
}