// Fig. 26.8: SimpleArray.java
// Class that manages an char array to be shared by multiple threads.
import java.util.Arrays;
import java.util.Random;

public class SimpleArray 
{
private final char[] array; // the shared char array
private int writeIndex = 0; // index of next element to be written
private final static Random generator = new Random();

// construct a SimpleArray of a given size
public SimpleArray( int size )
{
	array = new char[ size ];
} // end constructor

// add a value to the shared array
	public synchronized void add( char value )
	{
		int position = writeIndex;
	
		try
		{
			// put thread to sleep for 0-499 milliseconds
			Thread.sleep( generator.nextInt( 500 ) );
		} // end try
		catch ( InterruptedException ex )
		{
			ex.printStackTrace();
		} // end catch

		//put value in the appropriate element
		array[position] = value;
		//System.out.printf( "%s wrote %s to element %d.\n", Thread.currentThread().getName(), value, position );
		System.out.printf( "%s wrote %s to element %d.\n", Thread.currentThread().getName(), Character.toString(value), position );

		++writeIndex;
		System.out.printf( "Next write index: %d\n", writeIndex );
	} // end method add

// used for outputting the contents of the shared integer array
	public String toString()
	{
		return "\nContents of SimpleArray:\n" + Arrays.toString( array );
	} // end method toString
} // end class SimpleArray