// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// Dollar.java
// Dollar class for DQ1
// Week 4 DQ1
// July 29, 2013

import java.math.BigDecimal;

public class Dollar {
	
	BigDecimal dollarAmount;
	
	// no argument constructor
	public Dollar () {
		dollarAmount = new BigDecimal(0);
	}
	
	// constructor with argument
	public Dollar(BigDecimal amount) {
		dollarAmount = amount;
	}
	
	public void setDollarAmount(BigDecimal amount) {
		dollarAmount = amount;
	}

	public BigDecimal getDollarAmount() {
		return dollarAmount;
	}

	public BigDecimal getGbpAmount() {
		BigDecimal multiplicand = new BigDecimal(1.9);
		BigDecimal gbAmount = dollarAmount.multiply(multiplicand );
		return gbAmount;
	}

}
