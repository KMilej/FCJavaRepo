package taskweekONE;

import java.util.Scanner;

public class AssessmentTasks {
	Scanner input = new Scanner(System.in);
	public void Menu() {
		// menu code goes here
		
	Scanner input = new Scanner(System.in);
		
		// in this primitive menu we are only allowing the user to make one choice
		
		System.out.println("tests of the greatest code ever");
		System.out.println();
		System.out.println("which small code you want to see");
		
		
		System.out.println("1 - Task One, Hello world");
		System.out.println("2 - Task Two, ");
		System.out.println("3 - Task Three,  ");
		System.out.println("4 - Task Three, SumAndAverage ");
		System.out.println("5 - Task five, do while ");
		System.out.println("6 - Task six, sum of number 111 ");
		System.out.println("7 - Task seven, sum of the squares");
		System.out.println("8 - Task eight, moon’s gravity ");
		System.out.println("9 - Task nine, n×n (n=5) ");
		
		System.out.println("Please enter the number of the option you want:");
		String choice = input.nextLine();
		
		switch (choice) {
		case "1": 
			task1();
			break;
		case "2": 
			task2();
			break;
		case "3":
			task3();
			break;
		case "4":
			task4();
			break;
		case "5":
			task5();
			break;
		case "6":
			task6();
			break;
		case "7":
			task7();
			break;
		case "8":
			task8();
			break;
		case "9":
			task9();
			break;
		default: 
			System.out.println("Incorrect input");
			

		}
		
		input.close();
	}


private void task1() {
	 System.out.println("Hello World");
}

private void task2() {
	for (int i = 1; i <= 30; i++) {

    // Check if the number is even or odd
    if (i % 2 == 0) {
        System.out.println("The number is " + i + " and it is even");
    		} else {
        System.out.println("The number is " + i + " and it is odd");
    		}
		}
	}

private void task3() {
	
	        // Hard-coded lower and upper bounds
	 // Create a Scanner object to read input from the user
  //  Scanner scanner = new Scanner(System.in);

    // Prompt the user for the lower and upper bounds
    System.out.print("Enter the lower bound: ");
    int lowerBound = input.nextInt();

    System.out.print("Enter the upper bound: ");
    int upperBound = input.nextInt();

	        // Variables to hold the sums
	        int sumOdd = 0;
	        int sumEven = 0;

	        // Loop through the range
	        for (int i = lowerBound; i <= upperBound; i++) {
	            if (i % 2 == 0) {
	                sumEven += i; // Add to even sum if the number is even
	            } else {
	                sumOdd += i; // Add to odd sum if the number is odd
	            }
	        }

	        // Calculate the difference between the sums
	        int difference = sumOdd - sumEven;

	        // Print the results
	        System.out.println("Sum of odd numbers: " + sumOdd);
	        System.out.println("Sum of even numbers: " + sumEven);
	        System.out.println("Difference between odd and even sums: " + difference);
	    }

private void task4() {
	
	int sum = 0;
	double average = 0;
	int upperValue = 0;
	
	System.out.print("Enter the upper Value");
    upperValue = input.nextInt();
	
	for (int i = 1; i <= upperValue; i++) {
		sum += i; 		
	}
	average = (double) sum / upperValue;
	//average = (sum / upperValue);
	 System.out.println("Sum is: " + sum);
	 System.out.println("Average is: " + average);
}

private void task5() {
	int sum = 0;
	double average = 0;
	int upperValue = 0;
	
	System.out.print("Enter the upper Value");
    upperValue = input.nextInt();
    
    int i = 1;
    do {
    	System.out.println(i);
    	sum += i;
    	i++;
    } while (i <= upperValue);
    
    average = (double) sum / upperValue;
    
    System.out.println("Sum is: " + sum);
    System.out.println("Average is: " + average);
    
}

private void task6() {
	
	int sum = 0;
	double average = 0;
	int upperValue = 0;
	int sumOdd = 0;
	
	
	System.out.print("Enter the upper Value");
    upperValue = input.nextInt();
	
	for (int i = 111; i <= upperValue; i++) {
		sum += i; 		
	}
	average = (double) sum / upperValue;
	
    System.out.println("Sum is: " + sum);
    System.out.println("Average is: " + average);
    
    sum = 0;
	average = 0;
	upperValue = 0;
	sumOdd = 0;
    
	System.out.print("Enter the upper Value");
    upperValue = input.nextInt();
    
    for (int i = 111; i <= upperValue; i++) {
    if (i % 2 != 0) { // Check if the number is odd
        sum += i; // Add the odd number to the sum
        sumOdd++; // Increment the count of odd numbers
         
    	}
    }   
    // Calculate the average
    average = (double) sum / sumOdd;

    // Print the results
    System.out.println("The sum of odd numbers from " + 111 + " to " + upperValue + " is: " + sum);
    System.out.println("The average is: " + average);

    sum = 0;
	average = 0;
	upperValue = 0;
	sumOdd = 0;
	
	System.out.print("Enter the upper Value");
    upperValue = input.nextInt();
    
    for (int i = 111; i <= upperValue; i++) {	
    
    if (i % 7 == 0) { // Check if the number is divisible by 7 with no remainder
        System.out.println(i); // Display the number
        sum += i; // Add the number to the sum
        sumOdd++; // Increment the count of numbers divisible by 7
    }
    }


// Calculate the average
if (sumOdd > 0) {
    average = (double) sum / sumOdd;
} else {
    average = 0;
}

// Print the results
System.out.println("The sum of numbers divisible by 7 from " + 111 + " to " + upperValue + " is: " + sum);
System.out.println("The average of these numbers is: " + average);
	}

private void task7() {
	
	int sumOfSquares = 0;

    // Loop through numbers from 1 to 100
    for (int i = 1; i <= 100; i++) {
        int square = i * i; // Calculate the square of the number
        sumOfSquares += square; // Add the square to the sum
        
        // Print the number and its square
        System.out.println("Number: " + i + ", Square: " + square);
    }

    // Print the total sum of the squares
    System.out.println("The sum of the squares of all numbers from 1 to 100 is: " + sumOfSquares);
}



private void task8() {
	
	 final double MOON_GRAVITY = 0.17;

     // Loop through Earth pounds from 1 to 100
     for (int i = 1; i <= 100; i++) {
         // Calculate the equivalent moon weight
         double moonWeight = i * MOON_GRAVITY;
         
         // Print the Earth weight and corresponding moon weight
         System.out.printf("Earth pounds: %d, Moon weight: %.2f%n", i, moonWeight);

         // Print a line separator every 25 pounds
         if (i % 25 == 0) {
             System.out.println("==========================");
         }
     }    
}

private void task9() {
	
	System.out.print("Enter the size of the pattern (n): ");
    int n = input.nextInt();
    
//	int n = 5; // size of the pattern (n x n)

    // Outer loop for rows
    for (int i = 0; i < n; i++) {
        // Inner loop for columns
        for (int j = 0; j < n; j++) {
            System.out.print("# "); // Print hash and space
        }
        System.out.println(); // Move to the next line after each row
    }
	
}

}







		
