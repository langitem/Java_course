// JCustomInputPanel.java
// Provides a panel holding a label and a formatted text-field bound to a NumberFormatter
// Author: Daniel Schieberle
// Last Update: July 20th 2013

import java.awt.Color;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;


// class declaration
public class JCustomInputPanel extends JPanel {

		private JLabel label;
		private JFormattedTextField textField;
		
		// forcing locale to english, German uses different punctuation eg. 1234,56 = 1234.56
		private static NumberFormat f = NumberFormat.getNumberInstance(Locale.ENGLISH);
		// static class variable therefore all instances will share the same precision once altered
		public static int currentPrecision;		
	
		// Constructor
		public JCustomInputPanel(String caption, int precision) {
			// using GridLayout
			super(new GridLayout(2,1));
			// Setting initial precision
			currentPrecision = precision;
			
			// Adding a label positioned on the left hand side
			label = new JLabel(caption,JLabel.LEFT);
			add(label);
			
			// Setting the current precision
			f.setMinimumFractionDigits(currentPrecision);
			// don't use any "grouping" such as "1,234,567.89"
			f.setGroupingUsed(false);
			
			textField = new JFormattedTextField(f);
			// setting 16 columns for the text field
			textField.setColumns(16);
			add(textField);						
		} // end of constructor
		
		// Resetting the "panel"
		public void reset() {
			// clear the field
			textField.setValue(null);
		} // end of method reset
		
		// Method returns the input as a Double taking advantage of the input validation provided by the NumberFormatter
		public Double getInput() {			
			try {
				// Restoring label color
				label.setForeground(Color.BLACK);
				// 	Casting to "Number" before accessing the doubleValue as Java will throw an exception for instance as 12.0000000000 "cannot" be casted to Double (since Long)
				 // eg java.lang.Long cannot be cast to java.lang.Double
				return new Double(((Number) textField.getValue()).doubleValue());
			} catch (NullPointerException e) {
				// marking the label in red
				label.setForeground(Color.RED);
				// return no input
				return null;
			}
		} // end of method getInput

		// static method to set the precision on all instantiated objects
		public static void setPrecision(int precision) {
			currentPrecision = precision;
			// let Formatter "know" as well
			f.setMinimumFractionDigits(currentPrecision);			
		} // end of method setPrecision
		
} // end of class
