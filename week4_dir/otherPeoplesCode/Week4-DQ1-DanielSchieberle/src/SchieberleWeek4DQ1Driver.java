// SchieberleWeek4DQ1Driver.java
// Wrapper class for executing SchieberleWeek4DQ1
// Author: Daniel Schieberle
// Last Update: July 27th 2013

import javax.swing.SwingUtilities;

//Wrapper class declaration
public class SchieberleWeek4DQ1Driver {
	
	// main method begins execution of Java application	
	public static void main(String[] args) {
		

		
		   //	Swing objects aren't thread safe and need to be updated by the "Event Dispatcher Thread" and not the "main" thread created for executing this class.
	       SwingUtilities.invokeLater(new Runnable() {
	            public void run() {		
	            		//instantiation SchieberleWeek3DQ1
	            		SchieberleWeek4DQ1 hi = new SchieberleWeek4DQ1();
	            		// making the GUI visible
	            		hi.setVisible(true);
	            }
	       	}
	       ); 

	} // end method main

} // end class SchieberleWeek4DQ1Driver
