// Emanuel Langit
// elangit@smccd.edu
// CIS 255 WJ
// MyOval.java
// MyOval class representation of an oval.
// Assignment #6
// April 19, 2012

import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyBoundedShape{
	
	/*
	 * A constructor with no arguments that sets the shape’s coordinates to 0, the color of the
	 * shape to Color.BLACK, and the filled property to false (MyRectangle and MyOval only).
	 */
	public MyOval() {
		super();
	}
	
	// Declare a constructor in each class with arguments for initializing all the instance variables.
	public MyOval( int x1, int y1, int x2, int y2, Color color, boolean shapeFilled )
	{
		super( x1, y1, x2, y2, color, shapeFilled );

	} // end MyOval constructor
		
	public void draw( Graphics g ) {
		if ( getFilled() ) {
			//g.setColor( getColor() );
			g.fillOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		} else {
			g.drawOval( getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight() );
		}
	}
	
} // end of MyOval class
