package edu.ics211.h05;


import java.util.Arrays;

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
			int randoff = (int) ((Math.random() * 16) - 5);
			String addstr = "";
			String Test = "";
			OffsetArrayList<Integer> TestIntArray = new OffsetArrayList<Integer>(10, randoff);
			if(TestIntArray.capacity() == 10) {
				CapacityTest = true;
			}
			if(TestIntArray.offset() == randoff) {
				OffsetTest = true;
			}
			TestIntArray.add(2);
			TestIntArray.add(2);
			TestIntArray.add(3);
			TestIntArray.add(4);
			TestIntArray.add(5);
			TestIntArray.add(6);
			TestIntArray.add(8);
			TestIntArray.add(9);
			TestIntArray.add(10);
			TestIntArray.set(randoff,1);
			TestIntArray.add((randoff + 6),7);
			for(int i  = 0; i < expected.length; i++) {
				if(i == expected.length - 1) {
					addstr += expected[i];
				} 
				else {
					addstr += expected[i] + ", ";
				}
			}
			if(TestIntArray.toString().equals(addstr)) {
				add1Test = true;
				add2Test = true;
				SetTest  = true;
			
			}
			else {
				System.out.println(addstr);
				System.out.println("didn't pass add or set");
			}
			
			if(TestIntArray.size() == 10) {
				SizeTest = true;
			}
			else {
				System.out.println("didn't pass size");
			}
			
			if(TestIntArray.get(randoff) == 1) {
				GetTest = true;
			}
			else {
				System.out.println("didn't pass ger");
			}
			TestIntArray.remove(randoff + 9);
			expected = Arrays.copyOf(expected, 9);
			
			for(int i  = 0; i < expected.length; i++) {
				if(i == expected.length - 1) {
					Test += expected[i];
				} 
				else {
					Test += expected[i] + ", ";
				}
			}
			
			if(TestIntArray.toString().equals(Test)){
				RemoveTest = true;
				ToStringTest = true;
			}
			else {
				System.out.println("didn't pass tostring");
			}
			
			if(SizeTest && CapacityTest && SetTest && GetTest &&
				OffsetTest && add1Test && add2Test && RemoveTest && ToStringTest) {
			UnitTest = true;	
			}
			else {
				System.out.println(SizeTest);
				System.out.println(CapacityTest);
				System.out.println(SetTest);
				System.out.println(GetTest);
				System.out.println(OffsetTest);
				System.out.println(add1Test);
				System.out.println(add2Test);
				System.out.println(RemoveTest);
				System.out.println(ToStringTest);
				System.out.println(TestIntArray.toString());
				System.out.println(Test);
			}
			System.out.println("Unit Test completed");
	}
	public static Integer[] expected = {1,2,3,4,5,6,7,8,9,10};

	public static void main(String args[]) {
		testIntArray(expected);
	}
	
}
