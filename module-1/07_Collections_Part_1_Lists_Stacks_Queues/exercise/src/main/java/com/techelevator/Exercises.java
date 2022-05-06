package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
	 array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
	 array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
	 */
	public List<String> array2List(String[] stringArray) {

		List<String> array2List = new ArrayList<String>(); ///Declaring New ArrayList
		//array2List is the identifier; the <> means the data type
		for (String healthyFood : stringArray) { //Using for each loop with Arrays
			array2List.add(healthyFood); //The Add method is used for adding new values
		}
		return array2List;
	}


	/*
	 Given a list of Strings, return an array containing the same Strings in the same order
	 list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
	 list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
	 list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
	 */
	public String[] list2Array(List<String> stringList) {

		String[] list2Array = new String[(stringList.size())];
		//The new keyword is used to create an instance of a class
		//.size reflects the current number of elements in the collection
		for (int i = 0; i < stringList.size(); i++) {
			//for loop i = 0 less than stringList.size & increments value
			list2Array[i] = stringList.get(i);
			//.get to access an element in the ArrayList, refer to the index number
			System.out.println(list2Array[i]);
			//prints the line of list2Array
		}

		stringList.clear();
		//.clear method used for removing all elements from the list

		return list2Array;
		//prints the List
	}

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */
	public List<String> no4LetterWords(String[] stringArray) {
		//return an ArrayList that contains more than or less than but not equal to 4 characters
		//!= to 4 characters
		//< less than 4 characters
		// > more than 4 characters

		List<String> no4LetterWords = new ArrayList<String>();
		//Declaring a new arraylist
		//no4LetterWords is the identifier; the <> means the data type

		for (String sameOrder : stringArray) {
			if (sameOrder.length() == 4) {
				//saying the length is equal to 4
				sameOrder = "";
			} else {
				no4LetterWords.add(sameOrder);
				//the identifier is being added to sameOrder
			}
		}
		return no4LetterWords;
		//returning the identifier
	}

	/*
	 Given an array of ints, divide each int by 2, and return an ArrayList of Doubles.
	 arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
	 arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
	 arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
	 */
	public List<Double> arrayInt2ListDouble(int[] intArray) {

		List<Double> arrayInt2ListDouble = new ArrayList<Double>();
		//Declaring a new arraylist
		//arrayInt2ListDouble is the identifier; the <> means the data type

		//Declaring the variable
		double arrayDouble;
		arrayDouble = 2.0;
		//The value of the double is set to 2.0

		//For each loop
		for (int newValue : intArray) {
			arrayInt2ListDouble.add(newValue / arrayDouble);
			//Using the identifier, add method is used to add new values
			//arrayDouble is the dividing by 2
		}

		return arrayInt2ListDouble;
	}

	/*
	 Given a List of Integers, return the largest value.
	 findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
	 findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
	 findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 81238
	 */
	public Integer findLargest(List<Integer> integerList) {
		//List of Integers
		//Return the largest value

		//Declare
		List<Integer> findLargest = new ArrayList<Integer>();

		//The Max Value
		int maxValue = 0;

		//For each loop to find the max element
		for (int newValue : integerList) {
			if (newValue > maxValue)
				maxValue = newValue;
		}
		return maxValue;
		//Returning the maxValue from the list
	}

	/*
	 Given an array of Integers, return a List of Integers containing just the odd values.
	 oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83]
	 oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
	 oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
	 */
	public List<Integer> oddOnly(Integer[] integerArray) {
		//Returning a list of integers, but only the odd values
		List<Integer> oddOnly = new ArrayList<Integer>();
		//Declaring a new arraylist
		//oddOnly is the identifier; the <> means the data type
		for (int oddValues : integerArray) {
			////Using for each loop with Arrays
			if (oddValues % 2 == 1) {
				//ex. 9/3 = 3; == 0,
				//ex. 9/2 == 1, remainder of 1, chosen 2(even)
				//using the % finds the remainder
				oddOnly.add(oddValues);
				//.add method is used for adding a specific element into a set collection
			} else {
				continue;
				//the continue method is used for skipping the current iteration of a loop
			}
		}
		return oddOnly;
		//returning the oddOnly
	}

	/*
	 Given a List of Integers, and an int value, return true if the int value appears two or more times in
	 the list.
	 foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
	 foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
	 foundIntTwice( [9, 23, 44, 2, 88, 44], 44) -> true
	 */
	public boolean foundIntTwice(List<Integer> integerList, int intToFind) {
		//List of Integers
		//Int values need to appear at least 2 times

		//Declare
		List<Integer> findLargest = new ArrayList<Integer>();

		//The count
		int newValue = 0;

		for (Integer appears : integerList) {
			if (intToFind == appears) {
				////Using for each loop with Arrays
				//compares the value of two object references
				newValue = newValue + 1;

			}
		}
		if (newValue == 2) {
			return true;
			//will return true only if two object reference it's comparing represent exactly same object
		}

		return false;
	}

	/*
	 Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
	must be replaced by the String "Fizz", any multiple of 5 must be replaced by the String "Buzz",
	and any multiple of both 3 and 5 must be replaced by the String "FizzBuzz."
	** INTERVIEW QUESTION **

	fizzBuzzList( {1, 2, 3} )  ->  ["1", "2", "Fizz"]
	fizzBuzzList( {4, 5, 6} )  ->  ["4", "Buzz", "Fizz"]
	fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  ["7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

	HINT: To convert an Integer x to a String, you can use x.toString() in your code. For example, if x = 1, then x.toString() returns "1."
	 */
	public List<String> fizzBuzzList(Integer[] integerArray) {
		//Given an array of integers
		//Return a list
		//Multiple of 3 = String "Fizz"
		//Multiple of 5 = String "Buzz"
		//Multiple of both 3 & 5 = String "FizzBuzz"
		//To convert from Int to String, use .toString()

		//To declare
		List<String> result = new ArrayList<String>();
		for (Integer i : integerArray) {
			if (i % 3 == 0 && i % 5 == 0) {
				result.add("FizzBuzz");
			} else if (i % 5 == 0) {
				result.add("Buzz");
			} else if (i % 3 == 0) {
				result.add("Fizz");
			} else {
				result.add(i.toString());
				//.add method is used for adding a specific element into a set collection
			}
		}
		return result;
	}

	/*
	 Given two lists of Integers, interleave them beginning with the first element in the first list followed
	 by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
	 Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
	 list to the new list before returning it.
	 interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
	 */
	public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {

		//To declare
		List<Integer> interleaveLists = new ArrayList<Integer>();

		//listOne

		//listTwo

		int maxListLength = Math.max(listOne.size(),
				listTwo.size());
		//Created an integer for the max list length

		for (int i = 0; i < maxListLength; i++) {
			if (i < listOne.size()) {
				interleaveLists.add(listOne.get(i));
				//Getting element at index i
			}
			if (i < listTwo.size()) {
				interleaveLists.add(listTwo.get(i));
				//Getting element at index i
				//.add method is used for adding a specific element into a set collection
			}
		}

		return interleaveLists;
	}
}


