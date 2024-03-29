// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// SwimmingPool.java
// Swimming Pool class
// Week 2 Hand-in assignment
// July 17, 2013

public class SwimmingPool {
	
	private float width;
	private float length;
	private float depth;
	
	// no argument constructor
	public SwimmingPool() {
		this(0, 0, 0); // initialize all 3 instance variables to zero
	}
	
	// constructor with width, length and depth supplied
	public SwimmingPool(float initialWidth, float initialLength, float initialDepth) {
		if ((initialWidth >= 0) && (initialLength >= 0) && (initialDepth >= 0)) {
			width = initialWidth;
			length = initialLength;
			depth = initialDepth;
		}
	}
	
	// method to set width
	public void setWidth(float w) {
		width = w;
	}
	
	// method to set length
	public void setLength(float l) {
		length = l;
	}
	
	// method to set depth
	public void setDepth(float d) {
		depth = d;
	}
	
	// method to get width
	public float getWidth() {
		return width;
	}
	
	// method to get length
	public float getLength() {
		return length;
	}
	
	// method to get depth
	public float getDepth() {
		return depth;
	}
	
	// method to get volume in liters
	public float getVolume() {
		return width * length * depth * 1000;
	}
	
}
