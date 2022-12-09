package edu.ics211.ec;

/**
 * A Quantizable class can be represented as a number: specifically a double. 
 * 
 * @author Benjamin Strauss
 *
 */

public interface Quantizable extends Comparable<Quantizable> {
	/** @return numerical representation of the object */
	public double quantize();
	
	public default int compareTo(Quantizable other) {
		if(quantize() == other.quantize()) { 
			return 0;
		} else {
			return (quantize() < other.quantize()) ? -1 : 1; 
		}
	}
}
