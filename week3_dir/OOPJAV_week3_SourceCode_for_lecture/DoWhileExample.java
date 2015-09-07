//DO WHILE LOOP EXAMPLE	
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class DoWhileExample{

	//-------Main Method-------

	public static void main(String[ ] args){
		int number = 0;
		final int maximum = 50;
		final int minimum = 1;	
		
		//Do-while loop
		do{
			String input = JOptionPane.showInputDialog("Please enter an integer 					between " + minimum + " and " + maximum + " (inclusive):");
			number = new Integer(input).intValue();
			JOptionPane.showMessageDialog(null, "Input =" + number);
		}while (number > minimum && number < maximum);
	}
}
