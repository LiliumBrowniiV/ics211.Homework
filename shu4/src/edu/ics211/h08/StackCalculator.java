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
			System.out.println("Enter operands or operators1 to calculate; = to stop and get result ");
			input = sc.nextLine();
			if(input.equals("=")) {
				CheckFinalValidity();
				System.out.println("The final result is : " + getTop());
				break;
			} else if(!input.equals("+") && !input.equals("-") && !input.equals("*") && !input.equals("/")) {
				pushValue(Double.parseDouble(input));
			} else {
				try {
					applyOperation(input.charAt(0));
				} catch (EmptyStackException e) {
					System.out.println("Please make sure your postfix expression in valid");
					continue;
					}
				}
			}
		}

	public void pushValue(double value) {
		stack.push(value);
	}
	public void applyOperation(char operation) {
		CheckValidity();
		Double FirstPop = stack.pop();
		Double SecondPop = stack.pop();
		Double result = 0.0;
		if(Character.compare(operation, '+') == 0) {
			result = SecondPop + FirstPop;
			System.out.println("result : " + result);
			pushValue(result);
			result = 0.0;
		} else if(Character.compare(operation, '-') == 0) {
			result = SecondPop - FirstPop;
			System.out.println("result : " + result);
			pushValue(result);
			result = 0.0;
		}  else if(Character.compare(operation, '*') == 0) {
			result = SecondPop * FirstPop;
			System.out.println("result : " + result);
			pushValue(result);
			result = 0.0;
		}  else if(Character.compare(operation, '/') == 0) {
			result = SecondPop / FirstPop;
			System.out.println("result : " + result);
			pushValue(result);
			result = 0.0;
		}	
	}
	
	public double getTop() {
		return stack.peek();
	}
	
	public void CheckValidity() {
		if(stack.empty()) {
			throw new EmptyStackException();
		} 
		Double temp1 = stack.pop();
		if(stack.empty()) {
			stack.push(temp1);
			throw new EmptyStackException();
		} else {
			stack.push(temp1);
			}
		}
	public void CheckFinalValidity() {
		Double temp = stack.pop();
		if(!stack.empty()) {
			stack.push(temp);
			throw new ArithmeticException("The postfix is invalid"); 
		} else {
			stack.push(temp);
		}
	}
	
	public static void main(String[] arg) {
		StackCalculator calc = new StackCalculator(new LinkedStack<Double>());
		calc.UserInterface();
	}
}
