// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// DQ2Application.java
// Application class for DQ2
// Week 3 DQ2
// July 21, 2013

import javax.swing.JOptionPane;

public class DQ2Application {
	
	private int monthNum;
	private String monthString;
	
	// method to display welcome message
	public void displayGreeting() {
		JOptionPane.showMessageDialog(null, "Welcome! This program will ask you to give\n" +
											"a number from 1-12, and will display the\n" +
											"respective month");
	}
	
	// method to get month number from user
	public void getMonthNum() {
		
		Boolean isMonthNumInvalid = true;
		
		// following while loop will execute until a valid input is received from the user
		while (isMonthNumInvalid) {			
			String monthNumString = JOptionPane.showInputDialog(null, "Please enter an integer from 1-12.",
																"Month Number?", JOptionPane.QUESTION_MESSAGE);
			
			try {
				
				monthNum = Integer.parseInt(monthNumString);
				if ((monthNum < 1) || (monthNum > 12)) {
					showWarningMessage();
				} else {
					isMonthNumInvalid = false;
				} // end of if-else statement
				
			} catch (Exception e) {
				showWarningMessage();
			} // end of try-catch statement
			
		} // end of while loop
		
	} // end of getMonthNum method
	
	
	private void showWarningMessage() {
		JOptionPane.showMessageDialog(null, "Please enter only an integer value from 1-12.",
				"Invalid input", JOptionPane.WARNING_MESSAGE);
	}
	
	// method to display the corresponding month
	public void displayMonth () {
		
		// Determine month
		switch (monthNum) {
		case 1:
			monthString = "January";
			break;
		case 2:
			monthString = "February";
			break;
		case 3:
			monthString = "March";
			break;
		case 4:
			monthString = "April";
			break;
		case 5:
			monthString = "May";
			break;
		case 6:
			monthString = "June";
			break;
		case 7:
			monthString = "July";
			break;
		case 8:
			monthString = "August";
			break;
		case 9:
			monthString = "September";
			break;
		case 10:
			monthString = "October";
			break;
		case 11:
			monthString = "November";
			break;
		case 12:
			monthString = "December";
			break;
		} // end of switch
		
		JOptionPane.showMessageDialog(null, "The corresponding month is: " + monthString, "Month", JOptionPane.INFORMATION_MESSAGE);
	} // end of displayMonth method

}
