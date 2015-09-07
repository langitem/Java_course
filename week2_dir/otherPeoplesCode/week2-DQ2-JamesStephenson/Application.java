import javax.swing.JOptionPane; 
/**
 * Class representing an application.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class Application {

   private final String GET_DISTANCE_TITLE = "Get Distance in kilometres";
   private final String GET_DISTANCE_MESSAGE  = "Select a distance in kilometres";
   private final String GET_TIME_TITLE = "Get Time in hours";
   private final String GET_TIME_MESSAGE  = "Select a time in hours";
   private final String DEFAULT_DISTANCE = "2500";
   private final String DEFAULT_TIME = "12";
   private final String DISPLAY_TITLE = "Result";

   private final int MAX_KILOMETRES = 5000;
   private final int MIN_KILOMETRES = 0;
   private final int MAX_HOURS = 24;
   private final int MIN_HOURS = 0;


   /**
	* Default constructor for an instance of an Application object. 
	*/
	public Application(){
	}

   /**
	* Runs the application.
	*/
	public void run() {
		String theDistanceInKilometres = getDistanceInKilometres(); 
		String theTimeInHours = getTimeInHours(); 
		displayAverageSpeed(theDistanceInKilometres, theTimeInHours);   
    }

   
   /**
	* Opens the first JOptionPane for the user to enter a distance in kilometres. 
	* @return      a distance in kilometres as a string 
	* @see         JOptionPane
	* @see         Integer
	* @see         String
	* @see         Object
	*/
	public String getDistanceInKilometres() {
		Object[] kilometres = new String[MAX_KILOMETRES];
		for(int i=MIN_KILOMETRES;i<MAX_KILOMETRES;i++) {
			kilometres[i] = Integer.toString(i + 1);
		}
		String aDistance = (String)JOptionPane.showInputDialog(null, GET_DISTANCE_MESSAGE, GET_DISTANCE_TITLE, JOptionPane.INFORMATION_MESSAGE, null, kilometres, DEFAULT_DISTANCE);
		if(aDistance == null || aDistance.isEmpty()) {
			aDistance = getDistanceInKilometres(); //recursively call this function until the user enters a distance
		} 
		return aDistance;
	}

   /**
	* Opens the second JOptionPane for the user to enter a time in hours. 
	* @return      a time in hours as a string 
	* @see         JOptionPane
	* @see         Integer
	* @see         String
	* @see         Object
	*/
	public String getTimeInHours() {
		Object[] hours = new String[MAX_HOURS];
		for(int i=MIN_HOURS;i<MAX_HOURS;i++) {
			hours[i] = Integer.toString(i + 1);
		}
		String aTime = (String)JOptionPane.showInputDialog(null, GET_TIME_MESSAGE, GET_TIME_TITLE, JOptionPane.INFORMATION_MESSAGE, null, hours, DEFAULT_TIME);
		if(aTime == null || aTime.isEmpty()) {
			aTime = getTimeInHours(); //recursively call this function until the user enters a time
		} 
		return aTime;
	}

   /**
	* Calculates the speed.
	* @param aDistanceInKilometres 	the distance in kilometres as a string 	
	* @param aTimeInHours			the time in hours as a string 	
	* @see 		Float
	*/
	public float calculateAverageSpeed(String aDistanceInKilometres, String aTimeInHours) {
		return (Float.parseFloat(aDistanceInKilometres)) / (Float.parseFloat(aTimeInHours));
	}
   
   /**
	* Opens the final JOptionPane.
	* @param aDistanceInKilometres 	the distance in kilometres as a string 	
	* @param aTimeInHours			 	the time in hours as a string 	
	* @see 		JOptionPane
	* @see 		Float
	*/
	public void displayAverageSpeed(String aDistanceInKilometres, String aTimeInHours) {
		float averageSpeed = calculateAverageSpeed(aDistanceInKilometres, aTimeInHours);
		String theMessage = "The average speed is " + (int)Math.round(averageSpeed) + " kilometres per hour."; 
		JOptionPane.showMessageDialog(null, theMessage, DISPLAY_TITLE, JOptionPane.INFORMATION_MESSAGE);
	}

}