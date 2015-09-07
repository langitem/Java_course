//Week 2 DQ1
// Ozgur Ozden

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

public class Bye

{
   // display a welcome message to the user
   public void displayMessage()
   {

	JFrame frame = new JFrame();

    ImageIcon icon = new ImageIcon("exit.png");
   // show a joptionpane dialog using showMessageDialog
	 JOptionPane.showMessageDialog(frame, "Thank you for using my conversion program", "Bye!",
	 JOptionPane.PLAIN_MESSAGE, icon);



   } // end method displayMessage
} // end class greeting
