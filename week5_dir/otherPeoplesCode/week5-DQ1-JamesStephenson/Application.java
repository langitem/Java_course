import javax.swing.*;		// import entire Swing GUI Components Package			
import java.awt.*;		// import entire Abstract Windowing Toolkit Package
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


/**
 * Class representing an application.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class Application {

    private final String APPLICATION_TITLE = "Address Entry Form";
    private final String DISPLAY_SHORT_ADDRESS_TITLE = "The Address in short form";
    private final String DISPLAY_FULL_ADDRESS_TITLE = "The Address in full form";
    private final String EMPTY_STRING = "";
  
  
    private JFrame theFrame;
    private InputPanel inputPanel;//the address form
    private OptionPanel optionPanel;//the buttons
    private MessagePanel messagePanel;//the on-screen messages
    private FullAddress fullAddress;

   /**
	* Constructor for an instance of an Application object. 
	*/
	public Application(){
        messagePanel = new MessagePanel();
        inputPanel = new InputPanel();
        optionPanel = new OptionPanel(new ShortAddressButtonListener(), new FullAddressButtonListener(), new ResetButtonListener());
	}

   /**
    * Runs the application.
    * @see JFrame
    */
    public void run() {
        theFrame = new JFrame();
        theFrame.getContentPane().add(messagePanel.getPanel(), BorderLayout.PAGE_START);
        theFrame.getContentPane().add(inputPanel.getPanel(), BorderLayout.CENTER);
        theFrame.getContentPane().add(optionPanel.getPanel(), BorderLayout.PAGE_END);//position at the bottom of the JFrame
        theFrame.setSize(new Dimension(500,500));
        theFrame.setVisible(true);
        theFrame.setTitle(APPLICATION_TITLE);
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }   

   /**
    * Determines whether the user's input is valid. 
    * @return   boolean      true if the input is valid or false if not.     
    * @see      boolean
    * @see      Iterator
    * @see      Map 
    * @see      Entry 
    * @see      String
    * @see      JTextField     
    */ 
    private boolean validate() {
        boolean isValid = false;
        fullAddress = new FullAddress();
        Iterator i = inputPanel.getInputFields();
        while(i.hasNext())
        {
            Map.Entry entry = (Map.Entry) i.next();
            String key = (String)entry.getKey();
            JTextField textField = (JTextField)entry.getValue();
            if(key==AddressKeys.HOUSE_NUMBER_KEY) {
                isValid = validateHouseNumberField(textField);
            } else {
                isValid = validateField(textField, key);
            }
            if(isValid == false) {
                    return false;
            }
        }
        return isValid;
    }

   /**
    * Validates an integer value of the House Number JTextField. 
    * @param    field        the JTextField to be validated.
    * @return   boolean      true if the field validates or false if not.    
    * @see      boolean
    * @see      Integer
    * @see      NumberFormatException  
    */ 
    private boolean validateHouseNumberField(JTextField field) {
        try {
            int houseNumber = Integer.parseInt(field.getText());
            fullAddress.setHouseNumber(houseNumber);
            return true;
        } catch (NumberFormatException e) {
            messagePanel.setLabel("House number is not a valid integer! Try again...");
            return false;    
        }
    }

   /**
    * Validates a String value of a JTextField. 
    * @param    field        the JTextField to be validated.
    * @param    aKey         the key from the Hashmap containing the JTextField.
    * @return   boolean      true if the field validates or false if not.    
    * @see      boolean
    * @see      String
    */ 
    private boolean validateField(JTextField field, String aKey) {
        String value = field.getText();
        if(value.equals("")) {
            messagePanel.setLabel(aKey + " is empty! Try again...");
            return false;
        } else {
            if(aKey == AddressKeys.FIRST_NAME_KEY) {
                fullAddress.setFirstName(value);
            } else if(aKey == AddressKeys.SECOND_NAME_KEY) {
                fullAddress.setSecondName(value);
            } else if(aKey == AddressKeys.PHONE_NUMBER_KEY) {
                fullAddress.setPhoneNumber(value);
            } else if(aKey == AddressKeys.STREET1_NAME_KEY) {
                fullAddress.setStreet1Name(value);
            } else if(aKey == AddressKeys.STREET2_NAME_KEY) {
                fullAddress.setStreet2Name(value);
            } else if(aKey == AddressKeys.CITY_NAME_KEY) {
                fullAddress.setCityName(value);
            }
            return true;    
        }
    }
    

    /**
    * Inner class using an interface to listen for UI events associated with the 'Short Address' button.
    * @see      ActionListener 
    * @see      JOptionPane
    */ 
    class ShortAddressButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(validate()) {
                JOptionPane.showMessageDialog(null, fullAddress.toParentString(), DISPLAY_SHORT_ADDRESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
                messagePanel.setLabel("Please complete all fields!");
            }
        }
    }

   /**
    * Inner class using an interface to listen for UI events associated with the 'Full Address' button.
    * @see      ActionListener 
    * @see      JOptionPane
    */ 
    class FullAddressButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if(validate()) {
                JOptionPane.showMessageDialog(null, fullAddress.toString(), DISPLAY_FULL_ADDRESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
                messagePanel.setLabel("Please complete all fields!");
            }
        }
    }

   /**
    * Inner class using an interface to listen for UI events associated with the 'Reset' button.
    * @see      ActionListener 
    * @see      dispose()
    */ 
    class ResetButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            inputPanel.resetPanel();
            messagePanel.setLabel("Please complete all fields!");
        }
    }
}