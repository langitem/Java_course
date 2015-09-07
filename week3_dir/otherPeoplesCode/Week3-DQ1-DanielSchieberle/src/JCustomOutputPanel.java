// JCustomOutputPanel.java
// Provides a panel holding three labels to output the comparison result including "highlighting" of the numerically greater value
// Author: Daniel Schieberle
// Last Update: July 20th 2013

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;


//Class declaration
public class JCustomOutputPanel extends JPanel {
	
	private JLabel[] display;
	private static Font highlightFont = new Font("Dialog", Font.PLAIN,18);
	private Font oldFont;
	
	// Constructor
	public JCustomOutputPanel(String[] values) {
		// Panel using the GridbagLayout
		super(new GridBagLayout());
		// adding a nice border around the labels
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,10,10,10);
		// instantiating labels
		display = new JLabel[] {new JLabel(""),new JLabel(""),new JLabel("")};
		// Setting initial values
		updateDisplay(values);
		// Storing font properties to restore appearance
		oldFont = display[0].getFont();
		
		for (int i=0; i < display.length; i++) {
			// moving to the next line
			gbc.gridy = i;
			// set label color to dark gray
			display[i].setForeground(Color.DARK_GRAY);
			//Adding label to panel 
			add(display[i],gbc);
		}
	} // end of Constructor
	
	
	// Method to highlight a label by using larger font size and set the color to black
	private void highlightLabel(JLabel label) {
		label.setForeground(Color.BLACK);
		label.setFont(highlightFont);
	} // end of method highlightLabel
	
	// Method to restore a label's appearance
	private void restoreLabel(JLabel label) {
		label.setForeground(Color.DARK_GRAY);
		label.setFont(oldFont);
	} // end of method restoreLabel

	// Method to update the 3 lines of the "display"
	public void updateDisplay(String[] values) {
		// Making sure array is not uninitialized
		if (values != null) {
			for (int i=0; i < display.length; i++) {
				// set label text
				display[i].setText(values[i]);
				// restore appearance since values could be equal
				restoreLabel(display[i]);			
			}
			// highlight the first label once comparison has a "winner"
			if (values[1] == HumanReadableComparison.IN_CASE_DIFFERENT) {
				highlightLabel(display[0]);
			} 
		}
		
	} // end of method updateDisplay

} // end of class
