package edu.ics211.h12;

import java.util.*;

public class BST_Iterator<K extends Comparable<K>, V> implements Iterator<TreeNode<K,V>> {
	private Stack<TreeNode<K, V>> visit;
	public BST_Iterator(TreeNode<K, V> root){
		visit = new Stack<TreeNode<K, V>>();
	 	pushLeft(root);
	}
	
	@Override
	public boolean hasNext() {
		return !visit.isEmpty();
	}
	@Override
	public TreeNode<K, V> next() {
		if(!hasNext()) {
			return null;
		}
		
		TreeNode<K, V> current = visit.pop();
		if(current.right != null) {
			pushLeft(current.right);
		}
		return current;
	}
	

	private void pushLeft(TreeNode<K, V> current) {
		while(current != null) {
			visit.push(current);
			current = current.left;
		}
	}	
}
