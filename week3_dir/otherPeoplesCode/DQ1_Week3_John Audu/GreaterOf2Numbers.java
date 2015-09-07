/***********************************
 * John Audu				   	   *
 * July 2013                       *
 * The University of Liverpool, UK *
 * Week3 DQ1 Submission            *
 **********************************/

import javax.swing.*;// makes the JOptionPane class available for use

public class GreaterOf2Numbers
{

	//-------Main Method-------

	public static void main(String[ ] args)
		{
			//Declarations of variables
			double number1, number2, greater1;
			String firstN, secondN;

			welcome();

			//Enter the string that contains any two numbers
			firstN = JOptionPane.showInputDialog("Please input the first number:"); //call the input method in JOptionPane
			secondN = JOptionPane.showInputDialog("Please input the second number:");

			/* Converty the strings to numbers and call the method that compares them
			Create an instance of the class of Double with our input string variable as an argument, then
			call the doubleValue method from the Double class and assign the result to a the double variable*/

			number1 = new Double(firstN).doubleValue(); /* wrapper class wraps primitives into a
			class(Laureate Education B.V., 2000-2007)*/
			number2 = new Double(secondN).doubleValue();
			//meterDistInput = Double.parseDouble(intInputStr) - this worked too (tutorialspoint, 2013)

			GreaterXY gr8 = new GreaterXY(); //create an instance of the method GreaterXY
			greater1 = gr8.gr81(number1,number2);

			JOptionPane.showMessageDialog(null, "the greater of " + number1 + " and " + number2 + "  is  " + greater1);//call a screen output method in JOptionPane
			
			goodbye();

		}


			public static void goodbye()
			{ // beginning of method displayMsg

				JOptionPane.showMessageDialog(null, "Thanks for choosing to use my program","Goodbye", JOptionPane.INFORMATION_MESSAGE);

    			} // end of method goodbye method

			public static void welcome()
			{ // beginning of method displayMsg

				JOptionPane.showMessageDialog(null, "Welcome to this greater of 2 numbers program","Welcome", JOptionPane.INFORMATION_MESSAGE);

    			} // end of welcome goodbye method
}
