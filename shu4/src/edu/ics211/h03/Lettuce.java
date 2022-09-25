package edu.ics211.h03;
/**
 * Lettuce
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */
public class Lettuce extends Vegatable{

	
	public Lettuce() {
		super("Lettuce");
	}
	//toString that display plant type calories per grams and availability; 
		@Override
		public String toString() {
			return super.name() + " is a vagatalbe " + calories(1) + " calories per gram "+ super.avaliable() + " grams available";
		}

}
