package edu.ics211.ec;

/**
 * Extra Credit: Implement a Min-Heap
 * Use "https://en.wikipedia.org/wiki/Heap_(data_structure)" for help
 * Submissions will be accepted as long as I can input grades into Laulima
 * You may not extend or use any classes (Interfaces/Enums are OK) in java.util as class variables aside from:
 * 		{ ArrayList, LinkedList, BitSet, Iterator }
 * 
 * Heap has no generics, assume everything that is put in the heap implements the interface 'Quantizable'
 * You can declare any internal variables you like.
 * 
 * @author Benjamin Strauss
 *
 */

public class Heap {
	
	public Heap() { 
		//TODO add any required initialization to the heap
	}
	
	public void insert(Quantizable q) {
		//TODO: insert an object into the queue
	}
	
	public Quantizable find_min() {
		//TODO: find and return minimum element
		return null;
	}
	
	public Quantizable extract_min() {
		//TODO: find, return, and remove minimum element
		//HINT:	this method combines two other methods...
		return null;
	}
	
	public Quantizable delete_min() {
		//TODO: remove minimum element
		return null;
	}
	
	public int size() {
		//TODO
		return 0;
	}
	
	public static Heap heapify(Quantizable... q) {
		//TODO: adds an array of Quantizable into a heap
		return null;
	}
}
