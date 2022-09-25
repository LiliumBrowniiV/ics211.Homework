package edu.ics211.h03;
/**
 * Apple
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */

public class Apple extends Fruit{
	//constructor 
	public Apple(){
		super("Apple",0.52);
	}
	// Apple is not green
	public boolean isGreen() {
		// TODO Auto-generated method stub
		return false;
	}

	// get calories
	public double calories(double grams) {
		// TODO Auto-generated method stub
		return calories_per_grams * grams;
	}

	//toString that display plant type calories per grams and availability; 
		@Override
		public String toString() {
			return super.name() + " is a Fruit " + calories(1) + " calories per gram "+ super.avaliable() + " grams available";
		}
}
