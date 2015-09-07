//USE OF ARRAY LENGTH EXAMPLE
//Dr. Y. Jing
//7 December 2007
//The University of Liverpool, UK

import java.io.*;

public class ArrayEx{
	//-------FIELDS-------
	final int length = 5;
	final int lowerBound = 0;
	int[] intArray = {1, 1, 2, 3, 5};

	//-------METHODS-------
	/*Output method*/
	public void outputArray(){
		int index = lowerBound;
		//Output
		System.out.print("intArray = {" + intArray[0]);
		while(index < length){
			System.out.print(", " + intArray[index]);
			index++;
		}
		//End
		System.out.println("}\n");
	}
}


