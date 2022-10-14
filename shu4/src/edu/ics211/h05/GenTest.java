package edu.ics211.h05;

import java.util.Arrays;

public class GenTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OffsetArrayList<Integer> TestIntArray = new OffsetArrayList<Integer>(10, 0);
		TestIntArray.add(1);
		TestIntArray.add(1);
		TestIntArray.add(1);
		TestIntArray.add(1);
		TestIntArray.add(1);
		TestIntArray.add(1);
		TestIntArray.add(1);
		TestIntArray.add(1);
		TestIntArray.add(1);
		TestIntArray.add(1);
		System.out.println(TestIntArray.capacity());
		TestIntArray.add(10,1);
		System.out.println(TestIntArray.toString());
		System.out.println(TestIntArray.capacity());
		
	}

}
