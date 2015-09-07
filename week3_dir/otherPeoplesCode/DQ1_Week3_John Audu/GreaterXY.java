/**********************************************************
 * John Audu		   			          *
 * July 2013                                              *
 * The University of Liverpool, UK                        *
 * Week3 DQ1 Submission                                   *
 * GreaterXY class for finding the greater of two numbers *
 *********************************************************/

import javax.swing.*;

public class GreaterXY
	{

    		public static double gr81(double number1, double number2) //these arguements were declared as double in the calling class
		
		/* took out the void to ensure that it return a value . Source:
		http://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html*/
			{
				double X=0;//initialize X to avoid errors with the return statement

				if (number1 > number2) // adapted this if, elseif statement from (Deitel & Deitel, 2012)
					X = number1;
				else if (number1 < number2)
					X = number2;
				else
					{
						JOptionPane.showMessageDialog(null, "both numbers are equal");//call a screen output method in JOptionPane
						GreaterOf2Numbers.goodbye();
						System.exit (0); // this ends the program 
					}
				
				return +X; // this returns the greater of the two numbers
   			}
	}
