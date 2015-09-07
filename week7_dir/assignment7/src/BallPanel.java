import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

public class BallPanel extends JPanel implements Runnable{
	
	private int x=1;
	private int y=1;
	Ball myBall = new Ball(x, y, 1, 1, 50, Color.BLUE);
	
	// constructor, creates panel with ball
	public BallPanel() {
		MouseHandler handler = new MouseHandler();
		addMouseListener( handler );
	}
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g; // cast g to Graphics2D
		
		//while (true) {
			//Ball myBall = new Ball(x, y, 1, 1, 50, Color.BLUE);
			myBall.draw(g2d);
			repaint();
			try { Thread.sleep( 700 ); } catch ( Exception e ) {}
			
		//}
	}
	
	private class MouseHandler implements MouseListener {
		public void mouseClicked(MouseEvent event) {
			
		}

		@Override
		public void mouseEntered(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent event) {
			// TODO Auto-generated method stub
			
		}
	} // end of MouseHandler class

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while (true) {
			
			x=x+1;
			y=y-1;
			repaint();
		} // end of while loop
	}

}
