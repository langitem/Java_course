import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections; 
import java.text.DecimalFormat;
/**
 * Class representing a calculator.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class Calculator {

   private final String FIRST_MESSAGE = "Enter a number (to two decimal places)";
   private final String SUBSEQUENT_MESSAGE = "Enter another number (to two decimal places)";
   private ArrayList<Double> inputValues;//a collection to store the double values entered by the user.
   private DecimalFormat formatter = new DecimalFormat("0.00");
        
   /**
	* Overloaded constructor for an instance of a Calculator object. It initialises the size of 
	*/
	public Calculator() {
		inputValues = new ArrayList<Double>(2); 
	}

   /**
	* Runs the calculator. 
	*/
	public void run() {
		setInputValue(Double.parseDouble(getInputFromUser()),inputValues.size()); 
		setInputValue(Double.parseDouble(getInputFromUser()),inputValues.size()); 
		displayGreatestInputValue();   
    }

   /**
	* Returns a String representing the double number selected by the user. 
	* @return		the double nuimber selected by the user.
	* @see       	JOptionPane
	* @see       	String
	*/
	public String getInputFromUser() {
  		Object[] doubleNumbers = new String[10000];
		for(int i=0;i<10000;i++) {//this loop produces double numbers from 0.01 to 100.00
			Double aDouble = ((i+1d)/100d);
			doubleNumbers[i] = formatter.format(aDouble);//format to two decimal places
		}
		String theMessage = (getGreatestInputValue() == 0d) ? FIRST_MESSAGE : SUBSEQUENT_MESSAGE;
		String aDoubleNumber = (String)JOptionPane.showInputDialog(null, theMessage, "Input", JOptionPane.INFORMATION_MESSAGE, null, doubleNumbers, "50.00");
		if(aDoubleNumber == null || aDoubleNumber.isEmpty()) {
			aDoubleNumber = getInputFromUser(); //recursively call this function until the user selects a double number
		} 
		return aDoubleNumber;
	}

   /**
	* Sets an element in the ArrayList with the entered double number. 
	* @param  double  the entered double number.
	* @param  int     the index in the ArrayList to store the double number.
	*/ 
    public void setInputValue(double input, int index) {
    	inputValues.add(index, input);
	}

   /**
	* Returns the greatest value entered by the user. 
	* @return		the greatest double number entered by the user.
	* @see       	ArrayList
	* @see       	Collections
	* @see       	double
	*/
	public double getGreatestInputValue() {
		if(inputValues.isEmpty()) {//nothing has been entered yet
			return 0;
		}
		if(inputValues.size() < 2 && inputValues.size() > 0) {//one number has been entered so far, so return it
			return inputValues.get(0);
		}
		ArrayList<Double> clonedInputValues = inputValues;//clone the ArrayList, in case we need it in its original state in future.  
		Collections.sort(clonedInputValues);//sort the double numbers in the ArrayList from lowest to highest.
		return clonedInputValues.get(inputValues.size()-1);//return the double number at the end of the ArrayList. 
	}

   /*
	* Display the greatest value selected by the user. 
    * @see      JOptionPane
    */ 
    public void displayGreatestInputValue() {
		String theMessage = "The greatest input value is " + formatter.format(getGreatestInputValue()); 
		JOptionPane.showMessageDialog(null, theMessage, "Result", JOptionPane.INFORMATION_MESSAGE);
	}
}