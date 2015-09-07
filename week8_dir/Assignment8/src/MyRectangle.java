// Emanuel Langit
// elangit@smccd.edu
// CIS 255 WJ
// MyRectangle.java
// MyRectangle class representation of an rectangle.
// Assignment #6
// April 19, 2012

import java.awt.Color;
import java.awt.Graphics;

/*
 * should include x1, y1, x2, y2 coordinates, a color and a boolean flag
 *  to determine whether the shape is filled.
 */
public class MyRectangle extends MyBoundedShape {
	
	/*
	 * A constructor with no arguments that sets the shape’s coordinates to 0, the color of the
	 * shape to Color.BLACK, and the filled property to false (MyRectangle and MyOval only).
	 */
	public MyRectangle() {
		super();
	}
	
	// Declare a constructor in each class with arguments for initializing all the instance variables.
	public MyRectangle( int x1, int y1, int x2, int y2, Color color, boolean shapeFilled )
	{
		super( x1, y1, x2, y2, color, shapeFilled );
		
	} // end MyRectangle constructor
	
	public void draw( Graphics g ) {
		//g.setColor( getColor() );
		if ( getFilled() ) {
			g.fillRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		} else {
			g.drawRect( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		}
	}
} // end of MyRectangle class
