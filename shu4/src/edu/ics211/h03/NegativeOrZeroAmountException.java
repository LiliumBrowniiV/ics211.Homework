package edu.ics211.h03;

public class NegativeOrZeroAmountException extends RuntimeException {
	//
	public NegativeOrZeroAmountException(String s){
	
}
	//Constructor overloading
	public NegativeOrZeroAmountException(){
	System.out.println("The avaliablility is less then 0 grams");
	}
//to describe what is this exception
public String toString() {
	return "This is a Exception when the availability is less than 0";
}
}
