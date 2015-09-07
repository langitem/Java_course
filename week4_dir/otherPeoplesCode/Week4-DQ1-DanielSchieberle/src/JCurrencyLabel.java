// JCurrencyLabel.java
// Extends the default JLabel and allows to display a BigDecimal value formatted as a currency
// Author: Daniel Schieberle
// Last Update: July 27th 2013

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

import javax.swing.JLabel;

// class declaration
public class JCurrencyLabel extends JLabel {
	
		private NumberFormat currencyFormatter;
		private BigDecimal value = null;
	
		// Constructor
		public JCurrencyLabel(int horizontalAlignment) {
			super("",horizontalAlignment);
		} // end of constructor
					
		// getter
		public BigDecimal getValue() {
			return this.value;
		} // end of method getValue
		
		// setter 
		public void setValue(BigDecimal value, Currency currency) {
			this.setValue(value,currency,null);
		} // end of method setValue(value,currency)
		
		// overloaded setter 
		// In case a Locale is given, the currency will not only but displayed as such but also in the Locale specific format
		public void setValue(BigDecimal value, Currency currency, Locale formattingLocale) {
			if (value != null) {
				this.value = value;
				if (formattingLocale != null) {
					setLocale(formattingLocale);
				}
				currencyFormatter = NumberFormat.getCurrencyInstance(getLocale());
				currencyFormatter.setCurrency(currency);
				setText(currencyFormatter.format(value));
			} else {
				setText("");
			}
		} // end of method setValue()
		
		// Method to reset the label
		public void reset() {
			setValue(null,null);
		} // end of method reset
		
} // end of class
