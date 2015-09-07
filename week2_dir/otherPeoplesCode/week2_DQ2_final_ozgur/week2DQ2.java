//Week 2 DQ1
// Ozgur Ozden
// 11.7.2013

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import javax.swing.*;

public class week2DQ2 {
public static void main(String[] args) {
float distance_meters ;
int velocitykmhr, velocityms ;

// create a greeting object and assign it to greetingMessage
greeting greetingMessage = new greeting();

// lets call welcomeMessage's displayMessage method
greetingMessage.displayMessage();

// Lets create a custom panel ( Help taken from Ref: http://stackoverflow.com/questions/6555040/multiple-input-in-joptionpane-showinputdialog)
      JTextField xField = new JTextField(7);
      JTextField yField = new JTextField(7);

      JPanel myPanel = new JPanel();
      myPanel.add(new JLabel("Distance in km :"));
      myPanel.add(xField);
      myPanel.add(Box.createHorizontalStrut(15)); // a spacer
      myPanel.add(new JLabel("Time in hr :"));
      myPanel.add(yField);

      int result = JOptionPane.showConfirmDialog(null, myPanel,
               "Please Enter Distance (km) and time (hr)", JOptionPane.OK_CANCEL_OPTION);
      if (result == JOptionPane.OK_OPTION) {

     JFrame frame = new JFrame();

      // Converts strings xfield and y field to distance to float.
      float distance_covered = Float.valueOf(xField.getText());
      float time_covered = Float.valueOf(yField.getText());


      // Calculations and rounding to the nearest km
      velocitykmhr = Math.round( distance_covered / time_covered );

      // Display message joptionpane rounded to nearest km
      JOptionPane.showMessageDialog(frame," The velocity of the object is " + velocitykmhr + " km / hr","Result in km / hr?",JOptionPane.INFORMATION_MESSAGE);

      velocityms = (( velocitykmhr*1000)/3600);

      // Display message joptionpane rounded to nearest km
      JOptionPane.showMessageDialog(frame," The velocity of the object is " + velocityms + " m / s ","Result in m / s",JOptionPane.INFORMATION_MESSAGE);


      // create a Bye object and assign it to byeMessage
      Bye byeMessage = new Bye();

      // lets call byeMessage's displayMessage method
      byeMessage.displayMessage();

      }

   }
}