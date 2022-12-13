package edu.ics211.Test;

public class PrintBinary {	
	    /* recursive method to print each bit of an integer followed
	     * by a space, except the first bit is followed by two spaces */
	    private static void printBinary(int value) {
		if (value < 2) {            /* first (or only) bit */
		    System.out.print(value + " ");
		} else {
	    /* print the bits before this one */
		    printBinary(value / 2);
	    /* print last bit */
		   System.out.print(value % 2 + " ");
		}
	    }

	    /* test the printBinary method
	     * expected output: 101 
	     */
	    public static void main(String [] args) {
		int valueToPrint = 10;
		printBinary(valueToPrint);
	    }
}
