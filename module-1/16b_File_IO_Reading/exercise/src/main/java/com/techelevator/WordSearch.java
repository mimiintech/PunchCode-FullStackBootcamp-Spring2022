package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);
		System.out.println("Enter path to the book file: ");
		String filePath = userInput.nextLine();

		File bookFile = new File(filePath);
		System.out.println("Enter keyword: ");
		String searchWord = userInput.nextLine();

		System.out.println("Should the search be case sensitive? (Y/N)");
		String caseSensitive = userInput.nextLine();

		int lineCount = 0;

		try (Scanner fileInput = new Scanner(bookFile)) {
			while (fileInput.hasNextLine()) {
				String lineOfText = fileInput.nextLine();
				lineCount++;

				if (caseSensitive.equalsIgnoreCase("N")) {
					if (lineOfText.toLowerCase().contains(searchWord.toLowerCase())) {
						System.out.println(lineCount + ": " + lineOfText);
					}
				}
				if (caseSensitive.equalsIgnoreCase("Y")) {
					if (lineOfText.contains(searchWord)) {
						System.out.println(lineCount + ": " + lineOfText);
					}
				}

			}
		}
			catch(FileNotFoundException e){
				System.out.println("File not found");
			}
	}
}