//INTEGER INPUT VERSION 2
//Y. Jing
//March 2007
//University of Liverpool, UK

import javax.swing.*;

public class IntegerInput2{

	//-------Main Method-------

	public static void main(String[ ] args){
		int convertedStr;

		//Accept a string value from the user
		String intInputStr = JOptionPane.showInputDialog("Please input an integer value:");

		/*Create a new instance of Integer with a string argument, call the intValue 				method from the Integer class and assign the result to an int*/
		convertedStr = (new Integer(intInputStr)).intValue();
		JOptionPane.showMessageDialog(null, "Your int value is " + convertedStr);
	}
}