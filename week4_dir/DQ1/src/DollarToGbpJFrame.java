// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// DollarToGbpJFrame.java
// JFrame class for DQ1
// Week 4 DQ1
// July 29, 2013

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class DollarToGbpJFrame extends JFrame {
	
	private JTextField dollarTextField; // text field to enter dollars
	private JButton convertJButton;
	private JButton cancelJButton;
	
	// DollarToGbpJFrame constructor
	public DollarToGbpJFrame() {
		super("Convert USD to GBP");
		setLayout(new FlowLayout()); // set frame layout
		
		// construct textfield for dollars to be entered:
		dollarTextField = new JTextField(10);
		add(dollarTextField);
		
		convertJButton = new JButton("Convert to GBP");
		add(convertJButton); // add convertButton to JFrame
		
		cancelJButton = new JButton("Cancel");
		add(cancelJButton); // button to cancel/exit program
		
		// create new ButtonHandler for button event handling
		ButtonHandler handler = new ButtonHandler();
		convertJButton.addActionListener(handler);
		cancelJButton.addActionListener(handler);
		
	} // end of DollarToGbpFrame constructor
	
	// private inner class for event handling
	private class ButtonHandler implements ActionListener {

		// process button events
		public void actionPerformed(ActionEvent event) {
			
			if (event.getActionCommand().contentEquals("Convert to GBP")) {
				
				String dollarAmountString = dollarTextField.getText();
				dollarAmountString = dollarAmountString.replace("$", "");
				
				if (isInputValid(dollarAmountString)) {
				
					try {

						BigDecimal dollarAmount = new BigDecimal(dollarAmountString);
						Dollar myDollar = new Dollar(dollarAmount);
						BigDecimal gbpAmount = myDollar.getGbpAmount();
						gbpAmount = gbpAmount.setScale(2, RoundingMode.HALF_UP);

						String message = "$" + dollarAmountString + " is equivalent to "
											+ gbpAmount.toPlainString() + " GBP";
						JOptionPane.showMessageDialog(DollarToGbpJFrame.this, 
														message, "Converted to GBP",
														JOptionPane.INFORMATION_MESSAGE);
					} catch (NumberFormatException e) {

						System.err.printf("\nException: %s\n", e);
						displayInvalidInputMsg();

					} // end of try-catch block
				} else {
					
					displayInvalidInputMsg();
				} // end of if-else block that validates input
					
				
			} else if (event.getActionCommand().contentEquals("Cancel")) {
				System.exit(0);
			} // end of if-else block for buttons pressed.
				
		} // end of actionPerformed method
			
		
	} // end of ButtonHandler class
	
	// method to check if user input is valid
	private static boolean isInputValid(String inputGiven) {
		boolean result;

		// check if input given contains proper format e.g., 123 or 123.45
		if (inputGiven.matches("\\d*(\\.\\d{2})?")) {
			result = true;
		} else {
			result = false;
		}

		return result;
	} // end of isInputValid method
		
	// method to display invalid input message:
	private void displayInvalidInputMsg() {
		JOptionPane.showMessageDialog(DollarToGbpJFrame.this,
				"Please enter dollar amounts only in proper format",
				"Invalid Input!", JOptionPane.WARNING_MESSAGE);
	}

}
