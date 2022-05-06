package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter Length: ");
		String lengthInput = userInput.nextLine();

		int lengthOfMeasurement = Integer.parseInt(lengthInput);
		double metersConversion = lengthOfMeasurement * 0.3048;
		double feetConversion = lengthOfMeasurement * 3.2808399;

		System.out.println("Is the measurement in (m)eter, or (f)eet?");
		String inputOfMorL = userInput.nextLine();
		if (inputOfMorL.equals("m")) {
			System.out.println("Length in feet: " + feetConversion);
		}
		if (inputOfMorL.equals("f")) {
			System.out.println("Length in feet: " + metersConversion);
		}

	}
}







