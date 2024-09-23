package JavaDiceGame;

import java.util.Scanner;

public class diceSimulator {

	public void rollDice() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("What is your Username?");
		String username = input.nextLine();
	
		  for (int i = 0; i < 20; i++) {
			  
			  int randomNumber = (int) (Math.random() * 6) + 1;
			  System.out.println(randomNumber);
			  
			  
			  
	}
	}
}
	/*	public static int getValidatedGuess(Scanner input) {
	        int guess;
	        // Keep asking for input until a valid guess (0-99) is entered
	        do {
	            System.out.print("Enter your guess (between 0 and 99): ");
	            while (!input.hasNextInt()) {  // Check if the input is an integer
	                System.out.println("Invalid input! Please enter a number between 0 and 99.");
	                input.next();  // Consume the invalid input
	                System.out.print("Enter your guess (between 0 and 99): ");
	            }
	            guess = input.nextInt();
	            if (guess < 0 || guess > 99) {
	                System.out.println("Your guess is out of range! Please enter a number between 0 and 99.");
	            }
	        } while (guess < 0 || guess > 99);  // Repeat until the guess is valid
	        return guess;
	    }
*/		

