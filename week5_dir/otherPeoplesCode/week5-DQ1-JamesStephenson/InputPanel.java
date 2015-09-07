import javax.swing.*;       // import entire Swing GUI Components Package           
import java.awt.*;      // import entire Abstract Windowing Toolkit Package
import java.awt.event.*;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class representing an Input Panel for the application's UI.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class InputPanel {

    private JPanel inputPanel;
    Map<String,JTextField> inputFields = new HashMap<String, JTextField>(); 
    private ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private final String EMPTY_STRING = "";
   

   /**
    * Constructor for an instance of an InputPanel object. 
    * @see JPanel
    */
    public InputPanel() {
        inputPanel = new JPanel();
        addInputFieldsToPanel();
    }

   /**
    * Returns the panel to another class. 
    * @return   the inputPanel variable.
    * @see      JPanel      
    */
    public JPanel getPanel() {
        return inputPanel;
    }

   /**
    * Resets all the JTextFields in the panel. 
    * @see      Map
    * @see      Entry
    * @see      JTextField
    * @see      String      
    */
    public void resetPanel() {
        for (Map.Entry<String, JTextField> entry : inputFields.entrySet()) {//loop through the HashMap
            (entry.getValue()).setText(EMPTY_STRING);//get the JTextField and set it to empty
        }
    }

   /**
    * Gets an iterator for the HashMap of input fields.
    * @return   the iterator for the HashMap containing the input fields.  
    * @see      Iterator
    * @see      Map
    * @see      Entry
    * @see      String
    * @see      JTextField     
    */
    public Iterator getInputFields() {
        Iterator<Map.Entry<String, JTextField>> entries = inputFields.entrySet().iterator();
        return entries;
    }

   /**
    * Adds the input fields to the panel with a GridBagLayout. 
    * @see      GridBagLayout
    * @see      JTextField
    * @see      String      
    */
    public void addInputFieldsToPanel() {
        GridBagLayout gridbag = new GridBagLayout();
        inputPanel.setLayout(gridbag);
        createInputField("First Name:",AddressKeys.FIRST_NAME_KEY,25); 
        createInputField("Second Name:",AddressKeys.SECOND_NAME_KEY,50); 
        createInputField("Phone Number:",AddressKeys.PHONE_NUMBER_KEY,25); 
        createInputField("House Number:",AddressKeys.HOUSE_NUMBER_KEY,3); 
        createInputField("Street (1):",AddressKeys.STREET1_NAME_KEY,50); 
        createInputField("Street (2):",AddressKeys.STREET2_NAME_KEY,50); 
        createInputField("City:",AddressKeys.CITY_NAME_KEY,50);        
        addLabelTextRows(gridbag);
    }

   /**
    * A generic method to create a single JTextField instance, add it to the panel and store it and its label in a HashMap and ArrayList respectively.  
    * @param    theLabel       the label for the JTextField.
    * @param    addressKey     the key in the HashMap where the JTextField will be stored.
    * @param    numColumns     the number of columns used to calculate the preferred width.      
    * @see      String      
    * @see      JTextField
    * @see      JLabel      
    */ 
    public void createInputField(String theLabel, String addressKey, int numColumns) {
        JTextField aField = new JTextField(numColumns);
        JLabel aLabel = new JLabel(theLabel);
        inputFields.put(addressKey,aField);
        labels.add(aLabel);
    }

   /**
    * Applies a GridBagLayout to the panel and adds the labels and text fields.  
    * @see      GridBagLayout      
    * @see      GridBagConstraints
    */ 
    private void addLabelTextRows(GridBagLayout gridbag) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        for (int i = 0; i < labels.size(); i++) {
            constraints.gridwidth = GridBagConstraints.RELATIVE; 
            constraints.fill = GridBagConstraints.NONE;     
            constraints.weightx = 0.0;                     
            inputPanel.add(labels.get(i), constraints); 
            constraints.gridwidth = GridBagConstraints.REMAINDER;     
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.weightx = 1.0;
            inputPanel.add(inputFields.get(AddressKeys.ADDRESS_KEYS[i]), constraints);
        }
    }
    
   /**
    * A generic method to return the value from a specific JTextField in the HashMap. 
    * @param    key                                  the key for the HashMap to access the right JTextField.     
    * @return   the text value in the JTextField.               
    * @see      String      
    */
    public String getInputFieldText(String key) {
        return (inputFields.get(key)).getText();    
    }
} 