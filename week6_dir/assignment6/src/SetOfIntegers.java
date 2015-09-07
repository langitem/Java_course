// Emanuel Langit
// emanuel.langit@my.ohecampus.com
// CKIT-510
// SetOfIntegers.java
// Set of Integers class for assignment 6
// Week 6 Assignment
// August 14, 2013

public class SetOfIntegers {
	private static final int ARRAY_LENGTH = 10;
	int[] intArray = new int[ARRAY_LENGTH];
	
	// no argument constructor
	public SetOfIntegers() {
		intArray = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
	}
	
	// constructor with arguments
	public SetOfIntegers(int num0, int num1, int num2, int num3, int num4, int num5, 
							int num6, int num7, int num8, int num9) {

		intArray = new int[] {num0, num1, num2, num3, num4, num5, num6, num7, num8, num9 };
	} // end constructor
	
	
	public int[] bubbleSortArray() {
		boolean changed = true;
		while (changed) {
			changed = false;
			for (int i = 1; i <= intArray.length - 1; i++) {
				if (intArray[i] < intArray[i-1]) {
					// swap:
					int tmp = intArray[i];
					intArray[i] = intArray[i-1];
					intArray[i-1] = tmp;
					changed = true;
				}
			} // end of for loop
		} // end of while loop
		
		return intArray;
	} // end of bubbleSortArray method

}
