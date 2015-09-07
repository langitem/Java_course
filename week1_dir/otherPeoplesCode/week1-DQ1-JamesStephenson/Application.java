import javax.swing.JOptionPane; 
/**
 * Class representing an application.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class Application {

	private String name;
	private User theUser;
	private final int NAME = 1;
	private final int DOB = 2;

   /**
	* Default constructor for an instance of an Application object. 
	*<p>
	* For convenience, in this DQ I chose to include a User object as an attribute of this class, which is initialised in the constructor. This makes the code in Main.java easier to read.   
	* @param  aName  a name in string format
	* @see           String
	* @see           User
	*/
	public Application(String aName){
		name = aName;
		theUser = new User();
	}

   /**
	* Opens the first JOptionPane. 
	* @see           JOptionPane
	*/
	public void welcomeUser() {
		JOptionPane.showMessageDialog(null, "Welcome to " + name + "!", name, JOptionPane.PLAIN_MESSAGE);
	}

	/**
	* Opens the second JOptionPane. 
	* @see           JOptionPane
	*/
	public void requestUserName() {
		String aName = JOptionPane.showInputDialog(null, "What is your name?", "Input", JOptionPane.INFORMATION_MESSAGE);
		validateUserDetails(NAME, aName);
	}

   /**
	* Opens the third JOptionPane. 
	* @see           JOptionPane
	*/
	public void requestUserDateOfBirth() {
		String aDateOfBirth = JOptionPane.showInputDialog(null, "What is your birth date?", "Input", JOptionPane.INFORMATION_MESSAGE);
		validateUserDetails(DOB, aDateOfBirth);
	}

   /**
	* Opens the fourth JOptionPane. 
	* @see           JOptionPane
	*/
	public void confirmUserDetails() {
		String html = "<html><body><p>" + theUser.getName() + " (" + theUser.getDateOfBirth() + ") is logged in.</p><p>Thank you for using " + name + "!</p></body></html>";//HTML is used to produce new lines 
		JOptionPane.showMessageDialog(null, html, name, JOptionPane.INFORMATION_MESSAGE);
	}

   /**
	* Validates the user's input before using it to set one of the user's attributes. 
	*<p>
	* For convenience, in this DQ I chose to encapsulate the validation checks in this method in order to reduce duplication.   
	* @param  aCase  	a number indicating which attribute to set.
	* @param  userInput the user's input 
	* @see           	int
	* @see           	String
	*/
	public void validateUserDetails(int aCase, String userInput) {
		if(userInput == null || userInput.isEmpty()) {
			System.exit(0);//exit the application if the user does not enter a date of birth
		} else {
			switch(aCase) {
				case NAME:
					theUser.setName(userInput);
					break;
				case DOB:
					theUser.setDateOfBirth(userInput);
					break;
				default: //
					System.exit(0);//exit the application if a valid case was not provided as a parameter
					break;	
			}
		}
	}
}