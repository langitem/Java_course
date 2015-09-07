// HumanReadableComparison.java
// Comparing two Double types and return a human readable result
// Author: Daniel Schieberle
// Last Update: July 20th 2013


public class HumanReadableComparison  {
	
	public final static String IN_CASE_EQUAL = " is numerically equal to ";
	public final static String IN_CASE_DIFFERENT = " is numerically greater than ";	
	
	// static method to compare two Doubles and return human redable result
	public static String[] onDoubles(Double a, Double b) {
		// stop comparing once on value is null
		if ((a == null) || (b == null)) {return null;}
		
		// comparing the two Doubles using Java's compareTo method defined in the Double class
		int result = a.compareTo(b);
		if (result > 0) {
			// a is greather than b
			return new String[] {a.toString(),IN_CASE_DIFFERENT,b.toString()};
		} else if (result < 0) {
			// b is greater than a 
			return new String[] {b.toString(),IN_CASE_DIFFERENT,a.toString()};						
		} else {
			// both Doubles are equal
			return new String[] {a.toString(),IN_CASE_EQUAL,b.toString()};			
		}
	} // end of method onDoubles
	
} // end of class
