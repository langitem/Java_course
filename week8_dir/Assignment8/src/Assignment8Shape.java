import java.awt.Color;
import java.awt.Graphics;

public abstract class Assignment8Shape {
	
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private Color myColor;
	
	// A no-argument constructor that sets all the coordinates of the shape to 0 and the color to Color.BLACK.
	public Assignment8Shape() {
		x1 = 0;
		y1 = 0;
		x2 = 0;
		y2 = 0;
		myColor = Color.BLACK;
	} // end of no-argument constructor
	
	// A constructor that initializes the coordinates and color to the values of the arguments supplied.
	public Assignment8Shape(int x1, int y1, int x2, int y2, Color c) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		myColor = c;
	} // end of constructor
	
	public void setX1(int x1) {
		if (x1 >= 0) {
			this.x1 = x1;
		} else {
			this.x1 = 0;
		}
	}
	
	public int getX1() {
		return x1;
	}
	
	public void setY1(int y1) {
		if (y1 >= 0) {
			this.y1 = y1;
		} else {
			this.y1 = 0;
		}
	}
	
	public int getY1() {
		return y1;
	}
	
	public void setX2(int x2) {
		if (x2 >= 0) {
			this.x2 = x2;
		} else {
			this.x2 = 0;
		}
	}
	
	public int getX2() {
		return x2;
	}
	
	public void setY2(int y2) {
		if (y2 >= 0) {
			this.y2 = y2;
		} else {
			this.y2 = 0;
		}
	}
	
	public int getY2() {
		return y2;
	}
	
	public void setColor (Color color) {
		myColor = color;
	}
	
	public Color getColor () {
		return myColor;
	}
	
	public abstract void draw(Graphics g);

}
