// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Triangle.java
// Triangle class for Week 3 Assignment
// Week 3 Assignment
// July 24, 2013

public class Triangle {
	
	private float side1;
	private float side2;
	private float side3;
	
	// no argument constructor
	public Triangle() {
		this(0, 0, 0); // initialize all 3 instance variables
	}
	
	// constructor with all sides supplied
	public Triangle(float initialSide1, float initialSide2, float initialSide3) {
		
		side1 = initialSide1;
		side2 = initialSide2;
		side3 = initialSide3;
	}
	
	// setters for instance variables:
	public void setSide1(float length) {
		side1 = length;
	}
	
	public void setSide2(float length) {
		side2 = length;
	}
	
	public void setSide3(float length) {
		side3 = length;
	}
	
	// getters for instance variables:
	public float getSide1() {
		return side1;
	}
	
	public float getSide2() {
		return side2;
	}
	
	public float getSide3() {
		return side2;
	}
	
	// method to determine triangle type
	public String getTriangleType() {
		String triangleType = null;
		
		if ((side1 == side2) && (side2 == side3)) {
			triangleType = "equilateral";
		} else if ((side1 != side2) && (side1 != side3) && (side2 != side3)) {
			triangleType = "scalene";
		} else {
			triangleType = "isosceles";
		}
		
		return triangleType;
		
	} // end of getTriangleType method

}
