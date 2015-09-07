//Address UI class
//Geng Liu
//August 2013
//University of Liverpool, UK
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class AddressUI extends JFrame
{
	/*UI controls*/
	 private JLabel lblMessage;
	 private JLabel lblFirstName;
	 private JLabel lblSecondName;
	 private JLabel lblPhoneNumber;
	 private JLabel lblHouseNumber;
	 private JLabel lblStreet1Name;
	 private JLabel lblStreet2Name;
	 private JLabel lblCityName;


	 private JTextField txtFirstName;
	 private JTextField txtSecondName;
	 private JTextField txtPhoneNumber;
	 private JTextField txtHouseNumber;
	 private JTextField txtStreet1Name;
	 private JTextField txtStreet2Name;
	 private JTextField txtCityName;


 	 private JButton btnShortAddress;
 	 private JButton btnFullAddress;
	 private JButton btnReset;

	 /*Constructor*/
 	 public AddressUI()
	 {
		super();
		/*Set the panel size*/
		this.setSize(470, 350);
		this.getContentPane().setLayout(null);

		/*Create and set UI elements*/

		lblMessage=new javax.swing.JLabel();
		lblMessage.setBounds(50, 10, 350, 18);
		lblMessage.setForeground (Color.red);
		this.add(lblMessage, null);

		lblFirstName=new javax.swing.JLabel();
	    lblFirstName.setText("First Name:");
	    lblFirstName.setBounds(50, 30, 150, 18);
		this.add(lblFirstName, null);

		txtFirstName=new javax.swing.JTextField(10);
		txtFirstName.setBounds(180, 30, 150, 20);
		this.add(txtFirstName, null);


		lblSecondName=new javax.swing.JLabel();
		lblSecondName.setText("Second Name:");
		lblSecondName.setBounds(50, 60, 150, 18);
		this.add(lblSecondName, null);

		txtSecondName=new javax.swing.JTextField(10);
		txtSecondName.setBounds(180, 60, 150, 20);
		this.add(txtSecondName, null);



		lblPhoneNumber=new javax.swing.JLabel();
		lblPhoneNumber.setText("Phone Number:");
		lblPhoneNumber.setBounds(50, 90, 150, 18);
		this.add(lblPhoneNumber, null);

		txtPhoneNumber=new javax.swing.JTextField(10);
		txtPhoneNumber.setBounds(180, 90, 150, 20);
		this.add(txtPhoneNumber, null);


		lblHouseNumber=new javax.swing.JLabel();
		lblHouseNumber.setText("House Number:");
		lblHouseNumber.setBounds(50, 120, 150, 18);
		this.add(lblHouseNumber, null);

		txtHouseNumber=new javax.swing.JTextField(10);
		txtHouseNumber.setBounds(180, 120, 150, 20);
		this.add(txtHouseNumber, null);


		lblStreet1Name=new javax.swing.JLabel();
		lblStreet1Name.setText("Street Name 1:");
		lblStreet1Name.setBounds(50, 150, 150, 18);
		this.add(lblStreet1Name, null);

		txtStreet1Name=new javax.swing.JTextField(10);
		txtStreet1Name.setBounds(180, 150, 150, 20);
		this.add(txtStreet1Name, null);


		lblStreet2Name=new javax.swing.JLabel();
		lblStreet2Name.setText("Street Name 2:");
		lblStreet2Name.setBounds(50, 180, 150, 18);
		this.add(lblStreet2Name, null);

		txtStreet2Name=new javax.swing.JTextField(10);
		txtStreet2Name.setBounds(180, 180, 150, 20);
		this.add(txtStreet2Name, null);


 		lblCityName=new javax.swing.JLabel();
 		lblCityName.setText("City Name :");
 		lblCityName.setBounds(50, 210, 180, 18);
 		this.add(lblCityName, null);

 		txtCityName=new javax.swing.JTextField(10);
 		txtCityName.setBounds(180, 210, 150, 20);
		this.add(txtCityName, null);

		btnShortAddress = new javax.swing.JButton();
	  	btnShortAddress.setText("View Short Address");
	  	btnShortAddress.setBounds(20, 240, 150, 27);
	 	btnShortAddress.addActionListener(new ActionListener()
	  	{
		  public void actionPerformed(ActionEvent arg0)
		  {
			viewAddress ("Short");
		  }
		});
		this.add(btnShortAddress, null);


		btnFullAddress = new javax.swing.JButton();
	  	btnFullAddress.setText("View Full Address");
	  	btnFullAddress.setBounds(182, 240, 145, 27);
	 	btnFullAddress.addActionListener(new ActionListener()
	  	{
		  public void actionPerformed(ActionEvent arg0)
		  {
			viewAddress ("Full");
		  }
		});
		this.add(btnFullAddress, null);

		btnReset = new javax.swing.JButton();
		btnReset.setText("Reset");
		btnReset.setBounds(338, 240, 80, 27);
		btnReset.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent arg0)
		  {
			reset ();
		  }
		});
		this.add(btnReset, null);


   		this.setTitle("Address Information");
	 }

	/*Reset text field*/
	private void reset()
	{
		lblMessage.setText("");
		txtFirstName.setText("");
		txtSecondName.setText("");
		txtPhoneNumber.setText("");
		txtHouseNumber.setText("");
		txtStreet1Name.setText("");
		txtStreet2Name.setText("");
		txtCityName.setText("");
	}

	private void viewAddress(String actionCode)
	{
		resetErrorMessage();
		FullAddress address=getFullAddress();
		if(address!=null)
		{
			if(actionCode=="Full")
			{
				Utility.ShowInfomationMessage(address.getAddressInformation(),"View Full Address");
			}
			else if(actionCode=="Short")
			{
				Utility.ShowInfomationMessage(address.getAddressInformationSuper(),"View Short Address");
			}
		}

	}

	private FullAddress getFullAddress()
	{
		try
		{
			String firstName=txtFirstName.getText();
			String secondName=txtSecondName.getText();
			String phoneNumber=txtPhoneNumber.getText();
			int houseNumber=Integer.parseInt(txtHouseNumber.getText());
			String street1Name=txtStreet1Name.getText();
			String street2Name=txtStreet2Name.getText();
			String cityName=txtCityName.getText();
			/*Create new instance of FullAddress class*/
			FullAddress fullAddress=new FullAddress(firstName,secondName,phoneNumber,houseNumber,street1Name,street2Name,cityName);
			return fullAddress;

		} catch (NumberFormatException e)
		{
			setErrorMessage("Please enter a valid house number, no 1a or 3b's allowed");
			return null;
		}
	}

	private void resetErrorMessage()
	{
		lblMessage.setText("");
	}
	private void setErrorMessage(String message)
	{
		lblMessage.setText(message);
	}


}
