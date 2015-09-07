// Emanuel Langit
// elangit@smccd.edu
// CIS 255 WJ
// MyBoundedShape.java
// Subclass of MyShape
// Assignment #6
// April 19, 2012

import java.awt.Color;
import java.awt.Graphics;

public abstract class MyBoundedShape extends MyShape {
	
	private boolean shapeFilled;
	
	/*
	 * Class MyBoundedShape should declare two constructors that mimic those of class MyShape,
	 * only with an added parameter to set whether the shape is filled.
	 */
	public MyBoundedShape() {
		super();
		setFilled( false );
	}
	
	public MyBoundedShape( int x1, int y1, int x2, int y2, Color color, boolean filled )
	{
		super( x1, y1, x2, y2, color );
		
		setFilled( filled );

	}
	
	/*
	 * Class MyBoundedShape should also declare get and set methods for manipulating the
	 * filled flag and methods that calculate the upper- left x-coordinate,
	 * upper-left y-coordinate, width and height. 
	 */
	public int getUpperLeftX() {
		return Math.min( getX1(), getX2() );	
	}

	public int getUpperLeftY() {
		return Math.min( getY1(), getY2() );
	}
	
	public int getWidth() {
		return Math.abs( getX2() - getX1() );
	}
	
	public int getHeight() {
		return Math.abs( getY2() - getY1() );
	}
	
	public void setFilled( boolean filled ) {
		shapeFilled = filled;
	}
	
	public boolean getFilled() {
		return shapeFilled;
	}
	
	public void draw( Graphics g ) {
		if ( shapeFilled ) {
			g.setColor( getColor() );
			g.fillOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		} else {
			g.drawOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		}
	} // end of draw method
} // end of MyBoundedShape class
