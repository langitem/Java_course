/**
 * Class from which to run the application.
 *  
 * @author James Stephenson
 * @version 1.0
 */
public class Main {

	public static void main(String[] args) {
		try {
			Calculator theCalculator = new Calculator();//initialise the calculator
			theCalculator.run();
			System.exit(0);//exit the program
		} catch (Throwable t) {
            System.err.println("Error in class: " + t.getMessage());
        }
	}
}