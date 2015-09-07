import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class DollarAmountTest {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		Dollar myDollar = new Dollar();
		BigDecimal dollarAmount;
		System.out.println("Enter a dollar amount:");
		dollarAmount = input.nextBigDecimal();
		
		myDollar.setDollarAmount(dollarAmount);
		
		BigDecimal gbAmount = myDollar.getGbpAmount();
		//String gbAmountString = gbAmount.setScale(2).toPlainString();
		gbAmount = gbAmount.setScale(2, RoundingMode.HALF_UP);
		System.out.println(gbAmount);
		//System.out.println(gbAmount.toPlainString());

	}

}
