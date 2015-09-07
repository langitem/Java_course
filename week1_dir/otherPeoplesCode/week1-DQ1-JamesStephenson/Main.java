/**
 * Class from which to run the application.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		Application theApplication = new Application("Skynet");//initialise the application
		theApplication.welcomeUser();
		theApplication.requestUserName();
		theApplication.requestUserDateOfBirth();
		theApplication.confirmUserDetails();
		System.exit(0);//exit the program
	}
}