/*
 * square roots calculator and file reader 
 * @author Chien-Hua Shu
 * @assignment homework 1 
 * @data August 25, 2022
 * @bugs none
 */

//import all the necessary classes 
package edu.ics211.h01;
import java.io.*;
import java.util.Arrays;
public class Main {

	public static void main(String[] args){
		//declaring some variables
		int num = ((int) (Math.random() * 11));
		int arraylength = num -1;
		double [] output;
		//implement the method 1
		// conditional statement for numbers that are less than 2
		if (num < 2) {
			System.out.println("The randomized number is " + num);
			output = new double[0];
			System.out.println(Arrays.toString(output) + " nothing is in the array");
			
		} else {
			output = Calculator.SquareRoots(num);
			//print out the method 1 properly 
			System.out.println("The randomized number is " + num);
			for(int ii = 0; ii< arraylength; ii++) {
				if (ii == arraylength - 1) {
					System.out.println(output[ii]);
				}
				else {
					System.out.print(output[ii] + " , ");
				}
			}
		}
		// declaring variables 
		int result;
		//iterate through all the arguments 
		for(int ii = 0; ii < args.length;ii++) {
		//implement method 2
		result = FilesManipulator.BufferedFileReader(args[ii]);
		int resulttwo = FilesManipulator.FileReader(args[ii]);
		//print out the method 2 
		System.out.println(args[ii] + " " + result);
		
		//print out the mehtod 2  (class example)
		//System.out.println(args[ii]+ " " + resulttwo);
		}
		
		
		
		
		
	}
}


