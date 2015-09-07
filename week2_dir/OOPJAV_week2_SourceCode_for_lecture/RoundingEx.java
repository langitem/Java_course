//ROUNDING EXAMPLE APPLICATION CLASS
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class RoundingEx{

	//-------Main Method-------

	public static void main(String[ ] args){
		double inputDouble;

		//Input
		String intInputStr = JOptionPane.showInputDialog("Please input an double value:");

		/*Create a new instance of Double with a string argument, call the doubleValue 			method from the Double class and assign the result to a double*/
		inputDouble = new Double(intInputStr).doubleValue();

		//Output
		JOptionPane.showMessageDialog(null, "Your cast int value is " + (int)inputDouble);
		JOptionPane.showMessageDialog(null, "Your rounded int value is " + Math.round(inputDouble));
		JOptionPane.showMessageDialog(null, "Your ‘rint’ int value is " + Math.rint(inputDouble));
	}
}
