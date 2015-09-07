// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Application.java
// Application class
// Week 1 Hand-in assignment
// July 10, 2013

import javax.swing.JOptionPane;

public class Application {
	
	User myUser = new User(); // create instance of User class
	
	// method to display welcome message
	public void greeting() {
		JOptionPane.showMessageDialog(null, "Welcome to my program!", "Welcome!", JOptionPane.PLAIN_MESSAGE);
	}
	
	// method to ask for user's name
	public void getName() {
		String name = JOptionPane.showInputDialog(null, "Please enter your name:", "Name?", JOptionPane.QUESTION_MESSAGE);
		myUser.setUserName(name);
	}
	
	// method to ask for user's age
	public void getAge() {
		String stringAge = JOptionPane.showInputDialog(null, "Please enter your age:", "Age?", JOptionPane.QUESTION_MESSAGE);
		Integer integerAge = Integer.parseInt(stringAge); // convert stringAge into an integer value
		myUser.setUserAge(integerAge);
	}
	
	// method to display summary
	public void displayMessages() {
		JOptionPane.showMessageDialog(null, myUser.getUserName() + ", you are " + myUser.getUserAge() + " years old!", "Summary", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// method to display age in 10 years
	public void displayAgeInTenYears() {
		int ageInTenYears = myUser.getUserAge() + 10;
		
		JOptionPane.showMessageDialog(null, "In 10 years, you will be " + ageInTenYears + " years old!", "Guess What?", JOptionPane.WARNING_MESSAGE);
	}

}
