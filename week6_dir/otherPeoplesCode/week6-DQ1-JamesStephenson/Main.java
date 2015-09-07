/**
 * Class from which to run the program.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		int size = 12;//the size of the array
		ArrayWrapper aw = new ArrayWrapper(size);//initialise the array and populate with random numbers 
		aw.printAllNumbers();
		aw.printEvenNumbers();
		aw.printOddNumbers();
	}
}