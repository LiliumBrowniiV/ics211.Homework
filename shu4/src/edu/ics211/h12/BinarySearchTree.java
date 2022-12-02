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

public class BinarySearchTree<K extends Comparable<K>, V> implements Iterable<V> {
	
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
		TreeNode<K,V> node = root;
		while(node != null) {
			if(key.compareTo(node.key) == 0) {
				return node.value;
			}
			if(key.compareTo(node.key) < 0) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		return null;
	}
	public boolean contains(V value) {
		Objects.requireNonNull(value);
		Iterator<V> iter = iterator();
		while(iter.hasNext()) {
			if(iter.next().equals(value)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean add(K key, V value) {
		Objects.requireNonNull(key);
		Objects.requireNonNull(value);
		
		try {
			size++;
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
		if(root != null) {
			size--;
		}
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
	public Iterator<V> iterator() {
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
			 return indent + "\n";
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
			 return "";
		 }
		 if(node.left == null && node.right == null) {
			 return node.value.toString();
		 }
		 return toString(node.left) + "," + node.value.toString() + "," + toString(node.right);
	 }
}
/**
 * Testcode
 * 	public static boolean test0() {
		 BinarySearchTree<Integer, String> BST = new BinarySearchTree<Integer, String>();
		 	BST.add(0, "zero");
			BST.add(-1, "neg-one");
			BST.add(1, "one");
			BST.add(2, "two");
			BST.add(-2, "neg-two");
			if((BST.size() != 5)) {
				System.out.println(BST.size() + "size error");
				return false;
			}
			if(!BST.contains("one")) {
				System.out.println("contain 1 error");
				return false;
			}
			if(!BST.contains("two")) {
				System.out.println("cotaint 2 error");
				return false;
			}
			return BST.contains("zero");
	 }
	 public static boolean test1() {
		 BinarySearchTree<Integer, String> BST = new BinarySearchTree<Integer, String>();
			BST.add(0, "zero");
			BST.add(-5, "neg-five");
			BST.add(5, "five");
			BST.add(2, "two");
			BST.add(-2, "neg-two");
			BST.add(7, "seven");
			BST.add(-7, "neg-seven");
			if(BST.size() != 7) {
				System.out.println("size 7 error");
				return false;
			}
			if(!BST.get(7).equals("seven")) {
				System.out.println("get 7 error");
				return false;
			}
			if(!BST.get(-5).equals("neg-five")) {
				System.out.println("get -5 error");
				return false;
			}
			if(!BST.contains("two")) {
				System.out.println("containt 2 error");
				return false;
			}
			return true;
	 }
	 public static boolean test2() {
		 BinarySearchTree<Integer, String> BST = new BinarySearchTree<Integer, String>();
			BST.add(0, "zero");
			BST.add(-5, "neg-five");
			BST.add(5, "five");
			BST.add(2, "two");
			BST.add(-2, "neg-two");
			BST.add(7, "seven");
			BST.add(-7, "neg-seven");
			if(BST.size() != 7) {
				System.out.println("size 7 error");
				return false;
			}
			//System.out.println(BST);
			BST.remove(0);
			//System.out.println(BST);
			if(BST.size() != 6) {
				System.out.println("size 6 error");
				return false;
			}
			if(BST.get(0) != null) {
				System.out.println("get 0 error");
				return false;
			}
			return true;
	 }
	 public static boolean test3() {
		 BinarySearchTree<Integer, String> BST = new BinarySearchTree<Integer, String>();
			BST.add(0, "zero");
			BST.add(-5, "neg-five");
			BST.add(5, "five");
			BST.add(2, "two");
			BST.add(-2, "neg-two");
			BST.add(7, "seven");
			BST.add(-7, "neg-seven");
			BST.clear();
			return (BST.size() == 0);
	 }
	 public static boolean test4() throws Exception {
		 BinarySearchTree<Integer, String> BST = new BinarySearchTree<Integer, String>();
		 	BST.add(0, "zero");
			BST.add(-5, "neg-five");
			BST.add(5, "five");
			BST.add(2, "two");
			BST.add(-2, "neg-two");
			BST.add(7, "seven");
			BST.add(-7, "neg-seven");
			String[] strs = {"neg-seven", "neg-five", "neg-two", "zero", "two", "five", "seven"};
			int index = 0;
			for(String str : BST) {
				if(! str.equals(strs[index])) {
					return false;
				}
				index++;
			}
			return true;
	 }
	 
	 public static boolean test5() throws Exception {
		 BinarySearchTree<Integer, String> BST = new BinarySearchTree<Integer, String>();
		 	BST.add(0, "zero");
			BST.add(-5, "neg-five");
			BST.add(5, "five");
			BST.add(2, "two");
			BST.add(-2, "neg-two");
			BST.add(7, "seven");
			BST.add(-7, "neg-seven");
			//System.out.println(BST.toString());
			return BST.toString().equals("neg-seven,neg-five,neg-two,zero,two,five,seven");
	 }
	 public static boolean test6() throws Exception {
		 CompleteBinaryTree<String> cbt = new CompleteBinaryTree<String>();
		 cbt.add("zero");
		 if(!cbt.accessInternal(0).equals("zero")) {
			 System.out.println("accress 0");
			 return false;
		 }
		 cbt.add("one");
		 cbt.add("two");
		 if(!cbt.accessInternal(1).equals("one")) {
			 System.out.println("accress 1");
			 return false;
		 }
		 if(!cbt.accessInternal(2).equals("two")) {
			 System.out.println("accress 2");
			 return false;
		 }
		 cbt.remove("zero");
		 return cbt.accessInternal(0).equals("one") || cbt.accessInternal(0).equals("two");
	 }
	 public static boolean test7() throws Exception{
		 String[] VALUES = {"zero", "neg-five", "five", "two", "neg-two", "seven", "neg-one"};
		 CompleteBinaryTree<String> cbt = new CompleteBinaryTree<String>();
		 for(String str : VALUES) {
			 cbt.add(str);
		 }
		 if(!cbt.contains("zero")) {
			 return false;
		 }
		 if(!cbt.contains("five")) {
			 return false;
		 }
		 if(!cbt.contains("two")) {
			 return false;
		 }
		 return cbt.capacity() == VALUES.length;
		 }
	 public static boolean test8() throws Exception {
		 String[] VALUES = {"zero", "neg-five", "five", "two", "neg-two", "seven", "neg-one"};
		 String[] VALUES_ITERATED = {"two", "neg-five", "neg-two", "zero", "seven", "five", "neg-one"};
		 CompleteBinaryTree<String> cbt = new CompleteBinaryTree<String>();
		 for(String str : VALUES) {
			 cbt.add(str);
		 }
		 int ii = 0;
		 for(String str : cbt) {
			 //System.out.println(str);
			 if(!str.equals(VALUES_ITERATED[ii])) {
				 return false;
			 }
			 ii++;
		 }
		 return cbt.contains("five");
	 }
	 public static void main(String[] args) throws Exception {

		 System.out.println("test 0 : " + test0());
		 System.out.println("test 1 : " + test1());
		 System.out.println("test 2 : " + test2());
		 System.out.println("test 3 : " +test3());
		 System.out.println("test 4 : " +test4());
		 System.out.println("test 5 : " + test5());
		 System.out.println("test 6 : " + test6());
		 System.out.println("test 7 : " + test7());
		 System.out.println("test 8 : " + test8());
			
	 } 
 */
 
