package edu.ics211.h03;
/**
 * Carrot
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */

public class Carrot extends Vegatable{

	public Carrot() {
		super("Carrot");
	}
	@Override
	public boolean isGreen(){
		return false;
	}
	//toString that display plant type calories per grams and availability; 
		@Override
		public String toString() {
			return super.name() + " is a  vagatalbe " + calories(1) + " calories per gram "+ super.avaliable() + " grams available";
		}
}
