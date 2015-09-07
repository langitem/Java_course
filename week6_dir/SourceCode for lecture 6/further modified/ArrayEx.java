//USE OF ARRAY LENGTH EXAMPLE
//Dr. Y. Jing
//7 December 2007
//The University of Liverpool, UK
import java.io.*;
public class ArrayEx{
	//-------FIELDS-------
	int length;
	final int lowerBound = 0;
	int[] intArray = {1, 1, 2, 3, 5};
	//Create BufferedReader class instance
	public static BufferedReader keyboardInput = new
			BufferedReader(new InputStreamReader(System.in));
	// --- Constructors ---
	public ArrayEx(int size){
		length = size;
		intArray = new int[length];
		}
	//-------METHODS-------
	/*Output method*/
	public void inputArray() throws IOException{
		int index = lowerBound;
		//Input
		System.out.println("Input" + length+"array elements");
		while(index < intArray.length){
			intArray[index]=new Integer(keyboardInput.readLine()).intValue();
			index++;
		}
	}
	public void outputArray(){
			int index = lowerBound;
			//Output
			System.out.print("intArray = {");
			while(index < intArray.length){
				System.out.print(intArray[index] + ", ");
				index++;
			}
			//End
			System.out.println("}\n");
	}
}


