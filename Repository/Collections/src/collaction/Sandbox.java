package collaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Sandbox {

	// try out collections
	
	public void runTest() {
		
		// create an arraylist of string
		ArrayList<String> listOfString = new ArrayList<String>();
		
		// create an arraylist of integers
		ArrayList<Integer> listOfIntegers = new ArrayList<Integer>();
		
		// create a hashmap containing String and Integers
		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();
		
		// add some strings to listOFString
		
		listOfString.add("rabbit");
		listOfString.add("mouse");
		listOfString.add("badger");
		listOfString.add("hamster");
		
		// get the third item in the list
		
		System.out.println(listOfString.get(2));
		
		listOfString.set(1, "dog");
		
		System.out.println();
		
		for(String val : listOfString) {
			
			System.out.println(val);
		}
		
		System.out.println();
		
		//add gerbil to the list at position
		listOfString.add(2, "gerbil");
		
		// normal for loop
		
		for(int i = 0; i < listOfString.size(); i++) {
			
			System.out.println(listOfString.get(i));
		}
		
		// lets move on the list of integers
		// we'll get the values from the user
		
		Scanner input = new Scanner(System.in);
		
		Boolean exit = false;
		
		while (exit != true) {
			System.out.println("Enter an integer or -1 to exit");
			int userInput = input.nextInt();
		
		
		if(userInput == -1) {
			exit = true;
		} else {
			listOfIntegers.add(userInput);
		}
		
		}	
		// we'are out of the loop, lets print what a user in the list
		for(int num : listOfIntegers) {
			System.out.println(num);
		}
			
		for(int i = 0; i <listOfString.size(); i++) {
			
			String animal = listOfString.get(i);
			System.out.println("how many " + animal + " s are in the zoo?");
			int animalNum = input.nextInt();
			
			dictionary.put(animal, animalNum);
			
			
		}
		//out of the loop
		System.out.println();
		
		for(Entry<String, Integer> item : dictionary.entrySet() ) {
			System.out.println("There are " + item.getValue() + " " + item.getKey() + "s in the zoo") ;
		}
	}
}
