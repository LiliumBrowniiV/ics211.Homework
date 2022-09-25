package edu.ics211.h04;
import java.util.Arrays;
import java.util.Comparator;
public class Sort<E> {
	public static Sort<String> stringSorter = new Sort<String>();
	public static Sort<Integer> intSorter = new Sort<Integer>();
	private static StringComparator sc = new StringComparator();
	private static IntegerComparator ic = new IntegerComparator();
	
	
	int numberOfSwaps;
	int numberOfComparisons;

	/**
	 * initialize the statistics
	 */
	public Sort() {
		initStats();
	}

	public static void main(String[] args) {
		String[] str = {"yes","World"};
		Integer[] intarr  = {9,6,4,1,5,9,2,6,5,3};
		Integer[] intarr1 = {9,6,4,1,5,9,2,6,5,3};
		Integer[] intarr2 = {9,6,4,1,5,9,2,6,5,3};
		System.out.println("Origin" + Arrays.toString(intarr) + "\n");
		/* debug code
		*/
		
		intSorter.bubbleSort(intarr, ic);
		//System.out.println(Arrays.toString(intarr));
		//System.out.println(intSorter.numComparisons());
		
		intSorter.insertionSort(intarr1, ic);
		//System.out.println(Arrays.toString(intarr1));
		//System.out.println(intSorter.numComparisons());
		intSorter.selectionSort(intarr2, ic);
		//System.out.println(Arrays.toString(intarr2));
		//System.out.println(intSorter.numComparisons());
		
	}

	private void initStats() {
		numberOfSwaps = 0;
		numberOfComparisons = 0;
	}

       // get method for the number of comparisons
	public int numComparisons() {
		return numberOfComparisons;
	}

       // get method for the number of swaps
	public int numSwaps() {
		return numberOfSwaps;
	}

	private void swapAdjacent(E[] data, int index) 
			throws java.lang.ArrayIndexOutOfBoundsException {
		numberOfSwaps++;
		E swap = data[index];
		data[index] = data[index + 1];
		data[index + 1] = swap;
	}
	private void swapDistant(E[] data, int index, int index2) 
			throws java.lang.ArrayIndexOutOfBoundsException {
		numberOfSwaps++;
		E swap = data[index];
		data[index] = data[index2];
		data[index2] = swap;
	}
	private boolean reorder(E[]data, Comparator<E> comparator , int index) {
			try {
				if(comparator.compare(data[index],data[index + 1]) > 0) {
					swapAdjacent(data, index);
					numberOfComparisons++;
					return true;
				} else if(comparator.compare(data[index],data[index + 1]) == 0) {
					numberOfComparisons++;
					return false;
				} else {
					numberOfComparisons++;
					return false;
				}
			}catch(ArrayIndexOutOfBoundsException e){
				return false;
			}
	}

	public void bubbleSort(E[] data, Comparator<E> comparator) {
		//debug code 
		//System.out.println("Bubble Sort");
		initStats();
		for(int i = 0; i < data.length; i++) {
			//debug code
			//System.out.println("Before\n\n" + Arrays.toString(data) + "\n\n");
			for(int j = 0; j < data.length -  i - 1; j++) {
				reorder(data,comparator,j);
			}
			//debug code
			//System.out.println("After\n\n" + Arrays.toString(data) + "\n\n");
		}
	}

	public void insertionSort(E[] data, Comparator<E> comparator) {
		initStats();
		//System.out.println("InsertionSort");
		for(int i = 0; i < data.length; i++) {
			//debug code
			//System.out.println("Before\n\n" + Arrays.toString(data) + "\n\n");
			for (int j = i; j >= 0; j-- ) {
					if(!reorder(data,comparator,j)) {
					break;
				}
			}
			//debug code
			//System.out.println("After\n\n" + Arrays.toString(data) + "\n\n");
		}
	}

	public void selectionSort(E[] data, Comparator<E> comparator) {
		//System.out.println("SelectionSort");
		initStats();
		// to be completed by each student
		for (int i = 0; i < data.length - 1; i++) {
			int smallestIndex = i;
			//debug code
			//System.out.println("Before\n\n" + Arrays.toString(data) + "\n\n");
			for (int j = i + 1; j < data.length; j++) {
				numberOfComparisons++;
				if(comparator.compare(data[smallestIndex],data[j]) > 0) {
					smallestIndex = j;
				}
			}
			swapDistant(data, smallestIndex, i); 
		}
			//debug code
			//System.out.println("After\n\n" + Arrays.toString(data) + "\n\n");
		}
}
