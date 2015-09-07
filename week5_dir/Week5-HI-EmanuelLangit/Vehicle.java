// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Vehicle.java
// Vehicle class for assignment 5
// Week 5 Assignment
// August 7, 2013

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;

public abstract class Vehicle {
	protected String manufacturer;
	protected String model;
	protected Date registrationDate = null;
	protected DateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	
	// no argument constructor
	public Vehicle() {
		
		manufacturer = "";
		model = "";
		
	}
	
	// constructor with 3 arguments
	public Vehicle(String manufac, String mod, int day, int month, int year) {
		manufacturer = manufac;
		model = mod;
		
		setRegistrationDate(day, month, year);
		
	}
	
	public void setManufacturer(String manufact) {
		manufacturer = manufact;
	}
	
	public void setModel(String m) {
		model = m;
	}
	
	public void setRegistrationDate(int day, int month, int year ) {
		
		String monthString;
		String dayString;
		
		if (month < 10) {
			monthString = "0" + Integer.toString(month);
		} else {
			monthString = Integer.toString(month);
		}
		
		if (day < 10) {
			dayString = "0" + Integer.toString(day);
		} else {
			dayString = Integer.toString(day);
		}
		
		String ddMMyyyy = dayString + monthString + Integer.toString(year);

		try {
			registrationDate = (Date) formatter.parse(ddMMyyyy);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	} // end of setRegistrationDate method
	
	public String getRegistrationDateDDMMMMYYYY() {
		String date = new SimpleDateFormat("dd-MMMM-yyyy").format(registrationDate);
		
		return date;
	}
	
	public Date getRegistrationDateObject() {
		return registrationDate;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	abstract float getTax();
	
	// toString
	public String toString() {
		return String.format("%s: %s\n%s: %s\n%s: %s\n%s: %.2f %s\n", "Manufacturer", manufacturer,
								"Model", model, "Registration Date", getRegistrationDateDDMMMMYYYY(),
								"Tax", getTax(), "GBP");
	}

}
