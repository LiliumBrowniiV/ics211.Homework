package edu.ics211.h05;


import java.util.Arrays;

import edu.ics211.h06.ReverseLinkedList;

public class UnitTest {
		@SuppressWarnings("unlikely-arg-type")
		private static void testIntArray(Integer[] expected) {
			boolean UnitTest = false;
			boolean SizeTest = false;
			boolean CapacityTest = false;
			boolean SetTest = false;
			boolean GetTest = false;
			boolean OffsetTest = false;
			boolean add1Test = false;
			boolean add2Test = false;
			boolean RemoveTest = false;
			boolean ToStringTest = false;
			String addstr = "";
			String Test = "";
			ReverseLinkedList<Integer> RLL = new <Integer> ReverseLinkedList();
			if(RLL.capacity() == 10) {
				CapacityTest = true;
			}
			RLL.add(2);
			RLL.add(2);
			RLL.add(3);
			RLL.add(4);
			RLL.add(5);
			RLL.add(6);
			RLL.add(8);
			RLL.add(9);
			RLL.add(10);
			RLL.set(0,1);
			RLL.add(6,7);
			for(int i  = 0; i < expected.length; i++) {
				if(i == expected.length - 1) {
					addstr += expected[i];
				} 
				else {
					addstr += expected[i] + ", ";
				}
			}
			if(RLL.toString().equals(addstr)) {
				add1Test = true;
				add2Test = true;
				SetTest  = true;
			
			}
			else {
				System.out.println(addstr);
				System.out.println("didn't pass add or set");
			}
			
			if(RLL.size() == 10) {
				SizeTest = true;
			}
			else {
				System.out.println("didn't pass size");
			}
			
			if(RLL.get(0) == 1) {
				GetTest = true;
			}
			else {
				System.out.println("didn't pass ger");
			}
			RLL.remove(9);
			expected = Arrays.copyOf(expected, 9);
			
			for(int i  = 0; i < expected.length; i++) {
				if(i == expected.length - 1) {
					Test += expected[i];
				} 
				else {
					Test += expected[i] + ", ";
				}
			}
			
			if(RLL.toString().equals(Test)){
				RemoveTest = true;
				ToStringTest = true;
			}
			else {
				System.out.println("didn't pass tostring");
			}
			
			if(SizeTest && CapacityTest && SetTest && GetTest &&
				add1Test && add2Test && RemoveTest && ToStringTest) {
			UnitTest = true;	
			}
			else {
				System.out.println(SizeTest);
				System.out.println(CapacityTest);
				System.out.println(SetTest);
				System.out.println(GetTest);
				System.out.println(add1Test);
				System.out.println(add2Test);
				System.out.println(RemoveTest);
				System.out.println(ToStringTest);
				System.out.println(RLL.toString());
				System.out.println(Test);
			}
			System.out.println("Unit Test completed");
	}
	public static Integer[] expected = {1,2,3,4,5,6,7,8,9,10};
/*
	public static void main(String args[]) {
		testIntArray(expected);
	}
*/	
}
