// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Assignment7Driver.java
// Driver class for assignment 7
// Week 7 Assignment
// August 21, 2013

import javax.swing.JFrame;

public class Assignment7Driver {
	
	public static void main(String[] args) {
		
		BlueBallPanel panel = new BlueBallPanel();
		JFrame application = new JFrame("Assignment 7 by Emanuel Langit");
		
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setLocationRelativeTo(null);
		application.add(panel);
		application.setSize(500, 500);
		application.setVisible(true);
	}

}
