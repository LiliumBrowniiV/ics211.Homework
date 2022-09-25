package edu.ics211.h03;
/**
 * EdiblePlant
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */

public abstract class EdiblePlant implements Edible{
//declaring some variables 
protected String plantName;
protected PlantType plantType;
protected double availability; 
protected double calories_per_grams;

//access name
public String name() {
	return plantName;
}

//access plantType
public PlantType type() {
	return plantType;
}

//access availability
public double avaliable() {
	return availability;
}

//adding certain edible plant
public void add(double amount) {
	if(amount <= 0) {
		throw new NegativeOrZeroAmountException();
	} 
	else {
		availability += amount;
	}
}

// consume edible plant
public double consume(double amount) {
	if(amount <= 0) {
		throw new NegativeOrZeroAmountException();
		}
	double temp;
	if(amount > avaliable()){
		temp = availability;
		availability = 0;
		return temp;
	} else {
		return availability -= amount;
	}
}

//equal method that check two Objects 
public boolean equals(Object other) {
	if(other == null) {
		return false;
	}
	if(other instanceof EdiblePlant){
		EdiblePlant otherPlant = (EdiblePlant) other;
		if(plantName.equals(otherPlant.plantName)) {
			if ((availability <= otherPlant.availability * 1.1) && (otherPlant.availability <= availability *1.1)) {
				return true;
			}else {
				return false;
			}
		} else {
			return false;
		}
	} else {
		return false;
	}
	
}

//two abstract method to be implemented
public abstract boolean isGreen();
public abstract double calories(double grams);
}
