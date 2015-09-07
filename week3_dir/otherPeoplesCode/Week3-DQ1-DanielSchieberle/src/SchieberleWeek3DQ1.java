// SchieberleWeek3DQ1.java
// Wrapper class for creating the GUI and implementing its business logic
// Author: Daniel Schieberle
// Last Update: July 20th 2013

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


//Class declaration
public class SchieberleWeek3DQ1 extends JFrame implements ActionListener, ChangeListener  {

	// Instance Variables
	private JCustomInputPanel firstDoubleInput;
	private JCustomInputPanel secondDoubleInput;
	private JCustomPrecisionInputPanel precisionInputPanel;	
	private JCustomOutputPanel output;
	
	// Constants
	private final static int MIN_PRECISION = 5;
	private final static int MAX_PRECISION = 15;
	private final static int DEFAULT_PRECISION = 10;		
	private final static String[] INSTRUCTIONS = new String[] {"Please enter two \"double\" values","and press \"Compare\"",""};	
	private final static Border defaultBorder = BorderFactory.createEmptyBorder(10,10,10,10);
	
	// Constructor
	public SchieberleWeek3DQ1() {
		// setting Title
		super("Double Value Comparison");
		// setting default close behavior
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setting up the GUI
		setupGUI();
		pack();
		setLocationRelativeTo(null);
	} // end of Constructor
	
	// Private method to setup up the GUI
	private final void setupGUI() {
  
		JPanel input = new JPanel(new GridLayout(3,1));
		input.setBorder(defaultBorder);
		
		firstDoubleInput = new JCustomInputPanel("First value:",DEFAULT_PRECISION);	
		input.add(firstDoubleInput);
		
		secondDoubleInput = new JCustomInputPanel("Second value:",DEFAULT_PRECISION);
		input.add(secondDoubleInput);
		
		precisionInputPanel = new JCustomPrecisionInputPanel ("Display Precision: ",MIN_PRECISION,MAX_PRECISION,DEFAULT_PRECISION);
		// Registering current instance as listener to the slider change events
		precisionInputPanel.getSlider().addChangeListener(this);
        input.add(precisionInputPanel);

		
		add(input,BorderLayout.NORTH);
		
		output = new JCustomOutputPanel(INSTRUCTIONS);
		add(output,BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(defaultBorder);
		addButton("Reset",buttonPanel);
		addButton("Compare",buttonPanel);
		addButton("Close",buttonPanel);
		
		add(buttonPanel, BorderLayout.SOUTH);		
	} // end of method setupGUI
	
	// Private helper method to add a button to a panel and automatically register the current object as listener to actions
	private JButton addButton(String caption, JPanel panel) {
		JButton btn = new JButton(caption);
		btn.addActionListener(this);
		panel.add(btn);
		return btn;
	} // end of button addButton
	
	// Private method to reset the GUI
	private void reset() {
		JCustomInputPanel.setPrecision(DEFAULT_PRECISION);
		output.updateDisplay(INSTRUCTIONS);
		precisionInputPanel.reset();		
		firstDoubleInput.reset();
		secondDoubleInput.reset();		
	} // end of method reset
	

	// Method required due to the resulting object being an ActionListeneras well.
	// Handles click-events on the 3 buttons
	public void actionPerformed(ActionEvent e) {
		// Verify that the event comes from a button
		if (e.getSource() instanceof JButton) {
			// Get the button's title
			String label = ((JButton) e.getSource()).getText();
			if ("Compare".equals(label)) {
				// Do comparison
				output.updateDisplay(HumanReadableComparison.onDoubles(firstDoubleInput.getInput(), secondDoubleInput.getInput()));
			} else if ("Reset".equals(label)) {
				// Reset GUI
				reset();
			} else {
				// Otherwise exit application, equals clicking the close button
				System.exit(0);
			}
		}
	} // end of method actionPerfromed
	
	// Method required due to the resulting object being a ChangeListener as well.
	// Handles changes to the "precision slider"
    public void stateChanged(ChangeEvent e) {
    	// Verify that event comes from the slider
    	if (e.getSource() == precisionInputPanel.getSlider()) {
    		// Statically setting the new precision
    		JCustomInputPanel.setPrecision(precisionInputPanel.getValue());    		
    	}
    }	// end of method stateChanged

} // end of class
