package edu.ics211.h13;

import java.util.LinkedList;

/**
 * Implement a Hashtable (using separate chaining) from this skeleton.
 * You will need to determine what hash function to use, you can look at
 * "https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#hashCode()" for a way to get an index
 * from any object in java.
 *
 * Email Benjynstrauss@gmail.com or bnstraus@hawaii.edu if you have questions
 * 
 * @author Your name here
 *
 * @param <K> Key of the hash table
 * @param <V> Values of the hash table
 */

public class UHM_Hashtable<K,V> {
	//Feel free to edit this, however, your hash table must be an array of lists
	protected LinkedList<Pair<K,V>>[] table;
	protected double maxLoadFactor;
	public UHM_Hashtable() {
		//TODO constructor stub
		this(11, 0.75);
	}
	
	/**
	 * 
	 * @param initialCapacity: initial size of array
	 */
	public UHM_Hashtable(int initialCapacity) {
		this(initialCapacity, 0.75);
	}
	
	/**
	 * 
	 * @param loadFactorOnResize when the load factor exceeds this, resize
	 */
	public UHM_Hashtable(double loadFactorOnResize) {
		this(11, loadFactorOnResize);
	}
	
	/**
	 * 
	 * @param initialCapacity: initial size of array	
	 * @param loadFactorOnResize when the load factor exceeds this, resize
	 */
	@SuppressWarnings("unchecked")
	public UHM_Hashtable(int initialCapacity, double loadFactorOnResize) {
		table = (LinkedList<Pair<K,V>>[]) new LinkedList[initialCapacity];
		maxLoadFactor = loadFactorOnResize;
	}
	
	public void put(K key, V value) {
			int hash = key.hashCode();
			hash %= table.length;
			if(table[hash] == null) {
				table[hash] = new LinkedList<Pair<K,V>>();
			}
			for(Pair<K,V> pair: table[hash]) {
				if(pair.x.equals(key)) {
					pair.y = value;
					return;
				}
			}
			table[hash].add(new Pair<K,V>(key, value));
			if(loadFactor() > maxLoadFactor) {
				rehash(table.length * 3 + 1);
			}
		} 	
	
	public V get(K key) {
		int hash = key.hashCode();
		hash %= table.length;
		for(Pair<K,V> pair: table[hash]) {
			if(pair.x.equals(key)) {
				return pair.y;
			}
		}
		return null;
	}
	
	public V replace(K key, V value) {
		int hash = key.hashCode();
		hash %= table.length;
		if(table[hash] == null) {
			table[hash] = new LinkedList<Pair<K,V>>();
		}
		for(Pair<K,V> pair: table[hash]) {
			if(pair.x.equals(key)) {
				V temp = pair.y;
				pair.y = value;
				return temp;
			} 
		}
		return null;
	}
	
	public V remove(K key) {
		int hash = key.hashCode();
		hash %= table.length;
		if(table[hash] == null) {
			return null;
		}
		for(Pair<K,V> pair: table[hash]) {
			if(pair.x.equals(key)) {
				V temp = pair.y;
				table[hash].remove(pair);
				return temp;
			} 
		}
		return null;
	}
	
	public int size() {
		int totalSize = 0;
		for(LinkedList<?> ll : table) {
			if(ll != null) {
			totalSize += ll.size();
			}
		}
		return totalSize;
	}
	
	public void clear() {
		for(LinkedList<?> ll : table) {
			if(ll != null) {
				ll.clear();
			}
		}
	}
	
	public double loadFactor() {
		return (double) size() / table.length;
	}
	
	@SuppressWarnings("unchecked")
	public void rehash(int size) {
		LinkedList<Pair<K,V>>[] oldTable = table;
		table = (LinkedList<Pair<K,V>>[]) new LinkedList[size];
		for(int i = 0; i < oldTable.length; i++) {
			if(oldTable[i] != null) {
				for(Pair<K,V> pair : oldTable[i]) {
					if(pair != null) {
						put(pair.x, pair.y);
					}
				}
			}
		}
	}
	
	public int maxListLen() {
		int largest = 0;
		for(LinkedList<?> ll : table) {
			largest = (largest < ll.size() ? ll.size() : largest);
		}
		return largest;
	}
	
	/** Do Not Change - Used in grading */
	public int keysAtIndex(int index) { return table[index].size(); }
	
	/** Do Not Change - Used in grading */
	public int arrayLen() { return table.length; }
}

/**
 * Unit Test
 * public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < table.length; i++) {
			if(table[i] != null) {
				str.append(table[i] + "\n");
			} 
			else {
				str.append("null\n");
			}
		}
		return str.toString();
	}
	public void sout(Object s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		UHM_Hashtable<Integer, String> HT = new UHM_Hashtable<Integer, String>();
		HT.put(0, "Hello");
		HT.put(11, "World");
		HT.put(1, "a");
		HT.put(12, "b");
		HT.put(2, "c");
		HT.put(13, "d");
		HT.put(3, "e");
		HT.put(14, "f");
		HT.sout(HT);
		HT.sout(HT.get(14));
		HT.sout(HT.size());
	}
 */
