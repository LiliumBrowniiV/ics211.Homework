package edu.ics211.h07;

import java.util.*;

public class Main {
	public static void main(String[] arg) {
	
	}
	/**
	 * 
	 * @return
	 * private static boolean test8() {
		ICS211LinkedList<String> ll = new ICS211LinkedList<String>();
		for(String str: VALUES) {
			ll.add(str);
		}
		
		Iterator<String> iter = ll.iterator();
		while(iter.hasNext()) {
			String str = iter.next();
			
			for(int index = 0; index < VALUES.length; ++index) {
				if(index % 2 == 0 && str.equals(VALUES[index])) {
					iter.remove();
				}
			}
		}
		
		if(ll.size() != 5) { return false; }
		if(!ll.toString().equals("one ==> three ==> five ==> seven ==> nine")) { return false; }
		
		return true;
	}
	 */
}
