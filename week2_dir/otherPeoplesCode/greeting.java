//Week 2 DQ1
// Ozgur Ozden

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class greeting

{
   // display a welcome message to the user
   public void displayMessage()
   {

	JFrame frame = new JFrame();
    ImageIcon icon = new ImageIcon("car.png");

   // show a joptionpane dialog using showMessageDialog
	  JOptionPane.showMessageDialog(frame,
	           "Welcome to my Conversion program\nThis program Calculates the velocity\nof the object in tems of km/hr and m/s\nfor given ditance and time. ",
	           "Conversion!",
      JOptionPane.PLAIN_MESSAGE,icon);


   } // end method displayMessage
} // end class greeting
