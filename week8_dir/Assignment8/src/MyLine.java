// Emanuel Langit
// elangit@smccd.edu
// CIS 255 WJ
// MyLine.java
// MyLine class representation of a line
// Assignment #5
// March 29, 2012

import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape
{

	/*
	 * Class MyLine should provide a no- argument constructor and a constructor with arguments for
	 * the coordinates and color.
	 */
   
   // constructor with input values
   public MyLine( int x1, int y1, int x2, int y2, Color color )
   {
	   super( x1, y1, x2, y2, color );
   } // end MyLine constructor
   
   /*
    * A constructor with no arguments that sets the shape’s coordinates to 0, the color of the
    * shape to Color.BLACK, and the filled property to false (MyRectangle and MyOval only).
    */
	public MyLine() {
		super();
	}
   
   // Actually draws the line
   public void draw( Graphics g )
   {
      g.setColor( getColor() );
      g.drawLine( getX1(), getY1(), getX2(), getY2() );
   } // end method draw
} // end class MyLine
