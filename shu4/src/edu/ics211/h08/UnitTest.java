package edu.ics211.h08;

public class UnitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(pushTest());
		System.out.println(LpushTest());
		System.out.println(stackCapacityTest());
		System.out.println(operationTest());
		System.out.println(LoperationTest());
	}
	
	public static boolean pushTest() {
		StackCalculator calc = new StackCalculator(new ArrayStack<Double>());
		calc.pushValue(5.0);
		if (calc.getTop() != 5.0) {return false;}
		calc.pushValue(15.0);
		if (calc.getTop() != 15.0) {return false;}
		calc.applyOperation('+');
		if(calc.getTop() != 20.0) {return false;}
		return true;
	}
	/**
	 * 
	 * @return
	 */
	public static boolean  LpushTest() {
		StackCalculator calc = new StackCalculator(new LinkedStack<Double>());
		calc.pushValue(5.0);
		if (calc.getTop() != 5.0) {return false;}
		calc.pushValue(15.0);
		if (calc.getTop() != 15.0) {return false;}
		calc.applyOperation('+');
		if(calc.getTop() != 20.0) {return false;}
		return true;
	}
	public static boolean stackCapacityTest() {
		StackCalculator calc2 = new StackCalculator(new ArrayStack<Double>());
		calc2.pushValue(1);
		calc2.pushValue(1);
		calc2.pushValue(1);
		calc2.pushValue(1);
		try {
			calc2.pushValue(9);
			return false;
		} catch (Throwable t) {
			return true;
		}
	}
	public static boolean operationTest() {
		StackCalculator calc2 = new StackCalculator(new ArrayStack<Double>());
		calc2.pushValue(1);
		calc2.pushValue(1);
		calc2.pushValue(1);
		calc2.applyOperation('+');
		try {
			calc2.CheckFinalValidity();
			return false;
		} catch (Throwable t) {
			return true;
		}
	}
	public static boolean LoperationTest() {
		StackCalculator calc2 = new StackCalculator(new LinkedStack<Double>());
		calc2.pushValue(1);
		try {
			calc2.applyOperation('+');
			return false;
		} catch (Throwable t) {
			return true;
		}
	}
	
}
