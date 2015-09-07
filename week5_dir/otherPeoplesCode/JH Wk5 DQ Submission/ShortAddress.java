import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class ShortAddress {

protected String firstName;
protected String secondName;
protected String phoneNumber;

public ShortAddress(String fn, String sn, String phone){
         firstName = fn;
         secondName = sn;
         phoneNumber = phone;
}

public void printShortAddressDetails(){

        JFrame frameshort = new JFrame();
        JOptionPane.showMessageDialog(frameshort, "Name: " + firstName + " " + secondName + "\nPhone Number: " + phoneNumber, "Short Form Of Address Details:", JOptionPane.PLAIN_MESSAGE);
         
         
}
}