package edu.ics211.h04;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SortTest {
	private Sort<String> stringSorter;
	private Sort<Integer> intSorter;
	private StringComparator sc;
	private IntegerComparator ic;
	static final String[] unsortedStrings =
		{ "hello", "world", "ics", "211", "true", "yes" };
	static final String[] sortedStrings =
		{ "211", "hello", "ics", "true", "world", "yes" };
	static final Integer[] unsortedIntegers =
		{ 3, 1, 4, 1, 5, 9, 2, 6, 5, 3 };
	static final Integer[] sortedIntegers =
		{ 1, 1, 2, 3, 3, 4, 5, 5, 6, 9 };
	static Integer[] manyIntegers;
	public static SortTest st  = new SortTest();
	
public static void main(String args[]) {
	try {
		st.setUp();
		st.test();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		sc = new StringComparator();
		ic = new IntegerComparator();
		Random rand = new Random();
		manyIntegers = new Integer[rand.nextInt(1000)];
		for (int i = 0; i < manyIntegers.length; i++) {
			manyIntegers[i] = rand.nextInt(10000);
		}
	}

	private void assertArraysEqual(Object[] a1, Object[] a2) {
		assertEquals(a1.length, a2.length);
		for (int i = 0; i < a1.length; i++) {
			assert(a1[i].equals(a2[i]));
		}
	}

	private void testStringSorts(String[] original, String[] expected) {
		stringSorter = new Sort<String>();
		final boolean printSorted = false;  // make true for more debugging
		assertEquals(stringSorter.numComparisons(), 0);
		assertEquals(stringSorter.numSwaps(), 0);
		// first: bubble sort
		String[] sorted = Arrays.copyOf(original, original.length);
		stringSorter.bubbleSort(sorted, sc);
		System.out.println ("bubble sort on an array of length " +
				original.length + " did " +
				stringSorter.numComparisons() + " comparisons and " +
				stringSorter.numSwaps() + " swaps");
		assertArraysEqual(sorted, expected);
		assert(stringSorter.numComparisons() > 0);
		assert(stringSorter.numSwaps() > 0);
		assert(stringSorter.numComparisons() >= stringSorter.numSwaps());
		// sort again, make sure the statistics are reset correctly
		int swaps = stringSorter.numSwaps();
		int comparisons = stringSorter.numComparisons();
		sorted = Arrays.copyOf(original, original.length);
		stringSorter.bubbleSort(sorted, sc);
		assertEquals(stringSorter.numComparisons(), comparisons);
		assertEquals(stringSorter.numSwaps(), swaps);
		for (int i = 0; i + 1 < sorted.length; i++) {
			if (printSorted) {
				System.out.println ("sorted[" + i + "] is " + sorted[i]);
			}
			assert(sc.compare(sorted[i], sorted[i + 1]) <= 0);
		}
		if (printSorted) {
			System.out.println ("sorted[" + (sorted.length - 1) + "] is " + sorted[sorted.length - 1]);
		}
		// next: insertion sort
		sorted = Arrays.copyOf(original, original.length);
		stringSorter.insertionSort(sorted, sc);
		System.out.println ("insertion sort on an array of length " +
				original.length + " did " +
				stringSorter.numComparisons() + " comparisons and " +
				stringSorter.numSwaps() + " swaps");
		if(expected == null) {
			expected = Arrays.copyOf(sorted, sorted.length); 
		}
		assertArraysEqual(sorted, expected);
		assert(stringSorter.numComparisons() > 0);
		assert(stringSorter.numSwaps() > 0);
		assert(stringSorter.numComparisons() >= stringSorter.numSwaps());
		// sort again, make sure the statistics are reset correctly
		swaps = stringSorter.numSwaps();
		comparisons = stringSorter.numComparisons();
		sorted = Arrays.copyOf(original, original.length);
		stringSorter.insertionSort(sorted, sc);
		assertEquals(stringSorter.numComparisons(), comparisons);
		assertEquals(stringSorter.numSwaps(), swaps);
		for (int i = 0; i + 1 < sorted.length; i++) {
			if (printSorted) {
				System.out.println ("sorted[" + i + "] is " + sorted[i]);
			}
			assert(sc.compare(sorted[i], sorted[i + 1]) <= 0);
		}
		if (printSorted) {
			System.out.println ("sorted[" + (sorted.length - 1) + "] is " + sorted[sorted.length - 1]);
		}
		// finally, selection sort
		sorted = Arrays.copyOf(original, original.length);
		stringSorter.selectionSort(sorted, sc);
		System.out.println ("selection sort on an array of length " +
				original.length + " did " +
				stringSorter.numComparisons() + " comparisons and " +
				stringSorter.numSwaps() + " swaps");
		assert(stringSorter.numComparisons() > 0);
		assert(stringSorter.numSwaps() > 0);
		assert(stringSorter.numComparisons() >= stringSorter.numSwaps());
		// sort again, make sure the statistics are reset correctly
		swaps = stringSorter.numSwaps();
		comparisons = stringSorter.numComparisons();
		sorted = Arrays.copyOf(original, original.length);
		stringSorter.selectionSort(sorted, sc);
		assertEquals(stringSorter.numComparisons(), comparisons);
		assertEquals(stringSorter.numSwaps(), swaps);
		for (int i = 0; i + 1 < sorted.length; i++) {
			if (printSorted) {
				System.out.println ("sorted[" + i + "] is " + sorted[i]);
			}
			assert(sc.compare(sorted[i], sorted[i + 1]) <= 0);
		}
		if (printSorted) {
			System.out.println ("sorted[" + (sorted.length - 1) + "] is " + sorted[sorted.length - 1]);
		}
	}
	
	/**
	 * @param original: data to be sorted
	 * @param expected: same data, already sorted.  If expected is
	 * null, the data sorted by insertion sort and selection sort
	 * is compared to the data sorted by bubble sort, reporting
	 * success only if all three are the same
	 */
	private void testIntegerSorts(Integer[] original, Integer[] expected){
		
		intSorter = new Sort<Integer>();
		final boolean printSorted = false;  // make true for more debugging
		assertEquals(intSorter.numComparisons(), 0);
		assertEquals(intSorter.numSwaps(), 0);
		// first: bubble sort
		Integer[] sorted = Arrays.copyOf(original, original.length);
		intSorter.bubbleSort(sorted, ic);
		System.out.println ("bubble sort on an array of length " +
				original.length + " did " +
				intSorter.numComparisons() + " comparisons and " +
				intSorter.numSwaps() + " swaps");
		if(expected == null) {
			expected = Arrays.copyOf(sorted, sorted.length); 
		}
		assertArraysEqual(sorted, expected);
		assert(intSorter.numComparisons() > 0);
		assert(intSorter.numSwaps() > 0);
		assert(intSorter.numComparisons() >= intSorter.numSwaps());
		// sort again, make sure the statistics are reset correctly
		int swaps = intSorter.numSwaps();
		int comparisons = intSorter.numComparisons();
		sorted = Arrays.copyOf(original, original.length);
		intSorter.bubbleSort(sorted, ic);
		assertEquals(intSorter.numComparisons(), comparisons);
		assertEquals(intSorter.numSwaps(), swaps);
		for (int i = 0; i + 1 < sorted.length; i++) {
			if (printSorted) {
				System.out.println ("sorted[" + i + "] is " + sorted[i]);
			}
			assert(ic.compare(sorted[i], sorted[i + 1]) <= 0);
		}
		if (printSorted) {
			System.out.println ("sorted[" + (sorted.length - 1) + "] is " + sorted[sorted.length - 1]);
		}
		// next: insertion sort
		sorted = Arrays.copyOf(original, original.length);
		intSorter.insertionSort(sorted, ic);
		System.out.println ("insertion sort on an array of length " +
				original.length + " did " +
				intSorter.numComparisons() + " comparisons and " +
				intSorter.numSwaps() + " swaps");
		assert(intSorter.numComparisons() > 0);
		assert(intSorter.numSwaps() > 0);
		assert(intSorter.numComparisons() >= intSorter.numSwaps());
		// sort again, make sure the statistics are reset correctly
		swaps = intSorter.numSwaps();
		comparisons = intSorter.numComparisons();
		sorted = Arrays.copyOf(original, original.length);
		intSorter.insertionSort(sorted, ic);
		assertEquals(intSorter.numComparisons(), comparisons);
		assertEquals(intSorter.numSwaps(), swaps);
		for (int i = 0; i + 1 < sorted.length; i++) {
			if (printSorted) {
				System.out.println ("sorted[" + i + "] is " + sorted[i]);
			}
			assert(ic.compare(sorted[i], sorted[i + 1]) <= 0);
		}
		if (printSorted) {
			System.out.println ("sorted[" + (sorted.length - 1) + "] is " + sorted[sorted.length - 1]);
		}
		// finally, selection sort
		sorted = Arrays.copyOf(original, original.length);
		intSorter.selectionSort(sorted, ic);
		System.out.println ("selection sort on an array of length " +
				original.length + " did " +
				intSorter.numComparisons() + " comparisons and " +
				intSorter.numSwaps() + " swaps");
		assert(intSorter.numComparisons() > 0);
		assert(intSorter.numSwaps() > 0);
		assert(intSorter.numComparisons() >= intSorter.numSwaps());
		// sort again, make sure the statistics are reset correctly
		swaps = intSorter.numSwaps();
		comparisons = intSorter.numComparisons();
		sorted = Arrays.copyOf(original, original.length);
		intSorter.selectionSort(sorted, ic);
		assertEquals(intSorter.numComparisons(), comparisons);
		assertEquals(intSorter.numSwaps(), swaps);
		for (int i = 0; i + 1 < sorted.length; i++) {
			if (printSorted) {
				System.out.println ("sorted[" + i + "] is " + sorted[i]);
			}
			assert(ic.compare(sorted[i], sorted[i + 1]) <= 0);
		}
		if (printSorted) {
			System.out.println ("sorted[" + (sorted.length - 1) + "] is " + sorted[sorted.length - 1]);
		}
	}

	@Test
	void test() {
		System.out.println();
		testIntegerSorts(unsortedIntegers, sortedIntegers);
		System.out.println();
		testIntegerSorts(manyIntegers, null);
		System.out.println();
		testStringSorts(unsortedStrings, sortedStrings);
	}

}
