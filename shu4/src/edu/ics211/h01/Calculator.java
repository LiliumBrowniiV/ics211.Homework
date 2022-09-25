package edu.ics211.h01;

public class Calculator {
  public static double[] SquareRoots(int limit) {
	  //declaring the final result which is a double array
	  //to decide the length of the array
	  double[] result = new double[limit - 1];
	  
	  //conditional statement for numbers that are less than 2
	  if(limit < 2) {
		  return null;
	  }
	  
	  //conditional statement for numbers that are greater than 2
	  else 
	  {
		  //iterate through all the objects in the array
		  for(int ii = 2; ii <= limit; ii++) {
		  // change all the objects in array into their square roots form.
			result[ii - 2] = Math.sqrt(ii);
		  }
	  }
	  // return the final result
	  return result;
  }
}
