package edu.ics211.ec;
/**
 * Extra Credit: Implement a Min-Heap
 * Use "https://en.wikipedia.org/wiki/Heap_(data_structure)" for help
 * Submissions will be accepted as long as I can input grades into Laulima
 * You may not extend or use any classes (Interfaces/Enums are OK) in java.util as class variables aside from:
 * 		{ ArrayList, LinkedList, BitSet, Iterator }
 * 
 * Heap has no generics, assume everything that is put in the heap implements the interface 'Quantizable'
 * You can declare any internal variables you like.
 * 
 * @author Benjamin Strauss
 *
 */
public class Heap{
	
	private Quantizable[] MinHeap;
	private int size;
	
	
	public Heap() { 
		MinHeap = new Quantizable[31];
		size = 0;
	}
	
	public void insert(Quantizable q) {
		int inc = size();
		if(inc == MinHeap.length) {
			resize();
		}
		size++;
		MinHeap[inc] = q;
		heapify(MinHeap);
		
	}
	
	public Quantizable find_min() {
		return MinHeap[0];
	}
	
	public Quantizable extract_min() {
		Quantizable min = MinHeap[0];
		for(int i = 0; i < size - 1; i++) {
			  MinHeap[i] = MinHeap[i + 1];
		}
		MinHeap[size - 1] = null;
		size--;
		heapify(MinHeap);
		return min;
	}
	
	public void delete_min() {
		for(int i = 0; i < size - 1; i++) {
			  MinHeap[i] = MinHeap[i + 1];
		}
		MinHeap[size - 1] = null;
		size--;
		heapify(MinHeap);
	}
	
	public int size() {
		return size;
	}
	
	private final void resize() {
		Quantizable[] temp = MinHeap;
		 MinHeap = new Quantizable[MinHeap.length * 2 + 1];
		System.arraycopy(temp, 0, MinHeap, 0, temp.length);
	}
	
	public static void heapify(Quantizable... q) {
		heapify(0, q);
	}
	
	private static void heapify(int i, Quantizable[] q) {
		int n = q.length;
		int smallest = i;
		int left  = 2 * i + 1;
		int right = 2 * i + 2;
		if(q[smallest] == null || q[right] == null || q[left] == null) {
			return;
		} 
		if(q[left].compareTo(q[smallest]) < 0) {
			smallest = left;
		} 
		if(q[right].compareTo(q[smallest]) < 0) {
			smallest = right;
		}
		if(smallest != i) {
			Quantizable temp = q[i];
			q[i] = q[smallest];
			q[smallest] = temp;
		} 
		heapify(left, q);
		heapify(right,q);
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < MinHeap.length; i++) {
			if(MinHeap[i] != null)
			str.append(MinHeap[i] + " ");
		}
		return str.toString();
	}
	public void out(Object a) {
		System.out.println(a);
	}
}
/**
 * public static void main(String[] args) {
		
		class Node implements Quantizable{
			private Object obj;
			public Node (Object obj){
				this.obj = obj;
			}
			@Override
			public double quantize() {
				return obj.hashCode();
			}
			public String toString() {
				return obj.toString();
			}
		}
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		Node ten = new Node(10);
		Node ten1 = new Node(11);
		Node ten2 = new Node(12);
		Node ten3 = new Node(13);
		Node ten4 = new Node(14);
		Node ten5 = new Node(15);
		
		Heap minheap = new Heap();
		minheap.insert(ten4);
		minheap.insert(five);
		minheap.insert(two);
		minheap.insert(ten1);
		minheap.insert(eight);
		minheap.insert(ten3);
		minheap.insert(ten);
		minheap.insert(three);
		minheap.insert(ten2);
		minheap.insert(four);
		minheap.insert(ten5);
		minheap.insert(one);
		minheap.insert(six);
		minheap.insert(seven);
		minheap.insert(nine);
		minheap.out(minheap);
		minheap.extract_min();
		minheap.extract_min();
		minheap.extract_min();
		minheap.delete_min();
		minheap.extract_min();
		minheap.extract_min();
		minheap.extract_min();
		minheap.extract_min();
		minheap.delete_min();
		minheap.extract_min();
		minheap.extract_min();
		minheap.extract_min();
		minheap.extract_min();
		minheap.extract_min();
		minheap.extract_min();
		
		minheap.out(minheap);
		minheap.out(minheap.size());
	}
 */
