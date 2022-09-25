package edu.ics211.h03;
/**
 * Barley
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */

public class Barley extends Grain{
	//construct Barley
	public Barley(){
		 super("Barley" ,1.23);
	 } 
//calculate its calories 
	@Override
	public double calories(double grams) {
		return calories_per_grams * grams;
	}
// toString that display plant type calories per grams and availability; 
	@Override
	public String toString() {
		return super.name() + " is a grain" + calories(1) + " calories per gram "+ super.avaliable() + " grams available";
	}
}
