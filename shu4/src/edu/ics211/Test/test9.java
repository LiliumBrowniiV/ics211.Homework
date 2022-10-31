package edu.ics211.Test;

import java.util.*;

import edu.ics211.h09.Packet;
public class test9{
	final String[] array = new String[10];
	//tail of the queue
	int inSlot = 0;
	//head of the queue
	int outSlot = 0;
	public static void main(String[] arg) {
		test9 test = new test9();
		Iterator<String> itr = test.iterator();
		test.offer("0");
		test.offer("1");
		test.offer("2");
		test.offer("3");
		test.offer("4");
		test.offer("5");
		test.offer("6");
		test.offer("7");
		test.offer("8");
		test.offer("9");
		System.out.println(test.size());
		System.out.println(test.toString());
		
		
	

	}	
	
	public boolean offer(String str) {
		if (array[inSlot] != null) {
			return false;
		}
		array[inSlot] = str;
		inSlot++;
		inSlot %= 10;
		return true;
	
	}


	public String poll() {
		String drop = array[outSlot];
		if (drop == null) {
			return null;
		}
		array[outSlot] = null;
		outSlot++;
		outSlot %= 10;
		return drop;
	}


	public String peek() {
		return array[outSlot];
	}


	public Iterator<String> iterator() {
		return new Iterator<String>() {
		boolean started = false;
		int index = outSlot;
		@Override
		public boolean hasNext() {
			if(array[index] == null) {
				return false;
			}
			if(started && index == outSlot) {
				return false;
			}
			return true;
		}
		@Override
		public String next() {
			String p = array[index];
			if(!hasNext()) {
				throw new IllegalStateException();
			}
			started	= true;
			index++;
			index %= 10;
			return p;
			}
		
		};
	}


	public int size() {
		int size = 0;
		for(int index = 0; index < array.length; index++) {
			if(array[index] != null) {
				size++;
			}
		}
		return size;
	}
	public String toString() {
		return Arrays.toString(array);
	}
}
