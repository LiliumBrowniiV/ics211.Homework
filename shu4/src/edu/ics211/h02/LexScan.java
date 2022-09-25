/**
 * Modulo
 * @date September 01, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 2 LexcialScanner
 * @bugs none 
 */

package edu.ics211.h02;

import java.util.*;

public class LexScan {
	//implement unit test 
	public static void main(String[] args) {
		System.out.println("Chien-Hua Shu");
		System.out.println(unitTest());
	}
	
	public static boolean unitTest() {
		//sort testing condition into an array
		String[] condition = new String[4];
		 condition[0] = "a2 = a1 + b22;";
		 condition[1] = "for (int i = 0; i <= string.length; i++) {System.out.println()}";
		 condition[2] = "public static boolean unitTest(String[] args)";
		 condition[3] = "double[] testingArrays = new double[10]";
		 
		 //iterate through all testing conditions
		 for(int i = 0; i < condition.length; i++) {
			 //variable declaration
			 String[] tokens; 
			 StringBuilder placeholder = new StringBuilder();  
			 tokens = lexcialScanner(condition[i]);
			 System.out.println("Result of lexcial scanning : " + Arrays.toString(tokens));
			 //turn the array into a String
			 for(String str :tokens) {
					placeholder.append(str);
				 } 
			 //the expected output
			 String TestString = condition[i].replaceAll("\\s+","");
			 //return false if the actual result doesn't fit the expected result
			 if(!(TestString.equals(placeholder.toString()))){
				 System.out.println("Fail to pass the unit test");
				 return false;
			 }
			 //format
			 System.out.println("verfication : \n" + TestString + "\n" + "Tokens string :\n" + placeholder + "\n");
		 }
		 //format
		 System.out.println("unit test succeed");
		 //return true if the unit test is passed
		return true;
	}
	
	public static String[] lexcialScanner(String arg) {
	// variable deceleration
	String[] result = new String[arg.length()];
	char check;
	String holder = "";
	int count = 0;
	//iterate through the input string
	for(int i = 0; i < arg.length(); i++) {
		//check each character 
		check = arg.charAt(i); 
		// if the character is a valid letter or number 
		if (Character.isJavaIdentifierStart(check) || Character.isJavaIdentifierPart(check) || Character.isDigit(check)) {
			//put them all in one place
			holder += Character.toString(check);
			// if the character is white space (encounter a white space)
		}else if (Character.isWhitespace(check)) {
			// if the holder is not empty
	      if(holder != "") {
	    	  //put all the collected letter and number in front of the white space
	    	  result[i - 1] = holder;
	    	  //clear the holder for next loop
		      holder = "";
	      }
	      //change the white space into null
	        result[i] = null;
	      // if character is not a letter number which means it part of the Java program
		} else if (!(Character.isJavaIdentifierPart(check))) {
			if(holder != "") {
				//put all the letter in front of that sign
				  result[i - 1] = holder;
				  //clear the holder
			      holder = "";
			}
			//put that sign into array
			result[i] = Character.toString(check);
		}
		// if the program end with nothing
		if((i == arg.length() - 1) && holder != "") {
			//put down all the letter in holder and clear it
			result[i] = holder;
			holder = "";
		}
	}
	//bubble sort algorithm
	//iterate through all the items in array
	for(int i = 0; i < result.length -1; i++) {
		//iterate through the all the items except for the last one(decrease 1 loop as i increase)
		for(int j = 0; j < result.length - i -1; j++) {
			//if the item is null
			if(result[j] == null) {
				
				//Basically swap the null until it hits the end of the array
				//put it in a holder
				String temp = result[j];
				//put the item in font of it at the it's original position
				result[j] = result[j + 1];
				//put null in front of it's original position
				result[j + 1] = temp;
			}
		}
		
	}
	// count for how many null
	for(int i = 0; i < result.length; i++) {
		if(result[i] == null) {
			count++;
		}
	}
	// return the array with correct length and without null
	return Arrays.copyOf(result,result.length - count);
}
}

