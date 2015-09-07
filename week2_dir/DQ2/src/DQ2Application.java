// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// DQ2Application.java
// Application class for DQ2
// DQ2
// July 14, 2013

import javax.swing.JOptionPane;

public class DQ2Application {

        private int distance = 0;
        private int timeTraveled = 0;
        private double speed = 0;
        private String distanceString = "";
        private String timeString = "";

        // method to display greeting
        public void displayGreeting() {

                JOptionPane.showMessageDialog(null, "Welcome, this program will calculate your speed");
        }

        // method to get distance and time traveled
        public void getInput() {

                distanceString = JOptionPane.showInputDialog(null, "Please enter the distance traveled in kilometers", JOptionPane.QUESTION_MESSAGE);
                distance = Integer.parseInt(distanceString);

                timeString = JOptionPane.showInputDialog(null, "Please enter the time traveled in hours", JOptionPane.QUESTION_MESSAGE);
                timeTraveled = Integer.parseInt(timeString);

        } // end of getInput method

        // method to display speed
        public void displaySpeed() {

                speed = distance / timeTraveled;
                int speedRounded = (int)(Math.round(speed));
                String speedString = Integer.toString(speedRounded);

                String message = "The speed is " + speedString + " km per hour.";

                JOptionPane.showMessageDialog(null, message, "Speed", JOptionPane.INFORMATION_MESSAGE);

        } // end of displaySpeed method

}
