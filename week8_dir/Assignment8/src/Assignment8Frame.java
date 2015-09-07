// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Assignment8Frame.java
// Application class for assignment 8
// Week 8 Assignment
// August 28, 2013

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Assignment8Frame extends JFrame {
	
	// line variables:
	private JLabel lineX1JLabel = new JLabel("x1 coordinate:");
	private JLabel lineX2JLabel = new JLabel("x2 coordinate:");
	private JLabel lineY1JLabel = new JLabel("y1 coordinate:");
	private JLabel lineY2JLabel = new JLabel("y2 coordinate:");
	private JTextField lineX1JTextField = new JTextField(3);
	private JTextField lineX2JTextField = new JTextField(3);
	private JTextField lineY1JTextField = new JTextField(3);
	private JTextField lineY2JTextField = new JTextField(3);
	private int lineX1 = 0;
	private int lineX2 = 0;
	private int lineY1 = 0;
	private int lineY2 = 0;
	
	// oval and rectangle variables:
	private JLabel xJLabel = new JLabel("x coordinate:");
	private JLabel yJLabel = new JLabel("y coordinate:");
	private JLabel widthJLabel = new JLabel("width:");
	private JLabel heightJLabel = new JLabel("height:");
	private JTextField xJTextField = new JTextField(3);
	private JTextField yJTextField = new JTextField(3);
	private JTextField widthJTextField = new JTextField(3);
	private JTextField heightJTextField = new JTextField(3);
	private int x = 0;
	private int y = 0;
	private int width = 0;
	private int height = 0;
	
	ShapePanel myShapePanel = new ShapePanel(); // panel to draw shape
	
	// no-argument constructor set up GUI
	public Assignment8Frame() {
		
		super( "Assignment 8" );
		
		JMenu fileMenu = new JMenu( "File" ); // create file menu
		fileMenu.setMnemonic( 'F' ); // set mnemonic to F
		
		// create About... menu item
		JMenuItem aboutItem = new JMenuItem( "About..." );
		aboutItem.setMnemonic( 'A' ); // set mnemonic to A
		fileMenu.add( aboutItem ); // add about item to file menu
		
		aboutItem.addActionListener(

				new ActionListener() { // anonymous inner class  
					// display message dialog when user selects About...
					public void actionPerformed( ActionEvent event ) {
						JOptionPane.showMessageDialog( Assignment8Frame.this,
								"Assignment 8\nby Emanuel Langit",
								"About", JOptionPane.PLAIN_MESSAGE );
					} // end method actionPerformed
				} // end anonymous inner class
		); // end call to addActionListener
		
		JMenuItem exitItem = new JMenuItem( "Exit" ); // create exit item
		exitItem.setMnemonic( 'x' ); // set mnemonic to x
		fileMenu.add( exitItem ); // add exit item to file menu
		exitItem.addActionListener(

				new ActionListener() { // anonymous inner class
					// terminate application when user clicks exitItem
					public void actionPerformed( ActionEvent event ) {
						System.exit( 0 ); // exit application
					} // end method actionPerformed
				} // end anonymous inner class
		); // end call to addActionListener
		
		JMenu drawMenu = new JMenu( "Draw" ); // create draw menu
		drawMenu.setMnemonic( 'd' ); // set mnemonic to d
		
		// create line... menu item
		JMenuItem lineItem = new JMenuItem("Line");
		drawMenu.add(lineItem); // add line item to Draw menu
		
		lineItem.addActionListener(
				
				new ActionListener() { // anonymous inner class
					// prompt user for line inputs
					public void actionPerformed(ActionEvent event) {
						askUserForLineInput();
						myShapePanel.repaint();
	
					} // end method actionPerformed
					
				} // end anonymous inner class			
				
		); // end call to addActionListener
		
		// create oval menu item
		JMenuItem ovalItem = new JMenuItem("Oval");
		drawMenu.add(ovalItem); // add Oval item to Draw menu
		
		ovalItem.addActionListener(
				
				new ActionListener() { // anonymous inner class
					// prompt user for oval inputs
					public void actionPerformed(ActionEvent event) {
						askUserForInput("oval");
						myShapePanel.repaint();

					} // end method actionPerformed
					
				} // end anonymous inner class			
				
		); // end call to addActionListener
		
		// create rectangle menu item
		JMenuItem rectangleItem = new JMenuItem("rectangle");
		drawMenu.add(rectangleItem); // add rectangle item to Draw menu
		
		rectangleItem.addActionListener(
				
				new ActionListener() { // anonymous inner class
					// prompt user for rectangle inputs
					public void actionPerformed(ActionEvent event) {
						askUserForInput("rectangle");
						myShapePanel.repaint();

					} // end method actionPerformed
					
				} // end anonymous inner class			
				
		); // end call to addActionListener

		JMenuBar bar = new JMenuBar(); // create menu bar
		setJMenuBar( bar ); // add menu bar to application
		bar.add( fileMenu ); // add file menu to menu bar
		bar.add(drawMenu); // add draw menu to menu bar
		add(myShapePanel);

	} // end of constructor
	
	public void askUserForLineInput() {
		
		String lineX1String = "";
		String lineX2String = "";
		String lineY1String = "";
		String lineY2String = "";
		
		JPanel lineJPanel = new JPanel();
		lineJPanel.add(lineX1JLabel);
		lineJPanel.add(lineX1JTextField);
		lineJPanel.add(lineY1JLabel);
		lineJPanel.add(lineY1JTextField);
		lineJPanel.add(lineX2JLabel);
		lineJPanel.add(lineX2JTextField);
		lineJPanel.add(lineY2JLabel);
		lineJPanel.add(lineY2JTextField);
		
		int option = JOptionPane.showConfirmDialog(null, lineJPanel, "Please enter the line start and end coordinates (integers from 1-500 only)", JOptionPane.OK_CANCEL_OPTION);
		
		if (option  == JOptionPane.OK_OPTION) {

			lineX1String = lineX1JTextField.getText().trim();
			lineX2String = lineX2JTextField.getText().trim();
			lineY1String = lineY1JTextField.getText().trim();
			lineY2String = lineY2JTextField.getText().trim();

			try {
				lineX1 = Integer.parseInt(lineX1String);
				lineX2 = Integer.parseInt(lineX2String);
				lineY1 = Integer.parseInt(lineY1String);
				lineY2 = Integer.parseInt(lineY2String);
			} catch (NumberFormatException e) {
				System.err.printf("\nException: %s\n", e);
				displayInvalidInputMsg("Invalid characters entered!");
			}
			
			myShapePanel.setCoordinates(lineX1, lineY1, lineX2, lineY2, "line");

		} // end of if OK_OPTION
	} // end of askUserForLineInput method
	
	public void askUserForInput(String shapeType) {
		
		String shape = shapeType;
		String xString = "";
		String yString = "";
		String widthString = "";
		String heightString = "";
		
		JPanel lineJPanel = new JPanel();
		lineJPanel.add(xJLabel);
		lineJPanel.add(xJTextField);
		lineJPanel.add(yJLabel);
		lineJPanel.add(yJTextField);
		lineJPanel.add(widthJLabel);
		lineJPanel.add(widthJTextField);
		lineJPanel.add(heightJLabel);
		lineJPanel.add(heightJTextField);
		
		int option = JOptionPane.showConfirmDialog(null, lineJPanel, "Please enter the X,Y coordinates, and width & height (integers from 1-500 only)", JOptionPane.OK_CANCEL_OPTION);
		
		if (option  == JOptionPane.OK_OPTION) {

			xString = xJTextField.getText().trim();
			yString = yJTextField.getText().trim();
			widthString = widthJTextField.getText().trim();
			heightString = heightJTextField.getText().trim();

			try {
				x = Integer.parseInt(xString);
				y = Integer.parseInt(yString);
				width = Integer.parseInt(widthString);
				height = Integer.parseInt(heightString);
			} catch (NumberFormatException e) {
				System.err.printf("\nException: %s\n", e);
				displayInvalidInputMsg("Invalid characters entered!");
			}
			
			myShapePanel.setCoordinates(x, y, width, height, shape);
			
		} // end of if OK_OPTION
	} // end of askUserForInput method
	
	// method to display invalid input message:
	private void displayInvalidInputMsg(String msg) {
		
		JOptionPane.showMessageDialog(Assignment8Frame.this, msg, "Invalid Input!", JOptionPane.WARNING_MESSAGE);
		
	} // end displayInvalidInputMsg method

}
