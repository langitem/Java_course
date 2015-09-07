/************************************************************
 * John Audu		   			            *
 * July 2013                                                *
 * The University of Liverpool, UK                          *
 * Week3 DQ1 Submission                                     *
 * NameOfMonth class for finding the greater of two numbers *
 ***********************************************************/

import javax.swing.*;

public class NameOfMonth
	{

    		public static String mname(String month) //this was declared as String in the calling class
		
		/* took out the void to ensure that it return a value . Source:
		http://docs.oracle.com/javase/tutorial/java/javaOO/returnvalue.html*/
			{

				String Name = "none"; //initializing the string variable, name
								
				Integer MNI = new Integer(month);// convert the input from the main class to an integer

				if (MNI == 1) // adapted this if...elseif...else statement from (Deitel & Deitel, 2012)
					Name = "January";// assignment statement
				else if (MNI == 2)  // comparison operator. = return error.
					Name = "February";
				else if (MNI == 3) 
					Name = "March";
				else if (MNI == 4)
					Name = "April";
				else if (MNI == 5) 
					Name = "May";
				else if (MNI == 6) 
					Name = "June";
				else if (MNI == 7) 
					Name = "July";
				else if (MNI == 8) 
					Name = "August";
				else if (MNI == 9) 
					Name = "September";
				else if (MNI == 10) 
					Name = "October";
				else if (MNI == 11) 
					Name = "November";
				else if (MNI == 12) 
					Name = "December";
				else
					JOptionPane.showMessageDialog(null, "Error, Input number between 1 and 12 only");//call a screen output method in JOptionPane
									
				return Name; // this returns the required month's name or none
   			}
	}
