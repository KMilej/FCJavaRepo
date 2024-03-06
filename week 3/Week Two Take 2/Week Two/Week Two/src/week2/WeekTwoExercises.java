package week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeekTwoExercises {
	// class wide variables go here
	// class wide variables can be used by any code in the class
	private ArrayList<Double> priceList; 
	
	// constructor 
	public WeekTwoExercises() {
		// create and populate the priceList variable
		priceList = new ArrayList<Double>();
		priceList.add(3.50);
		priceList.add(1.99);
		priceList.add(5.49);
		priceList.add(1.99);
		priceList.add(4.00);
		priceList.add(1.89);
		priceList.add(10.20);
		priceList.add(4.50);
		priceList.add(12.00);
		priceList.add(6.00);
		
	}
	
	// methods
	public void runExercises() {
		// NOTE: input validation in this example is poor - we will return to this in later exercises
		// local variables
		Scanner input = new Scanner(System.in);
		
		// in this primitive menu we are only allowing the user to make one choice
		
		System.out.println("Welcome to The Wacky World of Lists");
		System.out.println();
		System.out.println("Please select from the following list of activities");
		
		
		System.out.println("1 - Task One, Search For A Name");
		System.out.println("2 - Task Two, Price List");
		System.out.println("3 - Task Three, Create a Menu");
		
		System.out.println("Please enter the number of the option you want:");
		int choice = input.nextInt();
		
		switch (choice) {
		case 1: 
			Task1();
			break;
		case 2: 
			Task2();
			break;
		case 3:
			Task3();
			break;
		default: 
			System.out.println("Incorrect input");
		}
		
		input.close();
	}
	
	// private methods
	
	// creates a list of names and searches for the user
	private void Task1() {
		
		ArrayList<String> pupilNames = new ArrayList<>();

        // Add 10 names to the list
        pupilNames.add("John Milej");
        pupilNames.add("Alice");
        pupilNames.add("Bob");
        pupilNames.add("Emily");
        pupilNames.add("Michael");
        pupilNames.add("Sarah");
        pupilNames.add("David");
        pupilNames.add("Emma");
        pupilNames.add("James");
        pupilNames.add("Olivia");

        // Ask the user to provide a name to search for
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name to search for: ");
        String searchName = scanner.nextLine();

        // Display an appropriate message based on whether the name is found or not
        boolean found = false;
        for (String name : pupilNames) {
            if (name.equalsIgnoreCase(searchName)) {
                found = true;
                break;
            }
        }
        

        if (found) {
            System.out.println(searchName + " is found in the list.");
        } else {
            System.out.println(searchName + " is not found in the list.");
        }


	}
		

	
	// creates and manipulates a list of prices
	private void Task2() {
		
	
	}
	
	// creates a menu
	private void Task3() {
		
		
	}
}
