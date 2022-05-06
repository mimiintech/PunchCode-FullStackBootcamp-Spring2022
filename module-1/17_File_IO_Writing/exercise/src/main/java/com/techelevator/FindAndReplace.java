package com.techelevator;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FindAndReplace {

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);

        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String wordToReplace = userInput.nextLine();

        System.out.println("What is the source file?");
        String filePath = userInput.nextLine();

        System.out.println("What is the destination file?");
        String destinationFile = userInput.nextLine();

        File bookFile = new File(filePath);

        try (Scanner wordInput = new Scanner(bookFile);
            PrintWriter word = new PrintWriter(destinationFile)) {
            while(wordInput.hasNextLine()) {
                    String word1 = wordInput.nextLine();
                    word.println(word1.replaceAll(searchWord , wordToReplace));
                }

            } catch (FileNotFoundException e) {
        System.out.println("File not found: ");
        }
    }
}
