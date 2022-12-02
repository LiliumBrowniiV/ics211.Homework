package edu.ics211.h12;

import java.util.*;

public class BST_Iterator<V> implements Iterator<V> {
	private Stack<TreeNode<?, V>> visit;
	public BST_Iterator(TreeNode<?, V> root){
		visit = new Stack<TreeNode<?, V>>();
	 	pushLeft(root);
	}
	
	@Override
	public boolean hasNext() {
		return !visit.isEmpty();
	}
	@Override
	public V next() {
		if(!hasNext()) {
			return null;
		}
		
		TreeNode<?, V> current = visit.pop();
		if(current.right != null) {
			pushLeft(current.right);
		}
		return current.value;
	}
	

	private void pushLeft(TreeNode<?, V> current) {
		while(current != null) {
			visit.push(current);
			current = current.left;
		}
	}	
}
