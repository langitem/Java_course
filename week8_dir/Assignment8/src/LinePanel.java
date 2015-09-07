import java.awt.Graphics;

import javax.swing.JPanel;


public class LinePanel extends JPanel {
	
	private int x1 = 0;
	private int y1 = 0;
	private int x2 = 0;
	private int y2 = 0;
	
	// draw line with specified coordinates:
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);

		g.drawLine(x1, y1, x2, y2);
		
		//repaint();
	} // end method paintComponent
	
	// validate and set line coordinates
	public void setCoordinates(int newX1, int newY1, int newX2, int newY2) {
		
		// if coordinates are invalid, default to zero
		x1 = ((newX1 >= 0) && (newX1 < 500) ? newX1 : 0);
		y1 = ((newY1 >= 0) && (newY1 < 500) ? newX1 : 0);
		x2 = ((newX2 >= 0) && (newX2 < 500) ? newX1 : 0);
		y2 = ((newY2 >= 0) && (newY2 < 500) ? newX1 : 0);
		
	} // end setCoordinates

}
