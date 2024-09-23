package zoo;

public class myMain {

	static private Zoo myZoo;
	
	public static void main(String[] args) {
	
		// create a new instance of zoo
		
		myZoo = new Zoo();
		
		myZoo.createTiger();
		myZoo.createBird();
		myZoo.createTiger();
		myZoo.createBird();
		
		System.out.println("there are " + myZoo.getnumAnimals() + " animals in the zoo");
	}

}
