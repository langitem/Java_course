// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// DQ1Application.java
// Application class for DQ1
// DQ1
// July 14, 2013

import javax.swing.JOptionPane;

public class DQ1Application {
	
	private float distanceInMeters = 0;
	private float distanceInKilometers = 0;
	private String metersString = "";
	private String kmString = "";
	
	// method to display greeting
	public void displayGreeting() {
		JOptionPane.showMessageDialog(null, "Welcome! this program converts meters into kilometers");
	} // end of displayGreeting method
	
	// method to get distance in meters
	public void getDistanceInMeters() {
		
		metersString = JOptionPane.showInputDialog(null, "Enter a distance in meters to be converted into kilometers", JOptionPane.QUESTION_MESSAGE);
		distanceInMeters = Float.parseFloat(metersString);
		
	} // end of getDistanceInMeters method
	
	// method to display distance in kilometers
	public void displayDistanceInKm() {
		
		int kmInteger = convertMetersToKm(distanceInMeters);
		kmString = Integer.toString(kmInteger);
		
		String message = metersString + " meters, when rounded equals " + kmString + " km.";
		
		JOptionPane.showMessageDialog(null, message, "Meters to Kilometers", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	// method to convert meters into kilometers
	private int convertMetersToKm(float meters) {
		// divide meters by 1000 to convert into kilometers
		distanceInKilometers = meters / 1000;
		
		// round km to nearest whole number
		int kmRoundedToInteger = (int)(Math.round(distanceInKilometers));
		System.out.printf("%d\n", (Math.round(distanceInKilometers)));
		
		return kmRoundedToInteger;
	} // end of convertMetersToKm method
	
} // end of DQ1Application class
