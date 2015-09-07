/**
 * Class representing a number (integer).
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class NumberWrapper {

    private int number;
    
   /**
    * Overloaded constructor for an instance of a NumberWrapper object.
    * @param    aNumber         the integer.
    * @see      int
    */
	public NumberWrapper(int aNumber) {
		number = aNumber;
    }

   /**
    * Check whether the number is an even number.
    * @return            true if the remainder of the modulus operation (%) is 0, false if not.
    * @see      boolean
    */
    public boolean isEvenNumber() {
    	if(number % 2 == 0) {//modulus operation
    	 return true;
        }
        return false;
    } 

   /**
    * Check whether the number is an odd number.
    * @return            true if the remainder of the modulus operation (%) is greater than 0, false if not.
    * @see      boolean
    */
    public boolean isOddNumber() {
    	if(number % 2 > 0) {//modulus operation
    	    return true;
    	}
    	return false;
    } 
    
   /**
    * Gets the number as an integer.
    * @return            the number as an integer.
    * @see      int
    */
    public int getNumber() {
        return number;
    }

   /**
    * Gets the number as a String.
    * @return           the number as a String.
    * @see      String
    */
    public String toString() {
        return number + "";
    }
}