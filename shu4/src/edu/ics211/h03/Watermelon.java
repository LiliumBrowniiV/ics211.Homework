package edu.ics211.h03;

public class Watermelon extends Fruit{
	//constructor inherit from fruit
	public Watermelon() {
		super("Watermelon", 0.3);
	}
	// watermelon is green
	public boolean isGreen() {
		return true;
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
			return super.name() + " is a Fruit " + calories(1) + " calories per gram "+ super.avaliable() + " grams available";
		}
}
