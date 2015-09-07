// JCustomPrecisionInputPanel.java
// Provides a panel holding a label and a slider
// Author: Daniel Schieberle
// Last Update: July 20th 2013

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;


// Class declaration
public class JCustomPrecisionInputPanel extends JPanel {

	 private JSlider precisionInput;
	 private int defaultValue; 
	
	// Constructor
	public JCustomPrecisionInputPanel(String caption, int minValue, int maxValue, int defaultValue) {
		super();
		this.defaultValue = defaultValue;
		
		JLabel label = new JLabel(caption);
		add(label);
		
        precisionInput = new JSlider(JSlider.HORIZONTAL,minValue, maxValue, this.defaultValue);
        precisionInput.setMajorTickSpacing(5);
        precisionInput.setMinorTickSpacing(1);
        precisionInput.setPaintTicks(true);
        precisionInput.setPaintLabels(true);
        // slider will snap to the positions
        precisionInput.setSnapToTicks(true);
        add(precisionInput);
	} // end of constructor
	
	// method to get the current value
	public int getValue() {
		return precisionInput.getValue();
	} // end of method getValue
	
	//method to reset the slider to the default value
	public void reset() {
		precisionInput.setValue(defaultValue);
	} // end of method reset
	
	// method to get the slider object to allow hooking of specific events.
	public JSlider getSlider() {
		return precisionInput;
	} // end of method getSlider

}
