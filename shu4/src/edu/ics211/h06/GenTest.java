package edu.ics211.h06;
import java.util.*;
public class GenTest {

	public static void main(String[] args) {
		 ReverseLinkedList<Integer> RLL = new <Integer> ReverseLinkedList();
		 ReverseLinkedList<Integer> rll = new <Integer> ReverseLinkedList();
		 LinkedList<Integer> ll = new LinkedList<Integer>();		 
		 RLL.add(0,0);
		 RLL.add(1,1);
		 RLL.add(2,2);
		 RLL.add(3,3);
		 RLL.add(4,4);
		 RLL.add(5,5);
		 RLL.add(6,6);
		 RLL.add(7,7);
		 RLL.add(8,8);
		 RLL.add(9,9);
		 RLL.add(10,10);	
		 
		 rll.add(0);
		 rll.add(1);
		 rll.add(2);
		 rll.add(3);
		 rll.add(4);
		 rll.add(5);
		 rll.add(6);
		 rll.add(7);
		 rll.add(8);
		 rll.add(9);
		 rll.add(10);
		 System.out.println(RLL.toString());
		 System.out.println(rll.toString());
	}

}
