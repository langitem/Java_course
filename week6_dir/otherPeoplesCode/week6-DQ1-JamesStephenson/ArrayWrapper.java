/**
 * Class representing a wrapper around an array of integers.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class ArrayWrapper {

    private NumberWrapper[] numbers;
    public final int MULTIPLIER = 100;//for multiplying a double value between 0 and 1

   /**
    * Overloaded constructor for an instance of an ArrayWrapper object.
    * @param    aSize         the desired size of the array.
    * @see      int
    */
	public ArrayWrapper(int aSize) {
		numbers = new NumberWrapper[aSize];
	    populateArray();
    }

   /**
    * Populates the array with random numbers.
    * @return            the integer.
    * @see      int
    */
    public void populateArray() {
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = new NumberWrapper(generateRandomNumber());
        }
    }

   /**
    * Generates a random double number, gets the smallest double number that is (a) equal to/greater than aRandomNumber and (b) equal to an integer and returns it as an integer.
    * @return            the integer.
    * @see      double
    * @see      int
    */
    public int generateRandomNumber() {
        double aRandomNumber = Math.random() * MULTIPLIER;//returns a random double number
        return (int)(Math.ceil(aRandomNumber)); 
    }

   /**
    * Prints all the numbers.
    * @see      int
    */
    public void printAllNumbers() {
    	System.out.println("All Numbers: ");
    	for(int i = 0; i < numbers.length; i++) {
    		System.out.print(numbers[i] + " ");
    	}
    	System.out.println("\n");
    } 

   /**
    * Prints all the even numbers.
    * @see      int
    */
    public void printEvenNumbers() {
    	System.out.println("Even Numbers: ");
    	for(int i = 0; i < numbers.length; i++) {
    		if(numbers[i].isEvenNumber()) {
    			System.out.print(numbers[i] + " ");
    		}
    	}
    	System.out.println("\n");
    } 

   /**
    * Prints all the odd numbers.
    * @see      int
    */
    public void printOddNumbers() {
    	System.out.println("Odd Numbers: ");
    	for(int i = 0; i < numbers.length; i++) {
    		if(numbers[i].isOddNumber()) {
    			System.out.print(numbers[i] + " ");
    		}
    	}
    	System.out.println("\n");
    } 

}