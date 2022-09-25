package edu.ics211.h03;

public class Vegatable extends EdiblePlant{
	//change it to name and the calories
public Vegatable(String PlantInput){
	this.plantName = PlantInput;
	this.plantType = PlantType.Vegetable;
	this.calories_per_grams = 0.15;
}
@Override
public boolean isGreen() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public double calories(double grams) {
	// TODO Auto-generated method stub
	return calories_per_grams * grams;
}
public String toString() {
	return super.name() + " is a grain " + calories(1) + " calories per gram "+ super.avaliable() + " grams available";
}
}
