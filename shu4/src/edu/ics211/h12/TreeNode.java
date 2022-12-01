package edu.ics211.h12;

/**
 * 
 * @author Benjamin Strauss
 * Feel free to add more constructors, helper methods, etc
 *
 * @param <K> key
 * @param <V> value
 */

public class TreeNode<K extends Comparable<K>, V> implements Comparable<TreeNode<K,V>> {
	public K key;
	public V value;
	public TreeNode<K,V> left;
	public TreeNode<K,V> right;
	
	public TreeNode() { }
	
	public TreeNode(K key, V value) { 
		this.key = key;
		this.value = value;
	}
	
	public int compareTo(TreeNode<K,V> node) {
		return key.compareTo(node.key);
	}
	
	public int compareTo(K key) {
		return this.key.compareTo(key);
	}
	
	public String toString() {
		return key + " :: " + value;
	}
}

