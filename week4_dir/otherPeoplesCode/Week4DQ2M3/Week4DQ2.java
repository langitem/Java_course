//Week 4 DQ2 Assignment
//Designed by Fatai Oseni
//28th July 2013

//The application is to answer Week4 DQ2 assignment stated below
/*
Week 4 DQ2- Square
Week 4 DQ2: : Post your Java GUI solutions, you can either use JOptionPane to design the input and output,
or you may want to use Swing components to design the interface. Write and run a Java program which allows
the user to input a double and outputs the square of this number.
*/

import javax.swing.*;
public class Week4DQ2
{
	//main method begins program execution
	public static void main(String[] args)
	{
        SwingUtilities.invokeLater(new Runnable()
        {
           public void run()
            {
                //create instance of class CurrencyConverter
                SquareNumber newSquare = new SquareNumber();
                newSquare.setVisible(true);
            }
        });
    }// end main method
}// end Week4DQ2 class