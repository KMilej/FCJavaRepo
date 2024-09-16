package taskweekTWO;
import java.util.Scanner;

public class Tasks  {
	
Scanner input = new Scanner(System.in);
		
		public void Menu() {
			// menu code goes here
					
			// in this primitive menu we are only allowing the user to make one choice
			
			System.out.println("tests of the greatest code ever");
			System.out.println();
			System.out.println("which small code you want to see from 10 to 13");
			
			
			System.out.println("10 - Task Exercise CheckerBoard");
			System.out.println("11 - Task Exercise GradesAverage ");
			System.out.println("12 - Task Exercise GradesStatistics  ");
			System.out.println("13 - Task Exercise NumberGuess");

			System.out.println("Please enter the number of the option you want:");
			String choice = input.nextLine();
			
			switch (choice) {
			case "10": 
				task10();
				break;			
			case "11": 
				task11();
				break;
			case "12":
				task12();
				break;
			case "13":
				task13();
				break;
		
			default: 
				System.out.println("Incorrect input");
				

			}
			
			input.close();
		}

	private void task10() {
		System.out.print("Enter the size of the pattern (n): or in task n=7 ");
	    int n = input.nextInt();

	    // Outer loop for rows
	    for (int i = 0; i < n; i++) {
	        // Inner loop for columns
	        for (int j = 0; j < n; j++) {
	            System.out.print("# "); // Print hash and space
	        }
	        System.out.println(); // Move to the next line after each row
	    }
		
	}
	
	
	private void task11() {
		System.out.print("number of students?");
		int numStudents = input.nextInt();
		
		 // Create an array to store grades
        int[] grades = new int[numStudents];
        int totalGrades = 0;
        
        // Loop to get each student's grade
        for (int i = 0; i < numStudents; i++) {
        	System.out.println("what is grade of " + (i+1));
        	
        	  // Validate the grade input
            int grade = input.nextInt();
        	while (grade < 0 || grade > 100) {  // Check if the grade is outside 0 to 100 range
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                grade = input.nextInt();
        	}  	

        	grades[i] = grade;
        	totalGrades += grades[i];
        	
        }
        
        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i]);
            
        }
        System.out.println("average scores is " + (totalGrades / numStudents));
	}
	
    
	private void task12() {
		System.out.print("number of students?");
		int numStudents = input.nextInt();
		
		 // Create an array to store grades
        int[] grades = new int[numStudents];
        int totalGrades = 0;
        
        // Loop to get each student's grade
        for (int i = 0; i < numStudents; i++) {
        	System.out.println("what is grade of " + (i+1));
        	
        	  // Validate the grade input
            int grade = input.nextInt();
        	while (grade < 0 || grade > 100) {  // Check if the grade is outside 0 to 100 range
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                grade = input.nextInt();
        	}  	

        	grades[i] = grade;
        	totalGrades += grades[i];
        	
        }
        
        for (int i = 0; i < grades.length; i++) {
            System.out.println(grades[i]);
            
        }
        System.out.println("average scores is " + (totalGrades / numStudents));
        
        System.out.println("Average grade: " + calculateAverage(grades));
        System.out.println("Minimum grade: " + findMinimum(grades));
        System.out.println("Maximum grade: " + findMaximum(grades));
                
	}
	
		 // Method to calculate average
	    public static double calculateAverage(int[] grades) {
	        int total = 0;
	        for (int grade : grades) {
	            total += grade;
	        }
	        return (double) total / grades.length;
	    }
	

	    // Method to find the minimum grade
	    public static int findMinimum(int[] grades) {
	        int min = grades[0];
	        for (int grade : grades) {
	            if (grade < min) {
	                min = grade;
	            }
	        }
	        return min;
	    }

	    // Method to find the maximum grade
	    public static int findMaximum(int[] grades) {
	        int max = grades[0];
	        for (int grade : grades) {
	            if (grade > max) {
	                max = grade;
	            }
	        }
	        return max;
	    }
	
	
	private void task13() {
/*		int[] grades = {85, 90, 78, 92};  // Array of integers

		for (int grade : grades) {
		    System.out.println("Grade: " + grade);	    
		}
	} */
		 // Generate a random number between 0 and 99
        int randomNumber = (int) (Math.random() * 100);
        int guess;
        int trials = 0;  // Count how many guesses it takes

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 0 and 99. Can you guess it?");

        // Loop to continue until the user guesses the correct number
        do {
            // Get the player's guess with validation
            guess = getValidatedGuess(input);
            trials++;  // Increment the number of trials

            // Check the guess and give feedback
            if (guess < randomNumber) {
                System.out.println("Try higher");
            } else if (guess > randomNumber) {
                System.out.println("Try lower");
            } else {
                System.out.println("You got it in " + trials + " trials!");
            }

        } while (guess != randomNumber);  // Continue until the guess is correct

        // Close the scanner to avoid resource leaks
        input.close();
    }

    // Method to get validated guess from the user
    public static int getValidatedGuess(Scanner input) {
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
}
		


