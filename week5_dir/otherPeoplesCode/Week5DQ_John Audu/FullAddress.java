//FullAddress.java
// John Audu
// August 2013
// The university of Liverpool, UK

import java.io.*;

class FullAddress extends ShortAddress{
// --- Fields ---
private int houseNumber1;
private String name1,name2,pnn,street1Name1, street2Name1,cityName1;

// --- Constructor ---

public FullAddress (String n1, String n2, String pn, String more1, String more2, String more3,int hN){
	super(n1,n2,pn);
	name1=n1;
	name2=n2;
	pnn=pn;
	street1Name1 = more1;
	street2Name1 = more2;
	cityName1 = more3;
	houseNumber1 = hN;
}

// --- Methods ---

public void outputDetails(){
	System.out.println("Name is  " +name1+""+name2);
	System.out.println("Phone Number is "+pnn);
	System.out.println("First Street Name is "+street1Name1);
	System.out.println("Second Street Name is "+street2Name1+" House Number is "+houseNumber1);
	System.out.println("The Name of the City is "+cityName1);
	}
}