/**
 * Super-class representing a Short Address.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class ShortAddress {

	protected String firstName;
	protected String secondName;
	protected String phoneNumber;
    
    public ShortAddress() {
    }

   /**
	* Overloaded constructor for an instance of a Short Address object. 
	* @param    aFirstName       the first name.
    * @param    aSecondName      the second name.
    * @param    aPhoneNumber     the phone number.      
    * @see      String      
    */
	public ShortAddress(String aFirstName, String aSecondName, String aPhoneNumber){
	    firstName = aFirstName;
	    secondName = aSecondName;
	    phoneNumber = aPhoneNumber;
	}

   /**
    * Sets the first name. 
    * @param    String    the first name.
    * @see      String
    */ 
	public void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

   /**
    * Sets the second name. 
    * @param    String    the second name.
    * @see      String
    */ 
    public void setSecondName(String aSecondName) {
        secondName = aSecondName;
    }

   /**
    * Sets the phone number. 
    * @param    String    the phone number.
    * @see      String
    */ 
    public void setPhoneNumber(String aPhoneNumber) {
        phoneNumber = aPhoneNumber;
    }


   /**
    * The toString method for this super-class. 
    * @return   a string containing the class' attributes.
    * @see      String
    */ 
	public String toString() {
		return firstName  + " " + secondName + ",\nTel:" + phoneNumber;
	}
}