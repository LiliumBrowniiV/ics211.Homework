package edu.ics211.h07;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		ICS211LinkedList<Integer> LL = new ICS211LinkedList<Integer>();
		Iterator<Integer> iter = LL.LinkListIterator();	
		LL.add(0);
		LL.add(1);
		LL.add(2);
		LL.add(3);
		LL.add(4);
		LL.add(5);
		LL.add(6);
		LL.add(7);
		LL.add(8);
		LL.add(9);
		System.out.println(LL.toString());
		


		/*List remove Test
		for(int i = LL.size - 1; i >= 0; i--) {
			if(i == 0) {
				System.out.println(LL.toString());
				LL.remove(i);
				System.out.println(LL.toString());
				System.out.println("Size after remove " + LL.size);
			} else {
				System.out.println(LL.toString());
				LL.remove(i);
				System.out.println(LL.toString());
				System.out.println("Size after remove " + LL.size);
				System.out.println("head " + LL.getHeadItem());
				System.out.println("tail " + LL.getTailItem());
			}
		}
		
		//illegal indices 
		  LL.remove(10);
		//empty list 
		 ICS211LinkedList<Integer> LL0 = new ICS211LinkedList<Integer>();
		 LL0.remove(1);
		*/
	}

}
