/**
 * Meal
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */
package edu.ics211.h03;

//interface of three methods
public interface Meal {
	Edible[] makeMeal(double calories);
	Edible[] makeRestrictMeal(double calories, String[] restricted);
	Edible[] makeRestrictMeal(double calories, PlantType[] restricted);
	
}
