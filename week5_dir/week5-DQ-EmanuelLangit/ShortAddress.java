// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// ShortAddress.java
// ShortAddress class for DQ
// Week 5 DQ
// August 4, 2013


public class ShortAddress {
	
	protected String firstName;
	protected String secondName;
	protected long phoneNumber;
	
	// no argument constructor
	public ShortAddress() {
		firstName = "";
		secondName = "";
		phoneNumber = 0;
	}
	
	// Constructor
	public ShortAddress(String first, String second, long num) {
		firstName = first;
		secondName = second;
		phoneNumber = num;
	}
	
	public void setFirstName(String fName) {
		firstName = fName;
	}
	
	public void setSecondName(String sName) {
		secondName = sName;
	}
	
	public void setPhoneNumber(int number) {
		phoneNumber = number;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getSecondName() {
		return secondName;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s\n%s: %s\n%s: %s",
				"First Name", firstName,
				"Second Name", secondName,
				"Phone Number", phoneNumber);
	}

}
