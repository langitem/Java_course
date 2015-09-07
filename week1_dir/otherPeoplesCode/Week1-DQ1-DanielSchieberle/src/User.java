// User.java
// User class representing a user's name and birthday
// Author: Daniel Schieberle
// Last Update: July 7th 2013

// User class declaration
public class User {

	// Declaring properties
	String name;
	String birthday;
	
	// Constructor
	public User() {}
	
	// Setter for name property
	public void setName(String name) throws UserInputException {
		this.name = name;
		if (this.name == null || (this.name != null && ("".equals(this.name)))) {
			throw new UserInputException("No name provided");
		}
	}

	// Getter for name property
	public String getName() {
		return this.name;
	}

	// Setter for birthday property	
	public void setBirthday(String birthday) throws UserInputException  {
		this.birthday = birthday;
		if (this.birthday == null || (this.birthday != null && ("".equals(this.birthday)))) {
			throw new UserInputException("no birthday provided");
		}		
	}
	
	
	// Getter for birthday property		
	public String getBirthday() {
		return this.birthday;
	}

} // end class User
