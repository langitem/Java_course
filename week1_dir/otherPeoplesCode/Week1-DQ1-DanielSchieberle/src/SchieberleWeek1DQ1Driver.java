
// SchieberleWeek1DQ1Driver.java
// Wrapper class for executing SchieberleWeek1DQ1
// Author: Daniel Schieberle
// Last Update: July 7th 2013

// Exception handling in absence of display
import java.awt.HeadlessException;

// Wrapper class declaration
public class SchieberleWeek1DQ1Driver {

	// main method begins execution of Java application
	public static void main(String[] args) {
		
		// Declaring and creating SchieberleWeek1DQ1
		try {
			SchieberleWeek1DQ1 dq1 = new SchieberleWeek1DQ1();
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
		
		System.exit(0); // Clean application termination
	} // end method main


} // end class SchieberleWeek1DQ1Driver
