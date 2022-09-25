package edu.ics211.h03;

/**
 * Carrot
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */
public abstract class Fruit extends EdiblePlant{
	//constructor
	public Fruit (String PlantInput, double calories){
		super();
		this.plantName = PlantInput;
		this.plantType = PlantType.Fruit;
		this.calories_per_grams = calories;
	}
	//toString that display plant type calories per grams and availability; 
		@Override
		public String toString() {
			return super.name() + " is a Fruit " + calories(1) + " calories per gram "+ super.avaliable() + " grams available";
		}
}
