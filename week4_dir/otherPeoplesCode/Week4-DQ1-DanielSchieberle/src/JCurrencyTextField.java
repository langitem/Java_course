// JCurrencyTextField.java
// Extends the default JTextField and limits user input to numbers (incl. locale specific separator) and commits valid input immediately
// Author: Daniel Schieberle
// Last Update: July 27th 2013

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

//Class declaration
public class JCurrencyTextField extends JTextField {
	
	private ArrayList<ActionListener> actionListenerList;
	private Double value;
	private DecimalFormat decimalFormat;
	private DecimalFormatSymbols symbols;
	
	// Constructor
	public JCurrencyTextField(int columns) {
		this(columns,null);
	} // end of constructor
	
	// Overloaded constructor to force input Locale and change the decimal-separator accepted for input
	public JCurrencyTextField(int columns, Locale forceLocale) {
		super();
		setColumns(columns);
		
		decimalFormat = (DecimalFormat) DecimalFormat.getInstance(forceLocale == null ? getLocale() : forceLocale);
		symbols=decimalFormat.getDecimalFormatSymbols();
		
		// adding a listener to keyboard events
		addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		      char c = e.getKeyChar();
		      
		      //check if a separator is already present 
		      if (getText().indexOf(symbols.getDecimalSeparator()) > 0) {
		    	  // check if 2 fraction digits are already present
		    	  if (getText().matches("^.*\\d\\d$")) {
		    		  	// beep
				        getToolkit().beep();
				        // "eat up" the event
				        e.consume();
		    	  } else
		    		  // check if separartor is already present and typed in again to avoid "0..0"
		    		  if ((getText().matches("^.*\\"+symbols.getDecimalSeparator()+"$") && (c == symbols.getDecimalSeparator()))) {
				        getToolkit().beep();
				        e.consume();				    		  
		    		  }
		      } 
		      
		      //Otherwise only allow numbers, back-space and delete key as valid input
		      if (!(
		    		  (c >= '0') && (c <= '9') ||
		    		  (c == symbols.getDecimalSeparator()) ||
		    		  (c == KeyEvent.VK_BACK_SPACE) ||
		    		  (c == KeyEvent.VK_DELETE)
		    		)) {
			        	getToolkit().beep();
			        	e.consume();
		      		} 
		    }
		  });	
		
		// add a listener to the textfield's document to monitor for immediate changes
		getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				commitEdit();
			}
			public void removeUpdate(DocumentEvent e) {
				commitEdit();						
			}

			public void changedUpdate(DocumentEvent e) {
				commitEdit();	
			}			
		}
	);			
		
	} // end of constructor
	
	// method to reset the field
	public void reset() {
		this.value = null;
		setText("");
	} // end of method reset
	
	// Getter
	public Double getDoubleValue() {
		return this.value;
	}  	// end of method getDoubleValue
	

	// Private method to commit changes, parses user input to Double
	private void commitEdit() {
		try {
			value = new Double((decimalFormat.parse(getText()).doubleValue()));				
		} catch (ParseException e) {
			value = null;
		}
		// notify all listeners about the change
		notifyListeners(new ActionEvent(this,ActionEvent.ACTION_PERFORMED ,"VALUE_CHANGED"));		
	} // end of method commitEdit
	
	// helper method to register a listener 
	// since Swing is not thread-safe, method needs to be "synchronized"
    public synchronized void addActionListener(ActionListener listener) {
    	// create ArrayList if empty
    	if(actionListenerList == null) {  
    	     actionListenerList = new ArrayList<ActionListener>();  
	    }  
    	// only add if listener is not already registered
	    if(!actionListenerList.contains(listener)) {  
	             actionListenerList.add(listener);  
	    }  
	} // end of method addActionListener
    
	// helper method to unregister a listener 
    public synchronized void removeActionListener(ActionListener listener) {  
        if(actionListenerList != null && actionListenerList.contains(listener)) {  
    	     actionListenerList.remove(listener);  
	    }  
	}  // end of method removeActionListener

	// helper method to notify listeners    
	private void notifyListeners(ActionEvent e) {  
	    ArrayList<ActionListener> list;
	    // since swing is not thread safe, get a synchronized copy of the listeners first.
	    synchronized(this) {  
	             if(actionListenerList == null) return;  
	             list = new ArrayList<ActionListener>(actionListenerList); 
	    }  
	    // work on the synchronized copy
	    // the method actionPerformed is mandatory for all objects 
	    for(int i = 0; i < list.size(); i++) {  
	             ActionListener listener = (ActionListener)list.get(i);  
	             listener.actionPerformed(e);  
	     }  
	} // end of method notifyListeners

	
} // end of class
