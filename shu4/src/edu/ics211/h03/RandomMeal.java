/**
 * RandomMeal
 * @date September 09, 2022
 * @author Chien-Hua Shu
 * @assignment Homework 3
 * @bugs none 
 */
package edu.ics211.h03;
import java.util.Arrays;

public class RandomMeal implements Meal{
	private static final EdiblePlant[] menu = {new Rice(), new Barley(), new Carrot(), new Lettuce()
			,new Apple(), new Banana(), new Watermelon()};
	/*
	
	System.out.println(Arrays.toString(RandArray()));
	System.out.println(Arrays.toString(RandTypeArray()));
	PlantType[] randtype = new PlantType[(int) (Math.random() * 4)];
	String[] res = new String[]{"Rice", "Barley"};
	PlantType[] type = new PlantType[]{PlantType.Grain};
	RandomMeal meal = new RandomMeal();
	*/
	public static void main(String[] args){
	//creating new EdliblePlant object
	EdiblePlant rice = new Rice();
	EdiblePlant barley = new Barley();
	EdiblePlant apple = new Apple();
	EdiblePlant watermelon = new Watermelon();
	EdiblePlant banana = new Banana();
	EdiblePlant carrot = new Carrot();
	EdiblePlant lettuce = new Lettuce();
	Edible carrot2 = new Carrot();
	Edible lettuce2 = new Lettuce();
	//create RandomMeal Object
	RandomMeal meal = new RandomMeal();
	//Equality test
	System.out.println("Chien-Hua Shu");
	System.out.println("Equality Test");
	if(rice.equals(barley) == barley.equals(rice)) {
		if(apple.equals(banana) == banana.equals(apple)) {
			if(watermelon.equals(carrot) == carrot.equals(watermelon)) {
				if(carrot2.equals(lettuce2) == lettuce2.equals(carrot2)) {
					if(lettuce.equals(lettuce2) == lettuce2.equals(lettuce)) {
						System.out.println("Equlity test is completed");
					}else{
						System.out.println("Equlity test is failed" + (lettuce.equals(lettuce2) == lettuce2.equals(lettuce)));
					}
				}else{
					System.out.println("Equlity test is failed" + (carrot2.equals(lettuce2) == lettuce2.equals(carrot2)));
				}
			}else{
				System.out.println("Equlity test is failed" + (watermelon.equals(carrot) == carrot.equals(watermelon)));
			}
		}else{
			System.out.println("Equlity test is failed" + (apple.equals(banana) == banana.equals(apple)));
		}
	}else{
		System.out.println("Equlity test is failed" + (rice.equals(barley) == barley.equals(rice)));
	}
	System.out.println("method test (watermelon object)");
	if(watermelon.name().equals("Watermelon")){
		if(watermelon.type().equals(PlantType.Fruit)) {
			watermelon.add(200);
			if(watermelon.avaliable() == 200){
				watermelon.consume(100);
					if(watermelon.avaliable() == 100){
						watermelon.consume(150);
						if(watermelon.avaliable() == 0) {
							if(watermelon.calories(10) == 3) {
								if(watermelon.toString().equals(watermelon.name() + " is a Fruit " + watermelon.calories(1) + " calories per gram "+ watermelon.avaliable() + " grams available")) {
									System.out.print("The method test is completed\n\n");
								}else {
									System.out.print("The method test is failed");
								}
							}else {
								System.out.print("The method test is failed");
							}
						}else {
							System.out.print("The method test is failed");
						}
					}else {
						System.out.print("The method test is failed");
					}
			}else {
				System.out.print("The method test is failed");
			}
		}else {
			System.out.print("The method test is failed");
		}
	}else {
		System.out.print("The method test is failed");
	}
	//meal test
	System.out.println("Meal object test\n");
	
	System.out.println("makeMeal method");
	EdiblePlant[] tester = meal.makeMeal(100);
	for(int i = 0; i < tester.length; i++) {
		System.out.print(tester[i].name() + " ");
		if(i == tester.length - 1) {
			System.out.println("\nDesired calories 100 cal");
			System.out.println("\n\n");
			
		}
	}
	
	EdiblePlant[] tester2 = meal.makeMeal(1000000000);
	System.out.println("Desired caloires 1000000000 cal" + Arrays.toString(tester2));
	
	//restricted meal test
	System.out.println("\n\nmakeRestrictMeal method (restricted plants)");
		EdiblePlant[] tester3 = meal.makeRestrictMeal(100, new String[]{"Rice","Apple"});
		for(int i = 0; i < tester3.length; i++) {
			System.out.print(tester3[i].name() + " ");
			if(i == tester3.length - 1) {
				System.out.println(Arrays.toString(new String[]{"Rice","Apple"}));
				System.out.println("Desired calories 100 cal");
				System.out.println("\n\n");
				
			}
		}
		
		EdiblePlant[] tester4 = meal.makeRestrictMeal(1000000000, new String[] {"Watermelon, Carrot, Barley"});
			System.out.println(Arrays.toString(new String[] {"Watermelon, Carrot, Barley"}));
			System.out.println("Desired caloires 1000000000 cal" + Arrays.toString(tester4));
			//restricted meal test
			System.out.println("\nmakeRestrictMeal method (restricted pants group)\n");
			PlantType [] testlist = new PlantType[] {PlantType.Vegetable,PlantType.Grain};
			EdiblePlant[] tester5 = meal.makeRestrictMeal(100,testlist);
			for(int i = 0; i < tester5.length; i++) {
				System.out.print(tester5[i].name() + " ");
				if(i == tester5.length - 1) {
					System.out.println(Arrays.toString(testlist));
					System.out.println("Desired calories 100 cal");
					System.out.println("\n\n");
					
				}
		}
			
			EdiblePlant[] tester6 = meal.makeRestrictMeal(1000000000, new PlantType[] {PlantType.Fruit});
			System.out.println(Arrays.toString(new PlantType[] {PlantType.Fruit}));
				System.out.println("Desired caloires 1000000000 cal" + Arrays.toString(tester6));
				
			System.out.println("Random calls test");
			int randcalories = (int) (Math.random() * 1001) + 500;
			EdiblePlant[] tester11 = meal.makeMeal(randcalories);
			for(int i = 0; i < tester11.length; i++) {
				System.out.print(tester11[i].name() + " ");
				if(i == tester11.length - 1) {
					System.out.println("\nDesired calories "+randcalories+" cal");
					System.out.println("\n\n");
					
				}
			}
			
			EdiblePlant[] tester12 = meal.makeMeal(randcalories);
			System.out.println("Desired caloires "+randcalories+"cal" + Arrays.toString(tester12));
			
			//restricted meal test
			System.out.println("\n\nmakeRestrictMeal method (restricted plants)");
				EdiblePlant[] tester13 = meal.makeRestrictMeal(randcalories,RandTypeArray());
				for(int i = 0; i < tester13.length; i++) {
					System.out.print(tester13[i].name() + " ");
					if(i == tester13.length - 1) {
						System.out.println(Arrays.toString(RandTypeArray()));
						System.out.println("Desired calories "+randcalories+" cal");
						System.out.println("\n\n");
						
					}
				}
				
				EdiblePlant[] tester14 = meal.makeRestrictMeal(randcalories, RandTypeArray());
					System.out.println(Arrays.toString(RandTypeArray()));
					System.out.println("Desired caloires "+randcalories+"cal" + Arrays.toString(tester14));
					//restricted meal test
					System.out.println("\nmakeRestrictMeal method (restricted pants group)\n");
					PlantType [] testlist1 = RandTypeArray();
					EdiblePlant[] tester15 = meal.makeRestrictMeal(randcalories,testlist1);
					for(int i = 0; i < tester15.length; i++) {
						System.out.print(tester5[i].name() + " ");
						if(i == tester15.length - 1) {
							System.out.println(Arrays.toString(testlist1));
							System.out.println("Desired calories "+randcalories+"cal");
							System.out.println("\n\n");
							
						}
				}
					
					EdiblePlant[] tester16 = meal.makeRestrictMeal(randcalories,RandTypeArray());
					System.out.println(Arrays.toString(RandTypeArray()));
						System.out.println("Desired caloires "+randcalories+" cal" + Arrays.toString(tester16));
						System.out.println("test successfully completed");
}
	
	
	@Override
	public EdiblePlant[] makeMeal(double calories) {
		double Mealcalories = 0;
		double scale = 1;
		int count = 0;
		EdiblePlant[] meal = new EdiblePlant[4];
		while(true){
			int randgram = (int) (Math.random() * 101 * scale);
			for(int i = 0; i < 4; i++) {
				if(count > 100) {
					System.out.println("Unable to create meal with desired calories");
					return new EdiblePlant[0];
				}
				double rand = (int) (Math.random() * 7);
				meal[i]= menu[(int)rand];
				Mealcalories += randgram * meal[i].calories_per_grams;
				/* debug
				System.out.println(scale);
				System.out.println(Mealcalories);
				*/
				}		
			if(Mealcalories > calories * 1.1) {
				count++;
				Mealcalories = 0;
			   scale /= 1.1;
			} else if(Mealcalories < calories / 1.1){
				count++;
				Mealcalories = 0;
				scale *= 1.1;
			} else{
				System.out.println(Mealcalories + " calroies");
				return meal;
			}	
		}
	}
@Override
	public EdiblePlant[] makeRestrictMeal(double calories, String[] restricted) {
	double Mealcalories = 0;
	double scale = 1;
	int count = 0;
	EdiblePlant[] meal = new EdiblePlant[4];
	while(true){
		for(int i = 0; i < 4; i++) {
			int randgram = (int) (Math.random() * 101 * scale);
			/*debug code
			System.out.println("randgram :" + randgram);
			System.out.println(count);
			*/
			if(count > 100) {
				System.out.println("Unable to create meal with desired calories");
				return new EdiblePlant[0];
			}
			double rand = (int) (Math.random() * 7);
			meal[i]= menu[(int)rand];
			for(int j = 0; j <restricted.length; j++){
			
				// make sure to check lowercase and uppercase
				while(meal[i].name().equals(restricted[j])) {	
					meal[i] = menu[(int)(Math.random() * 7)];
				}
			}
			Mealcalories += randgram * meal[i].calories_per_grams;
			/*
			System.out.println("scale :" + scale);
			System.out.println("calc :" + Mealcalories);
			*/
		
			//System.out.println(meal[i].plantType);
			}		
		if(Mealcalories > calories * 1.1) {
			count++;
			Mealcalories = 0;
		   scale /= 1.1;
		} else if(Mealcalories < calories / 1.1){
			count++;
			Mealcalories = 0;
			scale *= 1.1;
		} else{
			System.out.println(Mealcalories + " calroies");
			return meal;
		}	
	}
}
	@Override
	public EdiblePlant[] makeRestrictMeal(double calories, PlantType[] restricted) {
		double Mealcalories = 0;
		double scale = 1;
		int count = 0;
		EdiblePlant[] meal = new EdiblePlant[4];
		while(true){
			for(int i = 0; i < 4; i++) {
				int randgram = (int) (Math.random() * 101 * scale);
				/*
				System.out.println("randgram :" + randgram);
				System.out.println(count);
				*/
				if(count > 100) {
					System.out.println("Unable to create meal with desired calories");
					return new EdiblePlant[0];
					
				}
				double rand = (int) (Math.random() * 7);
				meal[i]= menu[(int)rand];
				for(int j = 0; j <restricted.length; j++){
					// make sure to check lowercase and uppercase
					while((meal[i].type().equals(restricted[j]))) {	
						meal[i] = menu[(int)(Math.random() * 7)];
					}
				}
				Mealcalories += randgram * meal[i].calories_per_grams;
				/*debug
				System.out.println("scale :" + scale);
				System.out.println("calc :" + Mealcalories);
				*/
				//System.out.println(meal[i].plantType);
				}		
			if(Mealcalories > calories * 1.1) {
				count++;
				Mealcalories = 0;
			   scale /= 1.1;
			} else if(Mealcalories < calories / 1.1){
				count++;
				Mealcalories = 0;
				scale *= 1.1;
			} else{
				System.out.println(Mealcalories + " calroies");
				return meal;
			}	
		}
	}
public String[] RandArray(){
	String [] randStringArr = new String[(int) (Math.random() * 4)];
	for(int i = 0; i < randStringArr.length; i++) {
		randStringArr[i] = menu[(int) (Math.random() * 7)].name();
	 for(int j = 0; j < i; j++) {
		 while(randStringArr[i].equals(randStringArr[j])) {
			 randStringArr[i] = menu[(int) (Math.random() * 7)].name();
		 }
	 }	
	}
	return randStringArr;
}
	


public static PlantType[] RandTypeArray(){
	PlantType[] randStringArr = new PlantType[(int) (Math.random() * 4)];
	for(int i = 0; i < randStringArr.length; i++) {
		randStringArr[i] = menu[(int) (Math.random() * 7)].plantType;
	 for(int j = 0; j < i; j++) {
		 while(randStringArr[i].equals(randStringArr[j])) {
			 randStringArr[i] = menu[(int) (Math.random() * 7)].plantType;
		 }
	 }	
	}
	return randStringArr;
}
}
