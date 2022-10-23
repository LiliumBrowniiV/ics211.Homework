package edu.ics211.h08;

import java.util.*;

// figure out what class variable you need
// and the implementaiotn of these 4 methods 
public class StackCalculator {
	StackInterface<Double> stack;
	Scanner sc = new Scanner(System.in);
	public StackCalculator(StackInterface<Double> stack) {
		this.stack = stack;
	} 
	@SuppressWarnings("unlikely-arg-type")
	public void UserInterface() {
		String input;
		while (true) {
			System.out.println("Enter numbers to calculate; = to stop and get result ");
			input = sc.nextLine();
			if(input.equals("=")) {
				CheckValidity();
				System.out.println(getTop());
				break;
			} else if(!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/")) {
				pushValue(Double.parseDouble(input));
			} else {
				applyOperation(input.charAt(0));
			}
		}
	}

	public void pushValue(double value) {
		stack.push(value);
	}
	public void applyOperation(char operation) {
		Double FirstPop = stack.pop();
		Double SecondPop = stack.pop();
		Double result = 0.0;
		if(Character.compare(operation, '+') == 0) {
			result = SecondPop + FirstPop;
			pushValue(result);
			result = 0.0;
		} else if(Character.compare(operation, '-') == 0) {
			result = SecondPop - FirstPop;
			pushValue(result);
			result = 0.0;
		}  else if(Character.compare(operation, '*') == 0) {
			result = SecondPop * FirstPop;
			pushValue(result);
			result = 0.0;
		}  else if(Character.compare(operation, '/') == 0) {
			result = SecondPop / FirstPop;
			pushValue(result);
			result = 0.0;
		}	
	}
	
	public double getTop() {
		return stack.peek();
	}
	
	public void CheckValidity() {
		Double temp  = stack.pop();
		if(!stack.empty()) {
			throw new ArithmeticException("The postfix is invalid"); 
		}
		stack.push(temp);
	}
	
	public static void main(String[] arg) {
		StackCalculator calc = new StackCalculator(new LinkedStack<Double>());
		calc.UserInterface();
	}
}
