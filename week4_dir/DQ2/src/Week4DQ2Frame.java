import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Week4DQ2Frame extends JFrame {
	
	private JTextField numJTextField; // text field to enter the number to be squared
	private JButton squareJButton; // button user will press to square the number
	private JButton cancelJButton;
	
	// constructor
	public Week4DQ2Frame() {
		super("Square a number");
		setLayout(new FlowLayout()); // set frame layout
		
		// construct textfield for number to be entered
		numJTextField = new JTextField(10);
		add(numJTextField);
		
		squareJButton = new JButton("Square This Number");
		add(squareJButton);
		
		cancelJButton = new JButton("Cancel");
		add(cancelJButton);
		
		ButtonHandler handler = new ButtonHandler();
		squareJButton.addActionListener(handler);
		cancelJButton.addActionListener(handler);
		
	} // end of constructor
	
	// inner class for button event handling
	private class ButtonHandler implements ActionListener {
		
		// handle button event
		public void actionPerformed(ActionEvent event) {
			String numString;
			double numDouble;
			
			if (event.getActionCommand().contentEquals("Square This Number")) {
				
				try {
										
					numString = numJTextField.getText();
					numDouble = Double.parseDouble(numString);
					double numSquared = Math.pow(numDouble, 2);
					
					String message = numString + " squared is: " + String.format("%,.2f", numSquared);
					JOptionPane.showMessageDialog(Week4DQ2Frame.this,
													message, "Result",
													JOptionPane.INFORMATION_MESSAGE);
					
				} catch (NumberFormatException e) {
					System.err.printf("\nException: %s\n", e);
					JOptionPane.showMessageDialog(Week4DQ2Frame.this, "Please enter doubles only",
													"Invalid input", JOptionPane.WARNING_MESSAGE);
					
				} // end of try-catch block
				
			} else if (event.getActionCommand().contentEquals("Cancel")) {
				System.exit(0);
			}
			
		} // end of actionPeformed method
		
	} // end of ButtonHandler class
	
	// method to check if user input is valid
	public boolean isInputValid(String inputGiven) {
		boolean result;
		
		// chekc if input given contains proper format e.g., 123 or 123.45
		if (inputGiven.matches("\\d*(\\.\\d{2})?")) {
			result = true;
		} else {
			result = false;
		}
		
		return result;
	} // end of isInputValid method

}
