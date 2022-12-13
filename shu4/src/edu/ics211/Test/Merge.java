package edu.ics211.Test;

public class Merge {
	public static void merge(int[] a1, int[] a2, int[] merged) {
		  if (a1.length + a2.length != merged.length) {
		    throw new RuntimeException("merge length mismatch");
		  }
		  int i1 = 0, i2 = 0, i = 0;
		  while (i < merged.length) {
		    if ((i1 < a1.length) && (i2 < a2.length)) {
		      if (a1[i1] < a2[i2]) {
		        merged[i] = a1[i1++];
		      } else {
		        merged[i] = a2[i2++];
		      }
		    } else if (i1 < a1.length) {
		      merged[i] = a1[i1++];
		    } else {
		      merged[i] = a2[i2++];
		    }
		    i++;
		  }
		}
	
	public static void main(String[] args) {
		int[] a1 = {1,2,3,4,5};
		int[] a2 = {1,2,3,4,5};
		int[] a3 = new int[10];
		merge(a1,a2,a3);
		
		for(int element : a3) {
			System.out.println(element);
		}
	}
}
