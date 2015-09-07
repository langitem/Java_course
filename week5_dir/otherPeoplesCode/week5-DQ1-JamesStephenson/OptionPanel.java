import javax.swing.*;       // import entire Swing GUI Components Package           
import java.awt.*;      // import entire Abstract Windowing Toolkit Package
import java.awt.event.*;
/**
 * Class representing an Option Panel for the application's UI.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class OptionPanel {

    JPanel optionPanel;
    
   /**
    * Constructor for an instance of an OptionPanel object. 
    * @param    a    the ActionListener for the first button.
    * @param    b    the ActionListener for the second button.
    * @param    c    the ActionListener for the third button.
    * @see      ActionListener
    * @see      JPanel      
    */
    public OptionPanel(ActionListener a, ActionListener b, ActionListener c) {
        optionPanel = new JPanel();
        addButtonsToPanel(a, b, c);
    }

   /**
    * Returns the panel to another class. 
    * @return   the optionPanel variable.
    * @see      JPanel      
    */
    public JPanel getPanel() {
        return optionPanel;
    }

   /**
    * Adds the two display buttons and a reset button to the panel. 
    * @param    a    the ActionListener for the first button.
    * @param    b    the ActionListener for the second button.
    * @param    c    the ActionListener for the third button.
    * @see      ActionListener      
    */
    public void addButtonsToPanel(ActionListener a, ActionListener b, ActionListener c) {
        optionPanel.add(createButton("Display Short Address",a));
        optionPanel.add(createButton("Display Full Address",b));
        optionPanel.add(createButton("Reset",c));
    }

   /**
    * A generic method to create a single button. 
    * @param    title       the text on the button.
    * @param    listener    the ActionListener to be assigned to the button.
    * @see      String      
    * @see      ActionListener      
    * @see      JButton      
    */ 
    public JButton createButton(String title, ActionListener listener) {
        JButton aButton = new JButton(title);
        aButton.addActionListener(listener);
        return aButton;
    }    
} 