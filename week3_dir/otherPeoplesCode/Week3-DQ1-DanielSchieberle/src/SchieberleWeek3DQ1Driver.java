// SchieberleWeek3DQ1Driver.java
// Wrapper class for executing SchieberleWeek3DQ1
// Author: Daniel Schieberle
// Last Update: July 20th 2013

import javax.swing.SwingUtilities;

//Wrapper class declaration
public class SchieberleWeek3DQ1Driver {
	
	// main method begins execution of Java application	
	public static void main(String[] args) {

		   //	Swing objects aren't thread safe and need to be updated by the "Event Dispatcher Thread" and not the "main" thread created for executing this class.
	       SwingUtilities.invokeLater(new Runnable() {
	            public void run() {		
	            		//instantiation SchieberleWeek3DQ1
	            		SchieberleWeek3DQ1 dq1 = new SchieberleWeek3DQ1();
	            		// making the GUI visible
	            		dq1.setVisible(true);
	            }
	       	}
	       );

	} // end method main

} // end class SchieberleWeek3DQ1Driver
