package edu.ics211.h03;
/**
 * Grain
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */

public abstract class Grain extends EdiblePlant {
	
//constructor
	public Grain(String PlantInput, double calories){
		this.plantName = PlantInput;
		this.plantType = PlantType.Grain;
		this.calories_per_grams = calories;
	} 
	
//to display that grain type in not green
 @Override
 public boolean isGreen() {
	 return false;
 }
 //toString general info
 public String toString() {
	 return super.name() + " is a grain " + super.avaliable() + " grams available";
 }
}
