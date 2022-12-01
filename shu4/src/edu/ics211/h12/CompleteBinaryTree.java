package edu.ics211.h12;

import java.util.*;

/**
 * Implement the following eight (0x8) methods
 * You may add methods and/or variables
 * Resize method already provided
 * CompleteBinaryTree is NOT ordered!
 * 
 * @Due Thursday December 1, 2022 at 2:00 am
 * Email Benjynstrauss@gmail.com or bnstraus@hawaii.edu if you have questions
 * Test all code thoroughly!
 * 
 * @author your name here
 *
 */

public class CompleteBinaryTree<E> implements Iterable<E> {
	
	private Object[] nodes;
	
	public CompleteBinaryTree() { 
		nodes = new Object[31];
	}
	
	
	public void add(E element) {
		int inc = capacity();
		if(inc == nodes.length) {
			resize();
		}
		nodes[inc] = element;
	}
	
	public boolean contains(E element) {
		for(int i = 0; i < capacity(); i++) {
			if(nodes[i].equals(element)) {
				return true;
			}
		}
		return false;
		
	}
	
	@SuppressWarnings("unchecked")
	public E get(E element) {
		for(int i = 0; i < capacity(); i++) {
			if(nodes[i].equals(element)) {
				return (E) nodes[i];
			}
		}
		return null;
		
	}
	
	public void remove(E element) {
		int index = 0;
		int capa = capacity();
		for(int i = 0; i < capa - 1; i++) {
			if(contains(element)) {
				index = i;
				nodes[i] = null;
				break;
			}
		}
		
		for(int j = index + 1; j <= capa - 1; j++) {
			nodes[j - 1] = nodes[j];
		}
		nodes[capa - 1] = null;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		int capa = capacity();
		for(int i = 0; i <= capa - 1; i++) {
			remove((E) nodes[i]);
		}
	}
	
	public int capacity() {
		int count = 0;
		for(int i = 0; i < nodes.length; i++) {
			if(nodes[i] != null) {
				count++;
			} 
		}
		return count;
	}
	
	@Override
	public Iterator<E> iterator() {
		// TODO create an iterator that can iterate through the tree in in-order traversal
		// (NOT the order of the ArrayList)
		return new BCT_Iterator<E>(nodes);
	}
	
	public String indented() {
		try {
			return indented(1,0);
		} catch(ArrayIndexOutOfBoundsException e) {
			resize();
			return indented(1,0);
		}
	}
	
	private String indented(int depth, int index){
		StringBuilder indent = new StringBuilder();
		for(int i = 1; i < depth; i++) {
			indent.append("\t");
		}
		if(nodes[index] == null) {
			return indent.append("-\n").toString();
		}
		int left =  2 * index + 1;
		int right = 2 * index + 2;
		if(nodes[left] == null && nodes[right] == null) {
			return indent.append(nodes[index]).toString() + "\n";
		} else {
			return indent.append(nodes[index]).toString() + "\n" + indented(depth + 1, left) + indented(depth + 1, right);
		}	
	}	
	/**Do not modify, for grading purposes*/
	@SuppressWarnings("unchecked")
	public final E accessInternal(int index) {
		return (E) nodes[index];
	}
	
	private final void resize() {
		Object[] temp = nodes;
		nodes = new Object[nodes.length*2+1];
		System.arraycopy(temp, 0, nodes, 0, temp.length);
	}
	
	public String toString() {
		try {
			return toString(0);
		} catch(ArrayIndexOutOfBoundsException e) {
			resize();
			return toString(0);
		}
	}
	private String toString(int index) {
		 if(nodes[index] == null) {
			 return "- ";
		 }
		 int left =  2 * index + 1;
		 int right = 2 * index + 2;
		 if(nodes[left] == null && nodes[right] == null) {
			 return (nodes[index]).toString();
		 }
		 return toString(left) + ", " + nodes[index].toString()+", " + toString(right);
	}

 
	
}
/** Unit Test
 *	public static void main(String[] args) {
		CompleteBinaryTree<String> CBT = new CompleteBinaryTree<String>();
		CBT.add("rahjmy");
		CBT.add("uwwkrx");
		CBT.add("nfmqge");
		CBT.add("ebeoap");
		CBT.add("ezsdzs");
		CBT.add("pmqcxj");
		System.out.print(CBT.get("rahjmy"));
		}
 */
