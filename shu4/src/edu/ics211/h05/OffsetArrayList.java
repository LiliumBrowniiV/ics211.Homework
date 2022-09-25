package edu.ics211.h05;
import java.util.*;
public class OffsetArrayList <E>{
	private final int off;
	private int size = 0;
	private Object[] arr;
	//debug code 
	//[1,2,3,4,5]
	//offset of 1
	//[offset,1,2,3,4,5]
// constructor The offset may be zero, positive, or negative. The initial capacity must be zero or positive.
//If the initial capacity is negative, this constructor must throw NegativeArraySizeException.
 OffsetArrayList(int initalCapacity, int offset) throws NegativeArraySizeException{
	 if (initalCapacity < 0) {
		 throw new NegativeArraySizeException("The intial capcacity cannot be less than zero");
	 }
	 this.off = offset;
	 arr = new Object[initalCapacity];
 }
//returns # of elements
 public int size() {
	 return size;
 } 	
 
//returns the size of underlying array
 public int capacity() {
	 return arr.length;
 }
 // returns offset of first element
 public int offset() {
	 return off;
 }
 // returns the object at the given position
 //Throws IndexOutOfBoundsException if the index is out of range, i.e. if index < offset || index >= offset+size().
@SuppressWarnings("unchecked")
public E get(int index) throws IndexOutOfBoundsException{
	if(index < off || index >= off + size()){
		throw new IndexOutOfBoundsException();
	}
	return (E) arr[index - off];

}
//returns the old value
//Throws IndexOutOfBoundsException if the index is out of range, i.e. if index < offset || index >= offset+size().
@SuppressWarnings("unchecked")
public E set(int index, E element) throws IndexOutOfBoundsException {
	if(index < off || index >= off + size()) {
		throw new IndexOutOfBoundsException();
	}
	E temp = (E) arr[index - off];
	arr[index - off] = element;
	return temp;	
}
//add at the end of list, always returns true
public boolean add(E element) {
	if(size == arr.length) {
		arr  = Arrays.copyOf(arr, (arr.length * 2) + 1);	
	}
	arr[size] = element;
	size++;
	return true;
}
//add at position
//Throws IndexOutOfBoundsException if the index is out of range, i.e. if index < offset  || index >= offset+size() + 1.
public void add(int index, E element) {
	if(index < off || index >= off + size() + 1) {
		throw new IndexOutOfBoundsException();
	}
	if(size == arr.length) {
		arr  = Arrays.copyOf(arr, (arr.length * 2) + 1);	
	}
	for(int i = arr.length - 1; i > index - off; i--) {
		arr[i] = arr[i - 1];
	}
	arr[index - off] = element;
	size++;
} 
//removes object at position
//Throws IndexOutOfBoundsException if the index is out of range, i.e. if index < offset || index >= offset+size().
@SuppressWarnings("unchecked")
public E remove(int index) {
	if(index < off || index >= off + size()) {
		throw new IndexOutOfBoundsException();
	}
	for(int i = index - off; i < size - 1; i++) {
		arr[i] = arr[i + 1];
	}
	size--;
	arr = Arrays.copyOf(arr, arr.length);
	return (E) arr[index - off];
}
//concatenate all the elements' toString() with "," as a separator
 public String toString() {
	 Object[] temp = new Object[size];
	 System.arraycopy(arr, 0, temp, 0,size);
	 String str  = Arrays.toString(temp);
	 return str.substring(1, str.length() - 1).trim();
 } 	
}
