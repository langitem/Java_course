// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// ShapePanel.java
// ShapePanel class for assignment 8
// Week 8 Assignment
// August 28, 2013

import java.awt.Graphics;
import javax.swing.JPanel;

public class ShapePanel extends JPanel {
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 0;
	private int y2 = 0;
	private int x = 0;
	private int y =0 ;
	private int width = 0;
	private int height = 0;
	private String shape = "";
	
	// draw oval with specified coordinates:
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		if (shape.contentEquals("line")){
			g.drawLine(x1, y1, x2, y2);
		} else if (shape.contentEquals("oval")) {
			g.drawOval(x, y, width, height);
		} else if (shape.contentEquals("rectangle")) {
			g.drawRect(x, y, width, height);
		}
		repaint();
	} // end method paintComponent
	
	// validate and set coordinates
	public void setCoordinates(int num1, int num2, int num3, int num4, String newShape) {
		
		shape = newShape;
		
		if (shape.contentEquals("line")) {
			// if coordinates are invalid, default to zero
			x1 = ((num1 >= 0) && (num1 < 500) ? num1 : 0);
			y1 = ((num2 >= 0) && (num2 < 500) ? num2 : 0);
			x2 = ((num3 >= 0) && (num3 < 500) ? num3 : 0);
			y2 = ((num4 >= 0) && (num4 < 500) ? num4 : 0);
		} else if (shape.contentEquals("oval") || (shape.contentEquals("rectangle"))) {
			// if coordinates are invalid, default to zero
			x = ((num1 >= 0) && (num1 < 500) ? num1 : 0);
			y = ((num2 >= 0) && (num2 < 500) ? num2 : 0);
			width = ((num3 >= 0) && (num3 < 500) ? num3 : 0);
			height = ((num4 >= 0) && (num4 < 500) ? num4 : 0);
		}
	} // end setCoordinates
	
}
