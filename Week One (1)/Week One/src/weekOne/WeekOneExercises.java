package weekOne;

import java.util.Scanner;

// this class is where you will write your code. 

// some things have already been filled in - you don't need to worry too much about that, your lecturer
// will explain

public class WeekOneExercises {

	
	// class wide variables go here
	// any data you want to be available to all methods in your class would be declared here
	// this need not concern you just now
	
	// every class has a constructor, which is called when the class is created - this need not concern you just now
	// constructor
	public WeekOneExercises() {
		
	}
	
	// methods
	// a method is like a function. It can either be internal to the class (private) or able to be called by other 
	// classes (public)
	// In this case this is a public method, so the WeekOneController class will call it to start your exercises
	
	// For this lesson you can write all your code in this method
	public void runExercises() {

		System.out.println("Welcome to The happy World of Java");
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("What is you First Name?");
		String firstName = scanner.nextLine();
		
		System.out.println("What is you Surname?");
		String userSurname = scanner.nextLine(); 
				
		
		System.out.println("how old are you?");
		int userAge = scanner.nextInt();
		
		System.out.println("Hello " + firstName + " " + userSurname + " Age: " + userAge);
		
		if (userAge >= 18) {
			System.out.println("Drinks are free at the java Bar");
		}	else if (userAge < 18) {
			System.out.println("Sorry you cant enter the bar area");
		} else	{
			System.out.println("you Imput Invalid Information");	
		}
		
// 	#6		
		
		System.out.println("Bar lenght?");
		int barLenght = scanner.nextInt();
		
		System.out.println("Bar breadth?");
		int barBreadth = scanner.nextInt();
		
		
		int measure = barLenght * barBreadth;
				System.out.println("bar measure is: " + measure);
//  #7 	
				
		System.out.println("How many bags of straw you need?");
		int bagsofStraw = scanner.nextInt();
		
		
		int bagofstrawCost = 6;
		int postandpackCost = 3; 
		int total;
		
		System.out.print("Your bags of straw will cost you " + (bagsofStraw * bagofstrawCost + 3) + " £");
		
		if (bagsofStraw < 7 ) {
			total = (bagsofStraw * 6 + 3);
			System.out.print("Your bags of straw will cost you " + total + " £");
		} else {
			total = (bagsofStraw * bagofstrawCost);
			System.out.println("Your bags of straw will cost you " + total + " £");
		}
		
		System.out.println("do you want to continue Y/N?");
		String userAnswer = scanner.next();
		
		
		if (userAnswer.equals("Y")) {
			System.out.println("ELo");
		} else {
			System.out.println("Nie ELo");
		
		
		}
	}
	
	
	
}
	
