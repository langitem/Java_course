// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Driver.java
// Application used to test application class
// Week 1 Hand-in assignment
// July 10, 2013

public class Driver {
	
	public static void main (String[] args) {
		
		Application myApplication = new Application(); // create instance of Application class
		
		myApplication.greeting();
		myApplication.getName();
		myApplication.getAge();
		myApplication.displayMessages();
		myApplication.displayAgeInTenYears();
	}

}
