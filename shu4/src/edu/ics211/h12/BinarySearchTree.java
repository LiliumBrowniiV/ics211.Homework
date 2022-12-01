package edu.ics211.h12;

import java.util.*;



/**
 * Implement the following nine (0x9) methods
 * You may add methods and/or variables, however arrays and lists are prohibited as class variables
 * @Due Thursday December 1, 2022 at 2:00 am
 * Email Benjynstrauss@gmail.com or bnstraus@hawaii.edu if you have questions
 * Test all code thoroughly!
 * 
 * @author your name here
 *
 */

public class BinarySearchTree<K extends Comparable<K>, V> implements Iterable<TreeNode<K,V>> {
	
	protected TreeNode<K,V> root;
	protected int size = 0;
	
	public BinarySearchTree(){
		 root = null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() { 
		return size() == 0; 	
	}

	public V get(K key) {
		return get(key, root);
	}
	
	private V get(K key, TreeNode<K, V> node) {
		
		 if(key.compareTo(node.key) == 0) {
			 return node.value;
			 
		 } else if(key.compareTo(node.key) > 0) {
			 return (V) get(key, node.right);
			 
		 } else if (key.compareTo(node.key) < 0) {
			 return (V) get(key, node.left);
		 }
		 return null;
		 
	}
	
	public boolean contains(V value) {
		Objects.requireNonNull(value);
		Iterator<TreeNode<K, V>> iter = iterator();
		while(iter.hasNext()) {
			if(iter.next().value.equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean add(K key, V value) {
		Objects.requireNonNull(key);
		Objects.requireNonNull(value);
		
		try {
			root = add(key, value, root);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	private TreeNode<K, V> add(K key, V value, TreeNode<K,V> node) {
		if(node == null) {
			return new TreeNode<K,V>(key, value);
		}
		if(key.compareTo(node.key) > 0) {
			node.right = add(key, value, node.right);
		} else if (key.compareTo(node.key) == 0) {
			node = new TreeNode<K,V>(key, value);
		}	else {
			node.left = add(key, value, node.left);
		}
		 return node;
	}
	
	public void remove(K key) {
		root = remove(key, root);
	}
	
	private TreeNode<K,V> remove(K key, TreeNode<K,V> node){
		 if(node == null) {
			 return null;
		 }
		 if(key.compareTo(node.key) == 0) {
			 if(node.left == null) {
				 return node.right;
			 } else if (node.right == null) {
				 return node.left;
			 } else {
				 V replacementV = (V) getRightmostV(node.left);
				 K replacementK = (K) getRightmostK(node.left); 
				 TreeNode<K,V> newNode = new TreeNode<K,V>(replacementK, replacementV);
				 newNode.right = node.right;
				 newNode.left = remove(replacementK, node.left);
				 return newNode;
			 }
		 } else {
			 if(key.compareTo(node.key) < 0) {
				 node.left = remove(key, node.left);
			 } else {
				 node.right = remove(key, node.right);
			 }
		 }
		 return node;
	 }
	 
	 protected V getRightmostV(TreeNode<K,V> node) {
		 assert(node != null);
		 TreeNode<K,V> right = node.right;
		 if(right == null) {
			 return node.value;
		 } else {
			 return getRightmostV(right);
		 }
	 }
	 protected K getRightmostK(TreeNode<K,V> node) {
		 assert(node != null);
		 TreeNode<K,V> right = node.right;
		 if(right == null) {
			 return node.key;
		 } else {
			 return getRightmostK(right);
		 }
	 }
	
	public void clear() {
		size = 0;
		root = null;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Iterator<TreeNode<K, V>> iterator() {
		return new BST_Iterator(root);
		
	}
	 public String indented() {
		 return indented(root, 1);
	 }
	
	private String indented(TreeNode<K,V> node, int level) {
		 String indent = "";
		 
		 for(int i = 1; i < level; i++) {
			indent += "\t";
		 }
		 if(node == null) {
			 return indent + "-\n";
		 }
		 if(node.left == null && node.right == null) {
			 return indent + node.key.toString() + " : " + node.value.toString() + "\n";
		 } 
		return indent + node.key.toString() + " : " + node.value.toString() + "\n" +
		indented(node.left, level + 1) + indented(node.right, level + 1);
	}
		
	 public String toString() {
		 return toString(root);
	 }
	 private String toString(TreeNode<K,V> node) {
		 if(node == null) {
			 return "-";
		 }
		 if(node.left == null && node.right == null) {
			 return node.key.toString() + " : " + node.value.toString();
		 }
		 return toString(node.left) + ", " 
				 + node.key.toString() + " : " + node.value.toString() + ", "
				  + toString(node.right);
	 }
	 
	 public static void main(String[] args) {
			BinarySearchTree<Integer, String> BST = new BinarySearchTree<Integer, String>();
			BST.add(864,"rahjmy");
			BST.add(834,"uwwkrx");
			BST.add(175,"nfmqge");
			BST.add(956,"ebeoap");
			BST.add(962,"ezsdzs");
			BST.add(154,"pmqcxj");
			
			System.out.println(BST.get(864));
			Iterator<TreeNode<Integer, String>> iter = BST.iterator();
			
			while(iter.hasNext()){
				System.out.println(iter.next());
			}
	 }
}
/**
 * unit test 
 */
 
