// SchieberleWeek4DQ1.java
// Class to implement Week 4's DQ1 logic
// Author: Daniel Schieberle
// Last Update: July 23th 2013

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

// class declaration
public class SchieberleWeek4DQ1 extends JFrame {
	
	private final static Border DEFAULT_BORDER = BorderFactory.createEmptyBorder(10,10,10,10);
	private final static String APP_TITLE = "Currency Converter";
	private final static Currency DEFAULT_FROM_CURRENCY = Currency.getInstance(Locale.US); 
	private final static Currency DEFAULT_TO_CURRENCY = Currency.getInstance(Locale.UK);
	private final static String INTRO = "Please enter a monetary value, conversion is performed as you type";
	private final static String RESULT = "Result:";	
	private final static String ERROR = "Please enter a valid monetary value";
	

	private JCurrencyTextField userInput;
	private JCurrencyLabel conversionResult;
	private CurrencyConverter currencyConverter;
	private JComboBox fromCurrency;
	private JComboBox toCurrency;
	private JLabel message;
	
	// Constructor
	public SchieberleWeek4DQ1() {
		// setting Title
		super(APP_TITLE);
		// setting default close behavior
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		

		//currencyConverter = new CurrencyConverter(DEFAULT_FROM_CURRENCY,DEFAULT_TO_CURRENCY,new BigDecimal(1.91));

		// initializing currency converter by Locales to allow locale-specific formatting	
    // BigDecimal is intentionally initialized as String, see intro doc for explanation	
		currencyConverter = new CurrencyConverter(Locale.US,Locale.UK,new BigDecimal("1.91"));		
		
		// setting up the GUI
		setupGUI();
		pack();
		setLocationRelativeTo(null);
	} // end of Constructor
	
	// Private method to setup up the GUI
	private final void setupGUI() {		
		
		JPanel input = new JPanel();
		input.setBorder(DEFAULT_BORDER);
		
		// Since I am German using "," as decimal separator, I am enforcing "." (Locale.US)
		// constructor without Locale (using VM's default locale) is also available, see: JCurrencyTextField.java
		userInput = new JCurrencyTextField(16,Locale.US);				
		input.add(userInput);
		
		fromCurrency = new JComboBox();
		fromCurrency.setEditable(false);
		// fill combobox with available currencies from converter object
		for (Currency key : currencyConverter.getAvailableCurrencies()) {
		    fromCurrency.addItem(key);
		}	
		fromCurrency.setSelectedItem(DEFAULT_FROM_CURRENCY);	
		fromCurrency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performConversion();
			}
			
		});		
		input.add(fromCurrency);
		
		JLabel to = new JLabel("to");
		input.add(to);
		
		toCurrency = new JComboBox();
		toCurrency.setEditable(false);
		for (Currency key : currencyConverter.getAvailableCurrencies()) {
		    toCurrency.addItem(key);
		}		
		toCurrency.setSelectedItem(DEFAULT_TO_CURRENCY);
		toCurrency.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performConversion();
			}
			
		});
		input.add(toCurrency);
		
		add(input,BorderLayout.NORTH);
		
		JPanel output = new JPanel(new GridLayout(2,1));
		output.setBorder(DEFAULT_BORDER);
		
		message = new JLabel(INTRO,JLabel.CENTER);
		output.add(message);

		conversionResult = new JCurrencyLabel(JLabel.CENTER);
		output.add(conversionResult,BorderLayout.CENTER);		
		
		add(output,BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(DEFAULT_BORDER);
		
		JButton reset = new JButton("Reset");
		
		reset.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				toCurrency.setSelectedItem(DEFAULT_TO_CURRENCY);
				fromCurrency.setSelectedItem(DEFAULT_FROM_CURRENCY);	
				conversionResult.reset();
				userInput.reset();
			}			
		});
		buttonPanel.add(reset);		
		
		JButton close = new JButton("Close");
		close.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}			
		});
		buttonPanel.add(close);			
		
		
		add(buttonPanel, BorderLayout.SOUTH);			
		
		userInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				performConversion();
			}			
		});		
		
		
	} // end of method setupGUI	
	
	// private method to perform conversion
	private void performConversion() {
		try {
			message.setText(RESULT);
			conversionResult.setValue(
					currencyConverter.convert(
									// Currency selected in the first combobox
									(Currency)fromCurrency.getSelectedItem(), 
									// Currency selected in the second combobox
									(Currency)toCurrency.getSelectedItem(), 
									// User input as Double, converted to BigDecimal
									// Big decimal is initialized "as is" (String) and not as Double directly to avoid rounding differences from floating point primitive types
									new BigDecimal(userInput.getDoubleValue().toString())
									),
					// Use currency from the second combobox for formatting
				    (Currency)toCurrency.getSelectedItem(),
				    // Check if a Currency/Locale pair is available to allow locale-specific currency formatting
					currencyConverter.getLocaleCurrencyFormatting((Currency)toCurrency.getSelectedItem())
				);
		} catch (NullPointerException e) {
			// focus input field
			userInput.grabFocus();
			// reset conversion display
			conversionResult.reset();
			// display "error message"
			message.setText(ERROR);
		}
	} // end of method performConversion
	
}
