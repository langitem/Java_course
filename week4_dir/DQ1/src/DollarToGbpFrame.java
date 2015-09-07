// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// DollarToGbpFrame.java
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


public class DollarToGbpFrame extends JFrame {
	
	private JTextField dollarTextField; // text field to enter dollars
	private JButton convertButton; // button user will press to convert
	
	// DollarToGbpFrame constructor
	public DollarToGbpFrame() {
		super("Convert USD to GBP");
		setLayout(new FlowLayout()); // set frame layout
		
		// construct textfield for dollars to be entered:
		dollarTextField = new JTextField(10);
		add(dollarTextField); // add textfield to JFrame
		
		convertButton = new JButton("Convert to GBP");
		add(convertButton); // add convertButton to JFrame
		
		// create new ButtonHandler for button event handling
		ButtonHandler handler = new ButtonHandler();
		convertButton.addActionListener(handler);
		
	} // end of DollarToGbpFrame constructor
	
	// private inner class for event handling
	private class ButtonHandler implements ActionListener {

		// process button events
		public void actionPerformed(ActionEvent event) {
			
			String dollarAmountString = dollarTextField.getText();
			dollarAmountString = dollarAmountString.replace("$", "");
			
			if ((isInputValid(dollarAmountString)) && (!dollarAmountString.contentEquals(""))) {
				BigDecimal dollarAmount = new BigDecimal(dollarAmountString);
				Dollar myDollar = new Dollar(dollarAmount);
				BigDecimal gbpAmount = myDollar.getGbpAmount();
				gbpAmount = gbpAmount.setScale(2, RoundingMode.HALF_UP);
				
				String message = "$" + dollarAmountString + " is equivalent to " + gbpAmount.toPlainString() + " GBP";
				JOptionPane.showMessageDialog(null, message, "Converted to GBP", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Please enter a dollar amount only " +
													"and in proper format", "Invalid Input!",
													JOptionPane.WARNING_MESSAGE);
			}
			
		} // end of actionPeformed method
		
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


} // end DollarToGbpFrame
