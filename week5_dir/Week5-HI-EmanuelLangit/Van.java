// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Van.java
// Van class for assignment 5
// Week 5 Assignment
// August 7, 2013

public class Van extends Vehicle {
	
	private float weight;
	
	public Van (String manufac, String mod, int day, int month, int year, float w ) {
		super(manufac, mod, day, month, year);
		setWeight(w);
	}
	
	public void setWeight(float w) {
		if (w > 0) {
			weight = w;
		}
	}
	
	public float getWeight() {
		return weight;
	}
	
	@Override
	public float getTax() {
		if (weight < 3500) {
			return 165;
		} else {
			return 190;
		}
	} // end of getTax method
	
	@Override
	public String toString() {
		return super.toString() + String.format("%s: %.2f %s\n", "Weight", weight, "kg");
	}

}
