package JavaDiceGame;
import java.util.Scanner;
public class DoubleDIce {
	
	private diceOne dice;  //declare private variable of instance of name dice, we use it to have access to all method in class diceOne
	private int score;  

	Scanner scanner = new Scanner(System.in);
	
	public DoubleDIce() {
		dice = new diceOne(); 
	    score = 0;
	}
	public void doubleplay() {
		
			System.out.println("'Double Dice game ! ");		
		    System.out.println("lets start, you have 3 throws, if you roll 2 same number you get a point");
		  
		  for (int i = 0; i < 3; i++) {
			  
			  int rollResult1 = dice.roll();
	          int rollResult2 = dice.roll();
	          
	          System.out.println("Roll 1: " + rollResult1);
	          System.out.println("Roll 2: " + rollResult2);
			  
	          if (rollResult1 == rollResult2) {
	                score++;
	                System.out.println("You rolled two of the same number! +1 point");
	          } else {
	        	  System.out.println("No match, no points this round.");
	          }
				
				  
		}
	    System.out.println("Game over! Your final score is: " + score);  
	}
}
