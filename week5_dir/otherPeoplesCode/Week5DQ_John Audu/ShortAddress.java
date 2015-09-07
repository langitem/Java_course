// ShortAddress Class
// John Audu
// August 2013
// The university of Liverpool, UK
// The code closely followed the examplelaid out in Dr. Sam's lecture notes for week 5 (Laureate Education B.V. (2000-2008)

import java.io.*; // for basic input / output operations

class ShortAddress{
// Declare variables

protected String firstName, secondName, phoneNumber; // protected members of this superclass can be assessed by subclass methods

// Create Constructor

public ShortAddress(String n1, String n2, String pn){
	firstName = n1;
	secondName = n2;
	phoneNumber = pn;
	}
// Methods

public void outputDetail(){
	System.out.println("Short Address:");
	System.out.println("The name is "+firstName+secondName);
	System.out.println("Phone Number is "+phoneNumber);
	//System.out.println("");

	}
}