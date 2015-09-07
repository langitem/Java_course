//VARIABLE COUNT WHILE LOOP EXAMPLE
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class WhileLoopExample{

	//-------Main Method-------

	public static void main(String[ ] args){
		int number = 2;
		final int maximum = 50;
		final int minimum = 1;

		//While loop
		while (number > minimum && number < maximum){
			String input = JOptionPane.showInputDialog("Please enter an integer between " + minimum + " and " + maximum + " (inclusive):");
			number = new Integer(input).intValue();
			JOptionPane.showMessageDialog(null, "Input =" + number);
		}
	}
}
