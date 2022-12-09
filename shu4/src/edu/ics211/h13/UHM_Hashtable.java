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
			while(loadFactor() > maxLoadFactor) {
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
			if(ll != null) {
				largest = (largest < ll.size() ? ll.size() : largest);
			}
		}
		return largest;
	}
	
	
	/** Do Not Change - Used in grading */
	public int keysAtIndex(int index) { return table[index].size(); }
	
	/** Do Not Change - Used in grading */
	public int arrayLen() { return table.length; }
}


/** Unit test 
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
	
	public boolean test0 () {
		UHM_Hashtable<String, String> hash =new UHM_Hashtable<String, String>();
		if(hash.size() != 0) {return false;}
		hash.put("foo", "bar1");
		if(hash.size() != 1) {return false;}
		hash.put("foo", "bar2");
		if(hash.size() != 1) {return false;}
		if(!hash.get("foo").equals("bar2")) {return false;}
		return true;
		
	}
	public boolean test1 () {
		UHM_Hashtable<String, String> hash =new UHM_Hashtable<String, String>(20,0.75);
		if(hash.arrayLen() != 20) {return false;}
		
		if(hash.loadFactor() != 0) {return false;}
		hash.put("foo", "bar2");
		if(hash.arrayLen() != 20) {return false;}
		
		if(hash.loadFactor() != 0.05) {return false;}
		
		if(hash.maxListLen() != 1) {return false;}
		return true;
		
	}
	public boolean test2 () {
		UHM_Hashtable<String, String> hash =new UHM_Hashtable<String, String>(8,0.75);
		hash.put("aah", "val0");
		hash.put("aap", "val1");
		if(hash.maxListLen() != 2) {return false;}
		if(hash.size() != 2) {return false;}
		if(hash.loadFactor() != 0.25) {return false;}
		hash.clear();
		if(hash.size() != 0) {return false;}
		if(hash.loadFactor() != 0) {return false;}
		return true;
		
	}
	public boolean test3 () {
		UHM_Hashtable<String, String> hash =new UHM_Hashtable<String, String>(4,0.5);
		hash.put("aah", "val0");
		hash.put("aap", "val1");
		hash.put("aay", "val2");
		if(hash.arrayLen() <= 4) {return false;}
		try {
			hash.put(null, null);
			return false;
		}catch(NullPointerException npe){
			
		}
		return true;
	}
	public boolean test4 () {
		UHM_Hashtable<String, String> hash =new UHM_Hashtable<String, String>(4,0.5);
		hash.put("aah", "val0");
		hash.put("aap", "val1");
		hash.put("aay", "val2");
		if(! hash.replace("aay", "val3").equals("val2")) {return false;}
		if(!hash.get("aay").equals("val3")) {return false;}
		return true;
		
	}
	public boolean test5 () {
		UHM_Hashtable<String, String> hash =new UHM_Hashtable<String, String>(4,0.5);
		hash.put("aah", "val0");
		hash.put("aap", "val1");
		hash.put("aay", "val2");
		if(hash.get("aay") == null) {return false;}
		hash.remove("aay");
		if(hash.get("aay") != null) {return false;}
		return true;
		
	}
	public boolean test6() {
		UHM_Hashtable<Integer, Integer> hash =new UHM_Hashtable<Integer, Integer>(100,0.5);
		for(int ii = 0; ii < 48; ++ii) {
			hash.put(ii, (int) Math.random());
		}
		
		if(hash.arrayLen() != 100) {return false;}
		if(hash.maxListLen() > 48) {return false;}
		if(hash.maxListLen() > 1) {return false;}
		return true;
		
	}
	public boolean test7 () {
		UHM_Hashtable<Integer, Integer> hash =new UHM_Hashtable<Integer, Integer>(100,100);
		for(int ii = 0; ii < 9999; ++ii) {
			hash.put(ii, (int)Math.random());
		}
		if(hash.maxListLen() < 95) {return false;};
		return true;
		
	}
	public boolean test8 () {
		UHM_Hashtable<String, String> hash =new UHM_Hashtable<String, String>(8,0.5);
		hash.put("aah", "val0");
		hash.put("aap", "val1");
		hash.put("aax", "val2");
		hash.put("aay", "val2");
		hash.put("aaz", "val2");
		if(hash.arrayLen() <= 8) { hash.sout("af"); return false;}
		if(hash.size() != 5) {hash.sout("sf"); return false;}
		if(hash.maxListLen() > 5 || hash.maxListLen() < 1) { hash.sout("mf");return false;}
		if(!hash.get("aax").equals(hash.get("aay"))) {return false;}
		return true;
	}
	public static void main(String[] args) {
		UHM_Hashtable<String, String> HT =new UHM_Hashtable<String, String>();
		System.out.println("test 0 " +  HT.test0());
		System.out.println("test 1 " +  HT.test1());
		System.out.println("test 2 " +  HT.test2());
		System.out.println("test 3 " +  HT.test3());
		System.out.println("test 4 " +  HT.test4());
		System.out.println("test 5 " +  HT.test5());
		System.out.println("test 6 " +  HT.test6());
		System.out.println("test 7 " +  HT.test7());
		System.out.println("test 8 " +  HT.test8());
	}
 */
 

