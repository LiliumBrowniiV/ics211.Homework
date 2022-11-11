package edu.ics211.Test;

public class LinkedListRec<E> {

	  // here, include the LinkedNode definition

	          /** 
	            * A node in a singly-linked list
	            * @author         Edo Biagioni
	            * @lecture        ICS 211 Jan 27 or later
	            * @date           January 26, 2010
	            */
	          
	          private static class LinkedNode<T> {
	            private T item;
	            private LinkedNode<T> next;
	          
	          
	          /** 
	            * constructor to build a node with no successor
	            * @param the value to be stored by this node
	            */
	            private LinkedNode(T value) {
	              item = value;
	              next = null;
	            }
	          
	          
	          /** 
	            * constructor to build a node with specified (maybe null) successor
	            * @param the value to be stored by this node
	            * @param the next field for this node
	            */
	            private LinkedNode(T value, LinkedNode<T> reference) {
	              item = value;
	              next = reference;
	            }
	          }
	  // end of the LinkedNode definition


	  // this is the start of the linked list.  If the list is empty, it is null
	  protected LinkedNode<E> head;

	  /** 
	    * initializes an empty linked list
	    */
	  public LinkedListRec() {
	    head = null;
	  }

	  /** recursive private method, called by the public wrapper method 
	    * @param the head of the list (may be null if we are at the end)
	    * @return the size of the list
	    */
	  private int size(LinkedNode<E> current) {
	    if (current == null) {
	      return 0;  // an empty list has size 0
	    }  // a non-empty list has size 1 more than the rest of the list:
	    return 1 + size (current.next);
	  }
	   
	  /** public wrapper method, calls the private recursive method 
	    * @param none
	    * @return the size of the list
	    */
	  public int size() {
	    return size(head);
	  }

	  /** recursive private method, called by the public wrapper method 
	    * @param the head of the list (may be null if we are at the end)
	    * @param the value to be added
	    * @return the list, with the value added
	    */
	  private LinkedNode<E> addAtEnd(LinkedNode<E> node, E value) {
	    if (node == null) {
	      return new LinkedNode<E>(value);
	    }
	    node.next = addAtEnd(node.next, value);
	    return node;
	  }
	   
	  /** public wrapper method, calls the private recursive method 
	    * @param the value to be added at the end of the linked list
	    */
	  public void add(E value) {
	    head = addAtEnd(head, value);
	  }

	  /** recursive private method, called by the public wrapper method 
	    * @param the head of the list (may be null if we are at the end)
	    * @param the number of nodes to skip before inserting
	    * @param the value to be added
	    * @return the list, with the value added
	    */
	  private LinkedNode<E> addAtPosition(LinkedNode<E> node, int skip, E value) {
	    if (skip == 0) {
	      return new LinkedNode<E>(value, node);
	    }
	    if (node == null) {  // node is null but skip > 0 -- bad index
	      throw new IndexOutOfBoundsException("bad index for add");
	    }
	    node.next = addAtPosition(node.next, skip - 1, value);
	    return node;
	  }
	   
	  /** public wrapper method, calls the private recursive method 
	    * @param the position at which to add: 0 to add at the start
	    * @param the value to be added
	    * @throws IndexOutOfBoundsException if the index is less than 0
	    *         or greater than the number of elements in the linked list
	    */
	  public void add(int index, E value) {
	    head = addAtPosition(head, index, value);
	  }

	  /** recursive private method, called by the public wrapper method 
	    * @param the head of the list (may be null if we are at the end)
	    * @param the value to be removed
	    * @return the list, with the value removed
	    */
	  private LinkedNode<E> remove(LinkedNode<E> node, E value) {
	    if (node == null) {  // node is null but skip > 0 -- bad index
	      return node;
	    }
	    if (node.item.equals(value)) {
	      return node.next;  // match, so remove this node
	    }
	    node.next = remove(node.next, value);
	    return node;
	  }
	   
	  /** public wrapper method, calls the private recursive method 
	    * @param the object to remove
	    */
	  public void remove(E value) {
	    head = remove(head, value);
	  }

	  /** recursive private method, called by the public wrapper method 
	    * @param the head of the list (may be null if we are at the end)
	    * @return the string representing the list
	    */
	  private String toString(LinkedNode<E> node) {
	    if (node == null) {
	      return "";
	    }
	    if (node.next == null) {
	      return node.item.toString();
	    }
	    return node.item.toString() + " ==> " + toString(node.next);
	  }

	  /** 
	    * concatenates the elements of the linked list, separated by " ==> "
	    * @return the string representation of the list
	    */
	  public String toString() {
	    return toString(head);
	  }

	  /** 
	    * unit test method -- basic testing of the functionality
	    * @param required, ignored
	    */
	  public static void main (String [] arguments) {
	    LinkedListRec<String> ll = new LinkedListRec<String>();
	    System.out.println (ll);
	    ll.add("foo");
	    System.out.println (ll);
	    ll.add(1, "bar");
	    System.out.println (ll);
	    ll.add("baz");
	    System.out.println (ll);
	    ll.add(0, "hello");
	    System.out.println (ll);
	    ll.add(1, "world");
	    System.out.println (ll);
	    ll.remove ("foo");     // remove an intermediate element
	    System.out.println (ll);
	    ll.remove ("hello");   // remove the first element
	    System.out.println (ll);
	    ll.remove ("baz");     // remove the last element
	    System.out.println (ll);
	  }

	}