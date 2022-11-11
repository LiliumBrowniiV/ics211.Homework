package edu.ics211.h10;

import java.util.*;

public class HW10StringIterator {
	  private char [] array;
	  private int index;
	  public HW10StringIterator(String s) {
		  array = s.toCharArray();
		  index = 0;
	  }

	  public boolean hasNext() {
		  return index < array.length;
	  }

	  public char next() {
		 index++;
		 return array[index - 1];
	  }
	  public void backUp() {
		  if(index == 0 ) {
			  throw new NoSuchElementException("At begining");
		  }
		  --index;
	    // implementation of backUp -- throws exception if already at beginning
	  }

}