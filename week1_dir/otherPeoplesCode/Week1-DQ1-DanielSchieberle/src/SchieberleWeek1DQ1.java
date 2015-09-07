
// SchieberleWeek1DQ1.java
// Week1 DQ1: User interaction using JOptionPane
// Author: Daniel Schieberle
// Last Update: July 7th 2013

// Exception handling in absence of display
import java.awt.HeadlessException;
// Importing JOptionPane from swing package
import javax.swing.JOptionPane;


// SchieberleWeek1DQ1 class declaration
public class SchieberleWeek1DQ1 {
	
	// Declaring constant variables for dialog messages
	private static final String DIALOG_TITLE = "Week 1 - DQ 1 (Daniel Schieberle)";	
	
	private static final String WELCOME_MESSAGE = "Welcome to the first week's DQ1 java application";
	private static final String ASK_FOR_NAME = "Please enter your name";
	private static final String ASK_FOR_DOB = "Please enter your date of birth";
	private static final String FINAL_MESSAGE = "Thank you %s born on %s for using this week's java application";
	
	
	// Constructor for SchieberleWeek1DQ1
	public SchieberleWeek1DQ1() throws HeadlessException {
		
		// Displaying WELCOME_MESSAGE  
		JOptionPane.showMessageDialog(null, WELCOME_MESSAGE,
				DIALOG_TITLE,
				JOptionPane.PLAIN_MESSAGE);
		
		// Declaring and creating User
		User user = new User();
				
		try {	
				// Set user's name property based on user input in 2nd JOptionPane	
				user.setName(JOptionPane.showInputDialog(null, ASK_FOR_NAME,
							DIALOG_TITLE,
							JOptionPane.QUESTION_MESSAGE));
		}
		catch (UserInputException e) {
			// Handling empty input selection
			JOptionPane.showMessageDialog(null, e.getErrorMessage(),
					DIALOG_TITLE,
					JOptionPane.ERROR_MESSAGE);
			// Abnormal application termination			
			System.exit(100); 	
		}
		
		try {	
				// Set user's birthday property based on user input	in 3rd JOptionPane		
				user.setBirthday(JOptionPane.showInputDialog(null, ASK_FOR_DOB,
							DIALOG_TITLE,
							JOptionPane.QUESTION_MESSAGE));
		} catch (UserInputException e) {
			// Handling empty input selection			
			JOptionPane.showMessageDialog(null, e.getErrorMessage(),
					DIALOG_TITLE,
					JOptionPane.ERROR_MESSAGE);		
			// Abnormal application termination			
			System.exit(100); 			
		}
			
		
		//Merging FINAL_MESSAGE with user properties and display 4th JOptionPane
		JOptionPane.showMessageDialog(null, String.format( FINAL_MESSAGE , user.getName(), user.getBirthday() ),
				DIALOG_TITLE,
				JOptionPane.PLAIN_MESSAGE);		
		
	} // end of SchieberleWeek1DQ1 constructor

} // end class SchieberleWeek1DQ1


