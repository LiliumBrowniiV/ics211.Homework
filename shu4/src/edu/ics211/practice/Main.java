package edu.ics211.practice;
import java.util.Stack;
public class Main {

	public static void main(String[] args) {
		Stack <Integer> pracstack = new Stack <Integer>();
		Stack <Integer> pracstack2 = new Stack <Integer>();
		Stack <Integer> pracstack3 = new Stack <Integer>();
		pracstack.push(-1);
		pracstack.push(15);
		pracstack.push(23);
		pracstack.push(44);
		pracstack.push(4);
		pracstack.push(99);
		/*
		System.out.println(pracstack.toString());
		pracstack.pop();
		System.out.println(pracstack.toString());
		 */
		
		while(pracstack.peek() != null) {
			Integer temp = pracstack.pop();
		 pracstack3.push(temp);
		}
		System.out.println(pracstack.toString());
		//System.out.println(pracstack3.toString());
	}

}
