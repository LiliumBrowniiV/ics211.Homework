package edu.ics211.h06;

public class UnitTest { 
 public static void main(String args[]) {
	 ReverseLinkedList<Integer> RLL = new <Integer> ReverseLinkedList();
	 String str = "1, 2, 3, 4, 5, 6, 7, 8, 9, 10";
	 String setstr = "2, 2, 2, 2, 2, 2, 2, 2, 2, 2";
	 String setstr2 = "3, 3, 3, 3, 3, 3, 3, 3, 3, 3";
	 String getstr = "";
	 // add and toString test
	 boolean addTest = false;
	 boolean SizeCapacityTest = false;
	 boolean getTest = false;
	 boolean setTest = false;
	 boolean removeTest = false;
	 RLL.add(0,1);
	 RLL.add(2);
	 RLL.add(3);
	 RLL.add(4);
	 RLL.add(5);
	 RLL.add(6);
	 RLL.add(7);
	 RLL.add(8);
	 RLL.add(9);
	 RLL.add(10);
	 //size and capacity test
	 if(RLL.capacity() == RLL.size() && RLL.size() == RLL.capacity()) {
		 SizeCapacityTest = true;
	 }
	 //add tests 
	 if(RLL.toString().equals(str)) {
		 addTest = true;
	 }else {
		 System.out.println("add Test failed");
	 }
	 
	 //get Test
	 for(int i = 0; i < RLL.size(); i++) {
		 if(i == RLL.size() - 1 ) {
			 getstr += RLL.get(i);
		 } else {
			 getstr += RLL.get(i) + ", ";
		 }
	 }
	 if(getstr.equals(str)) {
		 getstr = "";
		 for(int i = -1; i >= -RLL.size(); i--) {
			 if(i == -1) {
				 getstr = RLL.get(i) +  getstr;
			 } else {
				 getstr = RLL.get(i) + ", " + getstr;
			 }
		 }
		 if(getstr.equals(str)) {
			 getTest = true;
		 } else {
			 System.out.println("get Test failed (negative index)");
			 System.out.println(getstr + "\n" + str);
		 }
	 }else {
		 System.out.println("get Test failed");
		 System.out.println(getstr + "\n" + str);
	 }
	 
	 //Set Test 
	 for(int i = 0; i < RLL.size(); i++) {
		 RLL.set(i, 3);
	 }
	 
	 if(RLL.toString().equals(setstr2)) {
		 for(int i = -1; i >= -RLL.size(); i--) {
				RLL.set(i, 2);
			 }
		 if(RLL.toString().equals(setstr)) {
			 setTest = true;
		 } else {
			 System.out.println("set Test failed (negative index)");
			 System.out.println(RLL.toString() + "\n" + setstr);
		 }
	 } else {
		 System.out.println("set Test failed");
		 System.out.println(RLL.toString() + "\n" + setstr2);
	 }
	//remove test
	 for(int i = 0; i < RLL.size(); i *= 0) {
		 RLL.remove(i);
		 if(RLL.size() == 0) {
			 break;
		 }
	 }
	 if(RLL.toString().equals("")) {
		 RLL.add(1);
		 RLL.add(2);
		 RLL.add(3);
		 RLL.add(4);
		 RLL.add(5);
		 RLL.add(6);
		 RLL.add(7);
		 RLL.add(8);
		 RLL.add(9);
		 RLL.add(10);
		 for(int i = -1; i >= -RLL.size(); i *= 1) {
			 RLL.remove(i);
			 if(RLL.size() == 0) {
				 break;
			 } 
		 }
		 if(RLL.toString().equals("")) {
			 removeTest = true;
			 
		 } else {
			 System.out.println("Remove Test failed");
			 System.out.println(RLL.size());
		 }
		 
	} else {
		 System.out.println("Remove Test failed");
		 System.out.println(RLL.size());
	} 
	
	 
	 
	 if(addTest && SizeCapacityTest&&getTest&&setTest&&removeTest) {
		 System.out.print("UnitTest compeleted");
	 } else {
		 System.out.print("UnitTest failed");
	 }
 }
}




