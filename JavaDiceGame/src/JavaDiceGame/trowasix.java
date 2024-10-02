package JavaDiceGame;

public class trowasix {

	private diceOne dice;  //
	private int score;  

	public trowasix() {
    dice = new diceOne(); 
    score = 5;    // how many life user have      
	}
	
    public void play() {
    	System.out.println("'Throw A Six' game! good choice! ");
    	System.out.println("you have 5 attends or lifes and if you roll 6 you win");
    	
        System.out.println("lets start Throw A Six");
        
        while (score > 0) {
            int rollResult = dice.roll();
            System.out.println("You rolled " + rollResult);
            

            if (rollResult == 6) {
                System.out.println("Congratulations! You rolled 6 and you won the game with value of rolles " + score);
                break; // to finish all method
            }
            

            score--;
            System.out.println("You have " + score + " rolls left");

            if (score == 0) {
                System.out.println("Sorry, you lost. You have no more attends.");
            }
        }
    
    
	}	
}
