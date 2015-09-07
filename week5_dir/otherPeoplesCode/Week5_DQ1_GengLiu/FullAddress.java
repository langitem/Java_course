//Full Address class
//Geng Liu
//August 2013
//The University of Liverpool, UK
public class FullAddress extends ShortAddress
{
	public int houseNumber;
	public String street1Name;
	public String street2Name;
	public String cityName;


	public FullAddress(String firstName,String secondName,String phoneNumber,int houseNumber,String street1Name,String street2Name,String cityName)
	{
		super(firstName,secondName,phoneNumber);
		this.houseNumber=houseNumber;
		this.street1Name=street1Name;
		this.street2Name=street2Name;
		this.cityName=cityName;
	}

	@Override
	public String getAddressInformation()
	{
		String message="FirstName: %s\nSecond Name: %s\nPhone Number: %s\nHouse Number:%s\nStreet Name 1:\nStreet Name 2:\nCity Name:%s";
		return String.format(message,super.firstName,super.secondName,super.phoneNumber,this.houseNumber,this.street1Name,this.street2Name,this.cityName);
	}
	public String getAddressInformationSuper()
	{
		return super.getAddressInformation();
	}
}

