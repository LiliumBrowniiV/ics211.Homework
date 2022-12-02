package edu.ics211.h12;
import java.util.*;

public class BCT_Iterator<E> implements Iterator<E> {
	private Stack<Integer> visit;
	private Object[] arr;
	public BCT_Iterator(Object[] arr){
		visit = new Stack<Integer>();
		this.arr = arr;
		pushLeft(arr);
	}
	
	@Override
	public boolean hasNext() {
		return !visit.isEmpty();
	}

	@SuppressWarnings("unchecked")
	@Override
	public E next() {
		if(!hasNext()) {
			return null;
		}
		Integer current = visit.pop();
		int right = 2 * current + 2;
		try {
			if(arr[right] != null) {
				pushLeft(right);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			resize();
			if(arr[right] != null) {
				pushLeft(right);
			}
		}
		return (E) arr[current];
	}
	private void pushLeft(Object[] arr) {
		for(int i = 0; i < arr.length; i += 0) {
			if(arr[i] != null) {
			visit.push(i);
			}
			i = 2 * i + 1;
		}
	}
	
	private void pushLeft(int index) {
		for(int i = index; i < arr.length; i += 0) {
			if(arr[i] != null) {
			visit.push(i);
			}
			i = 2 * i + 1;
		}
	}
	private final void resize() {
		Object[] temp = arr;
		arr = new Object[arr.length*2+1];
		System.arraycopy(temp, 0, arr, 0, temp.length);
	}
}

