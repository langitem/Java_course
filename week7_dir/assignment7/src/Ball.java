import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	private int diameter; // default diameter of 10
	private Color myColor;
	private int x;
	private int y;
	private int changeInX;
	private int changeInY;

	
	// no argument constructor to set color to blue:
	public Ball() {
		myColor = Color.BLUE;
		x = 0;
		y = 0;
		changeInX = 1;
		changeInY = 1;
		diameter = 50;
	}
	
	// constructor that initializes the coordinates and color to the values of the
	// arguments supplied
	public Ball(int x, int y, int changeInX, int changeInY, int diameter, Color myColor) {
		this.x = x;
		this.y = y;
		this.changeInX = changeInY;
		this.changeInY = changeInY;
		this.diameter = diameter;
		this.myColor = myColor;
	}
	
	public void setX(int x) {
		if (x >= 0) {
			this.x = x;
		} else {
			this.x = 0;
		}
	}
	
	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		if ( y >= 0 ) {
			this.y = y;
		} else {
			this.y = 0;
		}
	}
	
	public int getY() {
		return y;
	}
	
	public void setchangeInX(int changeInX) {
		if ( changeInX >= 0 ) {
			this.changeInX = changeInX;
		} else {
			this.changeInX = 0;
		}
	}
	
	public int getchangeInX() {
		return changeInX;
	}
	
	public void setchangeInY(int changeInY) {
		if ( changeInY >= 0 ) {
			this.changeInY = changeInY;
		} else {
			this.changeInY = 0;
		}
	}
	
	public int getchangeInY() {
		return changeInY;
	}
	
	public void setColor (Color color) {
		myColor = color;
	}
	
	public Color getColor () {
		return myColor;
	}
	
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawOval(getX(), getY(), diameter, diameter);
		g.fillOval(getX(), getY(), diameter, diameter);
	}

}