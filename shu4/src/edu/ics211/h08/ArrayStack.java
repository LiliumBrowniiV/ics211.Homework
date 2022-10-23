package edu.ics211.h08;

import java.util.EmptyStackException;

public class ArrayStack<E> implements StackInterface<E> {
    /* fields to store the stack elements and the location of the
     * top of the stack.
     * the values are in array locations 0..top if top >= 0
     * for an empty array, top is -1
     */
    private int top;
    private Object[] array;

    /* no-arguments default constructor creates an empty stack */
    @SuppressWarnings("unchecked")
    public ArrayStack() {
	top = -1;		// empty stack
	array = new Object[4];  // make room for at least 10 items
    }

    /* @return	whether the stack is empty */
    public boolean empty() {
    checkInvariant();
	return (top == -1);
    }
       
    /* @param	value to push onto the stack */
    public void push(E value) {
    checkInvariant();
	/* make sure there is room in the array */
    try {
    	array[top+1] = value;
    	top++;
    	/**
    	 * unnecessary code due to the instruction 
    	 * array = java.util.Arrays.copyOf(array, array.length * 2);
    	 */
    	
    } catch(java.lang.ArrayIndexOutOfBoundsException error) {
    		throw new FullStackException("no more spaces for stack");
    }
    checkInvariant();  
    }

    /* different implementation of pop, does exactly the same.
     * @return	the top value on the stack
     */
    @SuppressWarnings("unchecked")
	public E pop() throws EmptyStackException {
    checkInvariant();
	try {
	    return (E) array[top--];
	} catch(java.lang.ArrayIndexOutOfBoundsException error) {
	    top = -1;		// just to be sure
	    throw new EmptyStackException();
	}
    }

    /* @return	the top value on the stack */
    @SuppressWarnings("unchecked")
	public E peek() throws EmptyStackException {
    checkInvariant();
    try {
    return (E) array[top];
    }catch(java.lang.ArrayIndexOutOfBoundsException error) {
    	checkInvariant();
    	throw new EmptyStackException();
    	}
	}
    private void checkInvariant() {
    	if(array == null) {throw new AssertionError();};
    	if(top < -1 || top > 3) {throw new AssertionError();};
    }
    /* convert the stack to a printable string
     * @return	a string representing the stack
     */
    public String toString() {
	if (empty()) {
	    return "Empty Stack";
	} else {
	    return recursiveToString(0);
	}
    }

    /* recursive method to print a non-empty stack
     * @param	the starting index in the array
     * @return	a string representing the stack
     */
    private String recursiveToString(int startPos) {
	if (startPos > top) {
	    return "";
	}
	String separator = "";
	if (startPos > 0) {
	    separator = " :: ";
	}
	return separator + array[startPos] + recursiveToString(startPos + 1);
    }

    // simple test
    public static void main(String[] args) {
	StackInterface<String> s = new ArrayStack<String>();

	System.out.println("before pushing anything, " + s);
	s.push("hello");
	s.push("world");
	System.out.println("after pushing hello and world, " + s);
	System.out.println("pop returns " + s.pop());
	System.out.println("after popping, " + s);
	// push 100 values (unnecessary due to the instruction)
	/**
	 * StackInterface<Integer> si = new ArrayStack<Integer>();
	 * for (int i = 0; i < 100; i++) {
	    si.push(i);
	}
	 */
	
	// now pop them and make sure the same values are returned
	// in LIFO order (cannot implement due to instruction)
	/**
	 * test for more element is array stack
	 * for (int i = 99; i >= 0; i--) {
	    Integer returned = si.pop();
	    if (! returned.equals(i)) {
		System.out.println("error: pop returns " + returned +
				   ", expected " + i);
	    }
	}
	 */
	s.push("a");
	s.push("beautiful");
	s.push("day");
	System.out.println("after pushing 'a beautiful day', " + s);
	System.out.println("pop returns " + s.pop());
	System.out.println("pop returns " + s.pop());
	System.out.println("pop returns " + s.pop());
	System.out.println("pop returns " + s.pop());
	System.out.println("after popping, " + s);
	/* expected output:
	 * before pushing anything, Empty Stack
	 * after pushing hello and world, hello :: world
	 * pop returns world
	 * after popping, hello
	 * after pushing 'a beautiful day', hello :: a :: beautiful :: day
	 * pop returns day
	 * pop returns beautiful
	 * pop returns a
	 * pop returns hello
	 * after popping, Empty Stack
	 */

    }
}