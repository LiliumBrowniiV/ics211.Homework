package edu.ics211.h04;

public class IntegerComparator implements java.util.Comparator<Integer>{
    public int compare(Integer s1, Integer s2) {
        return s1.compareTo(s2);
    }

    /**
     * basic test for functionality
     * @param args (ignored)
     */
    public static void main(String[] args) {
        IntegerComparator c = new IntegerComparator();
        System.out.println("hello compared to world returns " + c.compare(1,2));
        System.out.println("world compared to hello returns " + c.compare(2,1));
        System.out.println("world compared to world returns " + c.compare(2,2));
    }
}