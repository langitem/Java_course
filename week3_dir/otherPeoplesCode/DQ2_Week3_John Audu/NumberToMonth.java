/***********************************
 * John Audu				   	   *
 * July 2013                       *
 * The University of Liverpool, UK *
 * Week3 DQ2 Submission            *
 **********************************/

/* This was adapted from Dr. Sam's examples on page 9 of 18 week 3 notes (Copy Right Laurate Education Inc.)*/

import javax.swing.*;// makes the JOptionPane class available for use

public class NumberToMonth
{
	//-------Main Method-------

	public static void main(String[ ] args)
		{
			//Declarations of variables moved to the individual methods to simplify
			String number1;
			welcome();
			do {

				number1 = EnterNumber();
				displayMsg(number1);
			   }while ((JOptionPane.showInputDialog(null, "want to try again? enter yes")) .equals ("yes")); // == did not work here because it's an object
			 goodbye();
		}// end of main method

	public  static String EnterNumber()
		{
			String month, month1;
			//Enter the string that the month number

			month = JOptionPane.showInputDialog("Please enter the month number between 1 and 12:"); //call the input method in JOptionPane

			NameOfMonth MN = new NameOfMonth(); //create an instance of the method NameOfMonth
			month1 = MN.mname(month); // I found out that not creating this instance made no difference

			NameOfMonth.mname(month);

			String Msg1 = "Month that corresponds to the number  " + month + " is " + month1;
			return Msg1;
		} // end of method enter number

	public static void displayMsg(String number1)
		{
			// beginning of method displayMsg
			String JJ = number1;
			JOptionPane.showMessageDialog(null, JJ);//call a screen output method in JOptionPane

		} // end of method displayMsg

	public static void goodbye()
		{ // beginning of method displayMsg

			JOptionPane.showMessageDialog(null, "Thanks for choosing to use my program","Goodbye", JOptionPane.INFORMATION_MESSAGE);

    	} // end of method goodbye method

	public static void welcome()
		{ // beginning of method displayMsg

			JOptionPane.showMessageDialog(null, "Welcome to this month number conversion program","Welcome", JOptionPane.INFORMATION_MESSAGE);

    	} // end of welcome goodbye method

} // end of the class
