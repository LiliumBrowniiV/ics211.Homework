package edu.ics211.h09;

import java.util.*;

public class PacketQueue extends AbstractQueue<Packet> implements Queue<Packet> {
	protected final Packet[] array;
	
	//tail of the queue
	protected int inSlot = 0;
	//head of the queue
	protected int outSlot = 0;
	public PacketQueue(){
		this.array = new Packet[10];
	}
	
	@Override
	public boolean offer(Packet e) {
		if (array[inSlot] != null) {
			throw new IllegalStateException();
		}
		array[inSlot] = e;
		inSlot++;
		inSlot %= 10;
		return true;
	
	}

	@Override
	public Packet poll() {
		Packet drop = array[outSlot];
		if (drop == null) {
			throw new NoSuchElementException();
		}
		array[outSlot] = null;
		outSlot++;
		outSlot %= 10;
		return drop;
	}

	@Override
	public Packet peek() {
		return array[outSlot];
	}

	@Override
	public Iterator<Packet> iterator() {
		return new Iterator<Packet>() {
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
		public Packet next() {
			Packet p = array[index];
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

	@Override
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




/**
 * 
 * protected static final int DEFAULT_PACKET_QUEUE_SIZE = 32;
	protected final int queueSize;
	protected final Packet[] array;
	private int nextAccpeyIndex = 0;
	private int nextSendIndex = 0;
	
	public PacketQueue() {
		this(DEFAULT_PACKET_QUEUE_SIZE);
	}
	public PacketQueue (int size) {
	 if(size < 1) {
		 	throw new RuntimeException("");
	}
	 	queueSize = size;
		array = new Packet[size];
	}
	
	for(int i = 0; i < array.length; i++) {
			if(array[i] == null) {
				array[i] = e;
				size++;
				return true;
			}	
		} 
		return false;
	
	@Override
	public boolean offer(Packet e) {
		if(array[nextAccpeyIndex] == null) {
			array[nextAccpeyIndex] = e;
			nextAccpeyIndex++;
			if(nextAccpeyIndex >= array.length) {nextAccpeyIndex = 0;}
		}
		
		// TODO Auto-generated method stub
		///////
		return false;
	}

	@Override
	public Packet poll() {
		Packet chosen = array[nextAccpeyIndex];
		if (chosen == null) {return null; }
		array[nextSendIndex] = null;
		++nextSendIndex;
		if(nextSendIndex >= array.length) {nextSendIndex = 0;}
		return chosen;
	}

	@Override
	public Packet peek() {
		// TODO Auto-generated method stub
		return array[nextAccpeyIndex];
	}

	@Override
	public Iterator<Packet> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Packet>() {
			int index = nextSendIndex;

			@Override
			public boolean hasNext() {
				if (array[index] == null) {return false;}
				if(index +1 == nextSendIndex) {return false;}
				if(index +1 == array.length && nextSendIndex == 0) {return false;}
				// TODO Auto-generated method stub
				return true;
			}
			
			@Override
			public Packet next() {
				Packet chosen = array[index];
				if(chosen == null) {throw new IllegalStateException();}
				index++;
				if(index == array.length) {index = 0;}
				// TODO Auto-generated method stub
				return chosen;
			}
		};
	}

	@Override
	public int size() {
		int size = 0;
		for(int  index = 0; index < array.length; index++) {
			if(array[index] != null) {
				size++;
				}
		}
		return 0;
	}
	public String toString() {
		return null;
	}
 * 
 * 
 * 
 */
