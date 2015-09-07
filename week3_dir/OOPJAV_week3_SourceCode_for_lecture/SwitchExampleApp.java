//SWITCH EXAMPLE APPLICATION
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class SwitchExampleApp{

	//-------Main Method-------

	public static void main(String[ ] args){
		int number;

		//Input
		String input = JOptionPane.showInputDialog("Please input an integer:");
		number = new Integer(input).intValue();

		//Process number using a case statement
		switch (number){
			case 0:
				JOptionPane.showMessageDialog(null, "Number is 0");
			case 1:
				JOptionPane.showMessageDialog(null, "Number is 1");
			case 2:
			case 3:
			case 4:
				JOptionPane.showMessageDialog(null, "Number is 2, 3, or 4");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Number is less than 0 or more than 4");
		}
	}
}
