package com.techelevator;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FizzWriter {

	public static void main(String[] args) {

//		Entering the user file path
		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter path to the file: ");
		String filePath = userInput.nextLine();

//		Making a new file
		File fizzWriter = new File(filePath);

//		Creating a variable that contains a String & setting the value to 0
//		To convert an Integer x to a String, you can use x.toString() in your code. For example, if x = 1, then x.toString() returns "1."
		String show = String.valueOf(0);

//		Make a PrintWriter
		try (PrintWriter writer = new PrintWriter(fizzWriter)) {
			for (int i = 1; i <= 300; i++) {
//				Starts @1 since we're going from (1 to 300)
//				Less or Equal to 300
				if ((Integer.toString(0).contains("3")) && (Integer.toString(0).contains("5"))) {
					show = "FizzBuzz";
//					if (multipleOfThree && multipleOfFive) {
//				stringList.add(new String("FizzBuzz"));
				 } else if (Integer.toString(0).contains("3")) {
				show = "Fizz";
//				} else if (multipleOfThree) {
//				stringList.add(new String("Fizz"));
				} else if (Integer.toString(0).contains("5")) {
					show = "Buzz";
//				} else if (multipleOfFive) {
//				stringList.add(new String("Buzz"));
				} else if (i % 15 == 0) {
					show = "FizzBuzz";
//				if (multipleOfThree && multipleOfFive) {
//				stringList.add(new String("FizzBuzz"));
//					the {15} in the array returns "FizzBuzz"
				} else if (i % 3 == 0) {
					show = "Fizz";
//					multipleOfThree = currentInteger % 3 == 0;
				} else if (i % 5 == 0) {
					show = "Buzz";
//					multipleOfFive = currentInteger % 5 == 0;
				} else {
					show = Integer.toString(i);
//					Converting the Integer values to a String
				}
				writer.println(show);
//				PrintWriter to print on next line
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
//			The Exception
		}
	}
}