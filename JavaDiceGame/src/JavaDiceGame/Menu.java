package JavaDiceGame;

import java.util.Scanner;

public class Menu {
	
	static void mainManu() {
		

		
	Scanner scanner = new Scanner(System.in);
	

    System.out.println("Hello Players what is your NickName?");
    String name = scanner.nextLine();
    
    userName User = new userName(name);  // we make a user object
    
    System.out.println("Hello " + User);
    
    
	System.out.println("Welcome in MainMenu what you want to do, today?");
    System.out.println("1. Dice Simulator");
    System.out.println("2. Throw A Six");
    System.out.println("3. Throw Two Same Numbers");
    System.out.println("4. Play with friend");
    

    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume the newline character
    

    switch (choice) {           // basic switch with few option 
        case 1:
        	// diceSimulator object and method call
        	diceSimulator diceSim = new diceSimulator();
        	diceSim.rollDice();
            break;
        case 2:
        	trowasix game = new trowasix(); // we make object game of type trowsix class and we call a main method to play 
        	game.play();
            break;
        case 3:
    		DoubleDIce doubledice = new DoubleDIce();
    		doubledice.doubleplay();
            break;
        case 4:
        	TwoPlayersGame twoPlayersGame = new TwoPlayersGame();
            twoPlayersGame.playTime();
            break;
        default:
            System.out.println("Invalid choice. Please select 1, 2, 3, 4.");
            break;
    }
    
    System.out.println("Thank you for playing, " + User + "!");
    scanner.close();


	
	//trowasix game = new trowasix();
	//DoubleDIce doubledice = new DoubleDIce();
		

	  
	}	  
}
