/* This is the Class driver for my first java program for week 1 DQ1
   AUTHOR : OZGUR OZDEN
   DATE CREATED : 5/7/2013 */





import javax.swing.JOptionPane;

public class week1DQ1Driver
{
   // main method begins program execution
   public static void main( String[] args )
   {
      // create a Welcome object and assign it to WelcomeMessage
      Welcome WelcomeMessage = new Welcome();

      // lets call welcomeMessage's displayMessage method
      WelcomeMessage.displayMessage();

      // Command for name message
	  String name = JOptionPane.showInputDialog( "What is your name?" );

      // Command for DOB
      String $age = JOptionPane.showInputDialog( "Please enter you date of birth as mm/dd/year?" );

      // create the message
      String message = String.format( "%s, Welcome to Java Programming!", name );
	  String message1 = String.format( "%s  your date of birth is %s \n Thank you for using my first Java program", name, $age );

      // display the message to the user by name and DOB
      JOptionPane.showMessageDialog( null, message );
      JOptionPane.showMessageDialog( null, message1 );
   } // end main
} // end class week1DQ1

