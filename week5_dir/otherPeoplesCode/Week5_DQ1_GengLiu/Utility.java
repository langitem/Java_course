//Utility class
//Geng Liu
//August 2013
//The University of Liverpool, UK
import javax.swing.*;
public class Utility
{

 	public static void ShowInfomationMessage(String message,String title)
	{
		JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
	}

	public static String ShowInputDialog(String message)
	{
		return JOptionPane.showInputDialog(message);
	}

	public static void ShowWarningMessage(String message)
	{
		JOptionPane.showMessageDialog(null, message, "Warning", JOptionPane.WARNING_MESSAGE);
	}

	public static int ShowConfirmDialog(String message)
	{
		return JOptionPane.showConfirmDialog(null, message, "Exit", JOptionPane.YES_NO_OPTION);

	}


}

