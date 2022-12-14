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
	private Heap(Quantizable[] q) {
		MinHeap = q;
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
	
	public static Heap heapify(Quantizable... q) {
		heapify(0, q);
		Heap heap = new Heap(q);
		return heap;
	}
	
	private static void heapify(int i, Quantizable[] q) {
		int n = q.length;
		int smallest = i;
		int left  = 2 * i + 1;
		int right = 2 * i + 2;
		if(q[right] == null && q[left] == null) {
			return;
		} else if(q[right] == null) {
			if(q[left].compareTo(q[smallest]) < 0) {
				smallest = left;
			} else {
				return;
			}
		} else {
			if(q[left].compareTo(q[smallest]) < 0) {
				smallest = left;
			} 
			if(q[right].compareTo(q[smallest]) < 0) {
				smallest = right;
			}
		}
		if(smallest != i) {
			Quantizable temp = q[i];
			q[i] = q[smallest];
			q[smallest] = temp;
		} 
		heapify(left,  q);
		heapify(right, q);
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < MinHeap.length; i++) {
			if(MinHeap[i] != null)
			str.append(MinHeap[i].quantize() + " ");
		}
		return str.toString();
	}
	public void out(Object a) {
		System.out.println(a);
	} 
}

/**
* public boolean test0() {
	class Decimal implements Quantizable{
		double d;
		public Decimal(double d) {
			this.d = d;
		}
		@Override
		public double quantize() {
			return Double.valueOf(d);
		}
		
	}
	Decimal[] numbers = {
			new Decimal(9),new Decimal(5),new Decimal(1),new Decimal(4),new Decimal(7),new Decimal(3), new Decimal(2), new Decimal(8)
	};
	Heap test = new Heap();
	for(Decimal num : numbers) {
		test.insert(num);
	}
	Quantizable min = new Decimal(0);
	System.out.println(test);
	for(int i = 0; i < numbers.length; i++) {
		Quantizable temp = test.extract_min();
		if(temp.quantize() <= min.quantize()) {
			return false;
		}	
		min = temp;
	}
	return true;
}
public static void main(String[] args) {
	Heap test = new Heap();
	System.out.println(test.test0());
}
*/

