import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FullAddress extends ShortAddress{

private int houseNumber;
private String street1Name;
private String street2Name;
private String cityName;

public FullAddress (String fn, String sn, String phone, int streetN, String street1, String street2, String cityN){
          super(fn, sn, phone);
          houseNumber = streetN;
          street1Name = street1; 
          street2Name = street2;
          cityName = cityN;
}
public void printFullAddressDetails(){

        JFrame fullframe = new JFrame();
        JOptionPane.showMessageDialog(fullframe, "Name: " + firstName + " " + secondName + "\nPhone Number: " + phoneNumber + "\nAddress: " + houseNumber + " " + street1Name + " " + street2Name + "\nTown / City: " + cityName + ".", "Full Address Details Entered:", JOptionPane.PLAIN_MESSAGE);
        
}
}
