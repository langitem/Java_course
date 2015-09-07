// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Assignment3Driver.java
// Driver class for Week 3 Assignment
// Week 3 Assignment
// July 24, 2013

import javax.swing.JOptionPane;

public class Assignment3Driver {
	
	public static void main(String[] args) {
		Assignment3App myApp = new Assignment3App();
		String warningMessage = "Please enter only \"Y\" or \"N\"";
		
		Boolean runAgain = true;
		
		myApp.greeting();
		
		while (runAgain) {
			myApp.askUserForSideLengths();
			myApp.displayTriangleType();
			
			Boolean answerIsValid = false;
			
			// following loop will continue executing unti a valid response is received (y/n)
			while (answerIsValid == false ) {
			
				String runAgainAnswer = JOptionPane.showInputDialog(null,
																	"Would you like to run again?\n" +
																	"Please enter Y or N",
																	JOptionPane.QUESTION_MESSAGE);

				try {
					String runAgainAnswerLowerCase = runAgainAnswer
							.toLowerCase();
					if (runAgainAnswerLowerCase.contentEquals("n")) {
						runAgain = false;
						answerIsValid = true;
					} else if (runAgainAnswerLowerCase.contentEquals("y")) {
						runAgain = true;
						answerIsValid = true;
					} else {
						myApp.showWarningMessage(warningMessage);
					}

				} catch (Exception e) {
					myApp.showWarningMessage(warningMessage);
				}
			
			
			} // end of nested while loop
			
		} // end of while loop
	
	} // end of main method

}
