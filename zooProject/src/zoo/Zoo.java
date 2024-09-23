package zoo;

import java.util.ArrayList;

public class Zoo {

	// constructor
		private int numAnimals;
		private ArrayList<Tiger> tigers;
		private ArrayList<Bird> birds;
		
		public Zoo() {
		System.out.println("creating a new zoo!!");
		
		numAnimals = 0;
		tigers = new ArrayList<Tiger>();
		birds = new ArrayList<Bird>();
			
	}
		//creates a tiger for the zoo
		public void createTiger() {
			Tiger theTiger = new Tiger();
			tigers.add(theTiger);
			
			numAnimals++;
		}
		
		public void createBird() {
			Bird theBird = new Bird();
			birds.add(theBird);
			numAnimals++;
		}
		
		public int getnumAnimals() {
			
			return numAnimals;
		}
}
