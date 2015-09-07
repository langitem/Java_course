//ShortAddress class
//Geng Liu
//August 2013
//The University of Liverpool, UK
public class ShortAddress
{
	public String firstName;
	public String secondName;
	public String phoneNumber;

	public ShortAddress(String firstName,String secondName,String phoneNumber)
	{
		this.firstName=firstName;
		this.secondName=secondName;
		this.phoneNumber=phoneNumber;
	}

	public String getAddressInformation()
	{
		String message="FirstName: %s\nSecond Name: %s\nPhone Number: %s";
		return String.format(message,this.firstName,this.secondName,this.phoneNumber);
	}
}

