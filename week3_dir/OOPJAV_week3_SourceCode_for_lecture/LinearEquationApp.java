//LINEAR EQUATION APPLICATION CLASS
//Y. Jing
//March 2007
//The University of Liverpool, UK

import javax.swing.*;

public class LinearEquationApp{

	//-------Main Method-------

	public static void main(String[ ] args)
	{
		int newBValue, newCValue;
		//Input
		String inputB = JOptionPane.showInputDialog("Please input an int value for B:");
		newBValue = new Integer(inputB).intValue();
		String inputC = JOptionPane.showInputDialog("Please input an int value for C:");
		newCValue = new Integer(inputC).intValue();

		//Create linear equation instance
		LinearEquation newEquation = new LinearEquation(newBValue, newCValue);

		//Calculation if method returns true, output result; otherwise produce error message
		if(newEquation.resolveLinearEquation())
			JOptionPane.showMessageDialog(null, "Result is " + newEquation.getXValue());
		else
			JOptionPane.showMessageDialog(null, "Error 1:  Divide by zero error!");
	}
}