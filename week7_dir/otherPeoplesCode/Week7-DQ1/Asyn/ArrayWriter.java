// Fig. 26.6: ArrayWriter.java
// Adds integers to an array shared with other Runnables
import java.lang.Runnable;

public class ArrayWriter implements Runnable
{
	private final SimpleArray sharedSimpleArray;
	private final int startValue;

	public ArrayWriter( int value, SimpleArray array )
	{
		startValue = value;
		sharedSimpleArray = array;
	} // end constructor%s wrote %2d to elemen
	public void run()
	{
		for ( int i = startValue; i < startValue + 3; i++ )
		{
			char c;
			c = (char)i;
			//System.out.printf("char = %s, integer = %d\n", Character.toString(c), i);
			//System.out.printf( "%s wrote %2d to element %d.\n", Thread.currentThread().getName(), value, position );

			sharedSimpleArray.add(c); // add an element to the shared array
		} // end for
	} // end method run

} // end class ArrayWriter
