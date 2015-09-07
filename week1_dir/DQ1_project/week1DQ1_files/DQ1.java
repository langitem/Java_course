// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// DQ1.java
// DQ1 class
// Week 1 DQ1
// July 17, 2013

import javax.swing.JOptionPane;

public class DQ1 {
	
	private String userName;
	private String birthday;
	
	// method to set userName
	public void setUserName(String name) {
		userName = name;
	}
	
	// method to retrieve userName
	public String getUserName() {
		return userName;
	}
	
	// method to set birthday
	public void setBirthday(String date) {
		birthday = date;
	}
	
	// method to retrieve birthday
	public String getBirthday() {
		return birthday;
	}
	
	// method to display a welcome message
	public void displayWelcomeMessage() {
		JOptionPane.showMessageDialog(null, "Welcome to the DQ1 program.");
	}
	
	// method to ask for user's name
	public void askForName() {
		String name = JOptionPane.showInputDialog("What's your name? ");
		setUserName(name);
	}
	
	// method to ask for user's birthday
	public void askForBirthday() {
		String date = JOptionPane.showInputDialog(null, "When is your birthday? ");
		setBirthday(date);
	}
	
	// method to display user's name and birthday
	public void displayNameAndBirthday () {
		JOptionPane.showMessageDialog(null, "Hi " + getUserName() + ".\nYour birthday is on: " + getBirthday() );
	}

} // end of DQ1 class
