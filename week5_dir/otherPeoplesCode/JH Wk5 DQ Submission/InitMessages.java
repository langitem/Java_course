import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InitMessages extends JFrame {

private int DefaultAddressNumber = 1;
private int MinAddressNumber = 1;
private int MaxAddressNumber = 1000000;

private JTextField InputtedFirstName = new JTextField(10);
private JTextField InputtedSecondName = new JTextField(10);
private JTextField InputtedPhoneNumber = new JTextField(10);
private JTextField InputtedStreetNumber = new JTextField(10);
private JTextField InputtedStreet1 = new JTextField(10);
private JTextField InputtedStreet2 = new JTextField(10);
private JTextField InputtedCityName = new JTextField(10);
private JTextField numberField = new JTextField(4);
SpinnerNumberModel Number = new SpinnerNumberModel(DefaultAddressNumber, MinAddressNumber, MaxAddressNumber, 1);
JSpinner addressNumber = new JSpinner(Number);

public void CreateGUI(){


JFrame GUI = new JFrame("Add Your Addresses Here:");
ImageIcon addressbook = new ImageIcon("Address_Book.gif");
JLabel show_addressbook = new JLabel(addressbook);
JPanel interfaceArea = new JPanel();
JLabel textLabelFirstName = new JLabel("First Name:");
JLabel textLabelSecondName = new JLabel("Second Name:");
JLabel textLabelPhoneNumber = new JLabel("Phone Number:");
JLabel textLabelHouseNumber = new JLabel("House / Flat Number:");
JLabel textLabel1stLineOfAddress = new JLabel("1st Line Of Address:");           
JLabel textLabel2ndLineOfAddress = new JLabel("2nd Line Of Address:");
JLabel textLabelCityName = new JLabel("Name of Town City:");
JLabel emptyspace1 = new JLabel(""); 
JLabel emptyspace2 = new JLabel(""); 
JButton goSmallButton = new JButton("Small Address");
JButton goLongButton = new JButton("Long Address");
JButton resetButton = new JButton("Reset Address");

GUI.setVisible(true);
GUI.setSize(200, 600);
GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
GUI.add(interfaceArea);

textLabelFirstName.setHorizontalAlignment(JTextField.CENTER);
InputtedFirstName.setHorizontalAlignment(JTextField.CENTER);
textLabelSecondName.setHorizontalAlignment(JTextField.CENTER);
InputtedSecondName.setHorizontalAlignment(JTextField.CENTER);
textLabelPhoneNumber.setHorizontalAlignment(JTextField.CENTER);
InputtedPhoneNumber.setHorizontalAlignment(JTextField.CENTER);
textLabel1stLineOfAddress.setHorizontalAlignment(JTextField.CENTER);
InputtedStreet1.setHorizontalAlignment(JTextField.CENTER);
textLabel2ndLineOfAddress.setHorizontalAlignment(JTextField.CENTER);
InputtedStreet2.setHorizontalAlignment(JTextField.CENTER);
textLabelCityName.setHorizontalAlignment(JTextField.CENTER);
InputtedCityName.setHorizontalAlignment(JTextField.CENTER);
goSmallButton.setLocation(800, 250);

interfaceArea.add(textLabelFirstName);
interfaceArea.add(InputtedFirstName);
interfaceArea.add(textLabelSecondName);
interfaceArea.add(InputtedSecondName);
interfaceArea.add(textLabelPhoneNumber);
interfaceArea.add(InputtedPhoneNumber);
interfaceArea.add(textLabelHouseNumber);
interfaceArea.add(addressNumber);
interfaceArea.add(textLabel1stLineOfAddress);
interfaceArea.add(InputtedStreet1);
interfaceArea.add(textLabel2ndLineOfAddress);
interfaceArea.add(InputtedStreet2);
interfaceArea.add(textLabelCityName);
interfaceArea.add(InputtedCityName);
interfaceArea.add(emptyspace1);
interfaceArea.add(emptyspace2);
interfaceArea.add(goSmallButton);
interfaceArea.add(goLongButton);
interfaceArea.add(resetButton);
interfaceArea.add(show_addressbook);

goSmallButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e)
            {
 try {
            ShortAddress ThisEntryShort = new ShortAddress(InputtedFirstName.getText(), InputtedSecondName.getText(), InputtedPhoneNumber.getText());
            ThisEntryShort.printShortAddressDetails();
}

catch (Throwable exception) {
        JOptionPane.showMessageDialog(null, "The problem is  " + exception.getMessage() , "Short Entry Error Message:", JOptionPane.ERROR_MESSAGE);

                     }
 
}

});


goLongButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e)
            {
 try {

            FullAddress ThisEntryLong = new FullAddress(InputtedFirstName.getText(), InputtedSecondName.getText(), InputtedPhoneNumber.getText(), Integer.parseInt(addressNumber.getValue().toString().trim()), InputtedStreet1.getText(), InputtedStreet2.getText(), InputtedCityName.getText());
            ThisEntryLong.printFullAddressDetails();
}

catch (Throwable exception) {
        JOptionPane.showMessageDialog(null, "Before pressing the full address button you need to sort out: "  + exception.getMessage()  , "Short Entry Error Message:", JOptionPane.ERROR_MESSAGE);
            
                     }
 
}

});



resetButton.addActionListener(new ActionListener() {
 public void actionPerformed(ActionEvent e)
            {
 try {

                  InputtedFirstName.setText("");
                  InputtedSecondName.setText("");
                  InputtedPhoneNumber.setText("");
                  addressNumber.setValue(new Integer (1));
                  InputtedStreet1.setText("");
                  InputtedStreet2.setText("");
                  InputtedCityName.setText("");
            
}
catch (Throwable exception) {
        JOptionPane.showMessageDialog(null, "The problem is " + exception.getMessage(), "Reset Button Error Message", JOptionPane.ERROR_MESSAGE);
                     }
 
}

});

}
}