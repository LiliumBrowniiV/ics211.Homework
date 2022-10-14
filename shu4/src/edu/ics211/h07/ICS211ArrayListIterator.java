package edu.ics211.h07;

import java.util.*;

public class ICS211ArrayListIterator<E> implements Iterator<E>{
	 private final Object[] data;
	 private int location = 0;
	 public  ICS211ArrayListIterator(ArrayList<E> data){
		 this.data = data.toArray();
	 }
	@Override
	public boolean hasNext() {
		
		return location < data.length;
	}
	@Override
	@SuppressWarnings("unchecked")
	public E next() {
		if(data.length == location) {
			throw new NoSuchElementException();
			}
		location++;
		return (E) data[location - 1];
	}
}
