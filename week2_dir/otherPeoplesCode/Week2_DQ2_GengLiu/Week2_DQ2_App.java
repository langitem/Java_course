//Travel Speed computing rounding(CKIT-510,OBJECT ORIENTED PROGRAM JAVA.)
//Week2 DQ-2
//Geng Liu
//July 2013
//University of Liverpool, UK

import javax.swing.*;
import java.text.*;
public class Week2_DQ2_App
{
	//Main method
	public static void main(String[ ] args)
	{

		try
		{
		    double kilometres = GetDistanceInKilometres();
		    double travalHours = GetTravelTime();
		    //Create new instance of trip class
		    Trip trip=new Trip(kilometres,travalHours);
		    //Display the travel speed
		    JOptionPane.showMessageDialog(null, String.format("The speed of your traval is: %s Km per Hours",trip.GetSpeed()));
		} catch (Exception e)
		{

		     JOptionPane.showMessageDialog(null, "Error occurs", "Warning",JOptionPane.WARNING_MESSAGE);
		}

	}
	//Get metres from user input
	private static double GetDistanceInKilometres()
	{
		double kilometres=0;
		String inputKilometres = JOptionPane.showInputDialog("Please enter a distance in kilometres:");
		try
		{
			//Convert kilometres from string to integer
			kilometres= Double.parseDouble(inputKilometres);

		} catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid kilometres!", "Warning",JOptionPane.WARNING_MESSAGE);
			System.exit(100);
		}
		return kilometres;
	}
	//Get metres from user input
	private static double GetTravelTime()
	{
		double travelHours=0;
		String inputTravelHours = JOptionPane.showInputDialog("Please enter the travel time in hours:");
		try
		{
			//Convert time from string to integer
			travelHours= Double.parseDouble(inputTravelHours);
		} catch (NumberFormatException e)
		{
			JOptionPane.showMessageDialog(null, "Invalid travel hours!", "Warning",JOptionPane.WARNING_MESSAGE);
			System.exit(100);
		}
		return travelHours;
	}

}