package edu.ics211.h03;
/**
 * Edible
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3 
 * @bugs none 
 */
//interface that contain two methods
public interface Edible {
	
	//get calories with required grams
	double calories(double grams);
	
	//consume certain plant
	double consume(double amount);
}
