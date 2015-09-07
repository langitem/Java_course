// SchieberleWeek8DQ1Driver.java
// Wrapper class for executing SchieberleWeek8DQ1
// Author: Daniel Schieberle
// Last Update: August 23rd 2013

import javax.swing.SwingUtilities;

//Wrapper class declaration
public class SchieberleWeek8DQ1Driver {
	
	// main method begins execution of Java application	
	public static void main(String[] args) {
		

		
		   //	Swing objects aren't thread safe and need to be updated by the "Event Dispatcher Thread" and not the "main" thread created for executing this class.
	       SwingUtilities.invokeLater(new Runnable() {
	            public void run() {		
	            		//instantiation SchieberleWeek6DQ1
	            		SchieberleWeek8DQ1 dq1 = new SchieberleWeek8DQ1();
	            		// making the GUI visible
	            		dq1.setVisible(true);
	            }
	       	}
	       ); 

	} // end method main

} // end class SchieberleWeek8DQ1Driver
