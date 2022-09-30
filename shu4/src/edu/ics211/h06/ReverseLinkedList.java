package edu.ics211.h06;

public class ReverseLinkedList<E> {	
	private static class LinkedNode<E>{
		  private E item;
		  private LinkedNode<E> prev;
		  public LinkedNode(E item, LinkedNode <E> prev){
			  this.item = item;
			  this.prev = prev;
		  }
		} 
	private LinkedNode<E> tail = new LinkedNode<E>(null, null);
  //constructor
  public ReverseLinkedList(){
  }
  
  
  
  //returns # of elements, always >= 0
  public int size() {
	  int size = 0;
	  for(LinkedNode<E> pointer = tail; pointer != null; pointer = pointer.prev) {
		size++;  
	  }
	  return size;
  } 
  //returns the same as size()
  public int capacity(){
	  return size();
  } 
  //returns the object at the given position. 
  //Position 0 is at the front of the linked list.
  //A negative index counts from the end of the linked list, with -1 being the element at the tail.
  //Throws IndexOutOfBoundsException if the index is out of range, i.e. if index < -size() || index >= size().
  public E get(int index) {
	 int count = index;
	 LinkedNode<E> pointer;
	 E item = null;
	  if (index < -size() || index >= size()) {
		  throw new IndexOutOfBoundsException(index);
	  } else if (index >=	 0){
		  count = size() - index;
		 for(pointer = tail; count > 0; pointer = pointer.prev) {
				item = pointer.item;
				count--;
		 }
	  } else if (index < 0) {
		 for(pointer = tail; count < 0; pointer = pointer.prev) {
			 	count++;
				item = pointer.item;
		 }
	  }
	return item;
  }  
  
		  
  //returns the old value
  //Throws IndexOutOfBoundsException if the index is out of range, i.e. if index < -size() || index >= size().
  public E set(int index, E element) {
	LinkedNode pointer = getNode(index);
	E temp = (E) pointer.item;
	pointer.item = element;
	return temp;
  }
  
  // add at the end of the list, always returns true
  public boolean add(E element) {
	  if(size() == 0) {
		  tail = new LinkedNode<E>(null,null);
	 }
	 if(tail.item == null) {
		tail.item = element;
	} else {
		 LinkedNode <E> newTail = new LinkedNode<E>(element, tail);
		tail = newTail;
	}
	 return true;
  } 
  //add at position 
  //Throws IndexOutOfBoundsException if the index is out of range, i.e. if index < -size() || index >= size().
  public void add(int index, E element) {
	  if(index + 1 < -size() || index > size()) {
		  throw new IndexOutOfBoundsException(index);
	  } 
	  
	  if(size() == 0) {
		add(element);
		return;
	 } 
	  if(tail.item == null) {
			tail.item = element;
			return;
	  }
	  if(index == -size() - 1) {
		  LinkedNode <E> parentToBe = getNode(-size());
		  LinkedNode <E> newNode = new LinkedNode<E>(element, null);
		  parentToBe.prev = newNode;
		  return;
		  
	  } else if (index == size()){
		  add(element);
		  return;
	  }
	  LinkedNode <E> parentToBe = getNode(index);
	  LinkedNode <E> newNode = new LinkedNode<E>(element, parentToBe.prev);
	  parentToBe.prev = newNode;
  } 
  
  // removes object at position 
  //Throws IndexOutOfBoundsException if the index is out of range, i.e. if index < -size() || index >= size().
  public E remove(int index) {
	  LinkedNode <E> removeMe = getNode(index);
	  E temp;
	  temp = removeMe.item;
	  if(removeMe == tail) {
		  tail = removeMe.prev;
	  } else {
		  LinkedNode <E> parent = getNode(index + 1);
		  parent.prev = removeMe.prev;
	  }
	  return temp;
  }
  
  public String toString() {
	  String str = "";
	  for(LinkedNode<E> pointer = tail; pointer != null; pointer = pointer.prev) {
		  if(pointer == tail) {
			 str = pointer.item + str;
		  } else {
			  str = pointer.item + ", " + str;
		  }
		 
	  }
	  return str.trim();
  }
  
  private LinkedNode <E> getNode(int index){
	  if(index < -size() || index >= size()) {
		  throw new IndexOutOfBoundsException(index);
	  }
	  LinkedNode <E> pointer;
	  int nodeNo = 0;
	  if(index < 0) {
		  for(pointer = tail; nodeNo > index + 1; pointer = pointer.prev) {
			  //System.out.println("*" + pointer.item);
			  --nodeNo;
		  } 
	  } else {
		  int adjustedIndex = size() - index - 1;
		  for(pointer = tail; nodeNo < adjustedIndex; pointer = pointer.prev) {
			  ++nodeNo;
		  }
	  }
	  return pointer;
  }
}
