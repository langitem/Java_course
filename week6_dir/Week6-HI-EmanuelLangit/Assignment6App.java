// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Assignment6App.java
// Application class for assignment 6
// Week 6 Assignment
// August 14, 2013

//import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Assignment6App extends JFrame {
	
	private JLabel textFields1JLabel;
	private JLabel beforeSortedJLabel;
	private JLabel sortedJLabel;
	
	private JPanel firstJPanel;
	private JPanel secondJPanel;
	private JPanel beforeSortJPanel;
	private JPanel sortedJPanel;
	private JPanel buttonJPanel;
	private JTextField intTextField0 = new JTextField(4);
	private JTextField intTextField1 = new JTextField(4);
	private JTextField intTextField2 = new JTextField(4);
	private JTextField intTextField3 = new JTextField(4);
	private JTextField intTextField4 = new JTextField(4);
	private JTextField intTextField5 = new JTextField(4);
	private JTextField intTextField6 = new JTextField(4);
	private JTextField intTextField7 = new JTextField(4);
	private JTextField intTextField8 = new JTextField(4);
	private JTextField intTextField9 = new JTextField(4);
	
	private JButton sortJButton = new JButton("Sort");
	private JButton cancelJButton = new JButton("Cancel");

	private JTextField beforeSortedJTextField = new JTextField(40);
	private JTextField sortedJTextField = new JTextField(40);
	
	private static final int ARRAY_LENGTH = 10;
	int[] unsortedIntArray = new int[ARRAY_LENGTH];
	int[] sortedIntArray = new int[ARRAY_LENGTH];

	public Assignment6App() {
		super("Assignment 6 by Emanuel Langit");
		setLayout( new FlowLayout(FlowLayout.RIGHT)); // set frame layout
		
		// build panel for first JLabel:
		firstJPanel = new JPanel();
		String userPromptString = "Enter " + ARRAY_LENGTH + " random integers:";
		textFields1JLabel = new JLabel(userPromptString);
		firstJPanel.add(textFields1JLabel);
		
		// build panel for user to enter 10 integers:
		secondJPanel = new JPanel();
		
		secondJPanel.add(intTextField0);
		secondJPanel.add(intTextField1);
		secondJPanel.add(intTextField2);
		secondJPanel.add(intTextField3);
		secondJPanel.add(intTextField4);
		secondJPanel.add(intTextField5);
		secondJPanel.add(intTextField6);
		secondJPanel.add(intTextField7);
		secondJPanel.add(intTextField8);
		secondJPanel.add(intTextField9);
		
		// build panel to add current state:
		beforeSortJPanel = new JPanel();
		beforeSortedJLabel = new JLabel("You entered:");
		beforeSortJPanel.add(beforeSortedJLabel);
		beforeSortedJTextField.setEditable(false);
		beforeSortJPanel.add(beforeSortedJTextField);
		
		// build panel to add sorted state:
		sortedJPanel = new JPanel();
		sortedJLabel = new JLabel("Bubble sort result:");
		sortedJPanel.add(sortedJLabel);
		sortedJTextField.setEditable(false);
		sortedJPanel.add(sortedJTextField);
		
		// build panel to hold buttons:
		buttonJPanel = new JPanel();
		sortJButton.setActionCommand("SORT");
		buttonJPanel.add(sortJButton);
		cancelJButton.setActionCommand("CANCEL");
		buttonJPanel.add(cancelJButton);
		
		add(firstJPanel);
		add(secondJPanel);
		add(beforeSortJPanel);
		add(sortedJPanel);
		add(buttonJPanel);
		
		// register button handler for event handling
		ButtonHandler handler = new ButtonHandler();
		sortJButton.addActionListener(handler);
		cancelJButton.addActionListener(handler);

	} // end of constructor
	
	// private inner class for button event handling
	private class ButtonHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent event) {
			if (event.getActionCommand().equals("SORT")) {

				if (receiveInputFromUserSuccessful()) {
					displayArray(unsortedIntArray, beforeSortedJTextField);
					displayArray(sortedIntArray, sortedJTextField);
				}
				
			} else if (event.getActionCommand().equals("CANCEL")) {
				System.exit(0);
			}
			
		} // end of actionPerformed method	
		
	} // end of ButtonHandler class
	
	private boolean receiveInputFromUserSuccessful() {
		boolean successful = false;
		String stringInt0 = intTextField0.getText().trim();
		String stringInt1 = intTextField1.getText().trim();
		String stringInt2 = intTextField2.getText().trim();
		String stringInt3 = intTextField3.getText().trim();
		String stringInt4 = intTextField4.getText().trim();
		String stringInt5 = intTextField5.getText().trim();
		String stringInt6 = intTextField6.getText().trim();
		String stringInt7 = intTextField7.getText().trim();
		String stringInt8 = intTextField8.getText().trim();
		String stringInt9 = intTextField9.getText().trim();
		
		int int0 = 0;
		int int1 = 0;
		int int2 = 0;
		int int3 = 0;
		int int4 = 0;
		int int5 = 0;
		int int6 = 0;
		int int7 = 0;
		int int8 = 0;
		int int9 = 0;
		
		
		try {
			int0 = Integer.parseInt(stringInt0);
			int1 = Integer.parseInt(stringInt1);
			int2 = Integer.parseInt(stringInt2);
			int3 = Integer.parseInt(stringInt3);
			int4 = Integer.parseInt(stringInt4);
			int5 = Integer.parseInt(stringInt5);
			int6 = Integer.parseInt(stringInt6);
			int7 = Integer.parseInt(stringInt7);
			int8 = Integer.parseInt(stringInt8);
			int9 = Integer.parseInt(stringInt9);
			successful = true;
			
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(Assignment6App.this, "Please enter integers only", "Invalid input!",
											JOptionPane.INFORMATION_MESSAGE);
			beforeSortedJTextField.setText("");
			sortedJTextField.setText("");
			System.err.printf("\nException: %s\n", e);
		} // end of try catch block
		
		unsortedIntArray = new int[] {int0, int1, int2, int3, int4, int5, int6, int7, int8, int9};
		SetOfIntegers mySet = new SetOfIntegers(int0, int1, int2, int3, int4, int5, int6, int7, int8, int9);
		sortedIntArray = mySet.bubbleSortArray();
		
		return successful;
	} // end of receiveInputFromUser method
	
	private String displayArray(int[] arrayToBeDisplayed, JTextField textField) {
		String intString = "{";
		for (int i = 0; i < arrayToBeDisplayed.length; i++) {
			intString += arrayToBeDisplayed[i];
			if (i == (arrayToBeDisplayed.length - 1)) {
				intString += "}";
			} else {
				intString += ", ";
			}
		}
		
		textField.setText(intString);
		return intString;
		
	} // end of displayArray method

}
