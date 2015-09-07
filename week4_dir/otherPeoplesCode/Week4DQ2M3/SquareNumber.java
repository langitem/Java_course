//Designed by Fatai Oseni
//28th July 2013
//SquareNumber.java

import javax.swing.*;
import java.awt.event.*;

public class SquareNumber extends JFrame
{
	//-----Attributes----------
	private JTextField  numberTextField;
	private JLabel  squareLabel;
	private JLabel messageLabel;
	private JButton squareButton;
	private JButton quitButton;

	//-----constructor----------
	public SquareNumber()
	{
		initialiaseJFrame();
	} //end squareNumber constructor

	public void initialiaseJFrame()
	{
		JPanel displayPanel = new JPanel();
		getContentPane().add(displayPanel);
		displayPanel.setLayout(null);

		JLabel  jLabel1 = new JLabel("Enter Number :");
		jLabel1.setBounds(20, 30, 100, 30);
		numberTextField = new JTextField();
		numberTextField.setBounds(120, 30, 80, 20);

		squareLabel = new JLabel("The Square :  ");
		squareLabel.setBounds(20, 60, 160, 30);
		squareButton = new JButton("Square");
		squareButton.setBounds(60, 100, 80, 30);
		quitButton = new JButton("Quit");
		quitButton.setBounds(160, 100, 80, 30);

		messageLabel = new JLabel();
		messageLabel.setBounds(20,140,200,30);

		squareButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				squareButtonAction(event);
			}
		});

		quitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});

		displayPanel.add(quitButton);
		displayPanel.add(squareButton);
		displayPanel.add(numberTextField);
		displayPanel.add(jLabel1);
		displayPanel.add(squareLabel);
		displayPanel.add(messageLabel);

		setTitle("Square of Number");
		setSize(300, 220);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} //end of initialiaseJFrame

	private void squareButtonAction(ActionEvent evt)
	{
	 //get the value of the text field and convert it to double
		try
	    {
	    	double inputNumber = Double.parseDouble(numberTextField.getText());
	    	squareLabel.setText("The Square is :         " + doSquare(inputNumber));
	    	messageLabel.setText("");
		}
		//catch the error if null or not number
		catch (NullPointerException | NumberFormatException e)
		{
			messageLabel.setText("Invalid or null value try again");
		}
    } //end of squareButtonAction

	public double doSquare(double number)
	{
	    double newSquare = number * number;
	    return newSquare;
 	}// end of doSquare
}