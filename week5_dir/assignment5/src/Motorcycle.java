// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Motorcycle.java
// Motorcycle class for assignment 5
// Week 5 Assignment
// August 7, 2013

public class Motorcycle extends Vehicle {
	
	private float engineSize;
	
	public Motorcycle(String manufac, String mod, int day, int month, int year, float size) {
		super(manufac, mod, day, month, year);
		setEngineSize(size);
	}
	
	public void setEngineSize(float size) {
		engineSize = size;
	}
	
	public float getEngineSize() {
		return engineSize;
	}

	@Override
	float getTax() {
		int tax = 0;
		
		if (engineSize <= 150) {
			tax = 15;
		} else if ((engineSize > 150) && (engineSize <= 400)) {
			tax = 30;
		} else if ((engineSize > 400) && (engineSize <= 600)) {
			tax = 45;
		} else {
			tax = 60;
		}
		
		return tax;
	} // end of getTax method
	
	@Override
	public String toString() {
		return super.toString() + String.format("%s: %s %s\n", "Engine Size", engineSize, "cc");
	}

}