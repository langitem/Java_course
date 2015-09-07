/**
 * Class representing a Full Address.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class FullAddress extends ShortAddress {

	private int houseNumber;
	private String street1Name;
	private String street2Name;
	private String cityName;
    
    public FullAddress() {
    }

   /**
	* Overloaded constructor for an instance of a Full Address object.
	* @param    aFirstName       the first name.
    * @param    aSecondName      the second name.
    * @param    aPhoneNumber     the phone number.   
    * @param    aHouseNumber     the house number.   
    * @param    aStreet1Name     the street1 name.   
    * @param    aStreet2Name     the street2 name.   
    * @param    aCityName        the city name.      
    * @see      String  
    * @see      int       
	*/
	public FullAddress(String aFirstName, String aSecondName, String aPhoneNumber, int aHouseNumber, String aStreet1Name, String aStreet2Name, String aCityName){
	    super(aFirstName, aSecondName, aPhoneNumber);
	    houseNumber = aHouseNumber;
	    street1Name = aStreet1Name;
	    street2Name = aStreet2Name;
	    cityName = aCityName;
	}

   /**
    * Seta the first name. 
    * @param    String    the first name.
    * @see      String
    */ 
    public void setFirstName(String aFirstName) {
        super.setFirstName(aFirstName);
    }

   /**
    * Sets the second name. 
    * @param    String    the second name.
    * @see      String
    */ 
    public void setSecondName(String aSecondName) {
        super.setSecondName(aSecondName);
    }

   /**
    * Sets the phone number. 
    * @param    String    the phone number.
    * @see      String
    */ 
    public void setPhoneNumber(String aPhoneNumber) {
        super.setPhoneNumber(aPhoneNumber);
    }

   /**
    * Sets the house number. 
    * @param    int        the house number.
    * @see      int
    */
    public void setHouseNumber(int aHouseNumber) {
        houseNumber = aHouseNumber;
    }

   /**
    * Sets the street1 name. 
    * @param    String    the street1 name.
    * @see      String
    */ 
    public void setStreet1Name(String aName) {
        street1Name = aName;
    }
   
   /**
    * Sets the street2 name. 
    * @param    String    the street2 name.
    * @see      String
    */ 
    public void setStreet2Name(String aName) {
        street2Name = aName;
    }

   /**
    * Sets the city name. 
    * @param    String    the city name.
    * @see      String
    */ 
    public void setCityName(String aCityName) {
        cityName = aCityName;
    }

   /**
    * The toString method for this class. 
    * @return   a string containing the class' attributes as well as those of the super-class it extends.
    * @see      String
    */ 
	public String toString() {
		return firstName  + " " + secondName + ",\nTel:" + phoneNumber + ",\n" + houseNumber + " " + street1Name + ",\n" + street2Name + ",\n" + cityName;
	}

   /**
    * A method to use the toString method of the super-class that this class extends. 
    * @return   a string containing the super-class' attributes only.
    * @see      String
    */ 
	public String toParentString() {
		return super.toString();
	}
}