package edu.ics211.h03;
/**
 * Banana
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */

public class Banana extends Fruit{
	//constructor
		public Banana(){
			super("Banana", 0.89);
		}
	//banana is not green
		@Override
		public boolean isGreen() {
			// TODO Auto-generated method stub
			return false;
		}
	//get calories
		@Override
		public double calories(double grams) {
			// TODO Auto-generated method stub
			return calories_per_grams * grams;
		}
		//toString that display plant type calories per grams and availability; 
		@Override
		public String toString() {
			return super.name() + " is a Fruit "  + calories(1) + " calories per gram "+ super.avaliable() + " grams available";
		}

}
