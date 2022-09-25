/**
 * Modulo
 * @date September 01, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 2 Modulo
 * @bugs none 
 */

package edu.ics211.h02;

public class Modulo {
	// main method to implement 
	public static void main(String[] args) {
	System.out.println("Chien-Hua Shu");
	System.out.println(unitTest());
	}
	//modulo method 
	public static long modulo(long divisor, long dividend ) {
	//variable declaration
			long result;  
			long mult;
			long remainder = 0;
	
	try {
		result = divisor/dividend;
		 mult =result * dividend;
		 remainder = divisor - mult;
	}catch(ArithmeticException e){
		System.out.println(e);
	}
	//return remainder
	  return remainder;	
	}
	//unit test method 
	public static boolean unitTest(){
		int TestingNum = 0;
		int TestingNumTwo;
		//repeat the unit test 
		// randomly select numbers between -20 and 20 for divisor and -5 5 for dividend
			for (int i = 0; i <= 20; i++) {
				//avoid getting zero
				 TestingNum = ((int)(Math.random() * 41.0)) - 20;
				 TestingNumTwo = ((int)(Math.random() * 11.0)) - 5;
				while(TestingNumTwo == 0) {
					TestingNumTwo = ((int)(Math.random() * 11.0))- 5;
				}	
					long result = modulo(TestingNum, TestingNumTwo);
					//print out the result
					System.out.println("Divisor: " + Integer.toString(TestingNum) + " Dividend: " + Integer.toString(TestingNumTwo) + " remainder: " + Long.toString(result));
					//if the result is not equal to it suppose to be
					if( result != (TestingNum % TestingNumTwo)) {
						//error statement
						System.out.println("fail to pass the unit test");
						//return result of unit test
						return false;
					}
				
			}
			//Buffer
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("\n");
			System.out.println("Test when attempts to pass 0 in the second arugment");
			for (int i = 0; i <= 20; i++) {
				//avoid getting zero
				 TestingNum = ((int)(Math.random() * 41.0)) - 20;
				 TestingNumTwo = 0;
				 try {
					 long result = modulo(TestingNum, TestingNumTwo);
					//print out the result
						System.out.println("Divisor: " + Integer.toString(TestingNum) + " Dividend: " + Integer.toString(TestingNumTwo) + " remainder: " + Long.toString(result));
						//if the result is not equal to it suppose to be
						if( result != (TestingNum % TestingNumTwo)) {
							//error statement
							System.out.println("fail to pass the unit test");
							//return result of unit test
							return false;
						}
					
				 }
				 //catch and print out the errors
				 catch(ArithmeticException e){
					 System.out.println("Error : divided by zero");
				 }
			}
			
			
			//passing statement
			System.out.println("unit test succeed");
			return true;
			
	}
}
