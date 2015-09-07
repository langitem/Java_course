import javax.swing.*;       // import entire Swing GUI Components Package           
import java.awt.*;      // import entire Abstract Windowing Toolkit Package
import java.awt.event.*;
/**
 * Class representing a Message Panel for the application's UI.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class MessagePanel {

    JPanel messagePanel;
    JLabel messageLabel;
    
   /**
    * Constructor for an instance of a MessagePanel object. 
    * @see      JPanel      
    * @see      JLabel
    */
    public MessagePanel() {
        messagePanel = new JPanel();
        messageLabel = new JLabel("Please complete all fields!");
        messagePanel.add(messageLabel);
    }

   /**
    * Returns the panel to another class. 
    * @return   the messagePanel variable.
    * @see      JPanel      
    */
    public JPanel getPanel() {
        return messagePanel;
    }

   /**
    * Sets the label in the panel. 
    * @param    String   the new message to be displayed.
    * @see      String      
    */
    public void setLabel(String someText) {
        messageLabel.setText(someText);
    }
} 