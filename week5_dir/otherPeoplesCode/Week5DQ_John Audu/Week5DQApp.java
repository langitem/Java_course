// Week5DQApp.java
// John Audu
// August 2013
// The university of Liverpool, UK

import java.io.*;
import javax.swing.*;

class Week5DQApp
{
	//private int houseN;
	private static String firstName1, secondName1, phoneNumber1, street1Name1, street2Name1, cityName1, houseNumber1;

// Main method

public static void main (String[] args)
	{
		welcome();
		AddressDetails();
		int houseN = Integer.parseInt(houseNumber1);
		FullAddress fa = new FullAddress(firstName1, secondName1, phoneNumber1, street1Name1, street2Name1, cityName1, houseN);
		ShortAddress sa = new ShortAddress(firstName1, secondName1, phoneNumber1);

		String Q = JOptionPane.showInputDialog(null, "Which address do you want to print (enter S for short or L for long)?","Choose Address Type",JOptionPane.QUESTION_MESSAGE);

 		if (Q.equals("S"))
 			{
 				sa.outputDetail();
			}

 		else
 			{
 		        fa.outputDetails();
			}

	}

public static void welcome()
	{
	JOptionPane.showMessageDialog(null, "This program allows you to input addresses and out \n either the short or long version");
	}

public static void AddressDetails()
	{
		boolean reEneterValue=false;
	do {

		try {
				firstName1 = JOptionPane.showInputDialog(null, "Input the first name");
				secondName1 = JOptionPane.showInputDialog(null, "Input the second name");
				phoneNumber1 = JOptionPane.showInputDialog(null, "Input the phone number");
				street1Name1 = JOptionPane.showInputDialog(null, "Input street name 1");
				street2Name1 = JOptionPane.showInputDialog(null, "Input street name 2");
				cityName1 = JOptionPane.showInputDialog(null, "Input the city name");
				houseNumber1 = JOptionPane.showInputDialog(null, "Input the house number");
			}
				catch(NullPointerException e)
				//catch(Exception e)
				{
					System.out.println("You have an error. Please try again.");
					reEneterValue=true;
				}
       }while (reEneterValue);
	}

}