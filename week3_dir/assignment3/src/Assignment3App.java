// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Assignment3App.java
// Application class for Week 3 Assignment
// Week 3 Assignment
// July 24, 2013

import javax.swing.JOptionPane;

public class Assignment3App {
	
	private float side1 = 0;
	private float side2 = 0;
	private float side3 = 0;
	
	Triangle assignmentTriangle = new Triangle(side1, side2, side3);
	
	// method to display welcome message
	public void greeting() {
		JOptionPane.showMessageDialog(null, "Welcome! This program will ask you for the lengths\n" +
											"of all 3 sides of a triangle and tell you if they are\n" +
											"equilateral, isosceles, or scalene");
	}
	
	public void askUserForSideLengths() {
		
		side1 = getSideLength("side1");
		assignmentTriangle.setSide1(side1);
		side2 = getSideLength("side2");
		assignmentTriangle.setSide2(side2);
		side3 = getSideLength("side3");
		assignmentTriangle.setSide3(side3);
			
		
	} // end of askUserForSideLengths method
	
	public void displayTriangleType() {
		String triangleType = assignmentTriangle.getTriangleType();
		
		JOptionPane.showMessageDialog(null, "This is a " + triangleType + " triangle.", "Triangle type", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private float getSideLength(String side) {
		Boolean isInputValid = false;
		float sideLength = 0;
		
		while (isInputValid == false) {
			
			String sideString = JOptionPane.showInputDialog(null, "Please enter the length of " + side, JOptionPane.QUESTION_MESSAGE);
			String warningMessage = "Please enter only a number greater than 0 and less than 100";
			
			try {
				sideLength = Float.parseFloat(sideString);
				if ((sideLength < 0) || (sideLength > 100)) {
					showWarningMessage(warningMessage);
				} else {
					isInputValid = true;
				}
			} catch (Exception e) {
				showWarningMessage(warningMessage);
			} // end of try catch block
			
		} // end of while loop
		
		return sideLength;
	} // end of getSideLength method
	
	public void showWarningMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg,
				"Invalid input", JOptionPane.WARNING_MESSAGE);
	}

}
