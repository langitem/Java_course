import java.awt.Color;
import java.awt.Graphics;

public class Assignment8Line extends Assignment8Shape {
	
	/*
	 * Class MyLine should provide a no-argument constructor and a constructor with arguments for
	 * the coordinates and color.
	 */
   
   // constructor with input values
   public Assignment8Line( int x1, int y1, int x2, int y2, Color color ) {
	   super( x1, y1, x2, y2, color );
   } // end MyLine constructor
   
   /*
    * A constructor with no arguments that sets the shape�s coordinates to 0, the color of the
    * shape to Color.BLACK, and the filled property to false (MyRectangle and MyOval only).
    */
	public Assignment8Line() {
		super();
	}
   
   // Actually draws the line
   public void draw( Graphics g ) {
      g.setColor( getColor() );
      g.drawLine( getX1(), getY1(), getX2(), getY2() );
   } // end method draw
	

}
