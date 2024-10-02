package JavaDiceGame;

public class diceSimulator {

	public void rollDice() {
	
		
		  for (int i = 0; i < 20; i++) {
			  
			  int randomNumber = (int) (Math.random() * 6) + 1;
			  System.out.println(randomNumber);
			  
						  
		}
	}
}


