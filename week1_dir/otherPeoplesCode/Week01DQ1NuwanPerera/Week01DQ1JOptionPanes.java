//Week 01 DQ1: Your first Java application
//Nuwan Perera
//07th July, 2013
//The University of Liverpool, UK

import javax.swing.*;

public class Week01DQ1JOptionPanes {
	private String strUserName;
	private String strBirthday;
	
	public Week01DQ1JOptionPanes() {
		strUserName = "Unknown";
		strBirthday = "Unknown";
	}
	
	//Display a welcome message to the user in one JOptionPane.
    public void showWelcomeMsg() {
        JOptionPane.showMessageDialog(null, "Welcome to my application!");
    }
	
	//Ask the user for his or her name
	public void requestUserName(){
		String strTMP = JOptionPane.showInputDialog("What is your name?");
		if(!(strTMP == null || strTMP == "")){
			strUserName = strTMP;
		}
	}
	
	//Ask the user for his or her birth date
	public void requestBirthday(){
		String strTMP = JOptionPane.showInputDialog("What is your birthday?");
		if(!(strTMP == null || strTMP == "")){
			strBirthday = strTMP;
		}
	}
	
	//Display the user’s name and birth date and thank them for using this program
    public void showFinalMsg() {
        JOptionPane.showMessageDialog(null, String.format("Your Name\t: %s\n" +
														  "Birthday\t: %s\n" +
														  "Thank you for using my application.",strUserName,strBirthday));
    }
}