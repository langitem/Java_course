// CurrencyConverter.java
// Class to deal with currencies and conversion rates
// Author: Daniel Schieberle
// Last Update: July 27th 2013

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

// class declaration
public class CurrencyConverter {
	
	
	private HashMap<Currency, HashMap <Currency,BigDecimal>> conversionRates;
	private HashMap<Currency, Locale> outputFormatting;
	
	// using "bankers' rounding"
	private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_EVEN;
	// BigDecimal takes calculations very "seriously"
	// for instance 1/3 raises an exception as the result is infinite 0.33333....
	// For currencies 2 fraction digits is "enough"
	private static int DECIMALS = 2;

	
	// constructor
	public CurrencyConverter(Currency from, Currency to, BigDecimal conversionRate) {
		setConversionRate(from,to,conversionRate);
		outputFormatting = null;
	} // end of constructor
	
	// overloaded constructor
	// since Java does not allow to determine the Locale from the Currency object (EUR could be Germany, France, Spain, Italy, etc....)
	// the overloaded constructor takes Locale object as arguments, derives the Currency from it
	// and stores the association for future reference
	public CurrencyConverter(Locale from, Locale to, BigDecimal conversionRate) {
		this(Currency.getInstance(from),Currency.getInstance(to),conversionRate);
		outputFormatting = new HashMap<Currency, Locale>();
		outputFormatting.put(Currency.getInstance(from), from);
		outputFormatting.put(Currency.getInstance(to), to);		
	} // end of overleaded constructor	
	
	// Method to return all currencies "stored" in the object (for comboboxes)
	public Set<Currency> getAvailableCurrencies() {
			return conversionRates.keySet();

	} // end of method getAvailableCurrencies
	
	// method to set the conversion rate for a given Currency pair.
	public void setConversionRate(Currency from, Currency to, BigDecimal conversionRate) {
		// quick check whether conversionRate is not null or 0
		if ((conversionRate != null) && (conversionRate != BigDecimal.ZERO)) {
			// store conversion rate in Hash
			storeConversionRate(from, to, conversionRate);
			// store vice-versa conversion
			storeConversionRate(to, from, new BigDecimal(1).divide(conversionRate,DECIMALS,ROUNDING_MODE));
			// store 1 to 1 conversion to allow "switching" through the comboboxes 
			storeConversionRate(from, from, BigDecimal.ONE);			
			storeConversionRate(to, to, BigDecimal.ONE);			
		}
	} // end of method setConversionRate
	
	// private method to store a conversion pair in the Hash
	private void storeConversionRate(Currency from, Currency to, BigDecimal conversionRate) {
		// initialize Hash if empty
		if (conversionRates == null) {
			conversionRates = new HashMap<Currency, HashMap<Currency, BigDecimal>>();
		}
		// since the hash is a "hash of hashes" initialize the 2nd level hash as well
		if (conversionRates.get(from) == null) {
			conversionRates.put(from, new HashMap<Currency,BigDecimal>());			
		}
		conversionRates.get(from).put(to, conversionRate);
	} // end of method storeConversionRate
	
	// method to perform a conversion
	public BigDecimal convert(Currency from, Currency to, BigDecimal amount) {
		if (amount == null) {return null;}
		return amount.divide(conversionRates.get(from).get(to),DECIMALS,ROUNDING_MODE);
	} // end of method convert
	
	// method to get a Locale object associated to a currency (to optionally localize formatting)
	public Locale getLocaleCurrencyFormatting(Currency currency) {
		if (outputFormatting == null) {return null;}
		return outputFormatting.get(currency);
	} // end of method getLocaleCurrencyFormatting
}
