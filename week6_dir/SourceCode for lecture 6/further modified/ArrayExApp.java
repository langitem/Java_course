//Array example test Application
//Dr. Y. Jing
//7 December 2007
//The University of Liverpool, UK
import java.io.*;
class ArrayExApp{
// --- Fields ---
// Create BufferedReader class instance
public static BufferedReader keyboardInput = new
	BufferedReader(new InputStreamReader(System.in));
// --- Methods ---
// --- Main method ---
public static void main (String[] args) throws IOException{
	int arraySize;
	// Input value for upper bound and then create instance of arrayEx class
	System.out.println("Input array length");
	arraySize = new Integer(keyboardInput.readLine()).intValue();
	ArrayEx newArray = new ArrayEx(arraySize);
	// Input for set
	newArray.inputArray();
	// Output values for set
	newArray.outputArray();
	}
}


