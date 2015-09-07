/**
 * Class representing a user of the application.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class User {
	private String name;
	private String dateOfBirth;	


   /**
	* Default constructor for an instance of a User object. 
	*/
	public User(){

	}

   /**
	* Sets the user's name to the value of a String parameter. 
	* @param  aName  a name
	* @see           String
	*/
	public void setName(String aName) {
		name = aName;
	} 

   /**
	* Sets the user's date of birth to the value of a String parameter. 
	* @param  aDate  a date of birth in string format
	* @see           String
	*/
	public void setDateOfBirth(String aDate) {
		dateOfBirth = aDate;
	}

   /**
	* Returns a String representing the user's name. 
	* @return      the name attribute
	* @see         String
	*/
	public String getName() {
		return name;
	}

   /**
	* Returns a String representing the user's date of birth. 
	* @return      the dateOfBirth attribute
	* @see         String
	*/
	public String getDateOfBirth() {
		return dateOfBirth;
	}
}