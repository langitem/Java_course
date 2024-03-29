// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// BlueBallPanel.java
// Application class for assignment 7
// Week 7 Assignment
// August 21, 2013

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import java.lang.Runnable;
import java.util.Random;

public class BlueBallPanel extends JPanel implements Runnable {
	private final int DIAMETER = 10;
	private int x = 1;
	private int y = 1;
	private int changeInX = 1;
	private int changeInY = 1;
	private final int X_MAX = 495;
	private final int Y_MAX = 470;
	private Random randomInt = new Random();
	
	// constructor
	public BlueBallPanel() {
		MouseHandler handler = new MouseHandler();
		addMouseListener( handler );
	}
	
	// draw ball with specified DIAMETER
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	private void moveBall() {
		Thread blueBallThread = new Thread(this);
		blueBallThread.start();
	}

	@Override
	public void run() {
		String xDirection = "right";
		String yDirection = "down";
		Boolean justBounced = false;
		
		while (true) {
			try {
				Thread.sleep( 10 );
			} catch ( Exception e ) {
				
			}
			
			if (justBounced) {
				changeInX = 1 + randomInt.nextInt(3);
				changeInY = 1 + randomInt.nextInt(3);
			}
			
			if (xDirection.contentEquals("right")) {
				x += changeInX;
				if (x > X_MAX) {
					xDirection = "left";
					justBounced = true;
				} else {
					justBounced = false;
				}
			} else {
				x -= changeInX;
				if (x < 5) {
					xDirection = "right";
					justBounced = true;
				} else {
					justBounced = false;
				}
			} // end of checking xDirection
			
			if (yDirection.contentEquals("down")) {
				y += changeInY;
				if (y > Y_MAX) {
					yDirection = "up";
					justBounced = true;
				} else {
					justBounced = false;
				}
			} else {
				y -= changeInY;
				if (y < 5) {
					yDirection = "down";
					justBounced = true;
				} else {
					justBounced = false;
				}
			} // end of checking yDirection
			
			repaint();

		} // end of while loop
		
	} // end of run method
	
	// private inner class
	private class MouseHandler implements MouseListener {
		
		public void mouseClicked(MouseEvent event) {
			moveBall();
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			
		}

		@Override
		public void mouseExited(MouseEvent event) {
			
		}

		@Override
		public void mousePressed(MouseEvent event) {
			
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			
		}
	} // end of MouseHandler class

}
