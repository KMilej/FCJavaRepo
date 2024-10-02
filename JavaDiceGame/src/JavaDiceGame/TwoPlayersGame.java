package JavaDiceGame;

import java.util.Scanner;

public class TwoPlayersGame {

	private diceOne dice;     ////declare private variable of instance of name dice, we use it to have access to all method in class diceOne but its not initialized yet.
	private int score;  
	
	Scanner scanner = new Scanner(System.in);	
	
	public TwoPlayersGame() {
		dice = new diceOne(); // this code create instance of the class diceOne
	    score = 0;
				
	}
	public void playTime() {
		 System.out.println("Enter First Player name:");
	     Player player1 = new Player(scanner.nextLine(), score);  //this declare a variable named player1 of type Player(referance to Player class) score i guess should store score value and never this value never will lost.

	     System.out.println("Enter Secound Player name:");
	     Player player2 = new Player(scanner.nextLine(), score);
	     
	     boolean keepPlaying = true;
	     while (keepPlaying) {
	        System.out.println("\n" + player1.getName() + "'s turn to roll the dice.");   // we get from class player info about name
	        player1 = playTurn(player1);  // The current player1 object is passed to the playTurn method. This allows the method to operate on this particular player object, which includes rolling the dice and updating the player's points.

	        // Player 2 rolls the dice three times
	        System.out.println("\n" + player2.getName() + "'s turn to roll the dice.");
	        player2 = playTurn(player2); 
      
	        determineWinner(player1, player2); // you call the determineWinner method, passing two objects player1 and player2 as arguments or parameter.
	        
	        keepPlaying = askPlayAgain(); // this call a method on variable keepPlaying and in return response.equalsIgnoreCase we get True if user say Y and False if N
	    	}
	     	System.out.println("\nFinal Scores:");       // \n i use sometimes to put info in another line for better look.
	        System.out.println(player1.getName() + ": " + player1.getScore());    // get info from player object and show info which is inside 
	        System.out.println(player2.getName() + ": " + player2.getScore());

	        System.out.println("Thank you for playing!");
	    }
	public Player playTurn(Player player) { //Once the method has completed its execution, it returns an updated Player object, e.g. with a new score.
        //Passing an object: The player1 object is passed as an argument to the playTurn method.
		//Operations on the object: Inside the method, various operations are performed (e.g., rolling a dice, updating the score) on the player1 object.
		//Returning an object: Once the operation is complete, the method returns the same player1 object, but with an updated state (e.g., a new score).
		//Then, the player1 object is assigned back to the player1 variable, allowing the game to continue with the current score.
				
		int totalScore = 0;

        for (int i = 1; i <= 3; i++) {
            int roll1 = dice.roll();
            int roll2 = dice.roll();

            System.out.println("Roll " + i + ": Dice 1 = " + roll1 + ", Dice 2 = " + roll2);

            // Add 1 point if the two dice show the same number
            if (roll1 == roll2) {
                totalScore += 1;
                System.out.println("You rolled two of the same number! +1 point.");
            }
        }

        player.addScore(totalScore);
        System.out.println(player.getName() + "'s score after 3 rolls: " + player.getScore());

        return player;  // Return updated player with new score
    }

    // Method to determine and announce the winner
    public void determineWinner(Player player1, Player player2) {
        System.out.println("\nFinal Scores:");
        System.out.println(player1.getName() + ": " + player1.getScore());
        System.out.println(player2.getName() + ": " + player2.getScore());

        if (player1.getScore() > player2.getScore()) {
            System.out.println(player1.getName() + " wins!");
        } else if (player1.getScore() < player2.getScore()) {
            System.out.println(player2.getName() + " wins!");
        } else {
            System.out.println("It's a tie!");
        }    
	}
    // Method to ask players if they want to play again
    public boolean askPlayAgain() {
        System.out.println("\nDo you want to play another round? (Y/N)");
        String response = scanner.nextLine();

        return response.equalsIgnoreCase("Y"); //Returning a value: The method returns true if the response is "Y", otherwise it returns false.
    }
}
